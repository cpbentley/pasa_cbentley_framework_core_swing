package pasa.cbentley.framework.core.framework.swing.engine;

import java.awt.Component;

import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.core.j2se.ctx.J2seCoreCtx;
import pasa.cbentley.core.src4.ctx.IConfigU;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.logging.ILogConfigurator;
import pasa.cbentley.core.src5.ctx.C5Ctx;
import pasa.cbentley.core.src5.utils.LineGetterSrc5;
import pasa.cbentley.core.swing.ctx.SwingCoreCtx;
import pasa.cbentley.framework.core.data.src5.ctx.ConfigCoreData5Default;
import pasa.cbentley.framework.core.data.src5.ctx.CoreData5Ctx;
import pasa.cbentley.framework.core.data.src5.ctx.IConfigCoreData5;
import pasa.cbentley.framework.core.draw.j2se.ctx.CoreDrawJ2seCtx;
import pasa.cbentley.framework.core.draw.swing.ctx.ConfigCoreDrawSwingDef;
import pasa.cbentley.framework.core.draw.swing.ctx.CoreDrawSwingCtx;
import pasa.cbentley.framework.core.draw.swing.ctx.IConfigCoreDrawSwing;
import pasa.cbentley.framework.core.framework.src4.app.IAppli;
import pasa.cbentley.framework.core.framework.src4.app.IConfigApp;
import pasa.cbentley.framework.core.framework.src4.ctx.CoreFrameworkCtx;
import pasa.cbentley.framework.core.framework.src4.engine.CoordinatorAbstract;
import pasa.cbentley.framework.core.framework.src4.interfaces.ICreatorAppli;
import pasa.cbentley.framework.core.framework.src4.interfaces.IDependencies;
import pasa.cbentley.framework.core.framework.src4.interfaces.ILauncherHost;
import pasa.cbentley.framework.core.framework.swing.ctx.ConfigCoreFrameworkSwingDef;
import pasa.cbentley.framework.core.framework.swing.ctx.ConfigCoreFrameworkSwingDefault;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.framework.swing.ctx.IConfigCoreFrameworkSwing;
import pasa.cbentley.framework.core.io.src5.ctx.ConfigCoreIO5Def;
import pasa.cbentley.framework.core.io.src5.ctx.CoreIO5Ctx;
import pasa.cbentley.framework.core.io.src5.ctx.IConfigCoreIO5;
import pasa.cbentley.framework.core.j2se.ctx.CoreFrameworkJ2seCtx;
import pasa.cbentley.framework.core.j2se.ctx.IConfigCoreFrameworkJ2se;
import pasa.cbentley.framework.core.j2se.engine.CoordinatorJ2se;
import pasa.cbentley.framework.core.j2se.engine.LauncherJ2se;
import pasa.cbentley.framework.core.j2se.engine.LogConfiguratorJ2se;
import pasa.cbentley.framework.core.ui.j2se.ctx.CoreUiJ2seCtx;
import pasa.cbentley.framework.core.ui.src4.interfaces.IWrapperManager;
import pasa.cbentley.framework.core.ui.swing.ctx.ConfigCoreUiSwingDef;
import pasa.cbentley.framework.core.ui.swing.ctx.CoreUiSwingCtx;
import pasa.cbentley.framework.core.ui.swing.ctx.IConfigCoreUiSwing;
import pasa.cbentley.framework.core.ui.swing.engine.CanvasHostSwing;
import pasa.cbentley.framework.core.ui.swing.wrapper.WrapperManagerPanelSwing;
import pasa.cbentley.swing.ctx.ConfigSwingDefault;
import pasa.cbentley.swing.ctx.IConfigSwing;
import pasa.cbentley.swing.ctx.SwingCtx;

/**
 * Launcher for a single Drawable App that is used by Swing code.
 * 
 * @author Charles Bentley
 *
 */
public class LaunchSwingPanelApp implements ILauncherHost {

   protected BOCtx                   boc;

   protected C5Ctx                   c5;

   protected CoreFrameworkJ2seCtx    cfc;

   private IConfigApp                config;

   private IConfigCoreFrameworkSwing configCoreSwing;

   private IConfigCoreUiSwing        configCoreUiSwing;

   private IConfigU                  configu;

   protected CoordinatorJ2se         coordinator;

   private ICreatorAppli             creatorAppli;

   private IDependencies             dependencies;

   protected J2seCoreCtx             j2c;

   protected UCtx                    uc;

   /**
    * @param configU
    */
   public LaunchSwingPanelApp(IConfigU configU) {
      super();
      this.configu = configU;

      //which log configurator is used ? ConfigU or Launcher ?
      //config log is stronger
      ILogConfigurator logConfigurator = configu.toStringGetLogConfigurator();
      if (logConfigurator == null) {
         // 2: we fetch the ILogConfigurator from the subclass of LauncherJ2se
         logConfigurator = this.toStringGetLoggingConfig();
         configu.toStringSetLogConfigurator(logConfigurator);
      }

      //we set the logconfigurator into the configU so that UCtx has it
      //we don't want to polute the constructor of UCtx with a toString object.
      String name = configu.getUCtxName();
      if (name == null) {
         name = "LaunchSwingPanel";
      }
      uc = new UCtx(configu, name); //constructor deals smoothly with a null
      uc.toStringSetLineNumberGetter(new LineGetterSrc5());

   }

   public void appExit() {
      // TODO Auto-generated method stub

   }

   public void appPause() {
      // TODO Auto-generated method stub

   }

   public void build() {

      boc = new BOCtx(uc);
      c5 = new C5Ctx(uc);

      //gives the data for the host code contexts
      IConfigCoreData5 configData = createConfigCoreData5(uc);
      CoreData5Ctx coreDataCtx = new CoreData5Ctx(configData, boc);

      //configuration decide what directory to use
      IConfigCoreIO5 configIO = createConfigCoreIO(uc);
      CoreIO5Ctx cio5c = new CoreIO5Ctx(configIO, c5);

      j2c = createJ2seCtx(uc, c5, boc);
      CoreDrawJ2seCtx cdc = createCoreDrawJ2seCtx(j2c, boc);
      CoreUiJ2seCtx cuc = createCoreUiJ2seCtx(cdc, cio5c);

      cfc = createCoreFrameworkJ2seCtx(cuc, coreDataCtx, cio5c);

      coordinator = createCoodinator(cfc);

      IWrapperManager wrapperManager = createWrapperManager(cfc);
      cuc.setWrapperManager(wrapperManager);

   }

   public IConfigApp createConfigApp(UCtx uc) {
      return config;
   }

   public IConfigCoreData5 createConfigCoreData5(UCtx uc) {
      return new ConfigCoreData5Default(uc);
   }

   public IConfigCoreDrawSwing createConfigCoreDraw(UCtx uc) {
      return new ConfigCoreDrawSwingDef(uc);
   }

   public IConfigCoreIO5 createConfigCoreIO(UCtx uc) {
      return new ConfigCoreIO5Def(uc);
   }

   public IConfigCoreFrameworkJ2se createConfigCoreJ2SE(UCtx uc) {
      return new ConfigCoreFrameworkSwingDefault(uc);
   }

   public IConfigCoreFrameworkSwing createConfigCoreSwing(UCtx uc) {
      if (configCoreSwing == null) {
         return new ConfigCoreFrameworkSwingDef(uc);
      }
      return configCoreSwing;
   }

   public IConfigCoreUiSwing createConfigCoreUi(UCtx uc) {
      if (configCoreUiSwing == null) {
         return new ConfigCoreUiSwingDef(uc);
      }
      return configCoreUiSwing;

   }

   public CoordinatorJ2se createCoodinator(CoreFrameworkJ2seCtx cfc) {
      return new CoordinatorSwing((CoreFrameworkSwingCtx) cfc, this);
   }

   public CoreDrawJ2seCtx createCoreDrawJ2seCtx(J2seCoreCtx j2c, BOCtx boc) {
      IConfigCoreDrawSwing configCoreDraw = createConfigCoreDraw(boc.getUC());
      return new CoreDrawSwingCtx(configCoreDraw, (SwingCoreCtx) j2c, boc);
   }

   public CoreFrameworkJ2seCtx createCoreFrameworkJ2seCtx(CoreUiJ2seCtx cuc, CoreData5Ctx cdc, CoreIO5Ctx cio5c) {
      IConfigCoreFrameworkSwing configCoreFramework = createConfigCoreSwing(uc);
      return new CoreFrameworkSwingCtx(configCoreFramework, (CoreUiSwingCtx) cuc, cdc, cio5c, this);
   }

   public CoreUiJ2seCtx createCoreUiJ2seCtx(CoreDrawJ2seCtx cdc, CoreIO5Ctx cio5c) {
      J2seCoreCtx j2c = cdc.getJ2C();
      IConfigCoreUiSwing configCoreUi = createConfigCoreUi(j2c.getUC());
      return new CoreUiSwingCtx(configCoreUi, (CoreDrawSwingCtx) cdc, (SwingCtx) j2c, cio5c);
   }

   protected ICreatorAppli createCreator(UCtx uc) {
      return creatorAppli;
   }

   public J2seCoreCtx createJ2seCtx(UCtx uc, C5Ctx c5, BOCtx boc) {
      IConfigSwing config = getConfigSwing();
      return new SwingCtx(config, c5);
   }

   public IWrapperManager createWrapperManager(CoreFrameworkJ2seCtx cfc) {
      return new WrapperManagerPanelSwing((CoreUiSwingCtx) cfc.getCoreUiJ2seCtx());
   }

   public IAppli getAppli() {
      return coordinator.getAppli();
   }

   public Component getCanvasComponent() {
      return getCanvasSwing().getComponentOfCanvas();
   }

   /**
    * Returns the main canvas swing used
    * @return
    */
   public CanvasHostSwing getCanvasSwing() {
      return (CanvasHostSwing) getCFCSwing().getCoreUiSwingCtx().getCanvasRootHost();
   }

   public CoreFrameworkCtx getCFC() {
      return cfc;
   }

   public CoreFrameworkSwingCtx getCFCSwing() {
      return (CoreFrameworkSwingCtx) cfc;
   }

   public IConfigSwing getConfigSwing() {
      return new ConfigSwingDefault();
   }

   public CoordinatorAbstract getCoordinator() {
      return coordinator;
   }

   public IDependencies getDependencies() {
      if (dependencies == null) {
         throw new RuntimeException("Dependencings have not been set on this launcher");
      }
      return dependencies;
   }

   public UCtx getUC() {
      return uc;
   }

   public void launch() {
      //appli launcher 2nd class
      creatorAppli = createCreator(uc);

      toDLog().pInit("CreatorAppli created : ", creatorAppli, LauncherJ2se.class, "launch@213", LVL_05_FINE, true);

      //shake hands with Host
      this.startAppli(creatorAppli);
   }

   public void setConfigCoreUiSwing(IConfigCoreUiSwing configCoreUiSwing) {
      this.configCoreUiSwing = configCoreUiSwing;
   }

   public void setConfigU(IConfigU configU) {
      this.configu = configU;
   }

   public void setCreatorAppli(ICreatorAppli creatorAppli) {
      this.creatorAppli = creatorAppli;
   }

   public void setDependencies(IDependencies dependencies) {
      this.dependencies = dependencies;
   }

   /**
    * Shared code context. we only want one JInput ? Not possible.
    * Must be paused when app is out of focus
    */
   public void setOSSpecifics(CoreFrameworkCtx hoc) {

   }

   /**
    * The {@link ICreatorAppli} is known. Start it for starting the application.
    * <br>
    * <li> Swing needs special way to start appli in the GUI thread.
    * <li> JavaFx ...
    * <li>
    */
   public void startAppli(ICreatorAppli creatorAppli) {
      CoordinatorAbstract coordinator = getCoordinator();

      toDLog().pInit("CreatorAppli Created", creatorAppli, LaunchSwingPanelApp.class, "startAppli@213", LVL_05_FINE, DEV_X_ONELINE_THRE);
      coordinator.frameworkStart(creatorAppli);

      //this might never be called.. 
      //wait for UI thread to run?
   }

   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, LaunchSwingPanelApp.class, 250);
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, LaunchSwingPanelApp.class);
      toStringPrivate(dc);
   }

   /**
    * Called 
    */
   public void toStringEnableFullDebug() {
      getCoordinator().toStringEnableFullDebug();
   }

   public String toStringGetLine(int value) {
      return toStringGetUCtx().toStringGetLine(value);
   }

   /**
    * Returns the logging configurator for the logger
    */
   public ILogConfigurator toStringGetLoggingConfig() {
      return new LogConfiguratorJ2se();
   }

   public UCtx toStringGetUCtx() {
      return uc;
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
