/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;

/**
 *
 * @author anunez48
 */
public class NodoLista<AnyType>{

    /** Creates a new instance of NodoLista */
    //ATRIBUTOS AMISTOSOS, ACCESIBLES EN EL PAQUETE
    AnyType dato;
    NodoLista<AnyType> siguiente;

    public NodoLista(AnyType e)
    {
        this(e,null);
    }
    public NodoLista(AnyType e, NodoLista<AnyType> sig)
    {
        dato = e;
        siguiente = sig;
    }


}