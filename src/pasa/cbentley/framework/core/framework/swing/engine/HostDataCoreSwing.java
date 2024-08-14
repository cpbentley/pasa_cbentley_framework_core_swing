package pasa.cbentley.framework.core.framework.swing.engine;

import pasa.cbentley.core.src4.interfaces.IHostData;
import pasa.cbentley.framework.core.draw.swing.engine.HostDataDrawSwing;
import pasa.cbentley.framework.core.framework.src4.interfaces.ITechHostDataDrawUICore;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.framework.swing.ctx.ObjectCFCSwing;
import pasa.cbentley.framework.core.j2se.engine.HostDataCoreJ2se;

/**
 * This class deals with all HostData, from Draw, UI and Core.
 * 
 * If you want a class limited to Draw, you 
 * @author Charles Bentley
 *
 */
public class HostDataCoreSwing extends HostDataCoreJ2se implements IHostData, ITechHostDataDrawUICore {

   public HostDataCoreSwing(CoreFrameworkSwingCtx cfc) {
      super(cfc);
   }

   public float getHostDataFloat(int dataID) {
      switch (dataID) {
         default:
            return super.getHostDataFloat(dataID);
      }
   }

   public int getHostDataInt(int dataID) {
      switch (dataID) {

         default:
            return super.getHostDataInt(dataID);
      }
   }

   public Object getHostDataObject(int dataID) {
      switch (dataID) {
         default:
            break;
      }
      return super.getHostDataObject(dataID);
   }

   public String getHostDataString(int dataID) {
      switch (dataID) {
         default:
            return super.getHostDataString(dataID);
      }
   }

}
