package pasa.cbentley.framework.core.framework.swing.wrapper;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.framework.swing.ctx.ObjectCFCSwing;
import pasa.cbentley.framework.core.ui.src4.engine.CanvasHostAbstract;
import pasa.cbentley.framework.core.ui.src4.interfaces.IWrapperManager;
import pasa.cbentley.framework.core.ui.src4.tech.IBOCanvasHost;
import pasa.cbentley.framework.core.ui.src4.tech.ITechWrapper;
import pasa.cbentley.framework.core.ui.src4.wrapper.WrapperAbstract;
import pasa.cbentley.framework.core.ui.swing.engine.CanvasHostSwing;
import pasa.cbentley.framework.core.ui.swing.wrapper.WrapperSwingTopFrame;

/**
 * The first wrapper is always a {@link WrapperBorderLayoutSwing}.
 * All window others are frames
 * @author Charles Bentley
 *
 */
public class WrapperManagerControl extends ObjectCFCSwing implements IWrapperManager {

   private WrapperBorderLayoutSwing main;

   public WrapperManagerControl(CoreFrameworkSwingCtx cfc) {
      super(cfc);

      //#debug
      toDLog().pInit("", this, WrapperManagerControl.class, "created@20", LVL_04_FINER, true);
   }

   public CanvasHostAbstract createCanvasHost(WrapperAbstract wrapper, ByteObject boCanvasHost) {
      //create the default one
      CanvasHostSwing canvasHost = new CanvasHostSwing(cfc.getCoreUiSwingCtx(), boCanvasHost);
      return canvasHost;
   }

   /**
    * 
    */
   public WrapperAbstract createNewWrapper(ByteObject boCanvasHost) {
      //#debug
      toDLog().pBridge("", this, WrapperManagerControl.class, "createNewWrapper@27", LVL_05_FINE, true);

      if (main == null) {
         main = new WrapperBorderLayoutSwing(cfc);
         return main;
      } else {

         //find our wrapper
         int wrapperType = boCanvasHost.get1(IBOCanvasHost.CANVAS_HOST_OFFSET_10_WRAPPER_TYPE1);
         WrapperAbstract wrapper = null;

         switch (wrapperType) {
            case ITechWrapper.WRAPPER_TYPE_0_DEFAULT:
            case ITechWrapper.WRAPPER_TYPE_2_CONTROLLED:
            case ITechWrapper.WRAPPER_TYPE_1_FRAME:
               //this manager allows the main app to generate suboordinate frames
               wrapper = new WrapperSwingTopFrame(cfc.getCoreUiSwingCtx());
               break;
            default:
               throw new IllegalArgumentException();
         }

         return wrapper;
      }
   }

   /**
    * This manager
    */
   public boolean setPosition(WrapperAbstract wrapper, int x, int y) {

      return false;
   }

   public boolean setSize(WrapperAbstract wrapper, int w, int h) {
      //we can try grow it 
      return false;
   }

   public void setTitle(WrapperAbstract wrapper, String title) {
      if (wrapper instanceof WrapperBorderLayoutSwing) {
         WrapperBorderLayoutSwing w = (WrapperBorderLayoutSwing) wrapper;
         w.setTitle(title);
      } else {
         throw new IllegalArgumentException();
      }
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, WrapperManagerControl.class, 48);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, WrapperManagerControl.class, 48);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

}
