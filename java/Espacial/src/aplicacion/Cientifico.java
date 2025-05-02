/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Cientifico extends Usuario {
    private String centro;
    private Integer numArticulos;
    protected Cientifico(String idUsuario, String clave, String nombre, String email, String centro, Integer numArticulos) {
        super(idUsuario, clave, nombre, email);
        this.centro = centro;
        this.numArticulos = numArticulos;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }
    public Integer getNumArticulos() {
        return numArticulos;
    }
    public void setNumArticulos(Integer numArticulos) {
        this.numArticulos = numArticulos;
    }
}
