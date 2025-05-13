/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author basesdatos
 */
public class FachadaBaseDatos {
    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOUsuarios daoUsuarios;
    private DAOForo daoForo;
    private DAOCuerposCelestes daocuerpos;
    private DAOGalaxias daogalaxias;
    private DAOArticulos daoArticulos;
    private DAOAstronautas daoAstronautas;
    private DAOAgencias daoAgencias;
    private DAOPertenecerAgencia daoPertenecerAgencia;
    private DAONave daoNaves;
    private DAOMisiones daoMisiones;

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
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://" +
                    configuracion.getProperty("servidor") + ":" +
                    configuracion.getProperty("puerto") + "/" +
                    configuracion.getProperty("baseDatos"),
                    usuario);

            daoUsuarios = new DAOUsuarios(conexion, fa);

            daoForo = new DAOForo(conexion, fa);
            daocuerpos = new DAOCuerposCelestes(conexion, fa);
            daogalaxias = new DAOGalaxias(conexion, fa);
            daoArticulos = new DAOArticulos(conexion, fa);
            daoAstronautas = new DAOAstronautas(conexion, fa);
            daoAgencias = new DAOAgencias(conexion, fa);
            daoNaves = new DAONave(conexion,fa);
            daoMisiones = new DAOMisiones(conexion,fa);
            daoPertenecerAgencia = new DAOPertenecerAgencia(conexion, fa);
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

    public Usuario validarUsuario(String idUsuario, String clave) {
        return daoUsuarios.validarUsuario(idUsuario, clave);
    }

    public java.util.List<Usuario> obtenerUsuarios() {
        return daoUsuarios.obtenerUsuarios();
    }

    public java.util.List<Usuario> buscarUsuariosPorNombre(String nombre) {
        return daoUsuarios.buscarUsuariosPorNombre(nombre);
    }

    public Usuario buscarUsuarioPorId(String id) {
        return daoUsuarios.buscarUsuarioPorId(id);
    }

    public void crearAficionado(aplicacion.Aficionado a) {
        daoUsuarios.crearUsuario(a);
    }

    public void modificarAficionado(aplicacion.Aficionado a, String idPrevio) {
        daoUsuarios.modificarUsuario(a, idPrevio);
    }

    public void crearCientifico(aplicacion.Cientifico c) {
        daoUsuarios.crearUsuario(c);
    }

    public void modificarCientifico(aplicacion.Cientifico c, String idPrevio) {
        daoUsuarios.modificarUsuario(c, idPrevio);
    }

    public void crearEstudiante(aplicacion.Estudiante e) {
        daoUsuarios.crearUsuario(e);
    }

    public void modificarEstudiante(aplicacion.Estudiante e, String idPrevio) {
        daoUsuarios.modificarUsuario(e, idPrevio);
    }

    public void crearAdministrador(aplicacion.Administrador a) {
        daoUsuarios.crearUsuario(a);
    }

    public void modificarAdministrador(aplicacion.Administrador a, String idPrevio) {
        daoUsuarios.modificarUsuario(a, idPrevio);
    }

    public void eliminarUsuario(String id) {
        daoUsuarios.eliminarUsuario(id);
    }

    public List<Colaboracion> obtenerColaboraciones(aplicacion.Cientifico cientifico) {
        return daoUsuarios.obtenerColaboraciones(cientifico);
    }

    public void insertarColaboracion(aplicacion.Cientifico c, Integer id_agencia) {
        daoUsuarios.insertarColaboracion(c, id_agencia);
    }

    public void eliminarColaboracion(Colaboracion col) {
        daoUsuarios.finalizarColaboracion(col);
    }

    public void nuevaEntrada(Usuario u, String titulo, String contenido) {
        daoForo.nuevaEntrada(u, titulo, contenido);
    }

    public void modificarEntrada(aplicacion.EntradaForo entrada) {
        daoForo.modificarEntrada(entrada);
    }

    public java.util.ArrayList<aplicacion.EntradaForo> cargarEntradas() {
        return daoForo.cargarEntradas();
    }

    public java.util.ArrayList<aplicacion.EntradaForo> buscarEntradasPorAutor(String idUsuario) {
        return daoForo.buscarEntradasPorAutor(idUsuario);
    }

    public java.util.ArrayList<aplicacion.EntradaForo> buscarEntradasPorTitulo(String titulo) {
        return daoForo.buscarEntradasPorTitulo(titulo);
    }

    public void eliminarEntrada(EntradaForo entrada) {
        daoForo.eliminarEntrada(entrada);
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
    
    public java.util.List<Articulo> obtenerTodosLosArticulos(){
        return daoArticulos.obtenerTodosLosArticulos();
    }
    
    public void guardarArticulo(Articulo a){
        daoArticulos.guardarArticulo(a);
    }
    
    public void modificarArticulo(Articulo a){
        daoArticulos.guardarArticuloNuevo(a);
    }
    
    public void borrarArticulo(Articulo a){
        daoArticulos.borrarArticulo(a);
    }
    
    
    
    public java.util.List<Astronauta> obtenerAstronautas() {
        return daoAstronautas.obtenerAstronautas();
    }
    
    public java.util.List<Astronauta> obtenerAstronautas(Integer codigoMision) {
        return daoAstronautas.obtenerAstronautas(codigoMision);
    }
    
    public java.util.List<Astronauta> obtenerRestoAstronautas(Integer codigoMision) {
        return daoAstronautas.obtenerRestoAstronautas(codigoMision);
    }

    public java.util.List<Astronauta> buscarAstronautasPorNombre(String nombre) {
        return daoAstronautas.buscarAstronautasPorNombre(nombre);
    }
    public Astronauta buscarAstronautaPorId(int id){
        return daoAstronautas.buscarAstronautaPorId(id);
    }
 
    public boolean obtenerAstronautaPorId(int IDAstronauta){
        return daoAstronautas.obtenerAstronautaPorId(IDAstronauta);
    }
    
    public void insertarAstronauta(Astronauta astronauta, int idAgenciaNueva){
        daoAstronautas.insertarAstronauta(astronauta, idAgenciaNueva);
    }
    
    public void modificarAstronauta(Astronauta astronauta, int idAgenciaActual, int idAgenciaNueva){
       daoAstronautas.modificarAstronauta(astronauta, idAgenciaActual, idAgenciaNueva);
    }
            
    public void actualizarAstronautasMisiones(Integer codigoMision, java.util.List<Astronauta> astronautas) {
        daoAstronautas.borrarAstronautasMisiones(codigoMision);
        daoAstronautas.actualizarAstronautasMisiones(codigoMision, astronautas);
    }
    
    public void borrarAstronauta(int idAstronauta){
        daoAstronautas.borrarAstronauta(idAstronauta);
    }
    
    public java.util.List<HistorialAgencias> obtenerHistorialAstronauta(int idAstronauta) {
        return daoPertenecerAgencia.obtenerHistorialAstronauta(idAstronauta);
    }
    
    public java.util.List<Agencia> obtenerAgencias() {
        return daoAgencias.obtenerAgencias();
    }

    public java.util.List<Agencia> buscarAgenciasPorNombre(String nombre) {
        return daoAgencias.buscarAgenciasPorNombre(nombre);
    }
    public Agencia buscarAgenciaPorId(int id){
        return daoAgencias.buscarAgenciaPorId(id);
    }
 
    public boolean obtenerAgenciaPorId(int IDAgencia){
        return daoAgencias.obtenerAgenciaPorId(IDAgencia);
    }
    
    public void insertarAgencia(Agencia agencia){
        daoAgencias.insertarAgencia(agencia);
    }
    
    public void modificarAgencia(Agencia agencia){
       daoAgencias.modificarAgencia(agencia);
    }
    public void borrarAgencia(int idAgencia){
        daoAgencias.borrarAgencia(idAgencia);
    }
    
    public int obtenerAgenciaActual(int idAstronauta){
        return daoPertenecerAgencia.obtenerAgenciaActual(idAstronauta);
    }
    
    public void desvincularAgencia(int idAstronauta){
        daoPertenecerAgencia.desvincularAgencia(idAstronauta);
    }
    
    public List<Nave> obtenerNaves() {
        return daoNaves.obtenerNaves();
    }

    public void borrarNave(Nave nave) {
        daoNaves.borrarNave(nave);
    }

    public void añadirNave(Nave naveEspacial) {
        daoNaves.anadirNave(naveEspacial);
    }

    public void actualizrNave(Nave naveActualizada) {
        daoNaves.actualizarNave(naveActualizada);
    }

    public List<Nave> buscarNavePorId(Integer id) {
        return daoNaves.buscarNavePorId(id);
    }
    
    public List<Nave> buscarNavePorNombre(String nombre) {
        return daoNaves.buscarNavePorNombre(nombre);
    }
    
    public java.util.List<Mision> obtenerMisiones() {
        return daoMisiones.obtenerMisiones();
    }
    public java.util.List<Mision> obtenerMisiones(Nave nave) {
        return daoMisiones.obtenerMisiones(nave);
    }
    
    public void añadirMision(Mision m) {
        daoMisiones.añadirMision(m);
    }
    
    public void modificarMision(Mision m) {
        daoMisiones.modificarMision(m);
    }
    
    public void borrarMision(Integer codigo) {
        daoMisiones.borrarMision(codigo);
    }
}
