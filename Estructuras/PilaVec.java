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
public class PilaVec<AnyType> implements Pila<AnyType>
{

    /** Creates a new instance of PilaVec */

    private AnyType [] arreglo;
    private int cima;
    private final int CAPACIDAD_DEFECTO = 10;
    public PilaVec()
    {
        cima = -1;
        arreglo = (AnyType []) new Object[CAPACIDAD_DEFECTO];
    }
    @Override
    public void apilar(AnyType x)
    {
        cima++;
        if(cima == arreglo.length)
            duplicar();
        arreglo[cima] = x;
    }
    @Override
    public AnyType desapilar() throws DesbordamientoInferior//desapila y devuelve
    {
        if(esVacia())
        throw new DesbordamientoInferior("No hay Elementos");
       return arreglo[cima--];
    }
    @Override
    public AnyType cima() throws DesbordamientoInferior//devuelve y no desapila
    {
        if(esVacia())
            throw new DesbordamientoInferior("No hay Elementos");
        return arreglo[cima];
    }
    @Override
    public boolean esVacia()
    {
        return cima == -1;
    }
    @Override
    public void vaciar()
    {
        cima = -1;
    }
    @Override
    public int size()
    {
        return (cima+1);
    }
    private void duplicar()
    {
        AnyType[] aux = (AnyType [])new Object[arreglo.length * 2];
        for(int i = 0; i < arreglo.length; i++)
            aux[i] = arreglo[i];
        arreglo = aux;
    }

}
