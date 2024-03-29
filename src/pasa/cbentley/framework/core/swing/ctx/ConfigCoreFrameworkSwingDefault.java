package pasa.cbentley.framework.core.swing.ctx;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.framework.core.j2se.ctx.ConfigCoreFrameworkJ2SE;
import pasa.cbentley.framework.coredraw.src4.ctx.IConfigCoreDraw;
import pasa.cbentley.framework.coredraw.swing.ctx.ConfigCoreDrawSwingDef;
import pasa.cbentley.framework.coreui.j2se.ctx.IConfigCoreUiJ2se;
import pasa.cbentley.framework.coreui.src4.ctx.IConfigCoreUI;
import pasa.cbentley.framework.coreui.swing.ctx.ConfigCoreUiSwingDef;

public class ConfigCoreFrameworkSwingDefault extends ConfigCoreFrameworkJ2SE implements IConfigCoreFrameworkSwing {

   private ConfigCoreDrawSwingDef configDraw;

   private ConfigCoreUiSwingDef   configUI;

   public ConfigCoreFrameworkSwingDefault(UCtx uc) {
      super(uc);
      configDraw = new ConfigCoreDrawSwingDef(uc);
      configUI = new ConfigCoreUiSwingDef(uc);
   }

   public IConfigCoreUiJ2se getConfigCoreUiJ2se() {
      return configUI;
   }

   public IConfigCoreDraw getConfigDraw() {
      return configDraw;
   }

   public IConfigCoreUI getConfigUI() {
      return configUI;
   }


}
