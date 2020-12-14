package pasa.cbentley.framework.core.swing.wrapper;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.coreui.swing.engine.CanvasHostSwing;
import pasa.cbentley.framework.coreui.swing.wrapper.WrapperSwingTopFrame;

/**
 * 
 * {@link WrapperSwingTopFrame} with framework app lifecycle awareness
 *
 * @author Charles Bentley
 *
 */
public class WrapperSwingTopFrameApp extends WrapperSwingTopFrame {

   protected final CoreFrameworkSwingCtx   scc;

   private FrameAppWindowListener wrapperWindowListener;

   /**
    * 
    */
   public WrapperSwingTopFrameApp(CoreFrameworkSwingCtx scc) {
      super(scc.getCoreUiSwingCtx());
      this.scc = scc;
   }

   /**
    * Sets the Canvas to the frame
    */
   public void addCanvas(CanvasHostSwing ac) {
      super.addCanvas(ac); //must be called first
      //we want the event app exit to be processed last
      wrapperWindowListener = new FrameAppWindowListener(scc, ac);
      frame.addWindowListener(wrapperWindowListener);
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, WrapperSwingTopFrameApp.class, "@line42");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, WrapperSwingTopFrameApp.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
