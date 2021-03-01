/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacircular;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author jenif
 */
public class ListaCircular2 {
 Calendar calendario = new GregorianCalendar();
    int segundos = calendario.get(Calendar.SECOND);

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ListaCircular listita = new ListaCircular();
       
         double random = ThreadLocalRandom.current().nextInt(5, 10 + 1);
       
         listita.insertar(0,200);
         listita.insertar(1,100);
         listita.insertar(2,300);
         listita.insertar(3,400);
        
         listita.mostrar();
           
         System.out.println("-------------");
         listita.mostrar();
         if(!listita.vacia()){
              listita.eliminar(0);
               listita.eliminar(1);
                listita.eliminar(2);
                 listita.eliminar(3);  
             System.out.println("esta llena");
         }else{
             System.out.println("vacia");
         }
         listita.mostrar();
    }
}
