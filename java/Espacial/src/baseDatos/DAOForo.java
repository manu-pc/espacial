/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import java.sql.*;
import aplicacion.EntradaForo;
/**
 *
 * @author basesdatos
 */
public class DAOForo extends AbstractDAO {

    public DAOForo(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }



}
