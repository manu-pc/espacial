/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import aplicacion.CuerpoCeleste;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaCuerposCelestes extends AbstractTableModel {
    private java.util.List<CuerpoCeleste> cuerpos;

    public ModeloTablaCuerposCelestes(){
        this.cuerpos=new java.util.ArrayList<CuerpoCeleste>();
    }

    public int getColumnCount (){
        return 9;
    }

    public int getRowCount(){
        return cuerpos.size();
    }

    @Override //introducir direccion y clave si queremos mas cols
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Nombre"; break;
            case 1: nombre= "Tipo"; break;
            case 2: nombre= "Ubicacion"; break;
            case 3: nombre= "Habitabilidad"; break;
            case 4: nombre= "Masa"; break;
            case 5: nombre= "Tamaño"; break;
            case 6: nombre= "Temp.Superficie"; break;
            case 7: nombre= "Descripción"; break;
            case 8: nombre= "Galaxia"; break;
        }
        return nombre;
    }

    @Override
    public Class<?>  getColumnClass(int col){ //introducir direccion y clave si queremos mas cols
        Class <?> clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= aplicacion.TipoCuerpoCeleste.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase=Boolean.class; break;
            case 4: clase=Integer.class; break;
            case 5: clase=Integer.class; break;
            case 6: clase=Integer.class; break;
            case 7: clase=java.lang.String.class; break;
            case 8: clase=java.lang.String.class; break;
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
            case 0: resultado= cuerpos.get(row).getNombreCuerpoCeleste(); break;
            case 1: resultado= cuerpos.get(row).getTipo(); break;
            case 2: resultado= cuerpos.get(row).getUbicacion();break;
            case 3: resultado= cuerpos.get(row).getHabitabilidad();break;
            case 4: resultado=cuerpos.get(row).getMasa(); break;
            case 5: resultado=cuerpos.get(row).getTamanho(); break;
            case 6: resultado=cuerpos.get(row).getTemperaturaSuperficie(); break;
            case 7: resultado=cuerpos.get(row).getDescripcion(); break;
            case 8: resultado=cuerpos.get(row).getGalaxia(); break;

        }
        return resultado;
    }

    public void setFilas(java.util.List<CuerpoCeleste> cuerpos){
        this.cuerpos=cuerpos;
        fireTableDataChanged();
    }

    public CuerpoCeleste obtenerCuerpo(int i){
        return this.cuerpos.get(i);
    }
    

    public List<CuerpoCeleste> getCuerpos(){
    return cuerpos;
    }
    
}
