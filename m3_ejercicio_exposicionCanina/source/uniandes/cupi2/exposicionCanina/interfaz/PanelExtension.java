/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelExtension.java,v 1.4 2006/08/06 20:34:34 da-romer Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_exposicionCanina 
 * Autor: Mario Sánchez - 25/08/2005
 * Modificado por: Daniel Romero- 30/06/2006  
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.exposicionCanina.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Es el panel que contiene los botones de extensión
 */
public class PanelExtension extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * El comando para el botón 1
     */
    private final String OPCION_1 = "opcion 1";

    /**
     * El comando para el botón 2
     */
    private final String OPCION_2 = "opcion 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la referencia a la interfaz de la aplicación
     */
    private InterfazExposicionCanina principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el botón 1
     */
    private JButton botonOpcion1;

    /**
     * Es el botón 2
     */
    private JButton botonOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con una referencia a la ventana principal de la aplicación.
     * @param iec es una referencia a la ventana principal - ie!=null
     */
    public PanelExtension( InterfazExposicionCanina iec )
    {
        principal = iec;
        inicializar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa los componentes del panel. <br>
     * <b>post: </b> Se inicializaron y se ubicaron los componentes del panel.
     */
    private void inicializar( )
    {
        setBorder( new TitledBorder( "Puntos de Extensión" ) );

        setLayout( new FlowLayout( ) );
        botonOpcion1 = new JButton( "Opción 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );

        botonOpcion2 = new JButton( "Opción 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );

        add( botonOpcion1 );
        add( botonOpcion2 );
    }

    /**
     * Este método se llama cuando se presiona uno de los botones.
     * @param event es el evento del click en el botón
     */
    public void actionPerformed( ActionEvent event )
    {
        String comando = event.getActionCommand( );
        if( OPCION_1.equals( comando ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            principal.reqFuncOpcion2( );
        }
    }

}
