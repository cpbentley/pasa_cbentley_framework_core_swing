package pasa.cbentley.framework.core.framework.swing.wrapper;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IStringable;
import pasa.cbentley.framework.core.framework.src4.ctx.ObjectCFC;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.ui.swing.engine.CanvasHostSwing;

public class FrameAppWindowFocusListener extends ObjectCFC implements WindowFocusListener, IStringable {

   private CanvasHostSwing canvas;

   public FrameAppWindowFocusListener(CoreFrameworkSwingCtx cfc, CanvasHostSwing canvas) {
      super(cfc);
      this.canvas = canvas;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, FrameAppWindowFocusListener.class, 40);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, FrameAppWindowFocusListener.class, 40);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

   public void windowGainedFocus(WindowEvent e) {
   }

   public void windowLostFocus(WindowEvent e) {

   }

}
