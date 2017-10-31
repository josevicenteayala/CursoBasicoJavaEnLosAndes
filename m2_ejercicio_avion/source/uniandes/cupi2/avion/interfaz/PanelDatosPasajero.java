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

import javax.swing.*;

import uniandes.cupi2.avion.mundo.*;

/**
 * Panel con la informaci�n del pasajero
 */
public class PanelDatosPasajero extends JPanel
{
    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Texto que contiene la c�dula
     */
    private JTextField txtCedula;

    /**
     * Texto que contiene el nombre
     */
    private JTextField txtNombre;

    /**
     * Texto que contiene la clase
     */
    private JTextField txtClase;

    /**
     * Texto que contiene la ubicaci�n
     */
    private JTextField txtUbicacion;

    /**
     * Texto que contiene la silla
     */
    private JTextField txtSilla;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea el panel con los datos del pasajero
     * @param pasajero - pasajero cuya informaci�n se presentar�
     * @param silla Silla donde se encuentra ubicado el pasajero
     */
    public PanelDatosPasajero( Pasajero pasajero, Silla silla )
    {
        setLayout( new GridLayout( 5, 1, 1, 1 ) );
        setBorder( BorderFactory.createTitledBorder( "Datos del pasajero" ) );

        //C�dula
        JPanel panelCedula = new JPanel( );
        panelCedula.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaCedula = new JLabel( "C�dula " );
        txtCedula = new JTextField( Integer.toString( pasajero.darCedula( ) ) );
        txtCedula.setColumns( 15 );
        txtCedula.setEditable( false );
        panelCedula.add( etiquetaCedula );
        panelCedula.add( txtCedula );
        add( panelCedula );

        //Nombre
        JPanel panelNombre = new JPanel( );
        panelNombre.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaNombre = new JLabel( "Nombre " );
        txtNombre = new JTextField( pasajero.darNombre( ) );
        txtNombre.setColumns( 15 );
        txtNombre.setEditable( false );
        panelNombre.add( etiquetaNombre );
        panelNombre.add( txtNombre );
        add( panelNombre );

        //Silla
        JPanel panelSilla = new JPanel( );
        panelSilla.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaSilla = new JLabel( "Silla " );
        txtSilla = new JTextField( Integer.toString( silla.darNumero( ) ) );
        txtSilla.setColumns( 15 );
        txtSilla.setEditable( false );
        panelSilla.add( etiquetaSilla );
        panelSilla.add( txtSilla );
        add( panelSilla );

        //Clase
        JPanel panelClase = new JPanel( );
        panelClase.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaClase = new JLabel( "Clase " );
        String sClase;
        if( silla.darClase( ) == Silla.CLASE_ECONOMICA )
        {
            sClase = "Econ�mica";
        }
        else
        {
            sClase = "Ejecutiva";
        }
        txtClase = new JTextField( sClase );
        txtClase.setColumns( 15 );
        txtClase.setEditable( false );
        panelClase.add( etiquetaClase );
        panelClase.add( txtClase );
        add( panelClase );

        //Ubicaci�n
        JPanel panelUbicacion = new JPanel( );
        panelUbicacion.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaUbicacion = new JLabel( "Ubicaci�n " );
        String sUbicacion;
        if( silla.darUbicacion( ) == Silla.CENTRAL )
        {
            sUbicacion = "Centro";
        }
        else if( silla.darUbicacion( ) == Silla.PASILLO )
        {
            sUbicacion = "Pasillo";
        }
        else
        {
            sUbicacion = "Ventana";
        }
        txtUbicacion = new JTextField( sUbicacion );
        txtUbicacion.setColumns( 15 );
        txtUbicacion.setEditable( false );
        panelUbicacion.add( etiquetaUbicacion );
        panelUbicacion.add( txtUbicacion );
        add( panelUbicacion );
    }
}