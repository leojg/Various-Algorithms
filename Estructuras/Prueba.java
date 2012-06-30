/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Administrador
 */
public class Prueba {
     public static void main( String [ ] args )
    {
        ArbolAVL<Integer> t = new ArbolAVL<Integer> ( );
        final int NUMS = 4000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insertar( i );

        if( NUMS < 40 )
            t.imprimirArbolDesc();
        if( t.EncontrarMin() != 1 || t.EncontrarMax() != NUMS - 1 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 1; i < NUMS; i++ )
            if( !t.contiene( i ) )
               System.out.println( "Find error1!" );
    }
    
}
