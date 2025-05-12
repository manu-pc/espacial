/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class Mision {
    
    private Integer codigo;
    private String nombre;
    private java.time.LocalDate fechaInicio;
    private java.time.LocalDate fechaFin;
    private String descripcion;  
    private Integer nave;
    private String objetivo;

    
    public Mision(Integer codigo, String nombre, java.time.LocalDate fechaInicio, java.time.LocalDate fechaFin, String descripcion, Integer nave, String objetivo){
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.nave = nave;
        this.objetivo = objetivo;
    }

    public Integer getCodigo(){
        return this.codigo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public java.time.LocalDate getFechaInicio(){
        return this.fechaInicio;
    }

    public java.time.LocalDate getFechaFin(){
        return this.fechaFin;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    public Integer getNave(){
        return this.nave;
    }
    
    public String getObjetivo(){
        return this.objetivo;
    }
}
