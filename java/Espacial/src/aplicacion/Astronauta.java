package aplicacion;


public class Astronauta {
    private String nombre;
    private int idAstronauta;
    private java.time.LocalDate fecha;  
    private String nacionalidad;

    public Astronauta (int idAstronauta, java.time.LocalDate fecha, String nombre, String nacionalidad){
    this.idAstronauta=idAstronauta;
    this.fecha=fecha;
    this.nombre=nombre;
    this.nacionalidad=nacionalidad;
   }

   public int getIdAstronauta(){

       return this.idAstronauta;
   }

   public String getNombre(){

       return this.nombre;
   }

   public String getNacionalidad(){

       return this.nacionalidad;
   }


   public java.time.LocalDate getFecha(){

       return this.fecha;
   }
   
   @Override
   public String toString() {
       return this.nombre;
   }


}
