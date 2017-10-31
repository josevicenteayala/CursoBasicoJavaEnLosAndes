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
    private ArrayList<Pelicula> peliculas;

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
        peliculas = new ArrayList<>();
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
    public ArrayList<Pelicula> darPeliculas()
    {
    	return peliculas;
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
    	Pelicula pelicula = new Pelicula(nombre, genero, duracion, director);
    	peliculas.add(pelicula);
    }
    
    /**
     * Devuelve la duración total de las películas programadas por el pasajero.
     * @return Suma de la duración de cada una de las películas del pasajero.
     */
    public int darDuracionTotalPeliculas()
    {
    	int sumatoriaDuracionPelicula = 0;
    	for (int i = 0; i < peliculas.size(); i++) {
			Pelicula pelicula = peliculas.get(i);
			sumatoriaDuracionPelicula += pelicula.darDuracion();
		}
    	return sumatoriaDuracionPelicula;
    }
    
    /**
     * Devuelve una lista de las películas que pertenecen a un género determinado por parámetro. 
     * @param genero Género al que pertencen las películas.
     * @return Lista de las películas que pertenecen al género.
     */
    public ArrayList<Pelicula> darPeliculasGenero(String genero)
    {
    	ArrayList<Pelicula> listaPeliculasConGeneroIndicado = new ArrayList<>();
    	for (int i = 0; i < peliculas.size(); i++) {
			Pelicula pelicula = peliculas.get(i);
			if(pelicula.darGenero().equals(genero)) {
				listaPeliculasConGeneroIndicado.add(pelicula);
			}
		}    	
    	return listaPeliculasConGeneroIndicado;
    }
    
    /**
     * Determina si hay dos películas que tengan la misma duración.
     * @return True si hay dos películas con la misma duración, false de lo contrario.
     */
    public boolean tienePeliculasMismaDuracion()
    {
    	for (int i = 0; i < peliculas.size(); i++) {
			Pelicula pelicula = peliculas.get(i);
			for(int j = 0; j< peliculas.size();j++) {
				Pelicula pelicula2 = peliculas.get(j);
				if(!pelicula.darNombre().equalsIgnoreCase(pelicula2.darNombre()) &&  pelicula.darDuracion() == pelicula2.darDuracion()) {
					return true;
				}
			}
		}        	
    	return false;
    }
    
    /**
    * Calcula la duración promedio de las películas del pasajero.
    * @return Duración promedio de las películas del pasajero; 0 en caso que el pasajero no tenga películas
    */    
    public double calcularDuracionPromedioPeliculas() {
    	if(peliculas == null || peliculas.size() == 0) return 0;
    	int duracionPromedio = darDuracionTotalPeliculas() / peliculas.size();
    	return (double)duracionPromedio;
    }
    
    /**
    * Retorna la película de menor duración del pasajero. En caso que no tenga películas, retorna null.
    * @return Película más corta del pasajero; null en caso que no tenga
    */

    public Pelicula darPeliculaMasCorta() {
    	int duracionCorta = 999999999;
    	Pelicula peliculaCorta = null;
    	if(peliculas==null || peliculas.size()<=0) {
    		return peliculaCorta;
    	}
    	for (int i = 0; i < peliculas.size(); i++) {
			Pelicula pelicula = peliculas.get(i);
			if(duracionCorta> pelicula.darDuracion()) {
				peliculaCorta = pelicula;
				duracionCorta = pelicula.darDuracion();
			}
    	}
    	return peliculaCorta;
    }
    
    /**
    * Busca la primera película del pasajero cuyo nombre empieza por la letra dada como parámetro
    * @param letra - La letra por la cual empieza el nombre de la película buscada
    * @return - Película cuyo nombre empieza por la letra dada; null en caso de no existir ninguna que empiece por 
    * esa letra
    */
    
    public Pelicula buscarPrimerPeliculaEmpiezaPor(char letra){
    	Pelicula peliculaComienzaPorLetra = null;
    	if(peliculas==null || peliculas.size()<=0) {
    		return peliculaComienzaPorLetra;
    	}    	
    	for (int i = 0; i < peliculas.size(); i++) {
			Pelicula pelicula = peliculas.get(i);
			if(pelicula.darNombre().startsWith(String.valueOf(letra))) {
				return pelicula;
			}
    	}    	
    	return peliculaComienzaPorLetra;
    }
    
}