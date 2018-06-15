/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view.listeners;

import br.udesc.ceavi.progii.models.Produtos;
import br.udesc.ceavi.progii.view.FrameCRUDEstoque;
import br.udesc.ceavi.progii.view.principal.FrameSistema;
import java.awt.event.ActionEvent;

/**
 * Esta classe adiciona ao pressionar o botão modificar o internalframe para o jdesktop
 * @author Eduardo Woloszyn
 * @since 26/05/2018
 * @version 1.0
 */
public class MenuCadEstoqueActionListener extends MenuActionListener {

    public MenuCadEstoqueActionListener(FrameSistema tela) {
        super(tela);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Produtos produto = new Produtos();
        frame = FrameCRUDEstoque.getInstance();
        
        ((FrameCRUDEstoque)frame).setProduto(produto);
         ListenerCRUDEstoque estoque = ListenerCRUDEstoque.getInstancia(produto, frame);
       
        tela.addIntFrame(frame);
        frame.setVisible(true);
        
       
        
        
    }
    
    
}
