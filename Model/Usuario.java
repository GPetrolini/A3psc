package Model;

import DAO.DAOUsuario;
import java.sql.SQLException;
import java.util.List;

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

    // Métodos de controle
    public boolean salvarUsuario() {
        try {
            return this.daoUsuario.salvarUsuarioBD(this);
        } catch (SQLException e) {
            System.out.println("OCORREU UM ERRO AO SALVAR USUÁRIO\n METODO: salvarUsuarioBD\n erro: " + e);
            return false;
        }
    }

    public List<Usuario> listarUsuarios() {
        try {
            return this.daoUsuario.listarUsuariosBD();
        } catch (SQLException e) {
            System.out.println("OCORREU UM ERRO AO LISTAR USUÁRIOS\n METODO: listarUsuariosBD\n erro: " + e);
            return null;
        }
    }

    public Usuario getUsuario(int id_usuario) {
        try {
            return this.daoUsuario.buscarUsuarioBD(id_usuario);
        } catch (SQLException e) {
            System.out.println("OCORREU UM ERRO AO BUSCAR USUÁRIO ATRAVÉS DO SEU ID\n METODO: buscarUsuarioBD\n erro: " + e);
            return null;
        }
    }

    public boolean atualizarUsuario() {
        try {
            return this.daoUsuario.atualizarUsuarioBD(this);
        } catch (SQLException e) {
            System.out.println("OCORREU UM ERRO AO ATUALIZAR USUÁRIO\n METODO: atualizarUsuarioBD\n erro: " + e);
            return false;
        }
    }

    public boolean excluirUsuario(int id_usuario) {
        if (id_usuario > 0) {
            try {
                return this.daoUsuario.excluirUsuarioBD(id_usuario);
            } catch (SQLException ex) {
                System.out.println("ERRO NA EXCLUSÃO DE UM USUÁRIO: " + ex);
                return false;
            }
        } else {
            return false;
        }
    }

    public Usuario autenticarUsuario(String login_usuario, String senha_usuario) {
        try {
            return this.daoUsuario.autenticarUsuarioBD(login_usuario, senha_usuario);
        } catch (SQLException e) {
            System.out.println("OCORREU UM ERRO AO AUTENTICAR USUÁRIO\n METODO: autenticarUsuarioBD\n erro: " + e);
            return null;
        }
    }

    @Override
    public String toString() {
        return "\n ID: " + this.getId_usuario()
                + "\n Nome: " + this.getNome_usuario()
                + "\n Login: " + this.getLogin_usuario()
                + "\n Senha: " + this.getSenha_usuario();
    }
}