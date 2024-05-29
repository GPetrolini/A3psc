
package View;

import Model.Usuario;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class Login extends javax.swing.JFrame {


    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginTitulo = new javax.swing.JLabel();
        Icone_Login = new javax.swing.JLabel();
        Login_nome = new javax.swing.JLabel();
        nome_login = new javax.swing.JTextField();
        Login_senha = new javax.swing.JLabel();
        senha_login = new javax.swing.JPasswordField();
        b_entrar = new javax.swing.JButton();
        L_cadastro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LoginTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        LoginTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginTitulo.setText("Login");

        Icone_Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/account (3).png"))); // NOI18N

        Login_nome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Login_nome.setText("Nome:");

        nome_login.setText("Digite seu nome...");
        nome_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_loginActionPerformed(evt);
            }
        });

        Login_senha.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Login_senha.setText("Senha:");

        b_entrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        b_entrar.setText("Entrar");
        b_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_entrarActionPerformed(evt);
            }
        });

        L_cadastro.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        L_cadastro.setText("Não tem conta? Cadastrar-se");
        L_cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        L_cadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L_cadastroMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/back.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Icone_Login)
                .addGap(348, 348, 348))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(LoginTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(L_cadastro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(138, 138, 138)
                                    .addComponent(b_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Login_senha, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                    .addComponent(Login_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nome_login, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                    .addComponent(senha_login)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(231, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Icone_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginTitulo)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nome_login, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login_senha)
                    .addComponent(senha_login, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(L_cadastro)
                .addGap(28, 28, 28)
                .addComponent(b_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nome_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_loginActionPerformed

    private void L_cadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_cadastroMouseClicked
        CadastroUsuario objeto = new CadastroUsuario();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_L_cadastroMouseClicked

    private void b_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_entrarActionPerformed
        String login = nome_login.getText();
                String senha = new String(senha_login.getPassword());

                Usuario usuario = new Usuario();
                try {
                    Usuario autenticado = usuario.autenticarUsuario(login, senha);
                    if (autenticado != null) {
                        JOptionPane.showMessageDialog(rootPane, "Login bem-sucedido!");
                        new Produtos().setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Login ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao autenticar usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
    }//GEN-LAST:event_b_entrarActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        BemVindo voltartela = new BemVindo();
        voltartela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Icone_Login;
    private javax.swing.JLabel L_cadastro;
    private javax.swing.JLabel LoginTitulo;
    private javax.swing.JLabel Login_nome;
    private javax.swing.JLabel Login_senha;
    private javax.swing.JButton b_entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nome_login;
    private javax.swing.JPasswordField senha_login;
    // End of variables declaration//GEN-END:variables
}
