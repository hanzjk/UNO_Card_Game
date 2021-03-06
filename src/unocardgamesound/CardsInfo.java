/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unocardgamesound;

public class CardsInfo extends javax.swing.JFrame {

    /**
     * Creates new form CardsInfo
     */
    public CardsInfo() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        HomeButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CARDS INFO");
        setLocation(new java.awt.Point(300, 20));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(239, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("<html> <h3>    <p style=\"text-align: center;\"><strong style=\"font-family: Arial, Helvetica, sans-serif;\"><span style=\"font-size: 17px;\">The cards are in 4 different colors</span></strong></p>\n<ul>\n    <li><span style=\"font-family: Arial, Helvetica, sans-serif;\">Red</span></li>\n    <li>Blue</li>\n    <li>Green</li>\n    <li>Yellow</li>\n</ul> <br><p style=\"text-align: center;\"><span style=\"font-family: Arial, Helvetica, sans-serif;\"><strong><span style=\"font-size: 17px;\">There are 108 cards in the deck</span></strong></span></p> </h3> <ul>     <li><span style=\"font-family: Arial, Helvetica, sans-serif;\">4 cards numbered 0 <em>(one from each color)</em></span></li>     <li><span style=\"font-family: Arial, Helvetica, sans-serif;\">18 blue cards numbered from 1 to 9 <em>(two cards from each no)</em></span></li>     <li><span style=\"font-family: Arial, Helvetica, sans-serif;\">18 red cards numbered from 1 to 9</span></li>     <li><span style=\"font-family: Arial, Helvetica, sans-serif;\">18 yellow cards numbered from 1 to 9</span></li>     <li><span style=\"font-family: Arial, Helvetica, sans-serif;\">18 green cards numbered from 1 to 9</span></li>     <li><span style=\"font-family: Arial, Helvetica, sans-serif;\">8 &#39;DRAW TWO&#39; cards <em>&nbsp;(two cards from each color)</em></span></li>     <li><span style=\"font-family: Arial, Helvetica, sans-serif;\">8 &#39;REVERSE&#39; cards <em>&nbsp;(two cards from each color)</em></span></li>     <li><span style=\"font-family: Arial, Helvetica, sans-serif;\">8 &#39;SKIP&#39; cards <em>&nbsp;(two cards from each color)</em></span></li>     <li><span style=\"font-family: Arial, Helvetica, sans-serif;\">4 &#39;WILD&#39; cards</span></li>     <li><span style=\"font-family: Arial, Helvetica, sans-serif;\">4 &#39;DRAW FOUR&#39; cards</span></li> </ul> </html>");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 470, 370));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setText("CARDS INFO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        HomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/home.png"))); // NOI18N
        HomeButton.setContentAreaFilled(false);
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(HomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 550, 100, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/about image.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 350, 260));

        BackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unocardgamesound/images/BackButton.png"))); // NOI18N
        BackButton.setContentAreaFilled(false);
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 120, 110));

        jLabel2.setBackground(new java.awt.Color(239, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
         Music m = new Music();
        m.buttonClick();
        new Menu().setVisible(true); // Displays the Main menu again
        dispose(); //close the current frame
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
         Music m = new Music();
        m.buttonClick();
        new Instructions().setVisible(true); // Displays the Instructions menu again
        dispose(); //close the current frame
    }//GEN-LAST:event_BackButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CardsInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CardsInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CardsInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CardsInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardsInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton HomeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
