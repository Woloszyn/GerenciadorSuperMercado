package br.udesc.ceavi.progii.view;

import br.udesc.ceavi.progii.models.Fornecedores;
import br.udesc.ceavi.progii.models.TipoDeProduto;
import br.udesc.ceavi.progii.view.painels.PanelProdutos;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lenardo Steinke
 * @version 1.0
 * 
 */
public class FrameCRUDFornecedor extends FrameCRUD {
    
    
    private static FrameCRUDFornecedor instancia;
    
    private static final String titulo = "Cadastro de Fornecedor";
    private static final Dimension dimension = new Dimension(400, 400);
    
    
    private Fornecedores fornecedores;
    
    private Label lbCNPJ;
    private Label lbNomeEmpresa;
    private Label lbPedidoMin;
    private Label lbTipoProdu;
    
    private JTextField tfCNPJ;
    private JTextField tfNomeEmpresa;
    private JTextField tfPedidoMin;
    private JComboBox cbTipoProdu;
    
    private JPanel panelFormulario;
    private JPanel panelProdutos;
    private LayoutManager layout;
    private GridBagConstraints cons;
    
    private FrameCRUDFornecedor() {
        super(titulo, dimension);
        
        fornecedores = new Fornecedores();
        
        initializeComponents();
        addComponents();
    }
    
    public static FrameCRUDFornecedor getInstance(){
        if (instancia == null) {
            instancia = new FrameCRUDFornecedor();
        }
        
        return instancia;
    }
    
  
    
    private void initializeComponents(){
        lbCNPJ = new Label("CNPJ*:");
        lbNomeEmpresa = new Label("Nome Empresa:");
        lbPedidoMin = new Label("Pedido Mínimo:");
        lbTipoProdu = new Label("Tipo de Produto:");
        
        tfCNPJ = new JTextField();
        tfNomeEmpresa = new JTextField();
        tfPedidoMin = new JTextField();
        cbTipoProdu = new JComboBox(TipoDeProduto.values());
        
        cbTipoProdu.setSelectedIndex(-1);
        
        layout = new GridBagLayout();
        panelFormulario = new JPanel(layout);
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Dados do Fornecedor"));
        
        panelProdutos = new PanelProdutos(this);
        
        panelProdutos.setBorder(BorderFactory.createTitledBorder("Produtos"));
               
    }
    
  
    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCNPJ, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        panelFormulario.add(tfCNPJ, cons);
        
                cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbNomeEmpresa, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        panelFormulario.add(tfNomeEmpresa, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbPedidoMin, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        panelFormulario.add(tfPedidoMin, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbTipoProdu, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        panelFormulario.add(cbTipoProdu, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 20;
        cons.gridheight = 50;
        cons.fill = GridBagConstraints.HORIZONTAL;
        
        panelFormulario.add(panelProdutos, cons);
        
        
        super.addFormulario(panelFormulario);
    }
    
    public FrameCRUDFornecedor(String titulo, Dimension dimensao) throws HeadlessException {
        super(titulo, dimensao);
    }

    @Override
    public void limparCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void carregarCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setFornecedores(Fornecedores fornecedor) {
        this.fornecedores = fornecedor;
        
    }
    
}
