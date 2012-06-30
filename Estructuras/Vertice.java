/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Administrador
 * Clse vertice para utilizar con lista de adyacencia
 */
 final class Vertice {
    
    String nombre; //el nombre lo identifica 
    List<Arco> listaAdj;
    int coste;   // coste desde el vertice inicial despues de ejecutar el algoritmo (sin pesos y Dijkstra)
    Vertice anterior; // vertice previo en camino mínimo (sin pesos y Dijkstra)
    int extra;// variable extra utilizada en algoritmos, para ver, por ejemplo si ha sido visitado el vertice, podria ser boolean

     Vertice( String nom )
    {
        nombre = nom; 
        listaAdj = new LinkedList<Arco>( );
        resetear( ); 
    }

    void resetear( )
    { 
        coste = Grafo.INFINITO; 
        anterior = null; 
        extra = 0; 
    }
    @Override
   public boolean equals(Object o)
    {
        if( o instanceof Vertice)
        {
            Vertice v = (Vertice)o;
            return v.nombre.equals(nombre);
        }
        else
            return false;
    }

    @Override
    //codigo generado
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        return hash;
    }


}
