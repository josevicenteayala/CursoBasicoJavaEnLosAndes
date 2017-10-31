/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: MuestraOrdenadaTest.java,v 1.6 2006/08/03 16:30:30 da-romer Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_muestra
 * Autor: Mario S�nchez - 05-Jul-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.muestra.test;

import junit.framework.TestCase;
import uniandes.cupi2.muestra.mundo.MuestraOrdenada;

/**
 * Esta es la clase usada para verificar que los m�todos de la clase MuestraOrdenada est�n correctamente implementados
 */
public class MuestraOrdenadaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se har�n las pruebas
     */
    private MuestraOrdenada muestraOrdenada;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye un escenario de pruebas en el cual hay una muestra cuyos elementos fueron determinados de forma precisa y est�n ordenados. <br>
     * La secuencia de n�meros es la siguiente: <br>
     * 0 1 2 3 4 5 6 7 8 9 10
     */
    private void setupEscenario1( )
    {
        int[] valoresOrdenados = new int[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        muestraOrdenada = new MuestraOrdenada( valoresOrdenados );
    }

    /**
     * Construye un escenario de pruebas en el cual hay una muestra cuyos elementos fueron determinados de forma precisa y que se encuentran ordenados <br>
     * La secuencia de n�meros es la siguiente: <br>
     * 0 1 1 2 2 3 4 5 6 7 8 9
     */
    private void setupEscenario2( )
    {
        int[] valoresOrdenados = new int[]{ 0, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9 };
        muestraOrdenada = new MuestraOrdenada( valoresOrdenados );
    }

    /**
     * Verifica que la muestra se haya creado correctamente <b> M�todos a probar: </b> <br>
     * MuestraOrdenada (constructor), darCopiaValores. <br>
     * <b> Objetivo: </b> Probar que el constructor MuestraOrdenada() es capaz de crear una muestra correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al crear una muestra ordenada y revisar sus elementos, estos deben estar ordenados.
     */
    public void testMuestraOrdenada( )
    {
        setupEscenario1( );

        assertEquals( "El n�mero de valores en la muestra no es el esperado", 11, muestraOrdenada.darTamanio( ) );

        int[] valores = muestraOrdenada.darCopiaValores( );
        for( int i = 0; i < muestraOrdenada.darTamanio( ); i++ )
        {
            assertEquals( "El n�mero en la posici�n no es el esperado", i, valores[ i ] );
        }
    }

    /**
     * Verifica el m�todo para realizar la b�squeda binaria usando el escenario 1.<br>
     * Para verificar el m�todo se buscar�n valores que se sabe que est�n dentro de la muestra.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarBinario. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarBinario() es capaz de localizar los elementos presentes en la muestra.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un elemento existente en la muestra �ste debe ser encontrado.
     */
    public void testBuscarBinario1( )
    {
        setupEscenario1( );

        assertTrue( "Se debi� encontrar el valor", muestraOrdenada.buscarBinario( 0 ) );
        assertTrue( "Se debi� encontrar el valor", muestraOrdenada.buscarBinario( 3 ) );
        assertTrue( "Se debi� encontrar el valor", muestraOrdenada.buscarBinario( 5 ) );
        assertTrue( "Se debi� encontrar el valor", muestraOrdenada.buscarBinario( 8 ) );
        assertTrue( "Se debi� encontrar el valor", muestraOrdenada.buscarBinario( 10 ) );
    }

    /**
     * Verifica el m�todo para realizar la b�squeda binaria usando el escenario 1.<br>
     * Para verificar el m�todo se buscar�n valores que se sabe que NO est�n dentro de la muestra. <b> M�todos a probar: </b> <br>
     * buscarBinario. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarBinario() es capaz de localizar los elementos presentes en la muestra.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un elemento que no existe en la muestra �ste no debe ser encontrado.
     */
    public void testBuscarBinario2( )
    {
        setupEscenario1( );

        assertFalse( "No debi� encontrarse el valor", muestraOrdenada.buscarBinario( 11 ) );
        assertFalse( "No debi� encontrarse el valor", muestraOrdenada.buscarBinario( 15 ) );
        assertFalse( "No debi� encontrarse el valor", muestraOrdenada.buscarBinario( -1 ) );
    }

    /**
     * Verifica el m�todo contarElementosEnRango usando el escenario 2.<br>
     * Para realizar la prueba se invoca el m�todo y se verifica que la respuesta coincida con el valor esperado. <b> M�todos a probar: </b> <br>
     * contarElementosEnRango. <br>
     * <b> Objetivo: </b> Probar que el m�todo contarElementosEnRango() es capaz de calcular correctamente el n�mero de elementos que existen en el rango dado dentro de la
     * muestra.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el n�mero de elementos que tiene la muestra en el rango [a, b] es X. Al pedir el n�mero de elementos existente en el rango [a, b] el valor retornado debe
     * ser X.
     */
    public void testContarElementosEnRango( )
    {
        setupEscenario2( );

        assertEquals( "El valor calculado est� equivocado", 12, muestraOrdenada.contarElementosEnRango( 0, 9 ) );
        assertEquals( "El valor calculado est� equivocado", 10, muestraOrdenada.contarElementosEnRango( 1, 8 ) );
        assertEquals( "El valor calculado est� equivocado", 12, muestraOrdenada.contarElementosEnRango( 0, 25 ) );
    }

    /**
     * Verifica el m�todo contarOcurrencias usando el escenario 4.<br>
     * Para realizar la prueba se invoca el m�todo y se verifica que la respuesta coincida con el valor esperado. <b> M�todos a probar: </b> <br>
     * contarOcurrencias. <br>
     * <b> Objetivo: </b> Probar que el m�todo contarOcurrencias() es capaz de calcular correctamente el n�mero de veces que aparece un elemento dado dentro de la muestra.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el n�mero de ocurrencias del elemento Y en la muestra es X. Al pedir el n�mero de ocurrencias de Y el valor retornado debe ser X.
     */
    public void testContarOcurrencias( )
    {
        setupEscenario2( );

        assertEquals( "El valor calculado est� equivocado", 1, muestraOrdenada.contarOcurrencias( 0 ) );
        assertEquals( "El valor calculado est� equivocado", 2, muestraOrdenada.contarOcurrencias( 1 ) );
        assertEquals( "El valor calculado est� equivocado", 1, muestraOrdenada.contarOcurrencias( 9 ) );
        assertEquals( "El valor calculado est� equivocado", 0, muestraOrdenada.contarOcurrencias( 14 ) );
    }

    /**
     * Verifica el m�todo contarValoresDistintos usando el escenario 2.<br>
     * Para realizar la prueba se invoca el m�todo y se verifica que la respuesta coincida con el valor esperado. <b> M�todos a probar: </b> <br>
     * contarValoresDistintos. <br>
     * <b> Objetivo: </b> Probar que el m�todo contarValoresDistintos() es capaz de calcular correctamente el n�mero de valores diferentes que hay en la muestra.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el n�mero de valores distintos en la muestra es X. Al pedir el n�mero de valores distintos el valor retornado debe ser X.
     */
    public void testContarValoresDistintos( )
    {
        setupEscenario2( );

        assertEquals( "El valor calculado est� equivocado", 10, muestraOrdenada.contarValoresDistintos( ) );
    }

    /**
     * Verifica el m�todo darValorMasFrecuente usando el escenario 2.<br>
     * Para realizar la prueba se invoca el m�todo y se verifica que la respuesta coincida con el valor esperado. <b> M�todos a probar: </b> <br>
     * darValorMasFrecuente. <br>
     * <b> Objetivo: </b> Probar que el m�todo darValorMasFrecuente() es capaz de dar correctamente el valor que m�s veces aparece en la muestra.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el valor m�s frecuente es X. Al pedir el valor m�s frecuente se debe obtener X.
     */
    public void testDarValorMasFrecuente( )
    {
        setupEscenario2( );
        assertEquals( "El valor m�s frecuente no es el esperado", 1, muestraOrdenada.darValorMasFrecuente( ) );
    }

}