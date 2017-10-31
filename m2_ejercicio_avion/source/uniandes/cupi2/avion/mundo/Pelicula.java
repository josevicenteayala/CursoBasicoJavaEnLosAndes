package uniandes.cupi2.avion.mundo;

public class Pelicula {
	
	/**
	 * Indica que el género es Comedia
	 * */
	public static final String COMEDIA = "Comedia";
	/**
	 * Indica que el género es Acción
	 * */	
	public static final String ACCION = "Acción";
	/**
	 * Indica que el género es Drama
	 * */	
	public static final String DRAMA = "Drama";
	/**
	 * Indica que el género es Infantil
	 * */	
	public static final String INFANTIL = "Infantil";
	/**
	 * Indica que el género es Romance
	 * */	
	public static final String ROMANCE = "Romance";
	
	/**
	 * Indica que el nombre de la película
	 * */	
	private String nombre;
	/**
	 * Indica que el género de la película
	 * */	
	private String genero;
	/**
	 * Indica que la duración de la película
	 * */	
	private int duracion;
	/**
	 * Indica que el director de la película
	 * */	
	private String director;
	
	/**
	 * Crea una película con su nombre, género, duración y director
	 * <b>post: </b>La película tiene sus datos básicos nombre, género, duración y director asignados. 
	 * @param nombre - nombre de la película
	 * @param genero - género de la película
	 * @param duracion - duración de la película
	 * @param director - director de la película
	 */
	public Pelicula(String nombre, String genero, int duracion, String director) {
		this.nombre = nombre;
		this.genero = genero;
		this.duracion = duracion;
		this.director = director;
	}
	/**
	 * Retorna el nombre de la película
	 * @return nombre de la película
	 */
	public String darNombre() {
		return nombre;
	}

	/**
	 * Retorna el género de la película
	 * @return género de la película
	 */
	public String darGenero() {
		return genero;
	}

	/**
	 * Retorna la duración de la película
	 * @return duración de la película
	 */
	public int darDuracion() {
		return duracion;
	}

	/**
	 * Retorna el director de la película
	 * @return the director
	 */
	public String darDirector() {
		return director;
	}
	/**
	 * Cambia el nombre de la película
	 * @param nombre - nombre a cambiar
	 */
	public void cambiarNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Cambia el género de la película
	 * @param genero - género a cambiar
	 */
	public void cambiarGenero(String genero) {
		this.genero = genero;
	}
	/**
	 * Cambia la duración de la película
	 * @param duracion - duración a cambiar
	 */
	public void cambiarDuracion(int duracion) {
		this.duracion = duracion;
	}
	/**
	 * Cambia el director de la película
	 * @param director - director a cambiar
	 */
	public void cambiarDirector(String director) {
		this.director = director;
	}

	 /**
	  * Retorna una cadena de texto con la información de la película 
	  * siguiendo el siguiente formato:
	  * <nombre> (<genero>). <duracion> minutos - director.
	  * @return La cadena de texto con el formato definido. 
	  */	
	@Override
	public String toString() {
		return nombre+" ("+genero+"). "+duracion+" minutos - "+director+".";
	}
}
