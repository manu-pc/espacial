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



}
