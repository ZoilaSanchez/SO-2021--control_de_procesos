/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacircular;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lopez
 */
public class list {

    ArrayList<Nodo> lista;
    int tamaño_lista;

    public list() {
        tamaño_lista = 0;
        lista = new ArrayList<Nodo>();
    }

    public void insertar(String nombre, int tamanio, double tiempo_llegada, double duracion) {
//        int posi,String nombre,int tamanio, double tiempo_llegada,double duracion
        lista.add(new Nodo(tamaño_lista, nombre, tamanio, tiempo_llegada, duracion));
        tamaño_lista++;
    }

    public void mostra() {
        Iterator<Nodo> itrPartidos = lista.iterator();
        while (itrPartidos.hasNext()) {
            Nodo partido = itrPartidos.next();
            System.out.println(partido.getNombre() + " - "
                    + partido.getDuracion() + ""
            );
        }
    }

    public void eliminar(int pos) {
        Iterator<Nodo> itrnodo = lista.iterator();
        while (itrnodo.hasNext()) {
            Nodo listado = itrnodo.next();
            if (listado.getPosi() == pos) {
                System.out.println("encontrado " + listado.getPosi());
                lista.remove(pos);
            }
        }
    }

    public Nodo existe(int pos) {
        Nodo x = null;
        Iterator<Nodo> itrnodo = lista.iterator();
        while (itrnodo.hasNext()) {
            Nodo listado = itrnodo.next();
            if (listado.getPosi() == pos) {
                System.out.println("encontrado " + listado.getPosi());
                x = listado;
            }
        }
        return x;
    }

    public void algoritmo() {
        int cont = 0;
        Iterator<Nodo> itrNodo = lista.iterator();
        System.out.println(tamaño_lista);
        while (itrNodo.hasNext()) {
            Nodo listado = itrNodo.next();
            if (listado.getDuracion() <= 10) {
                System.out.println("proce eliminado : " + listado.getNombre() + " cantidad " + listado.getDuracion());
                itrNodo.remove();
                tamaño_lista--;
            } else if (listado.getDuracion() > 10) {
                System.out.println("proce desconetar : " + listado.getNombre() + " cantidad " + listado.getDuracion());
                double duracio = (listado.getDuracion() - 10);
                listado.setDuracion(duracio);
                System.out.println("proce desconetar : " + listado.getNombre() + " cantidad " + listado.getDuracion());
            }

        }

    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    String estado = "Ejecutando";

    public class hilo extends Thread {

        @Override
        public void run() {
            while (tamaño_lista > 0) {
                int cont = 0;
                Iterator<Nodo> itrNodo = lista.iterator();
                while (itrNodo.hasNext()) {
                    Nodo listado = itrNodo.next();
                    if (listado.getDuracion() <= 10) {
                        System.out.println("proce eliminado : " + listado.getNombre() + " cantidad " + listado.getDuracion());

                        for (int i = (int) listado.getDuracion(); i > 0; i--) {
                            System.out.println("Ejecutando......" + i);
                        }
                        try {
                            Thread.sleep(10000);
                            itrNodo.remove();
                            tamaño_lista--;
                            System.out.println("Terminado......");
                        } catch (InterruptedException ex) {
                            Logger.getLogger(list.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (listado.getDuracion() > 10) {
                        System.out.println("proce desconetar : " + listado.getNombre() + " cantidad " + listado.getDuracion());
                        System.out.println("Ejecutando......");
                        for (int i = (int) 10; i > 0; i--) {
                            System.out.println("Ejecutandos......" + i);
                        }
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(list.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        double duracio = (listado.getDuracion() - 10);
                        estado = "Listo";
                        System.out.println("Listo......");
                        listado.setDuracion(duracio);
                        System.out.println("proce desconetar : " + listado.getNombre() + " cantidad " + listado.getDuracion());
                    }
                }
            }
        }
    }

    public void iniciar() {
        hilo mostrar = new hilo();
        mostrar.start();
    }

}
