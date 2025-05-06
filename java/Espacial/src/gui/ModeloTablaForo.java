/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.EntradaForo;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaForo extends AbstractTableModel{
    private java.util.List<EntradaForo> entradas;

    public ModeloTablaForo(){
        this.entradas=new java.util.ArrayList<EntradaForo>();
    }

    public int getColumnCount (){
        return 2;
    }

    public int getRowCount(){
        return entradas.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Autor"; break;
            case 1: nombre= "Titulo"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.String.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }

    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado=entradas.get(row).getAutorId(); break;
            case 1: resultado=entradas.get(row).getTitulo(); break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<EntradaForo> entradas){
        this.entradas=entradas;
        fireTableDataChanged();
    }

    public EntradaForo obtenerEntradaForo(int i){
        return this.entradas.get(i);
    }

}
