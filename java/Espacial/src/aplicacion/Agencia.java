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
   
    @Override
    public String toString() {
        return nombre + ", " + idAgencia;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agencia agencia = (Agencia) o;

        return this.idAgencia == agencia.idAgencia; // compara por ID
      
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(idAgencia);
}
}
