/*
 * (c) 2018-2019 Charles-Philip Bentley
 * This code is licensed under CC by-nc-nd 4.0 (see LICENSE.txt for details)
 * Contact author for uses outside of the NonCommercial-NoDerivatives clauses.   
 */
package pasa.cbentley.framework.core.framework.swing.wrapper.tab;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.framework.core.framework.swing.ctx.CoreFrameworkSwingCtx;
import pasa.cbentley.framework.core.ui.j2se.engine.WrapperAbstractJ2se;
import pasa.cbentley.framework.core.ui.src4.engine.CanvasHostAbstract;
import pasa.cbentley.framework.core.ui.src4.interfaces.IWrapperManager;
import pasa.cbentley.swing.window.CBentleyFrame;

public class WrapperTabPane extends WrapperAbstractJ2se {

   private CBentleyFrame frame;

   public WrapperTabPane(CoreFrameworkSwingCtx cfc) {
      super(cfc.getCoreUiJ2seCtx());

      frame = new CBentleyFrame(cfc.getSwingCtx());

   }

   public void canvasHide() {
      // TODO Auto-generated method stub

   }

   public void canvasShow() {
      // TODO Auto-generated method stub

   }

   public int getX() {
      // TODO Auto-generated method stub
      return 0;
   }

   public int getY() {
      // TODO Auto-generated method stub
      return 0;
   }

   public boolean isContained() {
      // TODO Auto-generated method stub
      return false;
   }

   public void setCanvasHost(CanvasHostAbstract canvas) {
      // TODO Auto-generated method stub

   }

   public void setDefaultStartPosition() {
      // TODO Auto-generated method stub

   }

   public void setFullScreenMode(boolean mode) {
      // TODO Auto-generated method stub

   }

   public void setIcon(String str) {
      // TODO Auto-generated method stub

   }

   public void setPosition(int x, int y) {
      // TODO Auto-generated method stub

   }

   public void setSize(int w, int h) {
      // TODO Auto-generated method stub

   }

   public void setTitle(String str) {
      // TODO Auto-generated method stub

   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, WrapperTabPane.class, 35);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, WrapperTabPane.class, 35);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

}