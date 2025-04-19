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
public class GestionUsuarios {
     
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }  
    
    
  public Boolean comprobarAutentificacion(String idUsuario, String clave){
      Usuario u;
      u=fbd.validarUsuario(idUsuario, clave);
      if (u!=null){
          return u.getTipoUsuario()==TipoUsuario.Administrador;
      } else return false;
  }
  
  
      public void abrirVentanaUsuarios(){
        fgui.abrirVentanaUsuarios();
    }

 public java.util.List<Usuario> obtenerUsuarios(){
     return fbd.obtenerUsuarios();
 }
 
 public Usuario buscarUsuarioPorId(String id){
    return fbd.buscarUsuarioPorId(id);
}
public  java.util.List<Usuario> buscarUsuariosPorNombre(String nombre){
    return fbd.buscarUsuariosPorNombre(nombre);
}

public void insertarUsuario (String id, String nombre, String clave, String email, String direccion, String tipo){
    fbd.insertarUsuario(id, nombre, clave, email, direccion, tipo);
}
public void modificarUsuario (String id_nuevo, String nombre, String clave, String email, String direccion, String tipo, String id_previo){
    fbd.modificarUsuario(id_nuevo, nombre, clave, email, direccion, tipo, id_previo);
}
  public void eliminarUsuario(String id){
    fbd.eliminarUsuario(id);
}
}
