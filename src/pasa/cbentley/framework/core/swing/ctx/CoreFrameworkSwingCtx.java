package pasa.cbentley.framework.core.swing.ctx;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.byteobjects.src4.ctx.IConfigBO;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.j2se.ctx.CoreFrameworkJ2seCtx;
import pasa.cbentley.framework.core.src4.interfaces.IHostCore;
import pasa.cbentley.framework.core.src4.interfaces.IHostCoreTools;
import pasa.cbentley.framework.core.src4.interfaces.ILauncherHost;
import pasa.cbentley.framework.core.swing.engine.CoordinatorSwing;
import pasa.cbentley.framework.core.swing.engine.SwingHost;
import pasa.cbentley.framework.core.swing.engine.SwingTools;
import pasa.cbentley.framework.coredata.src5.ctx.CoreData5Ctx;
import pasa.cbentley.framework.coredraw.swing.ctx.CoreDrawSwingCtx;
import pasa.cbentley.framework.coreio.src5.ctx.CoreIO5Ctx;
import pasa.cbentley.framework.coreui.swing.ctx.CoreUiSwingCtx;
import pasa.cbentley.swing.ctx.SwingCtx;

public class CoreFrameworkSwingCtx extends CoreFrameworkJ2seCtx {

   private static final int         CTX_ID = 450;

   protected final IConfigCoreFrameworkSwing config;

   protected final CoreUiSwingCtx   cuc;

   private SwingHost                host;

   private SwingTools               tools;

   public CoreFrameworkSwingCtx(IConfigCoreFrameworkSwing config, CoreUiSwingCtx cuc, CoreData5Ctx dac, CoreIO5Ctx ioc, ILauncherHost launcher) {
      super(config, cuc, dac, ioc, launcher);
      this.config = config;
      this.cuc = cuc;
      host = new SwingHost(this);
      tools = new SwingTools(this);

      if (this.getClass() == CoreFrameworkSwingCtx.class) {
         a_Init();
      }
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

   /**
    * 
    * @return
    */
   public IHostCore getHostCore() {
      return host;
   }

   public IHostCoreTools getHostTools() {
      return tools;
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
      dc.root(this, CoreFrameworkSwingCtx.class, "@line86");
      toStringPrivate(dc);
      super.toString(dc.sup());
      dc.nlLvl(config, IConfigCoreFrameworkSwing.class);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, CoreFrameworkSwingCtx.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
