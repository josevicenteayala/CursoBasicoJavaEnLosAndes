/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: TareaActualizarProgreso.java,v 1.4 2006/08/06 20:26:47 da-romer Exp $
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

/**
 * Esta tarea se encarga de actualizar la ventana de progreso.<br>
 * Este tarea deber�a ser llamada desde el EventDispatchingThread
 */
public class TareaActualizarProgreso implements Runnable
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * La ventana de progreso que deber� ser actualizada
     */
    private VentanaProgreso progreso;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la tarea
     * @param ventana es la ventana de progreso que deber� ser actualizada - ventana != null
     */
    public TareaActualizarProgreso( VentanaProgreso ventana )
    {
        progreso = ventana;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Avanza un paso en la animaci�n de la ventana de progreso
     */
    public void run( )
    {
        progreso.avanzar( );
    }

}
