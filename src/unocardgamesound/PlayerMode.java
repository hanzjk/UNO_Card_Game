/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unocardgamesound;


public class PlayerMode extends javax.swing.JFrame {

    /**
     * Creates new form PlayerMode
     */
    public PlayerMode() {
        initComponents();
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VsComputerButton = new javax.swing.JButton();
        Players4Button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UNO");
        setLocation(new java.awt.Point(200, 20));
        setPreferredSize(new java.awt.Dimension(1026, 761));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VsComputerButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        VsComputerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/com_1.png"))); // NOI18N
        VsComputerButton.setBorderPainted(false);
        VsComputerButton.setContentAreaFilled(false);
        VsComputerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VsComputerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VsComputerButtonMouseExited(evt);
            }
        });
        VsComputerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VsComputerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VsComputerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

        Players4Button.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Players4Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/multi_1.png"))); // NOI18N
        Players4Button.setBorderPainted(false);
        Players4Button.setContentAreaFilled(false);
        Players4Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Players4ButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Players4ButtonMouseExited(evt);
            }
        });
        Players4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Players4ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Players4Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 320, 80));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("GAME MODE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/blue_background.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Players4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Players4ButtonActionPerformed
         Music m = new Music();
        m.buttonClick();
        new AddPlayerNames().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_Players4ButtonActionPerformed

    private void VsComputerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VsComputerButtonActionPerformed
         Music m = new Music();
        m.buttonClick();
        new AddPlayer().setVisible(true);
        dispose();
    }//GEN-LAST:event_VsComputerButtonActionPerformed

    private void Players4ButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Players4ButtonMouseExited
        Players4Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/multi_1.png")));
    }//GEN-LAST:event_Players4ButtonMouseExited

    private void VsComputerButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VsComputerButtonMouseExited
        VsComputerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/com_1.png")));
    }//GEN-LAST:event_VsComputerButtonMouseExited

    private void Players4ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Players4ButtonMouseEntered
        Players4Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/multi_2.png")));
    }//GEN-LAST:event_Players4ButtonMouseEntered

    private void VsComputerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VsComputerButtonMouseEntered
        VsComputerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/com_2.png")));
    }//GEN-LAST:event_VsComputerButtonMouseEntered

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
            java.util.logging.Logger.getLogger(PlayerMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerMode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PlayerMode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Players4Button;
    private javax.swing.JButton VsComputerButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
