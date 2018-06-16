/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.control.dao.interfaces;

import br.udesc.ceavi.progii.control.dao.exceptions.LetraCaixaException;
import br.udesc.ceavi.progii.control.jpacontroller.CaixaJpaController;
import br.udesc.ceavi.progii.control.jpacontroller.FilialJpaController;
import br.udesc.ceavi.progii.models.Caixa;
import br.udesc.ceavi.progii.models.Filial;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Woloszyn
 */
public class CaixaDAO implements DAO<Caixa> {
    
    private CaixaJpaController jpaCaixa ;
    
    @Override
    public boolean btnGravar(Caixa obj) throws LetraCaixaException {
        
        
        return true ;
    }

    @Override
    public boolean btnNovo(Caixa obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnCancelar(Caixa obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnExcluir(Caixa obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void create(Caixa objeto) {
        EntityManagerFactory objManagerFactory = Persistence.createEntityManagerFactory("GerenciadorSupermercadoPU");
                EntityManager manager = objManagerFactory.createEntityManager();
                jpaCaixa = new CaixaJpaController(objManagerFactory);
       try {
           jpaCaixa.create(objeto);
       } catch (Exception ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
           Logger.getLogger(FiliaisDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
