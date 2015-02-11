/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrace;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Walid
 */
public class Accept extends javax.swing.JFrame {

    /**
     * Creates new form Accept
     */
    Timer timer;
    boolean acp = false;
    public Accept() {
        try {
            c = new Connection();
            initComponents();
            timer = new Timer();
            timer.schedule(new Accept.RemindTask(), 0, //initial delay
                    1 * 100);
        } catch (SQLException ex) {
            Logger.getLogger(Accept.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    class RemindTask extends TimerTask {

        public void run() {
            try  {
                Statement t = c.con.createStatement();
                t.executeUpdate("update player set online = 1 where id_player = "+player());
                Statement st = c.con.createStatement();
                ResultSet r = st.executeQuery("SELECT accepted From game where idp1 = "+player());
                r.next();
                
                if(r.getInt("accepted") == 1 ){
                    acp();
                new MainGame().setVisible(true); 
                timer.cancel();
                timer.purge();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Accept.class.getName()).log(Level.SEVERE, null, ex);
            }
    }}
    public  void acp(){
        this.dispose();
    }
public int player(){
     int id = 1;
        try{
            FileReader getNameP;
            getNameP = new FileReader("player.txt");
            BufferedReader br = new BufferedReader(getNameP);
           String PlayerName = br.readLine();
            getNameP.close();
            Statement st = c.con.createStatement();
            String S = "SELECT * from player where name = '" + PlayerName + "'";
            ResultSet r =  st.executeQuery(S);
            r.next();
            id = r.getInt("id_player");
     }catch (FileNotFoundException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Pick.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
             
 }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Wait for Accepting ...");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 430, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 250);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Accept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accept().setVisible(true);
            }
        });
    }
Connection c;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
