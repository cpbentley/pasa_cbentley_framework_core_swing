package pasa.cbentley.framework.core.framework.swing.wrapper;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.framework.swing.ctx.ObjectCFCSwing;
import pasa.cbentley.framework.core.ui.swing.engine.CanvasHostSwingAbstract;

/**
 * 
 * @author Charles Bentley
 *
 */
public class FrameAppWindowListener extends ObjectCFCSwing implements WindowListener, IStringable {

   /**
    * not null
    */
   private CanvasHostSwingAbstract canvas;

   public FrameAppWindowListener(CoreFrameworkSwingCtx scc, CanvasHostSwingAbstract canvas) {
      super(scc);

      //#mdebug
      if (canvas == null) {
         throw new NullPointerException();
      }
      //#enddebug

      this.canvas = canvas;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, FrameAppWindowListener.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
      dc.nlLvl(canvas, "CanvasHostSwing");
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FrameAppWindowListener.class);
      toStringPrivate(dc);
      dc.appendVarWithSpace(canvas.getTitle(), "CanvasTitle");
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

   public void windowActivated(WindowEvent e) {
      //#debug
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowActivated@48", LVL_03_FINEST, true);
   }

   public void windowClosed(WindowEvent e) {
      //#debug
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowClosed@53", LVL_03_FINEST, true);
   }

   public void windowClosing(WindowEvent e) {
      //#debug
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowClosing@68", LVL_05_FINE, true);
      //normal behavior is frame is going on hide
      if (cfc.getCUC().getCanvasRootHost() == canvas) {
         try {
            //exit only if last active JFrame or the root JFrame
            //we have no idea at this level how to handle destroys
            cfc.getCoordinator().appliWantBeDestroyed();
         } catch (Exception ex) {
            cfc.toDLog().pEx("Exception Caught during Exit Routine. Forcing exit.... signing off", null, FrameAppWindowListener.class, "", ex);
         }
      } else {

      }
   }

   public void windowDeactivated(WindowEvent e) {
      //#debug
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowDeactivated@73", LVL_03_FINEST, true);
   }

   public void windowDeiconified(WindowEvent e) {
      //#debug
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowDeiconified@77", LVL_03_FINEST, true);
      //generate event
      cfc.getCoordinatorSwing().frameworkResume();
   }

   public void windowIconified(WindowEvent e) {
      //#debug
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowIconified@84", LVL_03_FINEST, true);
      cfc.getCoordinatorSwing().frameworkPause();
   }

   public void windowOpened(WindowEvent e) {
      //#debug
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowOpened@90", LVL_03_FINEST, true);
   }

}
