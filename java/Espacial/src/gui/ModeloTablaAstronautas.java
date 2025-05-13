/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import aplicacion.Astronauta;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaAstronautas extends AbstractTableModel {
    private java.util.List<Astronauta> astronautas;

    public ModeloTablaAstronautas() {
        this.astronautas = new java.util.ArrayList<Astronauta>();
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return astronautas.size();
    }

    public void añadirFilaVacia() {
        astronautas.add(null);
        fireTableRowsInserted(astronautas.size() - 1, astronautas.size() - 1);
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
                nombre = "Nacionalidad";
                break;
            case 3:
                nombre = "Feccha de nacimiento";
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
        if (astronautas.get(row) == null) {
            return "";
        }
        switch (col) {
            case 0:
                resultado = astronautas.get(row).getIdAstronauta();
                break;
            case 1:
                resultado = astronautas.get(row).getNombre();
                break;
            case 2:
                resultado = astronautas.get(row).getNacionalidad();
                break;
            case 3:
                resultado = astronautas.get(row).getFecha();
                break;

        }
        return resultado;
    }

    public void setFilas(java.util.List<Astronauta> astronautas) {
        this.astronautas = astronautas;
        fireTableDataChanged();
    }

    public Astronauta obtenerAstronauta(int i) {
        return this.astronautas.get(i);
    }

}
