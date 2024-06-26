package pasa.cbentley.framework.core.swing.wrapper;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import pasa.cbentley.core.src4.logging.Dctx;
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

   /**
    * not null
    */
   private CanvasHostSwing canvas;

   public FrameAppWindowListener(CoreFrameworkSwingCtx scc, CanvasHostSwing canvas) {
      super(scc);
      
      //#mdebug
      if(canvas == null) {
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
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowDeactivated@73", LVL_03_FINEST, true);
   }

   public void windowDeiconified(WindowEvent e) {
      //#debug
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowDeiconified@77", LVL_03_FINEST, true);
      //generate event
      scc.getCoordinatorSwing().frameworkResume();
   }

   public void windowIconified(WindowEvent e) {
      //#debug
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowIconified@84", LVL_03_FINEST, true);
      scc.getCoordinatorSwing().frameworkPause();
   }

   public void windowOpened(WindowEvent e) {
      //#debug
      toDLog().pFlow("", this, FrameAppWindowListener.class, "windowOpened@90", LVL_03_FINEST, true);
   }

}
