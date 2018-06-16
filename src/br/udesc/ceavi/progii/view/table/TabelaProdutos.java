/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.view.table;

import br.udesc.ceavi.progii.models.Produtos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Eduardo Woloszyn
 */
public class TabelaProdutos implements TableModel {
    private List<Produtos> produto ;
    private String[] colunas = new String[] { "Id_Produto", "Nome_Prod","Preço","Quantidade","Lote" } ;
    private static final int IDPRODUTO = 0 ;
    private static final int NOMEPRODUTO = 1 ;
    private static final int PRECO = 2 ;
    private static final int QUANTIDADE =3 ;
    private static final int LOTE = 4 ;
    
    public TabelaProdutos() {
        produto = new ArrayList<>();
    }

    public TabelaProdutos(List<Produtos> linhas) {
        this.produto = new ArrayList<>(linhas);
    }
    
    
    
    
    @Override
    public int getRowCount() {
        return produto.size();

    }

    @Override
    public int getColumnCount() {
        return colunas.length ;
        
    }

    @Override
    public String getColumnName(int i) {
        return colunas[i];
    }

    @Override
    public Class<?> getColumnClass(int i) {
        switch(i){
            case 0 :
                break ;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default :
                break;
                
        }
        
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

