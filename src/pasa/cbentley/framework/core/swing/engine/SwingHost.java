package pasa.cbentley.framework.core.swing.engine;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.j2se.engine.HostCoreJ2SE;
import pasa.cbentley.framework.core.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.coreui.src4.ctx.CoreUiCtx;
import pasa.cbentley.framework.coreui.src4.tech.ITechHostUI;

public class SwingHost extends HostCoreJ2SE {

   public SwingHost(CoreFrameworkSwingCtx csc) {
      super(csc);
   }

   public int getHostInt(int dataID) {
      switch (dataID) {
         default:
            return super.getHostInt(dataID);
      }
   }

   public String getHostString(int dataID) {
      switch (dataID) {
         case ITechHostUI.DATA_ID_STR_04_PLATFORM:
            return "Swing";
         default:
            return super.getHostString(dataID);
      }
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, SwingHost.class, 35);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, SwingHost.class);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug

}
