/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codigo2011;


/**
 *
 * @author Alvaro
 */

import java.util.Arrays;
import java.util.Random;
public class Ordenamiento
{
          
    public static void main(String []args)
    {
        int cant = 200000;
        Random r = new Random(System.nanoTime());
        int [] v = new int[cant];
        for(int i = 0; i < v.length;i++)
            v[i] = r.nextInt() % 100;
      
        int[] x = v.clone();
        int[] y = v.clone();
        int[] z = v.clone();
        int[] t = v.clone();
        int[] w = v.clone();
        
//        System.out.println(Arrays.toString(v));
//        System.out.println(Arrays.toString(x));
//        System.out.println(Arrays.toString(y));
//        System.out.println(Arrays.toString(z));
//        System.out.println(Arrays.toString(t));
        
         System.out.println("Comparacion de tiempos de ejecucion en milisegundos para " + Practico2.formato(cant) + " datos");
         System.out.println();
      
         long antes = System.currentTimeMillis();
         insertionSortInt(v);
         long despues = System.currentTimeMillis();
         String tiempo = Practico2.formato((int)(despues -  antes) );
         System.out.println("Tiempo de Insertsort: " + tiempo + " ms");
         
         v = null;
         
         antes = System.currentTimeMillis();
         shellsortInt(x);
         despues = System.currentTimeMillis();
         tiempo = Practico2.formato((int)(despues -  antes) );
         System.out.println("Tiempo de ShellSort con incremetos de Shell: " + tiempo + " ms");
         
         x = null;
         
         antes = System.currentTimeMillis();
         shellsortIntGonnet(y);
         despues = System.currentTimeMillis();
         tiempo = Practico2.formato((int)(despues -  antes) ) ;
         System.out.println("Tiempo de ShellSort con incremetos de Gonnet: " + tiempo + " ms");
         
         y = null;
         
         antes = System.currentTimeMillis();
         mergeSortInt(z);
         despues = System.currentTimeMillis();
         tiempo = Practico2.formato((int)(despues -  antes) );
         System.out.println("Tiempo de MergeSort: " + tiempo + " ms");
         
         z = null;
         
         antes = System.currentTimeMillis();
         quicksortInt(t);
         despues = System.currentTimeMillis();
         tiempo = Practico2.formato((int)(despues -  antes) );
         System.out.println("Tiempo de QuickSort: " + tiempo + " ms");
         
         t = null;
         
         antes = System.currentTimeMillis();
         Arrays.sort(w);
         despues = System.currentTimeMillis();
         tiempo = Practico2.formato((int)(despues -  antes) );
         System.out.println("Tiempo de QuickSort del lenguaje: " + tiempo + " ms");
          
         w = null;


    }
    public static void insertionSortInt( int [ ] a )
    {
        for( int p = 1; p < a.length; p++ )
        {
            int tmp = a[ p ];
            int j = p;

            for( ; j > 0 && tmp < a[ j - 1 ] ; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }
    /**
     * Ordenación por inserción
     * @param un array de elementos Comparables
     */
    public static <AnyType extends Comparable<? super AnyType>> void insertionSort( AnyType [ ] a )
    {
        for( int p = 1; p < a.length; p++ )
        {
            AnyType tmp = a[ p ];
            int j = p;

            for( ; j > 0 && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }
    
  

    /**
     * Shellsort, usando la secuencia de incrementos de Shell.
     * @param a un array de enteros.
     */
    public static void shellsortInt( int [ ] a )
    {
        int j;

        for( int intervalo = a.length / 2; intervalo > 0; intervalo /= 2 )
            for( int i = intervalo; i < a.length; i++ )
            {
                int tmp = a[ i ];
                for( j = i; j >= intervalo && tmp < a[ j - intervalo ] ; j -= intervalo )
                    a[ j ] = a[ j - intervalo ];
                a[ j ] = tmp;
            }
    }
    
     public static void shellsortIntGonnet( int [ ] a )
    {
        for( int intervalo = a.length / 2; intervalo > 0; intervalo = intervalo == 2 ? 1 : (int) ( intervalo / 2.2 ) )
            for( int i = intervalo; i < a.length; i++ )
            {
                int tmp = a[ i ];
                int j = i;

                for( ; j >= intervalo && tmp < a[ j - intervalo ]; j -= intervalo )
                    a[ j ] = a[ j - intervalo ];
                a[ j ] = tmp;
            }
    }



     /**
     * Shellsort, usando la secuencia de incrementos de Shell.
     * @param a un array de elementos Comparables.
     */
    public static <AnyType extends Comparable<? super AnyType>> void shellsort( AnyType [ ] a )
    {
        int j;

        for( int intervalo = a.length / 2; intervalo > 0; intervalo /= 2 )
            for( int i = intervalo; i < a.length; i++ )
            {
                AnyType tmp = a[ i ];
                for( j = i; j >= intervalo && tmp.compareTo( a[ j - intervalo ] ) < 0; j -= intervalo )
                    a[ j ] = a[ j - intervalo ];
                a[ j ] = tmp;
            }
    }


     /**
     * Shellsort, usando la secuencia sugerida por Gonnet
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>> void shellsortGonnet( AnyType [ ] a )
    {
        for( int intervalo = a.length / 2; intervalo > 0; intervalo = intervalo == 2 ? 1 : (int) ( intervalo / 2.2 ) )
            for( int i = intervalo; i < a.length; i++ )
            {
                AnyType tmp = a[ i ];
                int j = i;

                for( ; j >= intervalo && tmp.compareTo( a[ j - intervalo ] ) < 0; j -= intervalo )
                    a[ j ] = a[ j - intervalo ];
                a[ j ] = tmp;
            }
    }
    public static <AnyType extends Comparable<? super AnyType>> void mergeSortInt( int [ ] a )
    {
        int [ ] tmpArray =  new int[ a.length ];
        mergeSortInt( a, tmpArray, 0, a.length - 1 );
    }
      private static <AnyType extends Comparable<? super AnyType>> void mergeSortInt( int [ ] a, int [ ] tmpArray,
               int izq, int der )
    {
        if( izq < der )
        {
            int center = ( izq + der ) / 2;
            mergeSortInt( a, tmpArray, izq, center );
            mergeSortInt( a, tmpArray, center + 1, der );
            mergeInt( a, tmpArray, izq, center + 1, der );
        }
    }
       private static <AnyType extends Comparable<? super AnyType>> void mergeInt( int [ ] a, int [ ] tmpArray,
                               int PosIzq, int PosDer, int finalDer )
    {
        int finalIzq = PosDer - 1;
        int tmpPos = PosIzq;
        int numElementos = finalDer - PosIzq + 1;

        // Loop principal
        while( PosIzq <= finalIzq && PosDer <= finalDer )
            if( a[ PosIzq ] <= a[ PosDer ])
                tmpArray[ tmpPos++ ] = a[ PosIzq++ ];
            else
                tmpArray[ tmpPos++ ] = a[ PosDer++ ];

        while( PosIzq <= finalIzq )    // Copia el resto de la primera mitad
            tmpArray[ tmpPos++ ] = a[ PosIzq++ ];

        while( PosDer <= finalDer )  // Copia el resto de la seguna mitad
            tmpArray[ tmpPos++ ] = a[ PosDer++ ];

        // Copia tmpArray de nuevo hacia a 
        for( int i = 0; i < numElementos; i++, finalDer-- )
            a[ finalDer ] = tmpArray[ finalDer ];
    }


     /**
     * Algoritmo Mergesort
     * @param a un array de elementos Comparables
     */
    public static <AnyType extends Comparable<? super AnyType>> void mergeSort( AnyType [ ] a )
    {
        AnyType [ ] tmpArray = (AnyType []) new Comparable[ a.length ];
        mergeSort( a, tmpArray, 0, a.length - 1 );
    }

    /**
     * Método interno que realiza las llamadas recursivas.
     * @param a un array de elementos Comparables
     * @param tmpArray un array para guardar el resultado mezclado
     * @param izq el índice izquierdo del subarray
     * @param der el índice derecho del subarray
     */
    private static <AnyType extends Comparable<? super AnyType>> void mergeSort( AnyType [ ] a, AnyType [ ] tmpArray,
               int izq, int der )
    {
        if( izq < der )
        {
            int center = ( izq + der ) / 2;
            mergeSort( a, tmpArray, izq, center );
            mergeSort( a, tmpArray, center + 1, der );
            merge( a, tmpArray, izq, center + 1, der );
        }
    }

    /**
     * Método interno que mezcla las dos mitades de los subarrays ordenados.
     * @param a un array de elementos Comparables.
     * @param tmpArray n array para guardar el resultado mezclado.
     * @param PosIzq el índice izquierdo del subarray
     * @param PosDer el índice de comienzo de la segunda mitad
     * @param finalDer el índice derecho del subarray
     */
    private static <AnyType extends Comparable<? super AnyType>> void merge( AnyType [ ] a, AnyType [ ] tmpArray,
                               int PosIzq, int PosDer, int finalDer )
    {
        int finalIzq = PosDer - 1;
        int tmpPos = PosIzq;
        int numElementos = finalDer - PosIzq + 1;

        // Loop principal
        while( PosIzq <= finalIzq && PosDer <= finalDer )
            if( a[ PosIzq ].compareTo( a[ PosDer ] ) <= 0 )
                tmpArray[ tmpPos++ ] = a[ PosIzq++ ];
            else
                tmpArray[ tmpPos++ ] = a[ PosDer++ ];

        while( PosIzq <= finalIzq )    // Copia el resto de la primera mitad
            tmpArray[ tmpPos++ ] = a[ PosIzq++ ];

        while( PosDer <= finalDer )  // Copia el resto de la seguna mitad
            tmpArray[ tmpPos++ ] = a[ PosDer++ ];

        // Copia tmpArray de nuevo hacia a 
        for( int i = 0; i < numElementos; i++, finalDer-- )
            a[ finalDer ] = tmpArray[ finalDer ];
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
    void quicksortInt( int [ ] a )
    {
		quicksortInt( a, 0, a.length - 1 );
    }

     /**
     * algoritmo Quicksort
     * @param a un array de elementos Comparables.
     * ......
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void quicksort( AnyType [ ] a )
    {
		quicksort( a, 0, a.length - 1 );
    }

    private static final int CUTOFF = 3;

    /**
     * Method to swap to elements in an array.
     * @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 )
    {
        AnyType tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }
    
    public static <AnyType> void swapReferencesInt( int [ ] a, int index1, int index2 )
    {
        int tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }


    /**
     * Return median of left, center, and right.
     * Order these and hide the pivot.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    AnyType median3( AnyType [ ] a, int left, int right )
    {
        int center = ( left + right ) / 2;
        if( a[ center ].compareTo( a[ left ] ) < 0 )
            swapReferences( a, left, center );
        if( a[ right ].compareTo( a[ left ] ) < 0 )
            swapReferences( a, left, right );
        if( a[ right ].compareTo( a[ center ] ) < 0 )
            swapReferences( a, center, right );

            // Place pivot at position right - 1
        swapReferences( a, center, right - 1 );
        return a[ right - 1 ];
    }
     private static <AnyType extends Comparable<? super AnyType>>
    int median3Int( int [ ] a, int left, int right )
    {
        int center = ( left + right ) / 2;
        if( a[ center ] < a[ left ]  )
            swapReferencesInt( a, left, center );
        if( a[ right ] < a[ left ] )
            swapReferencesInt( a, left, right );
        if( a[ right ] < a[ center ] )
            swapReferencesInt( a, center, right );

            // Place pivot at position right - 1
        swapReferencesInt( a, center, right - 1 );
        return a[ right - 1 ];
    }

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
     
      private static <AnyType extends Comparable<? super AnyType>>
    void quicksortInt( int [ ] a, int left, int right )
    {
        if( left + CUTOFF <= right )
        {
            int pivot = median3Int( a, left, right );

                // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; )
            {
                while( a[ ++i ] < pivot  ) { }
                while( a[ --j ] > pivot  ) { }
                if( i < j )
                    swapReferencesInt( a, i, j );
                else
                    break;
            }

            swapReferencesInt( a, i, right - 1 );   // Restore pivot

            quicksortInt( a, left, i - 1 );    // Sort small elements
            quicksortInt( a, i + 1, right );   // Sort large elements
        }
        else  // Do an insertion sort on the subarray
            insertionSortInt( a, left, right );
    }
      
    private static <AnyType extends Comparable<? super AnyType>>
    void quicksort( AnyType [ ] a, int left, int right )
    {
        if( left + CUTOFF <= right )
        {
            AnyType pivot = median3( a, left, right );

                // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; )
            {
                while( a[ ++i ].compareTo( pivot ) < 0 ) { }
                while( a[ --j ].compareTo( pivot ) > 0 ) { }
                if( i < j )
                    swapReferences( a, i, j );
                else
                    break;
            }

            swapReferences( a, i, right - 1 );   // Restore pivot

            quicksort( a, left, i - 1 );    // Sort small elements
            quicksort( a, i + 1, right );   // Sort large elements
        }
        else  // Do an insertion sort on the subarray
            insertionSort( a, left, right );
    }

    
    private static <AnyType extends Comparable<? super AnyType>>
    void insertionSortInt( int [ ] a, int left, int right )
    {
        for( int p = left + 1; p <= right; p++ )
        {
            int tmp = a[ p ];
            int j;

            for( j = p; j > left && tmp < a[ j - 1 ]; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }
    /**
     * Internal insertion sort routine for subarrays
     * that is used by quicksort.
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void insertionSort( AnyType [ ] a, int left, int right )
    {
        for( int p = left + 1; p <= right; p++ )
        {
            AnyType tmp = a[ p ];
            int j;

            for( j = p; j > left && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }

}

