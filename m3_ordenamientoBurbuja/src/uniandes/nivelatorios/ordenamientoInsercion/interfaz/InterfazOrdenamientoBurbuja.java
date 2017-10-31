package uniandes.nivelatorios.ordenamientoInsercion.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import uniandes.nivelatorios.ordenamientoInsercion.mundo.OrdenadorBurbuja;

public class InterfazOrdenamientoBurbuja extends JFrame {
	
	private OrdenadorBurbuja ordenador;
	
	private PanelBotones panelBotones;
	
	private PanelEstudiantes panelEstudiantes;
	
	public InterfazOrdenamientoBurbuja()
	{
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setPreferredSize(new Dimension(700,200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ordenamiento por Inserción");
		
		panelEstudiantes = new PanelEstudiantes();
		panelEstudiantes.setBackground(Color.WHITE);
		getContentPane().add(panelEstudiantes, BorderLayout.CENTER);
		
		panelBotones = new PanelBotones(this);
		panelBotones.setBackground(Color.WHITE);
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		pack();
		
		ordenador = new OrdenadorBurbuja();
		ordenador.elegirEstudiantesAleatoriamente();
		panelEstudiantes.mostrarEstudiantes(ordenador.darEstudiantes());
		
		
	}
	
	public void nuevosEstudiantes()
	{
		ordenador.elegirEstudiantesAleatoriamente();
		panelEstudiantes.mostrarEstudiantes(ordenador.darEstudiantes());
		
	}
	
	 public static void main( String[] args )
	    {

	        InterfazOrdenamientoBurbuja interfaz = new InterfazOrdenamientoBurbuja( );
	        interfaz.setVisible( true );
	    }

	public void ordenarEstudiantes() {
		ordenador.ordenarEstudiantesPorBurbuja();
		panelEstudiantes.mostrarEstudiantes(ordenador.darEstudiantes());
		panelBotones.desahibilitarOrdenamiento();
	}

}
