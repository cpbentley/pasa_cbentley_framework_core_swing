package pasa.cbentley.framework.core.framework.swing.engine;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.i8n.IStringProducer;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.data.src5.ctx.ConfigCoreData5Default;
import pasa.cbentley.framework.core.data.src5.ctx.IConfigCoreData5;
import pasa.cbentley.framework.core.draw.swing.ctx.ConfigCoreDrawSwingDef;
import pasa.cbentley.framework.core.draw.swing.ctx.IConfigCoreDrawSwing;
import pasa.cbentley.framework.core.framework.src4.ctx.CoreFrameworkCtx;
import pasa.cbentley.framework.core.framework.src4.i8n.StringProducerBasic;
import pasa.cbentley.framework.core.framework.swing.ctx.ConfigCoreFrameworkSwingDefault;
import pasa.cbentley.framework.core.framework.swing.ctx.IConfigCoreFrameworkSwing;
import pasa.cbentley.framework.core.io.src5.ctx.ConfigCoreIO5Def;
import pasa.cbentley.framework.core.io.src5.ctx.IConfigCoreIO5;
import pasa.cbentley.framework.core.ui.swing.ctx.ConfigCoreUiSwingDef;
import pasa.cbentley.framework.core.ui.swing.ctx.IConfigCoreUiSwing;

/**
 * Only uses default Configs for Swing
 * @author Charles Bentley
 *
 */
public abstract class LaunchSwingAbstractDefConfig extends LaunchSwingAbstract {

   public LaunchSwingAbstractDefConfig() {
      super();
   }

   public void setOSSpecifics(CoreFrameworkCtx hoc) {

   }

   public IStringProducer createStringProducer(CoreFrameworkCtx cfc) {
      return new StringProducerBasic(cfc);
   }

  

   public IConfigCoreUiSwing createConfigCoreUi(UCtx uc) {
      return new ConfigCoreUiSwingDef(uc);
   }

   public IConfigCoreDrawSwing createConfigCoreDraw(UCtx uc) {
      return new ConfigCoreDrawSwingDef(uc);
   }

   public IConfigCoreFrameworkSwing createConfigCoreSwing(UCtx uc) {
      return new ConfigCoreFrameworkSwingDefault(uc);
   }

   public IConfigCoreData5 createConfigCoreData5(UCtx uc) {
      return new ConfigCoreData5Default(uc);
   }

   public IConfigCoreIO5 createConfigCoreIO(UCtx uc) {
      return new ConfigCoreIO5Def(uc);
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
