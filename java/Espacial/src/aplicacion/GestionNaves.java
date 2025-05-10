/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.util.List;
/**
 *
 * @author basesdatos
 */
public class GestionNaves{
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionNaves(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }
    

    List<Nave> obtenerNaves() {
        return fbd.obtenerNaves();
    }

    void borrarNave(Nave nave) {
        fbd.borrarNave(nave);
    }

    void añadirNave(Nave naveEspacial) {
        fbd.añadirNave(naveEspacial);
    }

    void actualizarNave(Nave naveActualizada) {
        fbd.actualizrNave(naveActualizada);
    }


    List<Nave> buscarNavePorId(Integer id) {
        return fbd.buscarNavePorId(id);
    }
    
    List<Nave> buscarNavePorNombre(String nombre) {
        return fbd.buscarNavePorNombre(nombre);
    }

   


}
