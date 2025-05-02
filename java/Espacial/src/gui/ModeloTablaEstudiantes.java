/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import aplicacion.Estudiante;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaEstudiantes extends AbstractTableModel {
    private java.util.List<Estudiante> estudiantes;

    public ModeloTablaEstudiantes() {
        this.estudiantes = new java.util.ArrayList<Estudiante>();
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return estudiantes.size();
    }

    public void añadirFilaVacia() {
        estudiantes.add(null);
        fireTableRowsInserted(estudiantes.size() - 1, estudiantes.size() - 1);
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
                nombre = "Centro";
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
        if (estudiantes.get(row) == null) {
            return "";
        }
        switch (col) {
            case 0:
                resultado = estudiantes.get(row).getIdUsuario();
                break;
            case 1:
                resultado = estudiantes.get(row).getNombre();
                break;
            case 2:
                resultado = estudiantes.get(row).getEmail();
                break;
            case 3:
                resultado = estudiantes.get(row).getCentro();
                break;

        }
        return resultado;
    }

    public void setFilas(java.util.List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
        fireTableDataChanged();
    }

    public Estudiante obtenerUsuario(int i) {
        return this.estudiantes.get(i);
    }

}
