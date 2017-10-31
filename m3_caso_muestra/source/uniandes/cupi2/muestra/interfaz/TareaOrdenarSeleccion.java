/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: TareaOrdenarSeleccion.java,v 1.6 2006/08/16 05:44:56 f-vela Exp $
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
import uniandes.cupi2.muestra.mundo.MuestraOrdenada;

/**
 * Esta tarea se usa para ordenar una muestra usando el algoritmo de Selección
 */
public class TareaOrdenarSeleccion extends Thread
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * La muestra que será ordenada
     */
    private Muestra muestra;

    /**
     * Es una referencia a la ventana principal de la interfaz, donde se tendrá que registrar el tiempo que tomó el ordenamiento
     */
    private InterfazMuestra principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la tarea, con una referencia a la ventana donde debe publicarse el tiempo
     * @param laMuestra es la muestra que será ordenada
     * @param ventanaPrincipal es la ventana principal donde se informará el tiempo que tomó el ordenamiento
     */
    public TareaOrdenarSeleccion( Muestra laMuestra, InterfazMuestra ventanaPrincipal )
    {
        muestra = laMuestra;
        principal = ventanaPrincipal;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta el ordenamiento y reporta el tiempo que tomó
     */
    public void run( )
    {
        long tiempoTotal = 0;
        long t1 = System.currentTimeMillis( );

        MuestraOrdenada muestraOrdenada = muestra.ordenarSeleccion( );

        long t2 = System.currentTimeMillis( );
        tiempoTotal += ( t2 - t1 );

        principal.registrarTiempoOrdenamientoSeleccion( tiempoTotal );
        principal.cambiarMuestraOrdenada( muestraOrdenada );

    }
}
