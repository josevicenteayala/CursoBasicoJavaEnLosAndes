/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PanelOrdenamiento.java,v 1.6 2006/08/02 19:57:57 da-romer Exp $
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co) 
 * Ejercicio: n7_muestra
 * Autor: Pablo Barvo - Sep 26, 2005
 * Autor: Mario S�nchez - 29-Jun-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.muestra.interfaz;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones de ordenamiento
 */
public class PanelOrdenamiento extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para ordenar por seleccion
     */
    private final static String ORDENAR_SELECCION = "ORDENAR_SELECCION";

    /**
     * Comando para ordenar por insercion
     */
    private final static String ORDENAR_INSERCION = "ORDENAR_INSERCION";

    /**
     * Comando para ordenar por burbuja
     */
    private final static String ORDENAR_BURBUJA = "ORDENAR_BURBUJA";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n
     */
    private InterfazMuestra principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta Algoritmos
     */
    private JLabel etiquetaAlgoritmo;

    /**
     * Etiqueta Tiempos
     */
    private JLabel etiquetaTiempos;

    /**
     * Etiqueta Tiempo Selecci�n
     */
    private JLabel etiquetaTiempoSeleccion;

    /**
     * Etiqueta Tiempo Burbuja
     */
    private JLabel etiquetaTiempoBurbuja;

    /**
     * Etiqueta Tiempo Inserci�n
     */
    private JLabel etiquetaTiempoInsercion;

    /**
     * Bot�n Ordenar Selecci�n
     */
    private JButton btnSeleccion;

    /**
     * Bot�n Ordenar Inserci�n
     */
    private JButton btnInsercion;

    /**
     * Bot�n Ordenar Burbuja
     */
    private JButton btnBurbuja;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param ventanaPrincipal es la ventana principal de la aplicaci�n
     */
    public PanelOrdenamiento( InterfazMuestra ventanaPrincipal )
    {
        principal = ventanaPrincipal;
        setBorder( new TitledBorder( "Ordenamiento" ) );
        setLayout( new GridLayout( 4, 1 ) );

        // Etiquetas de t�tulos
        JPanel panelTitulos = new JPanel( new GridLayout( 1, 2 ) );
        etiquetaAlgoritmo = new JLabel( "Algoritmo" );
        etiquetaAlgoritmo.setHorizontalAlignment( JLabel.CENTER );
        panelTitulos.add( etiquetaAlgoritmo );
        etiquetaTiempos = new JLabel( "Tiempo" );
        etiquetaTiempos.setHorizontalAlignment( JLabel.CENTER );
        panelTitulos.add( etiquetaTiempos );
        add( panelTitulos );

        // Algoritmo Selecci�n
        JPanel panelSeleccion = new JPanel( new GridLayout( 1, 2 ) );
        btnSeleccion = new JButton( "Selecci�n" );
        btnSeleccion.setActionCommand( ORDENAR_SELECCION );
        btnSeleccion.addActionListener( this );
        btnSeleccion.setPreferredSize( new Dimension( 120, 25 ) );
        panelSeleccion.add( btnSeleccion );
        etiquetaTiempoSeleccion = new JLabel( "N/A" );
        etiquetaTiempoSeleccion.setHorizontalAlignment( JLabel.CENTER );
        etiquetaTiempoSeleccion.setFont( etiquetaTiempoSeleccion.getFont( ).deriveFont( Font.PLAIN ) );
        panelSeleccion.add( etiquetaTiempoSeleccion );
        add( panelSeleccion );

        // Algoritmo Burbuja
        JPanel panelBurbuja = new JPanel( new GridLayout( 1, 2 ) );
        btnBurbuja = new JButton( "Burbuja" );
        btnBurbuja.setActionCommand( ORDENAR_BURBUJA );
        btnBurbuja.addActionListener( this );
        btnBurbuja.setPreferredSize( new Dimension( 120, 25 ) );
        panelBurbuja.add( btnBurbuja );
        etiquetaTiempoBurbuja = new JLabel( "N/A" );
        etiquetaTiempoBurbuja.setHorizontalAlignment( JLabel.CENTER );
        etiquetaTiempoBurbuja.setFont( etiquetaTiempoBurbuja.getFont( ).deriveFont( Font.PLAIN ) );
        panelBurbuja.add( etiquetaTiempoBurbuja );
        add( panelBurbuja );

        // Algoritmo Inserci�n
        JPanel panelInsercion = new JPanel( new GridLayout( 1, 2 ) );
        btnInsercion = new JButton( "Inserci�n" );
        btnInsercion.setActionCommand( ORDENAR_INSERCION );
        btnInsercion.addActionListener( this );
        btnInsercion.setPreferredSize( new Dimension( 120, 25 ) );
        panelInsercion.add( btnInsercion );
        etiquetaTiempoInsercion = new JLabel( "N/A" );
        etiquetaTiempoInsercion.setHorizontalAlignment( JLabel.CENTER );
        etiquetaTiempoInsercion.setFont( etiquetaTiempoInsercion.getFont( ).deriveFont( Font.PLAIN ) );
        panelInsercion.add( etiquetaTiempoInsercion );
        add( panelInsercion );

        // Desactivar inicialmente los botones
        btnSeleccion.setEnabled( false );
        btnInsercion.setEnabled( false );
        btnBurbuja.setEnabled( false );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Cambia el tiempo del algoritmo selecci�n
     * @param tiempo es el tiempo utilizado en el ordenamiento
     */
    public void cambiarTiempoSeleccion( long tiempo )
    {
        etiquetaTiempoSeleccion.setText( Long.toString( tiempo ) + "ms" );
    }

    /**
     * Cambia el tiempo del algoritmo burbuja
     * @param tiempo es el tiempo utilizado en el ordenamiento
     */
    public void cambiarTiempoBurbuja( long tiempo )
    {
        etiquetaTiempoBurbuja.setText( Long.toString( tiempo ) + "ms" );
    }

    /**
     * Cambia el tiempo del algoritmo inserci�n
     * @param tiempo es el tiempo utilizado en el ordenamiento
     */
    public void cambiarTiempoInsercion( long tiempo )
    {
        etiquetaTiempoInsercion.setText( Long.toString( tiempo ) + "ms" );
    }

    /**
     * Activa los botones para realizar b�squedas
     */
    public void activarBotones( )
    {
        btnSeleccion.setEnabled( true );
        btnInsercion.setEnabled( true );
        btnBurbuja.setEnabled( true );
    }

    /**
     * Borra los tiempos mostrados
     */
    public void limpiarTiempos( )
    {
        etiquetaTiempoSeleccion.setText( "N/A" );
        etiquetaTiempoBurbuja.setText( "N/A" );
        etiquetaTiempoInsercion.setText( "N/A" );
    }

    /**
     * Manejo de eventos de los botones
     * @param evento es la acci�n que gener� el evento
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( ORDENAR_SELECCION.equals( comando ) )
        {
            principal.ordenarSeleccion( );
        }
        else if( ORDENAR_INSERCION.equals( comando ) )
        {
            principal.ordenarInsercion( );
        }
        else if( ORDENAR_BURBUJA.equals( comando ) )
        {
            principal.ordenarBurbuja( );
        }
    }

}
