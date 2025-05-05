/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Estudiante extends Usuario {
    private String centro;
    private Integer num_est;

    protected Estudiante(String idUsuario, String clave, String nombre, String email, String centro, Integer num_est) {
        super(idUsuario, clave, nombre, email);
        this.centro = centro;
        this.num_est = num_est;
    }
    public String getCentro() {
        return centro;
    }
    public void setCentro(String centro) {
        this.centro = centro;
    }
    public Integer getNumEst() {
        return num_est;
    }
    public void setNumEst(Integer num_est) {
        this.num_est = num_est;
    }

    
}
