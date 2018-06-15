package br.udesc.ceavi.progii.view;

import br.udesc.ceavi.progii.models.Filial;
import br.udesc.ceavi.progii.view.painels.PanelEndereco;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Eduardo Woloszyn, Denilson Laucsen ,Leonardo Steinke
 */
public class FrameCRUDFiliais extends FrameCRUD{
    
    private static FrameCRUDFiliais instancia;
    
    private static final String titulo = "Cadastro de Filiais";
    private static final Dimension dimension = new Dimension (450,400);
    
    //private Filiais filial;
    
    private Label lbNome;
    private Label lbCNPJ;
    private Label lbPesquisa ;
    
    private JTextField tfNome;
    private JTextField tfCNPJ;
    private JTextField tfPesquisa;
    
    private JButton btnPesquisa ;
    
    private JPanel panelFormulario;
    private PanelEndereco panelEndereco;
    
    private LayoutManager layout;
    private GridBagConstraints cons;
    
    private Filial filial ;
    public FrameCRUDFiliais(){
        super(titulo, dimension);
        
       //endereco = new Endereco();

        initializeComponents();
        addComponents();
        
    }
    
    public static FrameCRUDFiliais getInstance(){
         if(instancia == null) {
             instancia = new FrameCRUDFiliais();
         }
        
        return instancia;
    }

    private void initializeComponents() {
        lbCNPJ = new Label("CNPJ:");
        lbNome = new Label("Nome:");
        lbPesquisa = new Label("Pesquisar Cnpj");
        
        tfPesquisa = new JTextField("Insira aqui o cnpj a ser buscado");
        tfCNPJ = new JTextField();
        tfNome = new JTextField();
        
        btnPesquisa = new JButton("Buscar");
        btnPesquisa.setSize(50,20);
        
        
        layout = new GridBagLayout();
        panelEndereco = new PanelEndereco(this);
        panelFormulario = new JPanel(layout);

        panelEndereco.setBorder(BorderFactory.createTitledBorder("Dados do Endereço"));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Dados da Filial"));
        
    }

    private void addComponents() {
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbPesquisa,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.ipadx = 160;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(tfPesquisa,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 2;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(btnPesquisa,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbCNPJ,cons);
        
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 100;
        panelFormulario.add(tfCNPJ,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lbNome,cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 160;
        panelFormulario.add(tfNome,cons);
        
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 100;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridheight = 50;
        panelFormulario.add(panelEndereco,cons);
        
        super.addFormulario(panelFormulario);
                
        
    }

    @Override
    public void limparCampos() {
        tfNome.setText("");
        tfCNPJ.setText("");
        panelEndereco.getTfBairro().setText("");
        panelEndereco.getTfCEP().setText("");
        panelEndereco.getTfCidade().setText("");
        panelEndereco.getTfNumero().setText("");
        panelEndereco.getTfRua().setText("");
        
    }

    public JTextField getTfNome() {
        return tfNome;
    }


    public JTextField getTfCNPJ() {
        return tfCNPJ;
    }

    

    public PanelEndereco getPanelEndereco() {
        return panelEndereco;
    }

    public void setPanelEndereco(PanelEndereco panelEndereco) {
        this.panelEndereco = panelEndereco;
    }

    public String getPesquisa() {
       
        return this.tfPesquisa.getText();
    }

    public void setTfPesquisa(JTextField tfPesquisa) {
        this.tfPesquisa = tfPesquisa;
    }

    public JButton getBtnPesquisa() {
        return btnPesquisa;
    }

    public void setBtnPesquisa(JButton btnPesquisa) {
        this.btnPesquisa = btnPesquisa;
    }
    
    
    
    public void carregarCampos(Filial obj) {
        this.tfCNPJ.setText(obj.getCnpj());
        this.tfNome.setText(obj.getNome());
        panelEndereco.setTfBairro(obj.getBairro());
        panelEndereco.setTfCEP(obj.getCep());
        panelEndereco.setTfCidade(obj.getCidade());
        panelEndereco.setTfNumero(obj.getNumero());
        panelEndereco.setTfRua(obj.getRua());
    }

    public Filial getFilial() {
     filial.setBairro(panelEndereco.getTfBairro().getText());
     filial.setCep(panelEndereco.getTfCEP().getText());
     filial.setCidade(panelEndereco.getTfCidade().getText());
     filial.setCnpj(getTfCNPJ().getText());
     filial.setNome(getTfNome().getText());
     filial.setNumero(Integer.parseInt(panelEndereco.getTfNumero().getText()) ) ;
     filial.setRua(panelEndereco.getTfRua().getText());
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    
    
    
}