/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Galaxia;
import aplicacion.CuerpoCeleste;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


/**
 *
 * @author basesdatos
 */
public class FachadaBaseDatos {

    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOCuerposCelestes daocuerpos;
    private DAOGalaxias daogalaxias;

    public FachadaBaseDatos(aplicacion.FachadaAplicacion fa) {

        Properties configuracion = new Properties();
        this.fa = fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://"
                    + configuracion.getProperty("servidor") + ":"
                    + configuracion.getProperty("puerto") + "/"
                    + configuracion.getProperty("baseDatos"),
                    usuario);

            daocuerpos = new DAOCuerposCelestes(conexion, fa);

        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i) {
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }

    }

    public CuerpoCeleste validarCuerpo(String nombreCuerpo, String ubicacion) {
        return daocuerpos.validarCuerpo(nombreCuerpo, ubicacion);
    }

    public List<CuerpoCeleste> obtenerCuerpoCeleste(String text) {
       return daocuerpos.obtenerCuerpos(text);
    }
    
    public void borrarCuerpo(String nombre) {
        daocuerpos.borrarCuerpo(nombre);
    }

    public void modificarCuerpo(CuerpoCeleste cuerpo) {
        daocuerpos.modificarCuerpo(cuerpo);
    }
    
    public void DarDeAltaCuerpo(CuerpoCeleste cuerpo) {
        daocuerpos.DarDeAltaCuerpo(cuerpo);
    }
    
    public List<Galaxia> obtenerGalaxia(String text) {
       return daogalaxias.obtenerGalaxia(text);
    }
    
    public void borrarGalaxia(String nombre) {
        daogalaxias.borrarGalaxia(nombre);
    }

    public void modificarGalaxia(Galaxia galaxia) {
        daogalaxias.modificarGalaxia(galaxia);
    }
    
    public void DarDeAltaGalaxia(Galaxia galaxia) {
        daogalaxias.DarDeAltaGalaxia(galaxia);
    }

    }




