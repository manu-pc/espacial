package aplicacion;


public class Agencia {
    private String nombre;
    private int idAgencia;
    private String localizacion;

    public Agencia (int id, String nombre, String localizacion){
    this.idAgencia = id;
    this.localizacion=localizacion;
    this.nombre=nombre;
   }

   public int getIdAgencia(){

       return this.idAgencia;
   }

   public String getNombre(){

       return this.nombre;
   }

   public String getLocalizacion(){

       return this.localizacion;
   }

}
