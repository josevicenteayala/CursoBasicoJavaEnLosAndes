/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: UrnaTest.java 445 2007-06-25 16:30:28Z camil-ji $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_elecciones
 * Autor: Carlos Andrés Vega - 29-ene-2007
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.elecciones.test;

import junit.framework.TestCase;
import uniandes.cupi2.elecciones.mundo.Urna;

/**
 * Esta es la clase usada para verificar que los métodos de la clase Urna estén correctamente implementados
 */
public class UrnaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private Urna urna;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye una nueva Urna vacía
     * 
     */
    private void setupEscenario1( )
    {
        urna = new Urna( );
    }

    /**
     * Construye una urna, donde cada candidato tiene un voto de cada tipo
     */
    private void setupEscenario2( )
    {
        urna = new Urna( );

        urna.ingresarVotoTelevisionCandidato1( );
        urna.ingresarVotoTelevisionCandidato2( );
        urna.ingresarVotoTelevisionCandidato3( );

        urna.ingresarVotoRadioCandidato1( );
        urna.ingresarVotoRadioCandidato2( );
        urna.ingresarVotoRadioCandidato3( );

        urna.ingresarVotoInternetCandidato1( );
        urna.ingresarVotoInternetCandidato2( );
        urna.ingresarVotoInternetCandidato3( );
    }
    
    /**
     * Construye una urna donde los candidatos tiene votos por internet.
     */
    private void setupEscenario3( )
    {
    	urna = new Urna( );
        
        urna.ingresarVotoInternetCandidato1();
        urna.ingresarVotoInternetCandidato1();
        urna.ingresarVotoInternetCandidato1();
        urna.ingresarVotoInternetCandidato1();
        urna.ingresarVotoInternetCandidato1();
        urna.ingresarVotoInternetCandidato2();
        urna.ingresarVotoInternetCandidato2();
        urna.ingresarVotoInternetCandidato2();
        urna.ingresarVotoInternetCandidato3();
        urna.ingresarVotoInternetCandidato3();
    }

    /**
     * Prueba 1 - Inicialización de los candidatos
     */
    public void testInicializacion( )
    {
        setupEscenario1( );
        assertNotNull( "El candidato 1 debe estar inicializado", urna.darCandidato1( ) );
        assertNotNull( "El candidato 2 debe estar inicializado", urna.darCandidato2( ) );
        assertNotNull( "El candidato 3 debe estar inicializado", urna.darCandidato3( ) );
    }

    /**
     * Prueba 2 - Ingresar voto influenciado por la televisión al candidato 1
     */
    public void testIngresarVotoTelevisionCandidato1( )
    {
        setupEscenario1( );
        urna.ingresarVotoTelevisionCandidato1( );
        assertTrue( "Debería aumentar el costo de campaña en 1000", urna.darCandidato1( ).darCostoCampanha( ) == 1000 );
    }

    /**
     * Prueba 3 - Ingresar voto influenciado por la radio al candidato 1
     */
    public void testIngresarVotoRadioCandidato1( )
    {
        setupEscenario1( );
        urna.ingresarVotoRadioCandidato1( );
        assertTrue( "Debería aumentar el costo de campaña en 500", urna.darCandidato1( ).darCostoCampanha( ) == 500 );
    }

    /**
     * Prueba 4 - Ingresar voto influenciado por Internet al candidato 1
     */
    public void testIngresarVotoInternetCandidato1( )
    {
        setupEscenario1( );
        urna.ingresarVotoInternetCandidato1( );
        assertTrue( "Debería aumentar el costo de campaña en 100", urna.darCandidato1( ).darCostoCampanha( ) == 100 );
    }

    /**
     * Prueba 5 - Ingresar voto influenciado por la televisión al candidato 2
     */
    public void testIngresarVotoTelevisionCandidato2( )
    {
        setupEscenario1( );
        urna.ingresarVotoTelevisionCandidato2( );
        assertTrue( "Debería aumentar el costo de campaña en 1000", urna.darCandidato2( ).darCostoCampanha( ) == 1000 );
    }

    /**
     * Prueba 6 - Ingresar voto influenciado por la radio al candidato 2
     */
    public void testIngresarVotoRadioCandidato2( )
    {
        setupEscenario1( );
        urna.ingresarVotoRadioCandidato2( );
        assertTrue( "Debería aumentar el costo de campaña en 500", urna.darCandidato2( ).darCostoCampanha( ) == 500 );
    }

    /**
     * Prueba 7 - Ingresar voto influenciado por Internet al candidato 2
     */
    public void testIngresarVotoInternetCandidato2( )
    {
        setupEscenario1( );
        urna.ingresarVotoInternetCandidato2( );
        assertTrue( "Debería aumentar el costo de campaña en 100", urna.darCandidato2( ).darCostoCampanha( ) == 100 );
    }

    /**
     * Prueba 8 - Ingresar voto influenciado por la televisión al candidato 3
     */
    public void testIngresarVotoTelevisionCandidato3( )
    {
        setupEscenario1( );
        urna.ingresarVotoTelevisionCandidato3( );
        assertTrue( "Debería aumentar el costo de campaña en 1000", urna.darCandidato3( ).darCostoCampanha( ) == 1000 );
    }

    /**
     * Prueba 9 - Ingresar voto influenciado por la radio al candidato 3
     */
    public void testIngresarVotoRadioCandidato3( )
    {
        setupEscenario1( );
        urna.ingresarVotoRadioCandidato3( );
        assertTrue( "Debería aumentar el costo de campaña en 500", urna.darCandidato3( ).darCostoCampanha( ) == 500 );
    }

    /**
     * Prueba 10 - Ingresar voto influenciado por Internet al candidato 3
     */
    public void testIngresarVotoInternetCandidato3( )
    {
        setupEscenario1( );
        urna.ingresarVotoInternetCandidato3( );
        assertTrue( "Debería aumentar el costo de campaña en 100", urna.darCandidato3( ).darCostoCampanha( ) == 100 );
    }

    /**
     * Prueba 11 - Calcular el total de votos que posee la urna
     */
    public void testCalcularTotalVotos( )
    {
        setupEscenario2( );

        assertTrue( "No calcula el total de votos correctamente", urna.calcularCostoPromedioCampanha() == 1600 );

    }

    /**
     * Prueba 12 - Calcular el costo promedio de campaña de los candidatos
     */
    public void testCalcularCostoPromedioCampanha( )
    {
        setupEscenario2( );

        assertTrue( "No calcula el costo promedio de campaña correctamente", urna.calcularCostoPromedioCampanha( ) == 1600 );
    }

    /**
     * Prueba 13 - Vaciar la urna de votación
     */
    public void testVaciarUrna( )
    {
        setupEscenario2( );

        urna.vaciarUrna( );

        assertTrue( "No inicializa el número de votos a 0 del candidato 1", urna.darCandidato1( ).darVotos( ) == 0 );
        assertTrue( "No inicializa el costo de campaña a 0 del candidato 1", urna.darCandidato1( ).darCostoCampanha( ) == 0 );

        assertTrue( "No inicializa el número de votos a 0 del candidato 2", urna.darCandidato2( ).darVotos( ) == 0 );
        assertTrue( "No inicializa el costo de campaña a 0 del candidato 2", urna.darCandidato2( ).darCostoCampanha( ) == 0 );

        assertTrue( "No inicializa el número de votos a 0 del candidato 3", urna.darCandidato3( ).darVotos( ) == 0 );
        assertTrue( "No inicializa el costo de campaña a 0 del candidato 3", urna.darCandidato3( ).darCostoCampanha( ) == 0 );

    }
    
    /**
     * Prueba 14 - Registra votos para edad joven candidato 1.
     */
    public void testRegistrarVotoEdadJoven1()
    {
    	setupEscenario1();
    	urna.registrarVotoEdadJovenCandidato1();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato1().darVotosEdadJoven());
    	urna.registrarVotoEdadJovenCandidato1();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato1().darVotosEdadJoven());
    	urna.registrarVotoEdadJovenCandidato1();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato1().darVotosEdadJoven());
    }
    
    /**
     * Prueba 15 - Registra votos para edad joven candidato 2.
     */
    public void testRegistrarVotoEdadJoven2()
    {
    	setupEscenario1();
    	urna.registrarVotoEdadJovenCandidato2();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato2().darVotosEdadJoven());
    	urna.registrarVotoEdadJovenCandidato2();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato2().darVotosEdadJoven());
    	urna.registrarVotoEdadJovenCandidato2();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato2().darVotosEdadJoven());
    }
    
    /**
     * Prueba 16 - Registra votos para edad joven candidato 3.
     */
    public void testRegistrarVotoEdadJoven3()
    {
    	setupEscenario1();
    	urna.registrarVotoEdadJovenCandidato3();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato3().darVotosEdadJoven());
    	urna.registrarVotoEdadJovenCandidato3();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato3().darVotosEdadJoven());
    	urna.registrarVotoEdadJovenCandidato3();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato3().darVotosEdadJoven());
    }
    
    /**
     * Prueba 17 - Registra votos para edad media candidato 1.
     */
    public void testRegistrarVotoEdadMedia1()
    {
    	setupEscenario1();
    	urna.registrarVotoEdadMediaCandidato1();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato1().darVotosEdadMedia());
    	urna.registrarVotoEdadMediaCandidato1();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato1().darVotosEdadMedia());
    	urna.registrarVotoEdadMediaCandidato1();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato1().darVotosEdadMedia());
    }
    
    /**
     * Prueba 18 - Registra votos para edad media candidato 2.
     */
    public void testRegistrarVotoEdadMedia2()
    {
    	setupEscenario1();
    	urna.registrarVotoEdadMediaCandidato2();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato2().darVotosEdadMedia());
    	urna.registrarVotoEdadMediaCandidato2();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato2().darVotosEdadMedia());
    	urna.registrarVotoEdadMediaCandidato2();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato2().darVotosEdadMedia());
    }
    
    /**
     * Prueba 19 - Registra votos para edad media candidato 3.
     */
    public void testRegistrarVotoEdadMedia3()
    {
    	setupEscenario1();
    	urna.registrarVotoEdadMediaCandidato3();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato3().darVotosEdadMedia());
    	urna.registrarVotoEdadMediaCandidato3();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato3().darVotosEdadMedia());
    	urna.registrarVotoEdadMediaCandidato3();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato3().darVotosEdadMedia());
    }
   
    /**
     * Prueba 20 - Registra votos para edad mayor candidato 1.
     */
    public void testRegistrarVotoEdadMayor1()
    {
    	setupEscenario1();
    	urna.registrarVotoEdadMayorCandidato1();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato1().darVotosEdadMayor());
    	urna.registrarVotoEdadMayorCandidato1();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato1().darVotosEdadMayor());
    	urna.registrarVotoEdadMayorCandidato1();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato1().darVotosEdadMayor());
    }
    
    /**
     * Prueba 21 - Registra votos para edad mayor candidato 2.
     */
    public void testRegistrarVotoEdadMayor2()
    {
    	setupEscenario1();
    	urna.registrarVotoEdadMayorCandidato2();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato2().darVotosEdadMayor());
    	urna.registrarVotoEdadMayorCandidato2();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato2().darVotosEdadMayor());
    	urna.registrarVotoEdadMayorCandidato2();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato2().darVotosEdadMayor());
    }
    
    /**
     * Prueba 22 - Registra votos para edad mayor candidato 3.
     */
    public void testRegistrarVotoEdadMayor3()
    {
    	setupEscenario1();
    	urna.registrarVotoEdadMayorCandidato3();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato3().darVotosEdadMayor());
    	urna.registrarVotoEdadMayorCandidato3();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato3().darVotosEdadMayor());
    	urna.registrarVotoEdadMayorCandidato3();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato3().darVotosEdadMayor());
    }

    /**
     * Prueba 23 - Registra votos para género masculino del candidato 1.
     */
    public void testRegistrarVotoGeneroMasculino1()
    {
    	setupEscenario1();
    	urna.registrarVotoGeneroMasculinoCandidato1();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato1().darVotosGeneroMasculino());
    	urna.registrarVotoGeneroMasculinoCandidato1();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato1().darVotosGeneroMasculino());
    	urna.registrarVotoGeneroMasculinoCandidato1();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato1().darVotosGeneroMasculino());
    	
    }
    
    /**
     * Prueba 24 - Registra votos para género masculino del candidato 1.
     */
    public void testRegistrarVotoGeneroMasculino2()
    {
    	setupEscenario1();
    	urna.registrarVotoGeneroMasculinoCandidato2();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato2().darVotosGeneroMasculino());
    	urna.registrarVotoGeneroMasculinoCandidato2();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato2().darVotosGeneroMasculino());
    	urna.registrarVotoGeneroMasculinoCandidato2();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato2().darVotosGeneroMasculino());
    	
    }
    
    /**
     * Prueba 25 - Registra votos para género masculino del candidato 1.
     */
    public void testRegistrarVotoGeneroMasculino3()
    {
    	setupEscenario1();
    	urna.registrarVotoGeneroMasculinoCandidato3();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato3().darVotosGeneroMasculino());
    	urna.registrarVotoGeneroMasculinoCandidato3();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato3().darVotosGeneroMasculino());
    	urna.registrarVotoGeneroMasculinoCandidato3();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato3().darVotosGeneroMasculino());
    	
    }
    
    /**
     * Prueba 26 - Registra votos para género femenino del candidato 1.
     */
    public void testRegistrarVotoGeneroFemenino1()
    {
    	setupEscenario1();
    	urna.registrarVotoGeneroFemeninoCandidato1();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato1().darVotosGeneroFemenino());
    	urna.registrarVotoGeneroFemeninoCandidato1();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato1().darVotosGeneroFemenino());
    	urna.registrarVotoGeneroFemeninoCandidato1();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato1().darVotosGeneroFemenino());
    	
    }
    
    /**
     * Prueba 27 - Registra votos para género femenino del candidato 1.
     */
    public void testRegistrarVotoGeneroFemenino2()
    {
    	setupEscenario1();
    	urna.registrarVotoGeneroFemeninoCandidato2();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato2().darVotosGeneroFemenino());
    	urna.registrarVotoGeneroFemeninoCandidato2();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato2().darVotosGeneroFemenino());
    	urna.registrarVotoGeneroFemeninoCandidato2();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato2().darVotosGeneroFemenino());
    	
    }
    
    /**
     * Prueba 28 - Registra votos para género femenino del candidato 1.
     */
    public void testRegistrarVotoGeneroFemenino3()
    {
    	setupEscenario1();
    	urna.registrarVotoGeneroFemeninoCandidato3();
    	assertEquals( "No registra bien el voto.", 1, urna.darCandidato3().darVotosGeneroFemenino());
    	urna.registrarVotoGeneroFemeninoCandidato3();
    	assertEquals( "No registra bien el voto.", 2, urna.darCandidato3().darVotosGeneroFemenino());
    	urna.registrarVotoGeneroFemeninoCandidato3();
    	assertEquals( "No registra bien el voto.", 3, urna.darCandidato3().darVotosGeneroFemenino());
    	
    }
    
    /**
     * Prueba 29 - Calcula promediod e votos influenciados por internet para el candidato 1.
     */
    public void testcCalcularPorcentajeVotosPorInternet1()
    {
    	setupEscenario3();
    	assertEquals("El porcentaje del candidato 1 no está bien.", 50, urna.calcularPorcentajeVotosPorInternetCandidato1(), 0.1);
    }
    
    /**
     * Prueba 30 - Calcula promediod e votos influenciados por internet para el candidato 2.
     */
    public void testcCalcularPorcentajeVotosPorInternet2()
    {
    	setupEscenario3();
    	assertEquals("El porcentaje del candidato 2 no está bien.", 30, urna.calcularPorcentajeVotosPorInternetCandidato2(), 0.1);
    }
    
    /**
     * Prueba 31 - Calcula promediod e votos influenciados por internet para el candidato 3.
     */
    public void testcCalcularPorcentajeVotosPorInternet3()
    {
    	setupEscenario3();
    	assertEquals("El porcentaje del candidato 3 no está bien.", 20, urna.calcularPorcentajeVotosPorInternetCandidato3(), 0.1);
    }
}