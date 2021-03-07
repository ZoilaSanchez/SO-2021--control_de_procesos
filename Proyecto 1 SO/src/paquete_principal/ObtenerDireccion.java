/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_principal;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import listacircular.list;

/**
 *
 * @author lucil
 */

//pasar la direccion a hexadecimal
public class ObtenerDireccion {
    
    list listaD = new list();
    
     public class Direccion extends Thread {
        int contador = 0;
        
        @Override
        public void run(){
            while(contador<16){
                listaD.existe(contador);
                contador+=contador;
//                Dir.setText(String.valueOf(contador));
                System.out.println("Conador: "+contador);
                try {
                   Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ObtenerDireccion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
     
    public void iniciarDir() {
        Direccion mostrar = new Direccion();
        mostrar.start();
    }
    
}
