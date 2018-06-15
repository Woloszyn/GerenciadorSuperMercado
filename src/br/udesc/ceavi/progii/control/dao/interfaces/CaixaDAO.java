/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.control.dao.interfaces;

import br.udesc.ceavi.progii.control.dao.exceptions.LetraCaixaException;
import br.udesc.ceavi.progii.models.Caixa;

/**
 *
 * @author Eduardo Woloszyn
 */
public class CaixaDAO implements DAO<Caixa> {

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
    
}
