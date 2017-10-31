/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PanelMuestra.java,v 1.5 2006/08/02 19:57:57 da-romer Exp $
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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.muestra.mundo.Muestra;

/**
 * El panel donde se muestran los datos de una muestra
 */
public class PanelMuestra extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando Nueva muestra
     */
    private final static String NUEVA_MUESTRA = "NUEVA_MUESTRA";

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
     * Botón nueva muestra
     */
    private JButton btnNuevaMuestra;

    /**
     * Etiqueta Número de Valores
     */
    private JLabel etiquetaNumero;

    /**
     * Etiqueta Límite Superior
     */
    private JLabel etiquetaLimite;

    /**
     * Etiqueta Promedio de los Valores
     */
    private JLabel etiquetaPromedio;

    /**
     * Etiqueta Valor Máximo
     */
    private JLabel etiquetaMaximo;

    /**
     * Etiqueta Valor Mínimo
     */
    private JLabel etiquetaMinimo;

    /**
     * Campo para el Número de Valores
     */
    private JTextField txtNumero;

    /**
     * Campo para el Límite Superior
     */
    private JTextField txtLimite;

    /**
     * Campo para el Promedio de los Valores
     */
    private JTextField txtPromedio;

    /**
     * Campo para el Valor Máximo
     */
    private JTextField txtMaximo;

    /**
     * Campo para el Valor Mínimo
     */
    private JTextField txtMinimo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel
     * @param ventanaPrincipal es la ventana principal de la aplicación
     */
    public PanelMuestra( InterfazMuestra ventanaPrincipal )
    {
        principal = ventanaPrincipal;
        setLayout( new GridBagLayout( ) );
        setBorder( new TitledBorder( "Datos de la muestra" ) );

        GridBagConstraints gbcE = new GridBagConstraints( 0, 0, 1, 1, 0.6, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        GridBagConstraints gbcT = new GridBagConstraints( 1, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );

        etiquetaNumero = new JLabel( "Tamaño" );
        txtNumero = new JTextField( "" );
        txtNumero.setEditable( false );
        add( etiquetaNumero, gbcE );
        add( txtNumero, gbcT );

        gbcE.gridy++;
        gbcT.gridy++;

        etiquetaLimite = new JLabel( "Límite" );
        txtLimite = new JTextField( "" );
        txtLimite.setEditable( false );
        add( etiquetaLimite, gbcE );
        add( txtLimite, gbcT );

        gbcE.gridy++;
        gbcT.gridy++;

        etiquetaPromedio = new JLabel( "Promedio" );
        txtPromedio = new JTextField( "" );
        txtPromedio.setEditable( false );
        add( etiquetaPromedio, gbcE );
        add( txtPromedio, gbcT );

        gbcE.gridx = 2;
        gbcE.insets = new Insets( 5, 20, 5, 5 );
        gbcT.gridx = 3;
        gbcE.gridy = 0;
        gbcT.gridy = 0;

        etiquetaMinimo = new JLabel( "Mínimo" );
        txtMinimo = new JTextField( "" );
        txtMinimo.setEditable( false );
        add( etiquetaMinimo, gbcE );
        add( txtMinimo, gbcT );

        gbcE.gridy++;
        gbcT.gridy++;

        etiquetaMaximo = new JLabel( "Máximo" );
        txtMaximo = new JTextField( "" );
        txtMaximo.setEditable( false );
        add( etiquetaMaximo, gbcE );
        add( txtMaximo, gbcT );

        // Botón Nueva muestra
        GridBagConstraints gbc = new GridBagConstraints( 3, 2, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        btnNuevaMuestra = new JButton( "Nueva Muestra" );
        btnNuevaMuestra.setActionCommand( NUEVA_MUESTRA );
        btnNuevaMuestra.addActionListener( this );
        add( btnNuevaMuestra, gbc );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Refresca los datos mostrados para la muestra
     * @param muestra es la muestra de la que se muestran los datos
     */
    public void refrescarDatos( Muestra muestra )
    {
        DecimalFormat df = new DecimalFormat( "0.0#" );

        txtLimite.setText( "" + muestra.darLimiteSuperior( ) );
        txtMaximo.setText( "" + muestra.darMaximo( ) );
        txtMinimo.setText( "" + muestra.darMinimo( ) );
        txtNumero.setText( "" + muestra.darTamanio( ) );
        txtPromedio.setText( df.format( muestra.darPromedio( ) ) );
    }

    /**
     * Manejo de eventos de los botones
     * @param e es la acción que generó el evento
     */
    public void actionPerformed( ActionEvent e )
    {
        if( NUEVA_MUESTRA.equals( e.getActionCommand( ) ) )
        {
            principal.nuevaMuestra( );
        }
    }

}
