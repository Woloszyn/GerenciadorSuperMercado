package br.udesc.ceavi.progii.view.painels;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lenardosteinke
 */
 public class PanelProdutos extends JPanel{
     private Dimension dimensaoPanel;
     
     private LayoutManager layout;
     
     private Label lbID;
     private Label lbNome;
     private Label lbQuant;
     private Label lbPreco;
     private Label lbValidade;
     private Label lbLote;
     
     private JTextField tfID;
     private JTextField tfNome;
     private JTextField tfQuant;
     private JTextField tfPreco;
     private JTextField tfValidade;
     private JTextField tfLote;
     
     private GridBagConstraints cons;
     
     private Container parent;

    public PanelProdutos(Container parent) {
        this.parent = parent;
        initComponents();
        addComponents();
        
        super.setVisible(true);
        super.setSize(dimensaoPanel);
                
    }
            
     private void initComponents(){
         lbID = new Label("ID:");
         lbLote = new Label("Lote:");
         lbNome = new Label("Nome:");
         lbPreco = new Label("Preço:");
         lbQuant = new Label("Quantidade:");
         lbValidade = new Label("Validade:");
         
         tfID = new JTextField();
         
         tfLote = new JTextField();
         tfNome = new JTextField();
         tfPreco = new JTextField();
         tfQuant = new JTextField();
         tfValidade = new JTextField();
        
         layout = new GridBagLayout();    
     }
     private void addComponents(){
         
         dimensaoPanel = new Dimension(200, 200);
         this.setLayout(layout);
         
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        this.add(lbID, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        this.add(tfID, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        this.add(lbNome, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 1;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        this.add(tfNome, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        this.add(lbPreco, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 2;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        this.add(tfPreco, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        this.add(lbPreco, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 3;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        this.add(tfPreco, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        this.add(lbQuant, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        this.add(tfQuant, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 4;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        this.add(lbValidade, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 4;
        cons.gridwidth = 2;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        this.add(tfValidade, cons);
        
        cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.gridy = 5;
        cons.gridwidth = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        this.add(lbLote, cons);

        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 5;
        cons.gridwidth = 12;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 50;
        this.add(tfLote, cons);
         
     }

    public JTextField getTfID() {
        return tfID;
    }

    public void setTfID(String tfID) {
        this.tfID.setText(tfID);
    }

    public JTextField getTfNome() {
        return tfNome;
    }

    public void setTfNome(String tfNome) {
        this.tfNome.setText(tfNome);
    }

    public JTextField getTfQuant() {
        return tfQuant;
    }

    public void setTfQuant(String tfQuant) {
        this.tfQuant.setText(tfQuant);
    }

    public JTextField getTfPreco() {
        return tfPreco;
    }

    public void setTfPreco(String tfPreco) {
        this.tfPreco.setText(tfPreco);
    }

    public JTextField getTfValidade() {
        return tfValidade;
    }

    public void setTfValidade(String tfValidade) {
        this.tfValidade.setText(tfValidade);
    }

    public JTextField getTfLote() {
        return tfLote;
    }

    public void setTfLote(String tfLote) {
        this.tfLote.setText(tfLote);
    }
     
     
     
}
