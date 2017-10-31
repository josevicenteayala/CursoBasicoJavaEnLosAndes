/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Avi�n
 * Autor: Katalina Marcos - Febrero 2005
 * Autor: Pablo Barvo - 24-Ago-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.avion.interfaz;

import java.awt.*;
import java.text.*;
import java.util.ArrayList;

import javax.swing.*;

import uniandes.cupi2.avion.mundo.*;

/**
 * Ventana principal del avi�n
 */
public class InterfazAvion extends JFrame
{

	//-----------------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------------

	/**
	 * Avi�n
	 */
	private Avion avion;

	//-----------------------------------------------------------------
	// Atributos de interfaz
	//-----------------------------------------------------------------

	/**
	 * Panel que contiene el avi�n
	 */
	private PanelAvion panelAvion;

	/**
	 * Panel de botones
	 */
	private PanelBotonesAvion panelBotones;

	/**
	 * Dialogo de nuevo pasajero
	 */
	private DialogoAsignacion dAsignacion;

	//-----------------------------------------------------------------
	// Constructores
	//-----------------------------------------------------------------

	/**
	 * Crea la interfaz del avi�n <br>
	 * <b>post: </b> Se crea el avi�n y se presenta en una gr�fica su estado inicial.
	 */
	public InterfazAvion( )
	{
		//Crea al avi�n
		avion = new Avion( );

		//Configura la interfaz
		setLayout( new BorderLayout( ) );

		//Panel de botones
		panelBotones = new PanelBotonesAvion( this );
		add( panelBotones, BorderLayout.NORTH );

		//Panel del avi�n
		panelAvion = new PanelAvion( avion );
		add( panelAvion, BorderLayout.CENTER );

		String titulo = "El Avi�n";
		setTitle( titulo );
		pack( );
		setResizable( false );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	//-----------------------------------------------------------------
	// M�todos
	//-----------------------------------------------------------------

	/**
	 * Procesa el registro un pasajero
	 */
	public void registrarPasajero( )
	{
		dAsignacion = new DialogoAsignacion( this, avion );
		dAsignacion.setLocation( calculaPosicionCentral( this, dAsignacion ) );
		dAsignacion.setModal( true );
		dAsignacion.setVisible( true );
		actualizar( );
	}

	/**
	 * Procesa la anulaci�n del registro de un pasajero
	 */
	public void anularPasajero( )
	{
		//Pregunta el numero de c�dula
		int cedula;
		String sCedula = JOptionPane.showInputDialog( this, "Ingrese el n�mero de c�dula" );
		try
		{
			cedula = Integer.parseInt( sCedula );
		}
		catch( NumberFormatException e )
		{
			JOptionPane.showMessageDialog( this, "Error en el n�mero de c�dula.", "Anulaci�n", JOptionPane.ERROR_MESSAGE );
			return;
		}

		Pasajero pasajero = new Pasajero( cedula, "no importa" );
		if( !avion.desasignarSilla( pasajero ) )
		{
			JOptionPane.showMessageDialog( this, "El pasajero no ten�a silla asignada", "Anulaci�n", JOptionPane.ERROR_MESSAGE );
			return;
		}

		actualizar( );
	}

	/**
	 * Muestra el porcentaje de ocupaci�n que tiene el avi�n
	 */
	public void mostrarPorcentajeOcupacion( )
	{
		double porcentaje;
		porcentaje = avion.calcularPorcentajeOcupacion( );
		DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
		df.applyPattern( "###.##" );
		JOptionPane.showMessageDialog( this, "El porcentaje de ocupaci�n es " + df.format( porcentaje ) + "%", "Ocupaci�n del avi�n", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * Procesa la b�squeda de un pasajero
	 */
	public void buscarPasajero( )
	{
		// Pregunta el numero de c�dula
		int cedula;
		String sCedula = JOptionPane.showInputDialog( this, "Ingrese el n�mero de c�dula" );
		try
		{
			cedula = Integer.parseInt( sCedula );
		}
		catch( NumberFormatException e )
		{
			JOptionPane.showMessageDialog( this, "Error en el n�mero de c�dula.", "Anulaci�n", JOptionPane.ERROR_MESSAGE );
			return;
		}
		Pasajero pasajero = new Pasajero( cedula, "no importa" );

		Silla silla = avion.buscarPasajero( pasajero );

		if( silla != null )
		{
			VentanaDatosPasajero vDatos = new VentanaDatosPasajero( silla );
			vDatos.setLocation( calculaPosicionCentral( this, vDatos ) );
			vDatos.setVisible( true );

		}
		else
		{
			JOptionPane.showMessageDialog( this, "El pasajero no se encuentra registrado", "B�squeda registro", JOptionPane.INFORMATION_MESSAGE );
			return;
		}
	}

	/**
	 * M�todo 1 de extensi�n para el ejemplo
	 */
	public void reqFuncOpcion1( )
	{
		String respuesta = avion.metodo1( );
		JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * M�todo 2 de extensi�n para el ejemplo
	 */
	public void reqFuncOpcion2( )
	{
		String respuesta = avion.metodo2( );
		JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * Repinta la gr�fica del avi�n
	 */
	public void actualizar( )
	{
		remove( panelAvion );

		//Panel del avi�n
		panelAvion = new PanelAvion( avion );
		add( panelAvion, BorderLayout.CENTER );
		validate( );
	}

	/**
	 * Calcula el punto central entre dos componentes
	 * @param componentePadre - Componente padre sobre el que se calcula el centro - componentePadre != null
	 * @param componenteHijo - Componente hijo que se centra sobre el padre - componenteHijo != null
	 * @return Punto central para ubicar al componente hijo
	 */
	private Point calculaPosicionCentral( Component componentePadre, Component componenteHijo )
	{

		//Centra la ventana y asegura que no sea mayor que la resoluci�n actual
		Dimension tamanhoPantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
		int maxY = tamanhoPantalla.height;
		int minY = 0;

		//Tama�o de la resoluci�n de la pantalla
		Dimension tamanhoPadre = componentePadre.getSize( );
		Point locacionPadre = componentePadre.getLocation( );
		Dimension tamanhoHijo = componenteHijo.getSize( );
		int x = ( tamanhoPadre.width - tamanhoHijo.width ) / 2 + locacionPadre.x;
		int y = ( tamanhoPadre.height - tamanhoHijo.height ) / 2 + locacionPadre.y;

		// Ajuste para abajo
		if( y + tamanhoHijo.height > maxY )
		{
			y = maxY - tamanhoHijo.height;
		}

		// Ajuste para arriba
		if( y < minY )
		{
			y = 0;
		}
		return new Point( x, y );
	}

	/**
	 * M�todo principal de ejecuci�n
	 * @param args - argumentos de ejecuci�n - no requiere.
	 */
	public static void main( String[] args )
	{
		InterfazAvion interfaz = new InterfazAvion( );
		interfaz.setVisible( true );
	}

	/**
	 * Agrega una pel�cula a un pasajero.
	 */
	public void agregarPelicula(int cedula, String nombre, String genero, int duracion, String director) 
	{
		Silla silla = avion.buscarPasajero(new Pasajero(cedula, "no importa"));
		if(silla!=null)
		{
			silla.darPasajero().agregarPelicula(nombre, genero, duracion, director);
			JOptionPane.showMessageDialog( this, "La pel�cula fue agregada exitosamente.", "Agregar pel�cula", JOptionPane.INFORMATION_MESSAGE );
		}
		else
		{
			JOptionPane.showMessageDialog( this, "No existe pasajero con la c�dula dada", "Buscar pel�culas", JOptionPane.INFORMATION_MESSAGE );
		}
	}

	/**
	 * Muestra el di�logo para agregar una pel�cula.
	 */
	public void mostrarDialogoAgregarPelicula()
	{
		DialogoAgregarPelicula dialogo = new DialogoAgregarPelicula(this);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
	}

	/**
	 * Buscar las pel�culas de un pasajero.
	 */
	public void buscarPeliculas() 
	{
		String cedula = JOptionPane.showInputDialog(this, "Ingrese la c�dula del pasajero:","C�dula pasajero", JOptionPane.QUESTION_MESSAGE);
		try{
			int ced = Integer.parseInt(cedula);
			Silla silla = avion.buscarPasajero(new Pasajero(ced, "no importa"));
			if(silla!=null)
			{
				ArrayList lista=silla.darPasajero().darPeliculas();
				String rta="Las pel�culas vistas por el pasajero son:\n";
				for (int i = 0; i < lista.size(); i++) 
				{
					Pelicula act= (Pelicula) lista.get(i);
					rta+=act.toString();
					rta+="\n";
				}
				if(lista.size()==0)
				{
					rta="El pasajero no tiene pel�culas.";
				}
				JOptionPane.showMessageDialog(this, rta,"Pel�culas pasajero", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog( this, "No existe pasajero con la c�dula dada", "Buscar pel�culas", JOptionPane.INFORMATION_MESSAGE );
			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this,"Debe ingresar un valor v�lido para la c�dula.","Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Calcula la duraci�n total de las pel�culas de todos los pasajeros del avi�n.
	 */
	public void duracionTotalPeliculas() 
	{
		int cuanto = avion.darDuracionTotalPeliculas();
		String rta = "La duraci�n total de las pel�culas en el avi�n es: " + cuanto + " minutos.";
		JOptionPane.showMessageDialog(this, rta, "Duraci�n total pel�culas", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Muestra el di�logo que da todas las pel�culas de un g�nero para un pasajero determinado.
	 */
	public void mostrarDialogoPeliculasGenero() 
	{
		DialogoPeliculasGenero dialogo = new DialogoPeliculasGenero(this);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
	}

	/**
	 * Muestra en un di�logo las pel�culas que pertenecen a un determiando g�nero y son de alg�n pasajero determinado por par�metro.
	 * @param cedula C�dula del pasajero.
	 * @param genero G�nero al cual pertenece la pel�cula.
	 */
	public void peliculasGenero(int cedula, String genero)
	{
		Silla silla = avion.buscarPasajero(new Pasajero(cedula, "no importa"));
		if(silla!=null)
		{
			ArrayList lista = silla.darPasajero().darPeliculasGenero(genero);
			String rta="Las pel�culas vistas por el pasajero son:\n";
			for (int i = 0; i < lista.size(); i++) 
			{
				Pelicula act= (Pelicula) lista.get(i);
				rta+=act.toString();
				rta+="\n";
			}
			if(lista.size()==0)
			{
				rta="El pasajero no tiene pel�culas.";
			}
			JOptionPane.showMessageDialog(this, rta,"Pel�culas pasajero", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else
		{
			JOptionPane.showMessageDialog(this,"No existe un pasajero con esa c�dula.","Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}

	/**
	 * Determina si un pasajero espec�fico tiene dos pel�culas con la misma duraci�n.
	 */
	public void peliculasMismaDuracion() 
	{
		String cedula = JOptionPane.showInputDialog(this, "Ingrese la c�dula del pasajero:","C�dula pasajero", JOptionPane.QUESTION_MESSAGE);
		try
		{
			int ced = Integer.parseInt(cedula);
			Silla silla = avion.buscarPasajero(new Pasajero(ced, "no importa"));
			if(silla!=null)
			{
				boolean tiene =silla.darPasajero().tienePeliculasMismaDuracion();
				
				String rta="";
				if(tiene == true)
				{
					rta= "El pasajero tiene pel�culas con la misma duraci�n.";
				}
				else
				{
					rta= "El pasajero no tiene pel�culas con la misma duraci�n.";
				}
				JOptionPane.showMessageDialog(this, rta, "Pel�culas de misma duraci�n", JOptionPane.INFORMATION_MESSAGE);

			}
			else
			{
				JOptionPane.showMessageDialog(this,"No existe un pasajero con esa c�dula.","Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this,"Debe ingresar un valor v�lido para la c�dula.","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}