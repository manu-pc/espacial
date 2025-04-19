package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public class Usuario {
    private String idUsuario;
    private String clave;
    private String nombre;
    private String direccion;
    private String email;
    private TipoUsuario tipo;
    private int prestamosVencidos;

   public Usuario (String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo, int prestamosVencidos){
    this.idUsuario=idUsuario;
    this.clave=clave;
    this.nombre=nombre;
    this.direccion=direccion;
    this.email=email;
    this.tipo=tipo;
    this.prestamosVencidos = prestamosVencidos;
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

   public String getDireccion(){

       return this.direccion;
   }

   public String getEmail(){

       return this.email;
   }

   public TipoUsuario getTipoUsuario(){

       return this.tipo;
   }

   public int getPrestamosVencidos(){
       return this.prestamosVencidos;
   }
}
