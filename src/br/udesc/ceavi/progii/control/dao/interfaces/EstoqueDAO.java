/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.control.dao.interfaces;

import br.udesc.ceavi.progii.models.Produtos;

/**
 *
 * @author Eduardo Woloszyn
 */
public class EstoqueDAO implements DAO<Produtos> {

    @Override
    public boolean btnGravar(Produtos obj) throws Exception {
        
        
        
        return true ;
    }

    @Override
    public boolean btnNovo(Produtos obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnCancelar(Produtos obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean btnExcluir(Produtos obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
