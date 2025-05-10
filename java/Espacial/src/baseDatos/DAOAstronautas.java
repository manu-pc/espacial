/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Astronauta;
import aplicacion.AstronautaFactory;
import java.sql.*;

/**
 *
 * @author basesdatos
 */
public class DAOAstronautas extends AbstractDAO {

    public DAOAstronautas(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

  
    public java.util.List<Astronauta> buscarAstronautasPorNombre(String nombre) {
        Connection con;
        PreparedStatement stmAstronauta = null;
        ResultSet rsAstronauta;
        java.util.List<Astronauta> astronautas = new java.util.ArrayList<>();

        con = this.getConexion();

        try {
            stmAstronauta = con.prepareStatement(
                    "SELECT a.id, a.nombre, a.nacionalidad, a.fechanacimiento " +
  
                            "FROM Astronauta a " +

                            "WHERE a.nombre LIKE ?");

            /* % antes y después de la cadena para que combinado con el LIKE
             * busque nombres que contienen esa cadena en cualquier parte
             */
            stmAstronauta.setString(1, "%"+nombre+"%");
            rsAstronauta = stmAstronauta.executeQuery();

            while (rsAstronauta.next()) {
                Astronauta astronauta = AstronautaFactory.crearAstronautaDesdeResultSet(rsAstronauta);
                astronautas.add(astronauta);
            }

        } catch (SQLException e) {
            System.out.println("Error buscando usuario! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmAstronauta != null)
                    stmAstronauta.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de búsqueda.");
            }
        }

        return astronautas;
    }

    public java.util.List<Astronauta> obtenerAstronautas() {
        java.util.List<Astronauta> astronautas = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmAstronautas = null;
        ResultSet rsAstronautas;

        con = this.getConexion();

        try {
            stmAstronautas = con.prepareStatement(
                    "SELECT a.id, a.nombre, a.nacionalidad, a.fechanacimiento " +
  
                            "FROM Astronauta a ");

            rsAstronautas = stmAstronautas.executeQuery();

            while (rsAstronautas.next()) {
                Astronauta astronauta = AstronautaFactory.crearAstronautaDesdeResultSet(rsAstronautas);
                astronautas.add(astronauta);
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo la lista de usuarios! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmAstronautas != null)
                    stmAstronautas.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de obtener usuarios.");
            }
        }

        return astronautas;
    }
public Astronauta buscarAstronautaPorId(int idAstronauta) {
    Astronauta astronauta = null;
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    try {
        con = this.getConexion();
        stm = con.prepareStatement(
            "SELECT a.id, a.nombre, a.nacionalidad, a.fechanacimiento " +

            "FROM Astronauta a " +

            "WHERE a.id = ? " +
            "GROUP BY a.id, a.nacionalidad, a.nombre, a.fechanacimiento"
        );
        stm.setInt(1, idAstronauta);
        rs = stm.executeQuery();
            if (rs.next()) {
                astronauta = AstronautaFactory.crearAstronautaDesdeResultSet(rs);
            }

    } catch (SQLException e) {
        System.out.println("Error buscando usuario por ID: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try { if (stm != null) stm.close(); } catch (SQLException ignored) {}
    }

    return astronauta;
}

    public boolean obtenerAstronautaPorId(int idAstronauta) {
        boolean exito = false;
        Connection con = super.getConexion();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = con.prepareStatement("SELECT * FROM Astronauta WHERE id = ?");
            stm.setInt(1, idAstronauta);
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
    
    public void insertarAstronauta(Astronauta astronauta){
        Connection con;
        PreparedStatement stmAstronauta=null;
        PreparedStatement stmIdAstronauta=null;

        ResultSet rsIdAstronauta;
        String idAstronauta=null;

        con=super.getConexion();

        try {
        stmAstronauta=con.prepareStatement("insert into astronauta(nombre, nacionalidad, fechaNacimiento) "+
                                      "values (?,?,?)");
        stmAstronauta.setString(1, astronauta.getNombre());
        stmAstronauta.setString(2, astronauta.getNacionalidad());
        stmAstronauta.setDate(3, java.sql.Date.valueOf(astronauta.getFecha()));

        stmAstronauta.executeUpdate();

       
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAstronauta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }

    }
    
    public void borrarAstronauta(int IdAstronauta){
        Connection con;
        PreparedStatement stmAstronauta=null;

        con=super.getConexion();

        try {
        stmAstronauta=con.prepareStatement("delete from Astronauta where id = ?");
        stmAstronauta.setInt(1, IdAstronauta);
        stmAstronauta.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAstronauta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void modificarAstronauta(Astronauta astronauta){
        Connection con;
        PreparedStatement stmAstronauta=null;
        PreparedStatement stmBorrado=null;

        con=super.getConexion();

        try {
        stmAstronauta=con.prepareStatement("update Astronauta "+
                                    " set nacionalidad=?, "+
                                    "    nombre=?, "+
                                    "    fechaNacimiento=? "+
                                    "where id=?");
        stmAstronauta.setString(1, astronauta.getNacionalidad());
        stmAstronauta.setString(2, astronauta.getNombre());
        stmAstronauta.setDate(3 , java.sql.Date.valueOf(astronauta.getFecha()));
        stmAstronauta.setInt(4, astronauta.getIdAstronauta());
        stmAstronauta.executeUpdate();


        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAstronauta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

}
