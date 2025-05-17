/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import aplicacion.Mision;
import aplicacion.Nave;
import java.sql.*;

/**
 *
 * @author alumnogreibd
 */
public class DAOMisiones extends AbstractDAO {
    public DAOMisiones(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public java.util.List<Mision> obtenerMisiones() {
        java.util.List<Mision> misiones = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmMisiones = null;
        ResultSet rsMisiones;

        con = this.getConexion();

        try {
            stmMisiones = con.prepareStatement(
                    "SELECT m.codigo, m.nombre, m.fechaInicio, m.fechaFin, " +
                            "       m.descripcion, m.nave, m.objetivo " +
                            "FROM Mision m ");

            rsMisiones = stmMisiones.executeQuery();

            while (rsMisiones.next()) {
                Integer codigo = rsMisiones.getInt("codigo");
                String nombre = rsMisiones.getString("nombre");
                java.time.LocalDate fechaInicio = rsMisiones.getDate("fechaInicio").toLocalDate(); 
                java.time.LocalDate fechaFin = null;
                if (rsMisiones.getDate("fechaFin") != null) {
                    fechaFin = rsMisiones.getDate("fechaFin").toLocalDate();
                }
                String descripcion = rsMisiones.getString("descripcion");
                Integer nave = rsMisiones.getInt("nave");
                String objetivo = rsMisiones.getString("objetivo");
                
                Mision mision = new Mision(codigo, nombre, fechaInicio, fechaFin, descripcion, nave, objetivo);
                misiones.add(mision);
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo la lista de misiones! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmMisiones != null)
                    stmMisiones.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de obtener misiones.");
            }
        }

        return misiones;
    }
    
    // Sobrecarga que devuelve las misiones en las que participa una nave en concreto
    public java.util.List<Mision> obtenerMisiones(Nave nave) {
        java.util.List<Mision> misiones = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmMisiones = null;
        ResultSet rsMisiones;

        con = this.getConexion();

        try {
            stmMisiones = con.prepareStatement(
                    "SELECT m.codigo, m.nombre, m.fechaInicio, m.fechaFin, " +
                            "       m.descripcion, m.nave, m.objetivo " +
                            "FROM Mision m " +
                            "WHERE m.nave = ?");
            
            stmMisiones.setInt(1, nave.getIDNave());

            rsMisiones = stmMisiones.executeQuery();

            while (rsMisiones.next()) {
                Integer codigo = rsMisiones.getInt("codigo");
                String nombre = rsMisiones.getString("nombre");
                java.time.LocalDate fechaInicio = rsMisiones.getDate("fechaInicio").toLocalDate(); 
                java.time.LocalDate fechaFin = null;
                if (rsMisiones.getDate("fechaFin") != null) {
                    fechaFin = rsMisiones.getDate("fechaFin").toLocalDate();
                }
                String descripcion = rsMisiones.getString("descripcion");
                Integer naveID = rsMisiones.getInt("nave");
                String objetivo = rsMisiones.getString("objetivo");
                
                Mision mision = new Mision(codigo, nombre, fechaInicio, fechaFin, descripcion, naveID, objetivo);
                misiones.add(mision);
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo la lista de misiones! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmMisiones != null)
                    stmMisiones.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de obtener misiones.");
            }
        }

        return misiones;
    }
    
    public boolean comprobarCodigoUnico(Integer codigo) {
        Connection con;
        PreparedStatement stmMisiones = null;
        ResultSet rsMisiones;
        boolean codigoUnico = true;

        con = this.getConexion();

        try {
            stmMisiones = con.prepareStatement(
                        "select * from mision where codigo = ?");
            stmMisiones.setInt(1, codigo);

            rsMisiones = stmMisiones.executeQuery();
            
            if(rsMisiones.next()) {
                codigoUnico = false;
            }

        } catch (SQLException e) {
            System.out.println("Error comprobando el codigo! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmMisiones != null)
                    stmMisiones.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de comprobar codigo unico.");
            }
        }
        
        return codigoUnico;
    }
    
    public void añadirMision(Mision m) {
        Connection con;
        PreparedStatement stmMisiones = null;

        con = this.getConexion();

        try {
            stmMisiones = con.prepareStatement(
                        "INSERT INTO mision (nombre, fechaInicio, fechaFin, descripcion, nave, objetivo) VALUES (?, ?, ?, ?, ?, ?)");
            
            stmMisiones.setString(1, m.getNombre());
            stmMisiones.setDate(2, java.sql.Date.valueOf(m.getFechaInicio()));
            if (m.getFechaFin() == null) {
                stmMisiones.setDate(3, null);
            }
            else {
                stmMisiones.setDate(3, java.sql.Date.valueOf(m.getFechaFin()));
            }
            stmMisiones.setString(4, m.getDescripcion());
            stmMisiones.setInt(5, m.getNave());
            stmMisiones.setString(6, m.getObjetivo());

            stmMisiones.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error añadiendo la mision! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmMisiones != null)
                    stmMisiones.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de añadir mision.");
            }
        }
    }
    
    public void modificarMision(Mision m) {
        Connection con;
        PreparedStatement stmMisiones = null;

        con = this.getConexion();

        try {
            stmMisiones = con.prepareStatement(
                        "UPDATE mision "+
                        "set nombre=?, " +
                        "    fechaInicio=?, "+
                        "    fechaFin=?, "+
                        "    descripcion=?, "+
                        "    nave=?, "+
                        "    objetivo=? "+
                        "where codigo=?");
            
            stmMisiones.setString(1, m.getNombre());
            stmMisiones.setDate(2, java.sql.Date.valueOf(m.getFechaInicio()));
            if (m.getFechaFin() == null) {
                stmMisiones.setDate(3, null);
            }
            else {
                stmMisiones.setDate(3, java.sql.Date.valueOf(m.getFechaFin()));
            }
            stmMisiones.setString(4, m.getDescripcion());
            stmMisiones.setInt(5, m.getNave());
            stmMisiones.setString(6, m.getObjetivo());
            stmMisiones.setInt(7, m.getCodigo());

            stmMisiones.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error modificando la mision! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmMisiones != null)
                    stmMisiones.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de modificar mision.");
            }
        }
    }
    
    public void borrarMision(Integer codigo) {
        Connection con;
        PreparedStatement stmMisiones = null;

        con = this.getConexion();

        try {
            stmMisiones = con.prepareStatement(
                        "DELETE FROM mision where codigo = ?");

            stmMisiones.setInt(1, codigo);
            
            stmMisiones.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error borrando la mision! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmMisiones != null)
                    stmMisiones.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de borrar mision.");
            }
        }
    }
    
}
