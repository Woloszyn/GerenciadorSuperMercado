
package br.udesc.ceavi.progii.control.dao.interfaces;

import br.udesc.ceavi.progii.control.dao.exceptions.CampoVazioException;
import br.udesc.ceavi.progii.control.jpacontroller.FilialJpaController;
import br.udesc.ceavi.progii.control.dao.exceptions.NumeroCEPInvalido;
import br.udesc.ceavi.progii.control.dao.exceptions.NumeroCnpjInvalido;
import br.udesc.ceavi.progii.control.dao.exceptions.NumeroNumeroInvalido;
import br.udesc.ceavi.progii.models.Filial;
import br.udesc.ceavi.progii.view.FrameCRUDFiliais;
import br.udesc.ceavi.progii.view.listeners.ListenerCRUDFiliais;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 * Esta classe define as exceções disparadas para o Frame filiais
 * @author Eduardo Woloszyn
 * @version 1.0
 * @since 04/06/2018
 */
public class FiliaisDAO implements DAO<Filial>{
   private FilialJpaController jpaFilial;
    
    @Override
    public boolean btnGravar(Filial obj) throws NumeroCnpjInvalido,NumeroCEPInvalido, NumeroNumeroInvalido {
        if (obj.getCnpj().length()>14) {
            throw new NumeroCnpjInvalido(" Número maior que o válido");
        } else if (obj.getCnpj().length()<14) {
            throw new NumeroCnpjInvalido(" Número menor que o válido");
        } 
        
        if (obj.getCep().length()>8) {
            throw new NumeroCEPInvalido("Número maior que 8 digitos");
        } else if (obj.getCep().length()<8) {
            throw new NumeroCEPInvalido("Número menor que 8 digitos");
        } 
        if (obj.getNumero()>10000 || obj.getNumero()<1) {
            throw new NumeroNumeroInvalido("Número não está no intervalo certo");
        } 
        create(obj);
     return true ;   
    }

    @Override
    public boolean btnNovo(Filial obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnCancelar(Filial obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnExcluir(Filial obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean btnPesquisar(String obj)throws CampoVazioException{
        if (obj.isEmpty()) {
            throw new CampoVazioException()  ;
        }
            
       
       
        return true ;
    }
    
    private void create(Filial objeto) {
        EntityManagerFactory objManagerFactory = Persistence.createEntityManagerFactory("GerenciadorSupermercadoPU");
                EntityManager manager = objManagerFactory.createEntityManager();
                jpaFilial = new FilialJpaController(objManagerFactory);
       try {
           jpaFilial.create(objeto);
       } catch (Exception ex) {
           Logger.getLogger(FiliaisDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
        
    
    
    
}
