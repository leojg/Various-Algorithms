/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;

/**
 *
 * @author Alvaro
 */
public class NodoBinario <AnyType extends Comparable<? super AnyType>>
{

    //atributos amistosos
    AnyType dato;
    NodoBinario <AnyType> izquierdo;
    NodoBinario <AnyType> derecho;
    int altura; //para arbolrd AVL
    /** Creates a new instance of NodoBinario*/
    public NodoBinario(AnyType dt)
    {
        this(dt, null, null);
    }

    public NodoBinario(AnyType dt, NodoBinario<AnyType> izq, NodoBinario<AnyType> der)
    {
        dato = dt;
        izquierdo = izq;
        derecho = der;
        altura = 0;
    }

}
