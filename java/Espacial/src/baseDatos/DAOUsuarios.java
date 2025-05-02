/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Usuario;
import aplicacion.Administrador;
import aplicacion.Aficionado;
import aplicacion.Estudiante;
import aplicacion.Cientifico;

import aplicacion.UsuarioFactory;
import java.sql.*;

/**
 *
 * @author basesdatos
 */
public class DAOUsuarios extends AbstractDAO {

    public DAOUsuarios(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    // COMPLEJA
    // ? Recibe un idUsuario y una clave. Busca el usuario, identifica si esa es su
    // clave y devuelve el objeto subtipo de Usuario correspondiente.
    public Usuario validarUsuario(String idUsuario, String clave) {
        Usuario resultado = null;
        Connection con = null;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario = null;

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement(
                    "SELECT u.id, u.nombre, u.email, u.clave, " +
                            "       a.tier AS tier_aficionado, " +
                            "       e.centro AS centro_estudiante, e.num_est, " +
                            "       c.centro AS centro_cientifico, " +
                            "       ad.rango AS rango_admin " +
                            "FROM Usuario u " +
                            "LEFT JOIN Aficionado a ON u.id = a.id " +
                            "LEFT JOIN Estudiante e ON u.id = e.id " +
                            "LEFT JOIN Cientifico c ON u.id = c.id " +
                            "LEFT JOIN Administrador ad ON u.id = ad.id " +
                            "WHERE u.id = ? AND u.clave = ?");

            stmUsuario.setString(1, idUsuario);
            stmUsuario.setString(2, clave);
            rsUsuario = stmUsuario.executeQuery();

            if (rsUsuario.next()) {
                Usuario usuario = UsuarioFactory.crearUsuarioDesdeResultSet(rsUsuario);
                resultado = usuario;
            }

        } catch (SQLException e) {
            System.out.println("Error validando el usuario: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmUsuario != null)
                    stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando recursos de validación.");
            }
        }

        return resultado;
    }

    public java.util.List<Usuario> buscarUsuariosPorNombre(String nombre) {
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;
        java.util.List<Usuario> usuarios = new java.util.ArrayList<>();

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement(
                    "SELECT u.id, u.nombre, u.email, u.clave, " +
                            "       a.tier AS tier_aficionado, " +
                            "       e.centro AS centro_estudiante, e.num_est, " +
                            "       c.centro AS centro_cientifico, " +
                            "       ad.rango AS rango_admin " +
                            "FROM Usuario u " +
                            "LEFT JOIN Aficionado a ON u.id = a.id " +
                            "LEFT JOIN Estudiante e ON u.id = e.id " +
                            "LEFT JOIN Cientifico c ON u.id = c.id " +
                            "LEFT JOIN Administrador ad ON u.id = ad.id " +
                            "WHERE u.nombre = ?");

            stmUsuario.setString(1, nombre);
            rsUsuario = stmUsuario.executeQuery();

            while (rsUsuario.next()) {
                Usuario usuario = UsuarioFactory.crearUsuarioDesdeResultSet(rsUsuario);
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Error buscando usuario! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmUsuario != null)
                    stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de búsqueda.");
            }
        }

        return usuarios;
    }

    public java.util.List<Usuario> obtenerUsuarios() {
        java.util.List<Usuario> usuarios = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmUsuarios = null;
        ResultSet rsUsuarios;

        con = this.getConexion();

        try {
            stmUsuarios = con.prepareStatement(
                    "SELECT u.id, u.nombre, u.email, u.clave, " +
                            "       a.tier AS tier_aficionado, " +
                            "       e.centro AS centro_estudiante, e.num_est, " +
                            "       c.centro AS centro_cientifico, " +
                            "       ad.rango AS rango_admin " +
                            "FROM Usuario u " +
                            "LEFT JOIN Aficionado a ON u.id = a.id " +
                            "LEFT JOIN Estudiante e ON u.id = e.id " +
                            "LEFT JOIN Cientifico c ON u.id = c.id " +
                            "LEFT JOIN Administrador ad ON u.id = ad.id");

            rsUsuarios = stmUsuarios.executeQuery();

            while (rsUsuarios.next()) {
                Usuario usuario = UsuarioFactory.crearUsuarioDesdeResultSet(rsUsuarios);
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo la lista de usuarios! " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmUsuarios != null)
                    stmUsuarios.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la transacción de obtener usuarios.");
            }
        }

        return usuarios;
    }
public Usuario buscarUsuarioPorId(String idUsuario) {
    Usuario usuario = null;
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    try {
        con = this.getConexion();
        stm = con.prepareStatement(
            "SELECT u.id_usuario, u.clave, u.nombre, u.direccion, u.email, u.tipo_usuario, " +
            "       COALESCE(COUNT(p.usuario), 0) AS prestamos_vencidos, " +
            "       a.institucion AS institucion, " +
            "       e.fecha_nacimiento AS fecha_nacimiento, " +
            "       c.campo_investigacion AS campo_investigacion " +
            "FROM usuario u " +
            "LEFT JOIN prestamo p ON u.id_usuario = p.usuario " +
            "                    AND p.fecha_devolucion IS NULL " +
            "                    AND p.fecha_prestamo < (CURRENT_DATE - INTERVAL '30 days') " +
            "LEFT JOIN aficionado a ON u.id_usuario = a.usuario " +
            "LEFT JOIN estudiante e ON u.id_usuario = e.usuario " +
            "LEFT JOIN cientifico c ON u.id_usuario = c.usuario " +
            "WHERE u.id_usuario = ? " +
            "GROUP BY u.id_usuario, u.clave, u.nombre, u.direccion, u.email, u.tipo_usuario, " +
            "         a.institucion, e.fecha_nacimiento, c.campo_investigacion"
        );
        stm.setString(1, idUsuario);
        rs = stm.executeQuery();
            if (rs.next()) {
                usuario = UsuarioFactory.crearUsuarioDesdeResultSet(rs);
            }

    } catch (SQLException e) {
        System.out.println("Error buscando usuario por ID: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try { if (stm != null) stm.close(); } catch (SQLException ignored) {}
    }

    return usuario;
}

// VARIAS SQL
public void crearUsuario(Usuario usuario) {
    Connection con = null;
    PreparedStatement stmUsuario = null;
    PreparedStatement stmSubtipo = null;

    con = this.getConexion();
    try {
        con.setAutoCommit(false); // Transacción

        // Insertar en Usuario
        stmUsuario = con.prepareStatement(
            "INSERT INTO Usuario (id, nombre, email, clave) VALUES (?, ?, ?, ?)"
        );
        stmUsuario.setString(1, usuario.getIdUsuario());
        stmUsuario.setString(2, usuario.getNombre());
        stmUsuario.setString(3, usuario.getEmail());
        stmUsuario.setString(4, usuario.getClave());
        stmUsuario.executeUpdate();

        // Insertar en subtipo
        if (usuario instanceof Aficionado) {
            Aficionado aficionado = (Aficionado) usuario;
            stmSubtipo = con.prepareStatement(
                "INSERT INTO Aficionado (id, tier) VALUES (?, ?)"
            );
            stmSubtipo.setString(1, aficionado.getIdUsuario());
            stmSubtipo.setString(2, aficionado.getTier());
            stmSubtipo.executeUpdate();

        } else if (usuario instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) usuario;
            stmSubtipo = con.prepareStatement(
                "INSERT INTO Estudiante (id, centro, num_est) VALUES (?, ?, ?)"
            );
            stmSubtipo.setString(1, estudiante.getIdUsuario());
            stmSubtipo.setString(2, estudiante.getCentro());
            stmSubtipo.setInt(3, estudiante.getNumEst());
            stmSubtipo.executeUpdate();

        } else if (usuario instanceof Cientifico) {
            Cientifico cientifico = (Cientifico) usuario;
            stmSubtipo = con.prepareStatement(
                "INSERT INTO Cientifico (id, centro) VALUES (?, ?)"
            );
            stmSubtipo.setString(1, cientifico.getIdUsuario());
            stmSubtipo.setString(2, cientifico.getCentro());
            stmSubtipo.executeUpdate();

        } else if (usuario instanceof Administrador) {
            Administrador administrador = (Administrador) usuario;
            stmSubtipo = con.prepareStatement(
                "INSERT INTO Administrador (id, rango) VALUES (?, ?)"
            );
            stmSubtipo.setString(1, administrador.getIdUsuario());
            stmSubtipo.setString(2, administrador.getDescripcion());
            stmSubtipo.executeUpdate();
        }

        con.commit();

    } catch (SQLException e) {
        try { if (con != null) con.rollback(); } catch (SQLException ex) {}
        System.out.println("Error creando usuario: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (stmUsuario != null) stmUsuario.close();
            if (stmSubtipo != null) stmSubtipo.close();
            if (con != null) con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Error cerrando recursos.");
        }
    }
}


}
