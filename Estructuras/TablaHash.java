/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;
import Excepciones.*;

/**
 *
 * @author Mark Allen Weiss
 * Traducción: anunez48
 */
public interface TablaHash<AnyType>
{
    void insertar( AnyType x );
    void eliminar( AnyType x ) throws ElementoNoEncontrado;
    AnyType buscar( AnyType x ) throws ElementoNoEncontrado;
    void vaciar( );
}

