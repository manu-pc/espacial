/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author basesdatos
 */
public class GestionPertenenciaAgencias {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionPertenenciaAgencias(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public int obtenerAgenciaActual(int idAstronauta) {
        return fbd.obtenerAgenciaActual(idAstronauta);
    }
    
    public java.util.List<HistorialAgencias> obtenerHistorialAstronauta(int idAstronauta) {
        return fbd.obtenerHistorialAstronauta(idAstronauta);
    }
    public void abrirVentanaHistorialAgencias(int idAstronauta){
        fgui.abrirVentanaHistorialAgencias(idAstronauta);
    }
    
    public void desvincularAgencia(int idAstronauta){
        fbd.desvincularAgencia(idAstronauta);
    }
    


}
