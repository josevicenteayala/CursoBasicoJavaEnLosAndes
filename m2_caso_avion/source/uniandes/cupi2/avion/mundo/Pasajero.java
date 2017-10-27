/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Avión
 * Autor: Katalina Marcos - Febrero 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.avion.mundo;

/**
 * Pasajero del avión
 */
public class Pasajero
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
    /**
     * Cédula del pasajero
     */
    private int cedula;
    /**
     * Nombre del pasajero
     */
    private String nombre;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea a un pasajero con su cédula y nombre <br>
     * <b>post: </b>El pasajero tiene sus datos básicos cédula y nombre asignados.
     * @param unaCedula - cédula del pasajero - unaCedula >0
     * @param unNombre - nombre del pasajero - unNombre != ""
     */
    public Pasajero( int unaCedula, String unNombre )
    {
        cedula = unaCedula;
        nombre = unNombre;
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Retorna la cédula del pasajero
     * @return cedula del pasajero
     */
    public int darCedula( )
    {
        return cedula;
    }

    /**
     * Retorna el nombre del pasajero
     * @return nombre del pasajero
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Indica si el pasajero es igual a otro.
     * @param otroPasajero - pasajero a comparar - otroPasajero != null
     * @return true si es el mismo pasajero, false en caso contrario
     */
    public boolean igualA( Pasajero otroPasajero )
    {
        if( cedula == otroPasajero.darCedula( ) )
            return true;
        else
            return false;
    }
}