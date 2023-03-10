package view;

import controller.CircusWorld;
import controller.EasyStrategy;
import controller.GameController;
import controller.HardStrategy;
import controller.MediumStrategy;

import controller.Strategy;
import eg.edu.alexu.csd.oop.game.GameEngine;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Blu-Ray
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public HomePage() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LeaveGameButton = new javax.swing.JButton();
        HardButton = new javax.swing.JButton();
        EasyButton = new javax.swing.JButton();
        MediumButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Circus Of Plates");
        setPreferredSize(new java.awt.Dimension(820, 550));
        getContentPane().setLayout(null);

        LeaveGameButton.setBackground(new java.awt.Color(149, 26, 27));
        LeaveGameButton.setFont(new java.awt.Font("Broken Console", 1, 20)); // NOI18N
        LeaveGameButton.setForeground(new java.awt.Color(0, 0, 0));
        LeaveGameButton.setText("leave game");
        LeaveGameButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LeaveGameButton.setOpaque(true);
        LeaveGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaveGameButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LeaveGameButton);
        LeaveGameButton.setBounds(310, 390, 180, 70);

        HardButton.setBackground(new java.awt.Color(149, 26, 27));
        HardButton.setFont(new java.awt.Font("Broken Console", 1, 20)); // NOI18N
        HardButton.setForeground(new java.awt.Color(0, 0, 0));
        HardButton.setText("HARD");
        HardButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        HardButton.setOpaque(true);
        HardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HardButtonActionPerformed(evt);
            }
        });
        getContentPane().add(HardButton);
        HardButton.setBounds(310, 310, 180, 70);

        EasyButton.setBackground(new java.awt.Color(149, 26, 27));
        EasyButton.setFont(new java.awt.Font("Broken Console", 1, 20)); // NOI18N
        EasyButton.setForeground(new java.awt.Color(0, 0, 0));
        EasyButton.setText("Easy");
        EasyButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EasyButton.setOpaque(true);
        EasyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EasyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(EasyButton);
        EasyButton.setBounds(310, 150, 180, 70);

        MediumButton.setBackground(new java.awt.Color(149, 26, 27));
        MediumButton.setFont(new java.awt.Font("Broken Console", 1, 20)); // NOI18N
        MediumButton.setForeground(new java.awt.Color(0, 0, 0));
        MediumButton.setText("MEDIUM");
        MediumButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MediumButton.setOpaque(true);
        MediumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MediumButtonActionPerformed(evt);
            }
        });
        getContentPane().add(MediumButton);
        MediumButton.setBounds(310, 230, 180, 70);

        jLabel1.setFont(new java.awt.Font("Broken Console", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background ready.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setMaximumSize(new java.awt.Dimension(800, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel1.setPreferredSize(new java.awt.Dimension(805, 505));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EasyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EasyButtonActionPerformed
        // TODO add your handling code here:
        GameController gameController = new GameController(() -> new CircusWorld( 1000, 700,new EasyStrategy()));
     gameController.start();
     this.setVisible(false);
        
       
    
    
    }//GEN-LAST:event_EasyButtonActionPerformed

    private void MediumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MediumButtonActionPerformed
        // TODO add your handling code here:
             GameController gameController = new GameController(() -> new CircusWorld( 1000, 700,new MediumStrategy()));
     gameController.start();
     this.setVisible(false);
        
    
    }//GEN-LAST:event_MediumButtonActionPerformed

    private void LeaveGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaveGameButtonActionPerformed
        // TODO add your handling code here:
        exit(0);
    }//GEN-LAST:event_LeaveGameButtonActionPerformed

    private void HardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HardButtonActionPerformed
        // TODO add your handling code here:
              GameController gameController = new GameController(() -> new CircusWorld( 1000, 700,new HardStrategy()));
     gameController.start();
     this.setVisible(false);
        
    
        
    }//GEN-LAST:event_HardButtonActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
                System.out.println("\u001b[31m\u2764");
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EasyButton;
    private javax.swing.JButton HardButton;
    private javax.swing.JButton LeaveGameButton;
    private javax.swing.JButton MediumButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
