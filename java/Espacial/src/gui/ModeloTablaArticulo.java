/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import aplicacion.Articulo;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaArticulo extends AbstractTableModel {
    
    private List<Articulo> articulos;
    
    public ModeloTablaArticulo() {
        this.articulos = new java.util.ArrayList<Articulo>();
    }
    
    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return articulos.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0: nombre = "ID"; break;
            case 1: nombre = "Fecha Publicación"; break;
            case 2: nombre = "Autor"; break;
            case 3: nombre = "Cuerpo Celeste"; break;
            case 4: nombre = "Descripción"; break;
            case 5: nombre = "Numero de paginas"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0: clase = java.lang.Integer.class; break;
            case 1: clase = java.time.LocalDate.class; break;
            case 2: clase = java.lang.String.class; break;
            case 3: clase = java.lang.String.class; break;
            case 4: clase = java.lang.String.class; break;
            case 5: clase = java.lang.Integer.class; break;
        }
        return clase;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object resultado = null;

        Articulo articulo = articulos.get(row);

        switch (col) {
            case 0: resultado = articulo.getId(); break;
            case 1: resultado = articulo.getFechaPublicacion(); break;
            case 2: resultado = articulo.getAutor(); break;
            case 3: resultado = articulo.getCuerpoCeleste(); break;
            case 4: resultado = articulo.getDescripcion(); break;
            case 5: resultado = articulo.getNumPaginas(); break;
        }
        return resultado;
    }

    public Articulo obtenerArticulo(int i) {
        return this.articulos.get(i);
    }

    public void setFilas(List<Articulo> articulos) {
        this.articulos = articulos;
        fireTableDataChanged();
    }

    public void nuevoArticulo(Articulo a) {
        this.articulos.add(a);
        fireTableRowsInserted(this.articulos.size() - 1, this.articulos.size() - 1);
    }

    public void borrarArticulo(int indice) {
        this.articulos.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public List<Articulo> getFilas() {
        return this.articulos;
    }
    
}
