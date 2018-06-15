/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.control.dao.exceptions;

/**
 * Esta classe é invocada caso o número no cadastro for inválido
 * @author Eduardo Woloszyn
 * @version 1.0
 * @since 03/06/2018
 */
public class NumeroNumeroInvalido extends Exception {

    public NumeroNumeroInvalido(String string) {
        super("Numero Inválido: "+string);
    }

    public NumeroNumeroInvalido(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
    
    
}
