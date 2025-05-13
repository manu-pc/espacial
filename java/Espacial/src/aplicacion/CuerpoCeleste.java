/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class CuerpoCeleste {
    private String nombreCuerpoCeleste;
    private TipoCuerpoCeleste tipo;
    private String ubicacion;
    private Boolean habitabilidad;
    private float masa;
    private float tamanho;
    private float temperaturaSuperficie;
    private String descripcion;
    private String galaxia;
    private String orbitaA = null; //hace referencia al nombre de otro CUerpoCeleste

   public CuerpoCeleste (String nombreCuerpoCeleste, TipoCuerpoCeleste tipo, String ubicacion, Boolean habitabilidad, float masa, float tamanho, float temperaturaSuperficie, String descripcion, String galaxia){
    this.nombreCuerpoCeleste=nombreCuerpoCeleste;
    this.tipo=tipo;
    this.ubicacion=ubicacion;
    this.habitabilidad=habitabilidad;
    this.masa=masa;
    this.tamanho=tamanho;
    this.temperaturaSuperficie=temperaturaSuperficie;
    this.descripcion=descripcion;
    this.galaxia=galaxia;
   }
   
   public CuerpoCeleste (String nombreCuerpoCeleste, TipoCuerpoCeleste tipo, String ubicacion, Boolean habitabilidad, float masa, float tamanho, float temperaturaSuperficie, String descripcion, String galaxia, String orbitaA){
    this.nombreCuerpoCeleste=nombreCuerpoCeleste;
    this.tipo=tipo;
    this.ubicacion=ubicacion;
    this.habitabilidad=habitabilidad;
    this.masa=masa;
    this.tamanho=tamanho;
    this.temperaturaSuperficie=temperaturaSuperficie;
    this.descripcion=descripcion;
    this.galaxia=galaxia;
    this.orbitaA = orbitaA;
    System.out.println(this.orbitaA);
   }
   
public String getNombreCuerpoCeleste() {
        return nombreCuerpoCeleste;
    }

    public TipoCuerpoCeleste getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Boolean getHabitabilidad() {
        return habitabilidad;
    }

    public float getMasa() {
        return masa;
    }

    public float getTamanho() {
        return tamanho;
    }

    public float getTemperaturaSuperficie() {
        return temperaturaSuperficie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getGalaxia() {
        return galaxia;
    }
    
    @Override
    public String toString(){
        return nombreCuerpoCeleste;
    }
    
    public String getOrbitaA(){
        return orbitaA;
    }
    
    public void setOrbitaA(String cuerpo){
        this.orbitaA = cuerpo;
    }
    

}
