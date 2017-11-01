/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ExposicionPerrosTest.java,v 1.6 2009/01/30 18:49:11 ju-cort1 Exp $ 
 * Universidad de los Andes (Bogota - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_exposicionCanina 
 * Autor: Mario Sánchez - 29/08/2005 
 * Modificado por: Daniel Romero- 30/06/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.exposicionCanina.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import junit.framework.TestCase;
import uniandes.cupi2.exposicionCanina.mundo.ExposicionPerros;
import uniandes.cupi2.exposicionCanina.mundo.Perro;

/**
 * Es la clase de pruebas para la clase ExposicionPerros
 */
public class ExposicionPerrosTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la exposición sobre la que se van a realizar las pruebas
     */
    private ExposicionPerros exposicion;

    /**
     * La cantidad de perros que hay en la exposición.
     */
    private int cantidadPerros;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Crea una exposición a partir del archivo perros1.txt
     */
    private void setupEscenario1( )
    {
        exposicion = new ExposicionPerros( );
        cargarPerros( "./test/data/perros1.txt" );

    }

    /**
     * Crea una exposición a partir del archivo perros2.txt
     */
    private void setupEscenario2( )
    {
        exposicion = new ExposicionPerros( );
        cargarPerros( "./test/data/perros2.txt" );

    }

    /**
     * Crea una exposición vacía
     */
    private void setupEscenario3( )
    {
        exposicion = new ExposicionPerros( );
        cantidadPerros = 0;
    }

    /**
     * Verifica el método agregarPerro agregando correctamente un perro. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarPerro, buscarPerro, darPerros. <br>
     * <b> Objetivo: </b> Probar que el método agregarPerro() sea capaz de registrar un perro en la exposición. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar (por nombre) un perro previamente agregado se debe obtener una posición diferente de -1 (se debe encontrar) y los datos del perro en esa posición deben
     * corresponder a los del perro con el nombre correspondiente. <br>
     */
    public void testAgregarPerro1( )
    {
        // Configura los datos de prueba
        setupEscenario3( );

        String nombre;
        String raza;
        String imagen;
        int edad;
        int puntos;
        boolean agregado;
        // Agrega un perro y luego verifica que se haya agregado de forma correcta
        for( int cont = 1; cont <= cantidadPerros; cont++ )
        {
            nombre = "nombre" + cont;
            raza = "raza" + cont;
            imagen = "imagen" + cont;
            edad = cont;
            puntos = cont;

            agregado = exposicion.agregarPerro( nombre, raza, imagen, edad, puntos );
            int pos = exposicion.buscarPerro( nombre );
            Perro perro = ( Perro )exposicion.darPerros( ).get( pos );

            assertTrue( "El perro no se agregó de forma correcta", agregado );
            assertEquals( "El perro no se agregó de forma correcta", cont - 1, pos );
            assertEquals( "El perro no se agregó de forma correcta", nombre, perro.darNombre( ) );
            assertEquals( "El perro no se agregó de forma correcta", raza, perro.darRaza( ) );
            assertEquals( "El perro no se agregó de forma correcta", imagen, perro.darImagen( ) );
            assertEquals( "El perro no se agregó de forma correcta", edad, perro.darEdad( ) );
            assertEquals( "El perro no se agregó de forma correcta", puntos, perro.darPuntos( ) );
        }
    }

    /**
     * Verifica el método agregarPerro agregando un perro con nombre repetido. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarPerro, buscarPerro, darPerros. <br>
     * <b> Objetivo: </b> Probar que el método agregarPerro() no agregue un perro en la exposición cuando su nombre ya pertenece a otro perro registrado. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al agregar un perro con nombre repetido el número de perros se debe mantener igual y la información de los perros existentes no debe haberse alterado.
     */
    public void testAgregarPerro2( )
    {
        // Configura los datos de prueba
        setupEscenario1( );

        ArrayList perros = exposicion.darPerros( );
        Perro p = ( Perro )perros.get( 0 );
        String nombrePerro = p.darNombre( );

        int i = Integer.parseInt( nombrePerro );
        boolean agregado = exposicion.agregarPerro( nombrePerro, nombrePerro, nombrePerro, i, i );
        assertFalse( "El perro no debería haberse agregado", agregado );

        String nombre;
        String raza;
        String imagen;
        int edad;
        int puntos;
        // Busca un perro y verifica que sus datos estén correctos
        for( int cont = 0; cont < cantidadPerros; cont++ )
        {
            nombre = "" + ( cont + 1 );
            raza = "" + ( cont + 1 );
            imagen = "" + ( cont + 1 );
            edad = cont + 1;
            puntos = cont + 1;

            Perro perro = ( Perro )exposicion.darPerros( ).get( cont );

            assertEquals( "El perro no se agregó de forma correcta", nombre, perro.darNombre( ) );
            assertEquals( "El perro no se agregó de forma correcta", raza, perro.darRaza( ) );
            assertEquals( "El perro no se agregó de forma correcta", imagen, perro.darImagen( ) );
            assertEquals( "El perro no se agregó de forma correcta", edad, perro.darEdad( ) );
            assertEquals( "El perro no se agregó de forma correcta", puntos, perro.darPuntos( ) );
        }

    }

    /**
     * Verifica el método buscarPerro buscando un perro que se sabe que debería encontrarse. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarPerro. <br>
     * <b> Objetivo: </b> Probar que el método buscarPerro() sea capaz de encontrar perros registrados en la exposición. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un perro previamente agregado se debe obtener una posición diferente de -1. <br>
     * 2. Al buscar un perro que no exista la posición retornada debe ser -1.
     * 
     */
    public void testBuscarPerro( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        exposicion.ordenarPorPuntos( );
        ArrayList perros = exposicion.darPerros( );
        Perro p0 = ( Perro )perros.get( 0 );
        String nombrePerro = p0.darNombre( );
        exposicion.ordenarPorRaza( );

        int posicion = exposicion.buscarPerro( nombrePerro );
        assertTrue( "No se encontró el perro", posicion != -1 );

        perros = exposicion.darPerros( );
        Perro pn = ( Perro )perros.get( posicion );
        assertEquals( "No se encontró el perro buscado", pn.darNombre( ), nombrePerro );

        posicion = exposicion.buscarPerro( "el perro no existe" );
        assertEquals( "No se encontró el perro buscado", -1, posicion );
    }

    /**
     * Verifica el método buscarBinarioPorNombre buscando un perro que se sabe que debería encontrarse. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarBinarioPorNombre. <br>
     * <b> Objetivo: </b> Probar que el método buscarBinarioPorNombre() sea capaz de encontrar perros registrados en la exposición. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un perro previamente agregado se debe obtener una posición diferente de -1. <br>
     * 2. Al buscar un perro que no exista la posición retornada debe ser -1.
     * 
     */
    public void testBuscarBinarioPorNombre( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        exposicion.ordenarPorNombre( );
        ArrayList perros = exposicion.darPerros( );

        // Busca el primer perro
        Perro perro = ( Perro )perros.get( 0 );
        String nombrePerro = perro.darNombre( );

        int posicion = exposicion.buscarBinarioPorNombre( nombrePerro );
        assertTrue( "No se encontró el perro", posicion != -1 );

        Perro perroNuevo = ( Perro )perros.get( posicion );
        assertEquals( "No se encontró el perro buscado", perroNuevo.darNombre( ), nombrePerro );

        // Busca el perro del medio
        perro = ( Perro )perros.get( cantidadPerros / 2 );
        nombrePerro = perro.darNombre( );

        posicion = exposicion.buscarBinarioPorNombre( nombrePerro );
        assertTrue( "No se encontró el perro", posicion != -1 );

        perroNuevo = ( Perro )perros.get( posicion );
        assertEquals( "No se encontró el perro buscado", perroNuevo.darNombre( ), nombrePerro );

        // Busca el perro del final}
        perro = ( Perro )perros.get( cantidadPerros - 1 );
        nombrePerro = perro.darNombre( );

        posicion = exposicion.buscarBinarioPorNombre( nombrePerro );
        assertTrue( "No se encontró el perro", posicion != -1 );

        perroNuevo = ( Perro )perros.get( posicion );
        assertEquals( "No se encontró el perro buscado", perroNuevo.darNombre( ), nombrePerro );

        // Busca un perro que no existe
        posicion = exposicion.buscarPerro( "el perro no existe" );
        assertEquals( "No se encontró el perro buscado", -1, posicion );
    }

    /**
     * Verifica el método de ordenar por puntos  <br>
     * <b> Métodos a probar: </b> <br>
     * ordenarPorPuntos. <br>
     * <b> Objetivo: </b> Probar que el método ordenarPorPuntos() ordena la exposición de forma correcta (en orden ascendente por puntos). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar la exposición por puntos no se encuentran dos perros consecutivos para los cuales el perro de la izquierda tenga más puntos que el perro de la derecha.
     */
    public void testOrdenarPorPuntos( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        exposicion.ordenarPorPuntos( );
        ArrayList perros = exposicion.darPerros( );
        for( int i = 1; i < perros.size( ); i++ )
        {
            Perro p0 = ( Perro )perros.get( i - 1 );
            Perro p1 = ( Perro )perros.get( i );

            assertTrue( "No se ordenó bien por puntos", p0.darPuntos( ) <= p1.darPuntos( ) );
        }
    }

    /**
     * Verifica el método de ordenar por edad  <br>
     * <b> Métodos a probar: </b> <br>
     * ordenarPorEdad. <br>
     * <b> Objetivo: </b> Probar que el método ordenarPorEdad() ordena la exposición de forma correcta (en orden ascendente por edad). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar la exposición por edad no se encuentran dos perros consecutivos para los cuales el perro de la izquierda tenga más edad que el perro de la derecha.
     */
    public void testOrdenarPorEdad( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        exposicion.ordenarPorEdad( );
        ArrayList perros = exposicion.darPerros( );
        for( int i = 1; i < perros.size( ); i++ )
        {
            Perro p0 = ( Perro )perros.get( i - 1 );
            Perro p1 = ( Perro )perros.get( i );

            assertTrue( "No se ordenó bien por edad", p0.darEdad( ) <= p1.darEdad( ) );
        }
    }

    /**
     * Verifica el método de ordenar por raza  <br>
     * <b> Métodos a probar: </b> <br>
     * ordenarPorRaza. <br>
     * <b> Objetivo: </b> Probar que el método ordenarPorRaza() ordena la exposición de forma correcta (en orden ascendente por raza). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar la exposición por raza no se encuentran dos perros consecutivos para los cuales el perro de la izquierda tenga una raza mayor (alfabéticamente) que el
     * perro de la derecha.
     */
    public void testOrdenarPorRaza( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        exposicion.ordenarPorRaza( );
        ArrayList perros = exposicion.darPerros( );
        for( int i = 1; i < perros.size( ); i++ )
        {
            Perro p0 = ( Perro )perros.get( i - 1 );
            Perro p1 = ( Perro )perros.get( i );

            assertTrue( "No se ordenó bien por raza", p0.darRaza( ).compareTo( p1.darRaza( ) ) <= 0 );
        }
    }

    /**
     * Verifica el método de ordenar por nombre  <br>
     * <b> Métodos a probar: </b> <br>
     * ordenarPorNombre. <br>
     * <b> Objetivo: </b> Probar que el método ordenarPorNombre() ordena la exposición de forma correcta (en orden ascendente por nombre). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar la exposición por nombre no se encuentran dos perros consecutivos para los cuales el perro de la izquierda tenga un nombre mayor (alfabéticamente) que el
     * perro de la derecha.
     */
    public void testOrdenarPorNombre( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        exposicion.ordenarPorNombre( );
        ArrayList perros = exposicion.darPerros( );
        for( int i = 1; i < perros.size( ); i++ )
        {
            Perro p0 = ( Perro )perros.get( i - 1 );
            Perro p1 = ( Perro )perros.get( i );

            assertTrue( "No se ordenó bien por nombre", p0.darNombre( ).compareTo( p1.darNombre( ) ) <= 0 );
        }
    }

    /**
     * Verifica el método buscarPerroMayorEdad funcione correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarPerroMayorEdad. <br>
     * <b> Objetivo: </b> Probar que el método buscarPerroMayorEdad() retorna el perro correcto (el que tiene mayor edad). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el perro con mayor edad se debe obtener la posición del perro con la edad más grande en la exposición. <br>
     * 2. Al buscar el perro con mayor edad en una exposición vacía la posición retornada debe ser -1.
     */
    public void testBuscarPerroMayorEdad( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        int posMayor = exposicion.buscarPerroMayorEdad( );
        ArrayList perros = exposicion.darPerros( );
        Perro mayor = ( Perro )perros.get( posMayor );
        exposicion.ordenarPorEdad( );
        perros = exposicion.darPerros( );
        Perro pMayor = ( Perro )perros.get( perros.size( ) - 1 );

        assertEquals( "El perro de mayor edad no es el correcto", pMayor, mayor );

        setupEscenario3( );
        posMayor = exposicion.buscarPerroMayorEdad( );
        assertEquals( "El perro de mayor edad no debe existir", -1, posMayor );
    }

    /**
     * Verifica el método buscarPerroMayorPuntaje funcione correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarPerroMayorPuntaje. <br>
     * <b> Objetivo: </b> Probar que el método buscarPerroMayorPuntaje() retorna el perro correcto (el que tiene mayor puntaje). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el perro con mayor puntaje se debe obtener la posición del perro con el puntaje más grande en la exposición. <br>
     * 2. Al buscar el perro con mayor puntaje en una exposición vacía la posición retornada debe ser -1.
     */
    public void testBuscarPerroMayorPuntaje( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        int posMayor = exposicion.buscarPerroMayorPuntaje( );
        ArrayList perros = exposicion.darPerros( );
        Perro mayor = ( Perro )perros.get( posMayor );
        exposicion.ordenarPorPuntos( );
        perros = exposicion.darPerros( );
        Perro pMayor = ( Perro )perros.get( perros.size( ) - 1 );

        assertEquals( "El perro de mayor puntaje no es el correcto", pMayor, mayor );

        setupEscenario3( );
        posMayor = exposicion.buscarPerroMayorPuntaje( );
        assertEquals( "El perro de mayor puntaje no debe existir", -1, posMayor );
    }

    /**
     * Verifica el método buscarPerroMenorPuntaje funcione correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * buscarPerroMenorPuntaje. <br>
     * <b> Objetivo: </b> Probar que el método buscarPerroMenorPuntaje() retorna el perro correcto (el que tiene menor puntaje). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el perro con menor puntaje se debe obtener la posición del perro con el puntaje más pequeño en la exposición. <br>
     * 2. Al buscar el perro con menor puntaje en una exposición vacía la posición retornada debe ser -1.
     */
    public void testBuscarPerroMenorPuntaje( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        int posMenor = exposicion.buscarPerroMenorPuntaje( );
        ArrayList perros = exposicion.darPerros( );
        Perro menor = ( Perro )perros.get( posMenor );
        exposicion.ordenarPorPuntos( );
        perros = exposicion.darPerros( );
        Perro pMenor = ( Perro )perros.get( 0 );

        assertEquals( "El perro de menor puntaje no es el correcto", pMenor, menor );

        setupEscenario3( );
        posMenor = exposicion.buscarPerroMenorPuntaje( );
        assertEquals( "El perro de menor puntaje no debe existir", -1, posMenor );
    }

    // -----------------------------------------------------------------
    // Métodos Auxiliares
    // -----------------------------------------------------------------
    /**
     * Carga los perros de la exposición especificada a partir de un archivo de propiedades.
     * @param archivo es el nombre del archivo de propiedades que contiene la información de los perros
     */
    private void cargarPerros( String archivo )
    {

        try
        {
            FileInputStream fis = new FileInputStream( new File( archivo ) );
            Properties propiedades = new Properties( );
            propiedades.load( fis );

            // Cargar los perros
            String dato;
            String nombre;
            String raza;
            String imagen;
            int puntos;
            int edad;
            String aux;
            dato = "total.perros";
            aux = propiedades.getProperty( dato );
            cantidadPerros = Integer.parseInt( aux );

            for( int cont = 1; cont <= cantidadPerros; cont++ )
            {
                // Carga un perro
                dato = "perro" + cont + ".nombre";
                nombre = propiedades.getProperty( dato );

                dato = "perro" + cont + ".raza";
                raza = propiedades.getProperty( dato );

                dato = "perro" + cont + ".raza";
                raza = propiedades.getProperty( dato );

                dato = "perro" + cont + ".imagen";
                imagen = propiedades.getProperty( dato );

                dato = "perro" + cont + ".puntos";
                aux = propiedades.getProperty( dato );
                puntos = Integer.parseInt( aux );

                dato = "perro" + cont + ".edad";
                aux = propiedades.getProperty( dato );
                edad = Integer.parseInt( aux );

                exposicion.agregarPerro( nombre, raza, imagen, puntos, edad );
                fis.close( );
            }
        }
        catch( Exception e )
        {

            fail( "No se pudo cargar el archivo de perros: " + e.getMessage( ) );
        }
    }
}
