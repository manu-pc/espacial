/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import aplicacion.Nave;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaNave extends AbstractTableModel {
    private java.util.List<Nave> naves;

    public ModeloTablaNave() {
        this.naves = new java.util.ArrayList<Nave>();
    }

    public int getColumnCount() {
        return 5;
    }

    public int getRowCount() {
        return naves.size();
    }

    public void añadirFilaVacia() {
        naves.add(null);
        fireTableRowsInserted(naves.size() - 1, naves.size() - 1);
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "ID";
                break;
            case 1:
                nombre = "Nombre";
                break;
            case 2:
                nombre = "Tipo";
                break;
            case 3:
                nombre = "Tamaño";
                break;
            case 4:
                nombre = "Masa";
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
                clase = java.lang.String.class;
                break;
            case 3:
                clase = java.lang.Float.class;
                break;
            case 4:
                clase = java.lang.Float.class;
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
        if (naves.get(row) == null) {
            return "";
        }
        switch (col) {
            case 0:
                resultado = naves.get(row).getIDNave();
                break;
            case 1:
                resultado = naves.get(row).getNombre();
                break;
            case 2:
                resultado = naves.get(row).getTipo();
                break;
            case 3:
                resultado = naves.get(row).getTamanho();
                break;
            case 4:
                resultado = naves.get(row).getMasa();
                break;

        }
        return resultado;
    }

    public void setFilas(java.util.List<Nave> naves) {
        this.naves = naves;
        fireTableDataChanged();
    }

    public Nave obtenerNave(int i) {
        return this.naves.get(i);
    }

}
