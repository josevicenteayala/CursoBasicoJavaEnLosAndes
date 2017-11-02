package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import uniandes.cupi2.sistemapacientes.mundo.SistemaPacientes;

public class InterfazSistemaPacientes extends JFrame {

	public static final String TITULO_SISTEMA_DE_PACIENTES = "Sistema de Pacientes";

	/**
	 * Serial de la clase
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Clase principal del mundo
	 */
	private SistemaPacientes sistemaPacientes;
	
	/**
	 * Es el panel que contiene los datos del paciente
	 */
	private PanelDatosPaciente panelDatosPaciente;
	
	/**
	 * Es el panel que contiene los elementos para realizar consultas sobre paciente
	 */
	private PanelDatosMuestra panelDatosMuestra;
	
	/**
	 * El el panel que contiene los elementos para ejecutar las extensiones y la navegacion
	 */
	private PanelExtensiones panelExtensiones;
	
	/**
	 * Construye una nueva interfaz de usuario, iniciandola con los datos del sistema de pacientes
	 */
	public InterfazSistemaPacientes() {
		setTitle(TITULO_SISTEMA_DE_PACIENTES);
		setSize(700,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		//Crea la clase principal
		sistemaPacientes = new SistemaPacientes();
		
		panelDatosPaciente = new PanelDatosPaciente();
		panelDatosMuestra = new PanelDatosMuestra();
		panelExtensiones = new PanelExtensiones();
		
		add(panelDatosPaciente, BorderLayout.NORTH);
		add(panelDatosMuestra, BorderLayout.CENTER);
		add(panelExtensiones, BorderLayout.SOUTH);
	}
	
	
	/**
	 * este metodo ejecuta la aplicacion, creando una ventana  de interfaz e iniciandola
	 * @param args Los argumentos no son utilizados
	 * 
	 * */
	
	public static void main(String[] args) {
		InterfazSistemaPacientes interfazSistemaPacientes = new InterfazSistemaPacientes();
		interfazSistemaPacientes.setVisible(true);
	}

}
