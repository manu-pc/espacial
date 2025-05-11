package aplicacion;


public class HistorialAgencias {
    private String nombre;
    private int idAgencia;
    private java.time.LocalDate fechaInicio;  
    private java.time.LocalDate fechaFin;  

    public HistorialAgencias (int id, String nombre, java.time.LocalDate fechaInicio, java.time.LocalDate fechaFin){
    this.idAgencia = id;
    this.nombre=nombre;
    this.fechaInicio=fechaInicio;
    this.fechaFin=fechaFin;
   }

   public int getIdAgencia(){

       return this.idAgencia;
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
   
}