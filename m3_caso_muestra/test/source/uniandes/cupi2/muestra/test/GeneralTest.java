package uniandes.cupi2.muestra.test;

/**
 * @author jayala
 *
 */
public class GeneralTest {

	private static final String LEON = "Leon";
	private static final String VICENTE = "Vicente";
	private static final int TAMANO_ARREGLO = 10;

	public static void main(String[] args) {
		//ejemploComparacion();
		//ordenamientoDescendentePorMecanismoDeBurbuja();
		//ordenamientoAscendentePorMecanismoDeBurbuja();
		ordemamientoAscendentePorMecanismoDeInsercion();
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

}
