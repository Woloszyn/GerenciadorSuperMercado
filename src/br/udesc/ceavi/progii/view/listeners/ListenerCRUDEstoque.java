/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view.listeners;

import br.udesc.ceavi.progii.models.Produtos;
import br.udesc.ceavi.progii.view.FrameCRUD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *Esta classe faz a ligação de listener com os frames 
 * @author Eduardo Woloszyn
 * @version 1.0
 * @since 25/05/2018
 */
public class ListenerCRUDEstoque {
    private static ListenerCRUDEstoque instancia ;
    private Produtos produtos ;
    private FrameCRUD frameCrud ;

    private  ListenerCRUDEstoque(Produtos produtos, FrameCRUD frameCrud) {
        this.produtos = produtos;
        this.frameCrud = frameCrud;
        addActionListener();
        
    }

   
   public static ListenerCRUDEstoque getInstancia(Produtos produto, FrameCRUD frame) {
        if (instancia==null) {
            instancia = new ListenerCRUDEstoque(produto, frame);
        }
        
        
        return instancia;
    }
    
    private void addActionListener() {
        JButton botao = new JButton();
        
        botao = frameCrud.getPanelBotoesCRUD().getBtnCancelar();
        botao.addActionListener(new btnCancelar());
        
        botao = frameCrud.getPanelBotoesCRUD().getBtnExcluir();
        botao.addActionListener(new btExcluirActionListener());
        
        botao = frameCrud.getPanelBotoesCRUD().getBtnGravar();
        botao.addActionListener(new btGravarActionListener());
        
        botao = frameCrud.getPanelBotoesCRUD().getBtnNovo();
        botao.addActionListener(new btNovoActionListener());
    }
    
    
    private class btnCancelar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
             frameCrud.dispose();
        }

         
    }
    private class btNovoActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frameCrud.limparCampos();
        }
    }
    private class btExcluirActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int resposta = JOptionPane.showConfirmDialog(frameCrud,"Deseja excluir os dados selecionados ?","Confirmar?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (resposta == JOptionPane.YES_OPTION) {
               frameCrud.limparCampos();
            }
        
        }
    }
    private class btGravarActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
                
                frameCrud.limparCampos();
            
        }
    }
    
    
    
    
}
