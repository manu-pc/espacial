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
    public void abrirVentanaMisiones(Nave nave) {
        fgui.abrirVentanaMisiones(nave);
    }

    public java.util.List<Mision> obtenerMisiones() {
        return fbd.obtenerMisiones();
    }
    public java.util.List<Mision> obtenerMisiones(Nave nave) {
        return fbd.obtenerMisiones(nave);
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