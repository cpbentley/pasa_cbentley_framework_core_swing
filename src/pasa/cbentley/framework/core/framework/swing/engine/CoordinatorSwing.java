package pasa.cbentley.framework.core.framework.swing.engine;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.framework.src4.engine.CoordinatorAbstract;
import pasa.cbentley.framework.core.framework.src4.interfaces.ILauncherHost;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.j2se.engine.CoordinatorJ2se;
import pasa.cbentley.framework.core.ui.swing.ctx.CoreUiSwingCtx;

/**
 * {@link CoordinatorAbstract} that  coordinates application in a Swing setting.  
 * 
 * It requires the {@link ILauncherHost}.
 * 
 * <p>
 * In Swing, we must start a GUI app in the Swing thread
 * Contains generic Launch concerns, like how to start in the UI thread
 * App specific launch stuff goes into the {@link LaunchSwingAbstract} implementation.
 * </p>
 * 
 * 
 * @see CoordinatorAbstract
 * 
 * @author Charles Bentley
 *
 */
public class CoordinatorSwing extends CoordinatorJ2se {

   protected final CoreFrameworkSwingCtx scc;

   protected CoordinatorSwing(CoreFrameworkSwingCtx scc, ILauncherHost launcherHost) {
      super(scc, launcherHost);
      this.scc = scc;

      //#debug
      toDLog().pCreate("", this, CoordinatorSwing.class, "Created@30", LVL_04_FINER, true);

   }
   
   public CoreUiSwingCtx getCUCSwing() {
      return scc.getCoreUiSwingCtx();
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

   public boolean subLoadLastState() {
      // TODO Auto-generated method stub
      return false;
   }

   protected void subPauseJ2SE() {
   }

   protected void subResumeJ2SE() {
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
