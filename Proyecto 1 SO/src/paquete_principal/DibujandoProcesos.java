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
public class DibujandoProcesos{
    private int cont = 0;
    private JTable tabla;
    private String[] datos = new String[4];

    public DibujandoProcesos() {
        //new AlternateRowColorTableTest();
        creandoTabla();
    }
     
    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public void creandoTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Tam");
        modelo.addColumn("No.");
        modelo.addColumn("Documento");
        modelo.addColumn("Estado");
        tabla.setModel(modelo);
    }
    
    public void actualizar (Procesos procesoAux){
        String[] datos = new String[4];//4 datos posibles necesitamos
        datos[0] = "2";
        datos[1] = "3";
        datos[2] = "4";
        datos[3] = "5";
    }
    public class AlternateRowColorTableTest extends JFrame {
        public AlternateRowColorTableTest() {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Tam");
            modelo.addColumn("No.");
            modelo.addColumn("Documento");
            modelo.addColumn("Estado");
            setTitle("AlternateRowColorTable Test");
           JTable table = new JTable(new Object[][] {{"115", "Ramesh"}, {"120", "Adithya"}, {"125", "Jai"}, {"130", "Chaitanya"}, {"135", "Raja"}}, new String[] {"Employee Id", "Employee Name"}) {
              public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                 Component comp = super.prepareRenderer(renderer, row, column);
                 Color alternateColor = new Color(200, 201, 210);
                 Color whiteColor = Color.WHITE;
                 if(!comp.getBackground().equals(getSelectionBackground())) {
                     Color bg = alternateColor;
                     if(row < 2){
                      bg = whiteColor;
                     }
                     
                    //Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
                    comp.setBackground(bg);
                    bg = null;
                 }
                 return comp;
              }
           };
           
           
           
//            table.setModel(modelo);
//            String[] datos = new String[4];//4 datos posibles necesitamos
//            datos[0] = "2";
//            datos[1] = "3";
//            datos[2] = "4";
//            datos[3] = "5";
//            modelo.addRow(datos);
//            datos[0] = "2";
//            datos[1] = "3";
//            datos[2] = "4";
//            datos[3] = "5";
//            modelo.addRow(datos);
            
           add(new JScrollPane(table));
           setSize(400, 300);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setLocationRelativeTo(null);
           setVisible(true);
       }
    }
//        @Override
//        public void run(){     
//            while(cont <= 100){
//                System.out.println("prueba");
//                cont++;
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException ex) {
//                  System.out.println("Error en el hilo de dibujo");
//                }
//            }
//        }
}
