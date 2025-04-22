package aplicacion;


public abstract class Usuario {
    private String idUsuario;
    private String clave;
    private String nombre;
    private String email;

    protected Usuario (String idUsuario, String clave, String nombre, String email){
    this.idUsuario=idUsuario;
    this.clave=clave;
    this.nombre=nombre;
    this.email=email;
   }

   public String getIdUsuario(){

       return this.idUsuario;
   }

   public String getClave(){

       return this.clave;
   }

   public String getNombre(){

       return this.nombre;
   }


   public String getEmail(){

       return this.email;
   }


}
