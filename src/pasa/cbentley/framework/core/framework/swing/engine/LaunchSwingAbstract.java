package pasa.cbentley.framework.core.framework.swing.engine;

import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.core.j2se.ctx.J2seCoreCtx;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.stator.IStatorFactory;
import pasa.cbentley.core.src5.ctx.C5Ctx;
import pasa.cbentley.core.swing.ctx.SwingCoreCtx;
import pasa.cbentley.framework.core.data.src4.stator.StatorCoreData;
import pasa.cbentley.framework.core.data.src5.ctx.CoreData5Ctx;
import pasa.cbentley.framework.core.draw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.core.draw.swing.ctx.CoreDrawSwingCtx;
import pasa.cbentley.framework.core.draw.swing.ctx.IConfigCoreDrawSwing;
import pasa.cbentley.framework.core.framework.src4.app.IAppli;
import pasa.cbentley.framework.core.framework.src4.app.IConfigApp;
import pasa.cbentley.framework.core.framework.src4.ctx.CoreFrameworkCtx;
import pasa.cbentley.framework.core.framework.src4.engine.CoordinatorAbstract;
import pasa.cbentley.framework.core.framework.src4.interfaces.ICreatorAppli;
import pasa.cbentley.framework.core.framework.src4.interfaces.ILauncherHost;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.framework.swing.ctx.IConfigCoreFrameworkSwing;
import pasa.cbentley.framework.core.framework.swing.wrapper.WrapperManagerSwingFrameApp;
import pasa.cbentley.framework.core.io.src4.ctx.IConfigCoreIO;
import pasa.cbentley.framework.core.io.src5.ctx.ConfigCoreIO5Def;
import pasa.cbentley.framework.core.io.src5.ctx.CoreIO5Ctx;
import pasa.cbentley.framework.core.j2se.ctx.CoreFrameworkJ2seCtx;
import pasa.cbentley.framework.core.j2se.ctx.IConfigCoreFrameworkJ2SE;
import pasa.cbentley.framework.core.j2se.engine.CoordinatorJ2se;
import pasa.cbentley.framework.core.j2se.engine.LaunchJ2SE;
import pasa.cbentley.framework.core.ui.j2se.ctx.CoreUiJ2seCtx;
import pasa.cbentley.framework.core.ui.j2se.ctx.IConfigCoreUiJ2se;
import pasa.cbentley.framework.core.ui.src4.interfaces.ICanvasAppli;
import pasa.cbentley.framework.core.ui.src4.interfaces.IWrapperManager;
import pasa.cbentley.framework.core.ui.swing.ctx.CoreUiSwingCtx;
import pasa.cbentley.framework.core.ui.swing.ctx.IConfigCoreUiSwing;
import pasa.cbentley.framework.core.ui.swing.wrapper.WrapperManagerDefaultSwing;
import pasa.cbentley.framework.coredraw.src4.ctx.IConfigCoreDraw;
import pasa.cbentley.swing.ctx.SwingCtx;

/**
 * Launcher to be used by sub applis without a full frame.
 * Initializes all the contexts for running a swing Bentley app.
 * 
 * @author Charles Bentley
 *
 */
public abstract class LaunchSwingAbstract extends LaunchJ2SE {

   public LaunchSwingAbstract(CoreFrameworkSwingCtx cfc) {
      super(cfc);
   }

   public LaunchSwingAbstract() {
      super();
   }

   public CoordinatorJ2se createCoodinator(CoreFrameworkJ2seCtx cfc) {
      return new CoordinatorSwing((CoreFrameworkSwingCtx) cfc, this);
   }

   public CoreDrawJ2seCtx createCoreDrawJ2seCtx(J2seCoreCtx j2c, BOCtx boc) {
      IConfigCoreDrawSwing configCoreDraw = createConfigCoreDraw(boc.getUC());
      return new CoreDrawSwingCtx(configCoreDraw, (SwingCoreCtx) j2c, boc);
   }

   public CoreUiJ2seCtx createCoreUiJ2seCtx(CoreDrawJ2seCtx cdc, CoreIO5Ctx cio5c) {
      J2seCoreCtx j2c = cdc.getJ2C();
      IConfigCoreUiSwing configCoreUi = createConfigCoreUi(j2c.getUC());
      return new CoreUiSwingCtx(configCoreUi, (CoreDrawSwingCtx) cdc, (SwingCtx) j2c, cio5c);
   }

   public CoreFrameworkJ2seCtx createCoreFrameworkJ2seCtx(CoreUiJ2seCtx cuc, CoreData5Ctx cdc, CoreIO5Ctx cio5c) {
      IConfigCoreFrameworkSwing configCoreFramework = createConfigCoreSwing(uc);
      return new CoreFrameworkSwingCtx(configCoreFramework, (CoreUiSwingCtx) cuc, cdc, cio5c, this);
   }

   public J2seCoreCtx createJ2seCtx(UCtx uc, C5Ctx c5, BOCtx boc) {
      return new SwingCtx(c5);
   }

   public void appExit() {
      ((CoreFrameworkSwingCtx) cfc).getSwingCtx().cmdExit();
      super.appExit();
   }

   /**
    * Creates a new instance of the {@link IConfigApp} for this app
    * @param uc
    * @return
    */
   public abstract IConfigApp createConfigApp(UCtx uc);

   public abstract IConfigCoreFrameworkSwing createConfigCoreSwing(UCtx uc);

   public abstract IConfigCoreUiSwing createConfigCoreUi(UCtx uc);

   public abstract IConfigCoreDrawSwing createConfigCoreDraw(UCtx uc);

   public CoreFrameworkSwingCtx getCFCSwing() {
      return (CoreFrameworkSwingCtx) cfc;
   }

   /**
    * Override to provide a different one.
    * @param cfc
    * @return
    */
   public IWrapperManager createWrapperManager(CoreFrameworkJ2seCtx cfc) {
      return new WrapperManagerSwingFrameApp((CoreFrameworkSwingCtx) cfc);
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, LaunchSwingAbstract.class, 115);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, LaunchSwingAbstract.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
