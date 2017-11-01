package uniandes.cupi2.avion.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.avion.mundo.Pasajero;
import uniandes.cupi2.avion.mundo.Pelicula;

/**
 * Dialogo para agregar una pel�cula.
 */
public class DialogoAgregarPelicula extends JDialog implements ActionListener
{
    // -----------------------------------------------
    // Atributos
    // -----------------------------------------------

    /**
     * Comando aceptar
     */
    private final static String ACEPTAR = "ACEPTAR";

    /**
     * Ventana principal de la aplicaci�n
     */
    private InterfazAvion principal;

    /**
     * Etiqueta c�dula pasajero.
     */
    private JLabel labelCedulaPasajero;

    /**
     * Etiqueta nombre pel�cula.
     */
    private JLabel labelNombre;

    /**
     * Etiqueta g�nero pelicula.
     */
    private JLabel labelGenero;

    /**
     * Etiqueta duraci�n pel�cula.
     */
    private JLabel labelDuracion;

    /**
     * Etiqueta director pel�cula.
     */
    private JLabel labelDirector;

    /**
     * Texto c�dula pasajero.
     */
    private JTextField textoCedulaPasajero;
    
    /**
     * Texto nombre pel�cula.
     */
    private JTextField textoNombre;

    /**
     * Combo g�nero.
     */
    private JComboBox comboGenero;

    /**
     * Texto duraci�n.
     */
    private JTextField textoDuracion;

    /**
     * Texto director.
     */
    private JTextField textoDirector;

    /**
     * Bot�n aceptar.
     */
    private JButton botonAceptar;

    // -----------------------------------------------
    // M�todos
    // -----------------------------------------------

    /**
     * Constructor del dialogo.
     * @param ventana Ventana principal de la aplicaci�n.
     */
    public DialogoAgregarPelicula( InterfazAvion ventana)
    {

        super( ventana, true );

        principal = ventana;

        setLayout( new BorderLayout( 10, 10 ) );

        JPanel panelNorte = new JPanel();
        JPanel panelCentral = new JPanel( );
        JPanel panelSur = new JPanel( );

        panelNorte.setLayout(new GridLayout(1, 2));
        labelCedulaPasajero = new JLabel( "C�dula pasajero:" );
        panelNorte.add( labelCedulaPasajero );
        textoCedulaPasajero = new JTextField( );
        panelNorte.add( textoCedulaPasajero );
        add(panelNorte, BorderLayout.NORTH);
        
        panelCentral.setBorder( new TitledBorder( "Informaci�n pel�cula" ) );
        panelCentral.setLayout( new GridLayout( 4, 2, 5, 5 ) );

        labelNombre = new JLabel( "Nombre:" );
        panelCentral.add( labelNombre );

        textoNombre = new JTextField( );
        panelCentral.add( textoNombre );

        labelGenero = new JLabel( "G�nero:" );
        panelCentral.add( labelGenero );

        comboGenero = new JComboBox();
        comboGenero.addItem(Pelicula.ACCION);
        comboGenero.addItem(Pelicula.COMEDIA);
        comboGenero.addItem(Pelicula.DRAMA);
        comboGenero.addItem(Pelicula.INFANTIL);
        comboGenero.addItem(Pelicula.ROMANCE);
        panelCentral.add( comboGenero );

        labelDuracion = new JLabel( "Duraci�n (mins):" );
        panelCentral.add( labelDuracion );

        textoDuracion = new JTextField( );
        panelCentral.add( textoDuracion );

        labelDirector = new JLabel( "Director:" );
        panelCentral.add( labelDirector );

        textoDirector = new JTextField( );
        panelCentral.add( textoDirector );

        add( panelCentral, BorderLayout.CENTER );

        botonAceptar = new JButton( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );

        panelSur.add( botonAceptar );

        add( panelSur, BorderLayout.SOUTH );

        setSize( new Dimension( 230, 250 ) );
        setLocationRelativeTo( principal );

    }

    /**
     * M�todo para manejar acciones
     * @param e Acci�n generada
     */
    public void actionPerformed( ActionEvent e )
    {
        if( e.getActionCommand( ).equals( ACEPTAR ) )
        {
            

            try
            {
            	int cedula = Integer.parseInt(textoCedulaPasajero.getText());
                int duracion = Integer.parseInt( textoDuracion.getText());
                String nombre = textoNombre.getText();
                String genero = (String) comboGenero.getSelectedItem();
                String director = textoDirector.getText();

                if( !nombre.equals( "" )&&  !director.equals( "" ) )
                {
                    
                    if(duracion>0)
                    {
                    	principal.agregarPelicula(cedula, nombre, genero, duracion, director);
                    }
                    else
                    {
                    	JOptionPane.showMessageDialog(this, "La duraci�n de la pel�cula debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    
                }
                else
                    JOptionPane.showMessageDialog( this, "Debe ingresar nombre de la pel�cula y director." );
            }
            catch( Exception e2 )
            {
                JOptionPane.showMessageDialog( this, "Error en el formato de la duraci�n y/o c�dula." );
            }
            dispose( );

        }

    }

}
