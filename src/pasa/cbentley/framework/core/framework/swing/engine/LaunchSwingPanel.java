package pasa.cbentley.framework.core.framework.swing.engine;

import java.awt.Component;

import pasa.cbentley.core.src4.ctx.IConfigU;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.framework.core.data.src5.ctx.ConfigCoreData5Default;
import pasa.cbentley.framework.core.data.src5.ctx.IConfigCoreData5;
import pasa.cbentley.framework.core.draw.swing.ctx.ConfigCoreDrawSwingDef;
import pasa.cbentley.framework.core.draw.swing.ctx.IConfigCoreDrawSwing;
import pasa.cbentley.framework.core.framework.src4.app.IConfigApp;
import pasa.cbentley.framework.core.framework.src4.ctx.CoreFrameworkCtx;
import pasa.cbentley.framework.core.framework.src4.interfaces.ICreatorAppli;
import pasa.cbentley.framework.core.framework.src4.interfaces.IDependencies;
import pasa.cbentley.framework.core.framework.swing.ctx.ConfigCoreFrameworkSwingDef;
import pasa.cbentley.framework.core.framework.swing.ctx.ConfigCoreFrameworkSwingDefault;
import pasa.cbentley.framework.core.framework.swing.ctx.IConfigCoreFrameworkSwing;
import pasa.cbentley.framework.core.io.src5.ctx.ConfigCoreIO5Def;
import pasa.cbentley.framework.core.io.src5.ctx.IConfigCoreIO5;
import pasa.cbentley.framework.core.j2se.ctx.CoreFrameworkJ2seCtx;
import pasa.cbentley.framework.core.j2se.ctx.IConfigCoreFrameworkJ2se;
import pasa.cbentley.framework.core.ui.src4.interfaces.IWrapperManager;
import pasa.cbentley.framework.core.ui.swing.ctx.ConfigCoreUiSwingDef;
import pasa.cbentley.framework.core.ui.swing.ctx.CoreUiSwingCtx;
import pasa.cbentley.framework.core.ui.swing.ctx.IConfigCoreUiSwing;
import pasa.cbentley.framework.core.ui.swing.engine.CanvasHostSwing;
import pasa.cbentley.framework.core.ui.swing.wrapper.WrapperManagerPanelSwing;

/**
 * Launcher for a single Drawable App that is used by Swing code.
 * 
 * @author Charles Bentley
 *
 */
public class LaunchSwingPanel extends LaunchSwingAbstract {

   private IConfigApp    config;

   private ICreatorAppli creatorAppli;

   private IDependencies dependencies;

   
   public LaunchSwingPanel(IConfigU configU) {
      super(configU);
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
      return new ConfigCoreFrameworkSwingDef(uc);
   }

   public IConfigCoreUiSwing createConfigCoreUi(UCtx uc) {
      return new ConfigCoreUiSwingDef(uc);
   }

   protected ICreatorAppli createCreator(UCtx uc) {
      return creatorAppli;
   }

   public IWrapperManager createWrapperManager(CoreFrameworkJ2seCtx cfc) {
      return new WrapperManagerPanelSwing((CoreUiSwingCtx) cfc.getCoreUiJ2seCtx());
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

   public IDependencies getDependencies() {
      if (dependencies == null) {
         throw new RuntimeException("Dependencings have not been set on this launcher");
      }
      return dependencies;
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

}
