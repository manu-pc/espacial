package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public enum TipoUsuario {
    Administrador,
    Normal;
    @Override
    public String toString() {
        return name(); 
    }
}
