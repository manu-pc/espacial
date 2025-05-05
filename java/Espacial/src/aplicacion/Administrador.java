/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
/**
 *
 * @author alumnogreibd
 */
public class Administrador extends Usuario {

    private String descripcion;

    protected Administrador(String idUsuario, String clave, String nombre, String email, String descripcion) {
        super(idUsuario, clave, nombre, email);
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
