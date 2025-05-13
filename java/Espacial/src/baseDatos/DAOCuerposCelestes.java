/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.CuerpoCeleste;
import aplicacion.TipoCuerpoCeleste;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author basesdatos
 */
public class DAOCuerposCelestes extends AbstractDAO {

    public DAOCuerposCelestes(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

public List<CuerpoCeleste> obtenerCuerpos(String nombre) {
    List<CuerpoCeleste> resultado = new ArrayList<>();
    Connection con = null;
    PreparedStatement strCuerpos = null;
    ResultSet rslCuerpos = null;

    try {
        con = this.getConexion();
        String consulta = "SELECT nombre, tipo, ubicacion, habitabilidad, masa, tamano, temperaturasuperficie, descripcion, galaxia, orbitaA FROM cuerpoceleste";
        if (!nombre.isEmpty()) {
            consulta += " WHERE nombre LIKE ?";
        }

        strCuerpos = con.prepareStatement(consulta);
        if (!nombre.isEmpty()) {
            strCuerpos.setString(1, "%" + nombre + "%");
        }
        rslCuerpos = strCuerpos.executeQuery();

        while (rslCuerpos.next()) {
            resultado.add(new CuerpoCeleste(
                rslCuerpos.getString("nombre"),
                TipoCuerpoCeleste.valueOf(rslCuerpos.getString("tipo")),
                rslCuerpos.getString("ubicacion"),
                rslCuerpos.getBoolean("habitabilidad"),
                rslCuerpos.getFloat("masa"),
                rslCuerpos.getFloat("tamano"),
                rslCuerpos.getFloat("temperaturasuperficie"),
                rslCuerpos.getString("descripcion"),
                rslCuerpos.getString("galaxia"),
                rslCuerpos.getString("orbitaA")
            ));
        }
    } catch (SQLException e) {
        System.out.println("Error obteniendo cuerpos celestes: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (rslCuerpos != null) rslCuerpos.close();
            if (strCuerpos != null) strCuerpos.close();
        } catch (SQLException e) {
            System.out.println("Error cerrando recursos: " + e.getMessage());
        }
    }
    return resultado;
}

public void DarDeAltaCuerpo(CuerpoCeleste cuerpo) {
    Connection con = null;
    PreparedStatement stmCuerpo = null;

    try {
        con = this.getConexion();
        con.setAutoCommit(false);

        stmCuerpo = con.prepareStatement("INSERT INTO cuerpoceleste(nombre, tipo, ubicacion, habitabilidad, masa, tamano, temperaturaSuperficie, descripcion, galaxia, orbitaA) VALUES (?,?,?,?,?,?,?,?,?,?)");
        stmCuerpo.setString(1, cuerpo.getNombreCuerpoCeleste());
        stmCuerpo.setString(2, cuerpo.getTipo().name());
        stmCuerpo.setString(3, cuerpo.getUbicacion());
        stmCuerpo.setBoolean(4, cuerpo.getHabitabilidad());
        stmCuerpo.setFloat(5, cuerpo.getMasa());
        stmCuerpo.setFloat(6, cuerpo.getTamanho());
        stmCuerpo.setFloat(7, cuerpo.getTemperaturaSuperficie());
        stmCuerpo.setString(8, cuerpo.getDescripcion());
        stmCuerpo.setString(9, cuerpo.getGalaxia());
        if (cuerpo.getOrbitaA() == null) {
            stmCuerpo.setNull(10, java.sql.Types.VARCHAR);
        } else {
            stmCuerpo.setString(10, cuerpo.getOrbitaA());
        }
        stmCuerpo.executeUpdate();

        con.commit();
    } catch (SQLException e) {
        try {
            if (con != null) con.rollback();
        } catch (SQLException ex) {}
        System.out.println("Error insertando cuerpo celeste: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (stmCuerpo != null) stmCuerpo.close();
            if (con != null) con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Error cerrando recursos: " + e.getMessage());
        }
    }
}

public void modificarCuerpo(CuerpoCeleste cuerpo) {
    Connection con = null;
    PreparedStatement stmCuerpo = null;

    try {
        con = this.getConexion();
        con.setAutoCommit(false);

        stmCuerpo = con.prepareStatement("UPDATE cuerpoceleste SET nombre=?, tipo=?, ubicacion=?, habitabilidad=?, masa=?, tamano=?, temperaturaSuperficie=?, descripcion=?, galaxia=?, orbitaA=? WHERE nombre=?");
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
        if (cuerpo.getOrbitaA() == null) {
            stmCuerpo.setNull(10, java.sql.Types.VARCHAR);
        } else {
            stmCuerpo.setString(10, cuerpo.getOrbitaA());
        }
        stmCuerpo.setString(11, cuerpo.getNombreCuerpoCeleste());

        stmCuerpo.executeUpdate();
        con.commit();
    } catch (SQLException e) {
        try {
            if (con != null) con.rollback();
        } catch (SQLException ex) {}
        System.out.println("Error modificando cuerpo celeste: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (stmCuerpo != null) stmCuerpo.close();
            if (con != null) con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Error cerrando recursos: " + e.getMessage());
        }
    }
}

public void borrarCuerpo(String nombre) {
    Connection con = null;
    PreparedStatement psCheck = null;
    PreparedStatement psDelete = null;
    ResultSet rs = null;

    try {
        con = getConexion();
        con.setAutoCommit(false);

        psCheck = con.prepareStatement("SELECT 1 FROM cuerpoceleste cc LEFT JOIN mision m ON m.objetivo = cc.nombre LEFT JOIN articulo a ON a.cuerpo = cc.nombre WHERE cc.nombre = ? AND (m.objetivo IS NOT NULL OR a.cuerpo IS NOT NULL)");
        psCheck.setString(1, nombre);
        rs = psCheck.executeQuery();

        if (rs.next()) {
            System.out.println("No se puede eliminar: el cuerpo celeste está relacionado con misiones o artículos.");
        } else {
            psDelete = con.prepareStatement("DELETE FROM cuerpoceleste WHERE nombre = ?");
            psDelete.setString(1, nombre);
            psDelete.executeUpdate();
            con.commit();
            System.out.println("Cuerpo celeste eliminado correctamente.");
        }
    } catch (SQLException e) {
        try {
            if (con != null) con.rollback();
        } catch (SQLException ex) {}
        System.out.println("Error eliminando cuerpo celeste: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (psCheck != null) psCheck.close();
            if (psDelete != null) psDelete.close();
            if (con != null) con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Error cerrando recursos: " + e.getMessage());
        }
    }
}

}
