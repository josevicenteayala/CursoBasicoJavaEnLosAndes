/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PerroTest.java,v 1.3 2006/08/04 15:12:57 da-romer Exp $ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_exposicionCanina 
 * Autor: Mario S�nchez - 10/02/2006 
 * Modificado por: Daniel Romero- 30/06/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.exposicionCanina.test;

import junit.framework.TestCase;
import uniandes.cupi2.exposicionCanina.mundo.Perro;

/**
 * Esta es la clase usada para verificar los m�todos de la clase Perro
 */
public class PerroTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Perro usado para los casos de prueba
     */
    private Perro perro1;

    /**
     * Perro usado para los casos de prueba
     */
    private Perro perro2;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye los perros 1 y 2
     */
    private void setupEscenario1( )
    {
        perro1 = new Perro( "nombre1", "raza1", "imagen1", 1, 1 );
        perro2 = new Perro( "nombre2", "raza2", "imagen2", 2, 2 );
    }

    /**
     * Verifica el constructor. <br>
     * <b> M�todos a probar: </b> <br>
     * Perro (constructor). <br>
     * <b> Objetivo: </b> Probar que el constructor crea un perro de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al crear un perro los atributos del objeto deben quedar con el valor correcto.
     */
    public void testPerro( )
    {
        setupEscenario1( );

        assertEquals( "El nombre del perro est� equivocado", "nombre1", perro1.darNombre( ) );
        assertEquals( "La raza del perro est� equivocada", "raza1", perro1.darRaza( ) );
        assertEquals( "La imagen del perro est� equivocada", "imagen1", perro1.darImagen( ) );
        assertEquals( "La edad del perro est� equivocada", 1, perro1.darEdad( ) );
        assertEquals( "La altura del perro est� equivocada", 1, perro1.darPuntos( ) );
    }

    /**
     * Verifica el m�todo compararPorPuntos. <br>
     * <b> M�todos a probar: </b> <br>
     * compararPorPuntos. <br>
     * <b> Objetivo: </b> Probar que el m�todo compararPorPuntos realiza la comparaci�n de dos perros de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comparar un perro cuyos puntos sean menores a los de otro el resultado debe ser -1. <br>
     * 2. Al comparar un perro cuyos puntos sean iguales a los de otro el resultado debe ser 0. <br>
     * 3. Al comparar un perro cuyos puntos sean mayores a los de otro el resultado debe ser 1.
     */
    public void testCompararPorPuntos( )
    {
        setupEscenario1( );

        assertEquals( "El perro 1 deber�a ser menor", -1, perro1.compararPorPuntos( perro2 ) );
        assertEquals( "El perro 1 y el perro 1 deber�an ser iguales", 0, perro1.compararPorPuntos( perro1 ) );
        assertEquals( "El perro 2 deber�a ser mayor", 1, perro2.compararPorPuntos( perro1 ) );
    }

    /**
     * Verifica el m�todo compararPorEdad. <br>
     * <b> M�todos a probar: </b> <br>
     * compararPorEdad. <br>
     * <b> Objetivo: </b> Probar que el m�todo compararPorEdad realiza la comparaci�n de dos perros de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comparar un perro cuya edad sea menor a la de otro el resultado debe ser -1. <br>
     * 2. Al comparar un perro cuya edad sea igual a la de otro el resultado debe ser 0. <br>
     * 3. Al comparar un perro cuya edad sea mayor a la de otro el resultado debe ser 1.
     */
    public void testCompararPorEdad( )
    {
        setupEscenario1( );

        assertEquals( "El perro 1 deber�a ser menor", -1, perro1.compararPorEdad( perro2 ) );
        assertEquals( "El perro 1 y el perro 1 deber�an ser iguales", 0, perro1.compararPorEdad( perro1 ) );
        assertEquals( "El perro 2 deber�a ser mayor", 1, perro2.compararPorEdad( perro1 ) );
    }

    /**
     * Verifica el m�todo compararPorNombre. <br>
     * <b> M�todos a probar: </b> <br>
     * compararPorNombre. <br>
     * <b> Objetivo: </b> Probar que el m�todo compararPorNombre realiza la comparaci�n de dos perros de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comparar un perro cuyo nombre sea menor a la de otro el resultado debe ser -1. <br>
     * 2. Al comparar un perro cuyo nombre sea igual a la de otro el resultado debe ser 0. <br>
     * 3. Al comparar un perro cuyo nombre sea mayor a la de otro el resultado debe ser 1.
     */
    public void testCompararPorNombre( )
    {
        setupEscenario1( );

        assertEquals( "El perro 1 deber�a ser menor", -1, perro1.compararPorNombre( perro2 ) );
        assertEquals( "El perro 1 y el perro 1 deber�an ser iguales", 0, perro1.compararPorNombre( perro1 ) );
        assertEquals( "El perro 2 deber�a ser mayor", 1, perro2.compararPorNombre( perro1 ) );
    }

    /**
     * Verifica el m�todo compararPorRaza. <br>
     * <b> M�todos a probar: </b> <br>
     * compararPorRaza. <br>
     * <b> Objetivo: </b> Probar que el m�todo compararPorRaza realiza la comparaci�n de dos perros de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comparar un perro cuya raza sea menor a la de otro el resultado debe ser -1. <br>
     * 2. Al comparar un perro cuya raza sea igual a la de otro el resultado debe ser 0. <br>
     * 3. Al comparar un perro cuya raza sea mayor a la de otro el resultado debe ser 1.
     */
    public void testCompararPorRaza( )
    {
        setupEscenario1( );

        assertEquals( "El perro 1 deber�a ser menor", -1, perro1.compararPorRaza( perro2 ) );
        assertEquals( "El perro 1 y el perro 1 deber�an ser iguales", 0, perro1.compararPorRaza( perro1 ) );
        assertEquals( "El perro 2 deber�a ser mayor", 1, perro2.compararPorRaza( perro1 ) );
    }
}
