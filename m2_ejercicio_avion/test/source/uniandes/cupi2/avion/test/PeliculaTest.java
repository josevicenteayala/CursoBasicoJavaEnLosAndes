package uniandes.cupi2.avion.test;

import uniandes.cupi2.avion.mundo.Pelicula;
import junit.framework.TestCase;

public class PeliculaTest extends TestCase
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Pelicula 1
     */
    private Pelicula pelicula;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea una pel�cula con los siguientes valores.
     *  Nombre : Pompeii
     *  G�nero: Acci�n
     *  Duraci�n: 105 minutos
     *  Director: Paul Anderson
     */
    private void setupEscenario1()
    {
    	pelicula = new Pelicula("Pompeii", Pelicula.ACCION, 105, "Paul Anderson");
    }

    
    /**
     * Prueba 1: verifica que la pelicula se cree con los valores dados.
     */
    public void testCrearPelicula()
    {
    	setupEscenario1();
    	assertEquals("El nombre deber�a ser Pompeii.", "Pompeii", pelicula.darNombre());
    	assertEquals("El g�nero deber�a ser Acci�n.", Pelicula.ACCION, pelicula.darGenero());
    	assertEquals("La duraci�n deber�a ser 105.", 105, pelicula.darDuracion());
    	assertEquals("El director deber�a ser Paul Anderson.", "Paul Anderson", pelicula.darDirector());
    	assertNotNull("El to string no deber�a dar nulo", pelicula.toString());
    }
    

}
