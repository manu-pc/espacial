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
    private String rango;

    protected Administrador(String idUsuario, String clave, String nombre, String email, String rango) {
        super(idUsuario, clave, nombre, email);
        this.rango = rango;
    }
    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }
}
