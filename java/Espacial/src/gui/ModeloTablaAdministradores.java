/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import aplicacion.Administrador;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaAdministradores extends AbstractTableModel {
    private java.util.List<Administrador> administradors;

    public ModeloTablaAdministradores() {
        this.administradors = new java.util.ArrayList<Administrador>();
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return administradors.size();
    }
    public void vaciar() {
        administradors.clear();
                fireTableDataChanged();  

    }

    public void añadirFilaVacia() {
        administradors.add(null);
        fireTableRowsInserted(administradors.size() - 1, administradors.size() - 1);
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
                nombre = "Rango";
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
        if (administradors.get(row) == null) {
            return "";
        }
        switch (col) {
            case 0:
                resultado = administradors.get(row).getIdUsuario();
                break;
            case 1:
                resultado = administradors.get(row).getNombre();
                break;
            case 2:
                resultado = administradors.get(row).getEmail();
                break;
            case 3:
                resultado = administradors.get(row).getDescripcion();
                break;

        }
        return resultado;
    }

    public void setFilas(java.util.List<Administrador> administradors) {
        this.administradors = administradors;
        fireTableDataChanged();
    }

    public Administrador obtenerUsuario(int i) {
        return this.administradors.get(i);
    }

}
