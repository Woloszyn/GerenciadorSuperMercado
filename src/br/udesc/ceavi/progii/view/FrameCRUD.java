/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view;

import br.udesc.ceavi.progii.view.painels.CRUDActionPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import static javafx.scene.input.KeyCode.X;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 * Esta classe é uma padrão para CRUD  
 * @author Eduardo Woloszyn
 * @since 19/04/2018
 * @version 1.0
 */
public abstract class FrameCRUD extends JInternalFrame {
    private Dimension dimensaoFC; 
    private LayoutManager layout ;
    
     
    private JPanel panelCrud ;
    private JPanel panelPrincipal;

    public FrameCRUD(String titulo,Dimension dimensao) throws HeadlessException {
        this.dimensaoFC = dimensao;
        
        initializeComponents() ;
        addComponents() ;
        
        this.setTitle(titulo);
        super.setSize(this.dimensaoFC);
        super.setLayout(layout);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }

    private void initializeComponents() {
        panelPrincipal = new JPanel();
        panelPrincipal.setSize(dimensaoFC);
        
        panelCrud = new CRUDActionPanel(this) ;
        
        layout = new BorderLayout();
        panelPrincipal.setLayout(layout);
        
    }

    private void addComponents() {
        this.setContentPane(panelPrincipal);
        panelPrincipal.add(panelCrud,BorderLayout.SOUTH);
        
    }
    
    public void addFormulario(Container container) {
        panelPrincipal.add(container,BorderLayout.CENTER);
        
        
    }
    
    public CRUDActionPanel getPanelBotoesCRUD() {
        return (CRUDActionPanel) panelCrud;
    }

    public abstract void limparCampos() ;
    
    
}
