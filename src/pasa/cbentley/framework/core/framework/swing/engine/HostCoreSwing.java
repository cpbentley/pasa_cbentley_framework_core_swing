package pasa.cbentley.framework.core.framework.swing.engine;

import java.io.IOException;
import java.io.InputStream;

import pasa.cbentley.core.src4.interfaces.IExecutor;
import pasa.cbentley.core.src4.interfaces.IHost;
import pasa.cbentley.core.src4.interfaces.IHostData;
import pasa.cbentley.core.src4.interfaces.IHostFeature;
import pasa.cbentley.core.src4.interfaces.IHostService;
import pasa.cbentley.core.src4.interfaces.ITimeCtrl;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.framework.swing.ctx.ObjectCFSwing;
import pasa.cbentley.framework.core.j2se.engine.HostCoreJ2se;
import pasa.cbentley.framework.core.ui.j2se.engine.TimeControlJ2se;
import pasa.cbentley.swing.ctx.SwingCtx;
import pasa.cbentley.swing.ctx.SwingExecutor;

public class HostCoreSwing extends HostCoreJ2se implements IHost {

   private HostDataCoreSwing    data;

   private HostFeatureCoreSwing feature;

   private HostServiceCoreSwing service;

   private SwingExecutor executor;

   public HostCoreSwing(CoreFrameworkSwingCtx cfc, HostDataCoreSwing data, HostFeatureCoreSwing feature, HostServiceCoreSwing service) {
      super(cfc);

      this.data = data;
      this.feature = feature;
      this.service = service;
      SwingCtx sc = cfc.getSwingCtx();
      executor = sc.getSwingExecutor();
   }

   public IHostData getHostData() {
      return data;
   }

   public IHostFeature getHostFeature() {
      return feature;
   }

   public IHostService getHostService() {
      return service;
   }

   public IExecutor getExecutor() {
      return executor;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, HostCoreSwing.class, 60);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, HostCoreSwing.class, 60);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {
      
   }
   //#enddebug
   

}
