/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unocardgamesound;


public class Instructions extends javax.swing.JFrame {

    /**
     * Creates new form Instructions
     */
    public Instructions() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        HomeButton = new javax.swing.JButton();
        CI = new javax.swing.JLabel();
        HTP = new javax.swing.JLabel();
        AC = new javax.swing.JLabel();
        Score = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        InstructionsBG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INSTRUCTIONS ");
        setLocation(new java.awt.Point(300, 100));
        setMaximumSize(new java.awt.Dimension(770, 670));
        setMinimumSize(new java.awt.Dimension(770, 670));
        setName("Instructions"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(770, 670));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        playButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/playButton.png"))); // NOI18N
        playButton.setBorderPainted(false);
        playButton.setContentAreaFilled(false);
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        getContentPane().add(playButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, -1, -1));

        CancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/cancel.png"))); // NOI18N
        CancelButton.setContentAreaFilled(false);
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, -1, -1));

        HomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/home.png"))); // NOI18N
        HomeButton.setContentAreaFilled(false);
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(HomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, -1, -1));

        CI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/CIBlack.png"))); // NOI18N
        CI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CIMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CIMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CIMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CIMousePressed(evt);
            }
        });
        getContentPane().add(CI, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        HTP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/HTPBlack.png"))); // NOI18N
        HTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HTPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HTPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HTPMouseExited(evt);
            }
        });
        getContentPane().add(HTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        AC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/ACBlack.png"))); // NOI18N
        AC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ACMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ACMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ACMouseExited(evt);
            }
        });
        getContentPane().add(AC, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 310, 50));

        Score.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/ScoreBlack.png"))); // NOI18N
        Score.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScoreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ScoreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ScoreMouseExited(evt);
            }
        });
        getContentPane().add(Score, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/about image.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 310, 370, 300));

        InstructionsBG.setBackground(new java.awt.Color(239, 255, 255));
        InstructionsBG.setOpaque(true);
        getContentPane().add(InstructionsBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        Music m = new Music();
        m.buttonClick();
        new PlayerMode().setVisible(true);//Display the PlayerMode frame
	dispose();//close the current frame
    }//GEN-LAST:event_playButtonActionPerformed

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        Music m = new Music();
        m.buttonClick();
        new Menu().setVisible(true); // Displays the Main menu again
        dispose(); //close the current frame
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        Music m = new Music();
        m.buttonClick();
        System.exit(0);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void ACMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ACMouseEntered
      AC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/ACWhite.png")));  
    }//GEN-LAST:event_ACMouseEntered

    private void HTPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HTPMouseEntered
        HTP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/HTPWhite.png")));
    }//GEN-LAST:event_HTPMouseEntered

    private void ScoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScoreMouseEntered
         Score.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/ScoreWhite.png")));
    }//GEN-LAST:event_ScoreMouseEntered

    private void ACMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ACMouseExited
      AC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/ACBlack.png")));  
    }//GEN-LAST:event_ACMouseExited

    private void HTPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HTPMouseExited
     HTP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/HTPBlack.png")));  
    }//GEN-LAST:event_HTPMouseExited

    private void ScoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScoreMouseExited
      Score.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/ScoreBlack.png")));
    }//GEN-LAST:event_ScoreMouseExited

    private void CIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CIMousePressed

    }//GEN-LAST:event_CIMousePressed

    private void CIMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CIMouseExited
        CI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/CIBlack.png")));
    }//GEN-LAST:event_CIMouseExited

    private void CIMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CIMouseEntered
        CI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/CIWhite.png")));
    }//GEN-LAST:event_CIMouseEntered

    private void CIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CIMouseClicked
      Music m = new Music();
        m.buttonClick();
        new CardsInfo().setVisible(true);
        dispose();
    }//GEN-LAST:event_CIMouseClicked

    private void ACMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ACMouseClicked
         Music m = new Music();
        m.buttonClick();
        new SpecialCards().setVisible(true);
        dispose();
    }//GEN-LAST:event_ACMouseClicked

    private void HTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HTPMouseClicked
        Music m = new Music();
        m.buttonClick();
        new HowToPlay().setVisible(true);
        dispose();
    }//GEN-LAST:event_HTPMouseClicked

    private void ScoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScoreMouseClicked
         Music m = new Music();
        m.buttonClick();
        new Score().setVisible(true);
        dispose();
    }//GEN-LAST:event_ScoreMouseClicked

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
            java.util.logging.Logger.getLogger(Instructions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instructions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instructions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instructions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instructions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AC;
    private javax.swing.JLabel CI;
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel HTP;
    private javax.swing.JButton HomeButton;
    private javax.swing.JLabel InstructionsBG;
    private javax.swing.JLabel Score;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton playButton;
    // End of variables declaration//GEN-END:variables
}
