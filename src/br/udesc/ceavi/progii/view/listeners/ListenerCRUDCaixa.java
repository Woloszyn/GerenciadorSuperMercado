
package br.udesc.ceavi.progii.view.listeners;

import br.udesc.ceavi.progii.control.dao.exceptions.LetraCaixaException;
import br.udesc.ceavi.progii.control.dao.interfaces.CaixaDAO;
import br.udesc.ceavi.progii.control.dao.interfaces.DAO;
import br.udesc.ceavi.progii.control.dao.interfaces.FiliaisDAO;
import br.udesc.ceavi.progii.models.Caixa;
import br.udesc.ceavi.progii.view.FrameCRUD;
import br.udesc.ceavi.progii.view.FrameCRUDCaixa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Esta classe trata de adicionar Listeners para o CRUD da classe FrameCRUDCaixa
 * @author Eduardo Woloszyn
 * @version 1.0 
 * @since 07/05/2018
 */
public class ListenerCRUDCaixa {
 private static ListenerCRUDCaixa instancia ;
 //Está se referindo à camada Model
 private Caixa caixa ;
 //Está se referindo à camada View
 private FrameCRUD frame ;

    private ListenerCRUDCaixa(Caixa caixa, FrameCRUD frame) {
        this.caixa = caixa;
        this.frame = frame;
        
        addListeners() ;

    }

    public static ListenerCRUDCaixa getInstancia(Caixa caixa,FrameCRUD frame) {
        if (instancia==null) 
            instancia = new ListenerCRUDCaixa(caixa, frame);
        
            
        return instancia;
    }
    
    
    private void addListeners() {
        JButton botao ; 
        
        botao = frame.getPanelBotoesCRUD().getBtnCancelar();
        botao.addActionListener(new btCancelarActionListener());
        
        
        botao = frame.getPanelBotoesCRUD().getBtnExcluir();
        botao.addActionListener(new btExcluirActionListener());
        
        botao = frame.getPanelBotoesCRUD().getBtnGravar();
        botao.addActionListener(new btGravarActionListener());
        
        
        botao = frame.getPanelBotoesCRUD().getBtnNovo();
        botao.addActionListener(new btNovoActionListener());

        
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
            int resposta = JOptionPane.showConfirmDialog(frame,"Deseja excluir os campos ?","Confirmar ?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            
            if (resposta==JOptionPane.YES_OPTION) {
                
            frame.limparCampos();
                
            }
            
        }
    }
    
    private class btCancelarActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }
    private class btGravarActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           // falta a classe controller 
            DAO dao = new CaixaDAO();
            try {
            caixa = ((FrameCRUDCaixa)frame).getCaixa();
                
            } catch (NumberFormatException c) {
                JOptionPane.showMessageDialog(null, "Não é permitido usar letras aqui ","Erro",JOptionPane.ERROR_MESSAGE);
                ((FrameCRUDCaixa)frame).getTfEntrada().setText("*");
                ((FrameCRUDCaixa)frame).getTfSaida().setText("*");
                
            }
            
            try {
                dao.btnGravar(caixa);
                frame.limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Erro "+ex.getMessage());
                Logger.getLogger(ListenerCRUDCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
           frame.limparCampos();
        }
    }
}
