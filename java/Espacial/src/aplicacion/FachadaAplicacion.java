/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class FachadaAplicacion {
    
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionCuerposCelestes gc;
    GestionGalaxias gg;

    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        gc = new GestionCuerposCelestes(fgui, fbd);
        gg = new GestionGalaxias(fgui, fbd);
    }
    
    public static void main(String args[]) {
        FachadaAplicacion fa;

        fa = new FachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }

    public void iniciaInterfazUsuario() {
        fgui.iniciaVista();
    }
    
     public void muestraExcepcion(String e) {
        fgui.muestraExcepcion(e);
    }

    public List<CuerpoCeleste> obtenerCuerpos(String text) {
        return gc.obtenerCuerpoCeleste(text);
    }
    
     public void borrarCuerpo(String nombreCuerpo) {
        gc.borrarCuerpo(nombreCuerpo);
    }

    public void modificarCuerpo(CuerpoCeleste cuerpo) {
        gc.modificarCuerpo(cuerpo);
    }
    
        public List<Galaxia> obtenerGalaxia(String nombre) {
        return gg.obtenerGalaxia(nombre);
    }
    
     public void borrarGalaxia(String nombreGalaxia) {
        gg.borrarGalaxia(nombreGalaxia);
    }

    public void modificarGalaxia(Galaxia galaxia) {
        gg.modificarGalaxia(galaxia);
    }

    public void darDeAltaCuerpo(CuerpoCeleste nuevo) {
        gc.darDeAltaCuerpo(nuevo);
    }

    public void darDeAltaGalaxia(Galaxia nueva) {
        gg.darDeAltaGalaxia(nueva);
    }
}
