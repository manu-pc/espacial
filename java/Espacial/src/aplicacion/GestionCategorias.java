/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.util.ArrayList;
/**
 *
 * @author basesdatos
 */
public class GestionCategorias{
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public GestionCategorias(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }


    public void nuevaEntrada(Usuario u, String titulo, String contenido) {
        fbd.nuevaEntrada(u, titulo, contenido);
    }

    public void modificarEntrada(Usuario u, String titulo, String contenido, Integer numEntrada) {
        fbd.modificarEntrada(u, titulo, contenido, numEntrada);
    }

    public ArrayList<EntradaForo> cargarEntradas() {
        return fbd.cargarEntradas();
    }

    public ArrayList<EntradaForo> buscarEntradasPorAutor(String idUsuario) {
        return fbd.buscarEntradasPorAutor(idUsuario);
    }

    public ArrayList<EntradaForo> buscarEntradasPorTitulo(String titulo) {
        return fbd.buscarEntradasPorTitulo(titulo);
    }
    public void eliminarEntrada(Usuario autor, Integer idEntrada) {
        fbd.eliminarEntrada(autor, idEntrada);
    }
}
