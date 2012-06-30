/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;

/**
 *
 * @author Alvaro
 */
public class ArbolBinarioBusqueda
        <AnyType extends Comparable<? super AnyType>>
{

  private NodoBinario<AnyType> raiz;

   public ArbolBinarioBusqueda( )
    {
        raiz = null;
    }
    /**
     *Vacia el arbol
     */
    public void vaciar( )
    {
        raiz = null;
    }

    /**
     * Cmprueba si el arbol es vacio
     * @return true si es vacio, false en caso contario.
     */
    public boolean esVacio( )
    {
        return raiz == null;
    }
    public void imprimirArbol( )
    {
        if( esVacio( ) )
            System.out.println( "Arbol Vacio" );
        else
            imprimirArbol( raiz );
    }

    private void imprimirArbol( NodoBinario<AnyType> t )
    {

        if( t != null )
        {
            imprimirArbol( t.izquierdo );
            System.out.println( t.dato );
            imprimirArbol( t.derecho );
        }
    }

    public int altura()
    {
        return altura(raiz);
    }
    private int altura( NodoBinario<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( altura( t.izquierdo ), altura( t.derecho ) );
    }

    /**
     * Encuentra un elemento en el arbol
     * @param x el elemento a buscar
     * @return true si lo encuentra
     */
    public boolean contiene( AnyType x )
    {
        return contiene( x, raiz );
    }

    /**
     *Metodo privado para hallar un elemento en el subarbol
     * @param x es el elemento a buscar
     * @param t el nodo raiz del subarbol
     * @return true si lo halla
     */
    private boolean contiene( AnyType x, NodoBinario<AnyType> t )
    {
        if( t == null )
            return false;

        int comparo = x.compareTo( t.dato );

        if( comparo < 0 )
            return contiene(x, t.izquierdo);
        else if( comparo > 0 )
            return contiene(x, t.derecho);
        else
            return true;    // Concuerda
    }

     /**
     * Encuentra el elemento más pequeño en el arbol
     * @return el elemento mas pequeño. o null si es vacio
     */
    public AnyType EncontrarMin( )
    {
         if(esVacio())
            return null;
         else
             return EncontrarMin( raiz ).dato;
    }
    /**
     * Metodo interno que devuelve el minimo
     * @param t el nodo raiz del subarbol
     * @return nodo conteniendo el minimo elemento.
     */
    private NodoBinario<AnyType> EncontrarMin( NodoBinario<AnyType> t )
    {
        if( t.izquierdo == null )
            return t;
        else
            return EncontrarMin( t.izquierdo );
    }

    public AnyType EncontrarMax( )
    {
        if(esVacio())
            return null;
         else
            return EncontrarMax( raiz ).dato;
    }

    private NodoBinario<AnyType> EncontrarMax( NodoBinario<AnyType> t )
    {
        while( t.derecho != null )
                t = t.derecho;
        return t;
    }

    /**
     * Inserta en el arbol, duplicados son ignorados
     * @param x el elemento a insertar (Comparable!!!)
     */
    public void insertar( AnyType x )
    {
        raiz = insertar(x, raiz);
    }

    /**
     * Metodo privado que inserta en el ABB
     * @param x el item a insertar
     * @param t el nodo raiz del subarbol
     * @return la nueva raiz del subarbol
     */
   private NodoBinario<AnyType> insertar( AnyType x, NodoBinario<AnyType> t )
    {

        if( t == null )
            return new NodoBinario<AnyType>( x, null, null );

        int comparo = x.compareTo(t.dato);

        if( comparo < 0 )
            t.izquierdo = insertar( x, t.izquierdo );
        else if( comparo > 0 )
            t.derecho = insertar( x, t.derecho );
        else
            ;  // Duplicado, no hago nada ver***********

        return t;
    }

    /**
     * Elimina del arbol. No hace nada si no encuentra x
     * @param x el item a eliminar
     */
    public void eliminar( AnyType x )
    {
        raiz = eliminar(x, raiz);
    }

     /**
     * Metodo privado para eliminar de un subarbol
     * @param x el item a eliminar
     * @param t el nodo raiz del subarbol
     * @return la nueva raiz del subarbol
     */
    private NodoBinario<AnyType> eliminar( AnyType x, NodoBinario<AnyType> t )
    {
        if( t == null )
            return t;   // Elemento no encontrado. No hace nada.

        int comparo = x.compareTo( t.dato );

        if( comparo < 0 )
            t.izquierdo = eliminar(x, t.izquierdo);
        else if( comparo > 0 )
            t.derecho = eliminar(x, t.derecho);
        else if( t.izquierdo != null && t.derecho != null ) // Dos hijos
        {
            t.dato = EncontrarMin( t.derecho ).dato;
            t.derecho = eliminar( t.dato, t.derecho);
        }
        else
        {
            if(t.izquierdo != null)
                t = t.izquierdo;
            else
                t = t.derecho;
        }
        return t;
    }
}
