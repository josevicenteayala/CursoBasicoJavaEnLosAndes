package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelDatosPaciente extends JPanel {

	private static final String TITULO_DATOS_DEL_PACIENTE = "Datos del paciente";
	/**
	 * Serial del panel
	 */
	private static final long serialVersionUID = -8782638591012119889L;

	public PanelDatosPaciente() {
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder(TITULO_DATOS_DEL_PACIENTE);
		border.setTitleColor(Color.BLUE);
		setBorder(border);
	}
	
	/**
	 * @param interfazSistemaPacientes
	 */
	public PanelDatosPaciente(JFrame interfazSistemaPacientes) {
		
	}
}
