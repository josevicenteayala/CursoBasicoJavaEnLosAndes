package uniandes.nivelatorios.ordenamientoInsercion.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import uniandes.nivelatorios.ordenamientoInsercion.mundo.OrdenadorInsercion;

public class InterfazOrdenamientoInsercion extends JFrame {
	
	private OrdenadorInsercion ordenador;
	
	private PanelBotones panelBotones;
	
	private PanelCartas panelCartas;
	
	public InterfazOrdenamientoInsercion()
	{
		getContentPane().setLayout(new BorderLayout());
		getContentPane().setPreferredSize(new Dimension(600,200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ordenamiento por Inserción");
		
		panelCartas = new PanelCartas();
		panelCartas.setBackground(new Color(0,100,0));
		getContentPane().add(panelCartas, BorderLayout.CENTER);
		
		panelBotones = new PanelBotones(this);
		panelBotones.setBackground(new Color(0,100,0));
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
		pack();
		
		ordenador = new OrdenadorInsercion();
		
		panelCartas.mostrarCartas(ordenador.darCartas());
		
		
	}
	
	public void nuevasCartas()
	{
		ordenador.elegirCartasAleatoriamente();
		panelCartas.mostrarCartas(ordenador.darCartas());
	}
	
	 public static void main( String[] args )
	    {

	        InterfazOrdenamientoInsercion interfaz = new InterfazOrdenamientoInsercion( );
	        interfaz.setVisible( true );
	    }

	public void ordenarCartas() {
		ordenador.ordenarCartasPorInsercion();
		panelCartas.mostrarCartas(ordenador.darCartas());
		panelBotones.desahibilitarOrdenamiento();
	}

}
