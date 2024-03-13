package pasa.cbentley.framework.core.swing.ctx;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.core.src4.logging.IStringable;

public class ObjectCFSwing implements IStringable {

   protected CoreFrameworkSwingCtx scc;

   public ObjectCFSwing(CoreFrameworkSwingCtx scc) {
      this.scc = scc;
   }
   
   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, ObjectCFSwing.class, 26);
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, ObjectCFSwing.class);
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return scc.getUC();
   }

   //#enddebug
   

}
