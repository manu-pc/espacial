/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Astronauta;
import aplicacion.Ejemplar;
import aplicacion.Mision;
import aplicacion.Nave;


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
    
    public void abrirVentanaUsuarios(){
        VUsuario ventanaUsuarios = new VUsuario(vp, true, fa);
        ventanaUsuarios.setVisible(true);
        ventanaUsuarios.setLocationRelativeTo(null);
    }
    
    public void abrirVentanaHistorialAgencias(int idAstronauta){
        VHistorialAgencias ventanaHistorial = new VHistorialAgencias(vp, true, fa, idAstronauta);
        ventanaHistorial.setVisible(true);
        ventanaHistorial.setLocationRelativeTo(null);
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
    public void abrirVentanaMisiones(){
        VMision ventanaMisiones = new VMision(vp, true, fa);
        ventanaMisiones.setVisible(true);
        ventanaMisiones.setLocationRelativeTo(null);
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
    public void nuevoPrestamo(Ejemplar ejemplar, java.awt.Dialog parent){

    }
    
    

    
   
}
