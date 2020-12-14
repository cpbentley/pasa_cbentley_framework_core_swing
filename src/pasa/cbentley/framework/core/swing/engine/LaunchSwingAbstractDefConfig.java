package pasa.cbentley.framework.core.swing.engine;

import pasa.cbentley.byteobjects.src4.ctx.BOCtx;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.i8n.IStringProducer;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src5.ctx.C5Ctx;
import pasa.cbentley.framework.core.src4.app.IConfigApp;
import pasa.cbentley.framework.core.src4.ctx.CoreFrameworkCtx;
import pasa.cbentley.framework.core.src4.i8n.StringProducerBasic;
import pasa.cbentley.framework.core.src4.interfaces.ILauncherAppli;
import pasa.cbentley.framework.core.swing.ctx.ConfigCoreFrameworkSwingDefault;
import pasa.cbentley.framework.core.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.swing.ctx.IConfigCoreFrameworkSwing;
import pasa.cbentley.framework.core.swing.engine.LaunchSwingAbstract;
import pasa.cbentley.framework.core.swing.wrapper.CanvasOwnerSwingFrameApp;
import pasa.cbentley.framework.coredata.src5.ctx.ConfigCoreData5Default;
import pasa.cbentley.framework.coredata.src5.ctx.IConfigCoreData5;
import pasa.cbentley.framework.coredraw.swing.ctx.ConfigCoreDrawSwingDef;
import pasa.cbentley.framework.coredraw.swing.ctx.IConfigCoreDrawSwing;
import pasa.cbentley.framework.coreio.src5.ctx.ConfigIO5Def;
import pasa.cbentley.framework.coreio.src5.ctx.IConfigCoreIO5;
import pasa.cbentley.framework.coreui.j2se.ctx.IConfigCoreUiJ2se;
import pasa.cbentley.framework.coreui.src4.interfaces.ICanvasOwner;
import pasa.cbentley.framework.coreui.swing.ctx.ConfigCoreUISwingDef;
import pasa.cbentley.swing.ctx.SwingCtx;

public abstract class LaunchSwingAbstractDefConfig extends LaunchSwingAbstract {

   public LaunchSwingAbstractDefConfig() {
      super();
   }

   public void setOSSpecifics(CoreFrameworkCtx hoc) {

   }

   public IStringProducer createStringProducer(CoreFrameworkCtx cfc) {
      return new StringProducerBasic(cfc);
   }

   public ICanvasOwner createWrapperManager(CoreFrameworkSwingCtx csc) {
      return new CanvasOwnerSwingFrameApp(csc);
   }

   public IConfigCoreUiJ2se createConfigCoreUi(UCtx uc) {
      return new ConfigCoreUISwingDef(uc);
   }

   public IConfigCoreDrawSwing createConfigCoreDraw(UCtx uc) {
      return new ConfigCoreDrawSwingDef(uc);
   }

   public IConfigCoreFrameworkSwing createConfigCoreSwing(SwingCtx sc) {
      return new ConfigCoreFrameworkSwingDefault(sc);
   }

   public IConfigCoreData5 createConfigCoreData5(UCtx uc) {
      return new ConfigCoreData5Default(uc);
   }

   public IConfigCoreIO5 createConfigCoreIO(UCtx uc) {
      return new ConfigIO5Def(c5);
   }


   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, LaunchSwingAbstractDefConfig.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, LaunchSwingAbstractDefConfig.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   

   

}
