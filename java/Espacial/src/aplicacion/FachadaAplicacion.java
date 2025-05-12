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
    GestionUsuarios cu;
    GestionAstronautas ca;
    GestionAgencias cag;
    GestionPertenenciaAgencias pag;
    GestionNaves gn;
    GestionMisiones gm;


    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        cu = new GestionUsuarios(fgui, fbd);
        ca = new GestionAstronautas(fgui, fbd);
        cag = new GestionAgencias(fgui, fbd);
        gn = new GestionNaves(fgui,fbd);
        gm = new GestionMisiones(fgui, fbd);
        pag = new GestionPertenenciaAgencias(fgui, fbd);

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

    public void abrirVentanaUsuarios() {
        cu.abrirVentanaUsuarios();
    }
    public void abrirVentanaHistorialAgencias(int idAstronauta){
        pag.abrirVentanaHistorialAgencias(idAstronauta);
    }
    public void abrirVentanaAstronautas() {
        ca.abrirVentanaAstronautas();
    }
    public void abrirVentanaAgencias() {
        cag.abrirVentanaAgencias();
    }
    public void abrirVentanaMisiones() {
        gm.abrirVentanaMisiones();
    }
    // Sobrecarga para abrir la ventana de misiones con las misiones de una nave en concreto
    public void abrirVentanaMisiones(Nave nave) {
        gm.abrirVentanaMisiones(nave);
    }
    
    public void abrirVentanaMisionesAstronautas(Integer codigoMision, java.util.List<Astronauta> astronautas, java.util.List<Astronauta> restoAstronautas) {
        fgui.abrirVentanaMisionesAstronautas(codigoMision, astronautas, restoAstronautas);
    }

    public Boolean comprobarAutentificacion(String idUsuario, String clave) {
        return cu.comprobarAutentificacion(idUsuario, clave);
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
    
    public java.util.List<HistorialAgencias> obtenerHistorialAstronauta(int idAstronauta) {
        return pag.obtenerHistorialAstronauta(idAstronauta);
    }

    public java.util.List<Astronauta> buscarAstronautasPorNombre(String nombre) {
        return ca.buscarAstronautasPorNombre(nombre);
    }
    
    public Astronauta buscarAstronautaPorId(int id){
        return ca.buscarAstronautaPorId(id);
    }
    
    public void actualizarAstronauta(Astronauta a, int idAgenciaActual, int idAgenciaNueva){
        ca.actualizarAstronauta(a, idAgenciaActual, idAgenciaNueva);
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
    
    public int obtenerAgenciaActual(int idAstronauta){
        return pag.obtenerAgenciaActual(idAstronauta);
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
        return ca.obtenerAstronautas(codigoMision);
    }
    
    public java.util.List<Astronauta> obtenerRestoAstronautas(Integer codigoMision) {
        return ca.obtenerRestoAstronautas(codigoMision);
    }
    
    public void actualizarAstronautasMisiones(Integer codigoMision, java.util.List<Astronauta> astronautas) {
        ca.actualizarAstronautasMisiones(codigoMision, astronautas);
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
        pag.desvincularAgencia(idAstronauta);
    }
}
