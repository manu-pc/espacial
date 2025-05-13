/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import aplicacion.Mision;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaMisiones extends AbstractTableModel {
    private java.util.List<Mision> misiones;
    
    public ModeloTablaMisiones() {
        this.misiones = new java.util.ArrayList<>();
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return misiones.size();
    }

    public void añadirFilaVacia() {
        misiones.add(null);
        fireTableRowsInserted(misiones.size() - 1, misiones.size() - 1);
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Código";
                break;
            case 1:
                nombre = "Nombre";
                break;
            case 2:
                nombre = "fechaInicio";
                break;
            case 3:
                nombre = "Objetivo";
                break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0:
                clase = java.lang.Integer.class;
                break;
            case 1:
                clase = java.lang.String.class;
                break;
            case 2:
                clase = java.time.LocalDate.class;
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
        if (misiones.get(row) == null) {
            return "";
        }
        switch (col) {
            case 0:
                resultado = misiones.get(row).getCodigo();
                break;
            case 1:
                resultado = misiones.get(row).getNombre();
                break;
            case 2:
                resultado = misiones.get(row).getFechaInicio();
                break;
            case 3:
                resultado = misiones.get(row).getObjetivo();
                break;

        }
        return resultado;
    }

    public void setFilas(java.util.List<Mision> misiones) {
        this.misiones = misiones;
        fireTableDataChanged();
    }

    public Mision obtenerMision(int i) {
        return this.misiones.get(i);
    }
}
