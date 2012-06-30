/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Administrador
 */
class Arco {
    
    Vertice destino;   // Segundo 
    int costo;   // costo de la arista, 1 si es sin pesos
    
    Arco( Vertice d, int c )
    {
        destino = d;
        costo = c;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Arco)
        {
            Arco a = (Arco) o;
            if(a.destino.equals(destino) && a.costo == costo)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    @Override
    //codigo generado
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.destino != null ? this.destino.hashCode() : 0);
        hash = 73 * hash + this.costo;
        return hash;
    }
}
  
