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
public class GestionPrestamos{
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionPrestamos(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }
    
    public void nuevoPrestamo(Ejemplar ejemplar, java.awt.Dialog parent){
        fgui.nuevoPrestamo(ejemplar, parent);
    }

public void insertarPrestamo(String idUsuario, int idLibro, int numEjemplar, java.time.LocalDate fechaPrestamo){
    fbd.insertarPrestamo(idUsuario, idLibro, numEjemplar, fechaPrestamo);
}

public void devolverPrestamo(String idUsuario, int idLibro, int numEjemplar, java.time.LocalDate fechaPrestamo) {
    fbd.devolverPrestamo(idUsuario, idLibro, numEjemplar, fechaPrestamo);
}
}
