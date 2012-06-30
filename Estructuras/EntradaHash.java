/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;

/**
 *
 * @author Mark Allen Weiss
 * Traducción: anunez48
 */
public class EntradaHash<AnyType>
{
    //atributos amistosos.
    AnyType elemento;   // el elemento
    boolean  esActivo;  // false si está borrado

    /** Creates a new instance of EntradaHash */
    EntradaHash(AnyType e)
    {
        this(e, true);
    }
    EntradaHash(AnyType e, boolean i)
    {
        elemento = e;
        esActivo = i;
    }

}
