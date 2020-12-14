package pasa.cbentley.framework.core.swing.wrapper;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.framework.core.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.coreui.swing.engine.CanvasHostSwing;

public class FrameAppWindowListener implements WindowListener, IStringable {

   protected final CoreFrameworkSwingCtx scc;

   private CanvasHostSwing  canvas;

   public FrameAppWindowListener(CoreFrameworkSwingCtx scc, CanvasHostSwing canvas) {
      this.scc = scc;
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
      //
      if (scc.getCUC().getRootCanvas() == canvas) {
         try {
            //exit only if last active JFrame or the root JFrame
            //otherwise call End for the frame content
            //not the whole application
            //do swing specific exit routine
            //generate an event that will get caught by core framework module
            scc.getCoordinatorSwing().frameworkExit();
            //TODO ask for confirmation ? yes. actually closes unless
            //guy press. No I still need this... very small frame that autoclose
            //this is an app choice. but could be implemented in host way
         } catch (Exception ex) {
            scc.toDLog().pEx("Exception Caught during Exit Routine. Forcing exit.... signing off", null, FrameAppWindowListener.class, "", ex);
         }
         System.exit(0);
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
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, "FrameAppWindowListener");
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "FrameAppWindowListener");
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return scc.getUCtx();
   }

   //#enddebug
   


}
