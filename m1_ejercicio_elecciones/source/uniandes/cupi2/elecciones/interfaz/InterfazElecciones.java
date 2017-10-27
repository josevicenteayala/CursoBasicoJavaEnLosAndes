/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazElecciones.java 445 2007-06-25 16:30:28Z camil-ji $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_elecciones
 * Autor: Carlos Andrés Vega - 29-ene-2007
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.elecciones.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.elecciones.mundo.Candidato;
import uniandes.cupi2.elecciones.mundo.Urna;

/**
 * Esta es la ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class InterfazElecciones extends JFrame
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Clase principal del mundo
	 */
	private Urna urna;

	// -----------------------------------------------------------------
	// Atributos de la interfaz
	// -----------------------------------------------------------------

	/**
	 * Panel con la imagen
	 */
	private PanelImagen panelImagen;

	/**
	 * Panel del candidato 1.
	 */
	private PanelCandidato panelCandidato1;

	/**
	 * Panel del candidato 2.
	 */
	private PanelCandidato panelCandidato2;

	/**
	 * Panel del candidato 3.
	 */
	private PanelCandidato panelCandidato3;

	/**
	 * Panel con los totales de la urna.
	 */
	private PanelUrna panelUrna;

	/**
	 * Panel con las extensiones
	 */
	private PanelExtension panelExtension;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor donde se arma la interfaz.
	 */
	public InterfazElecciones( )
	{
		// Crea la clase principal
		urna = new Urna( );

		// Construye la forma
		setTitle( "Elecciones Cupi2" );
		getContentPane( ).setLayout( new BorderLayout( ) );
		setSize(670, 760 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setResizable( true );

		// Creación de los paneles aquí

		// Panel imagen
		panelImagen = new PanelImagen( );
		getContentPane( ).add( panelImagen, BorderLayout.NORTH );

		// Construye el panel con los tres candidatos

		JPanel panelCandidatos = new JPanel( );
		panelCandidatos.setLayout( new GridLayout( 1, 3 ) );
		getContentPane( ).add( panelCandidatos, BorderLayout.CENTER );
		panelCandidato1 = new PanelCandidato( this, 1 );
		panelCandidatos.add( panelCandidato1 );
		panelCandidato2 = new PanelCandidato( this, 2 );
		panelCandidatos.add( panelCandidato2 );
		panelCandidato3 = new PanelCandidato( this, 3 );
		panelCandidatos.add( panelCandidato3 );

		JPanel panelInferior = new JPanel( );
		panelInferior.setLayout( new BorderLayout( ) );
		getContentPane( ).add( panelInferior, BorderLayout.SOUTH );
		panelUrna = new PanelUrna( );
		panelInferior.add( panelUrna, BorderLayout.CENTER );
		panelExtension = new PanelExtension( this );
		panelInferior.add( panelExtension, BorderLayout.SOUTH );
		setLocationRelativeTo( null );

		actualizar( );
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Adiciona un voto a un candidato dependiendo del medio que mas influenció el voto. Registra el género y el rango de edad del votante.
	 * @param numCandidato número del candidato a adicionar el voto.
	 * @param influencia La influencia del votante.
	 * @param genero El género del votante.
	 * @param rangoEdad El rango de edad del votante.
	 */
	public void adicionarVotoCandidato( int numCandidato, String influencia, String genero, String rangoEdad )
	{


		if( numCandidato == 1 )
		{
			urna.registrarVotoCandidato1();
			
			if( influencia.equals( "Televisión" ) )
			{
				urna.ingresarVotoTelevisionCandidato1( );
			}
			if( influencia.equals( "Radio" ) )
			{
				urna.ingresarVotoRadioCandidato1( );
			}
			if( influencia.equals( "Internet" ) )
			{
				urna.ingresarVotoInternetCandidato1( );
			}

			if( genero.equals( "Femenino" ) )
			{
				urna.registrarVotoGeneroFemeninoCandidato1();
			}
			if( genero.equals( "Masculino" ) )
			{
				urna.registrarVotoGeneroMasculinoCandidato1();;
			}

			if( rangoEdad.equals( "Jóven: 18 - 34 años" ) )
			{
				urna.registrarVotoEdadJovenCandidato1();
			}
			if( rangoEdad.equals( "Media: 35 - 54 años" ) )
			{
				urna.registrarVotoEdadMediaCandidato1();
			}
			if( rangoEdad.equals( "Mayor: 55 o más años" ) )
			{
				urna.registrarVotoEdadMayorCandidato1();
			}

		}
		if( numCandidato == 2 )
		{
			urna.registrarVotoCandidato2();
			
			if( influencia.equals( "Televisión" ) )
			{
				urna.ingresarVotoTelevisionCandidato2( );
			}
			if( influencia.equals( "Radio" ) )
			{
				urna.ingresarVotoRadioCandidato2( );
			}
			if( influencia.equals( "Internet" ) )
			{
				urna.ingresarVotoInternetCandidato2( );
			}

			if( genero.equals( "Femenino" ) )
			{
				urna.registrarVotoGeneroFemeninoCandidato2();
			}
			if( genero.equals( "Masculino" ) )
			{
				urna.registrarVotoGeneroMasculinoCandidato2();;
			}

			if( rangoEdad.equals( "Jóven: 18 - 34 años" ) )
			{
				urna.registrarVotoEdadJovenCandidato2();
			}
			if( rangoEdad.equals( "Media: 35 - 54 años" ) )
			{
				urna.registrarVotoEdadMediaCandidato2();
			}
			if( rangoEdad.equals( "Mayor: 55 o más años" ) )
			{
				urna.registrarVotoEdadMayorCandidato2();
			}
		}
		if( numCandidato == 3 )
		{
			urna.registrarVotoCandidato3();
			
			if( influencia.equals( "Televisión" ) )
			{
				urna.ingresarVotoTelevisionCandidato3( );
			}
			if( influencia.equals( "Radio" ) )
			{
				urna.ingresarVotoRadioCandidato3( );
			}
			if( influencia.equals( "Internet" ) )
			{
				urna.ingresarVotoInternetCandidato3( );
			}

			if( genero.equals( "Femenino" ) )
			{
				urna.registrarVotoGeneroFemeninoCandidato3();
			}
			if( genero.equals( "Masculino" ) )
			{
				urna.registrarVotoGeneroMasculinoCandidato3();;
			}

			if( rangoEdad.equals( "Jóven: 18 - 34 años" ) )
			{
				urna.registrarVotoEdadJovenCandidato3();
			}
			if( rangoEdad.equals( "Media: 35 - 54 años" ) )
			{
				urna.registrarVotoEdadMediaCandidato3();
			}
			if( rangoEdad.equals( "Mayor: 55 o más años" ) )
			{
				urna.registrarVotoEdadMayorCandidato3();

			}
		}

		actualizar( );

	}

	/**
	 * Restaura la urna
	 * 
	 */
	public void vaciarUrna( )
	{
		urna.vaciarUrna( );
		actualizar( );

	}

	/**
	 * Se informa el porcentaje de votos de un candidato dado.
	 * @param numCandidato El número del candidato del cual se va a mostrar el porcentaje de votos
	 */
	public void mostrarDialogoPorcentajeVotos( int numCandidato )
	{

		if( numCandidato == 1 )
		{
			JOptionPane.showMessageDialog( this, "Porcentaje de votos: " + formatearValorReal( urna.calcularPorcentajeVotosCandidato1( ) ) + " %", "Candidato " + numCandidato, JOptionPane.INFORMATION_MESSAGE );
		}
		if( numCandidato == 2 )
		{
			JOptionPane.showMessageDialog( this, "Porcentaje de votos: " + formatearValorReal( urna.calcularPorcentajeVotosCandidato2( ) ) + " %", "Candidato " + numCandidato, JOptionPane.INFORMATION_MESSAGE );
		}
		if( numCandidato == 3 )
		{
			JOptionPane.showMessageDialog( this, "Porcentaje de votos: " + formatearValorReal( urna.calcularPorcentajeVotosCandidato3( ) ) + " %", "Candidato " + numCandidato, JOptionPane.INFORMATION_MESSAGE );
		}
	}

	/**
	 * Total de votos de la urna
	 * @return El total de votos que contiene la urna
	 */
	public int darTotalVotosUrna( )
	{
		return urna.calcularTotalVotos( );
	}

	/**
	 * Muestra el dialogo para votar
	 * @param numCandidato número del candidato a adicionar el voto.
	 */
	public void mostrarDialogoVotar(int numCandidato )
	{
		DialogoVotar dialogo = new DialogoVotar( this, numCandidato );
		dialogo.setVisible( true );
	}

	/**
	 * Muestra el dialogo de estadísticas de un candidato
	 * @param numCandidato Número del candidato.
	 */
	public void mostrarDialogoEstadisticasCondidato(int numCandidato )
	{
		Candidato candidato = urna.darCandidato3();
		String pctjeVotos = formatearValorReal( urna.calcularPorcentajeVotosCandidato3( ) );
		String pctjeVotosInt = formatearValorReal( urna.calcularPorcentajeVotosPorInternetCandidato3() );
		
		if(numCandidato == 1)
		{
			candidato = urna.darCandidato1();
			pctjeVotos = formatearValorReal( urna.calcularPorcentajeVotosCandidato1( ) );
			pctjeVotosInt = formatearValorReal( urna.calcularPorcentajeVotosPorInternetCandidato1() );
		}
		
		if(numCandidato == 2)
		{
			candidato = urna.darCandidato2();
			pctjeVotos = formatearValorReal( urna.calcularPorcentajeVotosCandidato2( ) );
			pctjeVotosInt = formatearValorReal( urna.calcularPorcentajeVotosPorInternetCandidato2() );
		}
		
		DialogoEstadisticasCandidato dialogo = new DialogoEstadisticasCandidato( this, candidato, pctjeVotos, pctjeVotosInt );
        dialogo.setVisible( true );
	}
	// -----------------------------------------------------------------
	// Puntos de Extensión
	// -----------------------------------------------------------------

	/**
	 * Método para la extensión 1
	 */
	public void reqFuncOpcion1( )
	{
		String resultado = urna.metodo1( );
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * Método para la extensión 2
	 */
	public void reqFuncOpcion2( )
	{
		String resultado = urna.metodo2( );
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	// -----------------------------------------------------------------
	// Main
	// -----------------------------------------------------------------

	/**
	 * Este método ejecuta la aplicación, creando una nueva interfaz
	 * @param args
	 */
	public static void main( String[] args )
	{

		InterfazElecciones interfaz = new InterfazElecciones( );
		interfaz.setVisible( true );
	}

	/**
	 * Actualiza la visualización de la interfaz <br>
	 * <b>post: </b> Se actualiza la visualización
	 */
	private void actualizar( )
	{
		panelCandidato1.actualizar( urna.darCandidato1( ) );
		panelCandidato2.actualizar( urna.darCandidato2( ) );
		panelCandidato3.actualizar( urna.darCandidato3( ) );
		panelUrna.actualizar( urna );
	}

	/**
	 * Formatea un valor numérico real para presentar en la interfaz <br>
	 * @param valor El valor numérico a ser formateado
	 * @return Cadena con el valor formateado con puntos y signos.
	 */
	private String formatearValorReal( double valor )
	{
		DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
		df.applyPattern( " ###,###.##" );
		df.setMinimumFractionDigits( 2 );
		return df.format( valor );
	}

}