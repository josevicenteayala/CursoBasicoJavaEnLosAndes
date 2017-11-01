/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelListaPerros.java,v 1.9 2010/03/29 20:47:53 lr.ruiz114 Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_exposicionCanina 
 * Autor: Mario Sánchez - 26/08/2005 
 * Modificado por: Daniel Romero- 30/06/2006 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.exposicionCanina.interfaz;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import uniandes.cupi2.exposicionCanina.mundo.*;

/**
 * Es el panel donde se muestra la lista de perros y están los botones para interactuar con la lista
 */
public class PanelListaPerros extends JPanel implements ListSelectionListener
{
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
     * Es la lista que se muestra
     */
    private JList listaPerros;

    /**
     * Componente de desplazamiento para contener la lista gráfica
     */
    private JScrollPane scroll;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes
     * @param ventanaPrincipal es una referencia a la clase principal de la interfaz - ventanaPrincipal != null
     */
    public PanelListaPerros( InterfazExposicionCanina ventanaPrincipal )
    {
        principal = ventanaPrincipal;

        setLayout( new BorderLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Perros en la exposición" ) ) );

        listaPerros = new JList( );
        listaPerros.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        listaPerros.addListSelectionListener( this );

        scroll = new JScrollPane( listaPerros );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );

        add( scroll, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de perros que se está mostrando
     * @param nuevaLista es una lista con los perros que deben mostrarse
     */
    public void refrescarLista( ArrayList nuevaLista )
    {
        listaPerros.setListData( nuevaLista.toArray( ) );
        listaPerros.setSelectedIndex( 0 );
    }

    /**
     * Selecciona un elemento de la lista
     * @param seleccionado es la posición del elemento que se debe seleccionar
     */
    public void seleccionar( int seleccionado )
    {
        listaPerros.setSelectedIndex( seleccionado );
        listaPerros.ensureIndexIsVisible( seleccionado );
    }

    /**
     * Cambia la información del perro que se está mostrando de acuerdo al nuevo perro seleccionado
     * @param e es el evento de cambio el ítem seleccionado en la lista
     */
    public void valueChanged( ListSelectionEvent e )
    {
        if( listaPerros.getSelectedValue( ) != null )
        {
            Perro p = ( Perro )listaPerros.getSelectedValue( );
            principal.verDatos( p );
        }
    }
}