/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Astronauta;
import aplicacion.Agencia;
import aplicacion.Ejemplar;
import aplicacion.Usuario;
import aplicacion.Categoria;
import aplicacion.HistorialAgencias;
import aplicacion.Libro;
import aplicacion.Mision;
import aplicacion.Nave;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
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
    private DAOLibros daoLibros;
    private DAOCategorias daoCategorias;
    private DAOUsuarios daoUsuarios;
    private DAOPrestamos daoPrestamos;
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

            daoLibros = new DAOLibros(conexion, fa);
            daoCategorias = new DAOCategorias(conexion, fa);
            daoUsuarios = new DAOUsuarios(conexion, fa);
            daoPrestamos = new DAOPrestamos(conexion, fa);
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

    public java.util.List<Libro> consultarCatalogo(Integer id, String titulo, String isbn, String autor) {
        return daoLibros.consultarCatalogo(id, titulo, isbn, autor);
    }

    public Libro consultarLibro(Integer idLibro) {
        return daoLibros.consultarLibro(idLibro);
    }

    public java.util.List<Ejemplar> consultarEjemplaresLibro(Integer idLibro) {
        return daoLibros.consultarEjemplaresLibro(idLibro);
    }

    public java.util.List<String> obtenerRestoCategorias(Integer idLibro) {
        return daoLibros.obtenerRestoCategorias(idLibro);
    }

    public Integer insertarLibro(Libro libro) {
        return daoLibros.insertarLibro(libro);
    }

    public void borrarLibro(Integer idLibro) {
        daoLibros.borrarLibro(idLibro);
    }

    public void modificarLibro(Libro libro) {
        daoLibros.modificarLibro(libro);
    }

    public void modificarCategoriasLibro(Integer idLibro, java.util.List<String> categorias) {
        daoLibros.modificarCategoriasLibro(idLibro, categorias);
    }

    public void insertarEjemplarLibro(Integer idLibro, Ejemplar ejemplar) {
        daoLibros.insertarEjemplarLibro(idLibro, ejemplar);
    }

    public void borrarEjemplaresLibro(Integer idLibro, java.util.List<Integer> numsEjemplar) {
        daoLibros.borrarEjemplaresLibro(idLibro, numsEjemplar);
    }

    public void modificarEjemplarLibro(Integer idLibro, Ejemplar ejemplar) {
        daoLibros.modificarEjemplarLibro(idLibro, ejemplar);
    }

    public Usuario validarUsuario(String idUsuario, String clave) {
        return daoUsuarios.validarUsuario(idUsuario, clave);
    }

    public java.util.List<Categoria> consultarCategorias() {
        return daoCategorias.consultarCategorias();
    }

    public void insertarCategoria(String nombre, String descripcion) {
        daoCategorias.insertarCategoria(nombre, descripcion);
    }

    public void eliminarCategoria(String nombre) {
        daoCategorias.eliminarCategoria(nombre);
    }

    public java.util.List<Usuario> obtenerUsuarios() {
        return daoUsuarios.obtenerUsuarios();
    }

    public java.util.List<Usuario> buscarUsuariosPorNombre(String nombre) {
        return daoUsuarios.buscarUsuariosPorNombre(nombre);
    }
    public Usuario buscarUsuarioPorId(String id){
        return daoUsuarios.buscarUsuarioPorId(id);
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
