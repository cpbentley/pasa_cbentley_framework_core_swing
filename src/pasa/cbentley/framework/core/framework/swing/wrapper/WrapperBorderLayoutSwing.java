package pasa.cbentley.framework.core.framework.swing.wrapper;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pasa.cbentley.core.src4.ctx.ICtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.framework.src4.app.IAppli;
import pasa.cbentley.framework.core.framework.src4.app.ITechAppli;
import pasa.cbentley.framework.core.framework.src4.interfaces.ICreatorAppli;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.framework.swing.ctx.ITechStatorableCoreFrameworkSwing;
import pasa.cbentley.framework.core.framework.swing.engine.CoordinatorSwing;
import pasa.cbentley.framework.core.ui.src4.event.AppliEvent;
import pasa.cbentley.framework.core.ui.src4.event.BEvent;
import pasa.cbentley.framework.core.ui.src4.interfaces.ITechEventApp;
import pasa.cbentley.framework.core.ui.src4.interfaces.ITechEventHost;
import pasa.cbentley.framework.core.ui.src4.interfaces.IWrapperManager;
import pasa.cbentley.framework.core.ui.swing.ctx.CoreUiSwingCtx;
import pasa.cbentley.framework.core.ui.swing.engine.CanvasHostSwingAbstract;
import pasa.cbentley.framework.core.ui.swing.wrapper.WrapperAbstractSwing;
import pasa.cbentley.swing.window.CBentleyFrame;

/**
 * BorderLayout wrapper.
 * 
 * Top level or contained?
 * @author Charles Bentley
 *
 */
public class WrapperBorderLayoutSwing extends WrapperAbstractSwing implements ActionListener {

   private JButton               buttonPause;

   private JButton               buttonResume;

   private JButton               buttonStart;

   private JButton               buttonStop;

   private CBentleyFrame         frame;

   private JButton               imgIconButton;

   private JPanel                panel;

   private CoreFrameworkSwingCtx scc;

   private JLabel                titleLabel;

   public WrapperBorderLayoutSwing(CoreFrameworkSwingCtx scc) {
      super(scc.getCoreUiSwingCtx());
      this.scc = scc;
      frame = new CBentleyFrame(scc.getSwingCtx());
      panel = new JPanel();

      panel.setLayout(new BorderLayout());

      titleLabel = new JLabel();
      JPanel north = new JPanel();
      buttonStop = new JButton("Stop");
      buttonStop.addActionListener(this);
      buttonStart = new JButton("Start");
      buttonStart.addActionListener(this);
      buttonPause = new JButton("Pause");
      buttonPause.addActionListener(this);
      buttonResume = new JButton("Resume");
      buttonResume.addActionListener(this);
      north.add(buttonStop);
      north.add(buttonStart);
      north.add(buttonPause);
      north.add(buttonResume);

      imgIconButton = new JButton();
      north.add(imgIconButton);

      panel.add(north, BorderLayout.NORTH);

      JPanel south = new JPanel();
      JButton buttonSouth = new JButton("South");
      south.add(buttonSouth);
      panel.add(south, BorderLayout.SOUTH);

      JButton buttonEast = new JButton("East");

      JButton button1 = new JButton("One");
      JButton button2 = new JButton("Two");
      JButton button3 = new JButton("Three");
      JButton button4 = new JButton("Four");
      JButton button5 = new JButton("Five");
      JButton button6 = new JButton("Six");
      JButton button7 = new JButton("Seven");
      Box box = Box.createVerticalBox();
      box.add(buttonEast);
      box.add(button1);
      box.add(button2);
      box.add(button3);
      box.add(button4);
      box.add(button5);
      box.add(button6);
      box.add(button7);

      panel.add(box, BorderLayout.EAST);

      JPanel west = new JPanel();

      JButton buttonWest = new JButton("West");
      west.add(buttonWest);

      panel.add(west, BorderLayout.WEST);

      //we have buttons to show the ouput of std out of a single appli
      frame.getContentPane().add(panel);
   }

   /**
    * <li>
    */
   private void actionStart() {
      CoordinatorSwing coordinatorSwing = scc.getCoordinatorSwing();
      CoreUiSwingCtx cuc = coordinatorSwing.getCUCSwing();
      IAppli app = coordinatorSwing.getAppli();
      if (app != null) {
         cuc.publishMessageOnRoot("Application is already Started");
      } else {
         //when starting an appli, we need a fresh new UC
         //we need a new launcher object and a new CFC
         
         //do we need a creator ?
         ICreatorAppli creatorAppli = coordinatorSwing.getCreatorAppli();
         creatorAppli.createAppOnFramework(scc); //one time use

         //the launcher host decides which wrapper manager is used

         //we want to create it inside this wrapper. and not creating a new one.
      }
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == buttonStart) {
         this.actionStart();
      } else if (e.getSource() == buttonStop) {
         actionStop();
      } else if (e.getSource() == buttonPause) {
         actionPause();
      } else if (e.getSource() == buttonResume) {
         actionResume();
      }
   }

   private void actionResume() {
      CoordinatorSwing coordinatorSwing = scc.getCoordinatorSwing();
      IAppli app = coordinatorSwing.getAppli();
      if (app.getState() == ITechAppli.STATE_3_PAUSED) {
         coordinatorSwing.frameworkResume();
      } else {
         cuc.publishMessageOnRoot("Application is already Running");
      }
   }

   private void actionPause() {
      CoordinatorSwing coordinatorSwing = scc.getCoordinatorSwing();
      IAppli app = coordinatorSwing.getAppli();
      if (app.getState() == ITechAppli.STATE_2_STARTED) {
         coordinatorSwing.frameworkPause();
      } else {
         cuc.publishMessageOnRoot("Application is already Paused");
      }
   }

   private void actionStop() {
      CoordinatorSwing coordinatorSwing = scc.getCoordinatorSwing();
      coordinatorSwing.frameworkExit();
      Component realCanvas = canvas.getRealCanvas();
      //remove the canvas
      panel.remove(realCanvas);
      panel.repaint();
   }

   /**
    * 
    * 
    */
   public void addCanvas(CanvasHostSwingAbstract canvas) {
      Component cc = canvas.getRealCanvas();
      panel.add(cc, BorderLayout.CENTER);
   }

   public void canvasHide() {
      frame.setVisible(false);
   }

   /**
    * On its own it can't display itself. it needs a parent wrapper that can.
    * Well it can. At first nothing is shown. Press start to display it
    */
   public void canvasShow() {
      frame.pack();
      frame.setVisible(true);
   }

   /**
    * We have to override ctxowner because we subclass from coreui
    * @return
    */
   public ICtx getCtxOwner() {
      return scc;
   }

   public int getStatorableClassID() {
      return ITechStatorableCoreFrameworkSwing.CLASSID_1_WRAPPER_BORDER_LAYOUT;
   }

   public boolean isContained() {
      return true;
   }

   public void setDefaultStartPosition() {
      //#debug
      toDLog().pBridge("Before", this, WrapperBorderLayoutSwing.class, "setDefaultStartPosition@196", LVL_05_FINE, false);
      frame.setFramePositionCenter();

      //#debug
      toDLog().pBridge("After", frame, WrapperBorderLayoutSwing.class, "setDefaultStartPosition@196", LVL_05_FINE, false);

   }

   /**
    * Ask parent wrapper. we are just a panel actually
    */
   public void setFullScreenMode(boolean mode) {
      if (parent != null) {
         parent.setFullScreenMode(mode);
      }
   }

   public void setIcon(String str) {
      if (frame != null && str != null) {
         Image image = scc.getSwingCtx().createImage(str, "");
         frame.setIconImage(image);
         Icon ic = new ImageIcon(image);
         imgIconButton.setIcon(ic);
      }
   }

   public void setPosition(int x, int y) {
      if (parent != null) {
         parent.setPosition(x, y);
      }
   }

   public void setSize(int w, int h) {

   }

   public void setTitle(String str) {
      titleLabel.setText(str);
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, WrapperBorderLayoutSwing.class, 207);
      toStringPrivate(dc);
      super.toString(dc.sup());

      dc.nlLvl(frame, "frame");
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, WrapperBorderLayoutSwing.class, 207);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

}
