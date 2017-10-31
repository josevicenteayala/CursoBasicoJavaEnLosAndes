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

import java.util.ArrayList;

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
    
    /**
     * Lista de películas del pasajero.
     */
    //TODO Declare el atributo
    

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
        
        //TODO Inicialice la lista de películas.
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
    
    /**
     * Devuelve la lista de películas del pasajero.
     * @return Lista de películas del pasajero.
     */
    public ArrayList darPeliculas()
    {
    	//TODO Implemente el método según la documentación.
    }
    
    /**
     * Agrega una película a la lista.
     * @param nombre Nombre de la película. nombre !="" && nombre !=null.
     * @param genero Género de la película. genero !="" && genero !=null.
     * @param duracion Duración en minutos de la película. duracion > 0.
     * @param director Director de la película. director != null && director !="".
     */
    public void agregarPelicula(String nombre, String genero, int duracion, String director)
    {
    	//TODO Implemente el método según la documentación.
    }
    
    /**
     * Devuelve la duración total de las películas programadas por el pasajero.
     * @return Suma de la duración de cada una de las películas del pasajero.
     */
    public int darDuracionTotalPeliculas()
    {
    	//TODO Implemente el método según la documentación.
    }
    
    /**
     * Devuelve una lista de las películas que pertenecen a un género determinado por parámetro. 
     * @param genero Género al que pertencen las películas.
     * @return Lista de las películas que pertenecen al género.
     */
    public ArrayList darPeliculasGenero(String genero)
    {
    	//TODO Implemente el método según la documentación.
    }
    
    /**
     * Determina si hay dos películas que tengan la misma duración.
     * @return True si hay dos películas con la misma duración, false de lo contrario.
     */
    public boolean tienePeliculasMismaDuracion()
    {
    	//TODO Implemente el método según la documentación.
    	
    }
    
    
    
    
}