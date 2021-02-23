/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_principal;
import java.lang.Math;
/**
 *
 * @author ferna
 */
public class Procesos {
    private String nombre;//nombre P1, P2 y Pn
    private int tam;//tamaño del proceso en bits todavia falta pasarlo a hexa
    private int bloques;

    public Procesos(String nombre, int tam) {
        this.nombre = nombre;
        this.tam = tam;
        this.bloques = this.saberBloquesAUtilizar(tam);
    }

    
    public int getBloques() {
        return bloques;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTam() {
        return tam;
    }

    public void setBloques(int bloques) {
        this.bloques = bloques;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
    
    public int saberBloquesAUtilizar(int tam){//esto para saber cuantos bloques usar
        //ya que empezamos en 1h, 3h, 7h, Fh y así es 2 a la n
        int contadorDe2 = 0;
        int numeroGuia;
    do{
            numeroGuia = (int) Math.pow(2,contadorDe2);
//            System.out.println("El numero Guia es " + numeroGuia);
            if(numeroGuia <= tam){
                contadorDe2++;
            }
        }while(numeroGuia < tam);   
        return contadorDe2;
    }
    
}
