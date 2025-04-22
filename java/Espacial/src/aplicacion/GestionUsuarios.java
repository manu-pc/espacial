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
        if (u == null)
            return false;
        else
            return true;
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

}
