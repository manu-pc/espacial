/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;


import aplicacion.HistorialAgenciasFactory;
import aplicacion.HistorialAgencias;
import java.sql.*;

/**
 *
 * @author basesdatos
 */
public class DAOPertenecerAgencia extends AbstractDAO {

    public DAOPertenecerAgencia(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }


 public int obtenerAgenciaActual(int idAstronauta) {
    int idAgencia = -1;
    Connection con;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    con = this.getConexion(); // igual que en el otro método

    try {
        stmt = con.prepareStatement(
            "SELECT agencia_id FROM PertenecerAgencia WHERE astronauta_id = ? AND fechaFin IS NULL"
        );
        stmt.setInt(1, idAstronauta);
        rs = stmt.executeQuery();

        if (rs.next()) {
            idAgencia = rs.getInt("agencia_id");
        }

    } catch (SQLException e) {
        System.out.println("Error obteniendo la agencia actual: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            // NO cierres la conexión aquí si estás siguiendo el patrón de reaprovecharla
        } catch (SQLException e) {
            System.out.println("Error cerrando recursos: " + e.getMessage());
        }
    }

    return idAgencia;
}
    public java.util.List<HistorialAgencias> obtenerHistorialAstronauta(int idAstronauta) {
        java.util.List<HistorialAgencias> agencias = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmAgencias = null;
        ResultSet rsAgencias;

        con = this.getConexion();

        try {
            stmAgencias = con.prepareStatement(
                "SELECT a.agencia_id, ag.nombre, a.fechaInicio, a.fechaFin " +
                "FROM PertenecerAgencia a " +
                "JOIN Agencia ag ON a.agencia_id = ag.id " +
                "WHERE a.astronauta_id = ? " +
                "ORDER BY a.fechaInicio DESC, a.fechaFin DESC");

            stmAgencias.setInt(1, idAstronauta);
            rsAgencias = stmAgencias.executeQuery();

            while (rsAgencias.next()) {
                HistorialAgencias agencia = HistorialAgenciasFactory.crearAgenciaDesdeResultSet(rsAgencias);
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
        for (HistorialAgencias h : agencias) {
            System.out.println("Agencia ID: " + h.getIdAgencia());
            System.out.println("Nombre: " + h.getNombre());
            System.out.println("Fecha inicio: " + h.getFechaInicio());
            System.out.println("Fecha fin: " + h.getFechaFin());
            System.out.println("------------------------");
        }
        return agencias;
    }



}
