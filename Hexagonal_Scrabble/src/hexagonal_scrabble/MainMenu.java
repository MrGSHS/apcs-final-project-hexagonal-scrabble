/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexagonal_scrabble;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.swing.JFrame;

/**
 *
 * @author osimon8
 */
public class MainMenu extends javax.swing.JPanel {

    /**
     * Creates new form MainMenu
     */
    private Board b;
    private JFrame frame;
    //Hand h = new Hand();
    Tile t = new BlankTile (100,100);
    private double mouseX;
    private double mouseY;
    private int gameState;
    private LetterChooser c;
    private BlankTile selected;
    private Player currPlayer;
    private List<Player> players;
    private List<Word> currWords;
    public MainMenu() {
        selected = null;
        mouseX=0;
        mouseY=0;
        gameState = 0;
        initComponents();
        jComboBox1.setVisible(false);
        jPopupMenu1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        b = new Board(500,50);
        frame = new JFrame("Choose a Letter");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        c = new LetterChooser(this, frame, selected);
        frame.getContentPane().add(c);
        frame.pack();
        frame.setVisible(false);    
        players = new LinkedList<>();
        currWords = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jPopupMenu1.setMaximumSize(new java.awt.Dimension(100, 100));
        jPopupMenu1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPopupMenu1.setPreferredSize(new java.awt.Dimension(100, 100));
        jPopupMenu1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jPopupMenu1PopupMenuWillBecomeVisible(evt);
            }
        });

        setBackground(new java.awt.Color(125, 217, 255));
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1200, 700));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Hexagonal Scrabble");

        jLabel2.setText("Created by Owen Simon");

        jButton1.setText("Play");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 Players", "3 Players", "4 Players" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton2.setText("Shuffle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("End Turn");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Player: ");

        jLabel4.setText("Points: ");

        jButton4.setText("Recall");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(424, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(330, 330, 330)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(639, 639, 639))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel2))
                        .addGap(616, 616, 616))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 508, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(gameState==0){
            jLabel2.setVisible(false);
            jComboBox1.setVisible(true);
            jLabel1.setText("Setup Game");
            jButton1.setText("Next");
            gameState++;
        }
        else if(gameState==1){
            for(int i = 1; i<=jComboBox1.getSelectedIndex()+2; i++)
                players.add(new Player(i));
            currPlayer = players.get(0);
            jButton1.setVisible(false);
            jLabel2.setVisible(false);
            jComboBox1.setVisible(false);
            jLabel1.setVisible(false);
            jButton2.setVisible(true);
            jButton3.setVisible(true);
            jButton4.setVisible(true);
            gameState++;
        }
    }//GEN-LAST:event_jButton1MouseClicked
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        currWords = b.getWords();
        b.draw(g);
        if(currPlayer!=null)
            currPlayer.getHand().draw(g);
        //t.draw(g);
        jLabel3.setText((currPlayer!=null)?"Player: Player " + currPlayer.getNumber():"");
        jLabel4.setText((gameState==2 && currWords!=null)?"Points: " + b.getPoints():"");
        if(gameState == 2){
            if(currWords!=null){
                int sum=0;
                for(Word w : currWords)
                    sum+=w.points();
                jLabel4.setText("Points: " + sum);
            }
            else
               jLabel4.setText("Points: " + 0); 
        }
        else
           jLabel4.setText("");  
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        Point pos =this.getMousePosition();
        mouseX = pos.getX();
        mouseY = pos.getY();
       // System.out.println(b.contains(mouseX,mouseY));
        if(evt.getButton() == MouseEvent.BUTTON1){
            //System.out.println(Dictionary.getInstance().contains("pizza"));
//            if(t.contains(mouseX,mouseY)){
//                if(t.getPoints()==0 && t.getTile()==null){//is a blank tile
//                    selected = (BlankTile)t;
//                    c.setTile(selected);
//                    frame.setVisible(true);
//                }
//            }
            if(currPlayer !=null) {
                Hand h = currPlayer.getHand();
                Tile t = currPlayer.getHand().contains(mouseX,mouseY);
                if(h != null && t != null){
                    //System.out.println(t);
                    boolean set=t.getSelected();
                    h.deselect();
                    t.setSelected(!set);
                    repaint();
                    if(t.getPoints()==0 && t.getTile()==null){//is a blank tile
                       frame.setVisible(true);
                       selected = (BlankTile)t;
                       c.setTile(selected);

                   }
               }
            }
            Tile sel= null;
            if (currPlayer!=null && currPlayer.getHand()!=null){
                sel = currPlayer.getHand().getSelected();
                if(b.contains(mouseX,mouseY)!=null){
                    if(sel!=null && b.contains(mouseX,mouseY).getTile()==null &&
                       b.oneDirection()){
                        currPlayer.getHand().deselect();
                        currPlayer.getHand().remove(sel.getHandIndex());
                        b.contains(mouseX,mouseY).setTile(sel);
                        b.contains(mouseX,mouseY);
                        sel=null;
                    }
                    else if(sel==null && b.contains(mouseX,mouseY).getTile()!=null
                        && !b.contains(mouseX,mouseY).getTile().isPermanent()){
                        currPlayer.getHand().add(b.contains(mouseX, mouseY).getTile());
                        b.contains(mouseX,mouseY).setTile(null);
                        currPlayer.getHand().deselect();
                    }
                    repaint();
                }
            }
            
        }
        else if(evt.getButton() == MouseEvent.BUTTON3){
            if(currPlayer !=null) {
                Hand h = currPlayer.getHand();
                Tile t = currPlayer.getHand().contains(mouseX,mouseY);
                if(t!=null && t.contains(mouseX,mouseY)){
                    if(t.getPoints()==0 && t.getTile()!=null){//is a blank tile
                        t.setTile(null);
                        repaint();
                    }
                }
            }
        }
    }//GEN-LAST:event_formMouseClicked

    private void jPopupMenu1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jPopupMenu1PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jPopupMenu1PopupMenuWillBecomeVisible

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        currPlayer.getHand().deselect();
        currPlayer = (currPlayer.getNumber()==players.size())?players.get(0):players.get(currPlayer.getNumber());
        currPlayer.getHand().fill();
        b.makePermanent();
        repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        currPlayer.getHand().shuffle();
        repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        List<Tile> tiles = b.recall();
        currPlayer.getHand().add(tiles);
        repaint();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}
