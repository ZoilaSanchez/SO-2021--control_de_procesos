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
      double duracion,tiempo_llegada;
      int posi,tamanio;
      String nombre;

    public Nodo(int posi,String nombre,int tamanio, double tiempo_llegada,double duracion){
     
       this.nombre=nombre;
       this.tamanio=tamanio;
       this.tiempo_llegada=tiempo_llegada;
       this.duracion=duracion;
       this.posi=posi;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public double getTiempo_llegada() {
        return tiempo_llegada;
    }

    public void setTiempo_llegada(double tiempo_llegada) {
        this.tiempo_llegada = tiempo_llegada;
    }

    public int getPosi() {
        return posi;
    }

    public void setPosi(int posi) {
        this.posi = posi;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

        
    
    
     
}
