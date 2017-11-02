/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co) (http://cupi2.uniandes.edu.co)
 * Ejercicio:  n1_lineasTelefonicas
 * Imágenes tomadas de: http://www.shopnbu.com/classic-phones/crosley-retro-classic-1950-desk-phone-ivory-1950-desk-iv.shtml
 * Autor: Pablo Barvo - Dec 6, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.lineasTelefonicas.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.lineasTelefonicas.mundo.LineaCelular;
import uniandes.cupi2.lineasTelefonicas.mundo.LineaTelefonica;
import uniandes.cupi2.lineasTelefonicas.mundo.LineaVozIP;

/**
 * Panel con la información de una línea telefónica
 */
public class PanelLineaTelefonicaVozIP extends JPanel implements ActionListener
{

    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando Agregar llamada
     */
    private static final String AGREGAR = "AGREGAR";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazLineasTelefonicas principal;

    /**
     * Número del línea telefónica
     */
    private int numeroLinea;

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Etiqueta con la imagen del teléfono
     */
    private JLabel etiquetaImagen;

    /**
     * Etiqueta costo de llamadas
     */
    private JLabel etiquetaCosto;
    
    /**
     * Etiqueta con el saldo disponible
     */
    private JLabel etiquetaSaldo;

    /**
     * Etiqueta número de llamadas
     */
    private JLabel etiquetaNumeroLlamadas;

    /**
     * Etiqueta minutos consumidos en llamadas
     */
    private JLabel etiquetaMinutos;
    
    /**
     * Etiqueta minutos consumidos en llamadas larga distancia
     */
    private JLabel etiquetaMinutosLargaDistancia;    
    
    /**
     * Etiqueta minutos consumidos en llamadas a celular
     */
    private JLabel etiquetaMinutosCelular;

    /**
     * Botón Agregar llamada
     */
    private JButton btnAgregar;
 

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param laPrincipal Ventana principal. laPrincipal != null.
     * @param elNumeroLinea Número de la línea.
     */
    public PanelLineaTelefonicaVozIP( InterfazLineasTelefonicas laPrincipal, int elNumeroLinea )
    {
        principal = laPrincipal;
        numeroLinea = elNumeroLinea;
        setBorder( new TitledBorder( "Línea #" + numeroLinea ) );
        setLayout( new GridBagLayout( ) );
        setPreferredSize( new Dimension( 280, 250 ) );

        //
        //Etiqueta de Imagen
        ImageIcon icono = new ImageIcon( "data/linea" + numeroLinea + ".jpg" );
        etiquetaImagen = new JLabel( "" );
        etiquetaImagen.setIcon( icono );
        etiquetaImagen.setBorder( new TitledBorder( "" ) );

        //
        //Etiqueta Costo
        etiquetaCosto = new JLabel( formatearValor( 0 ) );
        etiquetaCosto.setForeground( Color.BLUE.darker( ) );
        etiquetaCosto.setFont( new Font( "Tahoma", Font.BOLD, 18 ) );
        
        JPanel panelCosto = new JPanel();
        panelCosto.setLayout(new BorderLayout());
        panelCosto.add(new JLabel("Costo:  "),BorderLayout.WEST);
        panelCosto.add(etiquetaCosto,BorderLayout.CENTER);

        //
        //Etiqueta Número de llamadas
        etiquetaNumeroLlamadas = new JLabel( "Número llamadas: 0" );

        //Etiqueta Total de Minutos
        etiquetaMinutos = new JLabel( "Número de minutos: 0" );
        
        etiquetaMinutosLargaDistancia = new JLabel( "Número de minutos larga distancia: 0" );        

        etiquetaMinutosCelular = new JLabel("Número de minutos celular: 0");
        
        //Etiqueta Saldo Disponible
        etiquetaSaldo = new JLabel(formatearValor(0));
        etiquetaSaldo.setForeground( Color.GREEN.darker( ) );
        etiquetaSaldo.setFont( new Font( "Tahoma", Font.BOLD, 18 ) );
        
        JPanel panelSaldo = new JPanel();
        panelSaldo.setLayout(new BorderLayout());
        panelSaldo.add(new JLabel("Saldo C y LD:  "),BorderLayout.WEST);
        panelSaldo.add(etiquetaSaldo,BorderLayout.CENTER);       
        
        //
        //Botón Agregar llamada
        btnAgregar = new JButton( "Agregar llamada" );
        btnAgregar.setPreferredSize( new Dimension( 150, 25 ) );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );

        //
        //Organización
        GridBagConstraints posicion = new GridBagConstraints( 0, 0, 2, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaImagen, posicion );

        posicion = new GridBagConstraints( 2, 0, 4, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( panelCosto, posicion );
        
        posicion = new GridBagConstraints( 2, 1, 4, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( panelSaldo, posicion );

        posicion = new GridBagConstraints( 0, 2, 6, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaNumeroLlamadas, posicion );

        posicion = new GridBagConstraints( 0, 4, 6, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaMinutos, posicion );
        
        posicion = new GridBagConstraints( 0, 5, 6, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaMinutosLargaDistancia, posicion );

        posicion = new GridBagConstraints( 0, 6, 6, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaMinutosCelular, posicion );
        
        posicion = new GridBagConstraints( 0, 7, 6, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( btnAgregar, posicion );        
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Actualiza la visualización de la información
     * @param linea Línea telefónica donde se saca la información. linea != null.
     */
    public void actualizar( LineaVozIP linea )
    {
        etiquetaCosto.setText( formatearValor( linea.darCostoLlamadas( ) ) );
        etiquetaSaldo.setText(formatearValor(linea.darSaldoDisponible()));
        etiquetaNumeroLlamadas.setText( "Número llamadas: " + formatearValorEntero( linea.darNumeroLlamadas( ) ) );
        etiquetaMinutos.setText( "Número de minutos: " + formatearValorEntero( linea.darNumeroMinutos( ) ) );
        etiquetaMinutosLargaDistancia.setText( "Número de minutos larga distacia: " + formatearValorEntero( linea.darNumeroMinutos()) );
        etiquetaMinutosCelular.setText( "Número de minutos celular: " + formatearValorEntero( linea.darNumeroMinutosCelular( ) ) );
    }

    /**
     * Formatea un valor numérico para presentar en la interfaz.
     * @param valor Valor numérico a ser formateado
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatearValor( double valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }

    /**
     * Formatea un valor numérico para presentar en la interfaz <br>
     * @param valor Valor numérico a ser formateado
     * @return Retorna una cadena con el valor formateado con puntos y signos.
     */
    private String formatearValorEntero( int valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###" );
        df.setMinimumFractionDigits( 0 );
        return df.format( valor );
    }

    /**
     * Manejo de eventos del usuario
     * @param e Evento de usuario. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( AGREGAR.equals( e.getActionCommand( ) ) )
        {
            principal.agregarLlamada( numeroLinea );
        }
    }

}
