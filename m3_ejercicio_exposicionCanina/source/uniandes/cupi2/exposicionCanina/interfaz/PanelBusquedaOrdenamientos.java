/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelBusquedaOrdenamientos.java,v 1.4 2006/08/04 15:12:57 da-romer Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_exposicionCanina 
 * Autor: Daniel Romero- 30/06/2006 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.exposicionCanina.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Este es el panel donde se encuentran los botones para realizar los ordenamientos por distintos criterios y las búsquedas.
 */
public class PanelBusquedaOrdenamientos extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String BUSCAR = "Buscar";

    private static final String ORDENAR_PUNTOS = "OrdenarPuntos";

    private static final String ORDENAR_EDAD = "OrdenarEdad";

    private static final String ORDENAR_RAZA = "OrdenarRaza";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazExposicionCanina principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Es el botón para ordenar la lista de perros por raza
     */
    private JButton botonOrdenarRaza;

    /**
     * Es el botón para ordenar la lista de perros por puntos
     */
    private JButton botonOrdenarPuntos;

    /**
     * Es el botón para ordenar la lista de perros por edad
     */
    private JButton botonOrdenarEdad;

    /**
     * Es el botón para realizar una búsqueda
     */
    private JButton botonBuscar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes.
     * @param ventanaPrincipal es una referencia a la clase principal de la interfaz - ventanaPrincipal != null
     */
    public PanelBusquedaOrdenamientos( InterfazExposicionCanina ventanaPrincipal )
    {
        principal = ventanaPrincipal;

        setPreferredSize( new Dimension( 200, 0 ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Búsqueda y ordenamientos" ) ) );
        setLayout( new GridBagLayout( ) );

        botonOrdenarRaza = new JButton( "Ordenar por Raza" );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        botonOrdenarRaza.setActionCommand( ORDENAR_RAZA );
        botonOrdenarRaza.addActionListener( this );
        add( botonOrdenarRaza, gbc );

        botonOrdenarPuntos = new JButton( "Ordenar por Puntos" );
        botonOrdenarPuntos.setActionCommand( ORDENAR_PUNTOS );
        botonOrdenarPuntos.addActionListener( this );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        add( botonOrdenarPuntos, gbc );

        botonOrdenarEdad = new JButton( "Ordenar por Edad" );
        botonOrdenarEdad.setActionCommand( ORDENAR_EDAD );
        botonOrdenarEdad.addActionListener( this );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        add( botonOrdenarEdad, gbc );

        botonBuscar = new JButton( "Buscar Perro" );
        botonBuscar.setActionCommand( BUSCAR );
        botonBuscar.addActionListener( this );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        gbc.fill = GridBagConstraints.BOTH;
        add( botonBuscar, gbc );
    }

    /**
     * Ejecuta una acción según el botón que se haya presionado.
     * @param evento es el evento de click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( ORDENAR_RAZA.equals( comando ) )
        {
            principal.ordenarPorRaza( );
        }
        else if( ORDENAR_PUNTOS.equals( comando ) )
        {
            principal.ordenarPorPuntos( );
        }
        else if( ORDENAR_EDAD.equals( comando ) )
        {
            principal.ordenarPorEdad( );
        }
        else if( BUSCAR.equals( comando ) )
        {
            principal.buscar( );
        }
    }
}
