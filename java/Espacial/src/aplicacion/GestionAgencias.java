/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author basesdatos
 */
public class GestionAgencias {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionAgencias(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void abrirVentanaAgencias() {
        fgui.abrirVentanaAgencias();
    }

    public java.util.List<Agencia> obtenerAgencias() {
        return fbd.obtenerAgencias();
    }

    public java.util.List<Agencia> buscarAgenciasPorNombre(String nombre) {
        return fbd.buscarAgenciasPorNombre(nombre);
    }
    public Agencia buscarAgenciaPorId(int id){
        return fbd.buscarAgenciaPorId(id);
    }
    
    public void actualizarAgencia(Agencia a){
        // Verificar si el usuario ya existe en la base de datos
        boolean existeAgencia = fbd.obtenerAgenciaPorId(a.getIdAgencia());
        // Si el usuario no existe, insertar
        if (existeAgencia == false) {
            fbd.insertarAgencia(a);
        } 
        // Si el usuario existe, modificar
        else {
            fbd.modificarAgencia(a);
        }
    }
    
    public void borrarAgencia(int idAgencia){
       fbd.borrarAgencia(idAgencia);
    }

}
