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
     * Línea celular de prueba
     */
	private LineaCelular lineaCelular;
	
	//-----------------------------------------------------------------
    // Métodos   
    //-----------------------------------------------------------------

    /**
     * Construye una nueva Línea celular vacía
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
		assertEquals("El número de llamadas debe ser 1", 1, lineaCelular.darNumeroLlamadas());
		assertEquals("El número de minutos debe ser 10", 10, lineaCelular.darNumeroMinutos());
		assertEquals("El costo debe ser $100", 100.0, lineaCelular.darCostoLlamadas());
		assertEquals("El número de minutos a celular debe ser 10", 10, lineaCelular.darNumeroMinutosCelular());

	}
	
    /**
     * Prueba 2 - Agregar llamada local
     */
	public void testAgregarLlamadaLocal()
	{
		setupEscenario1();
		lineaCelular.agregarLlamadaLocal(10);
		assertEquals("El número de llamadas debe ser 1", 1, lineaCelular.darNumeroLlamadas());
		assertEquals("El número de minutos debe ser 10", 10, lineaCelular.darNumeroMinutos());
		assertEquals("El costo debe ser $200", 200.0, lineaCelular.darCostoLlamadas());
		assertEquals("El saldo disponible debe ser $49800", 49800.0, lineaCelular.darSaldoDisponibleLocal());
		assertEquals("El número de minutos locales debe ser 10", 10, lineaCelular.darNumeroMinutosLocal());

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
        assertEquals( "El número de llamadas debe ser 0", 0, lineaCelular.darNumeroLlamadas( ) );
        assertEquals( "El número de minutos debe ser 0", 0, lineaCelular.darNumeroMinutos( ) );
        assertEquals( "El número de minutos a Celular debe ser 0", 0, lineaCelular.darNumeroMinutosCelular( ) );
        assertEquals( "El número de minutos Locales debe ser 0", 0, lineaCelular.darNumeroMinutosLocal( ) );
        assertEquals( "El costo debe ser $0.0", 0, lineaCelular.darCostoLlamadas( ), 0.001 );
	}

}
