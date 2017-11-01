/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ExposicionPerros.java,v 1.5 2006/08/04 15:12:57 da-romer Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_exposicionCanina 
 * Autor: Mario Sánchez - 26/08/2005 
 * Modificado por: Daniel Romero- 30/06/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.exposicionCanina.mundo;

import java.util.*;

/**
 * Es la clase que se encarga de manejar, organizar, cargar y salvar los perros. <br>
 * <b>inv: </b> <br>
 * perros != null <br>
 * no hay dos perros con el mismo nombre
 */
public class ExposicionPerros
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el vector que contiene todos los perros
     */
    private ArrayList<Perro> perros;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo manejador de perros vacío.
     */
    public ExposicionPerros( )
    {
        perros = new ArrayList<>( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de perros. La lista que se retorna no es la misma que la almacenada en esta clase, pero si tiene el mismo orden.
     * @return Lista de perros
     */
    public ArrayList<Perro> darPerros( )
    {
        ArrayList<Perro> copiaLista = new ArrayList<>( perros );
        return copiaLista;
    }

    /**
     * Organiza la lista de perros por raza usando el algoritmo de burbuja. <br>
     * <b>post: </b>La lista de perros está ordenada por raza (orden ascendente).
     */
    public void ordenarPorRaza( )
    {
    	if(!perros.isEmpty()){
    		for (int i = perros.size(); i > 0; i--) {
				for (int j = 0; j < i-1; j++) {
					Perro perro1 = perros.get(j);
					Perro perro2 = perros.get(j+1);
					if(perro1.compararPorRaza(perro2) == Perro.MENOR) {
						Perro perroTemporal = perro2;
						perros.set(j+1, perro1);
						perros.set(j, perroTemporal);
					}
				}
			}
    	}
    }

    /**
     * Organiza la lista de perros por nombre usando el algoritmo de inserción<br>
     * <b>post: </b>La lista de perros está ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre( )
    {
    	if(!perros.isEmpty()){
    		for(int i = 1; i < perros.size(); i++) {    			
    			for(int j = i; j > 0 && ( perros.get(j -1).compararPorNombre(perros.get(j)) == Perro.MENOR );j--) {
    				Perro perroTemporal = perros.get(j);
    				perros.set(j,perros.get(j-1));
    				perros.set(j-1, perroTemporal);
    			}
    		}
    	}
    }
    /**
     * Organiza la lista de perros por puntos usando el algoritmo de burbuja<br>
     * <b>post: </b>La lista de perros está ordenada por puntos (orden ascendente).
     */
    public void ordenarPorPuntos( )
    {
    	if(!perros.isEmpty()){
    		for (int i = perros.size(); i > 0; i--) {
				for (int j = 0; j < i-1; j++) {
					if(perros.get(j).compararPorPuntos(perros.get(j+1)) == Perro.MENOR) {
						Perro perroTemporal = perros.get(j+1);
						perros.set(j+1, perros.get(j));
						perros.set(j, perroTemporal);
					}
				}
			}
    	}    	
    }

    /**
     * Organiza la lista de perros por edad usando el algoritmo de selección. <br>
     * <b>post: </b>La lista de perros está ordenada por edad (orden ascendente).
     */
    public void ordenarPorEdad( )
    {
    	if(!perros.isEmpty()) {
    		for(int i = 0; i < perros.size(); i++) {
    			Perro perroMasPequenoEncontrado = perros.get(i);
    			int posicionDondeEstaElMenor = i;
    			for(int j = i + 1; j < perros.size(); j++) {
    				if(perroMasPequenoEncontrado.compararPorEdad(perros.get(j)) == Perro.MENOR) {
    					perroMasPequenoEncontrado = perros.get(j); 
    					posicionDondeEstaElMenor = j;
    				}
    			}    			
    			Perro perroTemporal = perros.get(i);
    			perros.set(i, perroMasPequenoEncontrado);
    			perros.set(posicionDondeEstaElMenor, perroTemporal);
    		}
    	}
    }

    /**
     * Busca un perro según su nombre y retorna la posición en la que se encuentra.
     * @param nombre es el nombre del perro buscado - nombre!=null
     * @return Retorna la posición donde se encuentra un perro con el nombre dado. Si no se encuentra ningún perro con ese nombre retorna -1
     */
    public int buscarPerro( String nombre )
    {
        int posicion = -1;
        boolean termine = false;

        for( int i = 0; i < perros.size( ) && !termine; i++ )
        {
            Perro perroPosicion = ( Perro )perros.get( i );
            String nombrePerro = perroPosicion.darNombre( );

            // Los nombres son iguales
            if( nombrePerro.equalsIgnoreCase( nombre ) )
            {
                posicion = i;
                termine = true;
            }
        }

        return posicion;
    }

    /**
     * Busca un perro utilizando una búsqueda binaria. <br>
     * <b>pre: </b> La lista de perros se encuentra ordenada por nombre.
     * @param nombre es el nombre del perro que se va a buscar - nombre!=null
     * @return La posición del perro con el nombre dado. Si el perro no existe se retorna -1.
     */
    public int buscarBinarioPorNombre( String nombre )
    {
        int posicion = -1;
        int inicio = 0;
        int fin = perros.size( ) - 1;
        Perro aBuscar = new Perro( nombre, "", "", 1, 1 );
        while( inicio <= fin && posicion == -1 )
        {
            int medio = ( inicio + fin ) / 2;
            Perro mitad = ( Perro )perros.get( medio );
            if( mitad.compararPorNombre( aBuscar ) == 0 )
            {
                posicion = medio;
            }
            else if( mitad.compararPorNombre( aBuscar ) > 0 )
            {
                fin = medio - 1;
            }
            else
            {
                inicio = medio + 1;
            }
        }
        return posicion;
    }

    /**
     * Agrega un nuevo perro a la exposición. <br>
     * <b>post: </b> El perro fue agregado a la exposición si no existe otro perro con el mismo nombre.
     * @param nombreP es el nombre del perro - nombreP != null
     * @param razaP es la raza del perro - razaP != null
     * @param imagenP es la ruta a la imagen del perro - imagenP != null
     * @param puntosP son Los puntos del perro en la exposición - puntosP >= 0
     * @param edadP es la edad en meses del perro - edadP >= 0
     * @return True si el perro fue adicionado o false de lo contrario
     */
    public boolean agregarPerro( String nombreP, String razaP, String imagenP, int puntosP, int edadP )
    {
        int perroBuscado = buscarPerro( nombreP );
        boolean agregado = false;
        if( perroBuscado == -1 )
        {
            Perro nuevoPerro = new Perro( nombreP, razaP, imagenP, puntosP, edadP );
            perros.add( nuevoPerro );
            agregado = true;
        }

        verificarInvariante( );

        return agregado;
    }

    /**
     * Busca el perro que tenga el mayor puntaje en la exposición.
     * @return Retorna la posición donde se encuentra el perro con el mayor puntaje. Si no hay perros en la exposición se retorna -1
     */
    public int buscarPerroMayorPuntaje( )
    {
        int posicion = -1;

        if( perros.size( ) > 0 )
        {
            Perro pMayorPuntaje = ( Perro )perros.get( 0 );
            posicion = 0;
            for( int i = 1; i < perros.size( ); i++ )
            {
                Perro perroPosicion = ( Perro )perros.get( i );

                // Los nombres son iguales
                if( pMayorPuntaje.compararPorPuntos( perroPosicion ) == -1 )
                {
                    posicion = i;
                    pMayorPuntaje = perroPosicion;
                }
            }
        }

        return posicion;
    }

    /**
     * Busca el perro que tenga el menor puntaje en la exposición.
     * @return Retorna la posición donde se encuentra el perro con el menor puntaje. Si no hay perros en la exposición se retorna -1
     */
    public int buscarPerroMenorPuntaje( )
    {
        int posicion = -1;

        if( perros.size( ) > 0 )
        {
            Perro pMenorPuntaje = ( Perro )perros.get( 0 );
            posicion = 0;
            for( int i = 1; i < perros.size( ); i++ )
            {
                Perro perroPosicion = ( Perro )perros.get( i );

                // Los nombres son iguales
                if( pMenorPuntaje.compararPorPuntos( perroPosicion ) == 1 )
                {
                    posicion = i;
                    pMenorPuntaje = perroPosicion;
                }
            }
        }

        return posicion;
    }

    /**
     * Busca el perro que tenga la mayor edad.
     * @return Retorna la posición donde se encuentra el perro con la mayor edad. Si no hay perros en la exposición se retorna -1
     */
    public int buscarPerroMayorEdad( )
    {
        int posicion = -1;

        if( perros.size( ) > 0 )
        {
            Perro pMayorEdad = ( Perro )perros.get( 0 );
            posicion = 0;
            for( int i = 1; i < perros.size( ); i++ )
            {
                Perro perroPosicion = ( Perro )perros.get( i );

                // Los nombres son iguales
                if( pMayorEdad.compararPorEdad( perroPosicion ) == -1 )
                {
                    posicion = i;
                    pMayorEdad = perroPosicion;
                }
            }
        }

        return posicion;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv </b> perros != null y no hay dos perros con el mismo nombre
     */
    private void verificarInvariante( )
    {
        assert ( perros != null ) : "La lista de perros no debe ser null";
        assert ( !buscarPerrosConNombresRepetidos( ) ) : "Hay dos perros con el mismo nombre";
    }

    /**
     * Verifica si hay dos perros con el mismo nombre.
     * @return Retorna true si hay dos perros con el mismo nombre, retorna false en caso contrario
     */
    private boolean buscarPerrosConNombresRepetidos( )
    {
        for( int i = 0; i < perros.size( ); i++ )
        {
            Perro perroI = ( Perro )perros.get( i );
            for( int j = 0; j < perros.size( ); j++ )
            {
                if( i != j )
                {
                    Perro perroJ = ( Perro )perros.get( j );
                    if( perroJ.darNombre( ).equals( perroI.darNombre( ) ) )
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
    * Ordena el vector de perros por edad descendentemente, usando el algoritmo de insercion
    */
    public void ordenarPorEdadDesc()
    {
    	if(!perros.isEmpty()){
    		for(int i = 1; i < perros.size(); i++) {    			
    			for(int j = i; j > 0 && ( perros.get(j -1).compararPorEdad(perros.get(j)) == Perro.MAYOR );j--) {
    				Perro perroTemporal = perros.get(j);
    				perros.set(j,perros.get(j-1));
    				perros.set(j-1, perroTemporal);
    			}
    		}
    	}        
    }    
    
    /**
    * Retorna el perro de menor edad del vector, a partir del vector ordenado 
    * por edad de mayor a menor.
    * @return Perro de menor edad de la exposicion
    */
    public Perro darPerroMenorEdad()
    {
    	ordenarPorEdadDesc();
    	if(!perros.isEmpty()) {
    		return perros.get(perros.size()-1);
    	}
    	return null;
    }    
    
    /**
    * Ordena el vector de perros de forma descendente por raza, usando el algoritmo burbuja
    */
    public void ordenarPorRazaDesc()
    {
    	if(!perros.isEmpty()){
    		for (int i = perros.size(); i > 0; i--) {
				for (int j = 0; j < i-1; j++) {
					if(perros.get(j).compararPorRaza(perros.get(j+1)) == Perro.MAYOR) {
						Perro perroTemporal = perros.get(j+1);
						perros.set(j+1, perros.get(j));
						perros.set(j, perroTemporal);
					}
				}
			}
    	}     	
    }    
    
    /**
    * Retorna la raza mas popular de la exposicion, a partir del vector ordenado descendentemente por raza
    * @return Raza mas popular de la exposicion
    */
    public String darRazaMasPopular()
    {
    	ordenarPorRazaDesc();
		String razaMasPopular = null;
    	if(!perros.isEmpty()) {
    		Map<String,Integer> mapaConCantidadPorRaza = new HashMap<>();
    		for (int i = 1; i < perros.size(); i++) {
				String razaAComparar = perros.get(i).darRaza();
				if(mapaConCantidadPorRaza.containsKey(razaAComparar)) {
					int cantidad = mapaConCantidadPorRaza.get(razaAComparar)+1;
					mapaConCantidadPorRaza.put(razaAComparar, cantidad);
				}else {
					mapaConCantidadPorRaza.put(razaAComparar, 1);
				}
			}
    		
    		if(!mapaConCantidadPorRaza.isEmpty()) {
    			Set<String> keySet = mapaConCantidadPorRaza.keySet();
    			Iterator<String> iterator = keySet.iterator();
    			int cantidadPorRaza = 0;
    			while(iterator.hasNext()) {
    				String raza = iterator.next();
    				Integer cantidad = mapaConCantidadPorRaza.get(raza);
    				if(cantidad > 1 && cantidad > cantidadPorRaza) {
    					cantidadPorRaza = cantidad;
    					razaMasPopular = raza;
    				}
    			}
    		}
    	}    	
    	return razaMasPopular;
    }    
    
    
    /**
    * Retorna la mediana de puntos de la exposicion, a partir del vector de perros ordenado por puntos
    * @return Mediana de puntos de la exposicion
    */
    public double darMedianaPuntos()
    {
    	ordenarPorPuntos();
    	if(perros != null && !perros.isEmpty()) {
			int cantidadValores = perros.size();
			if(cantidadValores % 2 == 0) {
				int mitad = (cantidadValores / 2) - 1;
				double valorMedio1 = perros.get(mitad).darPuntos();
				double valorMedio2 = perros.get(++mitad).darPuntos();
				return  ( valorMedio1 + valorMedio2) / 2 ;
			}else {
				int valorMedio = ((cantidadValores + 1) / 2) - 1;
				return Double.valueOf(perros.get(valorMedio).darPuntos());
			}    		
    	}
    	return 0;
    }    
    
    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensión 1.
     * @return respuesta 1
     */
    public void metodo1( )
    {
    	ordenarPorEdadDesc();
    }

    /**
     * Ejecuta el punto de extensión 2.
     * @return respuesta 2
     */
    public void metodo2( )
    {
    	ordenarPorRazaDesc();
    }
}