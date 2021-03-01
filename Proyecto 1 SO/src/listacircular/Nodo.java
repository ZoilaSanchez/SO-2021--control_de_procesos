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
      Nodo sig;
    int posicion;
    int dato;
    String nombre;
    int tamanio;
    double tiempo_llegada;
    double duracion;
   
    
    public Nodo(int posi,int dato, String nombre,int tamanio, double tiempo_llegada,double duracion){
       this.dato=dato;
       this.nombre=nombre;
       this.tamanio=tamanio;
       this.tiempo_llegada=tiempo_llegada;
       this.duracion=duracion;
       this.posicion=posi;
       sig=this; // siempre apunta a el mismo 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public double getTiempo_llegada() {
        return tiempo_llegada;
    }

    public void setTiempo_llegada(double tiempo_llegada) {
        this.tiempo_llegada = tiempo_llegada;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
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
