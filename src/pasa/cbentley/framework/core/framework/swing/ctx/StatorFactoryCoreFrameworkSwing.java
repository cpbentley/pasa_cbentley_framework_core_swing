package pasa.cbentley.framework.core.framework.swing.ctx;

import pasa.cbentley.core.src4.ctx.ICtx;
import pasa.cbentley.core.src4.stator.IStatorFactory;
import pasa.cbentley.core.src4.stator.IStatorable;
import pasa.cbentley.core.src4.stator.StatorReader;
import pasa.cbentley.framework.core.framework.swing.wrapper.WrapperBorderLayoutSwing;
import pasa.cbentley.framework.core.framework.swing.wrapper.WrapperSwingTopFrameApp;
import pasa.cbentley.framework.core.ui.swing.wrapper.WrapperSwingTopFrame;

public class StatorFactoryCoreFrameworkSwing implements IStatorFactory, ITechStatorableCoreFrameworkSwing {

   private CoreFrameworkSwingCtx cfc;

   public StatorFactoryCoreFrameworkSwing(CoreFrameworkSwingCtx cfc) {
      this.cfc = cfc;
   }

   public Object[] createArray(int classID, int size) {
      switch (classID) {
         case CLASSID_1_WRAPPER_BORDER_LAYOUT:
            return new WrapperBorderLayoutSwing[size];
         case CLASSID_2_WRAPPER_SWING_TOP_FRAME_APP:
            return new WrapperSwingTopFrame[size];

         default:
            break;
      }
      return null;
   }

   public boolean isSupported(IStatorable statorable) {
      int id = statorable.getStatorableClassID();
      switch (id) {
         case CLASSID_1_WRAPPER_BORDER_LAYOUT:
            return true;
         case CLASSID_2_WRAPPER_SWING_TOP_FRAME_APP:
            return true;

         default:
            break;
      }
      return false;
   }

   public ICtx getCtx() {
      return cfc;
   }

   public Object createObject(StatorReader reader, int classID) {
      switch (classID) {
         case CLASSID_1_WRAPPER_BORDER_LAYOUT:
            return new WrapperBorderLayoutSwing(cfc);
         case CLASSID_2_WRAPPER_SWING_TOP_FRAME_APP:
            return new WrapperSwingTopFrameApp(cfc);

         default:
            break;
      }
      return null;
   }

}
