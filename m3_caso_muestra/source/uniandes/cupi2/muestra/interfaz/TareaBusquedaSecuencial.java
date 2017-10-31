/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: TareaBusquedaSecuencial.java,v 1.6 2006/08/06 20:26:47 da-romer Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License versión 2.1
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_muestra
 * Autor: Mario Sánchez - 2/07/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.muestra.interfaz;

import uniandes.cupi2.muestra.mundo.Muestra;

/**
 * Esta tarea se usa para realizar búsquedas secuenciales sobre la muestra
 */
public class TareaBusquedaSecuencial extends Thread
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * La muestra sobre la que se realizará la búsqueda
     */
    private Muestra muestra;

    /**
     * La ventana donde se debe mostrar el tiempo al finalizar
     */
    private InterfazMuestra principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la tarea
     * @param laMuestra es la muestra sobre la que se realizará la búsqueda - laMuestra != null
     * @param ventanaPrincipal es la ventana donde se debe mostrar el tiempo al finalizar - ventanaPrincipal != null
     */
    public TareaBusquedaSecuencial( Muestra laMuestra, InterfazMuestra ventanaPrincipal )
    {
        muestra = laMuestra;
        principal = ventanaPrincipal;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicia la ejecución de la tarea. Cuando termina, registra el tiempo total en la ventana principal.
     */
    public void run( )
    {
        long tiempoTotal = 0;
        for( int i = 0; i < muestra.darTamanio( ); i++ )
        {
            long t1 = System.currentTimeMillis( );
            muestra.buscarSecuencial( i );
            long t2 = System.currentTimeMillis( );
            tiempoTotal += ( t2 - t1 );
        }

        principal.registrarTiempoBusquedaSecuencial( ( double )tiempoTotal / ( double )muestra.darTamanio( ) );
    }
}
