package Model;
import DAO.ProdutoDAO;
import java.util.*;
import java.sql.SQLException;

public class Produto {

// atributos
    private int id;
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;
    private String datacadastro;
    private final ProdutoDAO dao;

    public Produto() {
        this.dao = new ProdutoDAO();
    }

    public Produto(int id, String nome, String descricao, int quantidade, double preco, String datacadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.datacadastro = datacadastro;
        this.dao = new ProdutoDAO();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }


    public ArrayList getMinhaLista() {
        return dao.getMinhaLista();
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
