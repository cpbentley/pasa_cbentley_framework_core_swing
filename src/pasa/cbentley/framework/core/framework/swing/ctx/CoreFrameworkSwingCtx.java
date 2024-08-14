package pasa.cbentley.framework.core.framework.swing.ctx;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.ctx.IConfigBO;
import pasa.cbentley.core.src4.interfaces.IHost;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.stator.IStatorFactory;
import pasa.cbentley.framework.core.data.src5.ctx.CoreData5Ctx;
import pasa.cbentley.framework.core.draw.swing.ctx.CoreDrawSwingCtx;
import pasa.cbentley.framework.core.framework.src4.interfaces.IHostCoreTools;
import pasa.cbentley.framework.core.framework.src4.interfaces.ILauncherHost;
import pasa.cbentley.framework.core.framework.swing.engine.CoordinatorSwing;
import pasa.cbentley.framework.core.framework.swing.engine.HostCoreSwing;
import pasa.cbentley.framework.core.framework.swing.engine.HostDataCoreSwing;
import pasa.cbentley.framework.core.framework.swing.engine.HostFeatureCoreSwing;
import pasa.cbentley.framework.core.framework.swing.engine.HostServiceCoreSwing;
import pasa.cbentley.framework.core.framework.swing.engine.SwingTools;
import pasa.cbentley.framework.core.io.src5.ctx.CoreIO5Ctx;
import pasa.cbentley.framework.core.j2se.ctx.CoreFrameworkJ2seCtx;
import pasa.cbentley.framework.core.ui.swing.ctx.CoreUiSwingCtx;
import pasa.cbentley.swing.ctx.SwingCtx;

public class CoreFrameworkSwingCtx extends CoreFrameworkJ2seCtx {

   private static final int                CTX_ID = 102;

   protected final CoreUiSwingCtx          cuc;


   private StatorFactoryCoreFrameworkSwing factory;

   private HostDataCoreSwing               hostDataCoreSwing;

   private HostFeatureCoreSwing            hostFeatureCoreSwing;

   private HostServiceCoreSwing            hostServiceCoreSwing;

   private SwingTools                      tools;

   public CoreFrameworkSwingCtx(CoreUiSwingCtx cuc, CoreData5Ctx dac, CoreIO5Ctx ioc, ILauncherHost launcher) {
      this(null, cuc, dac, ioc, launcher);
   }

   public CoreFrameworkSwingCtx(IConfigCoreFrameworkSwing config, CoreUiSwingCtx cuc, CoreData5Ctx dac, CoreIO5Ctx ioc, ILauncherHost launcher) {
      super(config == null ? new ConfigCoreFrameworkSwingDefault(cuc.getUC()) : config, cuc, dac, ioc, launcher);
      this.cuc = cuc;
      tools = new SwingTools(this);
      factory = new StatorFactoryCoreFrameworkSwing(this);

      hostDataCoreSwing = new HostDataCoreSwing(this);
      hostFeatureCoreSwing = new HostFeatureCoreSwing(this);
      hostServiceCoreSwing = new HostServiceCoreSwing(this);

      if (this.getClass() == CoreFrameworkSwingCtx.class) {
         a_Init();
      }

      //#debug
      toDLog().pCreate("", this, CoreFrameworkSwingCtx.class, "Created@47", LVL_04_FINER, true);
   }

   public IHost createHost() {
      HostCoreSwing host = new HostCoreSwing(this, hostDataCoreSwing, hostFeatureCoreSwing, hostServiceCoreSwing);
      return host;
   }

   public CoordinatorSwing getCoordinatorSwing() {
      return (CoordinatorSwing) getCoordinator();
   }

   public CoreDrawSwingCtx getCoreDrawSwingCtx() {
      return cuc.getCoreDrawSwingCtx();
   }

   public CoreUiSwingCtx getCoreUiSwingCtx() {
      return cuc;
   }

   public int getCtxID() {
      return CTX_ID;
   }

   public IHostCoreTools getHostTools() {
      return tools;
   }


   public IStatorFactory getStatorFactory() {
      return factory;
   }

   public String getStringIDReal() {
      return "swing";
   }

   public SwingCtx getSwingCtx() {
      return cuc.getSwingCtx();
   }

   protected void matchConfig(IConfigBO config, ByteObject settings) {
      super.matchConfig(config, settings);
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, CoreFrameworkSwingCtx.class, 106);
      toStringPrivate(dc);
      super.toString(dc.sup());
      dc.nlLvl(config, IConfigCoreFrameworkSwing.class);
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, CoreFrameworkSwingCtx.class,113);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
