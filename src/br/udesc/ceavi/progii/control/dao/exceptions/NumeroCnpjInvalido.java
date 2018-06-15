/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.control.dao.exceptions;

/**
 *
 * @author Eduardo Woloszyn
 */
public class NumeroCnpjInvalido extends Exception {

    public NumeroCnpjInvalido(String message) {
    super("Numero de CNPJ inválido"+message);
    
    }

    public NumeroCnpjInvalido(String string, Throwable thrwbl) {
        super("Numero de cpf inválido "+string, thrwbl);
    }
    
    
    
}
