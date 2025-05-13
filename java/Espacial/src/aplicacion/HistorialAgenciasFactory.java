// factorymethod??? referencia a deseño de software!!! vanme quedar 3

package aplicacion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistorialAgenciasFactory {

    public static HistorialAgencias crearAgenciaDesdeResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("agencia_id");
        String nombre = rs.getString("nombre");
        java.time.LocalDate fechaInicio = rs.getDate("fechaInicio").toLocalDate();
        
        java.time.LocalDate fechaFin = null;

        java.sql.Date sqlFechaFin = rs.getDate("fechaFin");
        if (sqlFechaFin != null) {
            fechaFin = sqlFechaFin.toLocalDate();
        }
        return new HistorialAgencias(id, nombre, fechaInicio, fechaFin);
    }
}
