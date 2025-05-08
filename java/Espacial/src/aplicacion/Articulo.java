/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import java.time.LocalDate;

/**
 *
 * @author alumnogreibd
 */
public class Articulo {
    
    private Integer id;
    private LocalDate fechaPublicacion;
    private String autor;
    private String cuerpoCeleste;
    private String descripcion;
    private Integer numPaginas;
    
        // Constructor
    public Articulo (Integer id, LocalDate fechaPublicacion, String autor, String cuerpoCeleste, String descripcion, Integer numPaginas){
        
        this.id = id;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.cuerpoCeleste = cuerpoCeleste;
        this.descripcion = descripcion;
        this.numPaginas = numPaginas;
    }
    
    public Articulo (LocalDate fechaPublicacion, String autor, String cuerpoCeleste, String descripcion, Integer numPaginas){
        
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.cuerpoCeleste = cuerpoCeleste;
        this.descripcion = descripcion;
        this.numPaginas = numPaginas;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCuerpoCeleste() {
        return cuerpoCeleste;
    }

    public void setCuerpoCeleste(String cuerpoCeleste) {
        this.cuerpoCeleste = cuerpoCeleste;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }
}
