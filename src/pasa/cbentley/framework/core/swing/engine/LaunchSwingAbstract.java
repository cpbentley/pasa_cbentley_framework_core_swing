package pasa.cbentley.framework.core.swing.engine;

import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.core.j2se.ctx.J2seCtx;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.stator.IStatorFactory;
import pasa.cbentley.core.src5.ctx.C5Ctx;
import pasa.cbentley.framework.core.j2se.ctx.IConfigCoreFrameworkJ2SE;
import pasa.cbentley.framework.core.j2se.engine.LaunchJ2SE;
import pasa.cbentley.framework.core.src4.app.IAppli;
import pasa.cbentley.framework.core.src4.app.IConfigApp;
import pasa.cbentley.framework.core.src4.ctx.CoreFrameworkCtx;
import pasa.cbentley.framework.core.src4.engine.CoordinatorAbstract;
import pasa.cbentley.framework.core.src4.interfaces.ILauncherAppli;
import pasa.cbentley.framework.core.src4.interfaces.ILauncherHost;
import pasa.cbentley.framework.core.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.swing.ctx.IConfigCoreFrameworkSwing;
import pasa.cbentley.framework.coredraw.src4.ctx.IConfigCoreDraw;
import pasa.cbentley.framework.coredraw.swing.ctx.CoreDrawSwingCtx;
import pasa.cbentley.framework.coredraw.swing.ctx.IConfigCoreDrawSwing;
import pasa.cbentley.framework.coreio.src4.ctx.IConfigCoreIO;
import pasa.cbentley.framework.coreio.src5.ctx.ConfigIO5Def;
import pasa.cbentley.framework.coreio.src5.ctx.CoreIO5Ctx;
import pasa.cbentley.framework.coreui.j2se.ctx.IConfigCoreUiJ2se;
import pasa.cbentley.framework.coreui.src4.interfaces.ICanvasAppli;
import pasa.cbentley.framework.coreui.src4.interfaces.ICanvasOwner;
import pasa.cbentley.framework.coreui.swing.ctx.CoreUiSwingCtx;
import pasa.cbentley.framework.coreui.swing.wrapper.CanvasOwnerDefaultSwing;
import pasa.cbentley.swing.ctx.SwingCtx;

/**
 * Launcher to be used by sub applis without a full frame.
 * Initializes all the contexts for running a swing Bentley app.
 * 
 * @author Charles Bentley
 *
 */
public abstract class LaunchSwingAbstract extends LaunchJ2SE implements ILauncherHost {

   protected final CoreDrawSwingCtx cdc;

   protected final CoordinatorSwing coordinator;

   protected final CoreFrameworkSwingCtx     csc;

   protected final SwingCtx         sc;

   protected final CoreUiSwingCtx   cuiSwingc;

   public LaunchSwingAbstract() {
      super();
      sc = (SwingCtx) j2c;

      IConfigCoreDrawSwing configCoreDraw = createConfigCoreDraw(uc);
      cdc = new CoreDrawSwingCtx(configCoreDraw, sc, boc);

      IConfigCoreUiJ2se configCoreUi = createConfigCoreUi(uc);
      cuiSwingc = new CoreUiSwingCtx(configCoreUi, cdc, sc, cio5c);

      IConfigCoreFrameworkSwing configCoreFramework = createConfigCoreSwing(sc);
      csc = new CoreFrameworkSwingCtx(configCoreFramework, cuiSwingc, coreDataCtx, cio5c, this);

      this.cjc = csc;

      coordinator = new CoordinatorSwing(csc, this);

      //TODO can the wrapper manager depends on the state?
      ICanvasOwner wrapperManager = createWrapperManager(csc);
      cuiSwingc.setWrapperManager(wrapperManager);

      if (wrapperManager instanceof IStatorFactory) {
         stateReader.addFactory((IStatorFactory) wrapperManager);
      }

   }

   public J2seCtx createJ2seCtx(UCtx uc, C5Ctx c5, BOCtx boc) {
      return new SwingCtx(c5);
   }

   public CoordinatorAbstract getCoordinator() {
      return coordinator;
   }

   public IAppli getAppli() {
      return coordinator.getAppli();
   }

   /**
    * Shortcut
    * @return
    */
   public ICanvasAppli getCanvasAppliRoot() {
      return coordinator.getAppli().getCanvas(0, null);
   }

   public void appExit() {
      sc.cmdExit();
      super.appExit();
   }

   /**
    * Creates a new instance of the {@link IConfigApp} for this app
    * @param uc
    * @return
    */
   public abstract IConfigApp createConfigApp(UCtx uc, C5Ctx c5, BOCtx bo);

   public abstract IConfigCoreFrameworkSwing createConfigCoreSwing(SwingCtx sc);

   public abstract IConfigCoreUiJ2se createConfigCoreUi(UCtx uc);

   public abstract IConfigCoreDrawSwing createConfigCoreDraw(UCtx uc);

   /**
    * Decides which swing wrapper to use when creating canvases.
    * 
    * <li> {@link CanvasOwnerDefaultSwing}
    * @param cuc TODO
    * 
    * @return {@link ICanvasOwner}
    */
   public abstract ICanvasOwner createWrapperManager(CoreFrameworkSwingCtx cuc);

   /**
    * The {@link CoreFrameworkCtx} created in the constructor
    */
   public CoreFrameworkCtx getCFC() {
      return csc;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "SwingLauncher");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "SwingLauncher");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }

   //#enddebug

}
