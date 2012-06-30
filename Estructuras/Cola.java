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
public interface Cola<AnyType>
{
    void insertar(AnyType x);//enqueue
    AnyType primero()throws DesbordamientoInferior;
    //devuelve el primer elemento sin quitarlo
    AnyType quitarPrimero()throws DesbordamientoInferior;
    //devuelve el primer elemento y lo quita (dequeue)
    boolean esVacia();
    void vaciar();
    int size();
}
