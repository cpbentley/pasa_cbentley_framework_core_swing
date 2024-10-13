package pasa.cbentley.framework.core.framework.swing.wrapper.tab;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.framework.swing.ctx.ObjectCFCSwing;
import pasa.cbentley.framework.core.ui.src4.engine.CanvasHostAbstract;
import pasa.cbentley.framework.core.ui.src4.interfaces.IWrapperManager;
import pasa.cbentley.framework.core.ui.src4.tech.IBOCanvasHost;
import pasa.cbentley.framework.core.ui.src4.tech.ITechWrapper;
import pasa.cbentley.framework.core.ui.src4.wrapper.WrapperAbstract;

public class WrapperManagerTabs extends ObjectCFCSwing implements IWrapperManager {

   public WrapperManagerTabs(CoreFrameworkSwingCtx cfc) {
      super(cfc);
      
      //#debug
      toDLog().pInit("", this, WrapperManagerTabs.class, "created@20", LVL_04_FINER, true);
   }

   public CanvasHostAbstract createCanvasHost(WrapperAbstract wrapper, ByteObject canvasTech) {
      // TODO Auto-generated method stub
      return null;
   }

   public WrapperAbstract createNewWrapper(ByteObject tech) {
      //#debug
      toDLog().pBridge("", this, WrapperManagerTabs.class, "createNewWrapper@27", LVL_05_FINE, true);
      
      //find our wrapper
      int wrapperType = tech.get1(IBOCanvasHost.CANVAS_HOST_OFFSET_10_WRAPPER_TYPE1);
      WrapperAbstract wrapper = null;
      if (wrapperType == ITechWrapper.WRAPPER_TYPE_0_DEFAULT) {
         //in a controlled env.. the wrapper is a panel and all new windows must be inside the 
         //semi multi. a new component is drawn over the old one.. like in android. screen size is fixed.
      } else if (wrapperType == ITechWrapper.WRAPPER_TYPE_1_FRAME) {

      } else if (wrapperType == ITechWrapper.WRAPPER_TYPE_2_CONTROLLED) {

      }
      wrapper = new WrapperTabPane(cfc);
      return wrapper;
   }

   

   public boolean setPosition(WrapperAbstract wrapper, int x, int y) {
      return false;
   }

   public boolean setSize(WrapperAbstract wrapper, int w, int h) {
      //we can try grow it 
      return false;
   }

   public void setTitle(WrapperAbstract wrapper, String title) {
      if (wrapper instanceof WrapperTabPane) {
         WrapperTabPane w = (WrapperTabPane) wrapper;
         w.setTitle(title);
      } else {
         throw new IllegalArgumentException();
      }
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, WrapperManagerTabs.class, 48);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, WrapperManagerTabs.class, 48);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

}
