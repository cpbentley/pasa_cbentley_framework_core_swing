package pasa.cbentley.framework.core.framework.swing.engine;

import java.awt.Component;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.framework.core.data.src5.ctx.IConfigCoreData5;
import pasa.cbentley.framework.core.draw.swing.ctx.IConfigCoreDrawSwing;
import pasa.cbentley.framework.core.framework.src4.app.IConfigApp;
import pasa.cbentley.framework.core.framework.src4.ctx.CoreFrameworkCtx;
import pasa.cbentley.framework.core.framework.src4.interfaces.ICreatorAppli;
import pasa.cbentley.framework.core.framework.swing.ctx.ConfigCoreFrameworkSwingDefault;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.framework.swing.ctx.IConfigCoreFrameworkSwing;
import pasa.cbentley.framework.core.io.src5.ctx.IConfigCoreIO5;
import pasa.cbentley.framework.core.j2se.ctx.IConfigCoreFrameworkJ2SE;
import pasa.cbentley.framework.core.ui.src4.interfaces.IWrapperManager;
import pasa.cbentley.framework.core.ui.swing.ctx.IConfigCoreUiSwing;
import pasa.cbentley.framework.core.ui.swing.engine.CanvasSwing;

/**
 * Launcher for a Drawable used by Swing code
 * @author Charles Bentley
 *
 */
public class LaunchSwingPanel extends LaunchSwingAbstract {

   private ICreatorAppli launcher;

   private IConfigApp     config;

   public LaunchSwingPanel() {
   }

   public LaunchSwingPanel(ICreatorAppli launcher) {
      this.launcher = launcher;
   }

   public void setOSSpecifics(CoreFrameworkCtx hoc) {
      // TODO Auto-generated method stub

   }

   /**
    * Returns the main canvas swing used
    * @return
    */
   public CanvasSwing getCanvasSwing() {
      return (CanvasSwing) getCFCSwing().getCoreUiSwingCtx().getCanvasRootHost();
   }

   public IConfigCoreFrameworkJ2SE createConfigCoreJ2SE(UCtx uc) {
      return new ConfigCoreFrameworkSwingDefault(uc);
   }

   public Component getCanvasComponent() {
      return getCanvasSwing().getRealCanvas();
   }

   protected ICreatorAppli createCreator(UCtx uc) {
      return launcher;
   }

   public IConfigApp createConfigApp(UCtx uc) {
      return config;
   }

   public IWrapperManager createWrapperManager(CoreFrameworkSwingCtx csc) {
      // TODO Auto-generated method stub
      return null;
   }


   public IConfigCoreUiSwing createConfigCoreUi(UCtx uc) {
      // TODO Auto-generated method stub
      return null;
   }

   public IConfigCoreDrawSwing createConfigCoreDraw(UCtx uc) {
      // TODO Auto-generated method stub
      return null;
   }

   public IConfigCoreFrameworkSwing createConfigCoreSwing(UCtx uc) {
      // TODO Auto-generated method stub
      return null;
   }

   public IConfigCoreData5 createConfigCoreData5(UCtx uc) {
      // TODO Auto-generated method stub
      return null;
   }

   public IConfigCoreIO5 createConfigCoreIO(UCtx uc) {
      // TODO Auto-generated method stub
      return null;
   }

}
