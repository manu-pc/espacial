/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package baseDatos;
import aplicacion.Galaxia;
import aplicacion.TipoGalaxia;
import java.sql.*;

/**
 *
 * @author basesdatos
 */
public class DAOGalaxias extends AbstractDAO {

    public DAOGalaxias(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Galaxia validarGalaxia(String nombre) {
        Galaxia resultado = null;
        Connection con;
        PreparedStatement stmGalaxia = null;
        ResultSet rsGalaxia;

        con = this.getConexion();

        try {
            stmGalaxia = con.prepareStatement("select nombre, tipo, ubicacion, descripcion "
                    + "from galaxia "
                    + "where nombre = ?");
            stmGalaxia.setString(1, nombre);
            rsGalaxia = stmGalaxia.executeQuery();
            if (rsGalaxia.next()) {
                resultado = new Galaxia(rsGalaxia.getString("nombre"), TipoGalaxia.valueOf(rsGalaxia.getString("tipo")),
                        rsGalaxia.getString("ubicacion"), rsGalaxia.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmGalaxia.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public java.util.List<Galaxia> obtenerGalaxia(String nombre) {
        java.util.List<Galaxia> resultado = new java.util.ArrayList<Galaxia>();
        Galaxia galaxiaActual;
        Connection con;
        PreparedStatement strGalaxias = null;
        ResultSet rslGalaxias;

        con = this.getConexion();
        String consulta = "select nombre, tipo, ubicacion, descripcion "
                + "from galaxia ";
        if (!nombre.isEmpty()) {
            consulta = consulta + "where nombre like '%" + nombre + "%' ";
        }
        try {
            strGalaxias = con.prepareStatement(consulta);
            rslGalaxias = strGalaxias.executeQuery();

            while (rslGalaxias.next()) {
                galaxiaActual = new Galaxia(rslGalaxias.getString("nombre"), TipoGalaxia.valueOf(rslGalaxias.getString("tipo")),
                        rslGalaxias.getString("ubicacion"),rslGalaxias.getString("descripcion"));
                resultado.add(galaxiaActual);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                strGalaxias.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    public void DarDeAltaGalaxia(Galaxia galaxia) {
        Connection con;
        PreparedStatement stmGalaxia = null;

        con = super.getConexion();

        try {
            stmGalaxia = con.prepareStatement("insert into galaxia(nombre, tipo, ubicacion, descripcion) "
                    + "values (?,?,?,?,?,?,?,?,?)");
            stmGalaxia.setString(1, galaxia.getNombreGalaxia());
            stmGalaxia.setString(2, galaxia.getTipoGalaxia().name());
            stmGalaxia.setString(3, galaxia.getUbicacionGalaxia());
            stmGalaxia.setString(8, galaxia.getDescGalaxia());

            stmGalaxia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmGalaxia.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void modificarGalaxia(Galaxia galaxia) {
        Connection con;
        PreparedStatement stmGalaxia = null;

        con = super.getConexion();

        try {
            stmGalaxia = con.prepareStatement("update galaxia "
                    + "set nombre=?, "
                    + "    tipo=?, "
                    + "    ubicacion=?, "
                    + "    descripcion=?, "
                    + "where nombre=?");
            stmGalaxia.setString(1, galaxia.getNombreGalaxia());
            stmGalaxia.setString(2, galaxia.getTipoGalaxia().name());
            stmGalaxia.setString(3, galaxia.getUbicacionGalaxia());
            stmGalaxia.setString(8, galaxia.getDescGalaxia());
            stmGalaxia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmGalaxia.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void borrarGalaxia(String nombre) {

        Connection con = getConexion();
        PreparedStatement psCheck = null;
        PreparedStatement psDelete = null;
        ResultSet rs = null;

        try {
            psCheck = con.prepareStatement("""
        SELECT 1
        FROM galaxia g
        LEFT JOIN cuerpoceleste cc ON g.nombre = cc.galaxia
        WHERE g.nombre = ? AND (cc.galaxia IS NOT NULL)
    """);
            psCheck.setString(1, nombre);
            rs = psCheck.executeQuery();

            if (rs.next()) {
                System.out.println("No se puede eliminar: la galaxia está relacionada con cuerpos celestes.");
            } else {
                psDelete = con.prepareStatement("DELETE FROM galaxia WHERE nombre = ?");
                psDelete.setString(1, nombre);
                psDelete.executeUpdate();
                System.out.println("Galaxia eliminado correctamente.");
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
