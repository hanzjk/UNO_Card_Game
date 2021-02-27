/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unocardgamesound;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class AddPlayer extends javax.swing.JFrame { 
public ArrayList<String> playerIds;


    /**
     * Creates new form AddPlayer
     */
    public AddPlayer() { //constructor
        initComponents();
        playerIds =new ArrayList<>();
        
        
    }
    
    
    
      public String[] getPids() {
		String pids[]= playerIds.toArray(new String[playerIds.size()]);
		return pids;
	}
   
     
      
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerIdtextField = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        PlayerId1lbl = new javax.swing.JLabel();
        DoneButton1 = new javax.swing.JButton();
        playerid = new javax.swing.JLabel();
        PlayerPClbl1 = new javax.swing.JLabel();
        DeleteButton = new javax.swing.JButton();
        Backgroundlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UNO");
        setLocation(new java.awt.Point(300, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        playerIdtextField.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        playerIdtextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerIdtextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(playerIdtextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 370, -1));

        SaveButton.setBackground(new java.awt.Color(255, 255, 102));
        SaveButton.setFont(new java.awt.Font("Algerian", 1, 30)); // NOI18N
        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/save_1.png"))); // NOI18N
        SaveButton.setBorderPainted(false);
        SaveButton.setContentAreaFilled(false);
        SaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SaveButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SaveButtonMouseExited(evt);
            }
        });
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        PlayerId1lbl.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        PlayerId1lbl.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(PlayerId1lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 170, 30));

        DoneButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/done_1.png"))); // NOI18N
        DoneButton1.setBorderPainted(false);
        DoneButton1.setContentAreaFilled(false);
        DoneButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DoneButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DoneButton1MouseExited(evt);
            }
        });
        DoneButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(DoneButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, -1, -1));

        playerid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/userIcon.png"))); // NOI18N
        getContentPane().add(playerid, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        PlayerPClbl1.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        PlayerPClbl1.setForeground(new java.awt.Color(255, 255, 255));
        PlayerPClbl1.setText("COMPUTER");
        getContentPane().add(PlayerPClbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 170, 30));

        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/delete_1.png"))); // NOI18N
        DeleteButton.setContentAreaFilled(false);
        DeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseExited(evt);
            }
        });
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        Backgroundlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/AddPlayers.jpg"))); // NOI18N
        getContentPane().add(Backgroundlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playerIdtextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerIdtextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerIdtextFieldActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        if(playerIdtextField.getText().isEmpty())
        {
             Music m = new Music();
        m.buttonClick();
            JLabel message=new JLabel("Please enter a name");
            JOptionPane.showMessageDialog(null, message);
        }
        
        else if (playerIdtextField.getText().isBlank())
                                {
                                        Music m = new Music();
        m.buttonClick();
					JLabel message=new JLabel("Name cannot be all spaces");
					JOptionPane.showMessageDialog(null, message);
                                }

        else {
             Music m = new Music();
        m.buttonClick();
            String name=playerIdtextField.getText().trim();
            
            playerIds.add(name);

            if (playerIds.size()==1)
            
                PlayerId1lbl.setText(playerIds.get(0));
            
            
                
              
                
            

            if(playerIds.size()>0 && playerIds.size()<2) {

                playerIdtextField.setText(" ");

            }

            if (playerIds.size()==2) {
                playerIds.remove(name);
                JLabel message=new JLabel("There can be only One Player");
                JOptionPane.showMessageDialog(null, message);
                playerIdtextField.setText(" ");

            }
        }
    }//GEN-LAST:event_SaveButtonActionPerformed
    
    
    private void DoneButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneButton1ActionPerformed
         Music m = new Music();
        m.buttonClick();
         if (playerIds.isEmpty())
        {
            JLabel message=new JLabel("There must be at least One Player");
            JOptionPane.showMessageDialog(null, message);
            playerIdtextField.setText(" ");
        }

        else
        {

           int points[]={0,0};
           dispose();//close the current frame
           new PcvsPlayer(playerIds,points).setVisible(true); //Display the new frame  //playerIds

        }
    }//GEN-LAST:event_DoneButton1ActionPerformed

    private void SaveButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMouseExited
        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/save_1.png"))); 
    }//GEN-LAST:event_SaveButtonMouseExited

    private void SaveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMouseEntered
        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/save_2.png"))); 
    }//GEN-LAST:event_SaveButtonMouseEntered

    private void DoneButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DoneButton1MouseEntered
        DoneButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/done_2.png")));
    }//GEN-LAST:event_DoneButton1MouseEntered

    private void DoneButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DoneButton1MouseExited
        DoneButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/done_1.png")));
    }//GEN-LAST:event_DoneButton1MouseExited

    private void DeleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseEntered
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/delete_2.png")));
    }//GEN-LAST:event_DeleteButtonMouseEntered

    private void DeleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseExited
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/delete_1.png")));
    }//GEN-LAST:event_DeleteButtonMouseExited

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        if(PlayerId1lbl.getText().isEmpty())
        {
             Music m = new Music();
        m.buttonClick();
            JLabel message=new JLabel("Please enter a name first");
            JOptionPane.showMessageDialog(null, message);
        }
        
        else 
        {
             Music m = new Music();
        m.buttonClick(); 
            int index = playerIds.size()-1;
            PlayerId1lbl.setText(null);
            playerIds.remove(index);
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backgroundlabel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton DoneButton1;
    private javax.swing.JLabel PlayerId1lbl;
    private javax.swing.JLabel PlayerPClbl1;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField playerIdtextField;
    private javax.swing.JLabel playerid;
    // End of variables declaration//GEN-END:variables
}
        
