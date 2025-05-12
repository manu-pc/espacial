/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import java.sql.*;
import java.util.ArrayList;

import aplicacion.EntradaForo;
import aplicacion.Usuario;

/**
 *
 * @author basesdatos
 */
public class DAOForo extends AbstractDAO {

    public DAOForo(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public void nuevaEntrada(Usuario u, String titulo, String contenido) {
        Connection con = null;
        PreparedStatement stmEntrada = null;

        try {
            con = this.getConexion();
            con.setAutoCommit(false);

            String consulta = "INSERT INTO EntradaForo (autor, fecha, titulo, contenido) VALUES (?, CURRENT_DATE, ?, ?)";
            stmEntrada = con.prepareStatement(consulta);
            stmEntrada.setString(1, u.getIdUsuario());
            stmEntrada.setString(2, titulo);
            stmEntrada.setString(3, contenido);

            stmEntrada.executeUpdate();
            con.commit();
            this.getFachadaAplicacion().muestraMensaje("Entrada publicada!");
        } catch (SQLException e) {
            try {
                if (con != null)
                    con.rollback();
            } catch (SQLException ex) {
            }
            System.out.println("Error insertando entrada en el foro: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmEntrada != null)
                    stmEntrada.close();
                if (con != null)
                    con.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Error cerrando recursos.");
            }
        }
    }

    public void modificarEntrada(EntradaForo entrada) {
        Connection con = null;
        PreparedStatement stmModificar = null;

        try {
            con = this.getConexion();
            con.setAutoCommit(false); // Transacción

            String consulta = "UPDATE EntradaForo SET titulo = ?, contenido = ? WHERE numeroEntrada = ? AND autor = ?";
            stmModificar = con.prepareStatement(consulta);
            stmModificar.setString(1, entrada.getTitulo());
            stmModificar.setString(2, entrada.getContenido());
            stmModificar.setInt(3, entrada.getNumEntrada());
            stmModificar.setString(4, entrada.getAutorId());

            if (stmModificar.executeUpdate() == 0) {
                throw new SQLException("¡No se ha encontrado la entrada! Puede que haya sido eliminada recientemente.");
            }

            con.commit();

        } catch (SQLException e) {
            try {
                if (con != null)
                    con.rollback();
            } catch (SQLException ex) {
            }
            System.out.println("Error modificando entrada en el foro: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmModificar != null)
                    stmModificar.close();
                if (con != null)
                    con.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Error cerrando recursos.");
            }
        }
    }

    public void eliminarEntrada(EntradaForo entrada) {
        Connection con = null;
        PreparedStatement stmEliminar = null;

        try {
            con = this.getConexion();
            con.setAutoCommit(false); // Transacción

            String consulta = "DELETE FROM EntradaForo WHERE numeroEntrada = ? AND autor = ?";
            stmEliminar = con.prepareStatement(consulta);
            stmEliminar.setInt(1, entrada.getNumEntrada());
            stmEliminar.setString(2, entrada.getAutorId());

            if (stmEliminar.executeUpdate() == 0) {
                throw new SQLException("¡No se ha encontrado la entrada! Puede que haya sido eliminada recientemente.");
            }
            con.commit();

        } catch (SQLException e) {
            try {
                if (con != null)
                    con.rollback();
            } catch (SQLException ex) {
            }
            System.out.println("Error eliminando entrada del foro: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmEliminar != null)
                    stmEliminar.close();
                if (con != null)
                    con.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Error cerrando recursos.");
            }
        }
    }

    // devuelve todas las entradas del foro escritar por el usuario u
    // el resultado está ordenado por fecha (más reciente primero)
    public ArrayList<EntradaForo> buscarEntradasPorAutor(String idUsuario) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<EntradaForo> entradas = new ArrayList<>();

        try {
            con = this.getConexion();
            String consulta = "SELECT numeroEntrada, titulo, contenido, fecha FROM EntradaForo WHERE autor = ? ORDER BY fecha DESC";
            stm = con.prepareStatement(consulta);
            stm.setString(1, idUsuario);

            rs = stm.executeQuery();
            while (rs.next()) {
                EntradaForo entrada = new EntradaForo();
                entrada.setNumEntrada(rs.getInt("numeroEntrada"));
                entrada.setTitulo(rs.getString("titulo"));
                entrada.setContenido(rs.getString("contenido"));
                entrada.setFecha(rs.getDate("fecha").toLocalDate());
                entrada.setAutorId(idUsuario);
                entradas.add(entrada);
            }

        } catch (SQLException e) {
            System.out.println("Error recuperando entradas del usuario: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stm != null)
                    stm.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando recursos.");
            }
        }

        return entradas;
    }

    // devuelve todas las entradas cuyo titulo empieza por comienzoTitulo
    // el resultado está ordenado por fecha (más reciente primero)
    public ArrayList<EntradaForo> buscarEntradasPorTitulo(String comienzoTitulo) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<EntradaForo> entradas = new ArrayList<>();

        try {
            con = this.getConexion();
            String consulta = "SELECT numeroEntrada, titulo, contenido, fecha, autor FROM EntradaForo WHERE titulo ILIKE ? ORDER BY fecha DESC";
            stm = con.prepareStatement(consulta);
            stm.setString(1, comienzoTitulo + "%");

            rs = stm.executeQuery();
            while (rs.next()) {
                EntradaForo entrada = new EntradaForo();
                entrada.setNumEntrada(rs.getInt("numeroEntrada"));
                entrada.setTitulo(rs.getString("titulo"));
                entrada.setContenido(rs.getString("contenido"));
                entrada.setFecha(rs.getDate("fecha").toLocalDate());
                entrada.setAutorId(rs.getString("autor"));

                entradas.add(entrada);
            }

        } catch (SQLException e) {
            System.out.println("Error recuperando entradas por título: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stm != null)
                    stm.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando recursos.");
            }
        }

        return entradas;
    }

    public ArrayList<EntradaForo> cargarEntradas() {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<EntradaForo> entradas = new ArrayList<>();

        try {
            con = this.getConexion();
            String consulta = "SELECT numeroEntrada, titulo, contenido, fecha, autor FROM EntradaForo ORDER BY fecha DESC";
            stm = con.prepareStatement(consulta);

            rs = stm.executeQuery();
            while (rs.next()) {
                EntradaForo entrada = new EntradaForo();
                entrada.setNumEntrada(rs.getInt("numeroEntrada"));
                entrada.setTitulo(rs.getString("titulo"));
                entrada.setContenido(rs.getString("contenido"));
                entrada.setFecha(rs.getDate("fecha").toLocalDate());
                entrada.setAutorId(rs.getString("autor"));

                entradas.add(entrada);
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar entradas del foro: " + e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stm != null)
                    stm.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando recursos.");
            }
        }

        return entradas;
    }

}
