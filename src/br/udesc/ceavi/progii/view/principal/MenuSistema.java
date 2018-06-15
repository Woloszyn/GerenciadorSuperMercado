/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view.principal;

import br.udesc.ceavi.progii.view.listeners.MenuCadCaixaActionListener;
import br.udesc.ceavi.progii.view.listeners.MenuCadEstoqueActionListener;
import br.udesc.ceavi.progii.view.listeners.MenuCadFiliaisActionListener;
import br.udesc.ceavi.progii.view.listeners.MenuCadFornecedorActionListener;
import br.udesc.ceavi.progii.view.listeners.MenuCadPessoaActionListener;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Menu bar
 * @author Eduardo Woloszyn
 */
public class MenuSistema extends JMenuBar {
    private JMenu menuCaixa;
    //teste
    private JMenu menuEstoque;
    private JMenu menuCadastroPessoa;
    private JMenu menuFiliais;
    private JMenu menuFornecedor ;
    
    private JMenuItem menuCrudCaixa ;
    private JMenuItem menuCrudEstoque;
    private JMenuItem menuCrudFiliais;
    private JMenuItem menuCrudFornecedor;
    private JMenuItem menuCrudCadPessoa;
    
    private FrameSistema tela;

  
    public MenuSistema(FrameSistema frame) {
        super();
        this.tela = frame;

        initializeComponents();

        construirMenu();
        
        addListenersMenu();
        

    }

    private void initializeComponents() {
        menuCaixa = new JMenu("Caixa");
        menuCrudCaixa = new JMenuItem("Modificar");
        
        menuCadastroPessoa = new JMenu("Cadastro de Pessoa");
        menuCrudCadPessoa = new JMenuItem("Modificar");
        
        menuEstoque = new JMenu("Estoque");
        menuCrudEstoque = new JMenuItem("Modificar");
        
        menuFiliais = new JMenu("Filiais");
        menuCrudFiliais = new JMenuItem("Modificar");
        
        menuFornecedor = new JMenu("Fornecedor");
        menuCrudFornecedor = new JMenuItem("Modificar");
    }

    private void construirMenu() {
        menuCaixa.add(menuCrudCaixa);
        super.add(menuCaixa);
        
        menuCadastroPessoa.add(menuCrudCadPessoa);
        super.add(menuCadastroPessoa);
        
        menuEstoque.add(menuCrudEstoque);
        super.add(menuEstoque);
        
        menuFiliais.add(menuCrudFiliais);
        super.add(menuFiliais);
        
        menuFornecedor.add(menuCrudFornecedor);
        super.add(menuFornecedor);
    }
    
    private void addListenersMenu() {
        ActionListener listener = new MenuCadCaixaActionListener(tela);
        menuCrudCaixa.addActionListener(listener);
        
        listener = new MenuCadFiliaisActionListener(tela);
        menuCrudFiliais.addActionListener(listener);
        
        listener = new MenuCadPessoaActionListener(tela);
        menuCrudCadPessoa.addActionListener(listener);
        
        listener = new MenuCadEstoqueActionListener(tela);
        menuCrudEstoque.addActionListener(listener);
        
        listener = new MenuCadFornecedorActionListener(tela);
        menuCrudFornecedor.addActionListener(listener);
        
    }
    
    
}
