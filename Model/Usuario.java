package Model;

import DAO.DAOUsuario;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Usuario {
    private int id_usuario;
    private String nome_usuario;
    private String login_usuario;
    private String senha_usuario;
    private final DAOUsuario daoUsuario;

    public Usuario() {
        this.daoUsuario = new DAOUsuario();
    }

    public Usuario(int id_usuario, String nome_usuario, String login_usuario, String senha_usuario) {
        this.id_usuario = id_usuario;
        this.nome_usuario = nome_usuario;
        this.login_usuario = login_usuario;
        this.senha_usuario = senha_usuario;
        this.daoUsuario = new DAOUsuario();
    }

    // Getters e Setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }
    
    public boolean salvarUsuario() throws SQLException {
        return this.daoUsuario.InsertUsuarioBD(this);
    }

    public Usuario autenticarUsuario(String login_usuario, String senha_usuario) throws SQLException {
        this.login_usuario = login_usuario;
        this.senha_usuario = senha_usuario;
        ResultSet rs = this.daoUsuario.autenticacaoUsuario(this);
        if (rs.next()) {
            this.id_usuario = rs.getInt("id_usuario");
            this.nome_usuario = rs.getString("nome_usuario");
            return this;
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "\n ID: " + this.getId_usuario()
                + "\n Nome: " + this.getNome_usuario()
                + "\n Login: " + this.getLogin_usuario()
                + "\n Senha: " + this.getSenha_usuario();
    }
}