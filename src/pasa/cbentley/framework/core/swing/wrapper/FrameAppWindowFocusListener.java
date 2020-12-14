package pasa.cbentley.framework.core.swing.wrapper;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.framework.core.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.coreui.swing.engine.CanvasHostSwing;

public class FrameAppWindowFocusListener implements WindowFocusListener, IStringable {

   protected final CoreFrameworkSwingCtx scc;

   private CanvasHostSwing  canvas;

   public FrameAppWindowFocusListener(CoreFrameworkSwingCtx scc, CanvasHostSwing canvas) {
      this.scc = scc;
      this.canvas = canvas;
   }

   public void windowGainedFocus(WindowEvent e) {
   }


   public void windowLostFocus(WindowEvent e) {
      
   }
   
   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, "FrameAppWindowFocusListener");
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "FrameAppWindowFocusListener");
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return scc.getUCtx();
   }


   //#enddebug
   


}
