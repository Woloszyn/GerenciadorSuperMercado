/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view;

import br.udesc.ceavi.progii.models.Produtos;
import br.udesc.ceavi.progii.view.painels.PanelProdutos;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Frame Utilizado para cadastrar Produtos
 * @author Eduardo Woloszyn
 * @version 1.0
 * @since  22/04/2018
 */
public  class FrameCRUDEstoque extends FrameCRUD {
    private static FrameCRUDEstoque instancia;
    private JTable tabela ;
    private static final String titulo = "Estoque" ;
    private static final Dimension dimensao = new Dimension(600, 400);
    private JScrollPane scrollRolagem ;
    
    private Produtos produtos ;
    private JPanel panelFormulario ;
    private PanelProdutos panelProdutos ;
    private LayoutManager layout ;
    private GridBagConstraints cons ;
    private Container contProd ;
    
    private FrameCRUDEstoque() {
        super(titulo,dimensao);
        
        initComponents();
        addComponents();
        
    }

    public static FrameCRUDEstoque getInstance(){
        if(instancia == null) {
            instancia = new FrameCRUDEstoque();
        }
        
        return instancia;
    }
    
    private void initComponents() {
        
        contProd = new Container();
        contProd.setSize(300, 200);
        panelProdutos = new PanelProdutos(contProd);
        panelProdutos.setBorder(BorderFactory.createTitledBorder("Produtos"));
        layout = new GridBagLayout();
         tabela=new JTable();
        tabela.setPreferredScrollableViewportSize(new Dimension(500,100));//barra de rolagem
        tabela.setFillsViewportHeight(true);
        scrollRolagem = new JScrollPane(tabela);
        panelFormulario = new JPanel(layout);
        
        
    }

    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 10 ;
        panelFormulario.add(panelProdutos, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 10;
        panelFormulario.add(scrollRolagem, cons);

        
        
        super.addFormulario(panelFormulario);
        
        
    }

    @Override
    public void limparCampos() {
        panelProdutos.setTfID("");
        panelProdutos.setTfLote("");
        panelProdutos.setTfNome("");
        panelProdutos.setTfPreco("");
        panelProdutos.setTfQuant("");
        panelProdutos.setTfValidade("");
        
    }

    
    public void carregarCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setProduto(Produtos produto) {
       this.produtos = produto ;
               
    }
        
    public Produtos getProduto(Produtos produto) {
        produto.setId(Integer.parseInt(panelProdutos.getTfID().getText()));
        
        return this.produtos;  
    }
    
    
}