/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Categoria;
import aplicacion.Libro;
import aplicacion.Ejemplar;


/**
 *
 * @author alumno
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;
    
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
    
   
    public void visualizaLibro(Libro l, java.util.List<String>restoCategorias){
        VLibro vl;
        java.util.List<String> categorias = new java.util.ArrayList<String>();
        
        for(Categoria c:l.getCategorias()){
            categorias.add(c.getNombre());
        }
        
        vl=new VLibro(vp, true, fa, l, categorias, restoCategorias);
        vl.setVisible(true);
    }
    
    public void nuevoLibro(java.util.List<String>  restoCategorias){
        VLibro vl;
        vl=new VLibro(vp, true, fa, restoCategorias);
        vl.setVisible(true);
    }
    
    public void abrirVentanaUsuarios(){
        VUsuario ventanaUsuarios = new VUsuario(vp, true, fa);
        ventanaUsuarios.setVisible(true);
        ventanaUsuarios.setLocationRelativeTo(null);
    }
    
    public void abrirVentanaCategorias(){
        VCategoria ventanaCategorias = new VCategoria(vp, true, fa);
        ventanaCategorias.setVisible(true);
        ventanaCategorias.setLocationRelativeTo(null);
    }
    public void muestraExcepcion(String txtExcepcion){
       VAviso va;
      
       va = new VAviso(vp, true, txtExcepcion);
       va.setVisible(true);
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
    public void nuevoPrestamo(Ejemplar ejemplar, java.awt.Dialog parent){

    }
    
    

    
   
}
