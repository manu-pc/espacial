// factorymethod??? referencia a deseño de software!!! vanme quedar 3

package aplicacion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AstronautaFactory {

    public static Astronauta crearAstronautaDesdeResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String nacionalidad = rs.getString("nacionalidad");
        java.time.LocalDate fechanacimiento = rs.getDate("fechanacimiento").toLocalDate();

        return new Astronauta(id, fechanacimiento, nombre, nacionalidad);
    }
}
 
