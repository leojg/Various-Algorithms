/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
import java.util.Queue;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.PriorityQueue;
import Excepciones.*;


/**
 *
 * @author Administrador
 */
public class Grafo {
    
    public static final int INFINITO = Integer.MAX_VALUE;
    private Map<String,Vertice> verticesMapa;
    
    public Grafo()
    {
       verticesMapa = new HashMap<String,Vertice>( );
    }

    /**
     * Agrega un nuevo vertice al grafo 
     * (al mapa de vertices) siempre que el nombre
     * no exista, en caso de que ya exista un vertice
     * con el nombre tira la excepcion.
     * @param nombre nombre del nuevo vertice
     * @throws ElementoDuplicado en caso de que exista un vertice con el mismo nombre en el mapa
     */
    public void agregarVertice(String nombre) throws ElementoDuplicado
    {
        Vertice v = verticesMapa.get( nombre );
        if( v == null )
        {
            v = new Vertice( nombre );
            verticesMapa.put( nombre, v );
        }
      else
            throw new ElementoDuplicado("Ya existe vertice con ese nombre");
    }
    /**
     * Elimina el vértice así como todos los arcos asociados a el
     * en caso de que el vertice no existe lanza una excepcion.
     * @param nombre nombre del vertice a eliminar
     * @throws ElementoNoEncontrado en caso de que no exista un vertice con ese nomnbre en el mapa
     */
    public void eliminarVertice(String nombre) throws ElementoNoEncontrado
    {
        Vertice v = verticesMapa.get(nombre);
        if(v == null)
            throw new ElementoNoEncontrado("No existe vertice con ese nombre ");
        
        verticesMapa.remove(nombre);
        
       Vertice w;
       for(Map.Entry<String,Vertice> entrada : verticesMapa.entrySet())
       {
          w = entrada.getValue();
          for(Arco a : w.listaAdj)
          {
              if(a.destino.equals(v))
                  w.listaAdj.remove(a);
          }
       }
    }
    
    /**
     * Agrega nuevo arco al grafo.
     * Si no existe algun vertice con esos nombres los crea y 
     * agrega al mapa.
     * @param nombreOrigen nombre del vertice origen
     * @param nombreDestino nombre del vertice destino
     * @param costo asociado a la arista (si es sin pesos debe ser 1)
     * @throws ElementoDuplicado en caso de tener dos arcos identicos
     */
   
    public void agregarArco( String nombreOrigen, String nombreDestino, int costo ) throws ElementoDuplicado
    {
        Vertice v = getVertice( nombreOrigen );
        Vertice w = getVertice( nombreDestino );
        Arco a = new Arco(w,costo);
        if(v.listaAdj.contains(a))
            throw new ElementoDuplicado("Ya existe un arco identico");
        else
            v.listaAdj.add(a);
    }
    public void eliminarArco(String origen, String destino, int costo)throws ElementoNoEncontrado
    {
        Vertice v = verticesMapa.get(origen);
        Vertice w = verticesMapa.get(destino);
        if(v == null || w == null)
            throw  new ElementoNoEncontrado("no existe origen o destino");
        Arco a = new Arco(w,costo);
        if(v.listaAdj.remove(a))
           //llamo al eliminar de la lista que devuelve true si lo elimina
            //en este caso lo eliminó sin problemas, no hago nada
            ;
        else
            throw new ElementoNoEncontrado("Arco a eliminar no existe");
    }

    /**
     * Rutina publica que imprime el camino y el costo total, 
     * tiene en cuenta el caso de nodos destino inalcanzable.
     * llama recursivamente para imprimir camino hasta nombreDestino
     * DESPUES  qye el algoritmo de camino mínimo ha sido ejecutado.
     */
    public void imprimirCamino( String nombreDestino ) throws ElementoNoEncontrado
    {
        Vertice w = verticesMapa.get( nombreDestino );
        if( w == null )
            throw new ElementoNoEncontrado( "Vertice destino no encontrado" );
        else if( w.coste  == INFINITO )
            System.out.println( nombreDestino + " es inalcanzable" );
        else
        {
            System.out.print( "(Costo es: " + w.coste + ") " );
            imprimirCamino( w );
            System.out.println( );
        }
    }
    /**
     * Rutina recursiva para imprimir camino mínimo
     * DESPUES  que se ejecute el algoritmo de caminos mínimos.
     */
    private void imprimirCamino( Vertice dest )
    {
        if( dest.anterior != null )
        {
            imprimirCamino( dest.anterior );
            System.out.print( " -> " );
        }
        System.out.print( dest.nombre );
    }

    /**
     * SI el nombre de vertice no existe lo crea agregandolo al mapa
     * de otra manera devuelve el vertice por nombre
     */
    private Vertice getVertice( String verticeNombre )
    {
        Vertice v = verticesMapa.get( verticeNombre );
        if( v == null )
        {
            v = new Vertice( verticeNombre );
            verticesMapa.put( verticeNombre, v );
        }
        return v;
    }

    
    
    /**
     * Inicializa los vertices antes de correr al algoritmo de caminos mínimos.
     */
    private void limpiarTodo( )
    {
        for( Vertice v : verticesMapa.values( ) )
            v.resetear( );
    }
    /**
     * Verifica si el grafo es vacio, si carece de vertices
     * @return true si es vacio, false en caso contrario.
     */
    public boolean esVacio()
    {
        return verticesMapa.isEmpty();       
    }

    /**
     * Algoritmo de caminos mínimos sin pesos
	 *      :)
     */
    public void sinPesos( String nombreInicio ) throws ElementoNoEncontrado
    {
        Vertice inicio = verticesMapa.get( nombreInicio );
        if( inicio == null )
            throw new ElementoNoEncontrado( "Vertice Inicial no encontrado" );

        limpiarTodo(); 
        
    }
    /**
     * Algoritmo de dijkstra
	 *      :)
     */
    public void dijkstra( String nombreInicio ) throws ElementoNoEncontrado
    {
		limpiarTodo(); 
    }
}
