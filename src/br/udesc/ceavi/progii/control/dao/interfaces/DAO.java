/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.control.dao.interfaces;

import br.udesc.ceavi.progii.control.dao.exceptions.NumeroCEPInvalido;
import br.udesc.ceavi.progii.control.dao.exceptions.NumeroCnpjInvalido;

/**
 *
 * @author Eduardo Woloszyn
 */
public interface DAO<X > {
    boolean btnGravar(X obj) throws Exception ;
    boolean btnNovo(X obj) throws Exception;
    boolean btnCancelar(X obj) throws Exception;
    boolean btnExcluir(X obj) throws Exception;
    
    
    
}
