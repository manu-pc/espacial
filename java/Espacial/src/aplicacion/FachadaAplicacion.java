/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

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

    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        cl = new GestionLibros(fgui, fbd);
        cu = new GestionUsuarios(fgui, fbd);
        cg = new GestionCategorias(fgui, fbd);
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


    public void crearAficionado(String id, String clave, String nombre, String email, String tier) {
        cu.crearAficionado(id, clave, nombre, email, tier);
    }
    public void modificarAficionado(String id_previo, String id, String clave, String nombre, String email, String tier) {
        cu.modificarAficionado(id_previo, id, clave, nombre, email, tier);
    }
    public void crearAdministrador(String id, String clave, String nombre, String email, String tier) {
        cu.crearAdministrador(id, clave, nombre, email, tier);
    }
    public void modificarAdministrador(String id_previo, String id, String clave, String nombre, String email, String tier) {
        cu.modificarAdministrador(id_previo, id, clave, nombre, email, tier);
    }

    public void crearCientifico(String id, String clave, String nombre, String email, String centro) {
        cu.crearCientifico(id, clave, nombre, email, centro);

    }
    public void modificarCientifico(String id_previo, String id, String clave, String nombre, String email, String centro) {
        cu.modificarCientifico(id_previo, id, clave, nombre, email, centro);
    }

    public void crearEstudiante(String id, String clave, String nombre, String email, String centro, Integer num) {
        cu.crearEstudiante(id, clave, nombre, email, centro, num);
    }

    public void modificarEstudiante(String id_previo, String id, String clave, String nombre, String email, String centro, Integer num) {
        cu.modificarEstudiante(id_previo, id, clave, nombre, email, centro, num);
    }
    public void borrarUsuario(String id) {
        cu.eliminarUsuario(id);
    }

    public void abrirColaboraciones(Cientifico cientifico, java.awt.Dialog parent){
        fgui.abrirColaboraciones(cientifico, parent);
    }
    

}
