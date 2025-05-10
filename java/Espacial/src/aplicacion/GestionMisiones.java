/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

/**
 *
 * @author alumnogreibd
 */
public class GestionMisiones {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionMisiones(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public void abrirVentanaMisiones() {
        fgui.abrirVentanaMisiones();
    }

    public java.util.List<Mision> obtenerMisiones() {
        return fbd.obtenerMisiones();
    }
    
    public void añadirMision(Mision m) {
        fbd.añadirMision(m);
    }
    
    public void modificarMision(Mision m) {
        fbd.modificarMision(m);
    }
    
    public void borrarMision(Integer codigo) {
        fbd.borrarMision(codigo);
    }


}