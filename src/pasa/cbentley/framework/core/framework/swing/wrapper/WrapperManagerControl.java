package pasa.cbentley.framework.core.framework.swing.wrapper;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.ui.src4.engine.CanvasHostAbstract;
import pasa.cbentley.framework.core.ui.src4.engine.WrapperAbstract;
import pasa.cbentley.framework.core.ui.src4.interfaces.IWrapperManager;

public class WrapperManagerControl implements IWrapperManager {

   protected final CoreFrameworkSwingCtx csc;

   public WrapperManagerControl(CoreFrameworkSwingCtx csc) {
      this.csc = csc;
   }

   public void setTitle(WrapperAbstract wrapper, String title) {
      if(wrapper instanceof WrapperBorderLayoutSwing) {
         WrapperBorderLayoutSwing w = (WrapperBorderLayoutSwing)wrapper;
         w.setTitle(title);
      } else {
         throw new IllegalArgumentException();
      }
   }

   public boolean setSize(WrapperAbstract wrapper, int w, int h) {
      //we can try grow it 
      return false;
   }

   public boolean setPosition(WrapperAbstract wrapper, int x, int y) {
      return false;
   }

   public WrapperAbstract createNewWrapper(ByteObject tech) {
      return new WrapperBorderLayoutSwing(csc);
   }
   
   //#mdebug
   public IDLog toDLog() {
      return toStringGetUCtx().toDLog();
   }

   public String toString() {
      return Dctx.toString(this);
   }

   public void toString(Dctx dc) {
      dc.root(this, "WrapperManagerControl");
      toStringPrivate(dc);
   }

   public String toString1Line() {
      return Dctx.toString1Line(this);
   }

   private void toStringPrivate(Dctx dc) {

   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "WrapperManagerControl");
      toStringPrivate(dc);
   }

   public UCtx toStringGetUCtx() {
      return csc.getUC();
   }

   public CanvasHostAbstract createCanvasHost(WrapperAbstract wrapper, ByteObject canvasTech) {
      // TODO Auto-generated method stub
      return null;
   }

   //#enddebug
   

}
