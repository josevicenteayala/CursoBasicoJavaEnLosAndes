package uniandes.nivelatorios.ordenamientoInsercion.mundo;

public class Estudiante {
	
	/**
	 * Atributo que representa el sexo de un estudiante. 'f' para femenino, 'm' para masculino
	 */
	private char sexo;
	
	/**
	 * Atributo que repreenta el carnet de un estudiante
	 */
	private Carnet carnet;
	
	/**
	 * Constructor de la clase estudiante
	 * @param nSexo sexo del estudiante
	 * @param nNombre nombre para el carnet
	 * @param nCodigo código para el carnet
	 */
	public Estudiante(char nSexo, String nNombre, int nCodigo)
	{
		sexo = nSexo;
		carnet = new Carnet(nNombre, nCodigo);
	}
	
	/**
	 * Método que retorna el carnet del estudiante
	 * @return carnet del estudiante
	 */
	public Carnet darCarnet()
	{
		return carnet;
	}
	
	/**
	 * Método que retorna el sexo del estudiante
	 * @return 'f' o 'm'
	 */
	public char darSexo()
	{
		return sexo;
	}

}
