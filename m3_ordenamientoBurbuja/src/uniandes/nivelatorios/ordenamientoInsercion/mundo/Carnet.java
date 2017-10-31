package uniandes.nivelatorios.ordenamientoInsercion.mundo;

public class Carnet {
	
	/**
	 * Nombre del estudiante en el carnet
	 */
	private String nombre;
	
	/**
	 * Código del estudiante en el carnet
	 */
	private int codigo;
	
	/**
	 * Constructor de la clase Carnet
	 * @param nNombre nombre del estudiante
	 * @param nCodigo código del estudiante
	 */
	public Carnet(String nNombre, int nCodigo)
	{
		nombre = nNombre;
		codigo = nCodigo;
	}

	/**
	 * Método que retorna el nombre del estudiante como aparece en el carnet
	 * @return nombre
	 */
	public String darNombre()
	{
		return nombre;
	}
	
	/**
	 * Método que retorna el código del estudiante según el carnet
	 * @return código
	 */
	public int darCodigo()
	{
		return codigo;
	}
}
