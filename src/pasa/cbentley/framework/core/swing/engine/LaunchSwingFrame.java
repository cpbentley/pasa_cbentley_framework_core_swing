package pasa.cbentley.framework.core.swing.engine;

import javax.swing.SwingUtilities;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.j2se.ctx.IConfigCoreFrameworkJ2SE;
import pasa.cbentley.framework.core.j2se.engine.LaunchJ2SE;
import pasa.cbentley.framework.core.src4.app.IConfigApp;
import pasa.cbentley.framework.core.src4.interfaces.ILauncherAppli;
import pasa.cbentley.framework.core.src4.interfaces.ILauncherHost;
import pasa.cbentley.framework.coreui.src4.interfaces.ICanvasOwner;
import pasa.cbentley.framework.coreui.swing.ctx.CoreUiSwingCtx;
import pasa.cbentley.framework.coreui.swing.wrapper.CanvasOwnerDefaultSwing;


/**
 * Host launcher that uses a {@link LaunchSwingFrame}. 
 * <br>
 * <br>
 * The class creates a {@link CanvasHostSwing} 
 * <br>
 * <br>
 * ActivityBridge equivalents
 * 
 * @author Charles-Philip Bentley
 *
 */
public abstract class LaunchSwingFrame extends LaunchSwingAbstract {


   /**
    * The {@link ILauncherAppli} is set afterwards with {@link LaunchJ2SE#startAppli(ILauncherAppli)}
    */
   public LaunchSwingFrame() {
      
   }


   public ICanvasOwner createWrapperManager(CoreUiSwingCtx cuc) {
      return new CanvasOwnerDefaultSwing(cuiSwingc);
   }

   
   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, "SwingLauncherFrame");
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   private void toStringPrivate(Dctx dc) {
      
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, "SwingLauncherFrame");
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   //#enddebug
   

}
