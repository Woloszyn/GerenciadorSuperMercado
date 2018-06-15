/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view;

import br.udesc.ceavi.progii.models.Funcionario;
import br.udesc.ceavi.progii.models.Pessoa;
import br.udesc.ceavi.progii.view.painels.PanelCliente;
import br.udesc.ceavi.progii.view.painels.PanelFuncionario;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Esta classe serve como modelo para criação de cadastro de pessoas
 * @author Eduardo Woloszyn
 * @since 19/04/2018
 * @version 1.0 
 */
public  class FrameCRUDPessoas extends FrameCRUD {
    private static FrameCRUDPessoas instancia;
    private PanelCliente panelClie ;
    private PanelFuncionario panelFunc ;
    
    private static final String titulo = "Cadastro Pessoa" ;
    private static final Dimension dimensao = new Dimension(600, 400);
    
    private Pessoa pessoa ;
    private JLabel lblNome ;
    private JLabel lblCPF ;
    private JLabel lblTelefone ;
    private JLabel lblRG ;
    private JRadioButton rdClient ;
    private JRadioButton rdFunc ;
    
    
    private JTextField tfNome ;
    private JTextField tfCPF ;
    private JTextField tfTelefone ;
    private JTextField tfRG ;
    
    private JPanel panelFormulario ;
    private LayoutManager layout ;
    private GridBagConstraints cons ;
    private Container contClie ;
    
    private FrameCRUDPessoas() {
        super(titulo,dimensao);
        
        initComponents();
        addComponents();
        
    }

    public static FrameCRUDPessoas getInstance(){
        if(instancia == null) {
            instancia = new FrameCRUDPessoas();
        }
        
        return instancia;
    }
    
    private void initComponents() {
        lblCPF = new JLabel("CPF");
        lblNome = new JLabel("Nome");
        lblRG = new JLabel("RG");
        lblTelefone = new JLabel("Telefone");
        
        tfCPF= new JTextField();
        tfNome = new JTextField();
        tfRG = new JTextField();
        tfTelefone = new JTextField();
        
        
        rdClient = new JRadioButton("Cliente");
        rdFunc = new JRadioButton("Funcionario");
        contClie = new Container();
        contClie.setSize(300, 200);
        panelClie = new PanelCliente(contClie);
        panelClie.setBorder(BorderFactory.createTitledBorder("Dados Cliente"));
        panelFunc = new PanelFuncionario(contClie);
        panelFunc.setBorder(BorderFactory.createTitledBorder("Funcionario"));
        layout = new GridBagLayout();
        
        
        panelFormulario = new JPanel(layout);
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Dados Pessoa"));
        
    }

    private void addComponents() {
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lblNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 10;
        panelFormulario.add(tfNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lblCPF, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 10;
        panelFormulario.add(tfCPF, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lblRG, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 10;
        panelFormulario.add(tfRG, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(lblTelefone, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 10;
        panelFormulario.add(tfTelefone, cons);

        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(rdClient, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 10;
        panelFormulario.add(rdFunc, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 10;
        panelFormulario.add(panelClie, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 6;
        cons.gridwidth = 3;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 10;
        panelFormulario.add(panelFunc, cons);
        
        
        super.addFormulario(panelFormulario);
        
        
    }

    @Override
    public void limparCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void carregarCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Pessoa getPessoa() {
        return this.pessoa ;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa ;
    }
        
    
    
    
}
