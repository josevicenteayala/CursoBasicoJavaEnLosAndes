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

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel con la imagen de la empresa
 */
public class PanelImagen extends JPanel
{

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Etiqueta con la imagen de la empresa
     */
    private JLabel etiquetaImagen;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del Panel
     */
    public PanelImagen( )
    {

        setLayout( new GridBagLayout( ) );

        //Etiqueta Logo de la empresa
        ImageIcon icono = new ImageIcon( "data/logo.jpg" );
        etiquetaImagen = new JLabel( "" );
        etiquetaImagen.setIcon( icono );

        add( etiquetaImagen );
    }

}
