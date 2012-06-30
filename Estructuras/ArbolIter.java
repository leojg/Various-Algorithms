/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;
import Excepciones.*;
/**
 *
 * @author Administrador
 */
public class ArbolIter<AnyType>
{
    private NodoArbol<AnyType> actual;
    private Arbol<AnyType> elArbol;

    public ArbolIter(Arbol<AnyType> a)
    {
        elArbol = a;
        actual = elArbol.raiz;
    }
    /**
     *
     * @param x
     * @throws ElementoNoEncontrado
     * Lo inserta  en la raiz o como hijo de actual si es valido.
     */
    public void insertar(AnyType x) throws ElementoNoEncontrado
    {
        if(elArbol.esVacio())
            actual = elArbol.raiz = new NodoArbol<AnyType>(x,null,null);
        else
        {
            if(!esValido())
                throw new ElementoNoEncontrado("Posicion no valida");
            actual.primerHijo = new NodoArbol<AnyType>(x,null,actual.primerHijo);
        }
    }
    /**
     *
     * @param x
     * @return boolean si lo encontro
     * Busca a partir de la raiz
     * En caso de encontrarlo deja a actual posicionado en el elemento
     */
    public boolean buscar(AnyType x)
    {
       NodoArbol<AnyType> nodoObjeto = buscarAux(x, elArbol.raiz);
        if (nodoObjeto != null)
        {
            actual = nodoObjeto;
            return true;
        }
        else
            return false;
    }

    private  NodoArbol<AnyType> buscarAux(AnyType x,  NodoArbol<AnyType> nodo)
    {
        //La busqueda es recursiva inorder
    	if (nodo == null)
            return null;
    	else
        {
            if (nodo.dato.equals(x))
                return nodo;
            else
            {
                NodoArbol<AnyType> temp = buscarAux(x, nodo.primerHijo);
                if (temp == null)
                    temp = buscarAux(x, nodo.siguienteHermano);
                return temp;
            }
        }
    }
    /**
     *
     * @param x
     * @throws ElementoNoEncontrado
     * si no lo encuentra tira una excepcion
     * busca el nodo que lo apunta para pasarlo por alto
     */
   public void eliminar(AnyType x) throws ElementoNoEncontrado
   {
       if(elArbol.esVacio())
           throw new ElementoNoEncontrado("Arbol vacio");
       //primero veo si no es la raiz el dato buscado
       if(elArbol.raiz.dato.equals(x))
           elArbol.vaciar();
       else
       {
           NodoArbol<AnyType> anterior = buscarAnterior(x, elArbol.raiz, elArbol.raiz.primerHijo);
           if(anterior == null)
                   throw new ElementoNoEncontrado("Eliminación fallida. No se encontró el nodo.");
               else
                   eliminarAPartirDelAnterior(x,anterior);
       }
   }
   /**
    *
    * @param x
    * @param anterior
    * @param act
    * @return
    * BUSCA EL NODO QUE LO APUNTA
    * devuelve null si no halla
    */

   private  NodoArbol<AnyType> buscarAnterior(AnyType x,  NodoArbol<AnyType> anterior,  NodoArbol<AnyType> act)
   {

       if(act == null)
           return null;
       else
       {
           if(act.dato.equals(x))
               return anterior;
           else
           {
               NodoArbol<AnyType> temp = buscarAnterior(x, act, act.primerHijo);
               if(temp == null)
                   temp = buscarAnterior(x,act, act.siguienteHermano);
               return temp;
           }
       }
   }
   /**
    *
    * @param x
    * @param anterior
    * elimina a partir del anterior, aunque yo no se si es el primer hijo
    * o el siguiente hermano
    */
   private void eliminarAPartirDelAnterior(AnyType x, NodoArbol<AnyType> anterior)
   {
       if(anterior.primerHijo != null)//tiene al menos un hijo
       {
           if(anterior.primerHijo.dato.equals(x))//es el primer hijo
               anterior.primerHijo = anterior.primerHijo.siguienteHermano;
           else
               anterior.siguienteHermano = anterior.siguienteHermano.siguienteHermano;
       }
       else
           anterior.siguienteHermano = anterior.siguienteHermano.siguienteHermano;
   }
   public void irARaiz()
   {
       actual = elArbol.raiz;
   }
    public void irAPrimerHijo()
    {
        if(esValido())
            actual = actual.primerHijo;
    }
   public void irASiguienteHermano()
   {
       if(esValido())
           actual = actual.siguienteHermano;
   }
    public boolean esValido()
    {
        return actual != null;
    }
   public AnyType recuperar()
   {
         if(esValido())
             return actual.dato;
         return null;
   }
 
}
