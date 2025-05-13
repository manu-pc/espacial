/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import aplicacion.HistorialAgencias;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaHistorialAgencias extends AbstractTableModel {
    private java.util.List<HistorialAgencias> agencias;

    public ModeloTablaHistorialAgencias() {
        this.agencias = new java.util.ArrayList<HistorialAgencias>();
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return agencias.size();
    }

    public void añadirFilaVacia() {
        agencias.add(null);
        fireTableRowsInserted(agencias.size() - 1, agencias.size() - 1);
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
                nombre = "Fecha Inicio";
                break;
            case 3: 
                nombre = "Fecha Fin";
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
                clase = java.lang.String.class;
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
        if (agencias.get(row) == null) {
            return "";
        }
        switch (col) {
            case 0:
                resultado = agencias.get(row).getIdAgencia();
                break;
            case 1:
                resultado = agencias.get(row).getNombre();
                break;
            case 2:
                resultado = agencias.get(row).getFechaInicio();
                break;
            case 3:
                resultado = agencias.get(row).getFechaFin();
                break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<HistorialAgencias> agencias) {
        this.agencias = agencias;
        fireTableDataChanged();
    }

    public HistorialAgencias obtenerAgencia(int i) {
        return this.agencias.get(i);
    }

}
