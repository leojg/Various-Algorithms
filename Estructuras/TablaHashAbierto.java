/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;

import Excepciones.*;
import java.util.*;
/**
 *
 * 
 *
 */
public class TablaHashAbierto<AnyType> implements TablaHash<AnyType>
{
    private static final int TAMANYO_POR_DEFECTO = 11;
    private List<AnyType>[] arreglo;
    private int tamanio;

    public TablaHashAbierto()
    {   this(TAMANYO_POR_DEFECTO); }

    public TablaHashAbierto(int t)
    {
        arreglo = new LinkedList[siguientePrimo(t)];
        for(int i = 0 ; i < arreglo.length; i++)
            arreglo[i] = new LinkedList<AnyType>( );
    }

    @Override
    public void insertar( AnyType x )
    {
        int laLista = buscarPos(x);
        arreglo[laLista].add(x);
        if(++tamanio > arreglo.length * 2)
           // rehash();.
            ;
    }
    private int buscarPos(AnyType x)
    {
        int pos = x.hashCode();
         if(pos < 0)
            pos += arreglo.length;
        pos %= arreglo.length;
       
        return pos;
    }
    @Override
   public void eliminar( AnyType x ) throws ElementoNoEncontrado
    {
        int laLista = buscarPos(x);
        boolean res = arreglo[laLista].remove(x);
        if(!res)
            throw new ElementoNoEncontrado("No se encontró el elemento.");
        tamanio--;
    }
    @Override
    public AnyType buscar( AnyType x ) throws ElementoNoEncontrado
    {
         int laLista = buscarPos(x);
         boolean res = arreglo[laLista].contains(x);
         if(!res)
             throw new ElementoNoEncontrado("no se encontró el elemento.");
         return x;
    }
    @Override
    public void vaciar( )
    {
        tamanio = 0;
        for( int i = 0; i < arreglo.length; i++)
            arreglo[i].clear();
    }
    /**
     * metodo interno para encontrar un numero primo mayor o igual a n
     * @param n el numero de comienzo (debe ser positivo)
     * @return un numero primo mayor o igual a n
     */
    @SuppressWarnings("empty-statement")
    private int siguientePrimo( int n )
    {
        for( ; !esPrimo( n ); n += 2 ) ;
        return n;
    }

    /**
     * metodo interno para testear si un numero es primo
     * No es un algoritmo eficiente
     * @param n el numero a testear
     * @return el resultado del test
     */
    private boolean esPrimo( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;
        return true;
    }


}
