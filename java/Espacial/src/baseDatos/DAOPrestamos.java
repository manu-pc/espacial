/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Categoria;
import java.sql.*;
import java.time.LocalDate;
/**
 *
 * @author basesdatos
 */
public class DAOPrestamos extends AbstractDAO {
   
    
    public DAOPrestamos (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

public void insertarPrestamo(String idUsuario, int idLibro, int numEjemplar, LocalDate fechaPrestamo) {
    if (contarPrestamosVencidos(idUsuario) > 0){
        this.getFachadaAplicacion().muestraExcepcion("¡El usuario tiene préstamos vencidos! No se le pueden prestar más libros.");
        return;
    }
    Connection con;
    PreparedStatement stmPrestamo = null;
    
    con = super.getConexion();

    try {
        stmPrestamo = con.prepareStatement(
            "INSERT INTO prestamo(usuario, libro, ejemplar, fecha_prestamo, fecha_devolucion) " +
            "VALUES (?, ?, ?, ?, NULL)"
        );

        stmPrestamo.setString(1, idUsuario); 
        stmPrestamo.setInt(2, idLibro); 
        stmPrestamo.setInt(3, numEjemplar);  
        stmPrestamo.setDate(4, java.sql.Date.valueOf(fechaPrestamo)); 
        
        stmPrestamo.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error insertando el préstamo!  " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (stmPrestamo != null) stmPrestamo.close();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error cerrando la transacción de préstamo.");
        }
    }
}

public int contarPrestamosVencidos(String idUsuario) {
    Connection con;
    PreparedStatement stmPrestamos = null;
    ResultSet rsPrestamos;
    int numVencidos = 0;

    con = super.getConexion();

    try {
        stmPrestamos = con.prepareStatement(
            "SELECT COUNT(*) AS vencidos " +
            "FROM prestamo " +
            "WHERE usuario = ? " +
            "AND fecha_devolucion IS NULL " +
            "AND CURRENT_DATE >= fecha_expiracion"
        );

        stmPrestamos.setString(1, idUsuario);
        rsPrestamos = stmPrestamos.executeQuery();

        if (rsPrestamos.next()) {
            numVencidos = rsPrestamos.getInt("vencidos");
        }

    } catch (SQLException e) {
        System.out.println("Error en la consulta de préstamos vencidos! " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (stmPrestamos != null) stmPrestamos.close();
        } catch (SQLException e) {
            System.out.println("Se ha producido un error cerrando la transacción de préstamo.");
        }
    }

    return numVencidos;
}

public void devolverPrestamo(String idUsuario, int idLibro, int numEjemplar, LocalDate fechaPrestamo) {
    Connection con;
    PreparedStatement stmDevolver = null;

    con = super.getConexion();

    try {
        stmDevolver = con.prepareStatement(
            "UPDATE prestamo " +
            "SET fecha_devolucion = ? " +
            "WHERE usuario = ? AND libro = ? AND ejemplar = ? " +
            "AND fecha_prestamo = ? AND fecha_devolucion IS NULL"
        );

        stmDevolver.setDate(1, java.sql.Date.valueOf(LocalDate.now())); // Set today's date
        stmDevolver.setString(2, idUsuario);
        stmDevolver.setInt(3, idLibro);
        stmDevolver.setInt(4, numEjemplar);
        stmDevolver.setDate(5, java.sql.Date.valueOf(fechaPrestamo)); // Ensure we update the correct loan

        int updatedRows = stmDevolver.executeUpdate();

        if (updatedRows == 0) {
            this.getFachadaAplicacion().muestraExcepcion("No se encontró un préstamo activo para devolver.");
        }
    } catch (SQLException e) {
        System.out.println("Error devolviendo el préstamo! " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (stmDevolver != null) stmDevolver.close();
        } catch (SQLException e) {
            System.out.println("Error cerrando la transacción de devolver préstamo");
        }
    }
}


}
