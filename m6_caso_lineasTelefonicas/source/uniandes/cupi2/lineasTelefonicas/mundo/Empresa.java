/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
     * Lnea teleifonica n�mero 1
     */
    private LineaTelefonica linea1;

    /**
     * Linea telefonica numero 2
     */
    private LineaTelefonica linea2;

    /**
     * Linea telefonica numero 3
     */
    private LineaTelefonica linea3;
    
    /**
     * Linea telefonica celular numero 1
     */
    private LineaCelular lineaCelular1;
    

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Constructor que inicializa las l�neas telef�nicas de la empresa <br>
     * <b>post: </b> Se inicializaron las 3 l�neas telef�nicas b�sicas y la l�nea celular.
     */
    public Empresa( )
    {
        //Crea la l�nea telef�nica 1
        linea1 = new LineaTelefonica( );

        //Crea la l�nea telef�nica 2
        linea2 = new LineaTelefonica( );

        //Crea la l�nea telef�nica 3
        linea3 = new LineaTelefonica( );
        
        //Crea la l�nea telef�nica celular 1
        lineaCelular1 = new LineaCelular( );
    }

    /**
     * Devuelve la l�nea 1
     * @return L�nea 1
     */
    public LineaTelefonica darLinea1( )
    {
        return linea1;
    }

    /**
     * Devuelve la l�nea 2
     * @return L�nea 2
     */
    public LineaTelefonica darLinea2( )
    {
        return linea2;
    }

    /**
     * Devuelve la l�nea 3
     * @return L�nea 3
     */
    public LineaTelefonica darLinea3( )
    {
        return linea3;
    }

    /**
     * Devuelve la l�nea telef�nica celular 1
     * @return L�nea telef�nica celular 1
     */
    public LineaCelular darLineaCelular1( )
    {
        return lineaCelular1;
    }
    
    /**
     * Agrega una llamada local a la l�nea telef�nica 1 <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 1
     * @param minutos N�mero de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLocalLinea1( int minutos )
    {
        linea1.agregarLlamadaLocal( minutos );
    }

    /**
     * Agrega una llamada local a la l�nea telef�nica 2 <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 2
     * @param minutos N�mero de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLocalLinea2( int minutos )
    {
        linea2.agregarLlamadaLocal( minutos );
    }

    /**
     * Agrega una llamada local a la l�nea telef�nica 3 <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 3
     * @param minutos N�mero de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLocalLinea3( int minutos )
    {
        linea3.agregarLlamadaLocal( minutos );
    }

    /**
     * Agrega una llamada local a la l�nea telef�nica celular 1 <br>
     * <b>post: </b> Se agrega la llamada local a la l�nea telef�nica celular 1
     * @param minutos N�mero de minutos de la llamada. minutos > 0.
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
     * Agrega una llamada de larga distancia a la l�nea telef�nica 1 <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 1
     * @param minutos N�mero de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea1( int minutos )
    {
        linea1.agregarLlamadaLargaDistancia( minutos );
    }

    /**
     * Agrega una llamada de larga distancia a la l�nea telef�nica 2 <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 2
     * @param minutos N�mero de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea2( int minutos )
    {
        linea2.agregarLlamadaLargaDistancia( minutos );
    }

    /**
     * Agrega una llamada de larga distancia a la l�nea telef�nica 3 <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 3
     * @param minutos N�mero de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaLargaDistanciaLinea3( int minutos )
    {
        linea3.agregarLlamadaLargaDistancia( minutos );
    }

    /**
     * Agrega una llamada a celular a la l�nea telef�nica 1 <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 1
     * @param minutos N�mero de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaCelularLinea1( int minutos )
    {
        linea1.agregarLlamadaCelular( minutos );
    }

    /**
     * Agrega una llamada a celular a la l�nea telef�nica 2 <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 2
     * @param minutos N�mero de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaCelularLinea2( int minutos )
    {
        linea2.agregarLlamadaCelular( minutos );
    }

    /**
     * Agrega una llamada a celular a la l�nea telef�nica 3 <br>
     * <b>post: </b> Se agrega la llamada a la l�nea 3
     * @param minutos N�mero de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaCelularLinea3( int minutos )
    {
        linea3.agregarLlamadaCelular( minutos );
    }
    
    /**
     * Agrega una llamada a celular a la l�nea telef�nica celular 1 <br>
     * <b>post: </b> Se agrega la llamada celular a la l�nea telef�nica celular 1
     * @param minutos N�mero de minutos de la llamada. minutos > 0.
     */
    public void agregarLlamadaCelularLineaCelular1( int minutos )
    {
        lineaCelular1.agregarLlamadaCelular( minutos );
    }

    /**
     * Devuelve el n�8mero total de llamadas realizadas desde lineas telef�nicas alternativas
     * @return total de llamadas de las tres l�neas
     */
    public int darTotalNumeroLlamadasDesdeLineasNoAlternativas( )
    {
        int total = linea1.darNumeroLlamadas( ) + linea2.darNumeroLlamadas( ) + linea3.darNumeroLlamadas( );
        return total;
    }
    
    /**
     * Devuelve el n�mero total de llamadas realizadas desde lineas telef�nicas alternativas
     * @return
     */
    public int darTotalNumeroLlamadasDesdeLineasAlternativas()
    {
    	return lineaCelular1.darNumeroLlamadas();
    }

    /**
     * Devuelve el total de minutos consumidos
     * @return total de minutos de las tres l�neas
     */
    public int darTotalMinutosDesdeLineasNoAlternativas( )
    {
        int total = linea1.darNumeroMinutos( ) + linea2.darNumeroMinutos( ) + linea3.darNumeroMinutos( );
        return total;
    }
    
    /**
     * Devuelve el total de minutos consumidos desde l�neas alternativas
     * @return total de minutos de las l�neas alternativas
     */
    public int darTotalMinutosDesdeLineasAlternativas()
    {
    	return lineaCelular1.darNumeroMinutos();
    }

    /**
     * Devuelve el costo total de las llamadas realizadas
     * @return costo total de las tres l�neas
     */
    public double darTotalCostoLlamadasDesdeLineasNoAlternativas( )
    {
        double total = linea1.darCostoLlamadas( ) + linea2.darCostoLlamadas( ) + linea3.darCostoLlamadas( );
        return total;
    }

    /**
     * Devuelve el costo total de las llamadas realizadas desde l�neas alternativas
     * @return costo total de las l�neas alternativas
     */
    public double darTotalCostoLlamadasDesdeLineasAlternativas()
    {
    	return lineaCelular1.darCostoLlamadas();
    }
    
    /**
     * Devuelve el costo promedio de un minuto, seg�n los minutos consumidos <br>
     * <b>pre: </b> TotalMinutos > 0
     * @return Costo promedio por minuto.
     */
    public double darCostoPromedioMinutoDesdeLineasNoAlternativas( )
    {
        double promedio = darTotalCostoLlamadasDesdeLineasNoAlternativas( ) / darTotalMinutosDesdeLineasNoAlternativas( );
        return promedio;
    }
    
    /**
     * Devuelve el costo promedio de un minuto desde una l�nea alternativa, seg�n los minutos consumidos <br>
     * <b>pre: </b> TotalMinutos > 0
     * @return Costo promedio por minuto.
     */
    public double darCostoPromedioMinutoDesdeLineasAlternativas( )
    {
        double promedio = darTotalCostoLlamadasDesdeLineasAlternativas( ) / darTotalMinutosDesdeLineasAlternativas( );
        return promedio;
    }
    
    /**
     * Devuelve el saldo disponible para hacer llamadas desde las l�neas alternativas
     * @return saldo disponible 
     */
    public double darSaldoDisponibleLineasAlternativas()
    {
    	return lineaCelular1.darSaldoDisponibleLocal();
    }

    /**
     * Reinicia todas las l�neas telef�nicas.
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
    // Puntos de Extensi�n
    //-----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     * @return Respuesta 1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n2
     * @return Respuesta 2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}