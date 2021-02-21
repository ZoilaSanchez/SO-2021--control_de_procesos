/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_principal;

import java.util.Scanner;

/**
 *
 * @author Toshiba
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic he
        /*- Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un número decimal: ");
        int decimal = teclado.nextInt();
        teclado.close();

        // 2º método con array
        char digitosH[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String hexadecimal2 = "";
        int resto, aux = decimal;

        //for (int i = decimal - 1; i >= 0; i--) {
        while (aux > 0) {
            resto = aux % 16;
            hexadecimal2 = digitosH[resto] + hexadecimal2;
            aux /= 16;
        }
        System.out.printf("%n%nMétodo 2 -> Decimal: %d, Hexadecimal: %sh", decimal, hexadecimal2,"h");-*/

 /* System.out.printf("%n%nMétodo 2 -> Decimal: %d, Hexadecimal: %s", i + 1, hexadecimal2);
            hexadecimal2 = "";
            aux = i;
        }*/
  //   int numero = (int) (Math.random() * 16) + 1;
    //    System.out.println("número"+ numero);

        Hilo x = new Hilo();
        Hilo y = new Hilo();
        if (x.isAlive() == false && y.isAlive()==false) {
            x.setNombre("documento");
            x.setAccion("esperando");
            x.setFin("imprimiendo");
            y.setNombre("video");
            y.setAccion("esperando");
            y.setFin("reproducir");
            x.activo = true;
            y.activo=true;
            x.start();
            y.start();
        }
    }
}
