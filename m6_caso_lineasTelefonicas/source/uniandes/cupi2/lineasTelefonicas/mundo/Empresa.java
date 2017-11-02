/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_lineasTelefonicas
 * Autor: Pablo Barvo - 06-Dec-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.lineasTelefonicas.mundo;

/**
 * Clase que representa la empresa
 */
public class Empresa
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Línea telefónica número 1
     */
    private LineaTelefonica linea1;

    /**
     * Línea telefónica número 2
     */
    private LineaTelefonica linea2;

    /**
     * Línea telefónica número 3
     */
    private LineaTelefonica linea3;
    
    /**
     * Línea telefónica celular número 1
     */
    private LineaCelular lineaCelular1;
    

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Constructor que inicializa las líneas telefónicas de la empresa <br>
     * <b>post: </b> Se inicializaron las 3 líneas telefónicas básicas y la línea celular.
     */
    public Empresa( )
    {
        //Crea la línea telefónica 1
        linea1 = new LineaTelefonica( );

        //Crea la línea telefónica 2
        linea2 = new LineaTelefonica( );

        //Crea la línea telefónica 3
        linea3 = new LineaTelefonica( );
        
        //Crea la línea telefónica celular 1
        lineaCelular1 = new LineaCelular( );
    }

    /**
     * Devuelve la línea 1
     * @return Línea 1
     */
    public LineaTelefonica darLinea1( )
    {
        return linea1;
    }

    /**
     * Devuelve la línea 2
     * @return Línea 2
     */
    public LineaTelefonica darLinea2( )
    {
        return linea2;
    }

    /**
     * Devuelve la línea 3
     * @return Línea 3
     */
    public LineaTelefonica darLinea3( )
    {
        return linea3;
    }

    /**
     * Devuelve la línea telefónica celular 1
     * @return Línea telefónica celular 1
     */
    public LineaCelular darLineaCelular1( )
    {
        return lineaCelular1;
    }
    
    /**
     * Agrega una llamada local a la línea telefónica 1 <br>
     * <b>post: </b> Se agrega la llamada a la línea 1
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLocalLinea1( int minutos )
    {
        linea1.agregarLlamadaLocal( minutos );
    }

    /**
     * Agrega una llamada local a la línea telefónica 2 <br>
     * <b>post: </b> Se agrega la llamada a la línea 2
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLocalLinea2( int minutos )
    {
        linea2.agregarLlamadaLocal( minutos );
    }

    /**
     * Agrega una llamada local a la línea telefónica 3 <br>
     * <b>post: </b> Se agrega la llamada a la línea 3
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLocalLinea3( int minutos )
    {
        linea3.agregarLlamadaLocal( minutos );
    }

    /**
     * Agrega una llamada local a la línea telefónica celular 1 <br>
     * <b>post: </b> Se agrega la llamada local a la línea telefónica celular 1
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public boolean agregarLlamadaLocalLineaCelular1( int minutos )
    {
    	if(lineaCelular1.darSaldoDisponibleLocal() < minutos*20)
    	{
    		return false;
    	}
    	else
    	{  	
    		lineaCelular1.agregarLlamadaLocal( minutos );
    		return true;
    	}
    }
    
    /**
     * Agrega una llamada de larga distancia a la línea telefónica 1 <br>
     * <b>post: </b> Se agrega la llamada a la línea 1
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea1( int minutos )
    {
        linea1.agregarLlamadaLargaDistancia( minutos );
    }

    /**
     * Agrega una llamada de larga distancia a la línea telefónica 2 <br>
     * <b>post: </b> Se agrega la llamada a la línea 2
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea2( int minutos )
    {
        linea2.agregarLlamadaLargaDistancia( minutos );
    }

    /**
     * Agrega una llamada de larga distancia a la línea telefónica 3 <br>
     * <b>post: </b> Se agrega la llamada a la línea 3
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea3( int minutos )
    {
        linea3.agregarLlamadaLargaDistancia( minutos );
    }

    /**
     * Agrega una llamada a celular a la línea telefónica 1 <br>
     * <b>post: </b> Se agrega la llamada a la línea 1
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaCelularLinea1( int minutos )
    {
        linea1.agregarLlamadaCelular( minutos );
    }

    /**
     * Agrega una llamada a celular a la línea telefónica 2 <br>
     * <b>post: </b> Se agrega la llamada a la línea 2
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaCelularLinea2( int minutos )
    {
        linea2.agregarLlamadaCelular( minutos );
    }

    /**
     * Agrega una llamada a celular a la línea telefónica 3 <br>
     * <b>post: </b> Se agrega la llamada a la línea 3
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaCelularLinea3( int minutos )
    {
        linea3.agregarLlamadaCelular( minutos );
    }
    
    /**
     * Agrega una llamada a celular a la línea telefónica celular 1 <br>
     * <b>post: </b> Se agrega la llamada celular a la línea telefónica celular 1
     * @param minutos Número de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaCelularLineaCelular1( int minutos )
    {
        lineaCelular1.agregarLlamadaCelular( minutos );
    }

    /**
     * Devuelve el nú8mero total de llamadas realizadas desde lineas telefónicas alternativas
     * @return total de llamadas de las tres líneas
     */
    public int darTotalNumeroLlamadasDesdeLineasNoAlternativas( )
    {
        int total = linea1.darNumeroLlamadas( ) + linea2.darNumeroLlamadas( ) + linea3.darNumeroLlamadas( );
        return total;
    }
    
    /**
     * Devuelve el número total de llamadas realizadas desde lineas telefónicas alternativas
     * @return
     */
    public int darTotalNumeroLlamadasDesdeLineasAlternativas()
    {
    	return lineaCelular1.darNumeroLlamadas();
    }

    /**
     * Devuelve el total de minutos consumidos
     * @return total de minutos de las tres líneas
     */
    public int darTotalMinutosDesdeLineasNoAlternativas( )
    {
        int total = linea1.darNumeroMinutos( ) + linea2.darNumeroMinutos( ) + linea3.darNumeroMinutos( );
        return total;
    }
    
    /**
     * Devuelve el total de minutos consumidos desde líneas alternativas
     * @return total de minutos de las líneas alternativas
     */
    public int darTotalMinutosDesdeLineasAlternativas()
    {
    	return lineaCelular1.darNumeroMinutos();
    }

    /**
     * Devuelve el costo total de las llamadas realizadas
     * @return costo total de las tres líneas
     */
    public double darTotalCostoLlamadasDesdeLineasNoAlternativas( )
    {
        double total = linea1.darCostoLlamadas( ) + linea2.darCostoLlamadas( ) + linea3.darCostoLlamadas( );
        return total;
    }

    /**
     * Devuelve el costo total de las llamadas realizadas desde líneas alternativas
     * @return costo total de las líneas alternativas
     */
    public double darTotalCostoLlamadasDesdeLineasAlternativas()
    {
    	return lineaCelular1.darCostoLlamadas();
    }
    
    /**
     * Devuelve el costo promedio de un minuto, según los minutos consumidos <br>
     * <b>pre: </b> TotalMinutos > 0
     * @return Costo promedio por minuto.
     */
    public double darCostoPromedioMinutoDesdeLineasNoAlternativas( )
    {
        double promedio = darTotalCostoLlamadasDesdeLineasNoAlternativas( ) / darTotalMinutosDesdeLineasNoAlternativas( );
        return promedio;
    }
    
    /**
     * Devuelve el costo promedio de un minuto desde una línea alternativa, según los minutos consumidos <br>
     * <b>pre: </b> TotalMinutos > 0
     * @return Costo promedio por minuto.
     */
    public double darCostoPromedioMinutoDesdeLineasAlternativas( )
    {
        double promedio = darTotalCostoLlamadasDesdeLineasAlternativas( ) / darTotalMinutosDesdeLineasAlternativas( );
        return promedio;
    }
    
    /**
     * Devuelve el saldo disponible para hacer llamadas desde las líneas alternativas
     * @return saldo disponible 
     */
    public double darSaldoDisponibleLineasAlternativas()
    {
    	return lineaCelular1.darSaldoDisponibleLocal();
    }

    /**
     * Reinicia todas las líneas telefónicas.
     */
    public void reiniciarLineasNoAlternativas( )
    {
        linea1.reiniciar( );
        linea2.reiniciar( );
        linea3.reiniciar( );
    }

    public void reiniciarLineasAlternativas()
    {
    	lineaCelular1.reiniciar();
    }
    
    
    
    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return Respuesta 1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     * @return Respuesta 2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}