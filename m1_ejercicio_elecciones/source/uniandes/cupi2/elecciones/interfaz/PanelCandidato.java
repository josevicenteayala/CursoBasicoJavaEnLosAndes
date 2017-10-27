/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelCandidato.java 445 2007-06-25 16:30:28Z camil-ji $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_elecciones
 * Autor: Milena Vela - 01-dic-2006
 * Autor: Carlos Andrés Vega - 29-ene-2007
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.elecciones.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.cupi2.elecciones.mundo.Candidato;

/**
 * Panel que contiene la información de un candidato.
 */
@SuppressWarnings("serial")
public class PanelCandidato extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando mostrar estadísticas del candidato.
     */
    private static final String ESTADISTICAS_VOTOS = "Estadísticas";

    /**
     * Comando votar por el candidato.
     */
    private static final String VOTAR = "Votar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazElecciones principal;

    /**
     * Número del candidato.
     */
    private int numCandidato;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta nombre del candidato.
     */
    private JLabel lblNombreCandidato;

    /**
     * Etiqueta edad del candidato.
     */
    private JLabel lblEdadCandidato;

    /**
     * Etiqueta partido político del candidato.
     */
    private JLabel lblPartidoPoliticoCandidato;

    /**
     * Etiqueta Costo de campaña del candidato.
     */
    private JLabel lblCostoCampanhaCandidato;

    /**
     * Etiqueta número de votos del candidato.
     */
    private JLabel lblNumeroVotos;
    
    /**
     * Caja de texto nombre del candidato.
     */
    private JTextField txtNombreCandidato;

    /**
     * Caja de texto edad del candidato.
     */
    private JTextField txtEdadCandidato;

    /**
     * Caja de texto partido político del candidato.
     */
    private JTextField txtPartidoPoliticoCandidato;

    /**
     *Caja de texto Costo de campaña del candidato.
     */
    private JTextField txtCostoCampanhaCandidato;

    /**
     * Caja de texto número de votos del candidato.
     */
    private JTextField txtNumeroVotos;

    /**
     * Botón mostrar estadísticas.
     */
    private JButton btnEstadisticas;

    /**
     * Botón Votar.
     */
    private JButton btnVotar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param laPrincipal Ventana principal. laPrincipal != null.
     * @param nCandidato Número del candidato.
     */
    public PanelCandidato( InterfazElecciones laPrincipal, int nCandidato )
    {
        principal = laPrincipal;
        numCandidato = nCandidato;

        // Botón actualizar datos
        btnEstadisticas = new JButton( ESTADISTICAS_VOTOS );
        btnEstadisticas.setPreferredSize( new Dimension( 160, 20 ) );
        btnEstadisticas.setActionCommand( ESTADISTICAS_VOTOS );
        btnEstadisticas.addActionListener( this );

        btnVotar = new JButton( VOTAR );
        btnVotar.setPreferredSize( new Dimension( 160, 20 ) );
        btnVotar.setActionCommand( VOTAR );
        btnVotar.addActionListener( this );

        lblNombreCandidato = new JLabel( "Nombre" );
        lblNombreCandidato.setHorizontalAlignment( JLabel.LEFT );

        lblEdadCandidato = new JLabel( "Edad" );
        lblEdadCandidato.setHorizontalAlignment( JLabel.LEFT );

        lblPartidoPoliticoCandidato = new JLabel( "Partido político" );
        lblPartidoPoliticoCandidato.setHorizontalAlignment( JLabel.LEFT );

        lblCostoCampanhaCandidato = new JLabel( "Costo campaña" );
        lblCostoCampanhaCandidato.setHorizontalAlignment( JLabel.LEFT );

        lblNumeroVotos = new JLabel( "Número de votos" );
        lblNumeroVotos.setHorizontalAlignment( JLabel.LEFT );
        lblNumeroVotos.setForeground( Color.RED.darker( ) );
        
        txtNombreCandidato = new JTextField();
        txtNombreCandidato.setEditable(false);
        txtNombreCandidato.setFont( new Font( "Dialog", Font.BOLD, 12 ) );
        
        txtEdadCandidato = new JTextField();
        txtEdadCandidato.setEditable(false);
        txtEdadCandidato.setFont( new Font( "Dialog", Font.BOLD, 12 ) );
        
        txtPartidoPoliticoCandidato = new JTextField();
        txtPartidoPoliticoCandidato.setEditable(false);
        txtPartidoPoliticoCandidato.setFont( new Font( "Dialog", Font.BOLD, 12 ) );
        
        txtCostoCampanhaCandidato = new JTextField();
        txtCostoCampanhaCandidato.setEditable(false);
        txtCostoCampanhaCandidato.setFont( new Font( "Dialog", Font.BOLD, 12 ) );
       
        txtNumeroVotos = new JTextField();
        txtNumeroVotos.setEditable(false);
        txtNumeroVotos.setFont( new Font( "Dialog", Font.BOLD, 12 ) );
        txtNumeroVotos.setForeground( Color.RED.darker( ) );
        
        JPanel panelImagen = new JPanel( );
        JPanel panelInformacionGlobal = new JPanel( );
        JPanel panelInformacionDatos = new JPanel( );
        JPanel panelInformacionBotones = new JPanel( );

        setLayout( new java.awt.BorderLayout( ) );
        setBorder( javax.swing.BorderFactory.createTitledBorder( "Candidato" + numCandidato ) );
        
        panelImagen.setLayout( new BorderLayout( ) );
        
        JLabel temp = new JLabel( );
        temp.setHorizontalAlignment( JLabel.CENTER );
        temp.setIcon( new ImageIcon( "data/candidato" + numCandidato + ".jpg" ) );
        
        panelImagen.add( temp, BorderLayout.CENTER );
        
        add( panelImagen, java.awt.BorderLayout.CENTER );
        
        panelInformacionGlobal.setLayout( new BorderLayout() );
        panelInformacionDatos.setLayout( new GridLayout( 5, 2 ) );
        panelInformacionBotones.setLayout( new GridLayout( 2, 1 ) );

        panelInformacionDatos.add( lblNombreCandidato );
        panelInformacionDatos.add( txtNombreCandidato );
        panelInformacionDatos.add( lblEdadCandidato );
        panelInformacionDatos.add( txtEdadCandidato );
        panelInformacionDatos.add( lblPartidoPoliticoCandidato );
        panelInformacionDatos.add( txtPartidoPoliticoCandidato );
        panelInformacionDatos.add( lblCostoCampanhaCandidato );
        panelInformacionDatos.add( txtCostoCampanhaCandidato );
        
        
        panelInformacionDatos.add( lblNumeroVotos );
        panelInformacionDatos.add( txtNumeroVotos );
        
        
        panelInformacionBotones.add( btnEstadisticas );
        panelInformacionBotones.add( btnVotar );
        
        panelInformacionGlobal.add(panelInformacionDatos, BorderLayout.CENTER);
        panelInformacionGlobal.add(panelInformacionBotones, BorderLayout.SOUTH);
   
        add( panelInformacionGlobal, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la visualización de la información
     * @param candidato Candidato de donde se saca la información. candidato != null.
     */
    public void actualizar( Candidato candidato )
    {
        txtNombreCandidato.setText( candidato.darNombre( ) + " " +  candidato.darApellido() );
        txtEdadCandidato.setText( "" + candidato.darEdad( ) );
        txtPartidoPoliticoCandidato.setText( String.valueOf( candidato.darPartidoPolitico( ) ) );
        txtCostoCampanhaCandidato.setText( formatearValorReal( candidato.darCostoCampanha( ) ) );
        txtNumeroVotos.setText( "" + candidato.darVotos( ) );

        if( principal.darTotalVotosUrna( ) == 0 )
            btnEstadisticas.setEnabled( false );
        else
            btnEstadisticas.setEnabled( true );

    }

    /**
     * Manejo de eventos del usuario
     * @param e Evento de usuario. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( VOTAR.equals( e.getActionCommand( ) ) )
        {
            principal.mostrarDialogoVotar(numCandidato);
        }
        else if( ESTADISTICAS_VOTOS.equals( e.getActionCommand( ) ) )
        {
            principal.mostrarDialogoEstadisticasCondidato( numCandidato );
        }

    }

    /**
     * Formatea un valor numérico real para presentar en la interfaz <br>
     * @param valor El valor numérico a ser formateado
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatearValorReal( double valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }
}