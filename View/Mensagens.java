package View;

import javax.swing.JOptionPane;

public class Mensagens extends Exception {

    public static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static boolean confirmarExclusao(String mensagem) {
        Object[] options = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(
                null,
                mensagem,
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        return resposta == JOptionPane.YES_OPTION;
    }

    Mensagens(String msg) {
        super(msg);
    }
}
