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
public class ColaList<AnyType> implements Cola<AnyType>
{

    /** Creates a new instance of ColaList */
    private NodoLista<AnyType> ini;
    private NodoLista<AnyType> fin;
    private int tamanio;
    public ColaList()
    {
        tamanio = 0;
        ini = fin = null;
    }

    @Override
    public void insertar(AnyType x)
    {
        tamanio++;
        if(!esVacia())
            fin = fin.siguiente = new NodoLista<AnyType>(x,null);
        else
            ini = fin = new NodoLista<AnyType>(x,null);
    }

    @Override
    public AnyType quitarPrimero() throws DesbordamientoInferior
    {
        if(esVacia())
            throw new DesbordamientoInferior("No hay Elementos");
        AnyType res = ini.dato;
        ini = ini.siguiente;
        tamanio--;
        return res;
    }
    @Override
    public AnyType primero() throws DesbordamientoInferior
    {
        if(esVacia())
            throw new DesbordamientoInferior("No hay Elementos");
        return ini.dato;
    }

    @Override
    public void vaciar()
    {
        ini = fin = null;
        tamanio = 0;
    }
    @Override
     public boolean esVacia()
    {
        return ini == null;
    }
    @Override
    public int size()
    {
        return tamanio;
    }
}
