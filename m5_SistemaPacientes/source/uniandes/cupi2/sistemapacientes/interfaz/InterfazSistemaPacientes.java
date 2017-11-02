package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.sistemapacientes.mundo.Paciente;
import uniandes.cupi2.sistemapacientes.mundo.SistemaPacientes;

public class InterfazSistemaPacientes extends JFrame {

	private static final String EXPRESION_VALIDAR_NUMEROS = "[0123456789.]*";

	private static final String CADENA_VACIA = "";

	private static final int CODIGO_SEXO_MASCULINO = 2;

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
		
		panelDatosPaciente = new PanelDatosPaciente(this);
		panelDatosMuestra = new PanelDatosMuestra(this);
		panelExtensiones = new PanelExtensiones(this);
		
		add(panelDatosPaciente, BorderLayout.NORTH);
		add(panelDatosMuestra, BorderLayout.CENTER);
		add(panelExtensiones, BorderLayout.SOUTH);
		
		sistemaPacientes = new SistemaPacientes();
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
	
	
	/**
	 * Actualzia la informacion del paciente dado por parametro
	 * @param paciente del cual se mostran los datos
	 */
	public void actualizarInformacion(Paciente paciente) {
		String sexo = "F";
		if(paciente.darSexo() == CODIGO_SEXO_MASCULINO) {
			sexo = "M";
		}
		
		panelDatosPaciente.actualizarCampos(paciente.darNombre(), paciente.darApellido(), sexo, paciente.darFechaNacimiento(), paciente.darImagen());
		panelDatosMuestra.actualizarCampos(paciente.darFechaTomaMuestra(), paciente.darEnAyunas(), paciente.darVolumenMuestra(), paciente.darVolumenEritrocitos(), paciente.darConteoLeucocitos(), paciente.darConteoPlaquetas());
		panelDatosMuestra.limpiarCampos();
	}


	/**
	 * Permite cacular el valor de hematocrito del paciente
	 */
	public void calcularHematocrito() {
		String pVolumenMuestra = panelDatosMuestra.darVolumenMuestra();
		String pVolumenEritrocitos = panelDatosMuestra.darVolumenEritrocitos();
		
		if(pVolumenMuestra.trim().equals(CADENA_VACIA) || pVolumenEritrocitos.trim().equals(CADENA_VACIA)) {
			JOptionPane.showMessageDialog(this, "Debe ingresar los datos.", "Calcular Hmeatocrito", JOptionPane.ERROR_MESSAGE);
		}else if(pVolumenMuestra.trim().matches(EXPRESION_VALIDAR_NUMEROS) && pVolumenEritrocitos.trim().matches(EXPRESION_VALIDAR_NUMEROS)) {
			double volumenMuestra = Double.parseDouble(pVolumenMuestra.trim());
			double volumenEritrocitos = Double.parseDouble(pVolumenEritrocitos.trim());
			
			Paciente pacienteActual = sistemaPacientes.darPacienteActual();
			pacienteActual.cambiarVolumenMuestra(volumenMuestra);
			pacienteActual.cambiarVolumenEritrocitos(volumenEritrocitos);
			double hematocrito = pacienteActual.calcularHematocrito();
			hematocrito = Math.round(hematocrito * 100.0) / 100.0;
			panelDatosMuestra.mostrarHematocrito(String.valueOf(hematocrito));
		}else {
			JOptionPane.showMessageDialog(this, "Los datos ingresados no son correctos.", "Calcular Hmeatocrito", JOptionPane.ERROR_MESSAGE);
		}
	}


	public void calcularLeucocito() {
		String pVolumenMuestra = panelDatosMuestra.darVolumenMuestra();
		String pVolumenEritrocitos = panelDatosMuestra.darVolumenEritrocitos();
		
		if(pVolumenMuestra.trim().equals(CADENA_VACIA) || pVolumenEritrocitos.trim().equals(CADENA_VACIA)) {
			JOptionPane.showMessageDialog(this, "Debe ingresar los datos.", "Calcular Leucocito", JOptionPane.ERROR_MESSAGE);
		}else if(pVolumenMuestra.trim().matches(EXPRESION_VALIDAR_NUMEROS) && pVolumenEritrocitos.trim().matches(EXPRESION_VALIDAR_NUMEROS)) {
			double volumenMuestra = Double.parseDouble(pVolumenMuestra.trim());
			double volumenEritrocitos = Double.parseDouble(pVolumenEritrocitos.trim());
			
			Paciente pacienteActual = sistemaPacientes.darPacienteActual();
			pacienteActual.cambiarVolumenMuestra(volumenMuestra);
			pacienteActual.cambiarVolumenEritrocitos(volumenEritrocitos);
			double leucocito = pacienteActual.calcularLeucocitos();
			leucocito = Math.round(leucocito * 100.0) / 100.0;
			panelDatosMuestra.mostrarLeucocito(String.valueOf(leucocito));
		}else {
			JOptionPane.showMessageDialog(this, "Los datos ingresados no son correctos.", "Calcular Leucocito", JOptionPane.ERROR_MESSAGE);
		}		
	}


	/**
	 * Muestra un mensaje indicando si la muestra esta en ayunas o no dependiendo de la seleccion o deseleccion que haya hecho el usuario en el panel de los datos de la muestra
	 */
	public void cambiarEnAyunas() {
		if(panelDatosMuestra.estaEnAyunas()) {
			JOptionPane.showMessageDialog(this, "En ayunas.", "Estado", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "No en ayunas.", "Estado", JOptionPane.INFORMATION_MESSAGE);
		}
	}


	public void calcularEdad() {
		Paciente pacienteActual = sistemaPacientes.darPacienteActual();
		pacienteActual.darEdad();
		panelDatosPaciente.mostrarEdad(String.valueOf(pacienteActual.darEdad()));
	}


	/**
	 * Muestra la informacion del pasiente anterior al actual
	 */
	public void retroceder() {
		Paciente pacienteActual = sistemaPacientes.darPacienteAnterior();
		actualizarInformacion(pacienteActual);		
	}


	/**
	 * Muestra la informacion del pasiente que sigue
	 */
	public void avanzar() {
		Paciente pacienteActual = sistemaPacientes.darPacienteSiguiente();
		actualizarInformacion(pacienteActual);
	}


	/**
	 * Metodo para la extension 1
	 */
	public void regFuncOpcion1() {
		JOptionPane.showMessageDialog(this, sistemaPacientes.metodo1(), "Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}


	/**
	 * Metodo para la extension 2
	 */
	public void reqFuncOpcion2() {
		JOptionPane.showMessageDialog(this, sistemaPacientes.metodo2(), "Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}

}
