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
public class GestionCuerposCelestes {
    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionCuerposCelestes(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void borrarCuerpo(String nombre) {
        fbd.borrarCuerpo(nombre);
    }

    public void modificarCuerpo(CuerpoCeleste cuerpo) {
        fbd.modificarCuerpo(cuerpo);
    }
    
    public void darDeAltaCuerpo(CuerpoCeleste cuerpo){
    fbd.DarDeAltaCuerpo(cuerpo);
    }

    public List<CuerpoCeleste> obtenerCuerpoCeleste(String text) {
    return fbd.obtenerCuerpoCeleste(text);
    }
    
}
