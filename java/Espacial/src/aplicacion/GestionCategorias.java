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
public class GestionCategorias{
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionCategorias(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }
    
    public void abrirVentanaCategorias(){
        fgui.abrirVentanaCategorias();
    }
    
    public java.util.List<Categoria> consultarCategorias(){
        return fbd.consultarCategorias();
    }
    
        public void insertarCategoria(String nombre, String descripcion){
        fbd.insertarCategoria(nombre, descripcion);
    }
    public void eliminarCategoria(String nombre){
        fbd.eliminarCategoria(nombre);
    }


}
