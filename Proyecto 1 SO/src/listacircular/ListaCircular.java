/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacircular;

/**
 *
 * @author jenif
 */

public class ListaCircular {
    int tamaño;
    private Nodo ultimo;
    
    public ListaCircular(){
        ultimo=null; // porque no hay nada al inicio
    }
    
    public boolean vacia(){
      return ultimo==null;
    }
    // insertar nodos
    
    public ListaCircular insertar(int posicion,int dato){
        Nodo nuevo= new Nodo(posicion,dato);
        if(ultimo!=null){
            nuevo.setSig(ultimo.getSig());
            ultimo.setSig(nuevo);
        }
            ultimo=nuevo;
            return this;
        
        
    }
    
    public void mostrar(){
     if(!vacia()){
            Nodo aux= ultimo.getSig();
        
        do{
           System.out.println(aux.getPosicion());
           aux=aux.getSig();
        }while(aux!=ultimo.getSig());
     }else{
         System.out.println("vacia");
     }
    }
    public boolean eliminar(int p){
     Nodo a;
     boolean encontrado=false;
     a=ultimo;
     while(a.getSig()!=ultimo && !encontrado){ // eocntrado es falso
         encontrado=(a.getSig().getPosicion()==p);
         if(!encontrado){
          a=a.getSig();
         }
     }
     encontrado=(a.getSig().getPosicion()==p);
     if(encontrado){// true
         Nodo aux=a.getSig();
         if(ultimo==ultimo.getSig()){
             ultimo=null; // no hay mas nodos en la lista
         }else{
             if(aux== ultimo){
                 ultimo=a;
             }
             a.setSig(aux.getSig());
         }
         aux=null;
     }
     return encontrado==true;
     
    }
     
}