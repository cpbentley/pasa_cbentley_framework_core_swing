package pasa.cbentley.framework.core.framework.swing.engine;

import pasa.cbentley.core.src4.interfaces.IHostService;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.j2se.engine.HostServiceCoreJ2se;

public class HostServiceCoreSwing extends HostServiceCoreJ2se implements IHostService {

   public HostServiceCoreSwing(CoreFrameworkSwingCtx tfc) {
      super(tfc);
   }

   public boolean isHostServiceActive(int serviceID) {
      switch (serviceID) {
         default:
            return super.isHostServiceActive(serviceID);
      }
   }

   public boolean isHostServiceSupported(int serviceID) {
      switch (serviceID) {
         default:
            return super.isHostServiceSupported(serviceID);
      }
   }

   public boolean setHostServiceActive(int serviceID, boolean isActive) {
      switch (serviceID) {
         default:
            return super.setHostServiceActive(serviceID, isActive);
      }
   }



}
