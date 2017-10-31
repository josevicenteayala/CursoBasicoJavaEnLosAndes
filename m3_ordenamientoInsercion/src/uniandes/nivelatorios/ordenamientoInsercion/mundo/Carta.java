package uniandes.nivelatorios.ordenamientoInsercion.mundo;

public class Carta implements Comparable<Carta>{
	
	/**
	 * Atributo que representa el n�mero de la carta de 1 a 52 en la baraja
	 */
	private int numero;
	
	/**
	 * Atributo que representa el valor equivalente de la carta, de 1 a 13
	 */
	private int valor;
	
	/**
	 * Atributo que representa la pinta de la carta. corazones, picas, diamantes o tr�boles
	 */
	private String pinta;
	
	/**
	 * Constructor de la clase carta
	 * @param numero
	 */
	public Carta(int numero)
	{
		int numPinta = numero/13;
		
		if(numPinta == 0)
			pinta = "tr�boles";
		else if(numPinta == 1)
			pinta = "picas";
		else if(numPinta == 2)
			pinta = "corazones";
		else
			pinta = "diamantes";
		
		valor = (numero%13) + 1;
					
	}
	
	/**
	 * M�todo que retorna la pinta de la carta
	 * @return String que contiene la pinta de la carta
	 */
	public String darPinta()
	{
		return pinta;
	}
	
	/**
	 * M�todo que retorna el valor num�rico de la carta
	 * @return entero con el valor de la carta
	 */
	public int darValorNumero()
	{
		return valor;
	}
	
	/**
	 * M�todo que retorna una cadena de caracteres con el valor en t�rminos de la baraja
	 * @return String con el valor de la carta
	 */
	public String darValor()
	{
		if(valor == 1)
			return "As";
		else if(valor == 11)
			return "Jota";
		else if(valor == 12)
			return "Reina";
		else if(valor == 13)
			return "Rey";
		else
			return String.valueOf(valor);
	
	}
	
	/**
	 * M�todo que retorna el valor de la carta en t�rminos de su valor y su pinta
	 * @return String con el descriptor de la carta
	 */
	public String darValorCarta()
	{
		String numero;
	
		numero = darValor() + " de " + darPinta();
		
		return numero;
	}
	

	/**
	 * M�todo que compara el valor de la carta contra una segunda carta.
	 * El criterio de comparaci�n son los valores num�ricos. Las pintas se ignoran al
	 * comparar.
	 * @return 0 si el valor es igual, 
	 * 		   1 si el valor de c1 es mayor que el valor de la carta actual
	 *         -1 si el valor de c1 es menor que el valor de la carta actual
	 */
	public int compareTo(Carta c1) {
		
	if(c1.valor == this.valor)
		return 0;
	else if(c1.valor > this.valor)
		return 1;
	else
		return -1;
	}
	
}
