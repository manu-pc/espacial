/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Aficionado extends Usuario {
    private String tier;

    protected Aficionado(String idUsuario, String clave, String nombre, String email, String rango) {
        super(idUsuario, clave, nombre, email);
        this.tier = rango;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

}
