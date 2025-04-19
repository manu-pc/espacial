/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Usuario;
import aplicacion.TipoUsuario;
import java.sql.*;
/**
 *
 * @author basesdatos
 */
public class DAOUsuarios extends AbstractDAO {

   public DAOUsuarios (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

public Usuario validarUsuario(String idUsuario, String clave) {
    Usuario resultado = null;
    Connection con;
    PreparedStatement stmUsuario = null;
    ResultSet rsUsuario;

    con = this.getConexion();

    try {
        stmUsuario = con.prepareStatement(
            "SELECT u.id_usuario, u.clave, u.nombre, u.direccion, u.email, u.tipo_usuario, " +
            "       COALESCE(COUNT(p.usuario), 0) AS prestamos_vencidos " + //!
            "FROM usuario u " +
            "LEFT JOIN prestamo p ON u.id_usuario = p.usuario " +
            "                    AND p.fecha_devolucion IS NULL " + 
            "                    AND p.fecha_prestamo < (CURRENT_DATE - INTERVAL '30 days') " + // prestamos vencidos
            "WHERE u.id_usuario = ? AND u.clave = ? " +
            "GROUP BY u.id_usuario, u.clave, u.nombre, u.direccion, u.email, u.tipo_usuario"
        );

        stmUsuario.setString(1, idUsuario);
        stmUsuario.setString(2, clave);
        rsUsuario = stmUsuario.executeQuery();

        if (rsUsuario.next()) {
            resultado = new Usuario(
                rsUsuario.getString("id_usuario"),
                rsUsuario.getString("clave"),
                rsUsuario.getString("nombre"),
                rsUsuario.getString("direccion"),
                rsUsuario.getString("email"),
                TipoUsuario.valueOf(rsUsuario.getString("tipo_usuario")), 
                rsUsuario.getInt("prestamos_vencidos") 
            );
        }
    } catch (SQLException e) {
        System.out.println("Error validando el usuario! " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try { if (stmUsuario != null) stmUsuario.close(); } 
        catch (SQLException e) { System.out.println("Se ha producido un error validando el usuario."); }
    }

    return resultado;
}


public java.util.List<Usuario> obtenerUsuarios() {
    java.util.List<Usuario> usuarios = new java.util.ArrayList<>();
    Connection con;
    PreparedStatement stmUsuarios = null;
    ResultSet rsUsuarios;

    con = this.getConexion(); 

    try {
        stmUsuarios = con.prepareStatement(
            "SELECT u.id_usuario, u.clave, u.nombre, u.direccion, u.email, u.tipo_usuario, " +
            "       COALESCE(COUNT(p.usuario), 0) AS prestamos_vencidos " + //!
            "FROM usuario u " +
            "LEFT JOIN prestamo p ON u.id_usuario = p.usuario " +
            "                    AND p.fecha_devolucion IS NULL " + 
            "                    AND p.fecha_prestamo < (CURRENT_DATE - INTERVAL '30 days') " + // prestamos vencidos
            "GROUP BY u.id_usuario, u.clave, u.nombre, u.direccion, u.email, u.tipo_usuario"
        );

        rsUsuarios = stmUsuarios.executeQuery();

        while (rsUsuarios.next()) {
            Usuario usuario = new Usuario(
                rsUsuarios.getString("id_usuario"),
                rsUsuarios.getString("clave"),
                rsUsuarios.getString("nombre"),
                rsUsuarios.getString("direccion"),
                rsUsuarios.getString("email"),
                TipoUsuario.valueOf(rsUsuarios.getString("tipo_usuario")),  
                rsUsuarios.getInt("prestamos_vencidos")  
            );
            usuarios.add(usuario);
        }

    } catch (SQLException e) {
        System.out.println("Error obteniendo la lista de usuarios! " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try { if (stmUsuarios != null) stmUsuarios.close(); } 
        catch (SQLException e) { System.out.println("Se ha producido un error cerrando la transacción de obtener usuarios. "); }
    }

    return usuarios;
}


public java.util.List<Usuario> buscarUsuariosPorNombre(String nombre) {
    Connection con;
    PreparedStatement stmUsuario = null;
    ResultSet rsUsuario;
    java.util.List<Usuario> usuarios = new java.util.ArrayList<>();

    con = this.getConexion();

    try {
        stmUsuario = con.prepareStatement(
            "SELECT id_usuario, clave, nombre, direccion, email, tipo_usuario, " +
            "       COALESCE(COUNT(p.usuario), 0) AS prestamos_vencidos " + //! (coalesce --> convirte null a 0)
            "FROM usuario u " +
            "LEFT JOIN prestamo p ON u.id_usuario = p.usuario " +
            "                    AND p.fecha_devolucion IS NULL " + 
            "                    AND p.fecha_prestamo < (CURRENT_DATE - INTERVAL '30 days') " + // prestamos vencidos
            "WHERE u.nombre = ? " +
            "GROUP BY u.id_usuario, u.clave, u.nombre, u.direccion, u.email, u.tipo_usuario"
        );        stmUsuario.setString(1, nombre);
        rsUsuario = stmUsuario.executeQuery();

        while (rsUsuario.next()) {
            usuarios.add(new Usuario(
                rsUsuario.getString("id_usuario"),
                rsUsuario.getString("clave"),
                rsUsuario.getString("nombre"),
                rsUsuario.getString("direccion"),
                rsUsuario.getString("email"),
                TipoUsuario.valueOf(rsUsuario.getString("tipo_usuario")),
                rsUsuario.getInt("prestamos_vencidos")  
            ));
        }

    } catch (SQLException e) {
        System.out.println("Error buscando usuario! " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try { if (stmUsuario != null) stmUsuario.close(); } 
        catch (SQLException e) { System.out.println("Se ha producido un error cerrando la transacción de búsqueda."); }
    }

    return usuarios;
}

public Usuario buscarUsuarioPorId(String idUsuario) {
    Connection con;
    PreparedStatement stmUsuario = null;
    ResultSet rsUsuario;
    Usuario usuario = null;

    con = this.getConexion();

    try {
        stmUsuario = con.prepareStatement(
            "SELECT id_usuario, clave, nombre, direccion, email, tipo_usuario, " +
            "       COALESCE(COUNT(p.usuario), 0) AS prestamos_vencidos " +
            "FROM usuario u " +
            "LEFT JOIN prestamo p ON u.id_usuario = p.usuario " +
            "                    AND p.fecha_devolucion IS NULL " +  
            "                    AND p.fecha_prestamo < (CURRENT_DATE - INTERVAL '30 days') " +  
            "WHERE u.id_usuario = ? " +
            "GROUP BY u.id_usuario, u.clave, u.nombre, u.direccion, u.email, u.tipo_usuario"
        );

        stmUsuario.setString(1, idUsuario);
        rsUsuario = stmUsuario.executeQuery();

        if (rsUsuario.next()) {
            usuario = new Usuario(
                rsUsuario.getString("id_usuario"),
                rsUsuario.getString("clave"),
                rsUsuario.getString("nombre"),
                rsUsuario.getString("direccion"),
                rsUsuario.getString("email"),
                TipoUsuario.valueOf(rsUsuario.getString("tipo_usuario")),
                rsUsuario.getInt("prestamos_vencidos")  
            );
        }

    } catch (SQLException e) {
        System.out.println("Error buscando usuario! " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try { if (stmUsuario != null) stmUsuario.close(); } 
        catch (SQLException e) { System.out.println("Se ha producido un error cerrando la transacción de búsqueda."); }
    }

    return usuario;  
}


public void insertarUsuario(String id, String nombre, String clave, String email, String direccion, String tipo) {
    Connection con = null;
    PreparedStatement stmUsuario = null;

    try {
        con = this.getConexion();  

        stmUsuario = con.prepareStatement(
            "INSERT INTO Usuario (id_usuario, clave, nombre, direccion, email, tipo_usuario) " +
            "VALUES (?, ?, ?, ?, ?, ?)"
        );

        // Set parameters
        stmUsuario.setString(1, id);
        stmUsuario.setString(2, clave);
        stmUsuario.setString(3, nombre);
        stmUsuario.setString(4, direccion);
        stmUsuario.setString(5, email);
        stmUsuario.setString(6, tipo); 

        stmUsuario.executeUpdate(); 

    } catch (SQLException e) {
        System.out.println("Error insertando usuario! " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try { if (stmUsuario != null) stmUsuario.close(); } 
        catch (SQLException e) { System.out.println("Error cerrando la transacción de insertar usuario."); }
    }
}

public void modificarUsuario(String id_nuevo, String nombre, String clave, String email, String direccion, String tipo, String id_previo) {
    Connection con = null;
    PreparedStatement stmUsuario = null;

    try {
        con = this.getConexion();

        stmUsuario = con.prepareStatement(
            "UPDATE Usuario SET id_usuario = ?, clave = ?, nombre = ?, direccion = ?, email = ?, tipo_usuario = ? " +
            "WHERE id_usuario = ?"
        );

        // Set parameters
        stmUsuario.setString(1, id_nuevo);  // Nuevo ID del usuario
        stmUsuario.setString(2, clave);
        stmUsuario.setString(3, nombre);
        stmUsuario.setString(4, direccion);
        stmUsuario.setString(5, email);
        stmUsuario.setString(6, tipo);
        stmUsuario.setString(7, id_previo);  // ID actual del usuario

        int rowsUpdated = stmUsuario.executeUpdate(); 

        if (rowsUpdated == 0) {
            System.out.println("No se encontró un usuario con ID: " + id_previo);
        }

    } catch (SQLException e) {
        System.out.println("Error actualizando usuario! " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try { if (stmUsuario != null) stmUsuario.close(); } 
        catch (SQLException e) { System.out.println("Error cerrando la transacción de modificar usuario."); }
    }
}


public void eliminarUsuario(String id) {
    Connection con = null;
    PreparedStatement stmUsuario = null;

    try {
        con = this.getConexion();  

        stmUsuario = con.prepareStatement(
            "DELETE FROM Usuario WHERE id_usuario = ?"
        );

        // Set parameter
        stmUsuario.setString(1, id);  

        int rowsDeleted = stmUsuario.executeUpdate();  

        if (rowsDeleted == 0) {
            System.out.println("No user found with ID: " + id);
        }

    } catch (SQLException e) {
        System.out.println("Error eliminando usuario! " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try { if (stmUsuario != null) stmUsuario.close(); } 
        catch (SQLException e) { System.out.println("Error cerrando la transacción de eliminar usuario. "); }
    }
}


}
