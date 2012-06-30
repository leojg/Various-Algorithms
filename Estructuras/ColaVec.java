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
public class ColaVec<AnyType> implements Cola<AnyType>
{

    /** Creates a new instance of ColaVec */
    private AnyType[] arreglo;
    private int ini;
    private int fin;
    private int tamanio;
    static final int CAPACIDAD_DEFECTO = 2;
    public ColaVec()
    {
        arreglo = (AnyType []) new Object[CAPACIDAD_DEFECTO];
        vaciar();
    }
    @Override
    public void insertar(AnyType x)//enqueue
    {
        if(tamanio == arreglo.length)
            duplicar();
        fin = incrementar(fin);
        arreglo[fin] = x;
        tamanio++;
    }
    @Override
    public AnyType primero()throws DesbordamientoInferior//devuelve el primer elemento sin quitarlo
    {
       if(esVacia())
            throw new DesbordamientoInferior("No hay Elementos");
        return arreglo[ini];
    }
    @Override
    public AnyType quitarPrimero()throws DesbordamientoInferior//devuelve el primer elemento y lo quita (dequeue)
    {
        if(esVacia())
            throw new DesbordamientoInferior("No hay Elementos");
        tamanio--;
        AnyType res = arreglo[ini];
        ini = incrementar(ini);
        return res;
    }
    @Override
    public boolean esVacia()
    {
        return tamanio == 0;
    }

    @Override
    public void vaciar()
    {
        ini = 0;
        fin = -1;
        tamanio = 0;
    }
    @Override
    public int size()
    {
        return tamanio;
    }
    private int incrementar(int x)
    {
        if(++x == arreglo.length)
            x = 0;
        return x;
    }
    private void duplicar()
    {
        AnyType [] aux = (AnyType [])new Object[arreglo.length * 2];
        for(int i = 0; i < tamanio; i++, ini = incrementar(ini))
            aux[i] = arreglo[ini];
        arreglo = aux;
        ini = 0;
        fin = tamanio -1;
    }
}
