package DAO;

import Model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoTblProduto {

    public static ArrayList<Produto> MinhaLista = new ArrayList<Produto>();

    public DaoTblProduto() {
    }

    public int getProximoID() throws SQLException {
        int proximoID = 1; // Inicia com 1 como valor padrão
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;

        try {
            connection = getConexao();
            stmt = connection.createStatement();
            res = stmt.executeQuery("SELECT MAX(id) AS max_id FROM tb_produtos");

            if (res.next()) {
                proximoID = res.getInt("max_id") + 1; // Incrementa o maior ID encontrado
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar maior ID: " + ex.getMessage());
        } finally {
            if (res != null) {
                res.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return proximoID;
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

    public boolean salvarProdutoBD(Produto produto) throws SQLException {
        produto.setId(getProximoID());
        String sql = "INSERT INTO tb_produtos (id, nome, descricao, quantidade, preco, datacadastro) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConexao(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setDouble(5, produto.getPreco());
            stmt.setDate(6, produto.getDatacadastro());
            stmt.execute();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao salvar produto: " + erro.getMessage());
            throw new RuntimeException(erro);
        }
    }

    public List<Produto> listarProdutosBD() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM tb_produtos";
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                Produto produto = new Produto();
                produto.setId(res.getInt("id"));
                produto.setNome(res.getString("nome"));
                produto.setDescricao(res.getString("descricao"));
                produto.setQuantidade(res.getInt("quantidade"));
                produto.setPreco(res.getDouble("preco"));
                produto.setDatacadastro(res.getDate("datacadastro")); // Ajuste aqui para usar java.sql.Date
                produtos.add(produto);
            }
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro ao listar produtos: " + erro.getMessage());
        }
        return produtos;
    }

    public Produto buscarProdutoBD(int id) throws SQLException {
        Produto produto = new Produto();
        produto.setId(id);
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos WHERE id = " + id);
            if (res.next()) {
                produto.setNome(res.getString("nome"));
                produto.setDescricao(res.getString("descricao"));
                produto.setQuantidade(res.getInt("quantidade"));
                produto.setPreco(res.getDouble("preco"));
                produto.setDatacadastro(res.getDate("datacadastro")); // Ajuste aqui para usar java.sql.Date
            }
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro ao buscar produto: " + erro.getMessage());
            throw erro;
        }
        return produto;
    }

    public boolean atualizarProdutoBD(Produto produto) throws SQLException {
        String sql = "UPDATE tb_produtos SET nome = ?, descricao = ?, quantidade = ?, preco = ?, datacadastro = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setDouble(4, produto.getPreco());
            stmt.setDate(5, produto.getDatacadastro()); // Ajuste aqui para usar java.sql.Date
            stmt.setInt(6, produto.getId());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao atualizar produto: " + erro.getMessage());
            throw erro;
        }
    }

    public boolean excluirProdutoBD(int id) throws SQLException {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_produtos WHERE id = " + id);
            stmt.close();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao excluir produto: " + erro.getMessage());
            throw erro;
        }
    }
}
