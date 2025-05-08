/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import aplicacion.Aficionado;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaAficionados extends AbstractTableModel {
    private java.util.List<Aficionado> aficionados;

    public ModeloTablaAficionados() {
        this.aficionados = new java.util.ArrayList<Aficionado>();
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return aficionados.size();
    }
    public void vaciar() {
        aficionados.clear();
        fireTableDataChanged();  
    }
    public void añadirFilaVacia() {
        aficionados.add(null);
        fireTableRowsInserted(aficionados.size() - 1, aficionados.size() - 1);
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
                nombre = "Tier";
                break;
        }
        return nombre;
    }

    @Override
    public Class<?> getColumnClass(int col) {
        Class <?> clase = null;

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
        if (aficionados.get(row) == null) {
            return "";
        }
        switch (col) {
            case 0:
                resultado = aficionados.get(row).getIdUsuario();
                break;
            case 1:
                resultado = aficionados.get(row).getNombre();
                break;
            case 2:
                resultado = aficionados.get(row).getEmail();
                break;
            case 3:
                resultado = aficionados.get(row).getTier();
                break;

        }
        return resultado;
    }

    public void setFilas(java.util.List<Aficionado> aficionados) {
        this.aficionados = aficionados;
        fireTableDataChanged();
    }

    public Aficionado obtenerUsuario(int i) {
        return this.aficionados.get(i);
    }

}
