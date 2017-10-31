/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelExtension.java,v 1.1 2006/07/31 16:43:19 da-romer Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co) 
 * Ejercicio: n7_muestra
 * Autor: Jorge Villalobos - 05-Sep-2005
 * Autor: Pablo Barvo - 26-Sep-2005
 * Autor: Mario Sánchez - 28-Jun-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.muestra.mundo;

import java.util.ArrayList;

/**
 * Esta clase maneja una muestra de valores enteros entre 1 y el límite superior. <br>
 * <b>inv: </b> <br>
 * valores != null <br>
 * valores.lenght > 0 <br>
 * valores.lenght >= tamanio <br>
 * tamanio >= 0 <br>
 * limiteSuperior >= 1 <br>
 * todos los valores de la muestra están entre 1 y limiteSuperior
 */
public class Muestra
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Valores de la muestra
     */
    private int valores[];

    /**
     * Límite superior para los valores de la muestra
     */
    private int limiteSuperior;

    /**
     * Número de valores en la muestra
     */
    private int tamanio;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva muestra vacía (sin elementos) con una determinada capacidad y un límite superior
     * @param capacidad es la capacidad máxima de la muestra a crear - capacidad > 0
     * @param limite es el límite superior para los valores de la muestra - limite >= 1
     */
    public Muestra( int capacidad, int limite )
    {
        valores = new int[capacidad];
        tamanio = 0;
        limiteSuperior = limite;

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Agrega un dato al final de la muestra. <br>
     * <b>pre:</b> Hay espacio para un elemento adicional en la muestra. <br>
     * <b>post:</b> Se adicionó un elemento en el arreglo y el tamaño aumentó en uno.
     * @param valor es el valor que se va a agregar a la muestra - 1 <= valor <= limiteSuperior
     */
    public void agregarDato( int valor )
    {
        valores[ tamanio ] = valor;
        tamanio++;

        verificarInvariante( );
    }

    /**
     * Retorna el valor de la muestra que se encuentra en una posición dada
     * @param posicion es la posición del elemento que queremos recuperar - 0 <= posicion < tamanio
     * @return El valor de la muestra que está en la posición pedida
     */
    public int darDato( int posicion )
    {
        return valores[ posicion ];
    }

    /**
     * Genera valores aleatorios para llenar la muestra. <br>
     * <b> post:</b> se generó un número de valores aleatorios igual a la capacidad de la muestra. <br>
     * Todos los valores generados están entre 1 y limiteSuperior
     */
    public void generarValores( )
    {
        for( int i = 0; i < valores.length; i++ )
        {
            double aleatorio = Math.random( ) * limiteSuperior;
            valores[ i ] = ( int )aleatorio + 1;
        }
        tamanio = valores.length;
    }

    /**
     * Retorna el número de valores que hay en la muestra
     * @return Número de valores presentes en la muestra
     */
    public int darTamanio( )
    {
        return tamanio;
    }

    /**
     * Retorna el número máximo de valores que puede haber en la muestra
     * @return Capacidad máxima
     */
    public int darCapacidad( )
    {
        return valores.length;
    }

    /**
     * Retorna el límite superior para los valores de la muestra
     * @return Limite superior de la muestra
     */
    public int darLimiteSuperior( )
    {
        return limiteSuperior;
    }

    /**
     * Retorna el valor más grande entre los elementos de la muestra
     * @return Máximo valor encontrado en la muestra. Si la muestra está vacía se retorna 0
     */
    public int darMaximo( )
    {
        int maximo = 0;
        for( int i = 0; i < tamanio; i++ )
        {
            if( valores[ i ] > maximo )
                maximo = valores[ i ];
        }
        return maximo;
    }

    /**
     * Retorna el valor más pequeño entre los elementos de la muestra
     * @return Mínimo valor encontrado en la muestra. Si la muestra está vacía se retorna 0
     */
    public int darMinimo( )
    {
        if( tamanio == 0 )
            return 0;
        else
        {
            int minimo = valores[ 0 ];
            for( int i = 1; i < tamanio; i++ )
            {
                if( valores[ i ] < minimo )
                    minimo = valores[ i ];
            }
            return minimo;
        }
    }

    /**
     * Retorna el valor promedio entre los elementos de la muestra
     * @return Promedio de los datos de la muestra o cero si no hay ninguno
     */
    public double darPromedio( )
    {
        double promedio = 0;
        if( tamanio != 0 )
        {
            double suma = 0;
            for( int i = 0; i < tamanio; i++ )
            {
                suma += valores[ i ];
            }
            promedio = suma / ( double )tamanio;
        }
        return promedio;
    }

    /**
     * Crea una copia de los valores de la muestra
     * @return Una copia del arreglo con los valores que hay actualmente en la muestra
     */
    public int[] darCopiaValores( )
    {
        int[] copiaValores = new int[tamanio];
        for( int i = 0; i < tamanio; i++ )
        {
            copiaValores[ i ] = valores[ i ];
        }
        return copiaValores;
    }

    /**
     * Algoritmo de Ordenamiento - Selección. <br>
     * Crea una muestra ordenada utilizando el algoritmo de selección, sin modificar la muestra actual
     * @return Retorna un objeto de la clase MuestraOrdenada con los valores ordenados de la muestra
     */
    public MuestraOrdenada ordenarSeleccion( )
    {
        int[] arreglo = darCopiaValores( );
        for( int i = 0; i < tamanio - 1; i++ )
        {
            int menor = arreglo[ i ];
            int cual = i;
            // Busca el mínimo elemento entre una posición i y el final de la lista
            for( int j = i + 1; j < tamanio; j++ )
            {
                if( arreglo[ j ] < menor )
                {
                    menor = arreglo[ j ];
                    cual = j;
                }
            }
            // Intercambia el mínimo con el elemento de la posición i
            int temp = arreglo[ i ];
            arreglo[ i ] = menor;
            arreglo[ cual ] = temp;
        }
        return new MuestraOrdenada( arreglo );
    }

    /**
     * Algoritmo de Ordenamiento - Burbuja. <br>
     * Crea una muestra ordenada utilizando el algoritmo de burbuja, sin modificar la muestra actual
     * @return Retorna un objeto de la clase MuestraOrdenada con los valores ordenados de la muestra
     */
    public MuestraOrdenada ordenarBurbuja( )
    {
        int[] arreglo = darCopiaValores( );
        for( int i = tamanio; i > 0; i-- )
        {
            for( int j = 0; j < i - 1; j++ )
            {
                // Intercambia si están en el orden equivocado
                if( arreglo[ j ] > arreglo[ j + 1 ] )
                {
                    int temp = arreglo[ j ];
                    arreglo[ j ] = arreglo[ j + 1 ];
                    arreglo[ j + 1 ] = temp;
                }
            }
        }
        return new MuestraOrdenada( arreglo );
    }

    /**
     * Algoritmo de Ordenamiento - Inserción. <br>
     * Crea una muestra ordenada utilizando el algoritmo de inserción, sin modificar la muestra actual
     * @return Retorna un objeto de la clase MuestraOrdenada con los valores ordenados de la muestra
     */
    public MuestraOrdenada ordenarInsercion( )
    {
        int[] arreglo = darCopiaValores( );
        for( int i = 1; i < tamanio; i++ )
        {
            for( int j = i; j > 0 && arreglo[ j - 1 ] > arreglo[ j ]; j-- )
            {
                int temp = arreglo[ j ];
                arreglo[ j ] = arreglo[ j - 1 ];
                arreglo[ j - 1 ] = temp;
            }
        }
        return new MuestraOrdenada( arreglo );
    }

    /**
     * Busca un valor utilizando una búsqueda secuencial
     * @param valor es el valor a buscar en el arreglo
     * @return Retorna true si encontró el valor en la muestra.
     */
    public boolean buscarSecuencial( int valor )
    {
        for( int i = 0; i < tamanio; i++ )
        {
            if( valores[ i ] == valor )
                return true;
        }
        return false;
    }

    /**
     * Cuenta el número de veces que aparece un valor en la muestra
     * @param valor es el valor que se va a buscar en la muestra
     * @return Número de ocurrencias
     */
    public int contarOcurrencias( int valor )
    {
        int ocurrencias = 0;
        for( int i = 0; i < tamanio; i++ )
        {
            if( valor == valores[ i ] )
                ocurrencias++;
        }
        return ocurrencias;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv: </b> <br>
     * valores != null <br>
     * valores.lenght > 0 <br>
     * valores.lenght >= tamanio <br>
     * tamanio >= 0 <br>
     * limiteSuperior >= 1 <br>
     * todos los valores de la muestra están entre 1 y limiteSuperior
     */
    private void verificarInvariante( )
    {
        assert valores != null : "El arreglo de valores no puede ser null";
        assert valores.length > 0 : "Debe haber por lo menos espacio para un valor";
        assert valores.length >= tamanio : "El número de elementos debe ser inferior a la capacidad del arreglo";
        assert tamanio >= 0 : "Siempre hay cero o más elementos en una muestra";
        assert limiteSuperior >= 1 : "El limite superior debe ser mayor a igual a 1";

        for( int i = 0; i < tamanio; i++ )
        {
            assert valores[ i ] > 0 && valores[ i ] <= limiteSuperior : "Los valores deben estar entre 1 y limiteSuperior";
        }
    }

    /**
    * Retorna una muestra ordenada con los elementos del arreglo ordenados de forma descendente (de mayor a menor) usando el algoritmo burbuja
    * @return Retorna un objeto MuestraOrdenada con los elementos ordenados de mayor a menor
    */
    public MuestraOrdenada ordenarBurbujaDescendente()
    {
        int[] listaValores = darCopiaValores();
        for( int i = 0; i < listaValores.length -1; i++ )
        {
            for( int j = 1; j < listaValores.length -i; j++ )
            {
                if( listaValores[ j ] > listaValores[ j - 1 ] )
                {
                    int numeroTemporal = listaValores[ j ];
                    listaValores[ j ] = listaValores[ j - 1 ];
                    listaValores[ j - 1 ] = numeroTemporal;
                }
            }
        }
        return new MuestraOrdenada( listaValores );
    }    
    
    
    /**
    * Retorna el mayor elemento del arreglo, a partir de una muestra ordenada descendentemente por algoritmo burbuja
    * @return Numero mayor del arreglo ordenado descendentemente
    */
    public int darElementoMayor()
    {
    	MuestraOrdenada muestraOrdenada = ordenarBurbujaDescendente();
    	int[] valores = muestraOrdenada.darCopiaValores();
    	if(valores != null && valores.length > 0) {
    		return valores[0]; 
    	}
    	return 0;
    }        
    
    /**
    * Retorna un arreglo de enteros con los numeros pares presentes en el
    * arreglo original
    * @return Arreglo de enteros con los numeros pares del arreglo original
    */
    public int[] darParesArreglo()
    {
    	ArrayList<Integer> arregloNumeroPares  = new ArrayList<>();
    	int[] copiaValores = darCopiaValores();
    	for (int i = 0; i < copiaValores.length; i++) {
			if(copiaValores[i] % 2 == 0) {
				arregloNumeroPares.add(Integer.valueOf(copiaValores[i]));
			}
		}
    	
    	int[] valoresPares = new int[arregloNumeroPares.size()];
    	
    	for (int i = 0; i < arregloNumeroPares.size(); i++) {
    		valoresPares[i] = arregloNumeroPares.get(i);
		}
    	
    	return valoresPares;
    }    
    
    /**
    * Retorna un objeto MuestraOrdenada con los elementos pares del arreglo ordenados de forma descedente, usando el algoritmo de seleccion.
    * @return Objeto MuestraOrdenada con los elementos pares ordenados de 
    * mayor a menor
    */
    public MuestraOrdenada ordenarParesSeleccionDescendente()
    {
    	int[] arregloDePares = darParesArreglo();
        for( int i = 0; i < arregloDePares.length - 1; i++ )
        {
            int mayor = arregloDePares[ i ];
            int cual = i;
            // Busca el mínimo elemento entre una posición i y el final de la lista
            for( int j = i + 1; j < arregloDePares.length; j++ )
            {
                if( arregloDePares[ j ] > mayor )
                {
                    mayor = arregloDePares[ j ];
                    cual = j;
                }
            }
            // Intercambia el mínimo con el elemento de la posición i
            int temp = arregloDePares[ i ];
            arregloDePares[ i ] = mayor;
            arregloDePares[ cual ] = temp;
        }
        return new MuestraOrdenada( arregloDePares );
    }    
    
    /**
    * Retorna el menor numero par del arreglo, a partir de la muestra ordenada descendentemente por algoritmo de seleccion
    * @return Menor numero par del arreglo
    */
    public int darMenorParArreglo()
    {
    	MuestraOrdenada muestraOrdenada = ordenarParesSeleccionDescendente();
    	int[] copiaValores = muestraOrdenada.darCopiaValores();
    	if(copiaValores!=null && copiaValores.length > 0) {
    		return copiaValores[copiaValores.length-1];
    	}
    	return 0;
    }    
    
    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "respuesta1";
    }

    /**
     * Método para la extensión 2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "respuesta2";
    }

    /**
     * Método para la extensión 3
     * @return respuesta3
     */
    public String metodo3( )
    {
        return "respuesta3";
    }

    /**
     * Método para la extensión 4
     * @return respuesta4
     */
    public String metodo4( )
    {
        return "respuesta4";
    }
}