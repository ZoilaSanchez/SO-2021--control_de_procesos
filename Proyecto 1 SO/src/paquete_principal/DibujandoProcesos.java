/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_principal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author ferna
 */
public class DibujandoProcesos extends Thread{
     private int cont = 0;
    
     
     
     
        @Override
        public void run(){
            while(cont <= 100){
                System.out.println("prueba");
                cont++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                  System.out.println("Error en el hilo de dibujo");
                }
            }
        }
}
