/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Avi�n
 * Autor: Katalina Marcos - Febrero 2005
 * Autor: Pablo Barvo - 24-Ago-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.avion.interfaz;

import java.awt.*;
import java.text.*;

import javax.swing.*;

import uniandes.cupi2.avion.mundo.*;

/**
 * Ventana principal del avi�n
 */
public class InterfazAvion extends JFrame
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Avi�n
     */
    private Avion avion;

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Panel que contiene el avi�n
     */
    private PanelAvion panelAvion;

    /**
     * Panel de botones
     */
    private PanelBotonesAvion panelBotones;

    /**
     * Dialogo de nuevo pasajero
     */
    private DialogoAsignacion dAsignacion;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea la interfaz del avi�n <br>
     * <b>post: </b> Se crea el avi�n y se presenta en una gr�fica su estado inicial.
     */
    public InterfazAvion( )
    {
        //Crea al avi�n
        avion = new Avion( );

        //Configura la interfaz
        setLayout( new BorderLayout( ) );

        //Panel de botones
        panelBotones = new PanelBotonesAvion( this );
        add( panelBotones, BorderLayout.NORTH );

        //Panel del avi�n
        panelAvion = new PanelAvion( avion );
        add( panelAvion, BorderLayout.CENTER );

        String titulo = "El Avi�n";
        setTitle( titulo );
        pack( );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Procesa el registro un pasajero
     */
    public void registrarPasajero( )
    {
        dAsignacion = new DialogoAsignacion( this, avion );
        dAsignacion.setLocation( calculaPosicionCentral( this, dAsignacion ) );
        dAsignacion.setModal( true );
        dAsignacion.setVisible( true );
        actualizar( );
    }

    /**
     * Procesa la anulaci�n del registro de un pasajero
     */
    public void anularPasajero( )
    {
        //Pregunta el numero de c�dula
        int cedula;
        String sCedula = JOptionPane.showInputDialog( this, "Ingrese el n�mero de c�dula" );
        try
        {
            cedula = Integer.parseInt( sCedula );
        }
        catch( NumberFormatException e )
        {
            JOptionPane.showMessageDialog( this, "Error en el n�mero de c�dula.", "Anulaci�n", JOptionPane.ERROR_MESSAGE );
            return;
        }

        Pasajero pasajero = new Pasajero( cedula, "no importa" );
        if( !avion.desasignarSilla( pasajero ) )
        {
            JOptionPane.showMessageDialog( this, "El pasajero no ten�a silla asignada", "Anulaci�n", JOptionPane.ERROR_MESSAGE );
            return;
        }

        actualizar( );
    }

    /**
     * Muestra el porcentaje de ocupaci�n que tiene el avi�n
     */
    public void mostrarPorcentajeOcupacion( )
    {
        double porcentaje;
        porcentaje = avion.calcularPorcentajeOcupacion( );
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###.##" );
        JOptionPane.showMessageDialog( this, "El porcentaje de ocupaci�n es " + df.format( porcentaje ) + "%", "Ocupaci�n del avi�n", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Procesa la b�squeda de un pasajero
     */
    public void buscarPasajero( )
    {
        // Pregunta el numero de c�dula
        int cedula;
        String sCedula = JOptionPane.showInputDialog( this, "Ingrese el n�mero de c�dula" );
        try
        {
            cedula = Integer.parseInt( sCedula );
        }
        catch( NumberFormatException e )
        {
            JOptionPane.showMessageDialog( this, "Error en el n�mero de c�dula.", "Anulaci�n", JOptionPane.ERROR_MESSAGE );
            return;
        }
        Pasajero pasajero = new Pasajero( cedula, "no importa" );

        Silla silla = avion.buscarPasajero( pasajero );

        if( silla != null )
        {
            VentanaDatosPasajero vDatos = new VentanaDatosPasajero( silla );
            vDatos.setLocation( calculaPosicionCentral( this, vDatos ) );
            vDatos.setVisible( true );

        }
        else
        {
            JOptionPane.showMessageDialog( this, "El pasajero no se encuentra registrado", "B�squeda registro", JOptionPane.INFORMATION_MESSAGE );
            return;
        }
    }

    /**
     * M�todo 1 de extensi�n para el ejemplo
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = avion.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo 2 de extensi�n para el ejemplo
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = avion.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Repinta la gr�fica del avi�n
     */
    public void actualizar( )
    {
        remove( panelAvion );

        //Panel del avi�n
        panelAvion = new PanelAvion( avion );
        add( panelAvion, BorderLayout.CENTER );
        validate( );
    }

    /**
     * Calcula el punto central entre dos componentes
     * @param componentePadre - Componente padre sobre el que se calcula el centro - componentePadre != null
     * @param componenteHijo - Componente hijo que se centra sobre el padre - componenteHijo != null
     * @return Punto central para ubicar al componente hijo
     */
    private Point calculaPosicionCentral( Component componentePadre, Component componenteHijo )
    {

        //Centra la ventana y asegura que no sea mayor que la resoluci�n actual
        Dimension tamanhoPantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int maxY = tamanhoPantalla.height;
        int minY = 0;

        //Tama�o de la resoluci�n de la pantalla
        Dimension tamanhoPadre = componentePadre.getSize( );
        Point locacionPadre = componentePadre.getLocation( );
        Dimension tamanhoHijo = componenteHijo.getSize( );
        int x = ( tamanhoPadre.width - tamanhoHijo.width ) / 2 + locacionPadre.x;
        int y = ( tamanhoPadre.height - tamanhoHijo.height ) / 2 + locacionPadre.y;

        // Ajuste para abajo
        if( y + tamanhoHijo.height > maxY )
        {
            y = maxY - tamanhoHijo.height;
        }

        // Ajuste para arriba
        if( y < minY )
        {
            y = 0;
        }
        return new Point( x, y );
    }

    /**
     * M�todo principal de ejecuci�n
     * @param args - argumentos de ejecuci�n - no requiere.
     */
    public static void main( String[] args )
    {
        InterfazAvion interfaz = new InterfazAvion( );
        interfaz.setVisible( true );
    }
}