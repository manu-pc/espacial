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
public class GestionForo {
    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionForo(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void nuevaEntrada(Usuario u, String titulo, String contenido) {
        fbd.nuevaEntrada(u, titulo, contenido);
    }

    public void modificarEntrada(EntradaForo entrada) {
        fbd.modificarEntrada(entrada);
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

    public void eliminarEntrada( EntradaForo entrada) {
        fbd.eliminarEntrada(entrada);
    }
}
