/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Galaxia {
    private String nombreGalaxia;
    private TipoGalaxia tipo;
    private String ubicacionGalaxia;
    private String descGalaxia;

    public Galaxia(String nombreGalaxia, TipoGalaxia tipoGalaxia, String ubicacionGalaxia, String descGalaxia) {
        this.nombreGalaxia = nombreGalaxia;
        this.tipo = tipoGalaxia;
        this.ubicacionGalaxia = ubicacionGalaxia;
        this.descGalaxia = descGalaxia;
    }

    public String getNombreGalaxia() {
        return nombreGalaxia;
    }

    public TipoGalaxia getTipoGalaxia() {
        return tipo;
    }

    public String getUbicacionGalaxia() {
        return ubicacionGalaxia;
    }

    public String getDescGalaxia() {
        return descGalaxia;
    }
    
}
