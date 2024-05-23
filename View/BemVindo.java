package View;

import Model.Usuario;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BemVindo extends JFrame {
    private JLabel welcomeLabel;
    private JButton logoutButton;

    public BemVindo(Usuario usuario) {
        setTitle("Bem-vindo");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        welcomeLabel = new JLabel("Bem-vindo, " + usuario.getNome_usuario() + "!");
        welcomeLabel.setBounds(50, 20, 200, 25);
        add(welcomeLabel);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(100, 80, 80, 25);
        add(logoutButton);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                dispose();
            }
        });
    }
}
