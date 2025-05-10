/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import java.util.List;

/**
 *
 * @author basesdatos
 */
public class FachadaAplicacion {
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionLibros cl;
    GestionUsuarios cu;
    GestionCategorias cg;
    GestionAstronautas ca;
    GestionAgencias cag;
    GestionNaves gn;


    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        cl = new GestionLibros(fgui, fbd);
        cu = new GestionUsuarios(fgui, fbd);
        cg = new GestionCategorias(fgui, fbd);
        ca = new GestionAstronautas(fgui, fbd);
        cag = new GestionAgencias(fgui, fbd);
        gn = new GestionNaves(fgui,fbd);


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

    public java.util.List<Libro> obtenerLibros(Integer id, String titulo, String isbn, String autor) {
        return cl.obtenerLibros(id, titulo, isbn, autor);
    };

    public void visualizarLibro(Integer idLibro) {
        cl.visualizarLibro(idLibro);
    }

    public void nuevoLibro() {
        cl.nuevoLibro();
    }

    public void abrirVentanaCategorias() {
        cg.abrirVentanaCategorias();

    }

    public void abrirVentanaUsuarios() {
        cu.abrirVentanaUsuarios();
    }
    public void abrirVentanaAstronautas() {
        ca.abrirVentanaAstronautas();
    }
    public void abrirVentanaAgencias() {
        cag.abrirVentanaAgencias();
    }

    public Integer actualizarLibro(Libro l) {
        return cl.actualizarLibro(l);
    }

    public void borrarLibro(Integer idLibro) {
        cl.borrarLibro(idLibro);
    }

    public void actualizarCategoriasLibro(Integer idLibro, java.util.List<String> categorias) {
        cl.actualizarCategoriasLibro(idLibro, categorias);
    }

    public java.util.List<Ejemplar> actualizarEjemplaresLibro(Integer idLibro, java.util.List<Ejemplar> ejemplares,
            java.util.List<Integer> borrar) {
        return cl.actualizarEjemplaresLibro(idLibro, ejemplares, borrar);
    }

    public Boolean comprobarAutentificacion(String idUsuario, String clave) {
        return cu.comprobarAutentificacion(idUsuario, clave);
    }

    public java.util.List<String> obtenerNombreCategorias() {
        java.util.List<Categoria> categorias = cg.consultarCategorias();
        java.util.List<String> nombres = new java.util.ArrayList<>();
        for (Categoria c : categorias) {
            nombres.add(c.getNombre());
        }
        return nombres;
    }

    public void insertarCategoria(String nombre, String descripcion) {
        cg.insertarCategoria(nombre, descripcion);
    }

    public void eliminarCategoria(String nombre) {
        cg.eliminarCategoria(nombre);
    }

    public java.util.List<Usuario> obtenerUsuarios() {
        return cu.obtenerUsuarios();
    }

    public java.util.List<Usuario> buscarUsuariosPorNombre(String nombre) {
        return cu.buscarUsuariosPorNombre(nombre);
    }
    
    public Usuario buscarUsuarioPorId(String id){
        return cu.buscarUsuarioPorId(id);
    }
    
    public java.util.List<Astronauta> obtenerAstronautas() {
        return ca.obtenerAstronautas();
    }

    public java.util.List<Astronauta> buscarAstronautasPorNombre(String nombre) {
        return ca.buscarAstronautasPorNombre(nombre);
    }
    
    public Astronauta buscarAstronautaPorId(int id){
        return ca.buscarAstronautaPorId(id);
    }
    
    public void actualizarAstronauta(Astronauta a){
        ca.actualizarAstronauta(a);
    }
    public void borrarAstronauta(int idAstronauta){
       ca.borrarAstronauta(idAstronauta);
    }
    
    public java.util.List<Agencia> obtenerAgencias() {
        return cag.obtenerAgencias();
    }

    public java.util.List<Agencia> buscarAgenciasPorNombre(String nombre) {
        return cag.buscarAgenciasPorNombre(nombre);
    }
    
    public Agencia buscarAgenciaPorId(int id){
        return cag.buscarAgenciaPorId(id);
    }
    
    public void actualizarAgencia(Agencia a){
        cag.actualizarAgencia(a);
    }
    public void borrarAgencia(int idAgencia){
       cag.borrarAgencia(idAgencia);
    }
        public List<Nave> obtenerNaves() {
        return gn.obtenerNaves();
    }

    public void borrarNave(Nave nave) {
        gn.borrarNave(nave);
    }

    public void añadirNave(Nave naveEspacial) {
        gn.añadirNave(naveEspacial);
    }

    public void actualizarNave(Nave naveActualizada) {
        gn.actualizarNave(naveActualizada);
    }

    public List<Nave> buscarNavePorId(Integer id) {
        return gn.buscarNavePorId(id);
    }
    
    public List<Nave> buscarNavePorNombre(String nombre) {
        return gn.buscarNavePorNombre(nombre);
    }

}
