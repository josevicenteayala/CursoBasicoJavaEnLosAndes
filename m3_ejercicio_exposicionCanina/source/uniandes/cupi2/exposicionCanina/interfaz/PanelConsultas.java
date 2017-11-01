/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelConsultas.java,v 1.4 2006/08/04 15:12:57 da-romer Exp $ 
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
 * Este es el panel donde se encuentran los botones para hacer consulta sobre la exposición
 * 
 */
public class PanelConsultas extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String GANADOR = "Ganador";

    private static final String MENOS_PUNTOS = "Menos puntos";

    private static final String MAYOR_EDAD = "Mayor edad";

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
     * Es el botón para mostrar el nombre del perro ganador
     */
    private JButton botonGanador;

    /**
     * Es el botón para mostrar el perro con menos puntos
     */
    private JButton botonMenosPuntos;

    /**
     * Es el botón para mostrar el nombre del perro con mayor edad
     */
    private JButton botonMayorEdad;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye el panel e inicializa sus componentes.
     * @param ventanaPrincipal es una referencia a la clase principal de la interfaz - ventanaPrincipal != null
     */
    public PanelConsultas( InterfazExposicionCanina ventanaPrincipal )
    {
        principal = ventanaPrincipal;
        setLayout( new GridLayout( 4, 1, 10, 10 ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Consultas Exposición" ) ) );

        // Ganador
        botonGanador = new JButton( "Ganador" );
        botonGanador.addActionListener( this );
        botonGanador.setActionCommand( GANADOR );
        add( botonGanador );

        // Menos puntos
        botonMenosPuntos = new JButton( "Menor Puntaje" );
        botonMenosPuntos.addActionListener( this );
        botonMenosPuntos.setActionCommand( MENOS_PUNTOS );
        add( botonMenosPuntos );

        // Mayos edad
        botonMayorEdad = new JButton( "Más Viejo" );
        botonMayorEdad.addActionListener( this );
        botonMayorEdad.setActionCommand( MAYOR_EDAD );
        add( botonMayorEdad );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta una acción según el botón que se haya presionado.
     * @param evento es el evento de click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( GANADOR.equals( comando ) )
        {
            principal.buscarGanador( );
        }
        else if( MENOS_PUNTOS.equals( comando ) )
        {
            principal.buscarMenorPuntaje( );
        }
        else if( MAYOR_EDAD.equals( comando ) )
        {
            principal.buscarMayorEdad( );
        }
    }
}
