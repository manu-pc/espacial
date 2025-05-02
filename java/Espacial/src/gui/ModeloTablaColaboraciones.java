/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import aplicacion.Colaboracion;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaColaboraciones extends AbstractTableModel {
    private java.util.List<Colaboracion> colaboraciones;

    public ModeloTablaColaboraciones() {
        this.colaboraciones = new java.util.ArrayList<Colaboracion>();
    }

    public int getColumnCount() {
        return 3;
    }
    public void vaciar() {
        colaboraciones.clear();
                fireTableDataChanged();  

    }
    public int getRowCount() {
        return colaboraciones.size();
    }

    public void añadirFilaVacia() {
        colaboraciones.add(null);
        fireTableRowsInserted(colaboraciones.size() - 1, colaboraciones.size() - 1);
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 1:
                nombre = "FechaInicio";
                break;
            case 2:
                nombre = "FechaFin";
                break;
            case 0:
                nombre = "Agencia";
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
                clase = java.time.LocalDate.class;
                break;
            case 2:
            clase = java.time.LocalDate.class;
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
        if (colaboraciones.get(row) == null) {
            return "";
        }
        switch (col) {
            case 0:
                resultado = colaboraciones.get(row).getAgencia();
                break;
            case 1:
                resultado = colaboraciones.get(row).getFechaInicio();
                break;
            case 2:
                resultado = colaboraciones.get(row).getFechaFin();
                break;

        }
        return resultado;
    }

    public void setFilas(java.util.List<Colaboracion> colaboraciones) {
        this.colaboraciones = colaboraciones;
        fireTableDataChanged();
    }

    public Colaboracion obtenerUsuario(int i) {
        return this.colaboraciones.get(i);
    }

}
