/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view.listeners;

import br.udesc.ceavi.progii.control.dao.exceptions.CampoVazioException;
import br.udesc.ceavi.progii.control.jpacontroller.FilialJpaController;
import br.udesc.ceavi.progii.control.dao.exceptions.NumeroCnpjInvalido;
import br.udesc.ceavi.progii.control.dao.interfaces.DAO;
import br.udesc.ceavi.progii.control.dao.interfaces.FiliaisDAO;
import br.udesc.ceavi.progii.models.Filial;
import br.udesc.ceavi.progii.view.FrameCRUD;
import br.udesc.ceavi.progii.view.FrameCRUDFiliais;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 * Listener para a tela de Filiais
 * @author Eduardo Woloszyn
 * @version 1.0
 * @since 07/05/2018
 */
public class ListenerCRUDFiliais {
    private static ListenerCRUDFiliais instancia ;
    
    
    private Filial filial ;
    
    private FrameCRUD frame ;
    FilialJpaController jpaFilial ;

    ListenerCRUDFiliais(Filial filial, FrameCRUD frame) {
        this.filial = filial;
        this.frame = frame;
        
        addListeners() ;
        
    }

    private void addListeners() {
        JButton botao ;
        
        botao  = frame.getPanelBotoesCRUD().getBtnCancelar();
        botao.addActionListener(new btCancelarActionListener());
        
        botao = frame.getPanelBotoesCRUD().getBtnExcluir();
        botao.addActionListener(new btExcluirActionListener());
        
        botao = frame.getPanelBotoesCRUD().getBtnGravar();
        botao.addActionListener(new btGravarActionListener());
        
        botao= frame.getPanelBotoesCRUD().getBtnNovo();
        botao.addActionListener(new btNovoActionListener());
        
        botao = ((FrameCRUDFiliais)frame).getBtnPesquisa();
        botao.addActionListener(new btnBusca());
        
    }

    public static ListenerCRUDFiliais getInstancia(Filial filial, FrameCRUD frame) {
        if (instancia==null) 
            instancia = new ListenerCRUDFiliais(filial, frame);
        
        
        return instancia;
    }
    
    private class btCancelarActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }
    private class btNovoActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.limparCampos();
        }
    }
    private class btExcluirActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int resposta = JOptionPane.showConfirmDialog(frame,"Deseja excluir os dados selecionados ?","Confirmar?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    filial =((FrameCRUDFiliais)frame).getFilial();
                    DAO dao = new FiliaisDAO();
                    dao.btnExcluir(filial);
                    frame.limparCampos();
                } catch (Exception ex) {
                    
                    Logger.getLogger(ListenerCRUDFiliais.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        }
    }
    private class btGravarActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            // método para gravar 
            DAO dao = new FiliaisDAO();
            try {
            filial = ((FrameCRUDFiliais)frame).getFilial();
                
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Campo Número não pode ser letra","Erro",JOptionPane.ERROR_MESSAGE);
            }
           
            try {
                dao.btnGravar(filial);
                frame.limparCampos();
                
            // se os dados estiverem corretos irá gravar, senão irá disparar a exceção
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(ListenerCRUDFiliais.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            
        }
        
        
        
        
    }
    
    private class btnBusca implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            FiliaisDAO dao = new FiliaisDAO();
            EntityManagerFactory objManagerFactory = Persistence.createEntityManagerFactory("GerenciadorSupermercadoPU");
            EntityManager manager = objManagerFactory.createEntityManager();
            jpaFilial = new FilialJpaController(objManagerFactory);
            
            
            try {
                dao.btnPesquisar(((FrameCRUDFiliais)frame).getPesquisa());
            } catch (CampoVazioException ex) {
                Logger.getLogger(ListenerCRUDFiliais.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        try {
            Filial findFilial = jpaFilial.findFilial(((FrameCRUDFiliais)frame).getPesquisa());
            filial = findFilial ;
            ((FrameCRUDFiliais)frame).carregarCampos(filial);
       } catch (Exception ex) {
           JOptionPane.showMessageDialog(null,"Filial não encontrada");
           Logger.getLogger(FiliaisDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
            
        }
        
    }
    
    
    
}