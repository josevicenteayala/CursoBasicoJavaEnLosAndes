/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_lineasTelefonicas
 * Autor: Pablo Barvo - 06-Dec-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.lineasTelefonicas.test;

import junit.framework.TestCase;
import uniandes.cupi2.lineasTelefonicas.mundo.Empresa;

/**
 * Esta es la clase usada para verificar que los m�todos de la clase Empresa est�n correctamente implementados
 */
public class EmpresaTest extends TestCase
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Empresa de prueba
     */
    private Empresa empresa;

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Construye una nueva Empresa vac�a
     */
    private void setupEscenario1( )
    {
        empresa = new Empresa( );
    }

    /**
     * Construye una nueva Empresa con llamadas
     */
    private void setupEscenario2( )
    {
        empresa = new Empresa( );

        empresa.agregarLlamadaLocalLinea1( 1 );
        empresa.agregarLlamadaLargaDistanciaLinea1( 2 );
        empresa.agregarLlamadaCelularLinea1( 3 );

        empresa.agregarLlamadaLocalLinea2( 10 );
        empresa.agregarLlamadaLargaDistanciaLinea2( 20 );
        empresa.agregarLlamadaCelularLinea2( 30 );

        empresa.agregarLlamadaLocalLinea2( 100 );
        empresa.agregarLlamadaLargaDistanciaLinea2( 200 );
        empresa.agregarLlamadaCelularLinea2( 300 );
        
        empresa.agregarLlamadaCelularLineaVozIP1(10);
        empresa.agregarLlamadaLargaDistanciaLineaVozIP1(20);
    }
    
    private void setupEscenario3()
    {

        empresa = new Empresa( );

        empresa.agregarLlamadaLocalLineaCelular1(10);
        empresa.agregarLlamadaCelularLineaCelular1(5);
        
        empresa.agregarLlamadaCelularLineaVozIP1(15);
        empresa.agregarLlamadaLargaDistanciaLineaVozIP1(30);
    }

    /**
     * Prueba 1 - Inicializaci�n
     */
    public void testInicializacion( )
    {
        setupEscenario1( );
        assertNotNull( "La l�nea telef�nica 1 debe estar inicializada", empresa.darLinea1( ) );
        assertNotNull( "La l�nea telef�nica 2 debe estar inicializada", empresa.darLinea2( ) );
        assertNotNull( "La l�nea telef�nica 3 debe estar inicializada", empresa.darLinea3( ) );
        assertNotNull( "La l�nea alternativa 1 debe estar inicializada", empresa.darLineaCelular1());
        assertNotNull( "La l�nea alternativa 2 debe estar inicializada", empresa.darLineaVozIP1());
    }
    
    /**
     * Prueba 2 - AgregarLlamadaLocalLinea1
     */
    public void testAgregarLlamadaLocalLinea1( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLocalLinea1( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea1( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 3 - AgregarLlamadaLocalLinea2
     */
    public void testAgregarLlamadaLocalLinea2( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLocalLinea2( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea2( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 4 - AgregarLlamadaLocalLinea1
     */
    public void testAgregarLlamadaLocalLinea3( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLocalLinea3( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea3( ).darNumeroLlamadas( ) );
    }

    
    public void testAgregarLlamadaLocalLineaCelular1()
    {
    	setupEscenario1();
    	empresa.agregarLlamadaLocalLineaCelular1(10);
    	assertEquals("La llamada no qued� registrada", 1, empresa.darLineaCelular1().darNumeroLlamadas());
    }
    /**
     * Prueba 5 - AgregarLlamadaLargaDistanciaLinea1
     */
    public void testAgregarLlamadaLargaDistanciaLinea1( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLargaDistanciaLinea1( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea1( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 6 - AgregarLlamadaLargaDistanciaLinea2
     */
    public void testAgregarLlamadaLargaDistanciaLinea2( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLargaDistanciaLinea2( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea2( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 7 - AgregarLlamadaLargaDistanciaLinea1
     */
    public void testAgregarLlamadaLargaDistanciaLinea3( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLargaDistanciaLinea3( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea3( ).darNumeroLlamadas( ) );
    }
    
    /**
     * Prueba 8 - AgregarLlamadaLargaDistanciaVozIP1
     */
    public void testAgregarLlamadaLargaDistanciaVozIP1( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLargaDistanciaLineaVozIP1( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLineaVozIP1().darNumeroLlamadas( ) );
    }

    /**
     * Prueba 9 - AgregarLlamadaCelularLinea1
     */
    public void testAgregarCelularDistanciaLinea1( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaCelularLinea1( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea1( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 9 - AgregarLlamadaCelularLinea2
     */
    public void testAgregarCelularDistanciaLinea2( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaCelularLinea2( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea2( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 10 - AgregarLlamadaCelularLinea3
     */
    public void testAgregarCelularDistanciaLinea3( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaCelularLinea3( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea3( ).darNumeroLlamadas( ) );
    }

    public void testAgregarLlamadaCelularLineaCelular1()
    {
    	setupEscenario1();
    	empresa.agregarLlamadaCelularLineaCelular1(10);
    	assertEquals("La llamada no qued� registrada", 1, empresa.darLineaCelular1().darNumeroLlamadas());
    }
    
    public void testAgregarLlamadaCelularLineaVozIp1()
    {
    	setupEscenario1();
    	empresa.agregarLlamadaCelularLineaVozIP1(10);
    	assertEquals("La llamada no qued� registrada", 1, empresa.darLineaVozIP1().darNumeroLlamadas());
    }
    
    /**
     * Prueba 11 - Total Llamadas
     */
    public void testDarTotalLlamadas( )
    {
        setupEscenario2( );
        assertEquals( "El numero de llamadas debe ser 9", 9, empresa.darTotalNumeroLlamadasDesdeLineasNoAlternativas( ) );
    }

    public void testDarTotalLlamadasLineasAlternativas()
    {
    	setupEscenario3();
    	assertEquals("El n�mero de llamadas debe ser 4", 4, empresa.darTotalNumeroLlamadasDesdeLineasAlternativas());
    }
    
    /**
     * Prueba 12 - Total Minutos
     */
    public void testDarTotalMinutos( )
    {
        setupEscenario2( );
        assertEquals( "El total de minutos debe ser 666", 666, empresa.darTotalMinutosDesdeLineasNoAlternativas( ) );
    }
    
    public void testDarTotalMinutosLineasAlternativas()
    {
    	setupEscenario3();
    	assertEquals("El total de minutos debe ser 60", 60, empresa.darTotalMinutosDesdeLineasAlternativas());
    }

    /**
     * Prueba 13 - Total Llamadas
     */
    public void testDarTotalCosto( )
    {
        setupEscenario2( );
        assertEquals( "El costo es inv�lido. Debe ser $ 420.912", 420912, empresa.darTotalCostoLlamadasDesdeLineasNoAlternativas( ), 0.001 );
    }
    
    public void testDarTotalCostoLineasAlternativas()
    {
    	setupEscenario3();
    	assertEquals("El costo es inválido. Debe ser $2755", 2755.0, empresa.darTotalCostoLlamadasDesdeLineasAlternativas(),0.1);
    }

    /**
     * Prueba 14 - Costo promedio
     */
    public void testDarCostoPromedio( )
    {
        setupEscenario2( );
        assertEquals( "El costo promedio es inv�lido. Debe ser $632", 632, empresa.darCostoPromedioMinutoDesdeLineasNoAlternativas( ), 0.001 );
    }
    
    public void testDarCostoPromedioLineasAlternativas()
    {
    	setupEscenario3();
    	assertEquals("El costo promedio es inválido. Debe ser $45", 45, (int)empresa.darCostoPromedioMinutoDesdeLineasAlternativas());

    }

    /**
     * Prueba 15 - Reiniciar
     */
    public void testReiniciar( )
    {
        setupEscenario2( );
        empresa.reiniciarLineasNoAlternativas( );
        assertEquals( "El total de llamadas debe ser cero", 0, empresa.darTotalNumeroLlamadasDesdeLineasNoAlternativas( ) );
        assertEquals( "El total de minutos debe ser cero", 0, empresa.darTotalMinutosDesdeLineasNoAlternativas( ) );
        assertEquals( "El costo total de llamadas debe ser cero", 0, empresa.darTotalCostoLlamadasDesdeLineasNoAlternativas( ), 0.01 );
    }
    
    public void testReiniciarLineasAlternativas( )
    {
        setupEscenario3( );
        empresa.reiniciarLineasAlternativas( );
        assertEquals( "El total de llamadas de l�neas alternativas debe ser cero", 0, empresa.darTotalNumeroLlamadasDesdeLineasAlternativas( ) );
        assertEquals( "El total de minutos de l�neas alternativas debe ser cero", 0, empresa.darTotalMinutosDesdeLineasAlternativas( ) );
        assertEquals( "El costo total de llamadas de l�neas alternativas debe ser cero", 0, empresa.darTotalCostoLlamadasDesdeLineasAlternativas( ), 0.01 );
    }

}