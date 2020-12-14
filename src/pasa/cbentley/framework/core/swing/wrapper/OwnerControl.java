package pasa.cbentley.framework.core.swing.wrapper;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.core.src4.logging.IDLog;
import pasa.cbentley.framework.core.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.coreui.src4.engine.WrapperAbstract;
import pasa.cbentley.framework.coreui.src4.interfaces.ICanvasOwner;

public class OwnerControl implements ICanvasOwner {

   protected final CoreFrameworkSwingCtx csc;

   public OwnerControl(CoreFrameworkSwingCtx csc) {
      this.csc = csc;
   }

   public void setTitle(WrapperAbstract wrapper, String title) {
      if(wrapper instanceof SwingCanvasWrapperBorderLayout) {
         SwingCanvasWrapperBorderLayout w = (SwingCanvasWrapperBorderLayout)wrapper;
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
      return new SwingCanvasWrapperBorderLayout(csc);
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
      return csc.getUCtx();
   }

   //#enddebug
   

}
