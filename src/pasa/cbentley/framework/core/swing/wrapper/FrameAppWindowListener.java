package pasa.cbentley.framework.core.swing.wrapper;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.framework.core.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.swing.ctx.ObjectCFSwing;
import pasa.cbentley.framework.coreui.swing.engine.CanvasHostSwing;

/**
 * 
 * @author Charles Bentley
 *
 */
public class FrameAppWindowListener extends ObjectCFSwing implements WindowListener, IStringable {

   private CanvasHostSwing canvas;

   public FrameAppWindowListener(CoreFrameworkSwingCtx scc, CanvasHostSwing canvas) {
      super(scc);
      this.canvas = canvas;
   }

   public void windowActivated(WindowEvent e) {
      //#debug
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowActivated", LVL_03_FINEST, true);
   }

   public void windowClosed(WindowEvent e) {
      //#debug
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowClosed", LVL_03_FINEST, true);
   }

   public void windowClosing(WindowEvent e) {
      //normal behavior is frame is going on hide
      if (scc.getCUC().getCanvasRootHost() == canvas) {
         try {
            //exit only if last active JFrame or the root JFrame
            //we have no idea at this level how to handle destroys
            scc.getCoordinator().appliWantBeDestroyed();
         } catch (Exception ex) {
            scc.toDLog().pEx("Exception Caught during Exit Routine. Forcing exit.... signing off", null, FrameAppWindowListener.class, "", ex);
         }
      } else {

      }
   }

   public void windowDeactivated(WindowEvent e) {
      //#debug
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowDeactivated", LVL_03_FINEST, true);
   }

   public void windowDeiconified(WindowEvent e) {
      //generate event
      scc.getCoordinatorSwing().frameworkResume();
   }

   public void windowIconified(WindowEvent e) {
      scc.getCoordinatorSwing().frameworkPause();
   }

   public void windowOpened(WindowEvent e) {

   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, FrameAppWindowListener.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
      dc.nlLvl(canvas, "CanvasHostSwing");
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FrameAppWindowListener.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
