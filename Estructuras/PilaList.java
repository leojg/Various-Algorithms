/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;
import Excepciones.*;


/**
 *
 * @author anunez48
 */
public class PilaList<AnyType> implements Pila <AnyType>
{

    /** Creates a new instance of PilaList */
    private NodoLista<AnyType> cabecera;
    private int tamanio;
    public PilaList()
    {
        cabecera = null;
        tamanio = 0;
    }
    @Override
    public void apilar(AnyType x)
    {
        if(esVacia())
            cabecera = new NodoLista<AnyType>(x,null);
        else
            cabecera = new NodoLista<AnyType>(x,cabecera);
        tamanio++;
    }
    @Override
    public AnyType desapilar() throws DesbordamientoInferior//desapila y devuelve
    {
         if(esVacia())
            throw new DesbordamientoInferior("No hay Elementos");
         AnyType res = cabecera.dato;
         cabecera = cabecera.siguiente;
         tamanio--;
         return res;
    }
    @Override
    public AnyType cima() throws DesbordamientoInferior//devuelve y no desapila
    {
         if(esVacia())
            throw new DesbordamientoInferior("No hay Elementos");
         return cabecera.dato;
    }
    @Override
    public boolean esVacia()
    {
        return tamanio == 0;
    }
    @Override
    public void vaciar()
    {
        cabecera = null;
        tamanio = 0;
    }
    @Override
    public int size()
    {
        return tamanio;
    }

}
