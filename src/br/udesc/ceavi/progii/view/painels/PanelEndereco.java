/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view.painels;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Eduardo, Woloszyn Denilson Laucsen da Rosa, Leonardo Steinke
 */
public class PanelEndereco extends JPanel{
    
    private Label lbRua;
    private Label lbNumero;
    private Label lbBairro;
    private Label lbCidade;
    private Label lbCEP;
    
    private JTextField tfRua;
    private JTextField tfNumero;
    private JTextField tfBairro;
    private JTextField tfCidade;
    private JTextField tfCEP;
    
    private Dimension dimensionPainel;
    
    private LayoutManager layout;
    
    private Container parent;
    
    public PanelEndereco(Container parent){
        this.parent = parent;
        
        initComponents();
        addComponents();
        
        super.setVisible(true);
        super.setSize(dimensionPainel);
        
    
}

    private void initComponents() {
        dimensionPainel = new Dimension(parent.getWidth(), 100);
        
        layout = new GridLayout(5,2);
        
        
        lbBairro = new Label("Bairro:");
        lbCEP = new Label("CEP:");
        lbCidade = new Label("Cidade:");
        lbNumero = new Label("Numero:");
        lbRua = new Label("Rua:");
        
        tfBairro = new JTextField();
        tfCEP = new JTextField();
        tfCidade = new JTextField();
        tfNumero = new JTextField();
        tfRua = new JTextField();
        
        
    }

    private void addComponents() {
        this.setLayout(layout);
        
        this.add(lbCidade);
        this.add(tfCidade);
        this.add(lbCEP);
        this.add(tfCEP);
        this.add(lbBairro);
        this.add(tfBairro);
        this.add(lbRua);
        this.add(tfRua);
        this.add(lbNumero);
        this.add(tfNumero);
        
    }

    public Label getLbRua() {
        return lbRua;
    }

    public Label getLbNumero() {
        return lbNumero;
    }

    public Label getLbBairro() {
        return lbBairro;
    }

    public Label getLbCidade() {
        return lbCidade;
    }

    public Label getLbCEP() {
        return lbCEP;
    }

    public JTextField getTfRua() {
        return tfRua;
    }

    public JTextField getTfNumero() {
        return tfNumero;
    }

    public JTextField getTfBairro() {
        return tfBairro;
    }

    public JTextField getTfCidade() {
        return tfCidade;
    }

    public JTextField getTfCEP() {
        return tfCEP;
    }

    public void setLbRua(Label lbRua) {
        this.lbRua = lbRua;
    }

    public void setLbNumero(Label lbNumero) {
        this.lbNumero = lbNumero;
    }

    public void setLbBairro(Label lbBairro) {
        this.lbBairro = lbBairro;
    }

    public void setLbCidade(Label lbCidade) {
        this.lbCidade = lbCidade;
    }

    public void setLbCEP(Label lbCEP) {
        this.lbCEP = lbCEP;
    }

    public void setTfRua(String tfRua) {
        this.tfRua.setText(tfRua);
    }

    public void setTfNumero(int tfNumero) {
        String s = ""+tfNumero;
        this.tfNumero.setText(s);
    }

    public void setTfBairro(String tfBairro) {
        this.tfBairro.setText(tfBairro);
    }

    public void setTfCidade(String tfCidade) {
        this.tfCidade.setText(tfCidade);
    }

    public void setTfCEP(String tfCEP) {
        this.tfCEP.setText(tfCEP);
    }
    
    
    
    
    
}
