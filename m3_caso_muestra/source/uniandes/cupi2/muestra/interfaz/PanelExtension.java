/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PanelExtension.java,v 1.3 2006/08/02 19:57:57 da-romer Exp $ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_muestra
 * Autor: Pablo Barvo - Sep 26, 2005
 * Autor: Mario Sánchez - 29-Jun-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.muestra.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel para mostrar las extensiones
 */
public class PanelExtension extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando Opción 1
     */
    private final static String OPCION_1 = "OPCION_1";

    /**
     * Comando Opción 2
     */
    private final static String OPCION_2 = "OPCION_2";

    /**
     * Comando Opción 3
     */
    private final static String OPCION_3 = "OPCION_3";

    /**
     * Comando Opción 4
     */
    private final static String OPCION_4 = "OPCION_4";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazMuestra principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Botón Opción 1
     */
    private JButton btnOpcion1;

    /**
     * Botón Opción 2
     */
    private JButton btnOpcion2;

    /**
     * Botón Opción 3
     */
    private JButton btnOpcion3;

    /**
     * Botón Opción 4
     */
    private JButton btnOpcion4;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel
     * @param ventanaPrincipal es la ventana principal de la aplicación - ventanaPrincipal != null
     */
    public PanelExtension( InterfazMuestra ventanaPrincipal )
    {
        principal = ventanaPrincipal;
        setLayout( new GridLayout( 1, 2 ) );
        setBorder( new TitledBorder( "Opciones" ) );

        // Botón Opción 1
        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        // Botón Opción 2
        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );

        // Botón Opción 3
        btnOpcion3 = new JButton( "Opción 3" );
        btnOpcion3.setActionCommand( OPCION_3 );
        btnOpcion3.addActionListener( this );
        add( btnOpcion3 );

        // Botón Opción 4
        btnOpcion4 = new JButton( "Opción 4" );
        btnOpcion4.setActionCommand( OPCION_4 );
        btnOpcion4.addActionListener( this );
        add( btnOpcion4 );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de eventos de los botones
     * @param evento es la acción que generó el evento
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        if( OPCION_1.equals( comando ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if( OPCION_3.equals( comando ) )
        {
            principal.reqFuncOpcion3( );
        }
        else if( OPCION_4.equals( comando ) )
        {
            principal.reqFuncOpcion4( );
        }
    }
}
