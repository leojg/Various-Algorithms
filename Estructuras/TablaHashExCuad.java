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
public class TablaHashExCuad<AnyType> implements TablaHash<AnyType>
{

    /** Creates a new instance of TablaHashEx */

    private static final int TAMANYO_POR_DEFECTO = 11;
    private EntradaHash<AnyType>[] arreglo;
    private int tamanio;

    public TablaHashExCuad()
    {
        arreglo = new EntradaHash[TAMANYO_POR_DEFECTO];
        vaciar();
    }
    @Override
    public final void vaciar()
    {
        tamanio = 0;
        for(int i = 0; i < arreglo.length; i++)
            arreglo[i] = null;
    }

    @Override
    public final void insertar(AnyType x)
    {
        int posActual = buscarPos(x);
        arreglo[posActual] = new EntradaHash(x, true);//lo inserta como activo
        if(++tamanio >= arreglo.length / 2)
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
        int colision = 1;
        while(arreglo[posActual] != null && !arreglo[posActual].elemento.equals( x ) )
        {
            posActual += colision;  // Computa prueba i-ésima
            colision += 2;
            if( posActual >= arreglo.length)
                posActual -= arreglo.length;
        }
        return posActual;

    }
    private int buscarPos2(AnyType x)
    {
        int posActual = x.hashCode();
        posActual %= arreglo.length;//para asegurar que quede en el rango
         if(posActual < 0)
            posActual += arreglo.length ;
        int primera = posActual;
        int i = 0;
        while(arreglo[posActual] != null && !arreglo[posActual].elemento.equals( x ) )
        {
            i++;
            posActual = primera + i^2;
             if( posActual >= arreglo.length)
                posActual -= arreglo.length;
        }
        return posActual;
    }

    @Override
    public AnyType buscar(AnyType x) throws ElementoNoEncontrado//con hash abierto lo sobreescrbiríamos
    {
        int posActual = buscarPos(x);
        if(arreglo[posActual] == null || arreglo[posActual].esActivo == false)
            throw new ElementoNoEncontrado("Buscar de Exploración Tabla Hash");
        return arreglo[posActual].elemento;
    }


    @Override
    public final void eliminar(AnyType x) throws ElementoNoEncontrado
    {
        int posActual = buscarPos(x);
        if(arreglo[posActual]== null || arreglo[posActual].esActivo == false)
            throw new ElementoNoEncontrado("Eliminacion de Tabla Hash falla");
        arreglo[posActual].esActivo = false;
    }

    private void rehash()
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

