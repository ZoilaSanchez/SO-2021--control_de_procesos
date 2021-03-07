/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_principal;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Toshiba
 */
public class Hilo extends Thread {
    public String nombre="",accion="",fin="", tamanio="",posicion="";
    boolean activo = true;
    Random tiem = new Random();
    int tiempo = 0;
    int c = 0;

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    @Override
    public void run() {
        while (activo == true) {
            tiempo = tiem.nextInt(100);
            c = 1;
            if (c == 1) {
                System.out.println(nombre);
                c = 2;
            }
            if (c == 2) {
                System.out.println(accion);
                //Debe esperar hasta que el proceso anterior haya finalizado

                c = 3;
            }
            if (c == 3) {
                System.out.println(fin);
                try {
                    sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
                //activo=false;//sin esto esta infinito el hilo
                //c = 3;
            }
        }
    }

}
