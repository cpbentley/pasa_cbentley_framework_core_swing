package pasa.cbentley.framework.core.framework.swing.wrapper;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.framework.core.framework.src4.ctx.ObjectCFC;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.ui.src4.engine.CanvasHostAbstract;
import pasa.cbentley.framework.core.ui.src4.engine.WrapperAbstract;
import pasa.cbentley.framework.core.ui.src4.interfaces.IWrapperManager;
import pasa.cbentley.framework.core.ui.src4.tech.IBOCanvasHost;
import pasa.cbentley.framework.core.ui.swing.wrapper.WrapperSwingTopFrame;

/**
 * Canvas owner creates {@link WrapperSwingTopFrame}.
 * 
 * He is unaware of life cycle.
 * 
 * @author Charles Bentley
 *
 */
public class WrapperManagerSwingFrameApp extends ObjectCFC implements IWrapperManager {

   protected final CoreFrameworkSwingCtx cfc;

   public WrapperManagerSwingFrameApp(CoreFrameworkSwingCtx cfc) {
      super(cfc);
      this.cfc = cfc;
   }

   public CanvasHostAbstract createCanvasHost(WrapperAbstract wrapper, ByteObject canvasTech) {
      // TODO Auto-generated method stub
      return null;
   }

   public WrapperAbstract createNewWrapper(ByteObject tech) {
      //find our wrapper
      int wrapperType = tech.get1(IBOCanvasHost.TCANVAS_OFFSET_02_WRAPPER_TYPE1);
      WrapperAbstract wrapper = null;
      if (wrapperType == IBOCanvasHost.TCANVAS_TYPE_0_DEFAULT) {
         //in a controlled env.. the wrapper is a panel and all new windows must be inside the 
         //semi multi. a new component is drawn over the old one.. like in android. screen size is fixed.
      } else if (wrapperType == IBOCanvasHost.TCANVAS_TYPE_1_FRAME) {

      } else if (wrapperType == IBOCanvasHost.TCANVAS_TYPE_2_CONTROLLED) {

      }
      wrapper = new WrapperSwingTopFrameApp(cfc);
      return wrapper;
   }

   public boolean setPosition(WrapperAbstract wrapper, int x, int y) {
      return false;
   }

   public boolean setSize(WrapperAbstract wrapper, int w, int h) {
      return false;
   }

   public void setTitle(WrapperAbstract wrapper, String title) {

   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, WrapperManagerSwingFrameApp.class, 67);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, WrapperManagerSwingFrameApp.class, 67);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

}
