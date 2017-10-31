/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ThreadIniciarTarea.java,v 1.4 2006/08/06 20:26:47 da-romer Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License versión 2.1
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_muestra
 * Autor: Mario Sánchez - 3/07/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.muestra.interfaz;

/**
 * Este thread es el encargado de iniciar la ejecución de una tarea.<br>
 * Se utiliza este thread para no iniciar la ejecución justo desde el EventDispatchingThread; si se hiciera así, entonces no sería posible la correcta actualización de la
 * ventana de progreso.
 */
public class ThreadIniciarTarea extends Thread
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * La ventana donde se muestra el progreso de la tarea
     */
    private VentanaProgreso ventanaProgreso;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el thread
     * @param ventana es la ventana donde se mostrará el progreso de la tarea - ventana != null
     */
    public ThreadIniciarTarea( VentanaProgreso ventana )
    {
        ventanaProgreso = ventana;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicia la ejecución de la tarea en la ventana
     */
    public void run( )
    {
        ventanaProgreso.iniciarTarea( );
    }
}
