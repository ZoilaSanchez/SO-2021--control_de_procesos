/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_principal;

import java.awt.Color;
import java.awt.Font;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Toshiba
 */
public class HiloTamanio extends Thread {

    JTable tabla;
    DefaultTableModel modelo;
    String[] datos = new String[4];
    Color[] Colores = new Color[]{Color.red, Color.green, Color.blue};
    boolean Llena=false;
    int creado = 0;
    int tamañobloque = 0;
    int bloqueAnterior = 0, bloqueActual;
    int linea = 0, columna = 0;
    int espaciolibre=16;

    public int getEspaciolibre() {
        return espaciolibre;
    }

    public void setEspaciolibre(int espaciolibre) { 
        this.espaciolibre = espaciolibre;
    }
    
    public boolean isLlena() {
        return Llena;
    }

    public void setLlena(boolean Llena) {
        this.Llena = Llena;
    }


    public boolean Memoria_llena() {
        int lleno=tabla.getRowCount();
        System.out.println("Filas "+lleno);
        if (lleno >= 16) {
            JOptionPane.showMessageDialog(null, "Memoria llena");
            return true;
            //cuando aparezca este mensaje ya no se pueden meter más documentos
        } else {
            espaciolibre= 16-lleno;
            return false;
        }
    }

    public int getBloqueAnterior() {
        return bloqueAnterior;
    }

    public void setBloqueAnterior(int bloqueAnterior) {
        this.bloqueAnterior = bloqueAnterior;
    }

    boolean activo = true;
    Random tiem = new Random();
    public int bloque;
    //public int bloque = (int) (Math.random() * 16) + 1;
    int tiempo = 0;
    int c = 0;

    public int gettamanioBloques() {

        return tamañobloque;
    }

    public void settamanioBloques(int cantbloque) {
        /* if (cantbloque == 0) {
            JOptionPane.showMessageDialog(null, "No tiene tamaño");
        } else*/ if (cantbloque > 16) {
            JOptionPane.showMessageDialog(null, "Supera nuestra capacidad para almacenar");
        } else {
            this.tamañobloque = (int) Math.pow(2, cantbloque) - 1;
            System.out.println("Capacidad" + tamañobloque);
        }
    }

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    public String Hexadecimales(int decimal) {
        Scanner teclado = new Scanner(System.in);
        teclado.close();
        char digitosH[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String hexadecimal2 = "";
        int resto, aux = decimal;

        //for (int i = decimal - 1; i >= 0; i--) {
        while (aux > 0) {
            resto = aux % 16;
            hexadecimal2 = digitosH[resto] + hexadecimal2;
            aux /= 16;
        }
        System.out.printf("%n%nMétodo 2 -> Decimal: %d, Hexadecimal: %sh", decimal, hexadecimal2, "h");
        return hexadecimal2 + "h";
        /* System.out.printf("%n%nMétodo 2 -> Decimal: %d, Hexadecimal: %s", i + 1, hexadecimal2);
            hexadecimal2 = "";
            aux = i;
        }*/
    }

    @Override
    public void run() {
        tabla.getTableHeader().setFont(new Font("Arial", 1, 13));
        // cambia el fondo del encabezado de la tabla
        tabla.getTableHeader().setBackground(Color.WHITE);
        // cambia el color de la letra del encabezado de la tabla
        tabla.getTableHeader().setForeground(Color.BLACK);
        modelo = new DefaultTableModel();
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        modelo.addColumn("No.");
        modelo.addColumn("Documento");
        modelo.addColumn("Estado");
        tabla.setModel(modelo);

        while (activo == true) {
            //modelo = new DefaultTableModel();
            //tabla.setModel(modelo);
            System.out.println("BLOQUE" + bloque);
            System.out.println("creado " + creado);
            System.out.println("bloque anterior  "+bloqueAnterior);
            int col = (int) (Math.random() * 2) + 1;
            int ultimotamaño = tamañobloque;//el tamaño que quieren guardar
            tiempo = tiem.nextInt(100);
            c = 1;
            if (creado == 0 || creado == bloque - 1) {
                if (c == 1) {
                    //System.out.println("uno");
                    String tamaño;
                    if (creado == 0) {
                        if (bloqueAnterior/*Ve  las filas totales ocupadas*/ > 0) {
                            settamanioBloques(1 + bloqueAnterior);// bloque disponible
                            tamaño = Hexadecimales(tamañobloque);
                            System.out.println("tamaño" + tamañobloque);
                        } else {
                            settamanioBloques(0);
                            tamaño = Hexadecimales(tamañobloque);
                            System.out.println("tamaño" + tamañobloque);
                        }
                        datos[0] = tamaño;
                        c = 2;
                    } else {
                        if (bloqueAnterior > 0) {
                            settamanioBloques(bloque + bloqueAnterior);
                            tamaño = Hexadecimales(tamañobloque);
                        } else {
                            settamanioBloques(bloque);
                            tamaño = Hexadecimales(tamañobloque);
                        }
                        datos[0] = tamaño;
                        c = 2;
                    }

                }
            } else {
                datos[0] = "";
                c = 2;
            }
            if (c == 2) {
               // System.out.println("uno");
                datos[1] = "";
                c = 3;
            }
            if (c == 3) {
                //System.out.println("dos");
                datos[2] = "sjflasjdlf";
                //Debe esperar hasta que el proceso anterior haya finalizado
                c = 4;
            }
            if (c == 4) {
                datos[3] = "tres";
                modelo.addRow(datos);
                int numlinea = modelo.getRowCount();

                tabla.setBackground(Colores[col]);

                try {
                    creado++;
                    sleep(1000);
                    if (bloque == creado) {
                        Llena=Memoria_llena();
                        activo = false;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            /* if (bloque == 4) {
                datos[2]="paso4";
                modelo.insertRow(linea, datos);
                System.out.println("cuatro");
                try {
                    sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                }
                //activo=false;//sin esto esta infinito el hilo
                //c = 3;
            }*/
        }
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
}
