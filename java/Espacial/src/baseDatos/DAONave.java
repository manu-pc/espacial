package baseDatos;

import aplicacion.Nave;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAONave extends AbstractDAO {

    public DAONave(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public List<Nave> obtenerNaves() {
        List<Nave> resultado = new ArrayList<>();
        Connection con;
        PreparedStatement stmNaves = null;
        ResultSet rsNaves;

        con = this.getConexion();

        try {
            stmNaves = con.prepareStatement(
                "SELECT id, nombre, tipo, tamano, masa FROM nave"
            );
            rsNaves = stmNaves.executeQuery();
            while (rsNaves.next()) {
                Nave naveActual = new Nave(
                    rsNaves.getInt("id"),
                    rsNaves.getString("nombre"),
                    rsNaves.getString("tipo"),
                    rsNaves.getFloat("tamano"),
                    rsNaves.getFloat("masa")
                );
                resultado.add(naveActual);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener naves: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmNaves != null) stmNaves.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    public void borrarNave(Nave nave) {
    Integer idNave= nave.getIDNave();
    Connection con;
    PreparedStatement stmBorrar = null;

    con = this.getConexion();

    try {
        stmBorrar = con.prepareStatement("DELETE FROM nave WHERE id = ?");
        stmBorrar.setInt(1, idNave);

        int filas = stmBorrar.executeUpdate();
        if (filas == 0) {
            System.out.println("No se encontró la nave con ID " + idNave);
        }

    } catch (SQLException e) {
        System.out.println("Error al borrar la nave: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (stmBorrar != null) stmBorrar.close();
        } catch (SQLException e) {
            System.out.println("Imposible cerrar cursores");
        }
    }
}

    public void anadirNave(Nave nave) {
        Connection con;
        PreparedStatement stmInsertar = null;

        con = this.getConexion();

        try {
            stmInsertar = con.prepareStatement(
                "INSERT INTO nave (id, nombre, tipo, tamano, masa) VALUES (?, ?, ?, ?, ?)"
            );
            stmInsertar.setInt(1, nave.getIDNave());
            stmInsertar.setString(2, nave.getNombre());
            stmInsertar.setString(3, nave.getTipo());
            stmInsertar.setFloat(4, nave.getTamanho());
            stmInsertar.setFloat(5, nave.getMasa());

            stmInsertar.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar la nave: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmInsertar != null) stmInsertar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

       

    public void actualizarNave(Nave nave) {
        Connection con = this.getConexion();
        PreparedStatement stm = null;

        try {
            stm = con.prepareStatement(
                "UPDATE nave SET nombre = ?, tipo = ?, tamano = ?, masa = ? WHERE id = ?"
            );
            stm.setString(1, nave.getNombre());
            stm.setString(2, nave.getTipo());
            stm.setFloat(3, nave.getTamanho());
            stm.setFloat(4, nave.getMasa());
            stm.setInt(5, nave.getIDNave());
            stm.executeUpdate();
        } catch (SQLException e) {
            this.getFachadaAplicacion().muestraExcepcion("Error actualizando nave: " + e.getMessage());
        } finally {
            try { if (stm != null) stm.close(); } catch (SQLException e) {}
        }
}
public List<Nave> buscarNavePorId(Integer id) {
    List<Nave> resultado = new ArrayList<>();
    Connection con = this.getConexion();
    PreparedStatement stmBuscar = null;
    ResultSet rsNave = null;

    try {
        stmBuscar = con.prepareStatement(
            "SELECT id, nombre, tipo, tamano, masa FROM nave WHERE id = ?"
        );
        stmBuscar.setInt(1, id);

        rsNave = stmBuscar.executeQuery();

        while (rsNave.next()) {
            Nave nave = new Nave(
                rsNave.getInt("id"),
                rsNave.getString("nombre"),
                rsNave.getString("tipo"),
                rsNave.getFloat("tamano"),
                rsNave.getFloat("masa")
            );
            resultado.add(nave);
        }

    } catch (SQLException e) {
        System.out.println("Error al obtener las naves: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (stmBuscar != null) stmBuscar.close();
            if (rsNave != null) rsNave.close();
        } catch (SQLException e) {
            System.out.println("Imposible cerrar cursores");
        }
    }

    return resultado;
}

public List<Nave> buscarNavePorNombre(String nombre) {
    List<Nave> resultado = new ArrayList<>();
    Connection con = this.getConexion();
    PreparedStatement stmBuscar = null;
    ResultSet rsNave = null;

    try {
        stmBuscar = con.prepareStatement(
            "SELECT id, nombre, tipo, tamano, masa FROM nave WHERE nombre LIKE ?"
        );
        // Busca todas las naves que contienen la cadena introducida :)
        stmBuscar.setString(1, "%"+nombre+"%");

        rsNave = stmBuscar.executeQuery();

        while (rsNave.next()) {
            Nave nave = new Nave(
                rsNave.getInt("id"),
                rsNave.getString("nombre"),
                rsNave.getString("tipo"),
                rsNave.getFloat("tamano"),
                rsNave.getFloat("masa")
            );
            resultado.add(nave);
        }

    } catch (SQLException e) {
        System.out.println("Error al obtener las naves: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (stmBuscar != null) stmBuscar.close();
            if (rsNave != null) rsNave.close();
        } catch (SQLException e) {
            System.out.println("Imposible cerrar cursores");
        }
    }

    return resultado;
}

    
    

}
