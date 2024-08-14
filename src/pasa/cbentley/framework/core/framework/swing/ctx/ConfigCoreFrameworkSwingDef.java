package pasa.cbentley.framework.core.framework.swing.ctx;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.j2se.ctx.ConfigCoreFrameworkJ2SE;

public class ConfigCoreFrameworkSwingDef extends ConfigCoreFrameworkJ2SE implements IConfigCoreFrameworkSwing {

   public ConfigCoreFrameworkSwingDef(UCtx uc) {
      super(uc);
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, ConfigCoreFrameworkSwingDef.class, "@line5");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ConfigCoreFrameworkSwingDef.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
