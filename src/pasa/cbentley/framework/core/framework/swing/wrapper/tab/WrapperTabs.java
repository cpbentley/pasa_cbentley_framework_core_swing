package pasa.cbentley.framework.core.framework.swing.wrapper.tab;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.swing.imytab.TabbedBentleyPanel;
import pasa.cbentley.swing.panels.PreferenceTab;
import pasa.cbentley.swing.window.CBentleyFrame;

public class WrapperTabs extends TabbedBentleyPanel {
   private CBentleyFrame frame;

   private PreferenceTab tabPreferences;

   public WrapperTabs(CoreFrameworkSwingCtx cfc, String title) {
      super(cfc.getSwingCtx(), title);

      frame = new CBentleyFrame(cfc.getSwingCtx());

   }

   public void disposeTab() {
      tabPreferences = null;
   }

   public void initTabs() {

      addMyTab(tabPreferences);

   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, WrapperTabs.class, 35);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, WrapperTabs.class, 35);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

}