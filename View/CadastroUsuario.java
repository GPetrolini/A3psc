package View;

import Model.Usuario;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUsuario extends JFrame {
    private JTextField nomeField;
    private JTextField loginField;
    private JPasswordField senhaField;
    private JButton cadastrarButton;
    private JLabel nomeLabel;
    private JLabel loginLabel;
    private JLabel senhaLabel;

    public CadastroUsuario() {
        setTitle("Cadastro de Usuário");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(20, 20, 100, 25);
        add(nomeLabel);

        nomeField = new JTextField(20);
        nomeField.setBounds(140, 20, 165, 25);
        add(nomeField);

        loginLabel = new JLabel("Login:");
        loginLabel.setBounds(20, 50, 100, 25);
        add(loginLabel);

        loginField = new JTextField(20);
        loginField.setBounds(140, 50, 165, 25);
        add(loginField);

        senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(20, 80, 100, 25);
        add(senhaLabel);

        senhaField = new JPasswordField(20);
        senhaField.setBounds(140, 80, 165, 25);
        add(senhaField);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(140, 110, 100, 25);
        add(cadastrarButton);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome_usuario = nomeField.getText();
                String login_usuario = loginField.getText();
                String senha_usuario = new String(senhaField.getPassword());

                Usuario usuario = new Usuario(0, nome_usuario, login_usuario, senha_usuario);
                boolean sucesso = usuario.salvarUsuario();

                if (sucesso) {
                    JOptionPane.showMessageDialog(CadastroUsuario.this, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    new Login().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(CadastroUsuario.this, "Erro ao cadastrar usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }
}
