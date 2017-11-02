package uniandes.cupi2.lineasTelefonicas.test;

import uniandes.cupi2.lineasTelefonicas.mundo.LineaVozIP;
import junit.framework.TestCase;

/**
 * Pruebas de la clase linea voz ip.
 *
 */
public class LineaVozIPTest extends TestCase{
	
	 //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * L�nea voz ip de prueba.
     */
	private LineaVozIP lineaVozIP;
	
	//-----------------------------------------------------------------
    // M�todos   
    //-----------------------------------------------------------------

    /**
     * Construye una nueva L�nea celular vac�a.
     */
	private void setupEscenario1()
	{
		lineaVozIP = new LineaVozIP();
	}
	
    /**
     * Prueba 1 - Agregar llamada celular.
     */
	public void testAgregarLlamadaCelular()
	{
		setupEscenario1();
		lineaVozIP.agregarLlamadaCelular(10);
		assertEquals("El número de llamadas debe ser 1", 1, lineaVozIP.darNumeroLlamadas());
		assertEquals("El número de minutos debe ser 10", 10, lineaVozIP.darNumeroMinutos());
		assertEquals("El costo debe ser $70", 70.0, lineaVozIP.darCostoLlamadas(),0.1);
		assertEquals("El número de minutos a celular debe ser 10", 10, lineaVozIP.darNumeroMinutosCelular());
	}
	
    /**
     * Prueba 2 - Agregar llamada local.
     */
	public void testAgregarLlamadaLargaDistancia()
	{
		setupEscenario1();
		lineaVozIP.agregarLlamadaLargaDistancia(10);
		assertEquals("El n�mero de llamadas debe ser 1", 1, lineaVozIP.darNumeroLlamadas());
		assertEquals("El n�mero de minutos debe ser 10", 10, lineaVozIP.darNumeroMinutos());
		assertEquals("El costo debe ser $800", 800.0, lineaVozIP.darCostoLlamadas());
		assertEquals("El saldo disponible debe ser $99200.0", 99200.0, lineaVozIP.darSaldoDisponible());
		assertEquals("El n�mero de minutos larga distancia debe ser 10", 10, lineaVozIP.darNumeroMinutosLargaDistancia());

	}
	
	
    /**
     * Prueba 4 - Reiniciar.
     */
	public void testReiniciar()
	{
		setupEscenario1();
		lineaVozIP.agregarLlamadaCelular(10);
		lineaVozIP.agregarLlamadaLargaDistancia(20);;
		lineaVozIP.reiniciar();
        assertEquals( "El n�mero de llamadas debe ser 0", 0, lineaVozIP.darNumeroLlamadas( ) );
        assertEquals( "El n�mero de minutos debe ser 0", 0, lineaVozIP.darNumeroMinutos( ) );
        assertEquals( "El n�mero de minutos larga distancia debe ser 0", 0, lineaVozIP.darNumeroMinutosLargaDistancia());
        assertEquals( "El costo debe ser $0.0", 0, lineaVozIP.darCostoLlamadas( ), 0.001 );
	}

}
