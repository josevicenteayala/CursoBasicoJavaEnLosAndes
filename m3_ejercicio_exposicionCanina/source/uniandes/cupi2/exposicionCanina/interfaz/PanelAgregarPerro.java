/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelAgregarPerro.java,v 1.6 2006/08/04 15:12:57 da-romer Exp $ 
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
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Este es el panel donde se agregan perros
 */
public class PanelAgregarPerro extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String AGREGAR = "AgregarPerro";

    private static final String BUSCAR = "BuscarImagen";

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
     * Es el campo para la ruta hasta la imagen del perro
     */
    private JTextField txtImagen;

    /**
     * Es el campo para el nombre del perro
     */
    private JTextField txtNombre;

    /**
     * Es el campo para la raza del perro
     */
    private JTextField txtRaza;

    /**
     * Es el campo para la edad del perro
     */
    private JTextField txtEdad;

    /**
     * Es el campo para los puntos del perro
     */
    private JTextField txtPuntos;

    /**
     * Es la etiqueta para la imagen del perro
     */
    private JLabel etiquetaImagen;

    /**
     * Es la etiqueta para el nombre del perro
     */
    private JLabel etiquetaNombre;

    /**
     * Es la etiqueta para la raza del perro
     */
    private JLabel etiquetaRaza;

    /**
     * Es la etiqueta para los puntos del perro
     */
    private JLabel etiquetaPuntos;

    /**
     * Es la etiqueta para la edad del perro
     */
    private JLabel etiquetaEdad;

    /**
     * Es el botón que se usa para agregar un perro
     */
    private JButton botonAgregar;

    /**
     * Es el botón que se usa para examinar el disco buscando la imagen del perro
     */
    private JButton botonExaminar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes.
     * @param iec es una referencia a la clase principal de la interfaz
     */
    public PanelAgregarPerro( InterfazExposicionCanina iec )
    {
        principal = iec;

        setLayout( new GridBagLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "Agregar Perro" ) ) );

        JPanel panelDatos = new JPanel( new GridBagLayout( ) );

        // Nombre
        etiquetaNombre = new JLabel( "Nombre: " );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelDatos.add( etiquetaNombre, gbc );
        txtNombre = new JTextField( "" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;

        panelDatos.add( txtNombre, gbc );

        // Raza
        etiquetaRaza = new JLabel( "Raza: " );
        etiquetaRaza.setBorder( new EmptyBorder( 0, 5, 0, 0 ) );
        gbc = new GridBagConstraints( );
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.EAST;

        panelDatos.add( etiquetaRaza, gbc );
        txtRaza = new JTextField( "" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panelDatos.add( txtRaza, gbc );

        // Edad
        etiquetaEdad = new JLabel( "Edad: " );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelDatos.add( etiquetaEdad, gbc );
        txtEdad = new JTextField( "" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        panelDatos.add( txtEdad, gbc );

        // Puntos
        etiquetaPuntos = new JLabel( "Puntos: " );
        etiquetaPuntos.setBorder( new EmptyBorder( 0, 5, 0, 0 ) );
        gbc = new GridBagConstraints( );
        gbc.gridx = 2;
        gbc.gridy = 1;
        panelDatos.add( etiquetaPuntos, gbc );
        txtPuntos = new JTextField( "" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.ipadx = 160;
        panelDatos.add( txtPuntos, gbc );

        // Imagen
        etiquetaImagen = new JLabel( "Imagen: " );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelDatos.add( etiquetaImagen, gbc );
        txtImagen = new JTextField( "" );
        botonExaminar = new JButton( "Examinar" );
        botonExaminar.setActionCommand( BUSCAR );
        botonExaminar.addActionListener( this );

        // Botón agregar
        JPanel panelBoton = new JPanel( );
        botonAgregar = new JButton( "Agregar Perro" );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        panelBoton.add( botonAgregar );

        JPanel panelImagen = new JPanel( new GridLayout( ) );

        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        panelImagen.add( txtImagen );
        gbc = new GridBagConstraints( );
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        panelImagen.add( botonExaminar );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelDatos.add( panelImagen, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add( panelDatos, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add( panelBoton, gbc );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Este es el método que se ejecuta cuando se hace click sobre un botón.
     * @param evento es el evento del click sobre el botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( AGREGAR.equals( comando ) )
        {
            try
            {
                String nombre = txtNombre.getText( );
                String raza = txtRaza.getText( );
                String imagen = txtImagen.getText( );
                int puntos = Integer.parseInt( txtPuntos.getText( ) );
                int edad = Integer.parseInt( txtEdad.getText( ) );

                if( nombre == null || nombre.equals( "" ) )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar el nombre del perro", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( raza == null || raza.equals( "" ) )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar la raza del perro", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else if( imagen == null || imagen.equals( "" ) )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar la imagen del perro", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    principal.agregarPerro( nombre, raza, imagen, puntos, edad );

                    txtNombre.setText( "" );
                    txtRaza.setText( "" );
                    txtImagen.setText( "" );
                    txtPuntos.setText( "" );
                    txtEdad.setText( "" );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "Los campos de puntos y edad deben ser números", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( BUSCAR.equals( comando ) )
        {
            JFileChooser fc = new JFileChooser( "./data" );
            fc.setDialogTitle( "Buscar imagen de perro" );
            fc.setMultiSelectionEnabled( false );

            int resultado = fc.showOpenDialog( this );
            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                String imagen = fc.getSelectedFile( ).getAbsolutePath( );
                txtImagen.setText( imagen );
            }
        }

    }

}
