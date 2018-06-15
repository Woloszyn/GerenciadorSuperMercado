/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.control.dao.exceptions;

/**
 * Esta classe será disparada caso o número do CEP for maior que oito digitos ou menor que oito digitos
 * @author Eduardo Woloszyn
 * @since 03/06/2018
 * @version 1.0
 */
public class NumeroCEPInvalido extends Exception {

    public NumeroCEPInvalido(String message) {
    super("CEP INVÁLIDO : "+message);
    
    }

    public NumeroCEPInvalido(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
    
}
