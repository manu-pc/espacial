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
import aplicacion.Colaboracion;
import aplicacion.UsuarioFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                            "       c.centro AS centro_cientifico, c.num_articulos, " +
                            "       ad.rango AS rango_admin " +
                            "FROM Usuario u " +
                            "LEFT JOIN Aficionado a ON u.id = a.id " +
                            "LEFT JOIN Estudiante e ON u.id = e.id " +
                            "LEFT JOIN CientificoConArticulos c ON u.id = c.id " +
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

    public Usuario buscarUsuarioPorId(String idUsuario) {
        Usuario usuario = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = this.getConexion();
            stm = con.prepareStatement(
                    "SELECT u.id, u.nombre, u.email, u.clave, " +
                            "       a.tier AS tier_aficionado, " +
                            "       e.centro AS centro_estudiante, e.num_est, " +
                            "       c.centro AS centro_cientifico, c.num_articulos, " +
                            "       ad.rango AS rango_admin " +
                            "FROM Usuario u " +
                            "LEFT JOIN Aficionado a ON u.id = a.id " +
                            "LEFT JOIN Estudiante e ON u.id = e.id " +
                            "LEFT JOIN CientificoConArticulos c ON u.id = c.id " +
                            "LEFT JOIN Administrador ad ON u.id = ad.id " +
                            "WHERE u.id = ?");
            stm.setString(1, idUsuario);
            rs = stm.executeQuery();

            if (rs.next()) {
                usuario = UsuarioFactory.crearUsuarioDesdeResultSet(rs);
            }

        } catch (SQLException e) {
            System.out.println("Error buscando usuario por ID: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stm != null)
                    stm.close();
            } catch (SQLException ignored) {
            }
        }

        return usuario;
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
                            "       c.centro AS centro_cientifico, c.num_articulos, " +
                            "       ad.rango AS rango_admin " +
                            "FROM Usuario u " +
                            "LEFT JOIN Aficionado a ON u.id = a.id " +
                            "LEFT JOIN Estudiante e ON u.id = e.id " +
                            "LEFT JOIN CientificoConArticulos c ON u.id = c.id " +
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
                            "       c.centro AS centro_cientifico, c.num_articulos, " +
                            "       ad.rango AS rango_admin " +
                            "FROM Usuario u " +
                            "LEFT JOIN Aficionado a ON u.id = a.id " +
                            "LEFT JOIN Estudiante e ON u.id = e.id " +
                            "LEFT JOIN CientificoConArticulos c ON u.id = c.id " +
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
                    "INSERT INTO Usuario (id, nombre, email, clave) VALUES (?, ?, ?, ?)");
            stmUsuario.setString(1, usuario.getIdUsuario());
            stmUsuario.setString(2, usuario.getNombre());
            stmUsuario.setString(3, usuario.getEmail());
            stmUsuario.setString(4, usuario.getClave());
            stmUsuario.executeUpdate();

            // Insertar en subtipo
            if (usuario instanceof Aficionado) {
                Aficionado aficionado = (Aficionado) usuario;
                stmSubtipo = con.prepareStatement(
                        "INSERT INTO Aficionado (id, tier) VALUES (?, ?)");
                stmSubtipo.setString(1, aficionado.getIdUsuario());
                stmSubtipo.setString(2, aficionado.getTier());
                stmSubtipo.executeUpdate();

            } else if (usuario instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) usuario;
                stmSubtipo = con.prepareStatement(
                        "INSERT INTO Estudiante (id, centro, num_est) VALUES (?, ?, ?)");
                stmSubtipo.setString(1, estudiante.getIdUsuario());
                stmSubtipo.setString(2, estudiante.getCentro());
                stmSubtipo.setInt(3, estudiante.getNumEst());
                stmSubtipo.executeUpdate();

            } else if (usuario instanceof Cientifico) {
                Cientifico cientifico = (Cientifico) usuario;
                stmSubtipo = con.prepareStatement(
                        "INSERT INTO Cientifico (id, centro) VALUES (?, ?)");
                stmSubtipo.setString(1, cientifico.getIdUsuario());
                stmSubtipo.setString(2, cientifico.getCentro());
                stmSubtipo.executeUpdate();

            } else if (usuario instanceof Administrador) {
                Administrador administrador = (Administrador) usuario;
                stmSubtipo = con.prepareStatement(
                        "INSERT INTO Administrador (id, rango) VALUES (?, ?)");
                stmSubtipo.setString(1, administrador.getIdUsuario());
                stmSubtipo.setString(2, administrador.getDescripcion());
                stmSubtipo.executeUpdate();
            }

            con.commit();

        } catch (SQLException e) {
            try {
                if (con != null)
                    con.rollback();
            } catch (SQLException ex) {
            }
            System.out.println("Error creando usuario: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmUsuario != null)
                    stmUsuario.close();
                if (stmSubtipo != null)
                    stmSubtipo.close();
                if (con != null)
                    con.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Error cerrando recursos.");
            }
        }
    }

    public void modificarUsuario(Usuario usuario, String idPrevio) {
        Connection con = null;
        PreparedStatement stmUsuario = null;
        PreparedStatement stmSubtipo = null;

        con = this.getConexion();
        try {
            con.setAutoCommit(false); // Transacción

            // Modificar datos en Usuario
            stmUsuario = con.prepareStatement(
                    "UPDATE Usuario SET id = ?, nombre = ?, email = ?, clave = ? WHERE id = ?");
            stmUsuario.setString(2, usuario.getNombre());
            stmUsuario.setString(3, usuario.getEmail());
            stmUsuario.setString(4, usuario.getClave());
            stmUsuario.setString(1, usuario.getIdUsuario());
            stmUsuario.setString(5, idPrevio);

            stmUsuario.executeUpdate();

            // Modificar en tabla de subtipo correspondiente
            if (usuario instanceof Aficionado) {
                Aficionado aficionado = (Aficionado) usuario;
                stmSubtipo = con.prepareStatement(
                        "UPDATE Aficionado SET tier = ? WHERE id = ?");
                stmSubtipo.setString(1, aficionado.getTier());
                stmSubtipo.setString(2, aficionado.getIdUsuario());
                stmSubtipo.executeUpdate();

            } else if (usuario instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) usuario;
                stmSubtipo = con.prepareStatement(
                        "UPDATE Estudiante SET centro = ?, num_est = ? WHERE id = ?");
                stmSubtipo.setString(1, estudiante.getCentro());
                stmSubtipo.setInt(2, estudiante.getNumEst());
                stmSubtipo.setString(3, estudiante.getIdUsuario());
                stmSubtipo.executeUpdate();

            } else if (usuario instanceof Cientifico) {
                Cientifico cientifico = (Cientifico) usuario;
                stmSubtipo = con.prepareStatement(
                        "UPDATE Cientifico SET centro = ? WHERE id = ?");
                stmSubtipo.setString(1, cientifico.getCentro());
                stmSubtipo.setString(2, cientifico.getIdUsuario());
                stmSubtipo.executeUpdate();

            } else if (usuario instanceof Administrador) {
                Administrador administrador = (Administrador) usuario;
                stmSubtipo = con.prepareStatement(
                        "UPDATE Administrador SET rango = ? WHERE id = ?");
                stmSubtipo.setString(1, administrador.getDescripcion());
                stmSubtipo.setString(2, administrador.getIdUsuario());
                stmSubtipo.executeUpdate();
            }

            con.commit();

        } catch (SQLException e) {
            try {
                if (con != null)
                    con.rollback();
            } catch (SQLException ex) {
            }
            System.out.println("Error modificando usuario: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmUsuario != null)
                    stmUsuario.close();
                if (stmSubtipo != null)
                    stmSubtipo.close();
                if (con != null)
                    con.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Error cerrando recursos.");
            }
        }
    }

    public void eliminarUsuario(String idUsuario) {
        Connection con = null;
        PreparedStatement stmSubtipo = null;
        PreparedStatement stmUsuario = null;
        PreparedStatement stmDetectar = null;
        ResultSet rs = null;

        con = this.getConexion();
        try {
            con.setAutoCommit(false); // Transacción

            // Detectar subtipo al que pertenece el usuario
            String tablaSubtipo = null;

            String[] subtipos = { "Aficionado", "Estudiante", "Cientifico", "Administrador" };
            for (String subtipo : subtipos) {
                String consulta = "SELECT 1 FROM " + subtipo + " WHERE id = ?";
                stmDetectar = con.prepareStatement(consulta);
                stmDetectar.setString(1, idUsuario);
                rs = stmDetectar.executeQuery();
                if (rs.next()) {
                    tablaSubtipo = subtipo;
                    break;
                }
                rs.close();
                stmDetectar.close();
            }

            if (tablaSubtipo == null) {
                throw new SQLException("No se encontró subtipo para el usuario con id: " + idUsuario);
            }

            // Eliminar del subtipo detectado
            stmSubtipo = con.prepareStatement("DELETE FROM " + tablaSubtipo + " WHERE id = ?");
            stmSubtipo.setString(1, idUsuario);
            stmSubtipo.executeUpdate();

            // Eliminar de Usuario
            stmUsuario = con.prepareStatement("DELETE FROM Usuario WHERE id = ?");
            stmUsuario.setString(1, idUsuario);
            stmUsuario.executeUpdate();

            con.commit();

        } catch (SQLException e) {
            try {
                if (con != null)
                    con.rollback();
            } catch (SQLException ex) {
            }
            System.out.println("Error eliminando usuario: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmDetectar != null)
                    stmDetectar.close();
                if (stmSubtipo != null)
                    stmSubtipo.close();
                if (stmUsuario != null)
                    stmUsuario.close();
                if (con != null)
                    con.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Error cerrando recursos.");
            }
        }
    }

    public List<Colaboracion> obtenerColaboraciones(Cientifico cientifico) {
        List<Colaboracion> colaboraciones = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = this.getConexion();
            stm = con.prepareStatement(
                    "SELECT fechaInicio, fechaFin, cientifico, agencia " +
                            "FROM Colaboracion " +
                            "WHERE cientifico = ?");
            stm.setString(1, cientifico.getIdUsuario());
            rs = stm.executeQuery();

            while (rs.next()) {
                Colaboracion colaboracion = new Colaboracion();
                colaboracion.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());

                Date fechaFin = rs.getDate("fechaFin");
                if (fechaFin != null) {
                    colaboracion.setFechaFin(fechaFin.toLocalDate());
                }

                colaboracion.setCientifico(rs.getString("cientifico"));
                colaboracion.setAgencia(rs.getString("agencia"));

                colaboraciones.add(colaboracion);
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo colaboraciones: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stm != null)
                    stm.close();
            } catch (SQLException ignored) {
            }
        }

        return colaboraciones;
    }

    public void finalizarColaboracion(Colaboracion colaboracion) {
        Connection con = null;
        PreparedStatement stm = null;
        String nombreAgencia = colaboracion.getAgencia();
        String cientifico = colaboracion.getCientifico();
        try {
            con = this.getConexion();
            stm = con.prepareStatement(
                    "UPDATE Colaboracion " +
                            "SET fechaFin = CURRENT_DATE " +
                            "WHERE cientifico = ? AND agencia = ? AND fechaFin IS NULL");
            stm.setString(1, cientifico);
            stm.setString(2, nombreAgencia);
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error finalizando colaboración: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stm != null)
                    stm.close();
            } catch (SQLException ignored) {
            }
        }
    }

    public void insertarColaboracion(Cientifico cientifico, String nombreAgencia) {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = this.getConexion();
            stm = con.prepareStatement(
                    "INSERT INTO Colaboracion (fechaInicio, fechaFin, cientifico, agencia) " +
                            "VALUES (CURRENT_DATE, NULL, ?, ?)");
            stm.setString(1, cientifico.getIdUsuario());
            stm.setString(2, nombreAgencia);
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error insertando colaboración: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stm != null)
                    stm.close();
            } catch (SQLException ignored) {
            }
        }
    }

}
