/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;

/**
 *
 * @author Administrador
 */
public class NodoArbol <AnyType>
{
    //atributos amistosos, accedibles en el paquete
     AnyType dato;
     NodoArbol primerHijo;
     NodoArbol siguienteHermano;

    /** Creates a new instance of NodoBinario */
    NodoArbol()
    {
        this(null);
    }
    NodoArbol(AnyType elDato)
    {
        this(elDato, null);
    }
    NodoArbol(AnyType elDato, NodoArbol hijo)
    {
        this(elDato, hijo, null);
    }
    NodoArbol(AnyType elDato, NodoArbol hijo, NodoArbol hermano)
    {
        dato = elDato;
        primerHijo = hijo;
        siguienteHermano = hermano;
    }

    void printPreOrder( )
    {
        System.out.println( dato );       // Node
        if( primerHijo != null )
            primerHijo.printPreOrder( );           // left
        if( siguienteHermano != null )
            siguienteHermano.printPreOrder( );          // right
    }

//
    void printPostOrder( )
    {
        if( primerHijo != null )
            primerHijo.printPostOrder( );          // left
        if( siguienteHermano != null )
            siguienteHermano.printPostOrder( );         // right
        System.out.println( dato );       // Node
    }

    void printInOrder( )
    {
        if( primerHijo != null )
            primerHijo.printInOrder( );            // Left
        System.out.println( dato );       // Node
        if( siguienteHermano != null )
            siguienteHermano.printInOrder( );           // Right
    }


}
