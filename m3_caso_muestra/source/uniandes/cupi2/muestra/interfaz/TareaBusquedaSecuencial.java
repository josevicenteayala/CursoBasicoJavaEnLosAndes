/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: TareaBusquedaSecuencial.java,v 1.6 2006/08/06 20:26:47 da-romer Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License versi�n 2.1
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_muestra
 * Autor: Mario S�nchez - 2/07/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.muestra.interfaz;

import uniandes.cupi2.muestra.mundo.Muestra;

/**
 * Esta tarea se usa para realizar b�squedas secuenciales sobre la muestra
 */
public class TareaBusquedaSecuencial extends Thread
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * La muestra sobre la que se realizar� la b�squeda
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
     * @param laMuestra es la muestra sobre la que se realizar� la b�squeda - laMuestra != null
     * @param ventanaPrincipal es la ventana donde se debe mostrar el tiempo al finalizar - ventanaPrincipal != null
     */
    public TareaBusquedaSecuencial( Muestra laMuestra, InterfazMuestra ventanaPrincipal )
    {
        muestra = laMuestra;
        principal = ventanaPrincipal;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicia la ejecuci�n de la tarea. Cuando termina, registra el tiempo total en la ventana principal.
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
