package Model;
import DAO.ProdutoDAO;
import java.util.*;
import java.sql.SQLException;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;
    private String datacadastro;
    private ProdutoDAO dao;

    public Produto(int id, String nome, String descricao, int quantidade, double preco, String datacadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.datacadastro = datacadastro;
        try {
            this.dao = new ProdutoDAO();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar instância de ProdutoDAO", e);
        }
    }

    public ArrayList getMinhaLista() {
        try {
            return dao.getMinhaLista();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter lista de produtos, verificar se as informações escritas estão corretas", e);
        }
    }
}
    public boolean InsertProdutoBD(int id, String nome, String descricao, int quantidade, double preco, String datacadastro) throws SQLException {
        int ID = this.maiorID() + 1;
        Produto objeto = new Produto(quantidade, nome, descricao, quantidade, preco, datacadastro);
        dao.InsertProdutoBD(objeto);
        return true;
    }

    public boolean DeleteProdutoBD(int id) {
        dao.DeleteProdutoBD(id);
        return true;
    }

    public boolean UpdateProdutoBD(String nome, String descricao, int quantidade, double preco, String datacadastro) {
        Produto objeto = new Produto(quantidade, nome, descricao, quantidade, preco, datacadastro);
        dao.UpdateProdutoBD(objeto);
        return true;
    }

    private int procuraIndice(int id) {
        int indice = -1;
        for (int i = 0; i < ProdutoDAO.MinhaLista.size(); i++) {
            if (ProdutoDAO.MinhaLista.get(i).getId() == id) {
                indice = i;
            }
        }
        return indice;
    }

    public Produto carregaProduto(int id) {
//        int indice = this.procuraIndice(id);
//        return AlunoDAO.MinhaLista.get(indice);
        dao.carregaProduto(id);
        return null;
    }

    public int maiorID() throws SQLException {
//    public int maiorID(){
//        return AlunoDAO.maiorID();
        return dao.maiorID();
    }
}
