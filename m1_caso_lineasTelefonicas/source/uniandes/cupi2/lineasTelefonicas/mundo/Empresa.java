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

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Inicializa las líneas telefónicas de la empresa <br>
     * <b>post: </b> Se inicializaron las 3 líneas telefónicas.
     */
    public void inicializar( )
    {
        //
        //Inicializa la línea 1
        linea1 = new LineaTelefonica( );
        linea1.inicializar( );
        //
        //Inicializa la línea 2
        linea2 = new LineaTelefonica( );
        linea2.inicializar( );
        //
        //Inicializa la línea 3
        linea3 = new LineaTelefonica( );
        linea3.inicializar( );
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
     * Devuelve el nú8mero total de llamadas realizadas
     * @return total de llamadas de las tres líneas
     */
    public int darTotalNumeroLlamadas( )
    {
        int total = linea1.darNumeroLlamadas( ) + linea2.darNumeroLlamadas( ) + linea3.darNumeroLlamadas( );
        return total;
    }

    /**
     * Devuelve el total de minutos consumidos
     * @return total de minutos de las tres líneas
     */
    public int darTotalMinutos( )
    {
        int total = linea1.darNumeroMinutos( ) + linea2.darNumeroMinutos( ) + linea3.darNumeroMinutos( );
        return total;
    }

    /**
     * Devuelve el costo total de las llamadas realizadas
     * @return costo total de las tres líneas
     */
    public double darTotalCostoLlamadas( )
    {
        double total = linea1.darCostoLlamadas( ) + linea2.darCostoLlamadas( ) + linea3.darCostoLlamadas( );
        return total;
    }

    /**
     * Devuelve el costo promedio de un minuto, según los minutos consumidos <br>
     * <b>pre: </b> TotalMinutos > 0
     * @return Costo promedio por minuto.
     */
    public double darCostoPromedioMinuto( )
    {
        double promedio = darTotalCostoLlamadas( ) / darTotalMinutos( );
        return promedio;
    }

    /**
     * Reinicia todas las líneas telefónicas.
     */
    public void reiniciar( )
    {
        linea1.reiniciar( );
        linea2.reiniciar( );
        linea3.reiniciar( );
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