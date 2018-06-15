/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view.listeners;

import br.udesc.ceavi.progii.models.Fornecedores;
import br.udesc.ceavi.progii.view.FrameCRUDFornecedor;
import br.udesc.ceavi.progii.view.principal.FrameSistema;
import java.awt.event.ActionEvent;

/**
 *
 * @author Eduardo Woloszyn
 */
public class MenuCadFornecedorActionListener extends MenuActionListener {

    public MenuCadFornecedorActionListener(FrameSistema tela) {
        super(tela);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Fornecedores fornecedor = new Fornecedores();
        frame = FrameCRUDFornecedor.getInstance();
        
        ((FrameCRUDFornecedor)frame).setFornecedores(fornecedor);
        
        ListenerCRUDFornecedor listener = ListenerCRUDFornecedor.getInstancia(fornecedor, frame) ;
        
        tela.addIntFrame(frame);
        frame.setVisible(true);
        
    }
    
    
    
}
