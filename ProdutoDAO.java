
package DAO;

import static DAO.AlunoDAO.MinhaLista;
import Model.Produto;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ProdutoDAO {

    public static ArrayList<Produto> MinhaLista = new ArrayList<Produto>();
    
    public ProdutoDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_alunos");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }
    public Connection getConexao() {

        Connection connection = null;  //inst�ncia da conex�o

        try {

            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Configurar a conex�o
            String server = "localhost"; //caminho do MySQL
            String database = "db_produtos";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "A3password*";

            connection = DriverManager.getConnection(url, user, password);

            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: N�O CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver n�o encontrado
            System.out.println("O driver nao foi encontrado. " + e.getMessage() );
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }
        // Retorna a Lista de produtos(objetos)
    public ArrayList getMinhaLista() {
        
        MinhaLista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String descricao = res.getString("descricao");
                int quantidade = res.getInt("preco");
                double preco = res.getDouble("preco");
                String datacadastro = res.getString("datacadastro");
                

                Produto objeto = new Produto(id,nome,descricao,quantidade,preco,datacadastro);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }
     // Cadastra novo aluno
    public boolean InsertProdutoBD(Produto objeto) {
        String sql = "INSERT INTO tb_produtos(id,nome,descricao,quantidade,preco,datacadastro) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getDescricao());
            stmt.setInt(4, objeto.getQuantidade());
            stmt.setDouble(5, objeto.getPreco());
            stmt.setString(6,objeto.getDatacadastro());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    public boolean DeleteProdutoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_produtos WHERE id = " + id);
            stmt.close();            
            
        } catch (SQLException erro) {
        }
        
        return true;
    }
    public boolean UpdateProdutoBD(Produto objeto) {

        String sql = "UPDATE tb_produtos set nome = ? ,descricao = ? ,quantidade = ? ,preco = ? ,datacadastro = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getDescricao());
            stmt.setInt(3, objeto.getQuantidade());
            stmt.setDouble(4, objeto.getPreco());
            stmt.setString(5, objeto.getDatacadastro());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    public Produto carregaProduto(int id) {
        
        Produto objeto = new Produto();
        objeto.setId(id);
        
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setDescricao(res.getString("Descricao"));
            objeto.setQuantidade(res.getInt("Quantidade"));
            objeto.setPreco(res.getDouble("Preco"));
            objeto.setDatacadastro(res.getString("Datacadastra"));

            stmt.close();            
            
        } catch (SQLException erro) {
        }
        return objeto;
    }

  
}
    

