/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio:  n1_lineasTelefonicas
 * Autor: Pablo Barvo - Dec 7, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.lineasTelefonicas.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.lineasTelefonicas.mundo.Empresa;

/**
 * Panel con los totales
 */
public class PanelTotales extends JPanel
{

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Etiqueta con el costo total de llamadas
     */
    private JLabel etiquetaCosto;

    /**
     * Etiqueta Total llamadas
     */
    private JLabel etiquetaNumeroLlamadas;

    /**
     * Etiqueta Total minutos
     */
    private JLabel etiquetaMinutos;

    /**
     * Costo promedio de llamadas
     */
    private JLabel etiquetaCostoPromedio;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel
     */
    public PanelTotales( )
    {
        setBorder( new TitledBorder( "Totales" ) );
        setLayout( new GridBagLayout( ) );

        //
        //Etiqueta Costo
        etiquetaCosto = new JLabel( formatearValor( 0 ) );
        etiquetaCosto.setForeground( Color.BLUE.darker( ) );
        etiquetaCosto.setFont( new Font( "Tahoma", Font.BOLD, 48 ) );

        //
        //Etiqueta Numero de llamadas
        etiquetaNumeroLlamadas = new JLabel( "Total Llamadas: 0" );

        //Etiqueta Total de Minutos
        etiquetaMinutos = new JLabel( "Total Minutos: 0" );

        //Etiqueta costo promedio por minuto
        etiquetaCostoPromedio = new JLabel( "Costo promedio por minuto: N/A" );

        //Organización
        GridBagConstraints posicion = new GridBagConstraints( 2, 2, 1, 15, 1, 15, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaCosto, posicion );

        posicion = new GridBagConstraints( 2, 17, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaNumeroLlamadas, posicion );

        posicion = new GridBagConstraints( 2, 18, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaMinutos, posicion );

        posicion = new GridBagConstraints( 2, 19, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaCostoPromedio, posicion );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Actualiza la información
     * @param empresa Empresa de la cual se va a mostrar la información. empresa != null.
     */
    public void actualizar( Empresa empresa )
    {
        etiquetaCosto.setText( formatearValor( empresa.darTotalCostoLlamadas( ) ) );
        etiquetaNumeroLlamadas.setText( "Total Llamadas: " + formatearValorEntero( empresa.darTotalNumeroLlamadas( ) ) );
        etiquetaMinutos.setText( "Total de Minutos: " + formatearValorEntero( empresa.darTotalMinutos( ) ) );
        if( !Double.isNaN( empresa.darCostoPromedioMinuto( ) ) )
        {
            etiquetaCostoPromedio.setText( "Costo promedio por minuto: " + formatearValor( empresa.darCostoPromedioMinuto( ) ) );
        }
        else
        {
            etiquetaCostoPromedio.setText( "Costo promedio por minuto: N/A" );
        }
    }

    /**
     * Formatea un valor numérico para presentar en la interfaz <br>
     * @param valor El valor numérico a ser formateado
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
     * @param valor El valor numérico a ser formateado
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatearValorEntero( int valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###" );
        df.setMinimumFractionDigits( 0 );
        return df.format( valor );
    }

}
