/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view.principal;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;

/**
 * Frame principal
 * @author Eduardo Woloszyn
 */
public class FrameSistema extends JFrame {
    private static Dimension dimensaoTela ;
    // dimensão tela 
    private JDesktopPane desktop  ;
    
    private Container contentPane ;
    
    private JMenuBar menubar ;
    public FrameSistema() throws HeadlessException {
    super() ;
    
    super.setTitle("Sistema de Gerenciamento de Supermercado");
    
    dimensaoTela = new Dimension(800, 600);
    super.setSize(dimensaoTela);
    
     initializeDesktopPane() ;
     adicionarMenuPrincipal() ;
     
     super.setResizable(true);
     super.setLocationRelativeTo(null);
     
     super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    
    
    }

    private void initializeDesktopPane() {
        desktop = new JDesktopPane();
        contentPane = super.getContentPane();
        contentPane.add(desktop, BorderLayout.CENTER);
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        
    }

    private void adicionarMenuPrincipal() {
        menubar = new MenuSistema(this);
        super.setJMenuBar(menubar);
    }
    
    public void addIntFrame(JInternalFrame frame) {
        desktop.add(frame);
        frame.setVisible(true);
        
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
    }
  
    
    
}
