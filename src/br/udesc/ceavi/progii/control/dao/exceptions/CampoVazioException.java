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
public class CampoVazioException extends Exception{

    public CampoVazioException() {
        super("O campo de pesquisa está vazio");
    }

    public CampoVazioException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
    
}
