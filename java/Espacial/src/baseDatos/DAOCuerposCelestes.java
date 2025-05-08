/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.CuerpoCeleste;
import aplicacion.TipoCuerpoCeleste;
import java.sql.*;

/**
 *
 * @author basesdatos
 */
public class DAOCuerposCelestes extends AbstractDAO {

    public DAOCuerposCelestes(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public CuerpoCeleste validarCuerpo(String nombreCuerpo, String ubicacion) {
        CuerpoCeleste resultado = null;
        Connection con;
        PreparedStatement stmCuerpo = null;
        ResultSet rsCuerpoCeleste;

        con = this.getConexion();

        try {
            stmCuerpo = con.prepareStatement("select nombre, tipo, ubicacion, habitabilidad, masa, tamano, temperaturasuperficie, descripcion, galaxia "
                    + "from cuerpoceleste "
                    + "where nombre = ? AND ubicacion = ?");
            stmCuerpo.setString(1, nombreCuerpo);
            stmCuerpo.setString(2, ubicacion);
            rsCuerpoCeleste = stmCuerpo.executeQuery();
            if (rsCuerpoCeleste.next()) {
                resultado = new CuerpoCeleste(rsCuerpoCeleste.getString("nombre"), TipoCuerpoCeleste.valueOf(rsCuerpoCeleste.getString("tipo")),
                        rsCuerpoCeleste.getString("ubicacion"), rsCuerpoCeleste.getBoolean("habitabilidad"),
                        rsCuerpoCeleste.getFloat("masa"), rsCuerpoCeleste.getFloat("tamano"), rsCuerpoCeleste.getFloat("temperaturaSuperficie"),
                        rsCuerpoCeleste.getString("descripcion"), rsCuerpoCeleste.getString("galaxia"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCuerpo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public java.util.List<CuerpoCeleste> obtenerCuerpos(String nombre) {
        java.util.List<CuerpoCeleste> resultado = new java.util.ArrayList<CuerpoCeleste>();
        CuerpoCeleste cuerpoActual;
        Connection con;
        PreparedStatement strCuerpos = null;
        ResultSet rslCuerpos;

        con = this.getConexion();
        String consulta = "select nombre, tipo, ubicacion, habitabilidad, masa, tamano, temperaturasuperficie, descripcion, galaxia "
                + "from cuerpoceleste ";
        if (!nombre.isEmpty()) {
            consulta = consulta + "where nombre like '%" + nombre + "%' ";
        }
        try {
            strCuerpos = con.prepareStatement(consulta);
            rslCuerpos = strCuerpos.executeQuery();

            while (rslCuerpos.next()) {
                cuerpoActual = new CuerpoCeleste(rslCuerpos.getString("nombre"), TipoCuerpoCeleste.valueOf(rslCuerpos.getString("tipo")),
                        rslCuerpos.getString("ubicacion"), rslCuerpos.getBoolean("habitabilidad"),
                        rslCuerpos.getFloat("masa"), rslCuerpos.getFloat("tamano"), rslCuerpos.getFloat("temperaturasuperficie"),
                        rslCuerpos.getString("descripcion"), rslCuerpos.getString("galaxia"));
                resultado.add(cuerpoActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                strCuerpos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    public void DarDeAltaCuerpo(CuerpoCeleste cuerpo) {
        Connection con;
        PreparedStatement stmCuerpo = null;

        con = super.getConexion();

        try {
            stmCuerpo = con.prepareStatement("insert into cuerpoceleste(nombre, tipo, ubicacion, habitabilidad, masa, tamano, temperaturaSuperficie, descripcion, galaxia) "
                    + "values (?,?,?,?,?,?,?,?,?)");
            stmCuerpo.setString(1, cuerpo.getNombreCuerpoCeleste());
            stmCuerpo.setString(2, cuerpo.getTipo().name());
            stmCuerpo.setString(3, cuerpo.getUbicacion());
            stmCuerpo.setBoolean(4, cuerpo.getHabitabilidad());
            stmCuerpo.setFloat(5, cuerpo.getMasa());
            stmCuerpo.setFloat(6, cuerpo.getTamanho());
            stmCuerpo.setFloat(7, cuerpo.getTemperaturaSuperficie());
            stmCuerpo.setString(8, cuerpo.getDescripcion());
            stmCuerpo.setString(9, cuerpo.getGalaxia());

            stmCuerpo.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCuerpo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void modificarCuerpo(CuerpoCeleste cuerpo) {
        Connection con;
        PreparedStatement stmCuerpo = null;

        con = super.getConexion();

        try {
            stmCuerpo = con.prepareStatement("update cuerpoceleste "
                    + "set nombre=?, "
                    + "    tipo=?, "
                    + "    ubicacion=?, "
                    + "    habitabilidad=?, "
                    + "    masa=?, "
                    + "    tamano=?, "
                    + "    temperaturaSuperficie=?, "
                    + "    descripcion=?, "
                    + "    galaxia=? "
                    + "where nombre=?");
            stmCuerpo.setString(1, cuerpo.getNombreCuerpoCeleste());
            stmCuerpo.setString(2, cuerpo.getTipo().name());
            stmCuerpo.setString(3, cuerpo.getUbicacion());
            if (cuerpo.getHabitabilidad() != null) {
                stmCuerpo.setBoolean(4, cuerpo.getHabitabilidad());
            } else {
                stmCuerpo.setNull(4, java.sql.Types.BOOLEAN);
            }
            stmCuerpo.setFloat(5, cuerpo.getMasa());
            stmCuerpo.setFloat(6, cuerpo.getTamanho());
            stmCuerpo.setFloat(7, cuerpo.getTemperaturaSuperficie());
            stmCuerpo.setString(8, cuerpo.getDescripcion());
            stmCuerpo.setString(9, cuerpo.getGalaxia());
                        stmCuerpo.setString(10, cuerpo.getNombreCuerpoCeleste());

            stmCuerpo.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCuerpo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void borrarCuerpo(String nombre) {

        Connection con = getConexion();
        PreparedStatement psCheck = null;
        PreparedStatement psDelete = null;
        ResultSet rs = null;

        try {
            psCheck = con.prepareStatement("SELECT 1"
       +" FROM cuerpoceleste cc"
       +" LEFT JOIN mision m ON m.objetivo = cc.nombre"
       +" LEFT JOIN articulo a ON a.cuerpo = cc.nombre"
       +" WHERE cc.nombre = ? AND (m.objetivo IS NOT NULL OR a.cuerpo IS NOT NULL)");
            psCheck.setString(1, nombre);
            rs = psCheck.executeQuery();

            if (rs.next()) {
                System.out.println("No se puede eliminar: el cuerpo celeste está relacionado con misiones o artículos.");
            } else {
                psDelete = con.prepareStatement("DELETE FROM cuerpoceleste WHERE nombre = ?");
                psDelete.setString(1, nombre);
                psDelete.executeUpdate();
                System.out.println("Cuerpo celeste eliminado correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (psCheck != null) {
                    psCheck.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (psDelete != null) {
                    psDelete.close();
                }
            } catch (SQLException e) {
            }
        }
    }

}
