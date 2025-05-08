/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Agencia;
import aplicacion.AgenciaFactory;
import java.sql.*;

/**
 *
 * @author basesdatos
 */
public class DAOAgencias extends AbstractDAO {

    public DAOAgencias(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

  
    public java.util.List<Agencia> buscarAgenciasPorNombre(String nombre) {
        Connection con;
        PreparedStatement stmAgencia = null;
        ResultSet rsAgencia;
        java.util.List<Agencia> agencias = new java.util.ArrayList<>();

        con = this.getConexion();

        try {
            stmAgencia = con.prepareStatement(
                    "SELECT a.id, a.nombre, a.localizacion " +
  
                            "FROM Agencia a " +

                            "WHERE a.nombre = ?");

            stmAgencia.setString(1, nombre);
            rsAgencia = stmAgencia.executeQuery();

            while (rsAgencia.next()) {
                Agencia agencia = AgenciaFactory.crearAgenciaDesdeResultSet(rsAgencia);
                agencias.add(agencia);
            }

        } catch (SQLException e) {
            System.out.println("Error buscando usuario! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmAgencia != null)
                    stmAgencia.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de búsqueda.");
            }
        }

        return agencias;
    }

    public java.util.List<Agencia> obtenerAgencias() {
        java.util.List<Agencia> agencias = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmAgencias = null;
        ResultSet rsAgencias;

        con = this.getConexion();

        try {
            stmAgencias = con.prepareStatement(
                    "SELECT a.id, a.nombre, a.localizacion " +
  
                            "FROM Agencia a ");

            rsAgencias = stmAgencias.executeQuery();

            while (rsAgencias.next()) {
                Agencia agencia = AgenciaFactory.crearAgenciaDesdeResultSet(rsAgencias);
                agencias.add(agencia);
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo la lista de usuarios! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmAgencias != null)
                    stmAgencias.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de obtener usuarios.");
            }
        }

        return agencias;
    }
public Agencia buscarAgenciaPorId(int idAgencia) {
    Agencia agencia = null;
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    try {
        con = this.getConexion();
        stm = con.prepareStatement(
            "SELECT a.id, a.nombre, a.localizacion " +

            "FROM Agencia a " +

            "WHERE a.id = ? " +
            "GROUP BY a.id, a.localizacion, a.nombre"
        );
        stm.setInt(1, idAgencia);
        rs = stm.executeQuery();
            if (rs.next()) {
                agencia = AgenciaFactory.crearAgenciaDesdeResultSet(rs);
            }

    } catch (SQLException e) {
        System.out.println("Error buscando usuario por ID: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try { if (stm != null) stm.close(); } catch (SQLException ignored) {}
    }

    return agencia;
}

    public boolean obtenerAgenciaPorId(int idAgencia) {
        boolean exito = false;
        Connection con = super.getConexion();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement("SELECT * FROM Agencia WHERE id = ?");
            stm.setInt(1, idAgencia);
            rs = stm.executeQuery();

            if (rs.next()) {
                exito = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stm != null) stm.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos.");
            }
        }

        return exito;
    }
    
    public void insertarAgencia(Agencia agencia){
        Connection con;
        PreparedStatement stmAgencia=null;
        PreparedStatement stmIdAgencia=null;

        ResultSet rsIdAgencia;
        String idAgencia=null;

        con=super.getConexion();

        try {
        stmAgencia=con.prepareStatement("insert into agencia(nombre, localizacion) "+
                                      "values (?,?)");
        stmAgencia.setString(1, agencia.getNombre());
        stmAgencia.setString(2, agencia.getLocalizacion());
        
        stmAgencia.executeUpdate();

       
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAgencia.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }

    }
    
    public void borrarAgencia(int IdAgencia){
        Connection con;
        PreparedStatement stmAgencia=null;

        con=super.getConexion();

        try {
        stmAgencia=con.prepareStatement("delete from Agencia where id = ?");
        stmAgencia.setInt(1, IdAgencia);
        stmAgencia.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAgencia.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void modificarAgencia(Agencia agencia){
        Connection con;
        PreparedStatement stmAgencia=null;
        PreparedStatement stmBorrado=null;

        con=super.getConexion();

        try {
        stmAgencia=con.prepareStatement("update Agencia "+
                                    " set localizacion=?, "+
                                    "    nombre=? "+
                                    "where id=?");
        stmAgencia.setString(1, agencia.getLocalizacion());
        stmAgencia.setString(2, agencia.getNombre());
        stmAgencia.setInt(4, agencia.getIdAgencia());
        stmAgencia.executeUpdate();


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAgencia.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

}
