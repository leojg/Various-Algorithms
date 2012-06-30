/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Administrador
 */
public class MonticuloBinario <AnyType extends Comparable<? super AnyType>> implements ColaDePrioridad<AnyType>
{
    private AnyType [] arreglo;
    private int tamanio;
    
    public MonticuloBinario()
    {
        this(11);
    }
    public MonticuloBinario(int tam)
    {
        arreglo = (AnyType []) new Object[tam];
        tamanio = 0;
    }
    
    @Override
    public void insertar(AnyType x) {
        
        if(tamanio + 1 == arreglo.length)
            duplicar();
        
        int hueco = ++tamanio;
        arreglo[0] = x;
        //FILTRADO ASCENDENTE
        while(x.compareTo(arreglo[hueco / 2]) < 0)
        {
            arreglo [hueco] = arreglo [hueco / 2];
            hueco = hueco / 2;
        }
        arreglo[hueco] = x;
    }
    
    private void duplicar()
    {
        AnyType[] aux = (AnyType[]) new Comparable[arreglo.length * 2];
       
        System.arraycopy(arreglo, 0, aux, 0, arreglo.length);
        
        arreglo = aux;
    }

    @Override
    public AnyType minimo() {
      
        if(esVacia())
          return null;
      return arreglo[1];
    }

    @Override
    public AnyType eliminarMin() {
        if(esVacia())
            return null;
        AnyType tmp = arreglo[1];
        arreglo[1] = arreglo[tamanio--];
        filtradoDescendente(1);
        return tmp;
    }
    
    private void filtradoDescendente(int hueco)
    {
        int hijo;
        AnyType tmp = arreglo[ hueco ];

        for(; hueco * 2 <= tamanio; hueco = hijo )
        {
            hijo = hueco * 2;
            if( hijo != tamanio && arreglo[ hijo + 1 ].compareTo( arreglo[ hijo ] ) < 0)
                hijo++;
            //en hijo tengo el menor 
            if( arreglo[ hijo ].compareTo( tmp ) < 0 )
                arreglo[ hueco ] = arreglo[ hijo ];
            else
                break;
           
        }
        arreglo[ hueco ] = tmp;
    }

    @Override
    public boolean esVacia() {
      return tamanio == 0;
    }

    @Override
    public void vaciar() {
        tamanio = 0;
    }

    @Override
    public int size() {
        return tamanio;
    } 
}
