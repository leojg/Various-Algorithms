/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;

/**
 *
 * @author Administrador
 */
public class Arbol<AnyType>
{
 //atributo amistoso
    NodoArbol<AnyType> raiz;

    /** Creates a new instance of ArbolBinario */
    public Arbol()
    {
        this(null);
    }
    public Arbol(NodoArbol r)
    {
        raiz = r;
    }

    public boolean esVacio()
    {
        return raiz == null;
    }

    public void vaciar()
    {
        raiz = null;
    }
     public void printPreOrder()
    {
        if(raiz != null)
           raiz.printPreOrder();
    }
    public void printPostOrder()
    {
        if(raiz != null)
            raiz.printPostOrder();
    }
    public void printInOrder()
    {
        if(raiz != null)
           raiz.printInOrder();
    }


}
