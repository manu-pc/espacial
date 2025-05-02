// factorymethod??? referencia a deseño de software!!! vanme quedar 3

package aplicacion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioFactory {

    public static Usuario crearUsuarioDesdeResultSet(ResultSet rs) throws SQLException {
        String id = rs.getString("id");
        String nombre = rs.getString("nombre");
        String email = rs.getString("email");
        String clave = rs.getString("clave");

        if (rs.getString("tier_aficionado") != null) {
            return new Aficionado(id, nombre, email, clave, rs.getString("tier_aficionado"));
        } else if (rs.getString("centro_estudiante") != null) {
            return new Estudiante(id, nombre, email, clave,
                                  rs.getString("centro_estudiante"),
                                  rs.getInt("num_est"));
        } else if (rs.getString("centro_cientifico") != null) {
            return new Cientifico(id, nombre, email, clave,
                                  rs.getString("centro_cientifico"), rs.getInt("num_articulos"));
        } else if (rs.getString("rango_admin") != null) {
            return new Administrador(id, nombre, email, clave,
                                     rs.getString("rango_admin"));
        } else {
            throw new IllegalArgumentException("No se pudo determinar el tipo de usuario con ID: " + id);
        }
    }
}
 
