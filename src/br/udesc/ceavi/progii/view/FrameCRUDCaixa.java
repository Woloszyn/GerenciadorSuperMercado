/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view;

import br.udesc.ceavi.progii.models.Caixa;
import br.udesc.ceavi.progii.view.listeners.ListenerCRUDCaixa;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Eduardo Woloszyn
 */
public  class FrameCRUDCaixa extends FrameCRUD {
    private static FrameCRUDCaixa instancia;
    private static final String titulo = "Caixa" ;
    private static final Dimension dimensao = new Dimension(600, 400);
    
    
    private final String colunas[]={"Entrada","Saida","Saldo"};
    private final String dados[][]={
            {"400","500","-100"},
            {"200","100","100"},
            {"100","10","90"}};
    
    private JTable tabela ;
    private JScrollPane scrollRola ;
    
    private Caixa caixa ;
    private JLabel lblEntrada ;
    private JLabel lblSaida ;
    private JLabel lblSaldo ;
    
    private JButton botaoRelatorio ;
    
    
    private JTextField tfEntrada ;
    private JTextField tfSaida ;
    private JTextField tfSaldo ;
    
    private JPanel panelFormulario ;
    private LayoutManager layout ;
    private GridBagConstraints cons ;
    
    private FrameCRUDCaixa() {
        super(titulo,dimensao);
        
        initComponents();
        addComponents();
        
    } 
    
   

    public static FrameCRUDCaixa getInstance(){
        if(instancia == null) {
            instancia = new FrameCRUDCaixa();
        }
        
        return instancia;
    }
    
    private void initComponents() {
        lblEntrada = new JLabel("Entrada");
        lblSaida = new JLabel("Saida");
        lblSaldo = new JLabel("Saldo");
        
        tfEntrada= new JTextField();
        tfSaida = new JTextField();
        tfSaldo = new JTextField();
        
        botaoRelatorio = new JButton("Gerar Relatório");
        botaoRelatorio.setSize(new Dimension(30,20));
        
        layout = new GridBagLayout();
        
        
        panelFormulario = new JPanel(layout);
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Caixa"));
        
        tabela = new JTable(dados, colunas);
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 100));
        tabela.setFillsViewportHeight(true);
        
        scrollRola = new JScrollPane(tabela);
        
    }

    public Caixa getCaixa() {
        caixa.setEntrada(Double.parseDouble(tfEntrada.getText()));
        caixa.setSaida(Double.parseDouble(tfSaida.getText()));
        caixa.setSaldo(calculaSaldo());
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lblEntrada, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 10;
        panelFormulario.add(tfEntrada, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lblSaida, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 10;
        panelFormulario.add(tfSaida, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(scrollRola, cons);
        

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(botaoRelatorio, cons);
        
        super.addFormulario(panelFormulario);
        
        
    }

    public JTextField getTfEntrada() {
        return tfEntrada;
    }

    public void setTfEntrada(JTextField tfEntrada) {
        this.tfEntrada = tfEntrada;
    }

    public JTextField getTfSaida() {
        return tfSaida;
    }

    public void setTfSaida(JTextField tfSaida) {
        this.tfSaida = tfSaida;
    }
    
    @Override
    public void limparCampos() {
        

    }

    
    public void carregarCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private double calculaSaldo() {
        return getCaixa().getEntrada()-getCaixa().getSaida();
    }
        
    
    
    
}