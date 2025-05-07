/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import aplicacion.Galaxia;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaGalaxias extends AbstractTableModel {
    private java.util.List<Galaxia> galaxias;

    public ModeloTablaGalaxias(){
        this.galaxias=new java.util.ArrayList<Galaxia>();
    }

    public int getColumnCount (){
        return 4;
    }

    public int getRowCount(){
        return galaxias.size();
    }

    @Override //introducir direccion y clave si queremos mas cols
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "nombre"; break;
            case 1: nombre= "tipo"; break;
            case 2: nombre= "ubicacion"; break;
            case 3: nombre= "descripcion"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){ //introducir direccion y clave si queremos mas cols
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= aplicacion.TipoGalaxia.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase=java.lang.String.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    @Override //introducir direccion y clave si queremos más cols
    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= galaxias.get(row).getNombreGalaxia(); break;
            case 1: resultado= galaxias.get(row).getTipoGalaxia(); break;
            case 2: resultado= galaxias.get(row).getUbicacionGalaxia();break;
            case 3: resultado=galaxias.get(row).getDescGalaxia(); break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<Galaxia> galaxias){
        this.galaxias = galaxias;
        fireTableDataChanged();
    }

    public Galaxia obtenerGalaxia(int i){
        return this.galaxias.get(i);
    }
    

    public List<Galaxia> getGalaxia(){
    return galaxias;
    }
    
}

