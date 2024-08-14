package pasa.cbentley.framework.core.framework.swing.ctx;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.logging.IStringable;

public class ObjectCFCSwing implements IStringable {

   protected CoreFrameworkSwingCtx cfc;

   public ObjectCFCSwing(CoreFrameworkSwingCtx cfc) {
      this.cfc = cfc;
   }
   
   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, ObjectCFCSwing.class, 26);
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ObjectCFCSwing.class);
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return cfc.getUC();
   }

   //#enddebug
   

}
