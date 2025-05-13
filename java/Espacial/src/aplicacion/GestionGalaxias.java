/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class GestionGalaxias {
    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionGalaxias(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void borrarGalaxia(String nombre) {
        fbd.borrarGalaxia(nombre);
    }

    public void modificarGalaxia(Galaxia galaxia) {
        fbd.modificarGalaxia(galaxia);
    }
    
    public void darDeAltaGalaxia(Galaxia galaxia){
    fbd.DarDeAltaGalaxia(galaxia);
    }

    public List<Galaxia> obtenerGalaxia(String text) {
    return fbd.obtenerGalaxia(text);
    }
}
