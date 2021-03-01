/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Random;
import java.util.Scanner;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Lopez
 */
public class principal extends javax.swing.JFrame implements Runnable  {
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    DefaultTableModel modelo;
    String []datos=new String [31];
    private int contadorNombre = 0;
    String [] procesos = new String[16]; //como solo hasta 16 procesos podemos tener
    Stack <Procesos>Procesos = new Stack();//aqui almaceno mis procesos
    boolean [] procesosTabla = {false,false, false, false, false, false, false,false, false, false, false, false, false, false, false, false};
    private JTable tabla;
    private int insertar = 0;//si es 1 es porque hay datos que agregar a la tabla o eliminar
    private int contadorDeListaProcesos=-1;//sirve para ver que proceso estamos viendo
    /**
     * Creates new form principal
     */
    public principal() {
        initComponents();
        mostrardatos();
         h1 = new Thread(this);
        h1.start();
    }
        public void mostrardatos(){
      /* tablita.getTableHeader().setFont(new Font("Arial", 1, 13));
        // cambia el fondo del encabezado de la tabla
        tablita.getTableHeader().setBackground(Color.WHITE);
        // cambia el color de la letra del encabezado de la tabla
        tablita.getTableHeader().setForeground(Color.BLACK);
        modelo= new DefaultTableModel();
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        modelo.addColumn("No.");
        modelo.addColumn("[ ]");
        modelo.addColumn("Lista");
        tablita.setModel(modelo);*/
        
//        String anuncio="dato",lista="si";
//        HiloTamanio tamanio=new HiloTamanio();
//        HiloTamanio algo = new HiloTamanio();
////        int bloque = (int) (Math.random() * 16) + 1;// La cantidad de bloques que se desea ocupar
////            System.out.println("El bloque "+bloque);
//        //tamanio.settamanioBloques(bloque);
//        int espaciolibre=tamanio.getEspaciolibre();// dice cuanto espacio libre tiene la memoria
//            System.out.println("la memoria tiene "+ espaciolibre+ " bloques libres");
//        tamanio.setBloqueAnterior(0);// Se envia el numero (1-16) de bloques ya ocupados
//        tamanio.setBloque(3);// se manda el tamaño de bloques que ocupa el nuevo documento 
//        tamanio.setTabla(tablita);
//        tamanio.activo=true;
//        tamanio.start();
//        
////        int espaciolibre2=tamanio.getEspaciolibre();// dice cuanto espacio libre tiene la memoria
////            System.out.println("la memoria tiene "+ espaciolibre2+ " bloques libres");
////        int guadalupe = 16 - espaciolibre2;
////        algo.setBloqueAnterior(guadalupe);// Se envia el numero (1-16) de bloques ya ocupados
////        algo.setBloque(3);// se manda el tamaño de bloques que ocupa el nuevo documento 
////        algo.setTabla(tablita);
////        algo.activo=true;
////        algo.start();
//        
//        
//        boolean ver=tamanio.isLlena();// retorna un booleano , si es true la memoria ya esta llena si es false aún hay espacio
//        System.out.println("La memoria "+ ver + " llena");

//        DibujandoProcesos hilo = new DibujandoProcesos();//este hilo comprueba si se debe agregar o eliminar procesos
//        hilo.start();
          verificarProcesos hilo = new verificarProcesos();
          hilo.start();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablita = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bloques = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DirH = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblReloj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablita = new javax.swing.JTable(){
            public boolean isCellEditable(int ro,int col ){
                return false;
            }
        };
        tablita.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tamaño", "No.", "Documento", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Byte.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablita.setFocusable(false);
        tablita.setGridColor(new java.awt.Color(255, 255, 255));
        tablita.getTableHeader().setResizingAllowed(false);
        tablita.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablita);

        jLabel1.setText("Bloques a ocupar del proceso");

        agregar.setText("agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jLabel2.setText("Agregar proceso");

        jLabel3.setText("Direccion de Memoria:");

        DirH.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DirH.setText("0");

        jLabel4.setText("Direccion de memoria ejecutandose: ");

        jLabel5.setText("D");

        lblReloj.setText("HORA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(DirH)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)))))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bloques, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblReloj)
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DirH)
                    .addComponent(agregar))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bloques, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblReloj)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        Random rand = new Random();
        int randInt = rand.nextInt(63); //Genera numeros de 0 a 65535 que es nuestro espacio disponible
        bloques.setText("");
        Procesos procesoAux = new Procesos("aux", 0, 0,0,0);//ignorarlo solo lo uso para usar una funcion
        int guiaParaAsignarEspacios = procesoAux.saberBloquesAUtilizar(randInt);//me indica cuantos bloques de memoria debo buscar
        boolean asignar = true;
        int contador = 0;
        int PosA = 0;
        int PosB = 0;
    
        for(int i = 0; i<16; i++){
            
            if(contador != guiaParaAsignarEspacios){
                System.out.println("contador es " + contador);
                if(procesosTabla[i] == false){//hay espacio libre para asignar
                    if(contador == 0){//sera la posicion inicial del documento
                       PosA = i;
                       System.out.println("La posicion inicial es " + PosA);
                    }
                    if(contador == guiaParaAsignarEspacios-1){
                        PosB = i;
                       //Direccion en decimales 2^n-1
                       double Dir = (int) Math.pow(2,PosB);
                       int Total = (int) (Dir-1);
                       DirH.setText(String.valueOf(Total));
                        System.out.println("La posicion final es " + PosB);
                        
                    }
                    procesosTabla[i] = true;//esto significa que esos espacios de la memoria estan llenos
                    contador++;
                    
                }else{//encontro espacios asignados
                    contador = 0;
                }
                System.out.println("Voy en i "+i+"  "+procesosTabla[i]);
            }    
        }
        if(PosB != 0){//significa que encontro posiciones libres
             Procesos process = new Procesos("P"+this.contadorNombre, randInt,PosA,PosB,10);
            this.contadorNombre++;
            System.out.println("tam "+ randInt+ " nombre " + process.getNombre());
//            double Ejecutandose = (int) Math.pow(2,randInt);
//            int Resul = (int) (Ejecutandose-1);
            jLabel5.setText(String.valueOf(randInt));
            bloques.setText(String.valueOf(process.getBloques()));
            Procesos.add(process);//voy añadiendo los procesos conforme le van dando click
    //        System.out.println(Procesos.get(Procesos.size()-1).getNombre());//guia para ver el ultimo proceso insertado
            insertar++;
            contadorDeListaProcesos++;//aqui podriamos cambiar y mandarle otro numero
        }else{
            JOptionPane.showMessageDialog(null, "Memoria llena, el proceso ocupaba " + guiaParaAsignarEspacios);
        }

    }//GEN-LAST:event_agregarActionPerformed

    @Override
    public void run() {
          Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lblReloj.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {
                Thread.sleep(1000);

            } catch (InterruptedException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;

        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }

    
    
 
    
    public class verificarProcesos extends Thread{//sirve para ver si se dibuja o no 
        DefaultTableModel tables = new DefaultTableModel();
        
        public verificarProcesos(){
            tables.addColumn("Tam");
            tables.addColumn("No.");
            tables.addColumn("Documento");
            tables.addColumn("Estado");
        }
        @Override
        public void run(){//aqui dibujaremos
            while(true){
                System.out.println("toca insertar?" + insertar);
                System.out.println(Procesos.size());   
                 
                if(insertar == 1){//hay procesos que meter en nuestro sistema
                    if(Procesos.get(contadorDeListaProcesos).getBloques()!= 0){
                        System.out.println("Dibujar");
                        //System.out.println(Procesos.get(0).getBloques());
                        String[] datos = new String[4];//4 datos posibles necesitamos
                        datos[0] = " ";
                        datos[1] = " ";
                        datos[2] = " ";
                        datos[3] = " ";
                        tables.addRow(datos);
                        Procesos.get(contadorDeListaProcesos).setBloques(Procesos.get(contadorDeListaProcesos).getBloques() - 1);
                    }else{
                        insertar = 0;//dejo de insertar
                    }
                    tablita.setModel(tables);

                    
                }
                try {
                    Thread.sleep(1000);//revisaremos a cada cierto tiempo
                } catch (InterruptedException ex) {
                  System.out.println("Error en el hilo de dibujo");
                }
            }
        }

       
    }
    //pasar la direccion a Hexadecimal
    public String DireccionHexadecimal(int decimal) {
        Scanner teclado = new Scanner(System.in);
        teclado.close();
        char digitosH[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String hexadecimal2 = "";
        int resto, aux = decimal;
        while (aux > 0) {
            resto = aux % 16;
            hexadecimal2 = digitosH[resto] + hexadecimal2;
            aux /= 16;
        }
        return hexadecimal2 + "h";
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DirH;
    private javax.swing.JButton agregar;
    private javax.swing.JLabel bloques;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblReloj;
    private javax.swing.JTable tablita;
    // End of variables declaration//GEN-END:variables
}
