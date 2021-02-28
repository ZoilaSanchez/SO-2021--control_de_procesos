/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_principal;

public class ListaCircular {
    
    private Nodo inicio;
    // Puntero que indica el final de la lista o el ultimo nodo.
    private Nodo ultimo;
    // Variable para registrar el tamaño de la lista.
    private int tamanio2;

    public void Lista() {
        inicio = null;
        ultimo = null;
        tamanio2 = 0;
    }

    public boolean Vacia() {
        return inicio == null;
    }

    public int getTamanio() {
        return tamanio2;
    }

    public void Inserta_al_Final(double dato, String nombre, int tamanio, double tiempo_llegada, double duracion) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);
        nuevo.setNombre(nombre);
        nuevo.setTamanio(tamanio);
        nuevo.setTiempo_llegada(tiempo_llegada);
        nuevo.setDuracion(duracion);
        if (Vacia()) {
            inicio = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(inicio);
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(inicio);
            ultimo = nuevo;

        }
        tamanio2 = tamanio2 + 1;
    }

    public void Insertar_al_Inicio(double dato, String nombre, int tamanio, double tiempo_llegada, double duracion) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);
        nuevo.setNombre(nombre);
        nuevo.setTamanio(tamanio);
        nuevo.setTiempo_llegada(tiempo_llegada);
        nuevo.setDuracion(duracion);

        if (Vacia()) {
            inicio = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(inicio);
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            ultimo.setSiguiente(inicio);
        }
        tamanio2 = tamanio2 + 1;
    }

    public void insertarPorReferencia(int referencia, double dato, String nombre, int tamanio, double tiempo_llegada, double duracion) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);
        nuevo.setNombre(nombre);
        nuevo.setTamanio(tamanio);
        nuevo.setTiempo_llegada(tiempo_llegada);
        nuevo.setDuracion(duracion);
        if (!Vacia()) {
            if (buscar(referencia)) {
                Nodo aux = inicio;
                while (aux.getDato() != referencia) {
                    aux = aux.getSiguiente();
                }
                if (aux == ultimo) {
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(inicio);
                    ultimo = nuevo;
                } else {
                    Nodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(siguiente);
                }
                tamanio2 = tamanio2 + 1;
            }
        }
    }

    public void insrtarPorPosicion(int posicion, double dato, String nombre, int tamanio, double tiempo_llegada, double duracion) {
        if (posicion >= 0 && posicion <= tamanio2) {
            Nodo nuevo = new Nodo();
            nuevo.setDato(dato);
            nuevo.setNombre(nombre);
            nuevo.setTamanio(tamanio);
            nuevo.setTiempo_llegada(tiempo_llegada);
            nuevo.setDuracion(duracion);
            if(posicion==0){
                nuevo.setSiguiente(inicio);
                inicio=nuevo;
                ultimo.setSiguiente(inicio);
            }else{
                if(posicion == tamanio){
                    ultimo.setSiguiente(nuevo);
                    nuevo.setSiguiente(inicio);
                    ultimo = nuevo; 
                }else{
                    Nodo aux = inicio;
                     for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getSiguiente();
                    }
                     Nodo siguiente = aux.getSiguiente();
                     aux.setSiguiente(nuevo);
                     nuevo.setSiguiente(siguiente);
                     
                     
                }
            }
            tamanio2=tamanio2+1;
        }
    }
    
    public double getDato(int posicion) throws Exception{
        if(posicion>=0 && posicion<tamanio2){
            if (posicion == 0) {
                return inicio.getDato();
            }else{
                Nodo aux=inicio;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                return aux.getDato();
            }
        }else{
            throw new Exception("Posicion inexistente en la lista."); 
        }
    }
    
    public boolean buscar(int referencia){
        Nodo aux = inicio;
        boolean encontrado = false;
        do{
            if(referencia == aux.getDato()){
                encontrado= true;
            }else{
                aux = aux.getSiguiente();
            }
        }while(aux != inicio && encontrado != true);
        return encontrado;
    }
    public void Ver(){
        if (!Vacia()) {
            Nodo aux = inicio;
            int i = 0;
            System.out.print("-> ");
            do{
                System.out.print(i + ".[ " + aux.getDato()+" "+aux.getNombre()+ " "+aux.getTamanio()+ " "+aux.getTiempo_llegada() +" "+ aux.getDuracion()+" ]" + " ->  ");
                aux= aux.getSiguiente();
                i++;
            }while(aux !=inicio);
        }
    }
    
}
