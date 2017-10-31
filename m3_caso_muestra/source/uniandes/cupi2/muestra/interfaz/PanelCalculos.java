/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id: PanelCalculos.java,v 1.4 2006/08/02 19:57:57 da-romer Exp $ 
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Todos los derechos reservados 2005 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_muestra
 * Autor: Mario S�nchez - 29-Jun-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.muestra.interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panel con los c�lculos que se pueden hacer sobre la muestra
 */
public class PanelCalculos extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para calcular el n�mero de elementos en un rango
     */
    private static final String ELEMENTOS_RANGO = "ElementosEnUnRango";

    /**
     * Comando para contar el n�mero de ocurrencias de un valor en la muestra
     */
    private static final String OCURRENCIAS = "Ocurrencias";

    /**
     * Comando para calcular el n�mero de valores distintos en la muestra
     */
    private static final String VALORES_DISTINTOS = "ValoresDistintos";

    /**
     * Comando para calcular el valor m�s frecuente en la muestra
     */
    private static final String VALOR_FRECUENTE = "ValorFrecuente";

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
     * Bot�n Elementos en un Rango
     */
    private JButton btnElementosRango;

    /**
     * Bot�n Valor m�s Frecuente
     */
    private JButton btnValorFrecuente;

    /**
     * Bot�n Ocurrencias de un Valor
     */
    private JButton btnOcurrencias;

    /**
     * Bot�n Valores Distintos
     */
    private JButton btnValoresDistintos;

    /**
     * Campo de Texto Elementos en un Rango
     */
    private JTextField txtElementosRango;

    /**
     * Campo de Texto Valor m�s Frecuente
     */
    private JTextField txtValorFrecuente;

    /**
     * Campo de Texto Ocurrencias de un Valor
     */
    private JTextField txtOcurrencias;

    /**
     * Campo de Texto Valores Distintos
     */
    private JTextField txtValoresDistintos;

    /**
     * Campo de Texto Tiempo Elementos en un Rango
     */
    private JTextField txtTiempoElementosRango;

    /**
     * Campo de Texto Tiempo Valor m�s Frecuente
     */
    private JTextField txtTiempoValorFrecuente;

    /**
     * Campo de Texto Tiempo Ocurrencias de un Valor
     */
    private JTextField txtTiempoOcurrencias;

    /**
     * Campo de Texto Tiempo Valores Distintos
     */
    private JTextField txtTiempoValoresDistintos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param ventanaPrincipal es la ventana principal de la aplicaci�n
     */
    public PanelCalculos( InterfazMuestra ventanaPrincipal )
    {
        principal = ventanaPrincipal;
        setBorder( new TitledBorder( "Otros b�squedas" ) );
        setLayout( new GridBagLayout( ) );

        GridBagConstraints gbcB = new GridBagConstraints( 0, 0, 1, 1, 0.1, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets( 5, 5, 5, 5 ), 0, 0 );
        GridBagConstraints gbcT = new GridBagConstraints( 1, 0, 1, 1, 0.5, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets( 5, 5, 5, 5 ), 0, 0 );
        GridBagConstraints gbcTT = new GridBagConstraints( 2, 0, 1, 1, 0.5, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets( 5, 5, 5, 5 ), 0, 0 );

        // Elementos en un Rango
        btnElementosRango = new JButton( "Elementos en un Rango" );
        btnElementosRango.setActionCommand( ELEMENTOS_RANGO );
        btnElementosRango.addActionListener( this );
        add( btnElementosRango, gbcB );

        txtElementosRango = new JTextField( );
        txtElementosRango.setEditable( false );
        add( txtElementosRango, gbcT );

        txtTiempoElementosRango = new JTextField( );
        txtTiempoElementosRango.setEditable( false );
        add( txtTiempoElementosRango, gbcTT );

        gbcB.gridy++;
        gbcT.gridy++;
        gbcTT.gridy++;

        // Ocurrencias de un Valor
        btnOcurrencias = new JButton( "N�mero de Ocurrencias" );
        btnOcurrencias.setActionCommand( OCURRENCIAS );
        btnOcurrencias.addActionListener( this );
        add( btnOcurrencias, gbcB );

        txtOcurrencias = new JTextField( );
        txtOcurrencias.setEditable( false );
        add( txtOcurrencias, gbcT );

        txtTiempoOcurrencias = new JTextField( );
        txtTiempoOcurrencias.setEditable( false );
        add( txtTiempoOcurrencias, gbcTT );

        gbcB.gridy++;
        gbcT.gridy++;
        gbcTT.gridy++;

        // Valores Distintos
        btnValoresDistintos = new JButton( "N�mero de Valores Distintos" );
        btnValoresDistintos.setActionCommand( VALORES_DISTINTOS );
        btnValoresDistintos.addActionListener( this );
        add( btnValoresDistintos, gbcB );

        txtValoresDistintos = new JTextField( );
        txtValoresDistintos.setEditable( false );
        add( txtValoresDistintos, gbcT );

        txtTiempoValoresDistintos = new JTextField( );
        txtTiempoValoresDistintos.setEditable( false );
        add( txtTiempoValoresDistintos, gbcTT );

        gbcB.gridy++;
        gbcT.gridy++;
        gbcTT.gridy++;

        // Valor M�s Frecuente
        btnValorFrecuente = new JButton( "Valor m�s Frecuente" );
        btnValorFrecuente.setActionCommand( VALOR_FRECUENTE );
        btnValorFrecuente.addActionListener( this );
        add( btnValorFrecuente, gbcB );

        txtValorFrecuente = new JTextField( );
        txtValorFrecuente.setEditable( false );
        add( txtValorFrecuente, gbcT );

        txtTiempoValorFrecuente = new JTextField( );
        txtTiempoValorFrecuente.setEditable( false );
        add( txtTiempoValorFrecuente, gbcTT );

        // Desactivar los botones inicialmente
        btnElementosRango.setEnabled( false );
        btnOcurrencias.setEnabled( false );
        btnValoresDistintos.setEnabled( false );
        btnValorFrecuente.setEnabled( false );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Modifica el n�mero de elementos mostrado
     * @param numeroElementos es el n�mero de elementos en un rango que se va a mostrar
     * @param tiempo es el tiempo que tom� el c�lculo
     */
    public void cambiarNumeroElementosRango( int numeroElementos, long tiempo )
    {
        txtElementosRango.setText( "" + numeroElementos );
        txtTiempoElementosRango.setText( "" + tiempo + "ms" );
    }

    /**
     * Modifica el n�mero de ocurrencias mostrado
     * @param numeroOcurrencias es el n�mero de ocurrencias que se va a mostrar
     * @param tiempo es el tiempo que tom� el c�lculo
     */
    public void cambiarNumeroOcurrencias( int numeroOcurrencias, long tiempo )
    {
        txtOcurrencias.setText( "" + numeroOcurrencias );
        txtTiempoOcurrencias.setText( "" + tiempo + "ms" );
    }

    /**
     * Modifica el n�mero de valores distintos mostrado
     * @param numeroValores es el n�mero de valores distinto que se va mostrar
     * @param tiempo es el tiempo que tom� el c�lculo
     */
    public void cambiarNumeroValoresDistintos( int numeroValores, long tiempo )
    {
        txtValoresDistintos.setText( "" + numeroValores );
        txtTiempoValoresDistintos.setText( "" + tiempo + "ms" );
    }

    /**
     * Modifica el valor m�s frecuente mostrado
     * @param valorMasFrecuente es el valor m�s frecuente que se va a mostrar
     * @param tiempo es el tiempo que tom� el c�lculo
     */
    public void cambiarValorMasFrecuente( int valorMasFrecuente, long tiempo )
    {
        txtValorFrecuente.setText( "" + valorMasFrecuente );
        txtTiempoValorFrecuente.setText( "" + tiempo + "ms" );
    }

    /**
     * Desactiva los botones para realizar b�squedas
     */
    public void desactivarBotones( )
    {
        btnElementosRango.setEnabled( false );
        btnOcurrencias.setEnabled( false );
        btnValoresDistintos.setEnabled( false );
        btnValorFrecuente.setEnabled( false );
    }

    /**
     * Activa los botones para realizar b�squedas
     */
    public void activarBotones( )
    {
        btnElementosRango.setEnabled( true );
        btnOcurrencias.setEnabled( true );
        btnValoresDistintos.setEnabled( true );
        btnValorFrecuente.setEnabled( true );
    }

    /**
     * Borra los valores mostrados
     */
    public void limpiarValores( )
    {
        txtElementosRango.setText( "" );
        txtOcurrencias.setText( "" );
        txtValoresDistintos.setText( "" );
        txtValorFrecuente.setText( "" );
    }

    /**
     * Manejo de los eventos de los botones
     * @param evento es la acci�n que gener� el evento
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        if( ELEMENTOS_RANGO.equals( comando ) )
        {
            principal.contarElementosEnRango( );
        }
        else if( OCURRENCIAS.equals( comando ) )
        {
            principal.contarOcurrencias( );
        }
        else if( VALOR_FRECUENTE.equals( comando ) )
        {
            principal.calcularValorMasFrecuente( );
        }
        else if( VALORES_DISTINTOS.equals( comando ) )
        {
            principal.contarValoresDistintos( );
        }
    }

}