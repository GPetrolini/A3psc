package Model;

import DAO.DaoTblProduto;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;
    private Date datacadastro;
    private final DaoTblProduto daoProduto;

    public Produto() {
        this.daoProduto = new DaoTblProduto();
    }

    public Produto(int id, String nome, String descricao, int quantidade, double preco, Date datacadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.datacadastro = datacadastro;
        this.daoProduto = new DaoTblProduto();
    }

    // Getters e Setters
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

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    // Métodos de controle
    public boolean salvarProduto() {
        try {
            return this.daoProduto.salvarProdutoBD(this);
        } catch (SQLException e) {
            System.out.println("OCORREU UM ERRO AO SALVAR PRODUTO\n METODO: salvarProdutoBD\n erro: " + e);
            return false;
        }
    }

    public List<Produto> listaProdutos() {
        try {
            return this.daoProduto.listarProdutosBD();
        } catch (SQLException e) {
            System.out.println("OCORREU UM ERRO AO LISTAR PRODUTOS CADASTRADOS\n METODO: listarProdutosBD\n erro: " + e);
            return null;
        }
    }

    public Produto getProduto(int codigoProduto) {
        try {
            return this.daoProduto.buscarProdutoBD(codigoProduto);
        } catch (SQLException e) {
            System.out.println("OCORREU UM ERRO AO BUSCAR PRODUTO ATRAVES DE SEU CODIGO ID\n METODO: buscarProdutoBD\n erro: " + e);
            return null;
        }
    }

    public boolean atualizaProduto() {
        try {
            return this.daoProduto.atualizarProdutoBD(this);
        } catch (SQLException e) {
            System.out.println("OCORREU UM ERRO AO ATUALIZAR PRODUTO\n METODO: atualizarProdutoBD\n erro: " + e);
            return false;
        }
    }

    public boolean excluirProduto(int idProduto) {
        if (idProduto > 0) {
            try {
                return this.daoProduto.excluirProdutoBD(idProduto);
            } catch (SQLException ex) {
                System.out.println("ERRO NA EXCLUSÃO DE UM PRODUTO: " + ex);
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Descrição: " + this.getDescricao()
                + "\n Quantidade: " + this.getQuantidade()
                + "\n Preço: " + this.getPreco()
                + "\n Data de Cadastro: " + this.getDatacadastro();
    }
}