package DAO;

import Model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuario {

    public static ArrayList<Usuario> MinhaLista = new ArrayList<Usuario>();
    
    public DAOUsuario() {
    }

    public int maiorID() throws SQLException {
        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id_usuario) id FROM tb_usuarios");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar maior ID: " + ex.getMessage());
        }
        return maiorID;
    }

    public Connection getConexao() {
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

    public boolean salvarUsuarioBD(Usuario user) throws SQLException {
        String sql = "INSERT INTO tb_usuarios (nome_usuario, login_usuario, senha_usuario) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setString(1, user.getNome_usuario());
            stmt.setString(2, user.getLogin_usuario());
            stmt.setString(3, user.getSenha_usuario());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao salvar usuário: " + erro.getMessage());
            throw new RuntimeException(erro);
        }
    }

    public List<Usuario> listarUsuariosBD() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM tb_usuarios";
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                Usuario user = new Usuario();
                user.setId_usuario(res.getInt("id_usuario"));
                user.setNome_usuario(res.getString("nome_usuario"));
                user.setLogin_usuario(res.getString("login_usuario"));
                user.setSenha_usuario(res.getString("senha_usuario"));
                usuarios.add(user);
            }
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro ao listar usuários: " + erro.getMessage());
        }
        return usuarios;
    }

    public Usuario buscarUsuarioBD(int id_usuario) throws SQLException {
        Usuario user = new Usuario();
        user.setId_usuario(id_usuario);
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_usuarios WHERE id_usuario = " + id_usuario);
            if (res.next()) {
                user.setNome_usuario(res.getString("nome_usuario"));
                user.setLogin_usuario(res.getString("login_usuario"));
                user.setSenha_usuario(res.getString("senha_usuario"));
            }
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro ao buscar usuário: " + erro.getMessage());
            throw erro;
        }
        return user;
    }

    public boolean atualizarUsuarioBD(Usuario user) throws SQLException {
        String sql = "UPDATE tb_usuarios SET nome_usuario = ?, login_usuario = ?, senha_usuario = ? WHERE id_usuario = ?";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setString(1, user.getNome_usuario());
            stmt.setString(2, user.getLogin_usuario());
            stmt.setString(3, user.getSenha_usuario());
            stmt.setInt(4, user.getId_usuario());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar usuário: " + erro.getMessage());
            throw erro;
        }
    }

    public boolean excluirUsuarioBD(int id_usuario) throws SQLException {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_usuarios WHERE id_usuario = " + id_usuario);
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao excluir usuário: " + erro.getMessage());
            throw erro;
        }
    }

    public Usuario autenticarUsuarioBD(String login_usuario, String senha_usuario) throws SQLException {
        Usuario user = null;
        String sql = "SELECT * FROM tb_usuarios WHERE login_usuario = ? AND senha_usuario = ?";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setString(1, login_usuario);
            stmt.setString(2, senha_usuario);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                user = new Usuario();
                user.setId_usuario(res.getInt("id_usuario"));
                user.setNome_usuario(res.getString("nome_usuario"));
                user.setLogin_usuario(res.getString("login_usuario"));
                user.setSenha_usuario(res.getString("senha_usuario"));
            }
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro ao autenticar usuário: " + erro.getMessage());
            throw erro;
        }
        return user;
    }
}