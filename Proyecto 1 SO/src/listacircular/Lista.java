/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacircular;

import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author Lopez
 */
public class Lista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        list lista = new list();

       
        lista.insertar("P0", 10,10,15);
         lista.insertar("P1", 10,10,2);
          lista.insertar("P2", 10,10,11);

         lista.iniciar();
       
         lista.mostra();
       
        
    }
    
}
