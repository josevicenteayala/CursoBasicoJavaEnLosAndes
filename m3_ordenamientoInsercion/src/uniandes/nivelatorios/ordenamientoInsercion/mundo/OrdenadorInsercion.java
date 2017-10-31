package uniandes.nivelatorios.ordenamientoInsercion.mundo;

import java.util.ArrayList;
import java.util.Random;

public class OrdenadorInsercion {

	/**
	 * Arreglo de cartas a mostrar
	 */
	private Carta cartas[];
	
	/**
	 * Constructor de la clase OrdenadorInsercion
	 * El arreglo de cartas inicia en 6
	 */
	public OrdenadorInsercion()
	{
		cartas = new Carta[6];
		elegirCartasAleatoriamente();
	}
	
	/**
	 * Método que retorna el arreglo de cartas
	 * @return arreglo de objetos tipo Carta
	 */
	public Carta[] darCartas()
	{
		return cartas;
	}
	
	/**
	 * Método que elige las cartas iniciales sin repetir
	 */
	public void elegirCartasAleatoriamente()
	{
		Random rand= new Random();
		int carta;

		ArrayList cartasElegidas = new ArrayList(5);
		
		for(int i = 0; i < cartas.length; i++)
		{
			carta = rand.nextInt(52);
			while(cartasElegidas.contains(carta))
			{
				carta = rand.nextInt(52);
			}
			cartasElegidas.add(carta);
			cartas[i] = new Carta(carta);
		
		}
	}
	
	/**
	 * Método que ordena las cartas usando el Algoritmo de Inserción.
	 * 
	 */
	public void ordenarCartasPorInsercion()
	{
		Carta temp;
		for(int n = 1; n < cartas.length; n++)
		{
			for(int m = n; m > 0; m--)
			{
				if(cartas[m].compareTo(cartas[m-1]) > 0)
				{
					temp = cartas[m];
					cartas[m] = cartas[m-1];
					cartas[m-1] = temp;
				}
				else
					break;
			}
		}
	}
}
