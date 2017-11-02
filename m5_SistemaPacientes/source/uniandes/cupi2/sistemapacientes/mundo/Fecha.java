/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_empleado 
 * Autor: Mario S�nchez - 14/06/2005 
 * Autor: Mario S�nchez - 14/06/2005
 * Autor: Pablo Barvo - 22/08/2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sistemapacientes.mundo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Esta clase sirve para representar una fecha y hacer algunas operaciones b�sicas
 */
public class Fecha
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * D�a del mes
     */
    private int dia;

    /**
     * Mes
     */
    private int mes;

    /**
     * A�o
     */
    private int anio;

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Inicializa una fecha con los par�metros proporcionados <br>
     * <b>post: </b> El objeto fecha tiene sus datos b�sicos asignados con los par�metros proporcionados
     * @param d D�a. d > 0 y d <= 31 y d es un valor v�lido seg�n el mes
     * @param m Mes. m > 0 y m <= 12
     * @param a A�o.
     */
    public void inicializar( int d, int m, int a )
    {
        dia = d;
        mes = m;
        anio = a;
    }

    /**
     * Construye una nueva fecha inicializada en el d�a de hoy. <br>
     * <b>post: </b> El objeto fecha tiene sus datos b�sicos asignados con los datos del d�a de hoy
     */
    public void inicializarHoy( )
    {
        // Usamos un calendario Gregoriano inicializado en el d�a de hoy
        GregorianCalendar gc = new GregorianCalendar( );

        // Sacamos los valores de d�a, mes y a�o del calendario
        dia = gc.get( Calendar.DAY_OF_MONTH );
        mes = gc.get( Calendar.MONTH ) + 1;
        anio = gc.get( Calendar.YEAR );
    }

    /**
     * Retorna el d�a de esta fecha
     * @return d�a
     */
    public int darDia( )
    {
        return dia;
    }

    /**
     * Retorna el mes de esta fecha
     * @return mes
     */
    public int darMes( )
    {
        return mes;
    }

    /**
     * Retorna el a�o de esta fecha
     * @return a�o
     */
    public int darAnio( )
    {
        return anio;
    }

    /**
     * Este m�todo sirve para dar la diferencia en meses que hay entre dos fechas.
     * @param fecha La fecha contra la que se est� comparando. fecha != null
     * @return Retorna el n�mero de meses
     */
    public int darDiferenciaEnMeses( Fecha fecha )
    {
        int diferencia = 0;

        int otroAnho = fecha.darAnio( );
        int otroMes = fecha.darMes( );
        int otroDia = fecha.darDia( );

        // Calcula la diferencia en meses
        diferencia = 12 * ( otroAnho - anio ) + ( otroMes - mes );

        //Si el d�a no es mayor, resta un mes
        if( otroDia < dia )
            diferencia--;

        return diferencia;
    }

    /**
     * Retorna una cadena que representa la fecha
     * @return La cadena sigue el formato dia-mes-a�o
     */
    public String toString( )
    {
        return "" + dia + "-" + mes + "-" + anio;
    }
}
