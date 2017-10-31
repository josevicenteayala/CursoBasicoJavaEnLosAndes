/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PanelBusqueda.java,v 1.6 2006/08/02 19:57:57 da-romer Exp $ 
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

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones de búsqueda
 */
public class PanelBusqueda extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando Algoritmo de búsqueda secuencial
     */
    private static final String SECUENCIAL = "SECUENCIAL";

    /**
     * Comando Algoritmo de búsqueda binaria
     */
    private static final String BINARIA = "BINARIA";

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
     * Etiqueta Algoritmos
     */
    private JLabel etiquetaAlgoritmo;

    /**
     * Etiqueta Tiempos
     */
    private JLabel etiquetaTiempos;

    /**
     * Etiqueta tiempo del algoritmo secuencial
     */
    private JLabel etiquetaTiempoSecuencial;

    /**
     * Etiqueta tiempo del algoritmo binario
     */
    private JLabel etiquetaTiempoBinario;

    /**
     * Botón de búsqueda secuencial
     */
    private JButton btnSecuencial;

    /**
     * Botón de búsqueda binaria
     */
    private JButton btnBinario;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param ventanaPrincipal es la ventana principal de la aplicación
     */
    public PanelBusqueda( InterfazMuestra ventanaPrincipal )
    {
        principal = ventanaPrincipal;
        setBorder( new TitledBorder( "Búsqueda" ) );
        setLayout( new GridLayout( 4, 2 ) );

        // Etiquetas de títulos
        etiquetaAlgoritmo = new JLabel( "Algoritmo" );
        etiquetaAlgoritmo.setHorizontalAlignment( JLabel.CENTER );
        add( etiquetaAlgoritmo );
        etiquetaTiempos = new JLabel( "Tiempo Promedio" );
        etiquetaTiempos.setHorizontalAlignment( JLabel.CENTER );
        add( etiquetaTiempos );

        // Algoritmo secuencial
        btnSecuencial = new JButton( "Secuencial" );
        btnSecuencial.setActionCommand( SECUENCIAL );
        btnSecuencial.addActionListener( this );
        btnSecuencial.setPreferredSize( new Dimension( 120, 25 ) );
        add( btnSecuencial );
        etiquetaTiempoSecuencial = new JLabel( "N/A" );
        etiquetaTiempoSecuencial.setHorizontalAlignment( JLabel.CENTER );
        etiquetaTiempoSecuencial.setFont( etiquetaTiempoSecuencial.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaTiempoSecuencial );

        // Algoritmo Binario
        btnBinario = new JButton( "Binaria" );
        btnBinario.setActionCommand( BINARIA );
        btnBinario.addActionListener( this );
        btnBinario.setPreferredSize( new Dimension( 120, 25 ) );
        add( btnBinario );
        etiquetaTiempoBinario = new JLabel( "N/A" );
        etiquetaTiempoBinario.setHorizontalAlignment( JLabel.CENTER );
        etiquetaTiempoBinario.setFont( etiquetaTiempoBinario.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaTiempoBinario );

        // Desactivar los botones inicialmente
        btnSecuencial.setEnabled( false );
        btnBinario.setEnabled( false );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Cambia el tiempo del algoritmo secuencial
     * @param tiempo es el tiempo utilizado en cada búsqueda
     */
    public void cambiarTiempoSecuencial( double tiempo )
    {
        DecimalFormat df = new DecimalFormat( "0.0000" );
        etiquetaTiempoSecuencial.setText( df.format( tiempo ) + "ms" );
    }

    /**
     * Cambia el tiempo del algoritmo de búsqueda binaria
     * @param tiempo es el tiempo utilizado en cada búsqueda
     */
    public void cambiarTiempoBinaria( double tiempo )
    {
        DecimalFormat df = new DecimalFormat( "0.0000" );
        etiquetaTiempoBinario.setText( df.format( tiempo ) + "ms" );
    }

    /**
     * Borra los tiempos mostrados
     */
    public void limpiarTiempos( )
    {
        etiquetaTiempoSecuencial.setText( "N/A" );
        etiquetaTiempoBinario.setText( "N/A" );
    }

    /**
     * Desactiva el botón para realizar una búsqueda binaria
     */
    public void desactivarBusquedaBinaria( )
    {
        btnBinario.setEnabled( false );
    }

    /**
     * Activa el botón para realizar una búsqueda binaria
     */
    public void activarBusquedaBinaria( )
    {
        btnBinario.setEnabled( true );
    }

    /**
     * Activa el botón para realizar una búsqueda secuencial
     */
    public void activarBusquedaSecuencial( )
    {
        btnSecuencial.setEnabled( true );
    }

    /**
     * Manejo de los eventos de los botones
     * @param e es la acción que generó el evento
     */
    public void actionPerformed( ActionEvent e )
    {
        if( SECUENCIAL.equals( e.getActionCommand( ) ) )
        {
            principal.busquedaSecuencial( );
        }
        else
        {
            principal.busquedaBinaria( );
        }
    }

}
