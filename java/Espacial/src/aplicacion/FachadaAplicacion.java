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
    GestionAgencias ga;
    GestionAstronautas gs;
    GestionMisiones gm;
    GestionPertenenciaAgencias gp;
    GestionNaves gn;
    GestionArticulos ca;

    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        cu = new GestionUsuarios(fgui, fbd);
        cg = new GestionForo(fgui, fbd);
        gc = new GestionCuerposCelestes(fgui, fbd);
        gg = new GestionGalaxias(fgui, fbd);
        ca = new GestionArticulos(fgui, fbd);
        ga = new GestionAgencias(fgui, fbd);
        gs = new GestionAstronautas(fgui,fbd);
        gm = new GestionMisiones(fgui,fbd);
        gn = new GestionNaves(fgui, fbd);
        gp = new GestionPertenenciaAgencias(fgui, fbd);
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
    public Usuario getUsuarioActual(){
        return this.usuarioActual;
    }
    public void abrirVentanaUsuarios() {
        cu.abrirVentanaUsuarios();
    }

    public boolean comprobarAutentificacion(String idUsuario, String clave) {
        Usuario u = cu.comprobarAutentificacion(idUsuario, clave);
        if (u != null) {
            fgui.setUsuarioActual(u);
            this.usuarioActual = u;
            return true;
        }
        return false;
    }

    public boolean getSudo() {
        if (this.usuarioActual == null) {
            return false;
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

    public void eliminarEntrada(EntradaForo entrada) {
        cg.eliminarEntrada(entrada);
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
        if (cuerpo.getNombreCuerpoCeleste().equals(cuerpo.getOrbitaA())){
            muestraExcepcion("El cuerpo no puede orbitar sobre sí mismo!");
            return;
        }
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
                if (nuevo.getNombreCuerpoCeleste().equals(nuevo.getOrbitaA())){
            muestraExcepcion("El cuerpo no puede orbitar sobre sí mismo!");
            return;
        }
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
    
    public void abrirVentanaArticulos() {
        fgui.abrirVentanaArticulos();
    }
    
    public java.util.List<Articulo> obtenerTodosLosArticulos(){
        return ca.obtenerTodosLosArticulos();
    }
    
    public void guardarArticulo(Articulo a){

        if ((usuarioActual instanceof Cientifico && usuarioActual.getIdUsuario().equals(a.getAutor()))|| usuarioActual instanceof Administrador)
            ca.guardarArticulo(a);
        else
            muestraExcepcion("No tienes permiso para publicar este artículo!");
    }
    
    public void modificarArticulo(Articulo a){
        if ((usuarioActual instanceof Cientifico && usuarioActual.getIdUsuario().equals(a.getAutor()))|| usuarioActual instanceof Administrador)
            ca.modificarArticulo(a);
        else
            muestraExcepcion("No tienes permiso para modificar este artículo!");    }
    
    public void borrarArticulo(Articulo a){
        if ((usuarioActual instanceof Cientifico && usuarioActual.getIdUsuario().equals(a.getAutor()))|| usuarioActual instanceof Administrador)
            ca.borrarArticulo(a);
        else
            muestraExcepcion("No tienes permiso para borrar este artículo!");       }
    
    public void registrarUsuario(){
        fgui.registrarUsuario();
    }
    
    
    public void abrirVentanaNaves(){
        fgui.abrirVentanaNaves();
    }
    
    public void abrirVentanaAgencias(){
        fgui.abrirVentanaAgencias();
    }
    
    public void abrirVentanaAstronautas(){
        fgui.abrirVentanaAstronautas();
    }
    
    public void abrirVentanaMisiones(){
        fgui.abrirVentanaMisiones();
    }
    
     public void abrirVentanaMisiones(Nave nave){
        fgui.abrirVentanaMisiones(nave);
    }
    
    
    
    
    public java.util.List<Astronauta> obtenerAstronautas() {
        return gs.obtenerAstronautas();
    }
    
    public java.util.List<HistorialAgencias> obtenerHistorialAstronauta(int idAstronauta) {
        return gp.obtenerHistorialAstronauta(idAstronauta);
    }

    public java.util.List<Astronauta> buscarAstronautasPorNombre(String nombre) {
        return gs.buscarAstronautasPorNombre(nombre);
    }
    
    public Astronauta buscarAstronautaPorId(int id){
        return gs.buscarAstronautaPorId(id);
    }
    
    public void actualizarAstronauta(Astronauta a, int idAgenciaActual, int idAgenciaNueva){
        gs.actualizarAstronauta(a, idAgenciaActual, idAgenciaNueva);
    }
    public void borrarAstronauta(int idAstronauta){
       gs.borrarAstronauta(idAstronauta);
    }
    
    public java.util.List<Agencia> obtenerAgencias() {
        return ga.obtenerAgencias();
    }

    public java.util.List<Agencia> buscarAgenciasPorNombre(String nombre) {
        return ga.buscarAgenciasPorNombre(nombre);
    }
    
    public Agencia buscarAgenciaPorId(int id){
        return ga.buscarAgenciaPorId(id);
    }
    
    public void actualizarAgencia(Agencia a){
        ga.actualizarAgencia(a);
    }
    public void borrarAgencia(int idAgencia){
       ga.borrarAgencia(idAgencia);
    }
    public List<Nave> obtenerNaves() {
        return gn.obtenerNaves();
    }
    
    public int obtenerAgenciaActual(int idAstronauta){
        return gp.obtenerAgenciaActual(idAstronauta);
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
    
    public java.util.List<Mision> obtenerMisiones() {
        return gm.obtenerMisiones();
    }
    public java.util.List<Mision> obtenerMisiones(Nave nave) {
        return gm.obtenerMisiones(nave);
    }
    
    public java.util.List<Astronauta> obtenerAstronautas(Integer codigoMision) {
        return gs.obtenerAstronautas(codigoMision);
    }
    
    public java.util.List<Astronauta> obtenerRestoAstronautas(Integer codigoMision) {
        return gs.obtenerRestoAstronautas(codigoMision);
    }
    
    public void actualizarAstronautasMisiones(Integer codigoMision, java.util.List<Astronauta> astronautas) {
        gs.actualizarAstronautasMisiones(codigoMision, astronautas);
    }
    
    public void añadirMision(Mision m) {
        gm.añadirMision(m);
    }
    
    public void modificarMision(Mision m) {
        gm.modificarMision(m);
    }
    
    public void borrarMision(Integer codigo) {
        gm.borrarMision(codigo);
    }
    
    public void desvincularAgencia(int idAstronauta){
        gp.desvincularAgencia(idAstronauta);
    }    
    
    public void abrirVentanaHistorialAgencias(int id){
        fgui.abrirVentanaHistorialAgencias(id);
    }
    
    public void abrirVentanaMisionesAstronautas(Integer codigoMision, java.util.List<Astronauta> astronautas, java.util.List<Astronauta> restoAstronautas) {
        fgui.abrirVentanaMisionesAstronautas(codigoMision, astronautas, restoAstronautas);
    }

}
