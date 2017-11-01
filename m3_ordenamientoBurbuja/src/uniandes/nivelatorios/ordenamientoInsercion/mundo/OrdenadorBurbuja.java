package uniandes.nivelatorios.ordenamientoInsercion.mundo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;


public class OrdenadorBurbuja {

	/**
	 * Atributo que representa la lista de estudiantes
	 */
	private Estudiante estudiantes[];
	
	/**
	 * Lista de todos los estudiantes posibles para poner en la lista
	 */
	private ArrayList<Estudiante> estudiantesElegibles;
	
	/**
	 * Atributo que representa el último código disponible para asignárselo a un estudiante
	 */
	private int ultimoCodigo;
	
	/**
	 * Constructor de la clase Ordenador Burbuja
	 * Crea una lista de 6 estudiantes y lee un archivo de texto con todos los posibles
	 * estudiantes para seleccionarlos.
	 */
	public OrdenadorBurbuja()
	{		
		estudiantesElegibles = new ArrayList<Estudiante>();
		
		estudiantes = new Estudiante[6];
		
		BufferedReader br;
		String line;
		String[] lineData;
		
		ultimoCodigo = 0;
		
		try {
			FileReader fr = new FileReader("data/nombres.dat");
			br = new BufferedReader(fr);

			line = br.readLine();
			while(line != null)
			{
				lineData = line.split(":");
				estudiantesElegibles.add(new Estudiante(lineData[1].charAt(0), lineData[0], ultimoCodigo));
				ultimoCodigo++;
				line = br.readLine();
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
		
		elegirEstudiantesAleatoriamente();
	}
	
	/**
	 * Método que retorna la lista de estudiantes
	 * @return la lista de estudiantes
	 */
	public Estudiante[] darEstudiantes()
	{
		return estudiantes;
	}
	
	/**
	 * Método que selecciona de la lista de estudiants elegibles, 6 estudiantes para ordenar.
	 */
	public void elegirEstudiantesAleatoriamente()
	{
		Random rand= new Random();
		int estudiante;

		ArrayList estudiantesElegidos = new ArrayList(5);
		
		for(int n = 0; n < estudiantes.length; n++)
		{
			estudiante = rand.nextInt(41);
			while(estudiantesElegidos.contains(estudiante))
			{
				estudiante = rand.nextInt(41);
			}
			estudiantesElegidos.add(estudiante);
			estudiantes[n] = estudiantesElegibles.get(estudiante);
		
		}
	}
	
	/**
	 * Método que ordena a los estudiantes usando el algoritmo de ordenamiento burbuja
	 */
	public void ordenarEstudiantesPorBurbuja()
	{
		Estudiante temp;
		for(int n = 0; n < estudiantes.length- 1 ; n++)
		{
			for(int m = 1; m <estudiantes.length -n; m++)
			{
				if(estudiantes[m].darCarnet().darNombre().compareTo(estudiantes[m-1].darCarnet().darNombre()) < 0)
				{
					temp = estudiantes[m];
					estudiantes[m] = estudiantes[m-1];
					estudiantes[m-1] = temp;
				}
			}
		}
	}
}
