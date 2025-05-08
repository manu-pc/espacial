/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import aplicacion.Articulo;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author alumnogreibd
 */
public class DAOArticulos extends AbstractDAO {
    
    public DAOArticulos(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public List<Articulo> obtenerTodosLosArticulos() {
        
        Connection con;
        PreparedStatement stmArticulos = null;
        ResultSet rsArticulos;
        List<Articulo> listaArticulos = new ArrayList<>();

        con = super.getConexion();

        try {
            stmArticulos = con.prepareStatement(
                "SELECT id, fechaPublicacion, autor, cuerpo, descripcion, numPaginas " +
                "FROM Artículo"
            );

            rsArticulos = stmArticulos.executeQuery();

            while (rsArticulos.next()) {
                int id = rsArticulos.getInt("id");
            
                // Obtenemos la fecha como java.sql.Date y la convertimos a LocalDate
                java.sql.Date fechaSql = rsArticulos.getDate("fechaPublicacion");
                LocalDate fechaPublicacion1 = (fechaSql != null) ? fechaSql.toLocalDate() : null;

                String autor = rsArticulos.getString("autor");
                String cuerpo = rsArticulos.getString("cuerpo");
                String descripcion = rsArticulos.getString("descripcion");
                int numPaginas = rsArticulos.getInt("numPaginas");

                Articulo articulo = new Articulo(id, fechaPublicacion1, autor, cuerpo, descripcion, numPaginas);
                listaArticulos.add(articulo);
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta de artículos! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmArticulos != null) stmArticulos.close();
            } catch (SQLException e) {
                System.out.println("Se ha producido un error cerrando la transacción de artículos.");
            }
        }

        return listaArticulos;
    }
    
    public void guardarArticulo(Articulo articulo) {
        Connection con;
        PreparedStatement stmInsertarArticulo = null;

        con = super.getConexion();

        try {
            String sql = "INSERT INTO Artículo (fechaPublicacion, autor, cuerpo, descripcion, numPaginas) VALUES (?, ?, ?, ?, ?)";

            stmInsertarArticulo = con.prepareStatement(sql);

            // Asignar los valores del artículo a los parámetros del PreparedStatement
            stmInsertarArticulo.setDate(1, java.sql.Date.valueOf(articulo.getFechaPublicacion())); // Convertir LocalDate a java.sql.Date
            stmInsertarArticulo.setString(2, articulo.getAutor());
            stmInsertarArticulo.setString(3, articulo.getCuerpoCeleste());
            stmInsertarArticulo.setString(4, articulo.getDescripcion());
            stmInsertarArticulo.setInt(5, articulo.getNumPaginas());

            // Ejecutar la inserción
            stmInsertarArticulo.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar el artículo! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmInsertarArticulo != null) stmInsertarArticulo.close();
            } catch (SQLException e) {
                System.out.println("Se ha producido un error cerrando la transacción de inserción.");
            }
        }
    }
    
    public void guardarArticuloNuevo(Articulo articulo) {
    
        Connection con;
        PreparedStatement stmArticulo = null;

        con = super.getConexion();

        try {
            stmArticulo = con.prepareStatement(
                "UPDATE Artículo " +
                "SET fechaPublicacion = ?, " +
                "    autor = ?, " +
                "    cuerpo = ?, " +
                "    descripcion = ?, " +
                "    numPaginas = ? " +
                "WHERE id = ?"
            );

            // Asignar los valores del artículo a los parámetros del PreparedStatement
            stmArticulo.setDate(1, java.sql.Date.valueOf(articulo.getFechaPublicacion())); // Convertir LocalDate a java.sql.Date
            stmArticulo.setString(2, articulo.getAutor());
            stmArticulo.setString(3, articulo.getCuerpoCeleste());
            stmArticulo.setString(4, articulo.getDescripcion());
            stmArticulo.setInt(5, articulo.getNumPaginas());
            stmArticulo.setInt(6, articulo.getId());

            // Ejecutar la actualización
            stmArticulo.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmArticulo != null) stmArticulo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void borrarArticulo(Articulo articulo) {
    
        Connection con;
        PreparedStatement stmArticulo = null;

        con = super.getConexion();

        try {
            stmArticulo = con.prepareStatement(
                "DELETE FROM Artículo WHERE id = ?"
            );

            // Establecemos el valor del parámetro 'id' con el id del artículo a eliminar
            stmArticulo.setInt(1, articulo.getId());

            // Ejecutar la eliminación
            stmArticulo.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmArticulo != null) stmArticulo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }   
}
