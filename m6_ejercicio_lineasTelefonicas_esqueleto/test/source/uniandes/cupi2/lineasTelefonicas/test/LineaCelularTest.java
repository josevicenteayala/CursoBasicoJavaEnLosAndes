package uniandes.cupi2.lineasTelefonicas.test;

import uniandes.cupi2.lineasTelefonicas.mundo.LineaCelular;
import junit.framework.TestCase;

/**
 * Pruebas de la clase linea Celular.
 *
 */
public class LineaCelularTest extends TestCase{
	
	 //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * L�nea celular de prueba
     */
	private LineaCelular lineaCelular;
	
	//-----------------------------------------------------------------
    // M�todos   
    //-----------------------------------------------------------------

    /**
     * Construye una nueva L�nea celular vac�a
     */
	private void setupEscenario1()
	{
		lineaCelular = new LineaCelular();
	}
	
    /**
     * Prueba 1 - Agregar llamada celular
     */
	public void testAgregarLlamadaCelular()
	{
		setupEscenario1();
		lineaCelular.agregarLlamadaCelular(10);
		assertEquals("El n�mero de llamadas debe ser 1", 1, lineaCelular.darNumeroLlamadas());
		assertEquals("El n�mero de minutos debe ser 10", 10, lineaCelular.darNumeroMinutos());
		assertEquals("El costo debe ser $100", 100.0, lineaCelular.darCostoLlamadas());
		assertEquals("El n�mero de minutos a celular debe ser 10", 10, lineaCelular.darNumeroMinutosCelular());

	}
	
    /**
     * Prueba 2 - Agregar llamada local
     */
	public void testAgregarLlamadaLocal()
	{
		setupEscenario1();
		lineaCelular.agregarLlamadaLocal(10);
		assertEquals("El n�mero de llamadas debe ser 1", 1, lineaCelular.darNumeroLlamadas());
		assertEquals("El n�mero de minutos debe ser 10", 10, lineaCelular.darNumeroMinutos());
		assertEquals("El costo debe ser $200", 200.0, lineaCelular.darCostoLlamadas());
		assertEquals("El saldo disponible debe ser $49800", 49800.0, lineaCelular.darSaldoDisponibleLocal());
		assertEquals("El n�mero de minutos locales debe ser 10", 10, lineaCelular.darNumeroMinutosLocal());

	}
	
	
    /**
     * Prueba 4 - Reiniciar
     */
	public void testReiniciar()
	{
		setupEscenario1();
		lineaCelular.agregarLlamadaCelular(10);
		lineaCelular.agregarLlamadaLocal(20);
		lineaCelular.reiniciar();
        assertEquals( "El n�mero de llamadas debe ser 0", 0, lineaCelular.darNumeroLlamadas( ) );
        assertEquals( "El n�mero de minutos debe ser 0", 0, lineaCelular.darNumeroMinutos( ) );
        assertEquals( "El n�mero de minutos a Celular debe ser 0", 0, lineaCelular.darNumeroMinutosCelular( ) );
        assertEquals( "El n�mero de minutos Locales debe ser 0", 0, lineaCelular.darNumeroMinutosLocal( ) );
        assertEquals( "El costo debe ser $0.0", 0, lineaCelular.darCostoLlamadas( ), 0.001 );
	}

}
