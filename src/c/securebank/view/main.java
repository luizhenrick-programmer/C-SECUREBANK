package c.securebank.view;
import java.awt.Color;
import java.awt.Cursor;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class main extends javax.swing.JFrame {

    private DrawerController drawer;
    private saque saque_tela;
    private deposito deposito_tela;
    private tranferencia tranferencia_tela;
    private mudardados mudar_dados;
    private historico historico_tela;

    public main() {
        initComponents();
        saque_tela = new saque();
        deposito_tela = new deposito();
        tranferencia_tela = new tranferencia();
        mudar_dados = new mudardados();
        historico_tela = new historico();
        
        drawer = Drawer.newDrawer(this)
                .header(new logotipo())
                .background(new Color(26, 32, 44))
                .backgroundTransparent(0.9f)
                .drawerBackground(new Color(4, 191, 85))
                .addChild(new DrawerItem("Sacar Dinheiro").icon(new ImageIcon(getClass().getResource("/c/securebank/resources/saque-icon.png"))).build())
                .addChild(new DrawerItem("Depositar Dinheiro").icon(new ImageIcon(getClass().getResource("/c/securebank/resources/deposito-icon.png"))).build())
                .addChild(new DrawerItem("Tranferir Dinheiro").icon(new ImageIcon(getClass().getResource("/c/securebank/resources/transferir-icon.png"))).build())
                .addChild(new DrawerItem("Atualizar Dados").icon(new ImageIcon(getClass().getResource("/c/securebank/resources/atualizar-icon.png"))).build())
                .addChild(new DrawerItem("Histórico").icon(new ImageIcon(getClass().getResource("/c/securebank/resources/historico-icon.png"))).build())
                .addFooter(new DrawerItem("Realizar Logout").icon(new ImageIcon(getClass().getResource("/c/securebank/resources/logout-icon.png"))).build())
                .itemHeight(60)
                .event(new EventDrawer() {
                    @Override
                    public void selected(int i, DrawerItem di) {
                        if (i == 0) {
                            lbLogo.setVisible(false);
                            deposito_tela.setVisible(false);
                            tranferencia_tela.setVisible(false);
                            jDesktopPane1.remove(deposito_tela);
                            jDesktopPane1.remove(tranferencia_tela);
                            jDesktopPane1.remove(saque_tela);
                            jDesktopPane1.remove(mudar_dados);
                            jDesktopPane1.remove(historico_tela);
                            jDesktopPane1.add(saque_tela);
                            saque_tela.setVisible(true);
                            saque_tela.setSize(871, 509);
                            drawer.hide();
                        } else if (i == 1) {
                            lbLogo.setVisible(false);
                            saque_tela.setVisible(false);
                            tranferencia_tela.setVisible(false);
                            jDesktopPane1.remove(deposito_tela);
                            jDesktopPane1.remove(tranferencia_tela);
                            jDesktopPane1.remove(saque_tela);
                            jDesktopPane1.remove(mudar_dados);
                            jDesktopPane1.remove(historico_tela);
                            jDesktopPane1.add(deposito_tela);
                            deposito_tela.setVisible(true);
                            deposito_tela.setSize(871, 509);
                            drawer.hide();
                        } else if (i == 2) {
                            lbLogo.setVisible(false);
                            deposito_tela.setVisible(false);
                            saque_tela.setVisible(false);
                            jDesktopPane1.remove(deposito_tela);
                            jDesktopPane1.remove(tranferencia_tela);
                            jDesktopPane1.remove(saque_tela);
                            jDesktopPane1.remove(mudar_dados);
                            jDesktopPane1.remove(historico_tela);
                            jDesktopPane1.add(tranferencia_tela);
                            tranferencia_tela.setVisible(true);
                            tranferencia_tela.setSize(871, 509);
                            drawer.hide();
                        } else if (i == 3){
                            lbLogo.setVisible(false);
                            deposito_tela.setVisible(false);
                            saque_tela.setVisible(false);
                            jDesktopPane1.remove(deposito_tela);
                            jDesktopPane1.remove(tranferencia_tela);
                            jDesktopPane1.remove(saque_tela);
                            jDesktopPane1.remove(mudar_dados);
                            jDesktopPane1.remove(historico_tela);
                            jDesktopPane1.add(mudar_dados);
                            mudar_dados.setVisible(true);
                            mudar_dados.setSize(871, 509);
                            drawer.hide();
                        } else if (i == 4){
                            lbLogo.setVisible(false);
                            deposito_tela.setVisible(false);
                            saque_tela.setVisible(false);
                            jDesktopPane1.remove(deposito_tela);
                            jDesktopPane1.remove(tranferencia_tela);
                            jDesktopPane1.remove(saque_tela);
                            jDesktopPane1.remove(mudar_dados);
                            jDesktopPane1.remove(historico_tela);
                            jDesktopPane1.add(historico_tela);
                            historico_tela.setVisible(true);
                            historico_tela.setSize(871, 509);
                            drawer.hide();
                        } else if (i == 5) {
                            drawer.hide();
                            logout();
                        }

                    }

                })
                .build();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        lbLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(26, 32, 44));

        jButton1.setBackground(new java.awt.Color(4, 191, 85));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/c/securebank/resources/icons8-cardápio-32.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/c/securebank/resources/botao-fechar.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(26, 32, 44));

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/c/securebank/resources/_9561f767-62c1-4cbe-8994-e13523ee38ba (1).png"))); // NOI18N

        jDesktopPane1.setLayer(lbLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 871, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(320, 320, 320)
                    .addComponent(lbLogo)
                    .addContainerGap(320, Short.MAX_VALUE)))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(lbLogo)
                    .addContainerGap(139, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (drawer.isShow()) {
            drawer.hide();
            
        } else {
            
            drawer.show();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void logout() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        login janela = new login();
        janela.username = null;
        this.dispose();
        janela.setVisible(true);
        janela.setLocationRelativeTo(null);
    }

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbLogo;
    // End of variables declaration//GEN-END:variables
}
