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
            System.out.println("Error buscando astronauta! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmAstronauta != null)
                    stmAstronauta.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de búsqueda de astronautas.");
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
            System.out.println("Error obteniendo la lista de astronautas! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmAstronautas != null)
                    stmAstronautas.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de obtener astronautas.");
            }
        }

        return astronautas;
    }
    
    public java.util.List<Astronauta> obtenerAstronautas(Integer codigoMision) {
        java.util.List<Astronauta> astronautas = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmAstronautas = null;
        ResultSet rsAstronautas;

        con = this.getConexion();

        try {
            stmAstronautas = con.prepareStatement(
                    "SELECT a.* " +
                            "FROM Astronauta a join ParticiparMision p on a.id = p.astronauta " +
                            "where p.mision = ? ");
            stmAstronautas.setInt(1, codigoMision);

            rsAstronautas = stmAstronautas.executeQuery();

            while (rsAstronautas.next()) {
                Astronauta astronauta = AstronautaFactory.crearAstronautaDesdeResultSet(rsAstronautas);
                astronautas.add(astronauta);
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo la lista de astronautas! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmAstronautas != null)
                    stmAstronautas.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de obtener astronautas.");
            }
        }

        return astronautas;
    }
    
    public java.util.List<Astronauta> obtenerRestoAstronautas(Integer codigoMision) {
        java.util.List<Astronauta> astronautas = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmAstronautas = null;
        ResultSet rsAstronautas;

        con = this.getConexion();

        try {
            stmAstronautas = con.prepareStatement(
                    " SELECT a.* " +
                            " FROM astronauta a " +
                            " WHERE a.id not in ( " +
                            " SELECT a1.id " +
                            " FROM Astronauta a1 join ParticiparMision p on a1.id = p.astronauta " +
                            " WHERE p.mision = ? )");
            stmAstronautas.setInt(1, codigoMision);

            rsAstronautas = stmAstronautas.executeQuery();

            while (rsAstronautas.next()) {
                Astronauta astronauta = AstronautaFactory.crearAstronautaDesdeResultSet(rsAstronautas);
                astronautas.add(astronauta);
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo la lista de astronautas! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmAstronautas != null)
                    stmAstronautas.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de obtener astronautas.");
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
            System.out.println("Error buscando astronauta por ID: " + e.getMessage());
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
    
     public void insertarAstronauta(Astronauta astronauta, int idAgencia) {
        Connection con;
        PreparedStatement stmInsertar = null;
        PreparedStatement stmBuscarId = null;
        PreparedStatement stmRelacionAgencia = null;
        ResultSet rsBuscarId = null;

        con = super.getConexion();

        try {
            // 1. Insertar el astronauta
            stmInsertar = con.prepareStatement(
                "INSERT INTO Astronauta(nombre, nacionalidad, fechaNacimiento) VALUES (?, ?, ?)"
            );
            stmInsertar.setString(1, astronauta.getNombre());
            stmInsertar.setString(2, astronauta.getNacionalidad());
            stmInsertar.setDate(3, java.sql.Date.valueOf(astronauta.getFecha()));
            stmInsertar.executeUpdate();
            stmInsertar.close();

            // 2. Recuperar el ID del astronauta recién insertado
            stmBuscarId = con.prepareStatement(
                "SELECT id FROM Astronauta WHERE nombre = ? AND nacionalidad = ? AND fechaNacimiento = ? ORDER BY id DESC LIMIT 1"
            );
            stmBuscarId.setString(1, astronauta.getNombre());
            stmBuscarId.setString(2, astronauta.getNacionalidad());
            stmBuscarId.setDate(3, java.sql.Date.valueOf(astronauta.getFecha()));
            rsBuscarId = stmBuscarId.executeQuery();

            int idAstronauta = -1;
            if (rsBuscarId.next()) {
                idAstronauta = rsBuscarId.getInt("id");
            }

            // 3. Insertar relación con agencia si se indicó
            if (idAgencia != -1 && idAstronauta != -1) {
                stmRelacionAgencia = con.prepareStatement(
                    "INSERT INTO PertenecerAgencia (astronauta_id, agencia_id, fechaInicio, fechaFin) " +
                    "VALUES (?, ?, ?, ?)"
                );
                stmRelacionAgencia.setInt(1, idAstronauta);
                stmRelacionAgencia.setInt(2, idAgencia);
                stmRelacionAgencia.setDate(3, java.sql.Date.valueOf(astronauta.getFecha())); // Suponiendo que la fechaInicio es la fecha de nacimiento
                stmRelacionAgencia.setDate(4, null); // Asumiendo que fechaFin es NULL al momento de la inserción
                stmRelacionAgencia.executeUpdate();
                stmRelacionAgencia.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            // Cerrar recursos en el bloque finally
            try {
                if (stmInsertar != null) stmInsertar.close();
                if (stmBuscarId != null) stmBuscarId.close();
                if (stmRelacionAgencia != null) stmRelacionAgencia.close();
                if (rsBuscarId != null) rsBuscarId.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores: " + e.getMessage());
            }
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
    
    public void modificarAstronauta(Astronauta astronauta, int idAgenciaActual, int idAgenciaNueva) {
        Connection con;
        PreparedStatement stmAstronauta = null;
        PreparedStatement stmCerrarRelacion = null;
        PreparedStatement stmInsertarRelacion = null;

        con = this.getConexion();

        try {
            // 1. Actualizar los datos del astronauta
            stmAstronauta = con.prepareStatement(
                "UPDATE Astronauta " +
                "SET nacionalidad = ?, nombre = ?, fechaNacimiento = ? " +
                "WHERE id = ?"
            );
            stmAstronauta.setString(1, astronauta.getNacionalidad());
            stmAstronauta.setString(2, astronauta.getNombre());
            stmAstronauta.setDate(3, java.sql.Date.valueOf(astronauta.getFecha()));
            stmAstronauta.setInt(4, astronauta.getIdAstronauta());
            stmAstronauta.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando datos del astronauta: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmAstronauta != null) stmAstronauta.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar stmAstronauta");
            }
        }
        System.out.println("Agencia actual: " + idAgenciaActual + ", nueva: " + idAgenciaNueva);
        // 2. Si ha cambiado la agencia, actualizar historial
        if (idAgenciaActual != idAgenciaNueva && idAgenciaNueva != -1) {
            try {
                // Cerrar relación anterior
                stmCerrarRelacion = con.prepareStatement(
                    "UPDATE PertenecerAgencia SET fechaFin = CURRENT_DATE " +
                    "WHERE astronauta_id = ? AND fechaFin IS NULL"
                );
                stmCerrarRelacion.setInt(1, astronauta.getIdAstronauta());
                stmCerrarRelacion.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error cerrando relación con agencia actual: " + e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
                try {
                    if (stmCerrarRelacion != null) stmCerrarRelacion.close();
                } catch (SQLException e) {
                    System.out.println("Imposible cerrar stmCerrarRelacion");
                }
            }

            try {
                // Insertar nueva relación
                stmInsertarRelacion = con.prepareStatement(
                    "INSERT INTO PertenecerAgencia (astronauta_id, agencia_id, fechaInicio, fechaFin) " +
                    "VALUES (?, ?, CURRENT_DATE, NULL)"
                );
                stmInsertarRelacion.setInt(1, astronauta.getIdAstronauta());
                stmInsertarRelacion.setInt(2, idAgenciaNueva);
                stmInsertarRelacion.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error insertando nueva relación con agencia: " + e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
                try {
                    if (stmInsertarRelacion != null) stmInsertarRelacion.close();
                } catch (SQLException e) {
                    System.out.println("Imposible cerrar stmInsertarRelacion");
                }
            }
        }
    }
    
    public void borrarAstronautasMisiones(Integer codigoMision) {
        Connection con;
        PreparedStatement stmAstronauta=null;

        con=super.getConexion();

        try {
        stmAstronauta=con.prepareStatement("delete from ParticiparMision where mision = ?");
        stmAstronauta.setInt(1, codigoMision);
        stmAstronauta.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAstronauta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void actualizarAstronautasMisiones(Integer codigoMision, java.util.List<Astronauta> astronautas) {
        Connection con;
        PreparedStatement stmAstronauta=null;

        con=super.getConexion();

        try {
            stmAstronauta = con.prepareStatement(
                "INSERT INTO ParticiparMision(mision, astronauta) VALUES (?, ?)"
            );

            for (Astronauta astronauta : astronautas) {
                stmAstronauta.setInt(1, codigoMision);
                stmAstronauta.setInt(2, astronauta.getIdAstronauta());
                stmAstronauta.addBatch();
            }

            stmAstronauta.executeBatch();
            stmAstronauta.close();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmAstronauta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

}
