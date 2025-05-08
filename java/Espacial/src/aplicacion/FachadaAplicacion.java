/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author basesdatos
 */
public class FachadaAplicacion {
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionUsuarios cu;
    GestionForo cg;
    GestionCuerposCelestes gc;
    GestionGalaxias gg;
    Usuario usuarioActual;

    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        cu = new GestionUsuarios(fgui, fbd);
        cg = new GestionForo(fgui, fbd);

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

    public void muestraMensaje(String m) {
        fgui.muestraMensaje(m);
    }

    public void abrirVentanaUsuarios() {
        cu.abrirVentanaUsuarios();
    }

    public Usuario comprobarAutentificacion(String idUsuario, String clave) {
        Usuario u = cu.comprobarAutentificacion(idUsuario, clave);
        if (u != null) {
            fgui.setUsuarioActual(u);
            this.usuarioActual = u;
        }
        return u;
    }

    public boolean getSudo() {
        if (this.usuarioActual == null) {
            System.out.println("Error autenticando!");
            return false;
        }
        if (this.usuarioActual instanceof Administrador) {
            System.out.println("permiso sudo concedido!");
        }
        return this.usuarioActual instanceof Administrador;
    }

    public java.util.List<Usuario> obtenerUsuarios() {
        return cu.obtenerUsuarios();
    }

    public java.util.List<Usuario> buscarUsuariosPorNombre(String nombre) {
        return cu.buscarUsuariosPorNombre(nombre);
    }

    public Usuario buscarUsuarioPorId(String id) {
        return cu.buscarUsuarioPorId(id);
    }

    public void crearAficionado(String id, String clave, String nombre, String email, String tier) {
        cu.crearAficionado(id, clave, nombre, email, tier);
    }

    public void modificarAficionado(String id_previo, String id, String clave, String nombre, String email,
            String tier) {
        cu.modificarAficionado(id_previo, id, clave, nombre, email, tier);
    }

    public void crearAdministrador(String id, String clave, String nombre, String email, String tier) {
        cu.crearAdministrador(id, clave, nombre, email, tier);
    }

    public void modificarAdministrador(String id_previo, String id, String clave, String nombre, String email,
            String tier) {
        cu.modificarAdministrador(id_previo, id, clave, nombre, email, tier);
    }

    public void crearCientifico(String id, String clave, String nombre, String email, String centro) {
        cu.crearCientifico(id, clave, nombre, email, centro);

    }

    public void modificarCientifico(String id_previo, String id, String clave, String nombre, String email,
            String centro) {
        cu.modificarCientifico(id_previo, id, clave, nombre, email, centro);
    }

    public void crearEstudiante(String id, String clave, String nombre, String email, String centro, Integer num) {
        cu.crearEstudiante(id, clave, nombre, email, centro, num);
    }

    public void modificarEstudiante(String id_previo, String id, String clave, String nombre, String email,
            String centro, Integer num) {
        cu.modificarEstudiante(id_previo, id, clave, nombre, email, centro, num);
    }

    public void borrarUsuario(String id) {
        cu.eliminarUsuario(id);
    }

    public void abrirColaboraciones(Cientifico cientifico, java.awt.Dialog parent) {
        fgui.abrirColaboraciones(cientifico, parent);
    }

    public List<Colaboracion> obtenerColaboraciones(Cientifico cientifico) {
        return cu.obtenerColaboraciones(cientifico);
    }

    public void insertarColaboracion(Cientifico c, Integer idAgencia) {
        cu.insertarColaboracion(c, idAgencia);
    }

    public void eliminarColaboracion(Colaboracion colaboracion) {
        cu.eliminarColaboracion(colaboracion);
    }

    public void abrirMiPerfil(Usuario u) {
        fgui.abrirMiPerfil(u);
    }

    public void comenzarPublicacion(Usuario u) {
        fgui.comenzarPublicacion(u);
    }

    public void nuevaEntrada(Usuario u, String titulo, String contenido) {
        cg.nuevaEntrada(u, titulo, contenido);
    }

    public void modificarEntrada(EntradaForo entrada) {
        cg.modificarEntrada(entrada);
    }

    public void abrirEntrada(EntradaForo entrada) {
        fgui.abrirEntrada(entrada);
    }

    public void leerEntrada(EntradaForo entrada) {
        fgui.leerEntrada(entrada);
    }

    public ArrayList<EntradaForo> cargarEntradas() {
        return cg.cargarEntradas();
    }

    public ArrayList<EntradaForo> buscarEntradasPorAutor(String idUsuario) {
        return cg.buscarEntradasPorAutor(idUsuario);
    }

    public ArrayList<EntradaForo> buscarEntradasPorTitulo(String titulo) {
        return cg.buscarEntradasPorTitulo(titulo);
    }

    public void eliminarEntrada(Usuario autor, Integer idEntrada) {
        cg.eliminarEntrada(autor, idEntrada);
    }

    public void notificarNuevaEntrada() {
        fgui.notificarNuevaEntrada();
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

    public void abrirVentanaCuerposCelestes() {
        fgui.abrirVentanaCuerposCelestes();
    }

    public void abrirVentanaGalaxias() {
        fgui.abrirVentanaGalaxias();
    }
}
