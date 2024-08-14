package pasa.cbentley.framework.core.framework.swing.engine;

import pasa.cbentley.core.src4.ctx.UCtx;
import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.framework.src4.interfaces.ILauncherHost;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.j2se.engine.CoordinatorJ2se;

/**
 * Coordinates the {@link ILauncherHost}.
 * 
 * In Swing, we must start a GUI app in the Swing thread
 * 
 * Contains generic Launch concerns, like how to start in the UI thread
 * 
 * App specific launch stuff goes into the {@link LaunchSwingAbstract} implementation.
 * 
 * @author Charles Bentley
 *
 */
public class CoordinatorSwing extends CoordinatorJ2se {

   protected final CoreFrameworkSwingCtx scc;

   protected CoordinatorSwing(CoreFrameworkSwingCtx scc, ILauncherHost launcherHost) {
      super(scc, launcherHost);
      this.scc = scc;
   }

   public boolean subLoadLastState() {
      // TODO Auto-generated method stub
      return false;
   }

   protected void startUIThread() {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            
            initUIThreadInside();
         }
      });
   }

   protected void subExitJ2SE() {
   }

   protected void subResumeJ2SE() {
   }

   protected void subPauseJ2SE() {
   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, CoordinatorSwing.class, 54);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, CoordinatorSwing.class);
      super.toString1Line(dc.sup1Line());
   }
   //#enddebug

}
