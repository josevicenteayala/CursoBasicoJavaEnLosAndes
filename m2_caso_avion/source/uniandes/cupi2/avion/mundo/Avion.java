/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Avión
 * Autor: Katalina Marcos - Febrero 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.avion.mundo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Avión de pasajeros
 */
public class Avion
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
    /**
     * Numero de sillas ejecutivas
     */
    public final static int SILLAS_EJECUTIVAS = 8;
    /**
     * Numero de sillas económicas
     */
    public final static int SILLAS_ECONOMICAS = 42;

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
    /**
     * Sillas de la clase ejecutiva del avión
     */
    private Silla[] sillasEjecutivas;
    /**
     * Sillas de la clase económica del avión
     */
    private Silla[] sillasEconomicas;
    
    /**
     * Lista con los pasajeros del avión
     */    
    private ArrayList<Pasajero> pasajerosActuales;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye al avión
     */
    public Avion( )
    {
        int ubicacion;

        // Crea las sillas ejecutivas
        sillasEjecutivas = new Silla[SILLAS_EJECUTIVAS];

        // crea las sillas económicas
        sillasEconomicas = new Silla[SILLAS_ECONOMICAS];

        sillasEjecutivas[ 0 ] = new Silla( 1, Silla.CLASE_EJECUTIVA, Silla.VENTANA );
        sillasEjecutivas[ 1 ] = new Silla( 2, Silla.CLASE_EJECUTIVA, Silla.PASILLO );
        sillasEjecutivas[ 2 ] = new Silla( 3, Silla.CLASE_EJECUTIVA, Silla.PASILLO );
        sillasEjecutivas[ 3 ] = new Silla( 4, Silla.CLASE_EJECUTIVA, Silla.VENTANA );
        sillasEjecutivas[ 4 ] = new Silla( 5, Silla.CLASE_EJECUTIVA, Silla.VENTANA );
        sillasEjecutivas[ 5 ] = new Silla( 6, Silla.CLASE_EJECUTIVA, Silla.PASILLO );
        sillasEjecutivas[ 6 ] = new Silla( 7, Silla.CLASE_EJECUTIVA, Silla.PASILLO );
        sillasEjecutivas[ 7 ] = new Silla( 8, Silla.CLASE_EJECUTIVA, Silla.VENTANA );

        for( int numSilla = 1 + SILLAS_EJECUTIVAS, j = 1; j <= SILLAS_ECONOMICAS; numSilla++, j++ )
        {
            //Sillas ventana
            if( j % 6 == 1 || j % 6 == 0 )
                ubicacion = Silla.VENTANA;
            //Sillas centrales
            else if( j % 6 == 2 || j % 6 == 5 )
                ubicacion = Silla.CENTRAL;
            //Sillas pasillo
            else
                ubicacion = Silla.PASILLO;

            sillasEconomicas[ j - 1 ] = new Silla( numSilla, Silla.CLASE_ECONOMICA, ubicacion );
        }
        
        pasajerosActuales = new ArrayList<>();
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Asigna la silla a un pasajero, según sus preferencias de clase y ubicación <br>
     * <b>post: </b> Si existe una silla con la clase y la ubicación dada, el pasajero queda asignado en la primera de ellas según el orden numérico.
     * @param clase - clase elegida por el pasajero - clase pertenece {CLASE_EJECUTIVA,CLASE_ECONOMICA}
     * @param ubicacion - ubicación elegida por el pasajero - si clase = CLASE_ECONOMICA entonces ubicación pertenece {VENTANA, CENTRAL, PASILLO}, o si clase = CLASE_EJECUTIVA
     *        entonces ubicación pertenece {VENTANA, PASILLO}
     * @param pasajero - pasajero a asignar - pasajero != null y no tiene silla en el avión
     * @return silla asignada - Si no se asigna una silla retorna null
     */
    public Silla asignarSilla( int clase, int ubicacion, Pasajero pasajero )
    {
        //busca una silla libre
        Silla silla = null;
        if( clase == Silla.CLASE_EJECUTIVA )
        {
            silla = buscarSillaEjecutivaLibre( ubicacion );
        }
        else if( clase == Silla.CLASE_ECONOMICA )
        {
            silla = buscarSillaEconomicaLibre( ubicacion );
        }
        if( silla != null )
        {
            silla.asignarAPasajero( pasajero );                        
            asignarPasajeroALaLista(pasajero);
        }
        return silla;
    }

	/**
	 * Guarda el pasajero en la lista siempre y cuando este no este ya en ella
	 * @param pasajero
	 */
	private void asignarPasajeroALaLista(Pasajero pasajero) {
		boolean asignarPasajero = true;
		for (int i = 0; i < pasajerosActuales.size(); i++) {
			Pasajero pasajeroBuscado = pasajerosActuales.get(i);
			if(pasajero.darCedula() == pasajeroBuscado.darCedula()) {
				asignarPasajero = false;
			}			
		} 
		if(asignarPasajero) {
			pasajerosActuales.add(pasajero);
		}
	}

    /**
     * Busca la siguiente silla ejecutiva que este libre y tenga la ubicación indicada.
     * @param ubicacion - ubicación en donde buscar la silla - ubicación pertenece {VENTANA, PASILLO}
     * @return La silla libre encontrada. Si no encuentra retorna null.
     */
    public Silla buscarSillaEjecutivaLibre( int ubicacion )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_EJECUTIVAS && !encontrado; i++ )
        {
            silla = sillasEjecutivas[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.darUbicacion( ) == ubicacion )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    /**
     * Busca la siguiente silla económica que este libre y tenga la ubicación indicada.
     * @param ubicacion - ubicación en donde buscar la silla - ubicación pertenece {VENTANA, CENTRAL, PASILLO}
     * @return la silla encontrada libre. Si no encuentra retorna null
     */
    public Silla buscarSillaEconomicaLibre( int ubicacion )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.darUbicacion( ) == ubicacion )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    /**
     * Busca un pasajero en el avión
     * @param pasajero - pasajero a buscar - pasajero != null
     * @return silla en la que se encontró el pasajero. Si no lo encuentra retorna null
     */
    public Silla buscarPasajero( Pasajero pasajero )
    {
        //Busca el pasajero en ejecutiva
        Silla silla = buscarPasajeroEjecutivo( pasajero );
        //Si no estaba en ejecutiva
        if( null == silla )
            //Busca en económica
            silla = buscarPasajeroEconomico( pasajero );
        return silla;

    }

    /**
     * Busca un pasajero en las sillas ejecutivas
     * @param pasajero - pasajero a buscar - pasajero != null
     * @return silla en la que se encontró el pasajero. Si no lo encuentra retorna null
     */
    public Silla buscarPasajeroEjecutivo( Pasajero pasajero )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_EJECUTIVAS && !encontrado; i++ )
        {
            silla = sillasEjecutivas[ i ];
            if( silla.sillaAsignada( ) && silla.darPasajero( ).igualA( pasajero ) )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    /**
     * Busca la lista de sillas ejecutivas asignadas que tiene un pasajero
     * @param pasajero - pasajero a buscar - pasajero != null
     * @return lista sillas ejecutivas asignadas al pasajero
     */
    public ArrayList<Silla> buscarSillasEjecutivasAsignadasAPasajero( Pasajero pasajero )
    {
    	ArrayList<Silla> listaSillasAsignadasAPasajero = new ArrayList<>();
        Silla silla = null;
        for( int i = 0; i < SILLAS_EJECUTIVAS; i++ )
        {
            silla = sillasEjecutivas[ i ];
            if( silla.sillaAsignada( ) && silla.darPasajero( ).igualA( pasajero ) )
            {
            	listaSillasAsignadasAPasajero.add(silla);
            }
        }
        return listaSillasAsignadasAPasajero;
    }    
    
    /**
     * Busca la lista de sillas economicas asignadas que tiene un pasajero
     * @param pasajero - pasajero a buscar - pasajero != null
     * @return lista sillas economicas asignadas al pasajero
     */
    public ArrayList<Silla> buscarSillasEconomicasAsignadasAPasajero( Pasajero pasajero )
    {
    	ArrayList<Silla> listaSillasAsignadasAPasajero = new ArrayList<>();
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( silla.sillaAsignada( ) && silla.darPasajero( ).igualA( pasajero ) )
            {
            	listaSillasAsignadasAPasajero.add(silla);
            }
        }
        return listaSillasAsignadasAPasajero;
    }     
    
    /**
     * Busca un pasajero en las sillas económicas
     * @param pasajero - pasajero a buscar - pasajero != null
     * @return silla en la que se encontró el pasajero. Si no lo encuentra retorna null
     */
    public Silla buscarPasajeroEconomico( Pasajero pasajero )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( silla.sillaAsignada( ) && silla.darPasajero( ).igualA( pasajero ) )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    /**
     * Desasigna la silla de un pasajero <br>
     * <b>post: </b> Si se encuentra una silla con el pasajero, la silla quedara con su pasajero == null
     * @param pasajero - pasajero a retirar - pasajero != null
     * @return true si encontró el pasajero y desasignó la silla, false en caso contrario
     */
    public boolean desasignarSilla( Pasajero pasajero )
    {
        //Busca el pasajero en el avión
        Silla silla = buscarPasajero( pasajero );
        //Si lo encuentra desasigna
        if( silla != null )
        {
            silla.desasignarSilla( );
            return true;
        }
        else
            return false;
    }

    /**
     * Retorna el número de sillas ejecutivas ocupadas
     * @return numero de ejecutivas sillas ocupadas
     */
    public int contarSillasEjecutivasOcupadas( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_EJECUTIVAS; i++ )
        {
            if( sillasEjecutivas[ i ].sillaAsignada( ) )
            {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Retorna el número de sillas económicas ocupadas
     * @return numero de sillas económicas ocupadas
     */
    public int contarSillasEconomicasOcupadas( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_ECONOMICAS; i++ )
        {
            if( sillasEconomicas[ i ].sillaAsignada( ) )
            {
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Cuenta el número de sillas económicas, que están ubicadas en la 
     * ventana y que se encuentran libres
     * @return - Número de sillas económicas libres y que están en la ventana
     */
    public int contarSillasEconomicasDesocupadasVentana( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_ECONOMICAS; i++ )
        {
            if( !sillasEconomicas[ i ].sillaAsignada( ) && sillasEconomicas[ i ].darUbicacion() == Silla.VENTANA)
            {
                contador++;
            }
        }
        return contador;
    }    
    
    /**
     * Cuenta el número de sillas económicas, que están ubicadas en el 
     * pasillo y que se encuentran libres
     * @return - Número de sillas económicas libres y que están en el pasillo
     */
    public int contarSillasEconomicasDesocupadasPasillo( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_ECONOMICAS; i++ )
        {
            if( !sillasEconomicas[ i ].sillaAsignada( ) && sillasEconomicas[ i ].darUbicacion() == Silla.PASILLO)
            {
                contador++;
            }
        }
        return contador;
    }     

    /**
     * Cuenta el número de sillas económicas, que están ubicadas en el 
     * centro y que se encuentran libres
     * @return - Número de sillas económicas libres y que están en el centro
     */
    public int contarSillasEconomicasDesocupadasCentro( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_ECONOMICAS; i++ )
        {
            if( !sillasEconomicas[ i ].sillaAsignada( ) && sillasEconomicas[ i ].darUbicacion() == Silla.CENTRAL)
            {
                contador++;
            }
        }
        return contador;
    }    
    
    
    /**
     * Cuenta el número de sillas ejeceutivas, que están ubicadas en la 
     * ventana y que se encuentran libres
     * @return - Número de sillas ejecutivas libres y que están en la ventana
     */
    public int contarSillasEjecutivasDesocupadasVentana( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_EJECUTIVAS; i++ )
        {
            if( !sillasEjecutivas[ i ].sillaAsignada( ) && sillasEjecutivas[ i ].darUbicacion() == Silla.VENTANA)
            {
                contador++;
            }
        }
        return contador;
    }    
    
    /**
     * Cuenta el número de sillas ejecutivas, que están ubicadas en el 
     * pasillo y que se encuentran libres
     * @return - Número de sillas ejecutivas libres y que están en el pasillo
     */
    public int contarSillasEjecutivasDesocupadasPasillo( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_EJECUTIVAS; i++ )
        {
            if( !sillasEjecutivas[ i ].sillaAsignada( ) && sillasEjecutivas[ i ].darUbicacion() == Silla.PASILLO)
            {
                contador++;
            }
        }
        return contador;
    }       
    
    /**
     * Indica si hay por lo menos un cierto numero de sillas económicas *disponibles en el pasillo o en la ventana.
     * @param - nSillas - Minimo numero de sillas libres que se busca, ubicadas *en pasillo o ventana
     * @return - True si hay por lo menos nSillas libres en pasillo o ventana, *false en caso contrario
     */
    public boolean hayNumSillasEconomicasLibresPasilloVentana(int nSillas)
    {
        return contarSillasEconomicasDesocupadasVentana() + contarSillasEconomicasDesocupadasPasillo() >= nSillas;
    }
    
    /**
     * Busca la primera silla económica que este libre y tenga la ubicación *indicada, revisando desde la parte de atrás del avión
     * @param ubicacion - ubicación en donde buscar la silla - ubicacion *pertenece {VENTANA, CENTRAL, PASILLO}
     * @return La silla encontrada libre. Si no encuentra retorna null
     */
    public Silla buscarSillaEconomicaLibreReves(int ubicacion)
    {	
    	 for( int i = SILLAS_ECONOMICAS-1; i >=0 ; i-- ) {
             if( !sillasEconomicas[ i ].sillaAsignada( ) && sillasEconomicas[ i ].darUbicacion() == ubicacion)
             {
                 return sillasEconomicas[ i ];
             }    		 
    	 }
    	return null;
    }    
    
    /**
     * Retorna una lista con todas las sillas vacías del avión
     * @return - Lista con todas las sillas vacías del avión
     */
    public ArrayList<Silla> darSillasVacias()
    {
    	ArrayList<Silla> listaSillasVacias = new ArrayList<>();
    	listaSillasEconomicasVacias(listaSillasVacias);
    	listaSillasEjecutivasVacias(listaSillasVacias);
        return listaSillasVacias;
    }

	private ArrayList<Silla> listaSillasEconomicasVacias(ArrayList<Silla> listaSillasVacias) {		
	   	 for( int i =0; i < SILLAS_ECONOMICAS ; i++ ) {
	         if( !sillasEconomicas[ i ].sillaAsignada( ))
	         {
	        	 listaSillasVacias.add(sillasEconomicas[ i ]);
	         }    		 
		 }
		return listaSillasVacias;
	}    
    
	private ArrayList<Silla> listaSillasEjecutivasVacias(ArrayList<Silla> listaSillasVacias) {		
	   	 for( int i =0; i < SILLAS_EJECUTIVAS ; i++ ) {
	         if( !sillasEjecutivas[ i ].sillaAsignada( ))
	         {
	        	 listaSillasVacias.add(sillasEjecutivas[ i ]);
	         }    		 
		 }
		return listaSillasVacias;
	} 	
    
    /**
     * Retorna el número total de sillas ocupadas en el avión
     * @return - Total de sillas ocupadas en el avión
     */
    public int darNumTotalSillasOcupadas()
    {
        return contarSillasEconomicasOcupadas() + contarSillasEjecutivasOcupadas(); 
    }
	
    /**
     * Indica si hay dos sillas vacías con la misma ubicación en el avión, *Solo se comparan sillas de la misma clase
     * @return - True si hay dos vacías con la misma ubicación, false de lo *contrario
     */
    public boolean hayDosSillasVaciasMismaUbicacion()
    {
    	final int DOS_SILLAS_DESOCUPADAS = 2;
		if(contarSillasEconomicasDesocupadasVentana() == DOS_SILLAS_DESOCUPADAS) {
    		return true;
    	}
    	if(contarSillasEconomicasDesocupadasPasillo() == DOS_SILLAS_DESOCUPADAS) {
    		return true;
    	} 
    	if(contarSillasEconomicasDesocupadasCentro() == DOS_SILLAS_DESOCUPADAS) {
    		return true;
    	}
    	if(contarSillasEjecutivasDesocupadasVentana() == DOS_SILLAS_DESOCUPADAS) {
    		return true;
    	}
    	if(contarSillasEjecutivasDesocupadasPasillo() == DOS_SILLAS_DESOCUPADAS) {
    		return true;
    	}    	
    	return false;
    }    
    
	
    /**
     * Calcula el porcentaje de ocupación del avión
     * @return porcentaje total de ocupación
     */
    public double calcularPorcentajeOcupacion( )
    {
        double porcentaje;
        int totalSillas = SILLAS_ECONOMICAS + SILLAS_EJECUTIVAS;
        int sillasOcupadas = contarSillasEconomicasOcupadas( ) + contarSillasEjecutivasOcupadas( );
        porcentaje = ( double )sillasOcupadas / totalSillas * 100;
        return porcentaje;
    }

    /**
     * Retorna las sillas ejecutivas del avión
     * @return sillas ejecutivas
     */
    public Silla[] obtenerSillasEjecutivas( )
    {
        return sillasEjecutivas;
    }

    /**
     * Retorna las sillas económicas del avión
     * @return sillas económicas
     */
    public Silla[] obtenerSillasEconomicas( )
    {
        return sillasEconomicas;
    }

    /**
     * Método 1 de extensión al ejemplo
     * @return respuesta
     */
    public String metodo1( )
    {
        return "respuesta 1";
    }

    /**
     * Método 2 de extensión al ejemplo
     * @return respuesta
     */
    public String metodo2( )
    {
        return "respuesta 2";
    }
    
    /**
     * Retorna el porcentaje de sillas económicas pares que están ocupadas
     * @return - Porcentaje de sillas económicas pares ocupadas
     */
    public double darPorcentajeSillasEconomicasOcupadasPares()
    {
        int contadorSillasEconomicasParesDesocupadas = 0;
        for( int i = 0; i < SILLAS_ECONOMICAS; i++ )
        {
            if( sillasEconomicas[ i ].sillaAsignada( ) && i % 2 == 0)
            {
                contadorSillasEconomicasParesDesocupadas++;
            }
        }        
        int totalSillasEconomicasPares = SILLAS_ECONOMICAS/2;
		return ( double )contadorSillasEconomicasParesDesocupadas / totalSillasEconomicasPares * 100;
    }
    
    /**
     * Retorna el número de parejas de sillas económicas contiguas ocupadas.
     * Las sillas separadas por el pasillo NO cuentan como contiguas 
     * @return - Número de parejas de sillas económicas contiguas ocupadas
     */
    public int darNumParejasSillasEconomicasContiguasOcupadas()
    {
    	int numeroParejasSillasEconomicasContiguasOcupadas = 0;
    	int posicionInicialAEvaluar = SILLAS_EJECUTIVAS + 1;
    	
    	boolean esLaPrimeraComparacion = true;
        for( int posicionEnArreglo = 0; posicionEnArreglo < SILLAS_ECONOMICAS;)
        {        	
			if(sillasEconomicas[posicionEnArreglo].darNumero() == posicionInicialAEvaluar) {
        		if(sillasEconomicas[posicionEnArreglo].sillaAsignada() && sillasEconomicas[++posicionEnArreglo].sillaAsignada()) {
        			numeroParejasSillasEconomicasContiguasOcupadas++;
        		}
        		if(esLaPrimeraComparacion) {
        			posicionInicialAEvaluar += 1;
        			esLaPrimeraComparacion = false;
        		}else {
        			posicionInicialAEvaluar += 2;
        			esLaPrimeraComparacion = true;
        		}
        	}else {        		
        		++posicionEnArreglo;        		
        	}
        }    	
        return numeroParejasSillasEconomicasContiguasOcupadas;
    } 
    
    /**
     * Busca un pasajero dentro de la lista de pasajeros dada su cedula
     * @param pCedula - Cedula del pasajero
     * @return El pasajero con la cedula dada. Null en caso de que no exista * un pasajero
     * con esa cedula
     */
    public Pasajero buscarPasajero(int pCedula)
    {
    	for (int i = 0; i < pasajerosActuales.size(); i++) {
    		Pasajero pasajero = pasajerosActuales.get(i);
    		if(pasajero.darCedula() == pCedula) {
    			return pasajero;
    		}			
		}   	
    	return null;
    }
    
    /**
     * Retorna el número de sillas asignadas al pasajero dado como parámetro
     * @param pPasajero - Pasajero del que se quiere saber el número de *sillas 
     * que tiene asignadas
     * @return Número de sillas asignadas al pasajero dado como parámetro
     */
    public int darNumSillasAsignadasPasajero(Pasajero pPasajero)
    {
    	ArrayList<Silla> listaSillasEejcutivasAsignadasAPasajero = buscarSillasEjecutivasAsignadasAPasajero(pPasajero);
    	ArrayList<Silla> listaSillasEconomicasAsignadasAPasajero = buscarSillasEconomicasAsignadasAPasajero(pPasajero);
    	return listaSillasEejcutivasAsignadasAPasajero.size() + listaSillasEconomicasAsignadasAPasajero.size();
    }   
    
    /**
     * Retorna el pasajero que tiene más sillas asignadas en el avión
     * @return - Pasajero con más sillas asignadas en el avión
     */
    public Pasajero darPasajeroMasSillasAsignadas()
    {
    	Pasajero pasajeroConMayorNumeroDeSillas = null;
    	int numeroSillasASignadas = 0;
		for (int i = 0; i < pasajerosActuales.size(); i++) {
			Pasajero pasajeroActual = pasajerosActuales.get(i);
			int numeroSillasAsignadasPasajero = darNumSillasAsignadasPasajero(pasajeroActual);
			if(numeroSillasASignadas < numeroSillasAsignadasPasajero) {
				pasajeroConMayorNumeroDeSillas = pasajeroActual;
				numeroSillasASignadas = numeroSillasAsignadasPasajero;
			}
		} 
		return pasajeroConMayorNumeroDeSillas;
    }    
    
    /**
     * Indica si hay dos pasajeros con el mismo nombre en el avión, a partir
     * de la lista de pasajeros actuales
     * @return - True si hay dos pasajeros con el mismo nombre, false en *caso contrario
     */
    public boolean hayPasajerosHomonimos()
    {
    	for (int i = 0; i < pasajerosActuales.size(); i++) {
    		String nombre = pasajerosActuales.get(i).darNombre();
        	for (int j = 0; j < pasajerosActuales.size(); j++) {
        		if(pasajerosActuales.get(j).darNombre().equals(nombre) && pasajerosActuales.get(j).darCedula() != pasajerosActuales.get(i).darCedula()) {
        			return true;
        		}
        	}    		
    	}
    	
    	return false;
    }    
    
}