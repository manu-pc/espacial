/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import aplicacion.Libro;

/**
 *
 * @author basesdatos
 */
public class Ejemplar {

    private Integer numEjemplar;
    private String localizador;
    private String anoCompra;
    private Libro libro;
    private String usuario_id;   
    private java.time.LocalDate fechaPrestamo;
    
    
    public Ejemplar(Libro libro, Integer numEjemplar, String localizador, String anoCompra){
        this.numEjemplar=numEjemplar;
        this.anoCompra=anoCompra;
        this.localizador=localizador;
        this.libro=libro;
    }

    
    public Ejemplar(Libro libro, Integer numEjemplar, String localizador, String anoCompra, String usuario_id, java.time.LocalDate fechaPrestamo){
        this.numEjemplar=numEjemplar;
        this.anoCompra=anoCompra;
        this.localizador=localizador;
        this.libro=libro;
        this.usuario_id = usuario_id;
        this.fechaPrestamo=fechaPrestamo;
    }

    public Integer getNumEjemplar(){
        return this.numEjemplar;
    }

    public String getAnoCompra(){
        return this.anoCompra;
    }

    public String getLocalizador(){
        return this.localizador;
    }

    public Libro getLibro(){
        return this.libro;
    }

    public void setLocalizador(String l){
        localizador =l;
    }
    
    public void setAnoCompra(String a){
        anoCompra = a;
    }
    
    public String getUsuarioId(){
        return usuario_id;
    }
    
    public void setUsuarioId(String u){
        this.usuario_id=u;
    }
    
    public java.time.LocalDate getFechaPrestamo(){
        return fechaPrestamo;
    }
    
    public java.time.LocalDate getFechaVencimiento(){
        if (fechaPrestamo == null) return null;
        return fechaPrestamo.plusDays(30);
    }
    
}
