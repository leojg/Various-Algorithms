/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Administrador
 */
public interface ColaDePrioridad<AnyType extends Comparable<? super AnyType>> 
{
    /**
     * Inserta en la cola de prioridad manteniendo el orden
     * @param x el elemento a insertar
     */
    public void insertar(AnyType x);
    /**
     * Devuelve el elemento mínimo sin eliminarlo.
     * @return el elemento minimo o null si es vacia
     */
     public AnyType minimo( );

    /**
     * Devuelve el elemento mínimo y lo  elimina de la cola de prioridad.
     * @return el elemento minimo o null si es vacia.
     */
    public AnyType eliminarMin( );

    /**
     * Comprueba si es vacia.
     * @return true si es vacia, false en caso contrario.
     */
    public boolean esVacia( );

    /**
     * Vacia la cola de prioridad.
     */
    public void vaciar();
    
    /**
     * Devuelve el tamaño de la cola de prioridad
     * @return tamaño actual
     */
    public int size( );
        
}
