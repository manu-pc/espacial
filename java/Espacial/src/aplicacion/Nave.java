/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Nave {
    private Integer idNave;
    private String nombre;
    private String tipo;
    private Float tamanho;
    private Float masa;
    
    public Nave(Integer idNave, String nombre, String tipo, Float tamanho, Float masa) {
        this.idNave = idNave;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.masa = masa;
    }
    
    public Integer getIDNave() {
        return this.idNave;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Float getTamanho() {
        return this.tamanho;
    }
    
    public void setTamanho(Float tamanho) {
        this.tamanho = tamanho;
    }
    
    public Float getMasa() {
        return this.masa;
    }
    
    public void setMasa(Float masa) {
        this.masa = masa;
    }
}
