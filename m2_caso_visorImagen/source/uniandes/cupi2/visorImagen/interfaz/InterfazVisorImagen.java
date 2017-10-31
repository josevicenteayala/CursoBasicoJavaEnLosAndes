/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_visorImagen 
 * Autor: Katalina Marcos
 * Modificaci�n: Mario S�nchez - 28/06/2005
 * Modificaci�n: Pablo Barvo - 1-Sep-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.visorImagen.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

/**
 * Interfaz del visor de im�genes
 */
public class InterfazVisorImagen extends JFrame
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Dimensi�n para la convoluci�n
     */
    public static final int DIMENSION_CONVOLUCION = 3;

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Panel de la imagen
     */
    private PanelImagen panelImagen;

    /**
     * Panel de los botones
     */
    private PanelBotones panelBotones;

    /**
     * Di�logo para pedir la matriz de convoluci�n
     */
    private DialogoMatrizConvolucion dialogoMatriz;

    /**
     * Di�logo para pedir el umbral de binarizaci�n
     */
    private DialogoUmbralBinarizacion dialogoUmbral;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea la interfaz para el visor de im�genes
     */
    public InterfazVisorImagen( )
    {
        //Establece el distribuidor gr�fico
        setLayout( new BorderLayout( ) );

        //Crea y adiciona el panel de la imagen
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.CENTER );

        //Crea y adiciona el panel de botones
        panelBotones = new PanelBotones( this );
        add( panelBotones, BorderLayout.EAST );

        //Crea el di�logo de la matriz de convoluci�n
        dialogoMatriz = new DialogoMatrizConvolucion( this );

        //Crea el di�logo del umbral de binarizaci�n
        dialogoUmbral = new DialogoUmbralBinarizacion( this );

        setTitle( "Visor de Im�genes" );
        pack( );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Da el color promedio de la imagen
     * @return color promedio
     */
    public Color colorPromedio( )
    {
        return panelImagen.colorPromedio( );
    }

    /**
     * Opci�n 1: convertir la imagen en su negativo
     */
    public void convertirNegativo( )
    {
        panelImagen.convertirNegativo( );
    }

    /**
     * Opci�n 2: reflejar la imagen
     */
    public void reflejarImagen( )
    {
        panelImagen.reflejarImagen( );
    }

    /**
     * Presenta el di�logo de definici�n del umbral de binarizaci�n
     */
    public void presentarDialogoUmbral( )
    {
        dialogoUmbral.setVisible( true );
    }

    /**
     * Opci�n 3: binarizar la imagen
     * @param umbral de binarizaci�n
     */
    public void binarizarImagen( double umbral )
    {
        panelImagen.binarizarImagen( umbral );
    }

    /**
     * Opci�n 4: pixelar la imagen
     */
    public void pixelarImagen( )
    {
        panelImagen.pixelarImagen( );
    }

    /**
     * Opci�n 5: convertir a tonos de gris la imagen
     */
    public void convertirAGrises( )
    {
        panelImagen.convertirAGrises( );
    }

    /**
     * Presenta el di�logo de definici�n de la matriz de convoluci�n
     */
    public void presentarDialogoMatrizConvolucion( )
    {
        dialogoMatriz.setVisible( true );
    }

    /**
     * Opci�n 6: aplicar el operador de convoluci�n representado en la matriz
     * @param conv Matriz de convoluci�n
     */
    public void aplicarOperadorConvolucion( double conv[][] )
    {
        panelImagen.aplicarOperadorConvolucion( conv );
    }

    //-----------------------------------------------------------------
    // Puntos de Extensi�n
    //-----------------------------------------------------------------

    /**
     * Extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        panelImagen.extension1( );
    }

    /**
     * Extensi�n 2
     */
    public void reqFuncOpcion2( )
    {
        panelImagen.extension2( );
    }

    //-----------------------------------------------------------------
    // Programa principal
    //-----------------------------------------------------------------
    /**
     * M�todo para la ejecuci�n del programa.
     * @param args No hay argumentos para la ejecuci�n.
     */
    public static void main( String[] args )
    {
        InterfazVisorImagen i = new InterfazVisorImagen( );
        i.setVisible( true );
    }
}