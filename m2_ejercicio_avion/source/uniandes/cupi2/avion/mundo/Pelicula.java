package uniandes.cupi2.avion.mundo;

public class Pelicula {
	
	public static final String COMEDIA = "Comedia";
	public static final String ACCION = "Acción";
	public static final String DRAMA = "Drama";
	public static final String INFANTIL = "Infantil";
	public static final String ROMANCE = "Romance";
	
	private String nombre;
	private String genero;
	private int duracion;
	private String director;
	
	public Pelicula(String nombre, String genero, int duracion, String director) {
		this.nombre = nombre;
		this.genero = genero;
		this.duracion = duracion;
		this.director = director;
	}
	/**
	 * @return the nombre
	 */
	public String darNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the genero
	 */
	public String darGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the duracion
	 */
	public int darDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the director
	 */
	public String darDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

}
