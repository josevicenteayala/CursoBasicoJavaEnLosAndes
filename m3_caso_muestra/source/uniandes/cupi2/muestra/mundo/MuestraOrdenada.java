/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelExtension.java,v 1.1 2006/07/31 16:43:19 da-romer Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co) 
 * Ejercicio: n7_muestra
 * Autor: Mario S�nchez - 05-Jul-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.muestra.mundo;

/**
 * Esta clase maneja una secuencia ordenada ascendentemente de valores enteros <br>
 * <b>inv: </b> <br>
 * valores != null <br>
 * valores.lenght > 0 <br>
 * los valores de la muestra est�n ordenados ascendentemente
 */
public class MuestraOrdenada
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Valores de la muestra
     */
    private int valores[];

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva muestra ordenada a partir de un conjunto de valores ordenados.
     * @param vals es el arreglo con los valores de la muestra - vals != null, vals.lenght > 0, los elementos est�n ordenados ascendentemente
     */
    public MuestraOrdenada( int[] vals )
    {
       valores = vals;
       //verificarInvariante( );
    }

    /**
     * Retorna el conjunto de valores del objeto
     * @return int[]
     */
    public int[] darValores() {
    	return valores;
    }
    
    
    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de valores que hay en la muestra
     * @return n�mero de valores de la muestra
     */
    public int darTamanio( )
    {
        return valores.length;
    }

    /**
     * Crea una copia de los valores de la muestra. <br>
     * El tama�o del arreglo retornado es valores.length
     * @return Los valores que hay actualmente en la muestra
     */
    public int[] darCopiaValores( )
    {
        int[] copiaValores = new int[valores.length];
        for( int i = 0; i < valores.length; i++ )
        {
            copiaValores[ i ] = valores[ i ];
        }
        return copiaValores;
    }

    /**
     * Cuenta el n�mero de veces que aparece un valor en la muestra ordenada
     * @param valor es el valor que se va a buscar en la muestra
     * @return N�mero de ocurrencias
     */
    public int contarOcurrencias( int valor )
    {
        int ocurrencias = 0;
        for( int i = 0; i < valores.length && valores[ i ] <= valor; i++ )
        {
            if( valores[ i ] == valor )
                ocurrencias++;
        }
        return ocurrencias;
    }

    /**
     * Cuenta el n�mero de valores distintos que hay en la muestra ordenada
     * @return N�mero de valores distintos
     */
    public int contarValoresDistintos( )
    {
        int valoresDistintos = 1;
        int ultimoValor = valores[ 0 ];
        for( int i = 0; i < valores.length; i++ )
        {
            if( valores[ i ] != ultimoValor )
            {
                ultimoValor = valores[ i ];
                valoresDistintos++;
            }
        }
        return valoresDistintos;
    }

    /**
     * Cuenta el n�mero de elementos que hay en un rango de valores (incluidos los extremos)
     * @param inf es el valor inferior del rango
     * @param sup es el valor superior del rango
     * @return N�mero de valores en el rango
     */
    public int contarElementosEnRango( int inf, int sup )
    {
        int numElementos = 0;
        for( int i = 0; i < valores.length && valores[ i ] <= sup; i++ )
        {
            if( valores[ i ] >= inf )
                numElementos++;
        }
        return numElementos;
    }

    /**
     * Retorna el valor m�s frecuente en la muestra. Si hay varios n�meros con la misma frecuencia, retorna el menor de ellos
     * @return Valor m�s frecuente.
     */
    public int darValorMasFrecuente( )
    {
        int valorMasFrecuente = -1;
        int numeroAparicionesMasFrecuente = 0;

        int valorActual = -1;
        int numeroAparicionesNumeroActual = 0;

        for( int i = 0; i < valores.length; i++ )
        {
            if( valores[ i ] != valorActual )
            {
                if( numeroAparicionesNumeroActual > numeroAparicionesMasFrecuente )
                {
                    numeroAparicionesMasFrecuente = numeroAparicionesNumeroActual;
                    valorMasFrecuente = valorActual;
                }
                valorActual = valores[ i ];
                numeroAparicionesNumeroActual = 0;
            }
            numeroAparicionesNumeroActual++;
        }
        // Contar las apariciones del �ltimo numero
        if( numeroAparicionesNumeroActual > numeroAparicionesMasFrecuente )
        {
            numeroAparicionesMasFrecuente = numeroAparicionesNumeroActual;
            valorMasFrecuente = valorActual;
        }
        return valorMasFrecuente;
    }

    /**
     * Busca un valor utilizando una b�squeda binaria
     * @param valor es el valor a buscar en el arreglo
     * @return Retorna true si encontr� el valor en la muestra o false de lo contrario.
     */
    public boolean buscarBinario( int valor )
    {
        boolean encontre = false;
        int inicio = 0;
        int fin = valores.length - 1;
        while( inicio <= fin && !encontre )
        {
            int medio = ( inicio + fin ) / 2;
            if( valores[ medio ] == valor )
            {
                encontre = true;
            }
            else if( valores[ medio ] > valor )
            {
                fin = medio - 1;
            }
            else
            {
                inicio = medio + 1;
            }
        }
        return encontre;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase <br>
     * <b>inv: </b> <br>
     * valores != null <br>
     * valores.lenght > 0 <br>
     * los valores de la muestra est�n ordenados ascendentemente
     */
    private void verificarInvariante( )
    {
        assert valores != null : "El arreglo de valores no puede ser null";
        assert valores.length > 0 : "Debe haber por lo menos un valor";
        // Verificar que los valores est�n ordenados
        for( int i = 1; i < valores.length; i++ )
        {
            assert valores[ i - 1 ] <= valores[ i ] : "Los valores deben estar ordenados";
        }
    }
}