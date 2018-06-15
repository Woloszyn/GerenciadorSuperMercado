
package br.udesc.ceavi.progii.view.principal;

/**
 * Tela principal do sistema
 * @author Eduardo Woloszyn
 */
public class TelaPrincipal implements Runnable{
    public static void main(String[] args) {
        TelaPrincipal tela = new TelaPrincipal();
        
        Thread thread = new Thread(tela);
        
        thread.start();
        
    }
    
    
    @Override
    public void run() {
        FrameSistema oframe = new FrameSistema();
        System.out.println("Teste");
        oframe.setVisible(true);
        
    }
 
    
    
}
