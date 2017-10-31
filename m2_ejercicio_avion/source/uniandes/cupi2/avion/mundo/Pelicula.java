package uniandes.cupi2.avion.mundo;

public class Pelicula {
	
	/**
	 * Indica que el g�nero es Comedia
	 * */
	public static final String COMEDIA = "Comedia";
	/**
	 * Indica que el g�nero es Acci�n
	 * */	
	public static final String ACCION = "Acci�n";
	/**
	 * Indica que el g�nero es Drama
	 * */	
	public static final String DRAMA = "Drama";
	/**
	 * Indica que el g�nero es Infantil
	 * */	
	public static final String INFANTIL = "Infantil";
	/**
	 * Indica que el g�nero es Romance
	 * */	
	public static final String ROMANCE = "Romance";
	
	/**
	 * Indica que el nombre de la pel�cula
	 * */	
	private String nombre;
	/**
	 * Indica que el g�nero de la pel�cula
	 * */	
	private String genero;
	/**
	 * Indica que la duraci�n de la pel�cula
	 * */	
	private int duracion;
	/**
	 * Indica que el director de la pel�cula
	 * */	
	private String director;
	
	/**
	 * Crea una pel�cula con su nombre, g�nero, duraci�n y director
	 * <b>post: </b>La pel�cula tiene sus datos b�sicos nombre, g�nero, duraci�n y director asignados. 
	 * @param nombre - nombre de la pel�cula
	 * @param genero - g�nero de la pel�cula
	 * @param duracion - duraci�n de la pel�cula
	 * @param director - director de la pel�cula
	 */
	public Pelicula(String nombre, String genero, int duracion, String director) {
		this.nombre = nombre;
		this.genero = genero;
		this.duracion = duracion;
		this.director = director;
	}
	/**
	 * Retorna el nombre de la pel�cula
	 * @return nombre de la pel�cula
	 */
	public String darNombre() {
		return nombre;
	}

	/**
	 * Retorna el g�nero de la pel�cula
	 * @return g�nero de la pel�cula
	 */
	public String darGenero() {
		return genero;
	}

	/**
	 * Retorna la duraci�n de la pel�cula
	 * @return duraci�n de la pel�cula
	 */
	public int darDuracion() {
		return duracion;
	}

	/**
	 * Retorna el director de la pel�cula
	 * @return the director
	 */
	public String darDirector() {
		return director;
	}
	/**
	 * Cambia el nombre de la pel�cula
	 * @param nombre - nombre a cambiar
	 */
	public void cambiarNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Cambia el g�nero de la pel�cula
	 * @param genero - g�nero a cambiar
	 */
	public void cambiarGenero(String genero) {
		this.genero = genero;
	}
	/**
	 * Cambia la duraci�n de la pel�cula
	 * @param duracion - duraci�n a cambiar
	 */
	public void cambiarDuracion(int duracion) {
		this.duracion = duracion;
	}
	/**
	 * Cambia el director de la pel�cula
	 * @param director - director a cambiar
	 */
	public void cambiarDirector(String director) {
		this.director = director;
	}

	 /**
	  * Retorna una cadena de texto con la informaci�n de la pel�cula 
	  * siguiendo el siguiente formato:
	  * <nombre> (<genero>). <duracion> minutos - director.
	  * @return La cadena de texto con el formato definido. 
	  */	
	@Override
	public String toString() {
		return nombre+" ("+genero+"). "+duracion+" minutos - "+director+".";
	}
}
