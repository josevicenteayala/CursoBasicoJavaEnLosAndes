package uniandes.nivelatorios.ordenamientoInsercion.mundo;

public class Carnet {
	
	/**
	 * Nombre del estudiante en el carnet
	 */
	private String nombre;
	
	/**
	 * C�digo del estudiante en el carnet
	 */
	private int codigo;
	
	/**
	 * Constructor de la clase Carnet
	 * @param nNombre nombre del estudiante
	 * @param nCodigo c�digo del estudiante
	 */
	public Carnet(String nNombre, int nCodigo)
	{
		nombre = nNombre;
		codigo = nCodigo;
	}

	/**
	 * M�todo que retorna el nombre del estudiante como aparece en el carnet
	 * @return nombre
	 */
	public String darNombre()
	{
		return nombre;
	}
	
	/**
	 * M�todo que retorna el c�digo del estudiante seg�n el carnet
	 * @return c�digo
	 */
	public int darCodigo()
	{
		return codigo;
	}
}
