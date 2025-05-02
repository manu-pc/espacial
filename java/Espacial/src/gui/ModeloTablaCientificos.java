/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import aplicacion.Cientifico;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaCientificos extends AbstractTableModel {
    private java.util.List<Cientifico> cientificos;

    public ModeloTablaCientificos() {
        this.cientificos = new java.util.ArrayList<Cientifico>();
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return cientificos.size();
    }

    public void añadirFilaVacia() {
        cientificos.add(null);
        fireTableRowsInserted(cientificos.size() - 1, cientificos.size() - 1);
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Id";
                break;
            case 1:
                nombre = "Nombre";
                break;
            case 2:
                nombre = "E-mail";
                break;
            case 3:
                nombre = "Nº Articulos";
                break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0:
                clase = java.lang.String.class;
                break;
            case 1:
                clase = java.lang.String.class;
                break;
            case 2:
                clase = java.lang.String.class;
                break;
            case 3:
                clase = java.lang.Integer.class;
                break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public Object getValueAt(int row, int col) {
        Object resultado = null;
        if (cientificos.get(row) == null) {
            return "";
        }
        switch (col) {
            case 0:
                resultado = cientificos.get(row).getIdUsuario();
                break;
            case 1:
                resultado = cientificos.get(row).getNombre();
                break;
            case 2:
                resultado = cientificos.get(row).getEmail();
                break;
            case 3:
                resultado = cientificos.get(row).getNumArticulos();
                break;

        }
        return resultado;
    }

    public void setFilas(java.util.List<Cientifico> cientificos) {
        this.cientificos = cientificos;
        fireTableDataChanged();
    }

    public Cientifico obtenerUsuario(int i) {
        return this.cientificos.get(i);
    }

}
