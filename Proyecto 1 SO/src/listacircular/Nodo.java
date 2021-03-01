/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacircular;

/**
 *
 * @author jenif
 */
public class Nodo {
    int dato;
    Nodo sig;
    int posicion;
    
    public Nodo(int posi,int dato){
       this.dato=dato;
       this.posicion=posi;
       sig=this; // siempre apunta a el mismo 
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    
    
    
    
       

    
     
     
     
}
