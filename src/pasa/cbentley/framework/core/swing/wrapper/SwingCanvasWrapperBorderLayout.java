package pasa.cbentley.framework.core.swing.wrapper;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pasa.cbentley.core.src4.ctx.ICtx;
import pasa.cbentley.framework.core.src4.app.ITechAppli;
import pasa.cbentley.framework.core.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.swing.ctx.ITechStatorableCoreFrameworkSwing;
import pasa.cbentley.framework.coreui.swing.engine.CanvasHostSwing;
import pasa.cbentley.framework.coreui.swing.wrapper.WrapperAbstractSwing;
import pasa.cbentley.swing.window.CBentleyFrame;

/**
 * BorderLayout wrapper.
 * 
 * Top level or contained?
 * @author Charles Bentley
 *
 */
public class SwingCanvasWrapperBorderLayout extends WrapperAbstractSwing implements ActionListener {

   private JPanel                p;

   private CBentleyFrame         frame;

   private JButton               buttonStop;

   private JButton               buttonStart;

   private JButton               buttonPause;

   private JLabel                titleLabel;

   private JButton               imgIconButton;

   private CoreFrameworkSwingCtx scc;

   public SwingCanvasWrapperBorderLayout(CoreFrameworkSwingCtx scc) {
      super(scc.getCoreUiSwingCtx());
      this.scc = scc;
      frame = new CBentleyFrame(scc.getSwingCtx());
      p = new JPanel();

      p.setLayout(new BorderLayout());

      titleLabel = new JLabel();
      imgIconButton = new JButton();
      JPanel north = new JPanel();
      buttonStop = new JButton("Stop");
      buttonStop.addActionListener(this);
      buttonStart = new JButton("Start");
      buttonStart.addActionListener(this);
      buttonPause = new JButton("Pause");
      buttonPause.addActionListener(this);
      north.add(buttonStop);
      north.add(buttonStart);
      north.add(buttonPause);

      p.add(north, BorderLayout.NORTH);

      JPanel south = new JPanel();
      JButton buttonSouth = new JButton("South");
      south.add(buttonSouth);
      p.add(south, BorderLayout.SOUTH);

      JPanel east = new JPanel();
      JButton buttonEast = new JButton("East");
      east.add(buttonEast);
      east.add(imgIconButton);
      p.add(east, BorderLayout.EAST);

      JPanel west = new JPanel();
      JButton buttonWest = new JButton("West");
      west.add(imgIconButton);
      west.add(buttonWest);

      p.add(west, BorderLayout.WEST);

      //we have buttons to show the ouput of std out of a single appli
      frame.getContentPane().add(p);
   }

   public int getStatorableClassID() {
      return ITechStatorableCoreFrameworkSwing.CLASSID_1_WRAPPER_BORDER_LAYOUT;
   }

   /**
    * We have to override ctxowner because we subclass from coreui
    * @return
    */
   public ICtx getCtxOwner() {
      return scc;
   }

   /**
    * Ask parent wrapper. we are just a panel actually
    */
   public void setFullScreenMode(boolean mode) {
      if (parent != null) {
         parent.setFullScreenMode(mode);
      }
   }

   /**
    * On its own it can't display itself. it needs a parent wrapper that can.
    * Well it can. At first nothing is shown. Press start to display it
    */
   public void canvasShow() {
      frame.pack();
      frame.setVisible(true);
   }

   public void canvasHide() {
      frame.setVisible(false);
   }

   public void addCanvas(CanvasHostSwing canvas) {
      Component cc = canvas.getRealCanvas();
      p.add(cc, BorderLayout.CENTER);
   }

   public boolean isContained() {
      return true;
   }

   public void setIcon(String str) {
      if (frame != null && str != null) {
         Image image = scc.getSwingCtx().createImage(str, "");
         frame.setIconImage(image);
         Icon ic = new ImageIcon(image);
         imgIconButton.setIcon(ic);
      }
   }

   public void setTitle(String str) {
      titleLabel.setText(str);
   }

   public void setSize(int w, int h) {

   }

   public void setPosition(int x, int y) {
      if (parent != null) {
         parent.setPosition(x, y);
      }
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == buttonStart) {
         scc.getCoordinatorSwing().frameworkRestart();
      } else if (e.getSource() == buttonStop) {
         scc.getCoordinatorSwing().frameworkExit();
         //remove the canvas
         p.remove(canvas.getRealCanvas());
      } else if(e.getSource() == buttonPause) {
         if(scc.getCoordinator().getAppli().getState() == ITechAppli.STATE_2_STARTED) {
            scc.getCoordinator().frameworkPause(); 
         } else {
            scc.getCoordinator().frameworkResume(); 
         }
      }
   }

   public void setDefaultStartPosition() {
      frame.setFramePositionCenter();
   }

}
