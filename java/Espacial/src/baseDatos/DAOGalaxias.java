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
    Connection con = null;
    PreparedStatement stmGalaxia = null;
    ResultSet rsGalaxia = null;

    try {
        con = this.getConexion();
        stmGalaxia = con.prepareStatement("SELECT nombre, tipo, ubicacion, descripcion FROM galaxia WHERE nombre = ?");
        stmGalaxia.setString(1, nombre);
        rsGalaxia = stmGalaxia.executeQuery();

        if (rsGalaxia.next()) {
            resultado = new Galaxia(
                rsGalaxia.getString("nombre"),
                TipoGalaxia.valueOf(rsGalaxia.getString("tipo")),
                rsGalaxia.getString("ubicacion"),
                rsGalaxia.getString("descripcion")
            );
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (rsGalaxia != null) rsGalaxia.close();
            if (stmGalaxia != null) stmGalaxia.close();
        } catch (SQLException e) {
            System.out.println("Imposible cerrar recursos.");
        }
    }
    return resultado;
}

    
    public java.util.List<Galaxia> obtenerGalaxia(String nombre) {
    java.util.List<Galaxia> resultado = new java.util.ArrayList<>();
    Connection con = null;
    PreparedStatement strGalaxias = null;
    ResultSet rslGalaxias = null;

    try {
        con = this.getConexion();
        String consulta = "SELECT nombre, tipo, ubicacion, descripcion FROM galaxia ";
        if (!nombre.isEmpty()) {
            consulta += "WHERE nombre LIKE ?";
        }

        strGalaxias = con.prepareStatement(consulta);
        if (!nombre.isEmpty()) {
            strGalaxias.setString(1, "%" + nombre + "%");
        }

        rslGalaxias = strGalaxias.executeQuery();

        while (rslGalaxias.next()) {
            Galaxia galaxiaActual = new Galaxia(
                rslGalaxias.getString("nombre"),
                TipoGalaxia.valueOf(rslGalaxias.getString("tipo")),
                rslGalaxias.getString("ubicacion"),
                rslGalaxias.getString("descripcion")
            );
            resultado.add(galaxiaActual);
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (rslGalaxias != null) rslGalaxias.close();
            if (strGalaxias != null) strGalaxias.close();
        } catch (SQLException e) {
            System.out.println("Imposible cerrar recursos.");
        }
    }

    return resultado;
}

    
    
    public void DarDeAltaGalaxia(Galaxia galaxia) {
    Connection con = null;
    PreparedStatement stmGalaxia = null;

    try {
        con = this.getConexion();
        con.setAutoCommit(false);

        stmGalaxia = con.prepareStatement(
            "INSERT INTO galaxia(nombre, tipo, ubicacion, descripcion) VALUES (?, ?, ?, ?)"
        );

        stmGalaxia.setString(1, galaxia.getNombreGalaxia());
        stmGalaxia.setString(2, galaxia.getTipoGalaxia().name());
        stmGalaxia.setString(3, galaxia.getUbicacionGalaxia());
        stmGalaxia.setString(4, galaxia.getDescGalaxia());

        stmGalaxia.executeUpdate();
        con.commit();

    } catch (SQLException e) {
        try {
            if (con != null) con.rollback();
        } catch (SQLException ex) {
        }
        System.out.println(e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (stmGalaxia != null) stmGalaxia.close();
            if (con != null) con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Imposible cerrar recursos.");
        }
    }
}

    
    public void modificarGalaxia(Galaxia galaxia) {
    Connection con = null;
    PreparedStatement stmGalaxia = null;

    try {
        con = this.getConexion();
        con.setAutoCommit(false);

        stmGalaxia = con.prepareStatement(
            "UPDATE galaxia SET nombre=?, tipo=?, ubicacion=?, descripcion=? WHERE nombre=?"
        );

        stmGalaxia.setString(1, galaxia.getNombreGalaxia());
        stmGalaxia.setString(2, galaxia.getTipoGalaxia().name());
        stmGalaxia.setString(3, galaxia.getUbicacionGalaxia());
        stmGalaxia.setString(4, galaxia.getDescGalaxia());
        stmGalaxia.setString(5, galaxia.getNombreGalaxia());

        if (stmGalaxia.executeUpdate() == 0) {
            throw new SQLException("No se ha encontrado la galaxia para modificar.");
        }

        con.commit();
    } catch (SQLException e) {
        try {
            if (con != null) con.rollback();
        } catch (SQLException ex) {
        }
        System.out.println(e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (stmGalaxia != null) stmGalaxia.close();
            if (con != null) con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Imposible cerrar recursos.");
        }
    }
}

public void borrarGalaxia(String nombre) {
    Connection con = null;
    PreparedStatement psCheck = null;
    PreparedStatement psDelete = null;
    ResultSet rs = null;

    try {
        con = this.getConexion();
        con.setAutoCommit(false);

        psCheck = con.prepareStatement(
            "SELECT 1 FROM galaxia g " +
            "LEFT JOIN cuerpoceleste cc ON g.nombre = cc.galaxia " +
            "WHERE g.nombre = ? AND cc.galaxia IS NOT NULL"
        );
        psCheck.setString(1, nombre);
        rs = psCheck.executeQuery();

        if (rs.next()) {
            this.getFachadaAplicacion().muestraExcepcion(
                "No se puede eliminar: la galaxia está relacionada con cuerpos celestes."
            );
        } else {
            psDelete = con.prepareStatement("DELETE FROM galaxia WHERE nombre = ?");
            psDelete.setString(1, nombre);
            if (psDelete.executeUpdate() == 0) {
                throw new SQLException("La galaxia no existe.");
            }
            System.out.println("Galaxia eliminada correctamente.");
        }

        con.commit();
    } catch (SQLException e) {
        try {
            if (con != null) con.rollback();
        } catch (SQLException ex) {
        }
        System.out.println("Error eliminando galaxia: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (psCheck != null) psCheck.close();
            if (psDelete != null) psDelete.close();
            if (con != null) con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Imposible cerrar recursos.");
        }
    }
}

}
