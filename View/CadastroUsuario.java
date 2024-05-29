
package View;

import Model.Usuario;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class CadastroUsuario extends javax.swing.JFrame {

    public CadastroUsuario() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloCadastroUsuario = new javax.swing.JLabel();
        IconeCadastroUsuario = new javax.swing.JLabel();
        NomeCadastroUsuario = new javax.swing.JLabel();
        CadastroNomeUsuario = new javax.swing.JTextField();
        CadastroSenhaUsuario = new javax.swing.JPasswordField();
        SenhaCadastroUsuario = new javax.swing.JLabel();
        b_cadastrarUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TituloCadastroUsuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TituloCadastroUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloCadastroUsuario.setText("Cadastro");

        IconeCadastroUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/register (1).png"))); // NOI18N

        NomeCadastroUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NomeCadastroUsuario.setText("Nome:");

        CadastroNomeUsuario.setText("Digite seu nome...");

        SenhaCadastroUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SenhaCadastroUsuario.setText("Senha:");

        b_cadastrarUsuario.setText("Cadastrar");
        b_cadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cadastrarUsuarioActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(IconeCadastroUsuario)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TituloCadastroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NomeCadastroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SenhaCadastroUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CadastroSenhaUsuario)
                            .addComponent(CadastroNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(b_cadastrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(IconeCadastroUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TituloCadastroUsuario)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeCadastroUsuario)
                    .addComponent(CadastroNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CadastroSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SenhaCadastroUsuario))
                .addGap(29, 29, 29)
                .addComponent(b_cadastrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_cadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cadastrarUsuarioActionPerformed
        try {
        // recebendo e validando dados da interface gráfica.
        String nome_usuario = "";
        String senha_usuario = "";

        if (this.CadastroNomeUsuario.getText().length() < 3) {
            JOptionPane.showMessageDialog(null, "Nome deve conter ao menos 3 caracteres.");
            return; // Para a execução se a validação falhar
        } else {
            nome_usuario = CadastroNomeUsuario.getText();
        }
        if (this.CadastroSenhaUsuario.getText().length() < 6) {
            JOptionPane.showMessageDialog(null, "Senha deve conter ao menos 6 caracteres.");
            return; // Para a execução se a validação falhar
        } else {
            senha_usuario = CadastroSenhaUsuario.getText();
        }

        Usuario novoUsuario = new Usuario(0, nome_usuario, nome_usuario, senha_usuario); // Alterado para incluir login_usuario

        if (novoUsuario.salvarUsuario()) {
            JOptionPane.showMessageDialog(rootPane, "Usuário Cadastrado com Sucesso!");
            
            new Login().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar usuário.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, "Erro: " + e.getMessage());
    }
        
        
    }//GEN-LAST:event_b_cadastrarUsuarioActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
         Login voltartela = new Login();
        voltartela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked


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
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CadastroNomeUsuario;
    private javax.swing.JPasswordField CadastroSenhaUsuario;
    private javax.swing.JLabel IconeCadastroUsuario;
    private javax.swing.JLabel NomeCadastroUsuario;
    private javax.swing.JLabel SenhaCadastroUsuario;
    private javax.swing.JLabel TituloCadastroUsuario;
    private javax.swing.JButton b_cadastrarUsuario;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
