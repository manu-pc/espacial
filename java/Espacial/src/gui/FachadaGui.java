/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Categoria;
import aplicacion.Libro;
import aplicacion.Ejemplar;
import aplicacion.Cientifico;
import aplicacion.Usuario;
/**
 *
 * @author alumno
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;
    Usuario usuarioActual; 
    
   public FachadaGui(aplicacion.FachadaAplicacion fa){
     this.fa=fa;
     this.vp = new VPrincipal(fa);
   } 
    
    
    
    public void iniciaVista(){
      VAutentificacion va;
    
      va = new VAutentificacion(vp, true, fa);
      vp.setVisible(true);
      va.setVisible(true);

      
    }
    
   

    
    public void abrirVentanaUsuarios(){
        VUsuario ventanaUsuarios = new VUsuario(vp, true, fa);
        ventanaUsuarios.setVisible(true);
        ventanaUsuarios.setLocationRelativeTo(null);
    }
    

    public void muestraExcepcion(String txtExcepcion){
       VAviso va;
      
       va = new VAviso(vp, true, txtExcepcion, true);
       va.setVisible(true);
    }
    
    public void muestraMensaje(String mensaje){
        VAviso va;
        va = new VAviso(vp, true, mensaje, false);
        va.setVisible(true);
    }
    
    public void nuevoPrestamo(Ejemplar ejemplar, java.awt.Dialog parent){

    }
    
    public void actualizarAdmin(boolean modoAdmin){
        vp.setVisAdmin(modoAdmin);
    }
    
    public void abrirColaboraciones(Cientifico cientifico, java.awt.Dialog parent){
        VColaboraciones vc = new VColaboraciones(parent, true, fa, cientifico);
        vc.setVisible(true);
    }
    public void setUsuarioActual(Usuario u){
        this.usuarioActual = u;
        System.out.println("Usuario actual: " + u.getIdUsuario());
        vp.setUsuarioActual(u);
        vp.inicializar();
    }
    public Usuario getUsuarioActual(){
        return usuarioActual;
    }
    
    public void abrirMiPerfil(Usuario u){
        VUsuario vu =   new VUsuario(vp, true, fa, u);
        vu.setVisible(true);
    }

    public void comenzarPublicacion(Usuario u){
        VCategoria vp = new VCategoria(this.vp, true, fa, u);
        vp.setVisible(true);
    }
    
    public void leerEntrada(aplicacion.EntradaForo entrada){
        VLibro vp = new VLibro(this.vp, true, fa, this.vp.getUsuarioActual(), entrada);
        vp.setVisible(true);
    }
    public void abrirEntrada(aplicacion.EntradaForo entrada){
        VCategoria vp = new VCategoria(this.vp, true, fa, this.vp.getUsuarioActual(), entrada);
        vp.setVisible(true);
    }
    
    public void notificarNuevaEntrada(){
        this.vp.buscarLibros();
    }

    
       public void abrirVentanaCuerposCelestes(){
        VCuerpoCeleste vc = new VCuerpoCeleste(this.vp, true, fa);
        vc.setVisible(true);
       }
    public void abrirVentanaGalaxias(){
        VGalaxia vg = new VGalaxia(this.vp, true, fa);
        vg.setVisible(true);
    }

}
