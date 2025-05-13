/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import aplicacion.Astronauta;

/**
 *
 * @author basesdatos
 */
public class ModeloListaAstronautas extends javax.swing.AbstractListModel {
    java.util.List<Astronauta> elementos;

    public ModeloListaAstronautas(){
        this.elementos=new java.util.ArrayList<>();
    }

    public int getSize(){
        return this.elementos.size();
    }

    public Astronauta getElementAt(int i){
        return elementos.get(i);
    }

    public void nuevoElemento(Astronauta e){
        this.elementos.add(e);
        fireIntervalAdded(this, this.elementos.size()-1, this.elementos.size()-1);
    }

    public void borrarElemento(int i){
        String e;
        e=this.elementos.get(i).toString();
        this.elementos.remove(i);
        fireIntervalRemoved(this,i,i);
    }

    public void setElementos(java.util.List<Astronauta> elementos){
        this.elementos=elementos;
        fireContentsChanged(this, 0, elementos.size()-1);
    }

    public java.util.List<Astronauta> getElementos(){
        return this.elementos;
    }
}
