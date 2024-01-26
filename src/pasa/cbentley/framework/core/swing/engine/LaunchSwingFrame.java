package pasa.cbentley.framework.core.swing.engine;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.j2se.engine.LaunchJ2SE;
import pasa.cbentley.framework.core.src4.interfaces.ILauncherAppli;
import pasa.cbentley.framework.core.swing.ctx.ConfigCoreFrameworkSwingDef;
import pasa.cbentley.framework.core.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.swing.ctx.IConfigCoreFrameworkSwing;
import pasa.cbentley.framework.coredraw.swing.ctx.ConfigCoreDrawSwingDef;
import pasa.cbentley.framework.coredraw.swing.ctx.IConfigCoreDrawSwing;
import pasa.cbentley.framework.coreio.src5.ctx.ConfigCoreIO5Def;
import pasa.cbentley.framework.coreio.src5.ctx.IConfigCoreIO5;
import pasa.cbentley.framework.coreui.j2se.ctx.IConfigCoreUiJ2se;
import pasa.cbentley.framework.coreui.src4.interfaces.IWrapperManager;
import pasa.cbentley.framework.coreui.swing.ctx.ConfigCoreUISwingDef;
import pasa.cbentley.framework.coreui.swing.wrapper.CanvasOwnerDefaultSwing;

/**
 * {@link LaunchSwingAbstract} that uses a frame canvas owner {@link IWrapperManager}.
 * <br>
 * With a preset of configurations
 *  
 * @author Charles-Philip Bentley
 *
 */
public abstract class LaunchSwingFrame extends LaunchSwingAbstract {

   /**
    * The {@link ILauncherAppli} is set afterwards with {@link LaunchJ2SE#startAppli(ILauncherAppli)}
    */
   public LaunchSwingFrame() {
      super();
   }

   public LaunchSwingFrame(CoreFrameworkSwingCtx cfc) {
      super(cfc);
   }

   public IConfigCoreFrameworkSwing createConfigCoreSwing(UCtx uc) {
      return new ConfigCoreFrameworkSwingDef(uc);
   }

   public IConfigCoreUiJ2se createConfigCoreUi(UCtx uc) {
      return new ConfigCoreUISwingDef(uc);
   }

   public IConfigCoreDrawSwing createConfigCoreDraw(UCtx uc) {
      return new ConfigCoreDrawSwingDef(uc);
   }

   public IWrapperManager createWrapperManager(CoreFrameworkSwingCtx cfc) {
      return new CanvasOwnerDefaultSwing(cfc.getCoreUiSwingCtx());
   }

   public IConfigCoreIO5 createConfigCoreIO(UCtx uc) {
      return new ConfigCoreIO5Def(uc);
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, LaunchSwingFrame.class, 43);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, LaunchSwingFrame.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
