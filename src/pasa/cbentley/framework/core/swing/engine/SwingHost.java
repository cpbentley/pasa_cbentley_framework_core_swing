package pasa.cbentley.framework.core.swing.engine;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.framework.core.j2se.engine.CoreJ2SEHost;
import pasa.cbentley.framework.core.src4.interfaces.ITechDataHost;
import pasa.cbentley.framework.core.src4.interfaces.ITechHost;
import pasa.cbentley.framework.core.swing.ctx.CoreFrameworkSwingCtx;

public class SwingHost extends CoreJ2SEHost {

   public SwingHost(CoreFrameworkSwingCtx csc) {
      super(csc);
   }

   public int getHostInt(int dataID) {
      switch (dataID) {
         default:
            return super.getHostInt(dataID);
      }
   }
   
   public String getHostString(int dataID) {
      switch (dataID) {
         case ITechDataHost.DATA_ID_STR_04_PLATFORM:
            return "swing";
         default:
            return super.getHostString(dataID);
      }
   }


   public ByteObject getScreenConfig() {
      // TODO Auto-generated method stub
      return null;
   }
}
