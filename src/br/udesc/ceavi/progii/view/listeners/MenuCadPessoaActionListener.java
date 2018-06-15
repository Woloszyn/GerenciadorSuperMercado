/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view.listeners;

import br.udesc.ceavi.progii.models.Pessoa;
import br.udesc.ceavi.progii.view.FrameCRUDPessoas;
import br.udesc.ceavi.progii.view.principal.FrameSistema;
import java.awt.event.ActionEvent;

/**
 * Esta classe serve para iniciar o frame de Pessoa no programa
 * @author Eduardo Woloszyn
 * @version 1.0
 * @since 25/05/2018
 */
public class MenuCadPessoaActionListener extends MenuActionListener {

    public MenuCadPessoaActionListener(FrameSistema tela) {
        super(tela);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Pessoa pessoa = new Pessoa() {};
        
        frame = FrameCRUDPessoas.getInstance();
        ((FrameCRUDPessoas)frame).setPessoa(pessoa);
        
        ListenerCRUDPessoa listenerPessoa = ListenerCRUDPessoa.getInstancia(pessoa, frame);
        
        tela.addIntFrame(frame);
       frame.setVisible(true);
        
    }
    
}
