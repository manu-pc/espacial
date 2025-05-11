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
public class GestionAstronautas {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionAstronautas(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void abrirVentanaAstronautas() {
        fgui.abrirVentanaAstronautas();
    }

    public java.util.List<Astronauta> obtenerAstronautas() {
        return fbd.obtenerAstronautas();
    }

    public java.util.List<Astronauta> buscarAstronautasPorNombre(String nombre) {
        return fbd.buscarAstronautasPorNombre(nombre);
    }
    public Astronauta buscarAstronautaPorId(int id){
        return fbd.buscarAstronautaPorId(id);
    }
    
    public void actualizarAstronauta(Astronauta a, int idAgenciaActual, int idAgenciaNueva){
        // Verificar si el usuario ya existe en la base de datos
        boolean existeAstronauta = fbd.obtenerAstronautaPorId(a.getIdAstronauta());
        // Si el usuario no existe, insertar
        if (existeAstronauta == false) {
            fbd.insertarAstronauta(a, idAgenciaNueva);
        } 
        // Si el usuario existe, modificar
        else {
            fbd.modificarAstronauta(a, idAgenciaActual, idAgenciaNueva);
        }
    }
    
    public void borrarAstronauta(int idAstronauta){
       fbd.borrarAstronauta(idAstronauta);
    }

}
