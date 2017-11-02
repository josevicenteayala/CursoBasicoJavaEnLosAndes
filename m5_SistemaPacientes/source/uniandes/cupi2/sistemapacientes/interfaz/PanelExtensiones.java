package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelExtensiones extends JPanel {

	private static final String TITULO_PUNTOS_DE_EXTENSION = "Puntos de Extensión";
	/**
	 * Serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	
	public PanelExtensiones() {
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder(TITULO_PUNTOS_DE_EXTENSION);
		border.setTitleColor(Color.BLUE);
		setBorder(border);
	}
	
	/**
	 * @param interfazSistemaPacientes
	 */
	public PanelExtensiones(JFrame interfazSistemaPacientes) {
		
	}

}
