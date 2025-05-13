/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.*;

/**
 *
 * @author alumno
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;
    Usuario usuarioActual;

    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        this.vp = new VPrincipal(fa);
    }

    public void iniciaVista() {
        VAutentificacion va;

        va = new VAutentificacion(vp, true, fa);
        vp.setVisible(true);
        va.setVisible(true);

    }

    public void abrirVentanaUsuarios() {
        VUsuario ventanaUsuarios = new VUsuario(vp, true, fa, false);
        ventanaUsuarios.setVisible(true);
        ventanaUsuarios.setLocationRelativeTo(null);
    }

    public void muestraExcepcion(String txtExcepcion) {
        VAviso va;

        va = new VAviso(vp, true, txtExcepcion, true);
        va.setVisible(true);
    }

    public void muestraMensaje(String mensaje) {
        VAviso va;
        va = new VAviso(vp, true, mensaje, false);
        va.setVisible(true);
    }

    public void actualizarAdmin() {
        vp.setVisAdmin(this.usuarioActual instanceof Administrador);
    }

    public void abrirColaboraciones(Cientifico cientifico, java.awt.Dialog parent) {
        VColaboraciones vc = new VColaboraciones(parent, true, fa, cientifico);
        vc.setVisible(true);
    }

    public void setUsuarioActual(Usuario u) {
        this.usuarioActual = u;
        vp.setUsuarioActual(u);
        actualizarAdmin();
        vp.inicializar();
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void abrirMiPerfil(Usuario u) {
        VUsuario vu = new VUsuario(vp, true, fa, u);
        vu.setVisible(true);
    }

    public void comenzarPublicacion(Usuario u) {
        VEditarEntrada vp = new VEditarEntrada(this.vp, true, fa, u);
        vp.setVisible(true);
    }

    public void leerEntrada(aplicacion.EntradaForo entrada) {
        VLeerEntrada vp = new VLeerEntrada(this.vp, true, fa, this.vp.getUsuarioActual(), entrada);
        vp.setVisible(true);
    }

    public void abrirEntrada(aplicacion.EntradaForo entrada) {
        VEditarEntrada vp = new VEditarEntrada(this.vp, true, fa, this.vp.getUsuarioActual(), entrada);
        vp.setVisible(true);
    }

    public void notificarNuevaEntrada() {
        this.vp.buscarLibros();
    }

    public void abrirVentanaCuerposCelestes() {
        VCuerpoCeleste vc = new VCuerpoCeleste(this.vp, true, fa);
        vc.setVisible(true);
    }

    public void abrirVentanaGalaxias() {
        VGalaxia vg = new VGalaxia(this.vp, true, fa);
        vg.setVisible(true);
    }
    
    public void abrirVentanaArticulos() {
        VArticulo va = new VArticulo(this.vp, true, fa);
        va.setVisible(true);
    }
    
    public void registrarUsuario(){
        VUsuario vu = new VUsuario(this.vp, true, fa, true);
        vu.setVisible(true);
    }
        
    public void abrirVentanaAstronautas(){
        VAstronauta ventanaAstronautas = new VAstronauta(vp, true, fa);
        ventanaAstronautas.setVisible(true);
        ventanaAstronautas.setLocationRelativeTo(null);
    }  
    public void abrirVentanaAgencias(){
        VAgencia ventanaAgencias = new VAgencia(vp, true, fa);
        ventanaAgencias.setVisible(true);
        ventanaAgencias.setLocationRelativeTo(null);
    } 
    public void abrirVentanaMisiones(){
        VMision ventanaMisiones = new VMision(vp, true, fa);
        ventanaMisiones.setVisible(true);
        ventanaMisiones.setLocationRelativeTo(null);
    } 
    
    public void abrirVentanaNaves(){
        VNave ventanaNaves = new VNave(vp, true, fa);
        ventanaNaves.setVisible(true);
        ventanaNaves.setLocationRelativeTo(null);
    }

        public void abrirVentanaMisiones(Nave nave){
        VMision ventanaMisiones = new VMision(vp, true, fa, nave);
        ventanaMisiones.setVisible(true);
        ventanaMisiones.setLocationRelativeTo(null);
    }
    
    public void abrirVentanaMisionesAstronautas(Integer codigoMision, java.util.List<Astronauta> astronautas, java.util.List<Astronauta> restoAstronautas) {
        VMisionesAstronautas ventanaMisionesAstronautas = new VMisionesAstronautas(vp, true, fa, codigoMision, astronautas, restoAstronautas);
        ventanaMisionesAstronautas.setVisible(true);
        ventanaMisionesAstronautas.setLocationRelativeTo(null);
    }
    public void abrirVentanaHistorialAgencias(int idAstronauta){
        VHistorialAgencias ventanaHistorial = new VHistorialAgencias(vp, true, fa, idAstronauta);
        ventanaHistorial.setVisible(true);
        ventanaHistorial.setLocationRelativeTo(null);
    }
}
