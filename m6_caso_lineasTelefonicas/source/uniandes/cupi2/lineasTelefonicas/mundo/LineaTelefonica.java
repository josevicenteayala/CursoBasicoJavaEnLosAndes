/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$ 
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1  
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co) 
 * Ejercicio: n6_lineasTelefonicas
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.lineasTelefonicas.mundo;

/**
 * Clase que representa una l�nea telef�nica
 */
public class LineaTelefonica implements ILineaTelefonica
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * N�mero de llamadas realizadas
     */
    protected int numeroLlamadas;

    /**
     * N�mero de minutos consumidos
     */
    protected int numeroMinutos;

    /**
     * Costo total de las llamadas
     */
    protected double costoLlamadas;

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Constructor que inicializa la l�nea telef�nica <br>
     * <b>post: </b> La l�nea se inicializ� con valores en cero.
     */
    public LineaTelefonica( )
    {
        //Inicializa los valores
        numeroLlamadas = 0;
        numeroMinutos = 0;
        costoLlamadas = 0;
    }

    /**
     * Reinicia la l�nea telef�nica, dejando todos sus valores en cero.
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
     * Devuelve el n�mero de llamadas realizadas por esta l�nea
     * @return N�mero de llamadas realizadas por esta l�nea
     */
    public int darNumeroLlamadas( )
    {
        return numeroLlamadas;
    }

    /**
     * Devuelve el n�mero de minutos consumidos
     * @return N�mero de minutos consumidos
     */
    public int darNumeroMinutos( )
    {
        return numeroMinutos;
    }

    
    
    /**
     * Modifica el costo de las llamadas con el valor dado por par�metro.
     * @param pCostoLlamadas Nuevo costo de las llamadas;
     */
    public void modificarCostoLlamada(double pCostoLlamadas){
    	costoLlamadas = pCostoLlamadas;
    }
    
    /**
     * Agrega una llamada local a la l�nea telef�nica <br>
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 35 )
     * @param minutos N�mero de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaLocal( int minutos )
    {
        //
        //Una llamada m�s
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos
        numeroMinutos = numeroMinutos + minutos;
        //
        //Suma el costo (costo por minuto: 35 pesos)
        costoLlamadas = costoLlamadas + ( minutos * 35 );
    }

    /**
     * Agrega una llamada de larga distancia a la l�nea telef�nica <br>
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 380 )
     * @param minutos N�mero de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaLargaDistancia( int minutos )
    {
        //
        //Una llamada m�s
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos
        numeroMinutos = numeroMinutos + minutos;
        //
        //Suma el costo (costo por minuto: 380 pesos)
        costoLlamadas = costoLlamadas + ( minutos * 380 );
    }

    /**
     * Agrega una llamada a celular a la l�nea telef�nica <br>
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 999 )
     * @param minutos N�mero de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaCelular( int minutos )
    {
        //
        //Una llamada m�s
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos
        numeroMinutos = numeroMinutos + minutos;
        //
        //Suma el costo (costo por minuto: 999 pesos)
        costoLlamadas = costoLlamadas + ( minutos * 999 );
    }
    
    

}