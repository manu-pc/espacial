/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Categoria;
import java.sql.*;
/**
 *
 * @author basesdatos
 */
public class DAOCategorias extends AbstractDAO {
   
    
    public DAOCategorias (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Categoria> consultarCategorias(){
        java.util.List<Categoria> resultado = new java.util.ArrayList<Categoria>();
        Categoria categoriaActual;
        Connection con;
        PreparedStatement stmCategorias=null;
        ResultSet rsCategorias;

        con=this.getConexion();

        try  {
        stmCategorias=con.prepareStatement("select nombre, descripcion from categoria");
        rsCategorias=stmCategorias.executeQuery();
        while (rsCategorias.next())
        {
            categoriaActual = new Categoria(rsCategorias.getString("nombre"), rsCategorias.getString("descripcion"));
            resultado.add(categoriaActual);
        }

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmCategorias.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

public void insertarCategoria(String nombre, String descripcion) {
    Connection con;
    PreparedStatement stmCategoria = null;

    con = this.getConexion(); 

    try {

        stmCategoria = con.prepareStatement("INSERT INTO categoria (nombre, descripcion) VALUES (?, ?)");

        stmCategoria.setString(1, nombre);
        stmCategoria.setString(2, descripcion);

        stmCategoria.executeUpdate();

    } catch (SQLException e) {
        System.out.println("Error insertando la categoría: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (stmCategoria != null) stmCategoria.close();
        } catch (SQLException e) {
            System.out.println("Imposible cerrar cursores");
        }
    }
}

public void eliminarCategoria(String nombre) {
    Connection con;
    PreparedStatement stmCategoria = null;

    con = this.getConexion(); 

    try {
        stmCategoria = con.prepareStatement("DELETE FROM categoria WHERE nombre = ?");
        stmCategoria.setString(1, nombre); 
        
        int rowsAffected = stmCategoria.executeUpdate();
        if (rowsAffected == 0) {
            System.out.println("No existe la categoría " + nombre);
        }

    } catch (SQLException e) {
        System.out.println("Error eliminando la categoría: " + e.getMessage());
        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
    } finally {
        try {
            if (stmCategoria != null) stmCategoria.close();
        } catch (SQLException e) {
            System.out.println("Imposible cerrar cursores");
        }
    }
}

   

}
