package pasa.cbentley.framework.core.framework.swing.wrapper.tab;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import pasa.cbentley.core.src4.logging.Dctx;
import pasa.cbentley.swing.ctx.SwingCtx;
import pasa.cbentley.swing.imytab.AbstractMyTab;
import pasa.cbentley.swing.widgets.b.BButton;

public class MyTabAppli extends AbstractMyTab implements ActionListener {

   private BButton  butClear;

   private BButton  butRefresh;

   private BButton  butSave;

   private TextArea textArea;

   public MyTabAppli(SwingCtx sc) {
      super(sc, "preferences");
   }

   public void actionPerformed(ActionEvent e) {

   }

   public void disposeTab() {

   }

   public void initTab() {
      this.setLayout(new BorderLayout());

      JPanel north = new JPanel();

      butSave = new BButton(sc, this);
      butSave.setTextKey("but.save");
      north.add(butSave);

      butClear = new BButton(sc, this);
      butClear.setTextKey("but.clear");
      north.add(butClear);

      butRefresh = new BButton(sc, this);
      butRefresh.setTextKey("but.refresh");
      north.add(butRefresh);

      textArea = new TextArea();

      this.add(textArea, BorderLayout.CENTER);
      this.add(north, BorderLayout.NORTH);

   }

   public void tabGainFocus() {
   }

   public void tabLostFocus() {

   }

   //#mdebug
   public void toString(Dctx dc) {
      dc.root(this, MyTabAppli.class, 117);
      toStringPrivate(dc);
      super.toString(dc.sup());
   }

   public void toString1Line(Dctx dc) {
      dc.root1Line(this, MyTabAppli.class, 117);
      toStringPrivate(dc);
      super.toString1Line(dc.sup1Line());
   }

   private void toStringPrivate(Dctx dc) {

   }
   //#enddebug

}
