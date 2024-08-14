package pasa.cbentley.framework.core.framework.swing.engine;

import pasa.cbentley.core.src4.interfaces.IHostFeature;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.j2se.engine.HostFeatureCoreJ2se;

public class HostFeatureCoreSwing extends HostFeatureCoreJ2se implements IHostFeature {

   public HostFeatureCoreSwing(CoreFrameworkSwingCtx tfc) {
      super(tfc);
   }

   public boolean setHostFeatureEnabled(int featureID, boolean b) {
      switch (featureID) {
         default:
            return super.setHostFeatureEnabled(featureID, b);
      }
   }


   public boolean setHostFeatureEnabledFactory(int featureID, boolean b) {
      switch (featureID) {
         default:
            return super.setHostFeatureEnabledFactory(featureID, b);
      }
   }


   public boolean isHostFeatureSupported(int featureID) {
      switch (featureID) {
         default:
            return super.isHostFeatureSupported(featureID);
      }
   }

   public boolean isHostFeatureEnabled(int featureID) {
      switch (featureID) {
         default:
            return super.isHostFeatureEnabled(featureID);
      }
   }
   
   public boolean isHostFeatureFactoryEnabled(int featureID) {
      switch (featureID) {
         default:
            return super.isHostFeatureFactoryEnabled(featureID);
      }
   }


}
