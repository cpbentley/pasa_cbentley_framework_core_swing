package pasa.cbentley.framework.core.framework.swing.ctx;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.framework.core.draw.swing.ctx.ConfigCoreDrawSwingDef;
import pasa.cbentley.framework.core.j2se.ctx.ConfigCoreFrameworkJ2SE;
import pasa.cbentley.framework.core.ui.j2se.ctx.IConfigCoreUiJ2se;
import pasa.cbentley.framework.core.ui.src4.ctx.IConfigCoreUi;
import pasa.cbentley.framework.core.ui.swing.ctx.ConfigCoreUiSwingDef;
import pasa.cbentley.framework.coredraw.src4.ctx.IConfigCoreDraw;

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

   public IConfigCoreUi getConfigUI() {
      return configUI;
   }


}
