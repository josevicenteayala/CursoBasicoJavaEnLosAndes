package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelDatosMuestra extends JPanel {

	private static final String TITULO_INFORMACION_MUESTRA = "Información muestra";
	/**
	 * serial aplicacion
	 */
	private static final long serialVersionUID = -4491513643878361622L;
	
	public PanelDatosMuestra() {
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder(TITULO_INFORMACION_MUESTRA);
		border.setTitleColor(Color.BLUE);
		setBorder(border);		
	}
	
	/**
	 * @param interfazsistemaPacientes
	 */
	public PanelDatosMuestra(JFrame interfazsistemaPacientes) {
	}

}
