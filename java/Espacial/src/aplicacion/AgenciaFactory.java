// factorymethod??? referencia a deseño de software!!! vanme quedar 3

package aplicacion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AgenciaFactory {

    public static Agencia crearAgenciaDesdeResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String localizacion = rs.getString("localizacion");

        return new Agencia(id, nombre, localizacion);
    }
}
 
