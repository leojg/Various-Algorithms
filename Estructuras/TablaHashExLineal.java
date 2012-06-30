/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;
import Excepciones.*;

/**
 *
 * @author Mark Allen Weiss
 * Traducción: anunez48
 */
public class TablaHashExLineal<AnyType> implements TablaHash<AnyType>
{
    private static final int TAMANYO_POR_DEFECTO = 11;
    private EntradaHash<AnyType>[] arreglo;
    private int tamanio;

    public TablaHashExLineal()
    {
        arreglo = new EntradaHash[TAMANYO_POR_DEFECTO];
        vaciar();
    }
    public final void vaciar()
    {
        tamanio = 0;
        for(int i = 0; i < arreglo.length; i++)
            arreglo[i] = null;
    }

    public final void insertar(AnyType x)
    {
        int posActual = buscarPos(x);
        arreglo[posActual] = new EntradaHash(x, true);//lo inserta como activo
        if(++tamanio >= arreglo.length / 2 )
            rehash();
    }
    //devuelve la posicion donde debería insertarse el elemento
    //en este metodo aplico un tipo de exploracion.
    private int buscarPos(AnyType x)
    {
        int posActual = x.hashCode();
        posActual %= arreglo.length;
        //para asegurar que quede en el rango
        if(posActual < 0)
            posActual += arreglo.length ;
        //si es negativo
        while(arreglo[posActual] != null && !arreglo[posActual].elemento.equals( x ) )
        {
            posActual++;  // Computa prueba i-ésima
            if( posActual == arreglo.length)
                posActual = 0;
        }
        return posActual;

    }

    public AnyType buscar(AnyType x) throws ElementoNoEncontrado//con hash abierto lo sobreescrbiríamos
    {
        int posActual = buscarPos(x);
        if(arreglo[posActual] == null || arreglo[posActual].esActivo == false)
            throw new ElementoNoEncontrado("Buscar de Exploración Tabla Hash");
        return arreglo[posActual].elemento;
    }


    public final void eliminar(AnyType x) throws ElementoNoEncontrado
    {
        int posActual = buscarPos(x);
        if(arreglo[posActual]== null || arreglo[posActual].esActivo == false)
            throw new ElementoNoEncontrado("Eliminacion de Tabla Hash falla");
        arreglo[posActual].esActivo = false;
        tamanio --;
    }

    private final void rehash()
    {
        EntradaHash [] antiguo = arreglo;
        arreglo = new EntradaHash[siguientePrimo(arreglo.length * 2 + 1)];
        tamanio = 0;
        //copio arreglo en aux
        for(int i = 0; i < antiguo.length; i++)
            if(antiguo[i] != null && antiguo[i].esActivo)
                insertar((AnyType)antiguo[i].elemento);
    }


    /**
     * Método interno para encontrar un numero primo mayor o igual a n
     * @param n el numero de comienzo 
     * @return un numero primo mayor o igual a n
     */
    @SuppressWarnings("empty-statement")
    private final int siguientePrimo( int n )
    {
        for( ; !esPrimo( n ); n += 2 ) ;
        return n;
    }

    /**
     * Método interno para testear si un número es primo
     * No es un algoritmo eficiente (hay mejores algoritmos que este)
     * @param n el número a testear
     * @return el resultado del test
     */
    private final boolean esPrimo( int n )
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

