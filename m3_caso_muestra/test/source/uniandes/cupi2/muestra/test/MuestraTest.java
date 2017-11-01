/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co) 
 * Ejercicio: n7_muestra
 * Autor: Jorge Villalobos - 05-sep-2005
 * Autor: Mario S�nchez    - 06-feb-2006
 * Autor: Mario S�nchez    - 28-feb-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.muestra.test;

import junit.framework.TestCase;
import uniandes.cupi2.muestra.mundo.Muestra;
import uniandes.cupi2.muestra.mundo.MuestraOrdenada;

/**
 * Esta es la clase usada para verificar que los m�todos de la clase Muestra est�n correctamente implementados
 */
public class MuestraTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se har�n las pruebas
     */
    private Muestra muestra;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye un escenario de pruebas en el cual hay una muestra vac�a, con 7 n�meros entre 0 y 100.
     */
    private void setupEscenario1( )
    {
        muestra = new Muestra( 7, 20 );
    }

    /**
     * Construye un escenario de pruebas en el cual hay una muestra con valores generados de forma aleatoria entre 0 y 100.
     */
    private void setupEscenario2( )
    {
        muestra = new Muestra( 100, 100 );
        muestra.generarValores( );
    }

    /**
     * Construye un escenario de pruebas en el cual hay una muestra cuyos elementos fueron determinados de forma precisa. <br>
     * La secuencia de n�meros es la siguiente: <br>
     * 0 9 1 8 2 7 2 3 6 4 1 5
     */
    private void setupEscenario3( )
    {
        muestra = new Muestra( 10, 99 );

        muestra.agregarDato( 31 );
        muestra.agregarDato( 85 );
        muestra.agregarDato( 44 );
        muestra.agregarDato( 21 );
        muestra.agregarDato( 67 );
        muestra.agregarDato( 11 );
        muestra.agregarDato( 29 );
        muestra.agregarDato( 98 );
        muestra.agregarDato( 55 );
        muestra.agregarDato( 50 );
    }

    /**
     * Construye un escenario de pruebas en el cual hay una muestra cuyos elementos fueron determinados de forma precisa y est�n ordenados. <br>
     * La secuencia de n�meros es la siguiente: <br>
     * 0 1 2 3 4 5 6 7 8 9 10
     */
    private void setupEscenario4( )
    {
        muestra = new Muestra( 11, 10 );

        muestra.agregarDato( 0 );
        muestra.agregarDato( 1 );
        muestra.agregarDato( 2 );
        muestra.agregarDato( 3 );
        muestra.agregarDato( 4 );
        muestra.agregarDato( 5 );
        muestra.agregarDato( 6 );
        muestra.agregarDato( 7 );
        muestra.agregarDato( 8 );
        muestra.agregarDato( 9 );
        muestra.agregarDato( 10 );
    }

    /**
     * Usando el escenario 1, verifica que la muestra se haya creado correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * Muestra (constructor), darLimiteSuperior, darCapacidad, darTamanio, darMaximo, darMinimo, darPromedio. <br>
     * <b> Objetivo: </b> Probar que el constructor Muestra() es capaz de crear una muestra vac�a, con la capacidad y l�mite superior dados. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al crear una muestra con l�mite superior X y pedir su l�mite superior se debe obtener X. <br>
     * 2. Al crear una muestra con capacidad Y y pedir su capacidad se debe obtener Y. <br>
     * 3. Al crear una muestra sin elementos y pedir su tama�o, �ste debe ser 0. <br>
     * 4. Al crear una muestra sin elementos y pedir su m�ximo, �ste debe ser 0. <br>
     * 5. Al crear una muestra sin elementos y pedir su m�nimo, �ste debe ser 0. <br>
     * 6. Al crear una muestra sin elementos y pedir su promedio, �ste debe ser 0.0.
     */
    public void testMuestra( )
    {
        setupEscenario1( );

        assertEquals( "El valor m�ximo para los valores de la muestra es incorrecto", 20, muestra.darLimiteSuperior( ) );
        assertEquals( "La capacidad de la muestra es incorrecta", 7, muestra.darCapacidad( ) );
        assertEquals( "El n�mero de valores generados es incorrecto", 0, muestra.darTamanio( ) );
        assertEquals( "El valor m�ximo es incorrecto", 0, muestra.darMaximo( ) );
        assertEquals( "El valor m�nimo es incorrecto", 0, muestra.darMinimo( ) );
        assertEquals( "El valor promedio es incorrecto", 0.0, muestra.darPromedio( ), 0.0 );
    }

    /**
     * Usando el escenario 1, verifica que los valores de la muestra se generen correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * Muestra (constructor), generarValores, darLimiteSuperior, darCapacidad, darTamanio. <br>
     * <b> Objetivo: </b> Probar que el m�todo generarValores() es capaz de generar los datos para la muestra correctamente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al crear una muestra con l�mite superior X y pedir su l�mite superior se debe obtener X. <br>
     * 2. Al crear una muestra con capacidad Y y pedir su capacidad se debe obtener Y. <br>
     * 3. Al generar los valores en una muestra y pedir su tama�o este debe ser igual a su capacidad.
     */
    public void testGenerarValores( )
    {
        setupEscenario1( );

        muestra.generarValores( );

        assertEquals( "El valor m�ximo para los valores de la muestra es incorrecto", 20, muestra.darLimiteSuperior( ) );
        assertEquals( "La capacidad de la muestra es incorrecta", 7, muestra.darCapacidad( ) );
        assertEquals( "El n�mero de valores generados es incorrecto", 7, muestra.darTamanio( ) );
    }

    /**
     * Usando el escenario 1, verifica la implementaci�n del m�todo agregarDato. <br>
     * Se agrega un nuevo dato y se verifica que el dato haya sido agregado al final de la muestra. <b> M�todos a probar: </b> <br>
     * AgregarDato, darLimiteSuperior, darCapacidad, darTamanio, darDato. <br>
     * <b> Objetivo: </b> Probar que el m�todo agregarDato() es capaz de incluir nuevos valores en la muestra. Puesto que la precondici�n del m�todo exige que exista espacio
     * en la muestra y que el valor se encuentre en el rango v�lido, no es mucho lo que se debe probar.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al agregar un dato a la muestra su l�mite superior no debe cambiar. <br>
     * 2. Al agregar un dato a la muestra su capacidad no debe cambiar. <br>
     * 3. Al agregar un dato a la muestra su tama�o no debe cambiar. <br>
     * 3. Al agregar un dato a la muestra �ste debe quedar en la �ltima posici�n.
     */
    public void testAgregarDato( )
    {
        setupEscenario1( );

        muestra.agregarDato( 12 );

        assertEquals( "El valor m�ximo para los valores de la muestra es incorrecto", 20, muestra.darLimiteSuperior( ) );
        assertEquals( "La capacidad de la muestra es incorrecta", 7, muestra.darCapacidad( ) );
        assertEquals( "El n�mero de valores en la muestra es incorrecto", 1, muestra.darTamanio( ) );
        assertEquals( "El elemento no se agreg� correctamente", 12, muestra.darDato( muestra.darTamanio( ) - 1 ) );

        muestra.agregarDato( 5 );

        assertEquals( "El valor m�ximo para los valores de la muestra es incorrecto", 20, muestra.darLimiteSuperior( ) );
        assertEquals( "La capacidad de la muestra es incorrecta", 7, muestra.darCapacidad( ) );
        assertEquals( "El n�mero de valores en la muestra es incorrecto", 2, muestra.darTamanio( ) );
        assertEquals( "El elemento no se agreg� correctamente", 5, muestra.darDato( muestra.darTamanio( ) - 1 ) );

        muestra.agregarDato( 7 );

        assertEquals( "El valor m�ximo para los valores de la muestra es incorrecto", 20, muestra.darLimiteSuperior( ) );
        assertEquals( "La capacidad de la muestra es incorrecta", 7, muestra.darCapacidad( ) );
        assertEquals( "El n�mero de valores en la muestra es incorrecto", 3, muestra.darTamanio( ) );
        assertEquals( "El elemento no se agreg� correctamente", 7, muestra.darDato( muestra.darTamanio( ) - 1 ) );

        muestra.agregarDato( 1 );

        assertEquals( "El valor m�ximo para los valores de la muestra es incorrecto", 20, muestra.darLimiteSuperior( ) );
        assertEquals( "La capacidad de la muestra es incorrecta", 7, muestra.darCapacidad( ) );
        assertEquals( "El n�mero de valores en la muestra es incorrecto", 4, muestra.darTamanio( ) );
        assertEquals( "El elemento no se agreg� correctamente", 1, muestra.darDato( muestra.darTamanio( ) - 1 ) );

        muestra.agregarDato( 10 );

        assertEquals( "El valor m�ximo para los valores de la muestra es incorrecto", 20, muestra.darLimiteSuperior( ) );
        assertEquals( "La capacidad de la muestra es incorrecta", 7, muestra.darCapacidad( ) );
        assertEquals( "El n�mero de valores en la muestra es incorrecto", 5, muestra.darTamanio( ) );
        assertEquals( "El elemento no se agreg� correctamente", 10, muestra.darDato( muestra.darTamanio( ) - 1 ) );

        muestra.agregarDato( 1 );

        assertEquals( "El valor m�ximo para los valores de la muestra es incorrecto", 20, muestra.darLimiteSuperior( ) );
        assertEquals( "La capacidad de la muestra es incorrecta", 7, muestra.darCapacidad( ) );
        assertEquals( "El n�mero de valores en la muestra es incorrecto", 6, muestra.darTamanio( ) );
        assertEquals( "El elemento no se agreg� correctamente", 1, muestra.darDato( muestra.darTamanio( ) - 1 ) );

        muestra.agregarDato( 19 );

        assertEquals( "El valor m�ximo para los valores de la muestra es incorrecto", 20, muestra.darLimiteSuperior( ) );
        assertEquals( "La capacidad de la muestra es incorrecta", 7, muestra.darCapacidad( ) );
        assertEquals( "El n�mero de valores en la muestra es incorrecto", 7, muestra.darTamanio( ) );
        assertEquals( "El elemento no se agreg� correctamente", 19, muestra.darDato( muestra.darTamanio( ) - 1 ) );

    }

    /**
     * Usando el escenario 2, verifica que el algoritmo de burbuja ordene los valores correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * ordenarBurbuja. <br>
     * <b> Objetivo: </b> Probar que el m�todo ordenarBurbuja() ordena de manera correcta la muestra. Aqu� no hay forma de verificar que el m�todo haya aplicado la t�cnica de
     * ordenamiento por burbuja. S�lo se puede comprobar que al final se haya creado una muestra ordenada correcta con los mismos valores de la muestra original.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al aplicar el algoritmo los valores deben estar ordenados. <br>
     * 2. Al aplicar el algoritmo los valores deben seguir siendo los mismos valores iniciales.
     */
    public void testOrdenarBurbuja( )
    {
        setupEscenario2( );

        // Crear una copia de la muestra desordenada
        int[] valoresDesordenados = muestra.darCopiaValores( );

        // Ordenar los valores
        MuestraOrdenada muestraOrdenada = muestra.ordenarBurbuja( );
        int[] valoresOrdenados = muestraOrdenada.darCopiaValores( );

        // Comparar la muestra original y la copia desordenada para saber si tienen los mismos elementos (son permutaciones del mismo conjunto)
        boolean permutacion = sonPermutacion( muestra.darLimiteSuperior( ), valoresOrdenados, valoresDesordenados );
        assertTrue( "La muestra ordenada no tiene los mismos elementos que la muestra desordenada", permutacion );
    }

    /**
     * Usando el escenario 2, verifica que el algoritmo de selecci�n ordene los valores correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * ordenarSeleccion. <br>
     * <b> Objetivo: </b> Probar que el m�todo ordenarSeleccion() ordena de manera correcta la muestra. Aqu� no hay forma de verificar que el m�todo haya aplicado la t�cnica
     * de ordenamiento por selecci�n. S�lo se puede comprobar que al final se haya creado una muestra ordenada correcta con los mismos valores de la muestra original.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al aplicar el algoritmo los valores deben estar ordenados. <br>
     * 2. Al aplicar el algoritmo los valores deben seguir siendo los mismos valores iniciales.
     */
    public void testOrdenarSeleccion( )
    {
        setupEscenario2( );

        // Crear una copia de la muestra desordenada
        int[] valoresDesordenados = muestra.darCopiaValores( );

        // Ordenar los valores
        MuestraOrdenada muestraOrdenada = muestra.ordenarSeleccion( );
        int[] valoresOrdenados = muestraOrdenada.darCopiaValores( );

        // Comparar la muestra original y la copia desordenada para saber si tienen los mismos elementos (son permutaciones del mismo conjunto)
        boolean permutacion = sonPermutacion( muestra.darLimiteSuperior( ), valoresOrdenados, valoresDesordenados );
        assertTrue( "La muestra ordenada no tiene los mismos elementos que la muestra desordenada", permutacion );
    }

    /**
     * Usando el escenario 2, verifica que el algoritmo de inserci�n ordene los valores correctamente. <br>
     * <b> M�todos a probar: </b> <br>
     * ordenarInsercion. <br>
     * <b> Objetivo: </b> Probar que el m�todo ordenarInsercion() ordena de manera correcta la muestra. Aqu� no hay forma de verificar que el m�todo haya aplicado la t�cnica
     * de ordenamiento por inserci�n. S�lo se puede comprobar que al final se haya creado una muestra ordenada correcta con los mismos valores de la muestra original.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al aplicar el algoritmo los valores deben estar ordenados. <br>
     * 2. Al aplicar el algoritmo los valores deben seguir siendo los mismos valores iniciales.
     */
    public void testOrdenarInsercion( )
    {
        setupEscenario2( );

        // Crear una copia de la muestra desordenada
        int[] valoresDesordenados = muestra.darCopiaValores( );

        // Ordenar los valores
        MuestraOrdenada muestraOrdenada = muestra.ordenarInsercion( );
        int[] valoresOrdenados = muestraOrdenada.darCopiaValores( );

        // Comparar la muestra original y la copia desordenada para saber si tienen los mismos elementos (son permutaciones del mismo conjunto)
        boolean permutacion = sonPermutacion( muestra.darLimiteSuperior( ), valoresOrdenados, valoresDesordenados );
        assertTrue( "La muestra ordenada no tiene los mismos elementos que la muestra desordenada", permutacion );
    }

    /**
     * Verifica el m�todo para realizar la b�squeda secuencial usando el escenario 3.<br>
     * Para verificar el m�todo se buscar�n valores que se sabe que est�n dentro de la muestra. <br>
     * <b> M�todos a probar: </b> <br>
     * buscarSecuencial. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarSecuencial() es capaz de localizar los elementos presentes en la muestra.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un elemento existente en la muestra �ste debe ser encontrado.
     */
    public void testBuscarSecuencial1( )
    {
        setupEscenario3( );

        assertTrue( "Se debi� encontrar el valor", muestra.buscarSecuencial( 31 ) );
        assertTrue( "Se debi� encontrar el valor", muestra.buscarSecuencial( 50 ) );
        assertTrue( "Se debi� encontrar el valor", muestra.buscarSecuencial( 11 ) );
        assertTrue( "Se debi� encontrar el valor", muestra.buscarSecuencial( 55 ) );
        assertTrue( "Se debi� encontrar el valor", muestra.buscarSecuencial( 29 ) );
    }

    /**
     * Verifica el m�todo para realizar la b�squeda secuencial usando el escenario 3.<br>
     * Para verificar el m�todo se buscar�n valores que se sabe que NO est�n dentro de la muestra. <b> M�todos a probar: </b> <br>
     * buscarSecuencial. <br>
     * <b> Objetivo: </b> Probar que el m�todo buscarSecuencial() es capaz de localizar los elementos presentes en la muestra.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un elemento que no existe en la muestra �ste no debe ser encontrado.
     */
    public void testBuscarSecuencial2( )
    {
        setupEscenario3( );

        assertFalse( "No debi� encontrarse el valor", muestra.buscarSecuencial( 10 ) );
        assertFalse( "No debi� encontrarse el valor", muestra.buscarSecuencial( 111 ) );
        assertFalse( "No debi� encontrarse el valor", muestra.buscarSecuencial( -1 ) );
    }

    /**
     * Verifica el m�todo darMaximo usando el escenario 3, en el que los valores est�n desordenados. <br>
     * Para realizar la prueba se invoca el m�todo y se verifica que la respuesta coincida con el valor esperado. <b> M�todos a probar: </b> <br>
     * darMaximo. <br>
     * <b> Objetivo: </b> Probar que el m�todo darMaximo() retorne el elemento m�s grande de la muestra.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el valor m�s grande de la muestra es X. Al pedir el valor m�ximo de la muestra este debe ser igual a X.
     */
    public void testDarMaximo1( )
    {
        setupEscenario3( );
        assertEquals( "El valor m�ximo no es el esperado", 98, muestra.darMaximo( ) );
    }

    /**
     * Verifica el m�todo darMaximo usando el escenario 4, en el que los valores est�n ordenados. <br>
     * Para realizar la prueba se invoca el m�todo y se verifica que la respuesta coincida con el valor esperado. <b> M�todos a probar: </b> <br>
     * darMaximo. <br>
     * <b> Objetivo: </b> Probar que el m�todo darMaximo() retorne el elemento m�s grande de la muestra.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el valor m�s grande de la muestra es X. Al pedir el valor m�ximo de la muestra este debe ser igual a X.
     */
    public void testDarMaximo2( )
    {
        setupEscenario4( );
        assertEquals( "El valor m�ximo no es el esperado", 10, muestra.darMaximo( ) );
    }

    /**
     * Verifica el m�todo darMinimo usando el escenario 3, en el que los valores est�n desordenados. <br>
     * Para realizar la prueba se invoca el m�todo y se verifica que la respuesta coincida con el valor esperado. <b> M�todos a probar: </b> <br>
     * darMinimo. <br>
     * <b> Objetivo: </b> Probar que el m�todo darMinimo() retorne el elemento m�s peque�o de la muestra.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el valor m�s peque�o de la muestra es X. Al pedir el valor m�nimo de la muestra este debe ser igual a X.
     */
    public void testDarMinimo1( )
    {
        setupEscenario3( );
        assertEquals( "El valor m�nimo no es el esperado", 11, muestra.darMinimo( ) );
    }

    /**
     * Verifica el m�todo darMinimo usando el escenario 4, en el que los valores est�n ordenados. <br>
     * Para realizar la prueba se invoca el m�todo y se verifica que la respuesta coincida con el valor esperado. <b> M�todos a probar: </b> <br>
     * darMinimo. <br>
     * <b> Objetivo: </b> Probar que el m�todo darMinimo() retorne el elemento m�s peque�o de la muestra.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el valor m�s peque�o de la muestra es X. Al pedir el valor m�nimo de la muestra este debe ser igual a X.
     */
    public void testDarMinimo2( )
    {
        setupEscenario4( );
        assertEquals( "El valor m�nimo no es el esperado", 0, muestra.darMinimo( ) );
    }

    /**
     * Verifica el m�todo darPromedio usando el escenario 3.<br>
     * Para realizar la prueba se invoca el m�todo y se verifica que la respuesta coincida con el valor esperado. <b> M�todos a probar: </b> <br>
     * darPromedio. <br>
     * <b> Objetivo: </b> Probar que el m�todo darPromedio() retorne el promedio de la muestra de forma correcta.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el valor del promedio es X. Al pedir el valor promedio de la muestra este debe ser igual a X.
     */
    public void testDarPromedio( )
    {
        setupEscenario3( );

        double promedio = ( 491.0 / 10.0 );
        assertEquals( "El valor promedio no es el esperado", promedio, muestra.darPromedio( ), 0 );
    }

    /**
     * Permite ordenar una lista de forma ascendente mediante el metodo de Burbuja
     */
    public void testOrdenarBurbujaDescendente() {
        setupEscenario3( );
        MuestraOrdenada muestraOrdenada = muestra.ordenarBurbujaDescendente();
        int valores[] = muestraOrdenada.darValores();
        for (int i = 0; i < valores.length; i++) {
			System.out.println(valores[i]);
		}
		assertTrue( "Se esperaba un arreglo ordenado.", valores != null );    	
    }  
    
    /**
     * Prueba el metodo darParesArreglo
     */
    public void testDarParesArreglo() {
    	setupEscenario3( );
    	int[] darParesArreglo = muestra.darParesArreglo();
    	for (int i = 0; i < darParesArreglo.length; i++) {
    		System.out.println(darParesArreglo[i]);	
		}
    	
    }
    
    /**
     * Permtie mostrar la lista ordenada de los pares en forma ascendente
     */
    public void testOrdenarParesSeleccionDescendente() {
	    	setupEscenario3( );
	    	MuestraOrdenada muestraOrdenada = muestra.ordenarParesSeleccionDescendente();
	    	int[] darParesArreglo = muestraOrdenada.darCopiaValores();
	    	for (int i = 0; i < darParesArreglo.length; i++) {
	    		System.out.println(darParesArreglo[i]);	
		}    	
    }
    
    /**
     * Permtie mostrar la lista ordenada de los pares en forma ascendente
     */
    public void testDarMenorParArreglo() {
    	setupEscenario3( );
    	System.out.println("EL MENOR NUMERO PAR ES: "+muestra.darMenorParArreglo());    	
    }    
    
    /**
     * prueba el ordenamiento descendente mendiante el metodo de Insercion
     */
    public void testOrdenarInsercionDescendente() {
    		setupEscenario3( );
    		MuestraOrdenada muestraOrdenada = muestra.ordenarInsercionDescendente();
    		int[] arregloValores = muestraOrdenada.darCopiaValores();
    		System.out.println("Lista ordenada por metodo insercion de manera ascendente.");
	    	for (int i = 0; i < arregloValores.length; i++) {
	    		System.out.println(arregloValores[i]);	
		}     		
    		
    }
    
    /**
     * permite hacer busqueda binaria
     */
    public void testBuscarBinarioDesc() {
    		setupEscenario3( );
    		boolean datoEncontrado = muestra.buscarBinarioDesc(98);
    		System.out.println("El dato fue encontrado "+datoEncontrado);
    }
    
    /**
     * obtiene la mediana de un arreglo ordenado
     */
    public void testObtenerMedianaMuestra() {
		setupEscenario3( );
		double mediana = muestra.obtenerMedianaMuestra();
		System.out.println("Mediana "+mediana);
    }
    
    
    // -----------------------------------------------------------------
    // M�todos Auxiliares
    // -----------------------------------------------------------------
    /**
     * Informa si una pareja de arreglos son permutaciones del mismo conjunto. <br>
     * Para que sean permutaciones es necesario que tengan los mismos valores y que cada valor aparezca exactamente la misma cantidad de veces en los dos arreglos.
     * @param limite El valor m�ximo que puede haber en cualquiera de los dos arreglos. limite > 0
     * @param valores1 Primer arreglo de valores. valores1 != null && todos los elementos del arreglo son menores a limite
     * @param valores2 Segundo arreglo de valores. valores2 != null && todos los elementos del arreglo son menores a limite
     * @return Retorna true si los arreglos son permutaciones del mismo conjunto.
     */
    private boolean sonPermutacion( int limite, int[] valores1, int[] valores2 )
    {
        int[] frecuencias1 = darFrecuencia( limite, valores1 );
        int[] frecuencias2 = darFrecuencia( limite, valores2 );

        boolean sonPermutacion = true;

        for( int i = 0; i < frecuencias1.length && sonPermutacion; i++ )
        {
            if( frecuencias1[ i ] != frecuencias2[ i ] )
                sonPermutacion = false;
        }

        return sonPermutacion;
    }

    /**
     * Calcula la frecuencia con la que aparece cada n�mero dentro de la muestra.
     * @param limite El n�mero m�s grande que podr�a encontrarse en la muestra. limite > 0
     * @param valores El arreglo con los valores. valores != null
     * @return Retorna un arreglo con las frecuencias. En la i-esima posici�n del arreglo se encuentra el n�mero de veces que aparece el n�mero i en la muestra.
     */
    private int[] darFrecuencia( int limite, int[] valores )
    {
        int[] frecuencias = new int[limite + 1];

        for( int i = 0; i < valores.length; i++ )
        {
            int valor = valores[ i ];
            frecuencias[ valor ]++;
        }

        return frecuencias;
    }
}