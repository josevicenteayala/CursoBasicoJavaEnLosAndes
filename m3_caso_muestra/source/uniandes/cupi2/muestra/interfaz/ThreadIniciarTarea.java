/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ThreadIniciarTarea.java,v 1.4 2006/08/06 20:26:47 da-romer Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License versi�n 2.1
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_muestra
 * Autor: Mario S�nchez - 3/07/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.muestra.interfaz;

/**
 * Este thread es el encargado de iniciar la ejecuci�n de una tarea.<br>
 * Se utiliza este thread para no iniciar la ejecuci�n justo desde el EventDispatchingThread; si se hiciera as�, entonces no ser�a posible la correcta actualizaci�n de la
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
     * @param ventana es la ventana donde se mostrar� el progreso de la tarea - ventana != null
     */
    public ThreadIniciarTarea( VentanaProgreso ventana )
    {
        ventanaProgreso = ventana;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicia la ejecuci�n de la tarea en la ventana
     */
    public void run( )
    {
        ventanaProgreso.iniciarTarea( );
    }
}
