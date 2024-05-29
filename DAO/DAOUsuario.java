package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAOUsuario {

    public static ArrayList<Usuario> MinhaLista = new ArrayList<Usuario>();

    public DAOUsuario() {
    }

    private Connection getConexao() {
        Connection connection = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String server = "localhost";
            String database = "db_a3";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "A3password*";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NÃO CONECTADO!");
            }

            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver não foi encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    public ResultSet autenticacaoUsuario(Usuario objetoUsuario) {
        Connection connection = getConexao();

        try {
            String sql = "SELECT * FROM tb_usuarios WHERE login_usuario = ? AND senha_usuario = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, objetoUsuario.getLogin_usuario());
            stmt.setString(2, objetoUsuario.getSenha_usuario());

            return stmt.executeQuery();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }

    public boolean InsertUsuarioBD(Usuario objeto) {
        Connection connection = getConexao();

        try {
            String sql = "INSERT INTO tb_usuarios(nome_usuario, login_usuario, senha_usuario) VALUES(?,?,?)";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, objeto.getNome_usuario());
            stmt.setString(2, objeto.getLogin_usuario());
            stmt.setString(3, objeto.getSenha_usuario());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
}