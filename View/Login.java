package View;

import Model.Usuario;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField loginField;
    private JPasswordField senhaField;
    private JButton loginButton;
    private JLabel loginLabel;
    private JLabel senhaLabel;

    public Login() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        loginLabel = new JLabel("Login:");
        loginLabel.setBounds(20, 20, 80, 25);
        add(loginLabel);

        loginField = new JTextField(20);
        loginField.setBounds(100, 20, 165, 25);
        add(loginField);

        senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(20, 50, 80, 25);
        add(senhaLabel);

        senhaField = new JPasswordField(20);
        senhaField.setBounds(100, 50, 165, 25);
        add(senhaField);

        loginButton = new JButton("Entrar");
        loginButton.setBounds(100, 80, 80, 25);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login_usuario = loginField.getText();
                String senha_usuario = new String(senhaField.getPassword());

                Usuario usuario = new Usuario();
                Usuario autenticado = usuario.autenticarUsuario(login_usuario, senha_usuario);

                if (autenticado != null) {
                    new BemVindo(autenticado).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Login ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
