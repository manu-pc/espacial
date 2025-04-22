/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Usuario;
import aplicacion.UsuarioFactory;
import aplicacion.Administrador;
import aplicacion.Aficionado;
import aplicacion.Cientifico;
import aplicacion.Estudiante;
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

}
