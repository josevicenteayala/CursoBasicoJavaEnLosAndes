/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: VentanaProgreso.java,v 1.4 2006/08/06 20:26:47 da-romer Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License versi�n 2.1
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_muestra
 * Autor: Mario S�nchez - 29/06/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.muestra.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 * Esta es la ventana en la cual se muestra el progreso de un proceso largo (b�squeda u ordenamiento) sobre la muestra
 */
public class VentanaProgreso extends JDialog
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * El n�mero de pasos que tiene la barra de progreso
     */
    private static final int MAXIMO = 15;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la tarea larga que se ejecutar�
     */
    private Thread tarea;

    /**
     * El mensaje que se muestra en la ventana
     */
    private String mensaje;

    /**
     * El n�mero de la imagen de la tira de im�genes que se est� mostrando en un momento dado
     */
    private int numeroImagenMostrada;

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazMuestra principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * La barra de progreso
     */
    private JProgressBar barraProgreso;

    /**
     * La etiqueta donde se muestra el icono animado
     */
    private JLabel etiquetaIcono;

    /**
     * La etiqueta donde se muestra un texto descriptivo
     */
    private JLabel etiquetaTexto;

    /**
     * La tira de im�genes que se muestra como una animaci�n
     */
    private BufferedImage imagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana
     * @param ventanaPrincipal es una referencia a la ventana principal de la aplicaci�n - ventanaPrincipal != null
     * @param titulo es el t�tulo que se muestra en la ventana - titulo != null
     * @param textoMensaje es el mensaje que se muestra en la ventana y que describe lo que se est� haciendo - textoMensaje != null
     * @param tareaMuestra es la tarea que se realizar� sobre la muestra - tareaMuestra != null
     */
    public VentanaProgreso( InterfazMuestra ventanaPrincipal, String titulo, String textoMensaje, Thread tareaMuestra )
    {
        super( ventanaPrincipal, false );
        tarea = tareaMuestra;
        mensaje = textoMensaje;
        principal = ventanaPrincipal;

        // Atributos de la Ventana
        setDefaultCloseOperation( JDialog.DO_NOTHING_ON_CLOSE );
        setTitle( titulo );
        setResizable( false );
        setUndecorated( true );
        getContentPane( ).setBackground( Color.WHITE );

        // Tama�o y Ubicacion
        setSize( 250, 110 );
        int xVentana = ventanaPrincipal.getX( );
        int yVentana = ventanaPrincipal.getY( );
        setLocation( xVentana + ventanaPrincipal.getWidth( ) / 2 - 125, yVentana + ventanaPrincipal.getHeight( ) / 2 - 55 );

        // Imagen Animada
        etiquetaIcono = new JLabel( );
        etiquetaIcono.setMinimumSize( new Dimension( 64, 64 ) );
        getContentPane( ).add( etiquetaIcono, BorderLayout.CENTER );
        numeroImagenMostrada = 0;

        try
        {
            imagen = ImageIO.read( new File( "./data/imagen.jpg" ) );
        }
        catch( IOException e )
        {
        }

        // Texto Mostrado
        etiquetaTexto = new JLabel( mensaje + "           " );
        getContentPane( ).add( etiquetaTexto, BorderLayout.EAST );

        // Barra de Progreso
        barraProgreso = new JProgressBar( 0, MAXIMO );
        barraProgreso.setStringPainted( false );
        getContentPane( ).add( barraProgreso, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Muestra la ventana y ejecuta la tarea. <br>
     * Mientras la tarea est� en ejecuci�n, los botones de la ventana principal est�n desactivados y se muestra la animaci�n del icono y de la barra de progreso.
     */
    public void iniciarTarea( )
    {
        // Crear la tarea que se va a encargar de actualizar la ventana de progreso
        TareaActualizarProgreso tap = new TareaActualizarProgreso( this );

        // Mostrar la ventana de progreso y deshabilitar la ventana principal
        setVisible( true );
        setAlwaysOnTop( true );
        principal.deshabilitarBotones( );

        // Iniciar la tarea sobre la muestra
        tarea.start( );

        while( tarea.isAlive( ) )
        {
            try
            {
                // Encargar al EventDispatchingThread la actualizaci�n de la ventana de progreso
                SwingUtilities.invokeAndWait( tap );
                Thread.sleep( 100 );
            }
            catch( Exception e )
            {
            }
        }

        // Habilitar la ventana principal y cerrar la ventana que muestra el progreso
        principal.habilitarBotones( );
        dispose( );
    }

    /**
     * Avanza un punto en la barra de progreso y un cuadro en la animaci�n del icono
     */
    public void avanzar( )
    {
        int valor = barraProgreso.getValue( );
        barraProgreso.setValue( ( valor + 1 ) % MAXIMO );

        numeroImagenMostrada++;
        numeroImagenMostrada %= 5;

        Graphics g = etiquetaIcono.getGraphics( );
        if( g != null )
        {
            g.clipRect( 0, 0, 64, 64 );
            g.drawImage( imagen, -numeroImagenMostrada * 64, 0, null );
        }
    }
}
