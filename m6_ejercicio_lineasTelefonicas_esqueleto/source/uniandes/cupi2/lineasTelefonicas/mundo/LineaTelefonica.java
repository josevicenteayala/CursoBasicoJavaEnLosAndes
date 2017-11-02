/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1  
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co) 
 * Ejercicio: n6_lineasTelefonicas
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.lineasTelefonicas.mundo;

/**
 * Clase que representa una línea telefónica
 */
public class LineaTelefonica
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Número de llamadas realizadas
     */
    protected int numeroLlamadas;

    /**
     * Número de minutos consumidos
     */
    protected int numeroMinutos;

    /**
     * Costo total de las llamadas
     */
    private double costoLlamadas;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Constructor que inicializa la línea telefónica <br>
     * <b>post: </b> La línea se inicializó con valores en cero.
     */
    public LineaTelefonica( )
    {
        //Inicializa los valores
        numeroLlamadas = 0;
        numeroMinutos = 0;
        costoLlamadas = 0;
    }

    /**
     * Reinicia la línea telefónica, dejando todos sus valores en cero.
     */
    public void reiniciar( )
    {
        numeroLlamadas = 0;
        numeroMinutos = 0;
        costoLlamadas = 0;
    }

    /**
     * Devuelve el costo total de las llamadas realizadas
     * @return Costo total de las llamadas realizadas
     */
    public double darCostoLlamadas( )
    {
        return costoLlamadas;
    }

    /**
     * Devuelve el número de llamadas realizadas por esta línea
     * @return Número de llamadas realizadas por esta línea
     */
    public int darNumeroLlamadas( )
    {
        return numeroLlamadas;
    }

    /**
     * Devuelve el número de minutos consumidos
     * @return Número de minutos consumidos
     */
    public int darNumeroMinutos( )
    {
        return numeroMinutos;
    }

    
    
    /**
     * Modifica el costo total de las llamadas con el valor dado por parámetro.
     * @param pCostoLlamadas Nuevo costo total de las llamadas;
     */
    public void modificarCostoLlamada(double pCostoLlamadas){
    	costoLlamadas = pCostoLlamadas;
    }
    
    /**
     * Agrega una llamada local a la línea telefónica <br>
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 35 )
     * @param minutos Número de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaLocal( int minutos )
    {
        //
        //Una llamada más
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos
        numeroMinutos = numeroMinutos + minutos;
        //
        //Suma el costo (costo por minuto: 35 pesos)
        costoLlamadas = costoLlamadas + ( minutos * 35 );
    }

    /**
     * Agrega una llamada de larga distancia a la línea telefónica <br>
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 380 )
     * @param minutos Número de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaLargaDistancia( int minutos )
    {
        //
        //Una llamada más
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos
        numeroMinutos = numeroMinutos + minutos;
        //
        //Suma el costo (costo por minuto: 380 pesos)
        costoLlamadas = costoLlamadas + ( minutos * 380 );
    }

    /**
     * Agrega una llamada a celular a la línea telefónica <br>
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 999 )
     * @param minutos Número de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaCelular( int minutos )
    {
        //
        //Una llamada más
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos
        numeroMinutos = numeroMinutos + minutos;
        //
        //Suma el costo (costo por minuto: 999 pesos)
        costoLlamadas = costoLlamadas + ( minutos * 999 );
    }
    
    

}