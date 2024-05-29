package View;

import DAO.DaoTblProduto;
import Model.Produto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

public class Produtos extends javax.swing.JFrame {

    private DaoTblProduto produtoDAO;

    public Produtos() {
        initComponents();
        produtoDAO = new DaoTblProduto();
        configurarCamposFormatados();
        atualizarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo_Produtos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_produtos = new javax.swing.JTable();
        produto_nome = new javax.swing.JLabel();
        nome_produto = new javax.swing.JTextField();
        produto_descricao = new javax.swing.JLabel();
        descricao_produto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        quantidade_produto = new javax.swing.JSpinner();
        produto_preco = new javax.swing.JLabel();
        preco_produto = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        data_produto = new javax.swing.JFormattedTextField();
        b_cadastrarProduto = new javax.swing.JButton();
        b_editarProduto = new javax.swing.JButton();
        b_excluirProduto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titulo_Produtos.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        Titulo_Produtos.setText("Estoque Produtos");

        tbl_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Descrição", "Quantidade", "Preço", "Data de Cadastro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_produtosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_produtos);

        produto_nome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        produto_nome.setText("Nome:");

        nome_produto.setText("Informe o nome do produto...");

        produto_descricao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        produto_descricao.setText("Descrição:");

        descricao_produto.setText("Informe a descrição...");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quantidade:");

        produto_preco.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        produto_preco.setText("Preço:");

        preco_produto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        preco_produto.setText("R$0");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Data de Cadastro:");

        data_produto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        b_cadastrarProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        b_cadastrarProduto.setText("Cadastrar");
        b_cadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cadastrarProdutoActionPerformed(evt);
            }
        });

        b_editarProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        b_editarProduto.setText("Editar");
        b_editarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_editarProdutoActionPerformed(evt);
            }
        });

        b_excluirProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        b_excluirProduto.setText("Excluir");
        b_excluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_excluirProdutoActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/back.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(b_cadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)
                        .addComponent(b_editarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_excluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(produto_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(produto_descricao)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nome_produto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(descricao_produto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addComponent(quantidade_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(55, 55, 55)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(preco_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(produto_preco))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(data_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(106, 106, 106)))
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(Titulo_Produtos)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addComponent(Titulo_Produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(produto_nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(produto_descricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descricao_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(produto_preco)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantidade_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preco_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_editarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_excluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_produtosMouseClicked
        int selectedRow = tbl_produtos.getSelectedRow();
        if (selectedRow >= 0) {
            nome_produto.setText(tbl_produtos.getValueAt(selectedRow, 1).toString());
            descricao_produto.setText(tbl_produtos.getValueAt(selectedRow, 2).toString());

            // Conversão de String para Integer
            try {
                quantidade_produto.setValue(Integer.parseInt(tbl_produtos.getValueAt(selectedRow, 3).toString()));
            } catch (NumberFormatException e) {
                quantidade_produto.setValue(0);
                System.err.println("Erro ao converter quantidade: " + e.getMessage());
            }

            // Conversão de Object para Double
            try {
                Object precoObj = tbl_produtos.getValueAt(selectedRow, 4);
                if (precoObj instanceof Number) {
                    preco_produto.setValue(((Number) precoObj).doubleValue());
                } else {
                    preco_produto.setValue(Double.parseDouble(precoObj.toString().replace(",", ".")));
                }
            } catch (NumberFormatException e) {
                preco_produto.setValue(0.0);
                System.err.println("Erro ao converter preço: " + e.getMessage());
            }

            data_produto.setText(converterDataParaFormatoBR(tbl_produtos.getValueAt(selectedRow, 5).toString()));
        }
    }//GEN-LAST:event_tbl_produtosMouseClicked

    private void b_cadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cadastrarProdutoActionPerformed
        try {
            String nome = "";
            String descricao = "";
            int quantidade = 0;
            double preco = 0.0;
            String dataCadastro = "";

            if (this.nome_produto.getText().length() < 2) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.nome_produto.getText();
            }
            if (this.descricao_produto.getText().length() < 2) {
                throw new Mensagens("Descrição deve ter ao menos 2 caracteres.");
            } else {
                descricao = this.descricao_produto.getText();
            }
            if (Integer.parseInt(this.quantidade_produto.getValue().toString()) <= 0) {
                throw new Mensagens("Quantidade deve ser número e maior que zero.");
            } else {
                quantidade = Integer.parseInt(this.quantidade_produto.getValue().toString());
            }
            if (Double.parseDouble(this.preco_produto.getValue().toString()) <= 0) {
                throw new Mensagens("Preço deve ser número e maior que zero.");
            } else {
                preco = Double.parseDouble(this.preco_produto.getValue().toString());
            }
            if (this.data_produto.getText().length() < 10) {
                throw new Mensagens("Data de cadastro deve ser preenchida no formato dd/MM/yyyy.");
            } else {
                dataCadastro = this.data_produto.getText();
            }

            Produto produto = new Produto(0, nome, descricao, quantidade, preco, Date.valueOf(converterDataParaFormatoSQL(dataCadastro)));

            if (produtoDAO.salvarProdutoBD(produto)) {
                JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
                atualizarTabela();
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar produto.");
            }
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_b_cadastrarProdutoActionPerformed

    private void b_editarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_editarProdutoActionPerformed
        try {
            int selectedRow = tbl_produtos.getSelectedRow();
            if (selectedRow >= 0) {
                int id = Integer.parseInt(tbl_produtos.getValueAt(selectedRow, 0).toString());
                String nome = "";
                String descricao = "";
                int quantidade = 0;
                double preco = 0.0;
                String dataCadastro = "";

                if (this.nome_produto.getText().length() < 2) {
                    throw new Mensagens("Nome deve conter ao menos 2 caracteres.");
                } else {
                    nome = this.nome_produto.getText();
                }
                if (this.descricao_produto.getText().length() < 2) {
                    throw new Mensagens("Descrição deve ter ao menos 2 caracteres.");
                } else {
                    descricao = this.descricao_produto.getText();
                }
                if (Integer.parseInt(this.quantidade_produto.getValue().toString()) <= 0) {
                    throw new Mensagens("Quantidade deve ser número e maior que zero.");
                } else {
                    quantidade = Integer.parseInt(this.quantidade_produto.getValue().toString());
                }
                if (Double.parseDouble(this.preco_produto.getValue().toString()) <= 0) {
                    throw new Mensagens("Preço deve ser número e maior que zero.");
                } else {
                    preco = Double.parseDouble(this.preco_produto.getValue().toString());
                }
                if (this.data_produto.getText().length() < 10) {
                    throw new Mensagens("Data de cadastro deve ser preenchida no formato dd/MM/yyyy.");
                } else {
                    dataCadastro = this.data_produto.getText();
                }

                Produto produto = new Produto(id, nome, descricao, quantidade, preco, Date.valueOf(converterDataParaFormatoSQL(dataCadastro)));

                if (produtoDAO.atualizarProdutoBD(produto)) {
                    JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
                    atualizarTabela();
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao atualizar produto.");
                }
            }
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }

    }//GEN-LAST:event_b_editarProdutoActionPerformed

    private void b_excluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_excluirProdutoActionPerformed
        try {
            int selectedRow = tbl_produtos.getSelectedRow();
            if (selectedRow >= 0) {
                int id = Integer.parseInt(tbl_produtos.getValueAt(selectedRow, 0).toString());

                // Usar a classe Mensagens para exibir a confirmação
                if (Mensagens.confirmarExclusao("Deseja realmente excluir o produto?")) {
                    if (produtoDAO.excluirProdutoBD(id)) {
                        Mensagens.exibirMensagem("Produto excluído com sucesso!");
                        atualizarTabela();
                        limparCampos();
                    } else {
                        Mensagens.exibirMensagem("Erro ao excluir produto.");
                    }
                }
            }
        } catch (Exception e) {
            Mensagens.exibirMensagem("Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_b_excluirProdutoActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
         Login voltartela = new Login();
        voltartela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void configurarCamposFormatados() {
        try {
            MaskFormatter maskData = new MaskFormatter("##/##/####");
            maskData.setPlaceholderCharacter('_');
            data_produto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(maskData));

            NumberFormat format = NumberFormat.getNumberInstance();
            format.setMinimumFractionDigits(2);
            format.setMaximumFractionDigits(2);
            NumberFormatter numberFormatter = new NumberFormatter(format);
            numberFormatter.setAllowsInvalid(false);
            preco_produto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(numberFormatter));

            SpinnerNumberModel quantidadeModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
            quantidade_produto.setModel(quantidadeModel);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void atualizarTabela() {
        try {
            List<Produto> produtos = produtoDAO.listarProdutosBD();
            DefaultTableModel model = (DefaultTableModel) tbl_produtos.getModel();
            model.setRowCount(0);
            for (Produto p : produtos) {
                model.addRow(new Object[]{p.getId(), p.getNome(), p.getDescricao(), p.getQuantidade(), p.getPreco(), converterDataParaFormatoBR(p.getDatacadastro().toString())});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        nome_produto.setText("");
        descricao_produto.setText("");
        quantidade_produto.setValue(0);
        preco_produto.setValue(0.0);
        data_produto.setText("");
    }

    private String converterDataParaFormatoBR(String data) {
        try {
            if (data.contains("-")) {
                // Formato yyyy-MM-dd
                String[] dataArray = data.split("-");
                if (dataArray.length == 3) {
                    return dataArray[2] + "/" + dataArray[1] + "/" + dataArray[0];
                }
            } else if (data.contains("/")) {
                // Formato dd/MM/yyyy
                String[] dataArray = data.split("/");
                if (dataArray.length == 3) {
                    return data;
                }
            }
            System.err.println("Data no formato inesperado: " + data);
            return data;
        } catch (Exception e) {
            System.err.println("Erro ao converter data para formato BR: " + e.getMessage());
            return data;
        }
    }

    private String converterDataParaFormatoSQL(String data) {
        try {
            if (data.contains("/")) {
                // Formato dd/MM/yyyy
                String[] dataArray = data.split("/");
                if (dataArray.length == 3) {
                    return dataArray[2] + "-" + dataArray[1] + "-" + dataArray[0];
                }
            } else if (data.contains("-")) {
                // Formato yyyy-MM-dd
                String[] dataArray = data.split("-");
                if (dataArray.length == 3) {
                    return data;
                }
            }
            System.err.println("Data no formato inesperado: " + data);
            return data;
        } catch (Exception e) {
            System.err.println("Erro ao converter data para formato SQL: " + e.getMessage());
            return data;
        }
    }

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produtos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo_Produtos;
    private javax.swing.JButton b_cadastrarProduto;
    private javax.swing.JButton b_editarProduto;
    private javax.swing.JButton b_excluirProduto;
    private javax.swing.JFormattedTextField data_produto;
    private javax.swing.JTextField descricao_produto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nome_produto;
    private javax.swing.JFormattedTextField preco_produto;
    private javax.swing.JLabel produto_descricao;
    private javax.swing.JLabel produto_nome;
    private javax.swing.JLabel produto_preco;
    private javax.swing.JSpinner quantidade_produto;
    private javax.swing.JTable tbl_produtos;
    // End of variables declaration//GEN-END:variables
}
