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

    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public Boolean comprobarAutentificacion(String idUsuario, String clave) {
        Usuario u;
        u = fbd.validarUsuario(idUsuario, clave);
        if (u == null){
            fgui.actualizarAdmin(true);
            System.out.println("debug: auth fallida");
            return true;}
        else{
            if (u instanceof Administrador){
            fgui.actualizarAdmin(true);
               System.out.println("Modo admin activado!");
        }
            else{
            fgui.actualizarAdmin(false);
                System.out.println("Modo admin desactivado");
            }
            return true;

        }
    }

    public void abrirVentanaUsuarios() {
        fgui.abrirVentanaUsuarios();
    }

    public java.util.List<Usuario> obtenerUsuarios() {
        return fbd.obtenerUsuarios();
    }

    public java.util.List<Usuario> buscarUsuariosPorNombre(String nombre) {
        return fbd.buscarUsuariosPorNombre(nombre);
    }
        public Usuario buscarUsuarioPorId(String id){
        return fbd.buscarUsuarioPorId(id);
    }

}
