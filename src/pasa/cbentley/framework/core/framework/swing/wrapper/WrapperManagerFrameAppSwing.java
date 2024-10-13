package pasa.cbentley.framework.core.framework.swing.wrapper;

import pasa.cbentley.byteobjects.src4.core.ByteObject;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.j2se.wrapper.WrapperManagerFrameAppJ2se;
import pasa.cbentley.framework.core.ui.src4.interfaces.IWrapperManager;
import pasa.cbentley.framework.core.ui.src4.wrapper.WrapperAbstract;
import pasa.cbentley.framework.core.ui.swing.wrapper.WrapperSwingTopFrame;

/**
 * Canvas owner creates {@link WrapperSwingTopFrame}.
 * 
 * He is unaware of life cycle.
 * 
 * @author Charles Bentley
 *
 */
public class WrapperManagerFrameAppSwing extends WrapperManagerFrameAppJ2se implements IWrapperManager {

   protected final CoreFrameworkSwingCtx cfc;

   public WrapperManagerFrameAppSwing(CoreFrameworkSwingCtx cfc) {
      super(cfc);
      this.cfc = cfc;

      //#debug
      toDLog().pCreate("", this, WrapperManagerFrameAppSwing.class, "Created@32", LVL_03_FINEST, true);

   }

   public WrapperAbstract createNewWrapper(ByteObject tech) {
      WrapperSwingTopFrameApp wrapper = new WrapperSwingTopFrameApp(cfc);
      return wrapper;
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, WrapperManagerFrameAppSwing.class, 67);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, WrapperManagerFrameAppSwing.class, 67);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

}
