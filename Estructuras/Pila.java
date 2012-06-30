package Estructuras;
import Excepciones.*;

/**
 *
 * @author anunez48
 */
public interface Pila<AnyType>
{
    void apilar(AnyType x);
    AnyType desapilar() throws DesbordamientoInferior;//desapila y devuelve
    AnyType cima() throws DesbordamientoInferior;//devuelve y no desapila
    boolean esVacia();
    void vaciar();
    int size();
}
