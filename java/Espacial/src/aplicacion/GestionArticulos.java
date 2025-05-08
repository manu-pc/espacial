/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class GestionArticulos {
    
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionArticulos(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }
    
       
    public List<Articulo> obtenerTodosLosArticulos(){
        return fbd.obtenerTodosLosArticulos();
    }
    
    public void guardarArticulo(Articulo a){
        fbd.guardarArticulo(a);
    }
    
    public void modificarArticulo(Articulo a){
        fbd.modificarArticulo(a);
    }
    
    public void borrarArticulo(Articulo a){
        fbd.borrarArticulo(a);
    }
    
}
