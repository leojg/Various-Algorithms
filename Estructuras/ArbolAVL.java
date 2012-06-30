/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;

/**
 *
 * @author Alvaro
 */
public class ArbolAVL<AnyType extends Comparable<? super AnyType>>
{

    /** Creates a new instance of ArbolAVL */
    private NodoBinario<AnyType> raiz;

    public ArbolAVL()
    {
         vaciar();
    }
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
    public void imprimirArbolDesc( )
    {
        if( esVacio( ) )
            System.out.println( "Arbol Vacio" );
        else
            imprimirArbolDesc( raiz );
    }

    private void imprimirArbolDesc( NodoBinario<AnyType> t )
    {
        if( t != null )
        {
            imprimirArbolDesc( t.izquierdo );
            System.out.print( ";" + t.dato );
            imprimirArbolDesc( t.derecho );
        }
    }
     public void imprimirArbolNiv( )
    {
        if( esVacio( ) )
            System.out.println( "Arbol Vacio" );
        else
        {
            Cola<Capsula> c = new ColaVec<Capsula>();
            try
            {
                int nivel = 0;
                Capsula actual;
                c.insertar(new Capsula(raiz, 0));
                while(!c.esVacia())
                {
                    actual = c.quitarPrimero();
                    //nivel = actual.nivel;
                    if(actual.nodo.izquierdo != null)
                        c.insertar(new Capsula(actual.nodo.izquierdo, actual.nivel + 1));
                    if(actual.nodo.derecho != null)
                        c.insertar(new Capsula(actual.nodo.derecho,actual.nivel + 1));

                    if(nivel == actual.nivel )
                        System.out.print("-" +   actual.nodo.dato);
                    else
                        System.out.print("\n" +  actual.nodo.dato);
                    nivel = actual.nivel;
                }
                //System.out.println();
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }

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
            return t.altura;
    }
   private void actualizarAltura(NodoBinario<AnyType> t)
    {
        if(t != null)
            t.altura = 1 + Math.max(altura(t.izquierdo), altura(t.derecho));
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

    private NodoBinario<AnyType> conHijoIzquierdo(NodoBinario<AnyType> k2)
     {
         NodoBinario<AnyType> k1 = k2.izquierdo;
         k2.izquierdo = k1.derecho;
         k1.derecho = k2;
         //k2.altura = 1 + Math.max(altura(k2.izquierdo), altura(k2.derecho));
         //k1.altura = 1 + Math.max(altura(k1.izquierdo), k2.altura );
         actualizarAltura(k2);
         actualizarAltura(k1);
         return k1;
     }

   private NodoBinario<AnyType> conHijoDerecho(NodoBinario<AnyType> k1)
     {
         NodoBinario<AnyType> k2 = k1.derecho;
         k1.derecho = k2.izquierdo;
         k2.izquierdo = k1;
         //k1.altura = 1 + Math.max(altura( k1.izquierdo ), altura( k1.derecho ));
         //k2.altura = 1 + Math.max(altura( k2.derecho ), k1.altura);
         actualizarAltura(k1);
         actualizarAltura(k2);
         return k2;
     }
     private NodoBinario<AnyType> dobleConHijoIzquierdo(NodoBinario<AnyType> k3)
     {
         k3.izquierdo = conHijoDerecho(k3.izquierdo);
         return conHijoIzquierdo(k3);
     }

     private NodoBinario<AnyType> dobleConHijoDerecho(NodoBinario<AnyType> k1)
     {
         k1.derecho = conHijoIzquierdo(k1.derecho);
         return conHijoDerecho(k1);
     }

     private NodoBinario<AnyType> balancear(NodoBinario<AnyType> t)
    {
        if(t != null)
        {
            if(altura(t.izquierdo) - altura(t.derecho) == 2)//desequilibrio hacia la izquierda
             {
                 if(altura(t.izquierdo.izquierdo) > altura(t.izquierdo.derecho))//simple conhijoIzquierdo
                     t = conHijoIzquierdo(t);
                 else
                     t = dobleConHijoIzquierdo(t);
             }
             else if(altura(t.derecho) - altura(t.izquierdo) == 2)//desequilibrio hacia la derecha
             {
                 if(altura(t.derecho.derecho) > altura(t.derecho.izquierdo))
                     t = conHijoDerecho(t);
                 else
                     t = dobleConHijoDerecho(t);
             }
         }
         return t;
     }

             public void insertar( AnyType x )
    {
        raiz = insertar(x, raiz);
    }

    /**
     * Metodo privado que inserta en el ABB AVL
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
         t = balancear(t);
         actualizarAltura(t);
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
        else if( t.izquierdo != null && t.dato != null ) // Dos hijos
        {
            t.dato = EncontrarMin( t.derecho ).dato;
            t.derecho = eliminar( t.dato, t.derecho);
        }
        else
            t = ( t.izquierdo != null ) ? t.izquierdo : t.derecho;

        t = balancear(t);
        actualizarAltura(t);
        return t;
    }
    private static class Capsula
    {

        Capsula(NodoBinario nod, int niv)
        {
            nodo = nod;
            nivel = niv;
        }
         NodoBinario nodo;
        int nivel;

    }
}
