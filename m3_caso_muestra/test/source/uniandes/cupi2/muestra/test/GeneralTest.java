package uniandes.cupi2.muestra.test;

import uniandes.cupi2.muestra.mundo.MuestraOrdenada;

/**
 * @author jayala
 *
 */
public class GeneralTest {

	private static final String LEON = "Leon";
	private static final String VICENTE = "Vicente";
	private static final int TAMANO_ARREGLO = 10;
	private static int[] arreglo = new int[] {15,20,3,7,1,9,8,16,10,21};

	public static void main(String[] args) {
		//ejemploComparacion();
		//ordenamientoDescendentePorMecanismoDeBurbuja();
		//ordenamientoAscendentePorMecanismoDeBurbuja();
		//ordemamientoAscendentePorMecanismoDeInsercion();
		//ejercicioOrdenamiento2();
		//ordenamientoEnterosConBurbuja();
		ejercicioOrdenamientoBurbuja();
		//ordenamientoEnterosConInsercionAscendente();
		//ordenamientoEnterosConSeleccionAscendente();
		//ordenamientoEnterosConBurbujaAscendente();
		//ordenamientoEnterosConInsercionDescendente();
		//ordenamientoEnterosConSeleccionDescendente();
		//ordenamientoEnterosConBurbujaDescendente();
	}

	private static void ordemamientoAscendentePorMecanismoDeInsercion() {
		String numeros[] = inicializarArreglo();
		String numeroTemporalMenor = null;
		for (int i = 1; i < numeros.length; i++) {
			for (int j = i; j > 0; j--) {
				if(numeros[j].compareTo(numeros[j-1]) < 0) {
					numeroTemporalMenor = numeros[j];
					numeros[j] = numeros[j-1];
					numeros[j-1] = numeroTemporalMenor;
				}else {
					System.out.println("Entro al break");
					break;
				}
			}
		}
		imprimirArreglo(numeros);		
	}	
	
	/**
	 * Permite ordenar de manera descendente el arreglo, usando el metodo de Burbuja
	 */
	private static void ordenamientoDescendentePorMecanismoDeBurbuja() {
		String numeros[] = inicializarArreglo();		
		String numeroTemporalMayor = null;
		
		for (int i = 0; i < numeros.length -1; i++) {
			for (int j = 1; j < numeros.length -i; j++) {
				if(numeros[j].compareTo(numeros[j-1]) > 0) {
					numeroTemporalMayor = numeros[j];
					numeros[j] = numeros[j-1];
					numeros[j-1] = numeroTemporalMayor;
				}
			}
		}
		
		imprimirArreglo(numeros);
	}

	/**
	 * Permite ordenar de manera ascendente el arreglo, usando el metodo de Burbuja
	 */
	private static void ordenamientoAscendentePorMecanismoDeBurbuja() {
		String numeros[] = inicializarArreglo();		
		String numeroTemporalMenor = null;
		
		for (int i = 0; i < numeros.length -1; i++) {
			for (int j = 1; j < numeros.length -i; j++) {
				if(numeros[j].compareTo(numeros[j-1]) < 0) {
					numeroTemporalMenor = numeros[j];
					numeros[j] = numeros[j-1];
					numeros[j-1] = numeroTemporalMenor;
				}
			}
		}
		
		imprimirArreglo(numeros);
	}	
	
	/**
	 * Geenra un arrelo de numeros
	 * @return String []
	 */
	private static String[] inicializarArreglo() {
		String numeros[] = new String[TAMANO_ARREGLO];
		int contador = 0;
		while(contador < TAMANO_ARREGLO) {
			numeros[contador++] = String.valueOf(Math.ceil(Math.random()*10));
		}
		return numeros;
	}
	
	/**
	 * Imprime el contenido de un arreglo
	 * @param numeros
	 */
	private static void imprimirArreglo(String[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
	}
	
	private static void ejemploComparacion() {
		System.out.println(VICENTE.compareTo(LEON));
		System.out.println(LEON.compareTo(VICENTE));
		System.out.println(VICENTE.compareTo(VICENTE));
	}
	
	
	private static void ordenamientoEnterosConBurbujaAscendente() {
		int contador = 0;
		for (int i = arreglo.length; i > 0; i--) {
			contador++;
			for (int j = 0; j < i - 1; j++) {
				// Intercambia si estan en el orden equivocado
				if (arreglo[j] > arreglo[j + 1]) {
					int temp = arreglo[j];
					arreglo[j] = arreglo[j + 1];
					arreglo[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < arreglo.length; i++) {
			int j = arreglo[i];
			System.out.println(j);
		}
	}
	
	private static void ordenamientoEnterosConBurbujaDescendente() {
		int contador = 0;
		for (int i = arreglo.length; i > 0 && contador < 2; i--) {
			contador++;
			for (int j = 0; j < i - 1; j++) {
				if (arreglo[j] < arreglo[j + 1]) {
					int temp = arreglo[j];
					arreglo[j] = arreglo[j + 1];
					arreglo[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < arreglo.length; i++) {
			int j = arreglo[i];
			System.out.println(j);
		}
	}
		
	
	public static void ordenamientoEnterosConSeleccionAscendente() {
		int contador = 0;
		for (int i = 0; i < arreglo.length - 1; i++) {
			contador ++;
			int menor = arreglo[i];
			int cual = i;
			// Busca el minimo elemento entre una posicion i y el final de la lista
			for (int j = i + 1; j < arreglo.length; j++) {
				if (arreglo[j] < menor) {
					menor = arreglo[j];
					cual = j;
				}
			}
			// Intercambia el minimo con el elemento de la posicion i
			int temp = arreglo[i];
			arreglo[i] = menor;
			arreglo[cual] = temp;
			
			if(arreglo[0] == 6) {
				System.out.println("cantidad de ciclos externos para ordenar el primer elemento "+contador);		
			}
		}
		for (int i = 0; i < arreglo.length; i++) {
			int j = arreglo[i];
			System.out.println(j);
		}
		System.out.println("cantidad de ciclos externos "+contador);
	}	
	
	public static void ordenamientoEnterosConSeleccionDescendente() {
		int contador = 0;
		for (int i = 0; i < arreglo.length - 1; i++) {
			contador ++;
			int menor = arreglo[i];
			int cual = i;
			for (int j = i + 1; j < arreglo.length; j++) {
				if (arreglo[j] > menor) {
					menor = arreglo[j];
					cual = j;
				}
			}
			// Intercambia el minimo con el elemento de la posicion i
			int temp = arreglo[i];
			arreglo[i] = menor;
			arreglo[cual] = temp;
		}
		for (int i = 0; i < arreglo.length; i++) {
			int j = arreglo[i];
			System.out.println(j);
		}
	}	
	
	public static void ordenamientoEnterosConInsercionAscendente() {
		int contador = 0;
		for (int i = 10; i < arreglo.length; i++) {
			contador ++;
			for (int j = i; j > 0 && arreglo[j - 1] > arreglo[j]; j--) {
				int temp = arreglo[j];
				arreglo[j] = arreglo[j - 1];
				arreglo[j - 1] = temp;
			}
		}
		for (int i = 0; i < arreglo.length; i++) {
			int j = arreglo[i];
			System.out.println(j);
		}
		System.out.println("ciclos realizados "+contador);
	}
	
	public static void ordenamientoEnterosConInsercionDescendente() {
		int contador = 0;
		for (int i = 1; i < arreglo.length; i++) {
			contador ++;
			for (int j = i; j > 0 && arreglo[j - 1] < arreglo[j]; j--) {
				int temp = arreglo[j];
				arreglo[j] = arreglo[j - 1];
				arreglo[j - 1] = temp;
			}
		}
		for (int i = 0; i < arreglo.length; i++) {
			int j = arreglo[i];
			System.out.println(j);
		}
	}	
	
	private static void ejercicioOrdenamientoBurbuja() {
		
		int a = 2* arreglo .length/3;
        for ( int i = 0; i < a; i++ )
        {
            for ( int j = 0; j < a-i-1; j++ )
            {
            	if( arreglo[ j ] < arreglo[ j + 1 ] )
            	{
            		int temp = arreglo[ j ];
            		arreglo[ j ] = arreglo[ j + 1 ];
            		arreglo[ j + 1 ] = temp;
            	}
            }
        }	
        for (int i = 0; i < arreglo.length; i++) {
			int j = arreglo[i];
			System.out.println(j);	
		}        
	}
	
	private static void ejercicioOrdenamiento2() {
		  //Aquí debería declararse la variable de tipo entero donde se acumulará el resultado.
		int sumaValores = 0;
		  
		  //Aquí deberían declararse las variables de tipo entero a, b y c que definen los límites de los dos ciclos. No olvide que es un ordenamiento por inserción.
		  
		int b = arreglo.length;
		int a = 1;
		int c = 0;
		for ( int i = a; i < b; i++ )
		  {
		        boolean termino = false ;
		        
				for ( int j = i; j > c && !termino ;  j-- )
		        {
		              if ( arreglo[j] < arreglo[j-1] )
		             {
		                //Piense en las modificaciones necesarias para tener en cuenta el nuevo requerimiento
		            	  sumaValores+= arreglo[j] + arreglo[j +1];
		                 int temp = arreglo [j-1];
		                 arreglo[j-1] = arreglo[j];
		                 arreglo[j]= temp;
		              }
		              else
		              {
		                  termino = true;
		              }
		        }
		   }
		for (int i = 0; i < arreglo.length; i++) {
			System.out.println(arreglo[i]);
		}
		System.out.println("Suma de valores "+sumaValores);		
	}
	
	
	public static void ordenarArreglo1()
	{
	   for ( int i = 0; i < arreglo.length; i += 2 )         
	   {
	        int menor = arreglo[i];
	        int pos = i;
	        for ( int j = i+2; j < arreglo.length; j+=2)
	        {
	              if ( arreglo[j] < menor )
	              {
	                  menor = arreglo[j];
	                  pos = j;
	              }
	        }
	        
	        int temp = arreglo[i];
	        arreglo[i] = menor;
	        arreglo[pos] = temp;
	   }
	}

	public static void ordenarArreglo2()
	{
	   for ( int i = 3; i < arreglo.length; i+=2 )
	   {
	        boolean termino = false;
	        for ( int j = i;  j > 1 && !termino; j -= 2 )
	        {                    
	            if ( arreglo[j] < arreglo[j-2] )
	            {
	                int temp = arreglo [j-2];
	                arreglo[j-2] = arreglo[j];
	                arreglo[j] = temp;
	            }
	            else
	                termino = true;
	        }
	   }
	}

	public static void metodo3()
	{
	  ordenarArreglo1();
	  ordenarArreglo2();
	}	
	

}
