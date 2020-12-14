package pasa.cbentley.framework.core.swing.engine;

import java.awt.Component;

import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.core.j2se.ctx.J2seCtx;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src5.ctx.C5Ctx;
import pasa.cbentley.framework.core.j2se.ctx.ConfigCoreFrameworkJ2SE;
import pasa.cbentley.framework.core.j2se.ctx.IConfigCoreFrameworkJ2SE;
import pasa.cbentley.framework.core.src4.app.IConfigApp;
import pasa.cbentley.framework.core.src4.ctx.CoreFrameworkCtx;
import pasa.cbentley.framework.core.src4.interfaces.ILauncherAppli;
import pasa.cbentley.framework.core.swing.ctx.ConfigCoreFrameworkSwingDefault;
import pasa.cbentley.framework.core.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.swing.ctx.IConfigCoreFrameworkSwing;
import pasa.cbentley.framework.coredata.src5.ctx.IConfigCoreData5;
import pasa.cbentley.framework.coredraw.swing.ctx.IConfigCoreDrawSwing;
import pasa.cbentley.framework.coreio.src5.ctx.IConfigCoreIO5;
import pasa.cbentley.framework.coreui.j2se.ctx.IConfigCoreUiJ2se;
import pasa.cbentley.framework.coreui.src4.interfaces.ICanvasOwner;
import pasa.cbentley.framework.coreui.swing.ctx.CoreUiSwingCtx;
import pasa.cbentley.framework.coreui.swing.engine.CanvasSwing;
import pasa.cbentley.swing.ctx.SwingCtx;

/**
 * Launcher for a Drawable used by Swing code
 * @author Charles Bentley
 *
 */
public class LaunchSwingPanel extends LaunchSwingAbstract {

   private ILauncherAppli launcher;

   private IConfigApp     config;

   public LaunchSwingPanel() {
   }

   public LaunchSwingPanel(ILauncherAppli launcher) {
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
      return (CanvasSwing) cuiSwingc.getCanvasRoot();
   }

   public IConfigCoreFrameworkJ2SE createConfigCoreJ2SE(J2seCtx j2c) {
      ConfigCoreFrameworkJ2SE c = new ConfigCoreFrameworkSwingDefault((SwingCtx) j2c);
      return c;
   }

   public Component getCanvasComponent() {
      return getCanvasSwing().getRealCanvas();
   }

   protected ILauncherAppli createLauncher(UCtx uc) {
      return launcher;
   }

   public IConfigApp createConfigApp(UCtx uc,C5Ctx c5, BOCtx bo) {
      return config;
   }

   public ICanvasOwner createWrapperManager(CoreFrameworkSwingCtx csc) {
      // TODO Auto-generated method stub
      return null;
   }

   public IConfigCoreFrameworkJ2SE createConfigCoreJ2SE(UCtx uc) {
      // TODO Auto-generated method stub
      return null;
   }

   public IConfigCoreUiJ2se createConfigCoreUi(UCtx uc) {
      // TODO Auto-generated method stub
      return null;
   }

   public IConfigCoreDrawSwing createConfigCoreDraw(UCtx uc) {
      // TODO Auto-generated method stub
      return null;
   }

   public IConfigCoreFrameworkSwing createConfigCoreSwing(SwingCtx sc) {
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
