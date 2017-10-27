package uniandes.cupi2.elecciones.interfaz;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;

import uniandes.cupi2.elecciones.mundo.Candidato;

/**
 * Es el diálogo para mostrar las estadísticas de un candidato.
 */
public class DialogoEstadisticasCandidato extends JDialog
{
	// -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel donde se muestran las estadísticas de un candidato.
     */
    private PanelEstadisticasCandidato panelEstadisticas;
    
 // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo e inicializa sus componentes
     * @param inter Es una referencia a la ventana principal de la interfaz - inter!=null
     * @param Candidato Candidato cuyas estadísticas se mostrarán.
     * @param pctje Porcentaje de votos obtenidos por el candidato.
     * @param pctje Porcentaje de votantes influenciados por internet del candidato .
     */
    public DialogoEstadisticasCandidato( InterfazElecciones inter, Candidato candidato, String pctje, String pctjeInt)
    {
        super( inter, true );

        panelEstadisticas = new PanelEstadisticasCandidato( this, candidato, pctje, pctjeInt );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        getContentPane( ).add( panelEstadisticas );
        setResizable( false );
        setTitle( "Estadísticas candidato " + candidato.darNombre() + " " + candidato.darApellido() );
        pack( );
        centrar( );
    }
    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Centra el diálogo en la pantalla
     */
    private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }
}
