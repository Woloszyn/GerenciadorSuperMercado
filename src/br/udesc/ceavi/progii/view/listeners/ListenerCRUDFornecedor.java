/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view.listeners;

import br.udesc.ceavi.progii.models.Fornecedores;
import br.udesc.ceavi.progii.models.Produtos;
import br.udesc.ceavi.progii.view.FrameCRUD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Woloszyn
 */
public class ListenerCRUDFornecedor {
    private static ListenerCRUDFornecedor instancia ;
    private Fornecedores fornecedor ;
    private FrameCRUD frameCrud ;

    ListenerCRUDFornecedor(Fornecedores fornecedor, FrameCRUD frameCrud) {
        this.fornecedor = fornecedor;
        this.frameCrud = frameCrud;
        addActionListener();
    }



   
   public static ListenerCRUDFornecedor getInstancia(Fornecedores fornecedor, FrameCRUD frame) {
        if (instancia==null) {
            instancia = new ListenerCRUDFornecedor(fornecedor, frame);
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
            // metodo para gravar no banco de dados 
                frameCrud.limparCampos();
            
        }
    }

}
