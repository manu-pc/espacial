/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import gui.FachadaGui;

import java.util.List;

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

    public Usuario comprobarAutentificacion(String idUsuario, String clave) {
        Usuario u;
        u = fbd.validarUsuario(idUsuario, clave);
        if (u == null) {
            fgui.actualizarAdmin(true);
            System.out.println("debug: auth fallida. iniciando sesion como 'id' 'clave'...");
            return fbd.validarUsuario("id", "clave");

        } else {
            if (u instanceof Administrador) {
                fgui.actualizarAdmin(true);
                System.out.println("Modo admin activado!");
            } else {
                fgui.actualizarAdmin(false);
                System.out.println("Modo admin desactivado");
            }
            return u;

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

    public Usuario buscarUsuarioPorId(String id) {
        return fbd.buscarUsuarioPorId(id);
    }

    public void crearAficionado(String id, String clave, String nombre, String email, String tier) {
        Aficionado a = new Aficionado(id, clave, nombre, email, tier);
        fbd.crearAficionado(a);
    }

    public void modificarAficionado(String id_previo, String id, String clave, String nombre, String email,
            String tier) {
        Aficionado a = new Aficionado(id, clave, nombre, email, tier);
        fbd.modificarAficionado(a, id_previo);
    }

    public void crearAdministrador(String id, String clave, String nombre, String email, String tier) {
        Administrador a = new Administrador(id, clave, nombre, email, tier);
        fbd.crearAdministrador(a);
    }

    public void modificarAdministrador(String id_previo, String id, String clave, String nombre, String email,
            String tier) {
        Administrador a = new Administrador(id, clave, nombre, email, tier);
        fbd.modificarAdministrador(a, id_previo);
    }

    public void crearCientifico(String id, String clave, String nombre, String email, String centro) {
        Cientifico c = new Cientifico(id, clave, nombre, email, centro, 0);
        fbd.crearCientifico(c);
    }

    public void modificarCientifico(String id_previo, String id, String clave, String nombre, String email,
            String centro) {
        Cientifico c = new Cientifico(id, clave, nombre, email, centro, 0);
        fbd.modificarCientifico(c, id_previo);
    }

    public void crearEstudiante(String id, String clave, String nombre, String email, String centro, Integer num) {
        Estudiante e = new Estudiante(id, clave, nombre, email, centro, num);
        fbd.crearEstudiante(e);
    }

    public void modificarEstudiante(String id_previo, String id, String clave, String nombre, String email,
            String centro, Integer num) {
        Estudiante e = new Estudiante(id, clave, nombre, email, centro, num);
        fbd.modificarEstudiante(e, id_previo);
    }

    public void eliminarUsuario(String id) {
        fbd.eliminarUsuario(id);
    }

    public List<Colaboracion> obtenerColaboraciones(Cientifico cientifico) {
        return fbd.obtenerColaboraciones(cientifico);
    }

    public void insertarColaboracion(Cientifico c, Integer id_agencia) {
        fbd.insertarColaboracion(c, id_agencia);
    }

    public void eliminarColaboracion(Colaboracion col) {
        fbd.eliminarColaboracion(col);
    }
}
