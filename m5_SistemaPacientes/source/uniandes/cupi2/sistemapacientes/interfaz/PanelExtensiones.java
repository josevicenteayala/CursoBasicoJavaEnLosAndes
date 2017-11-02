package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelExtensiones extends JPanel implements ActionListener{

	private static final String TITULO_PUNTOS_DE_EXTENSION = "Puntos de Extensión";
	private InterfazSistemaPacientes interfazSistemaPacientes;
	private static final String AVANZAR = "AVANZAR";
	private static final String RETROCEDER = "RETROCEDER";
	private static final String OPCION_1 = "opcion1";
	private static final String OPCION_2 = "opcion2";
	
	/**
	 * Serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	
	//Boton para avanzar al siguiente paciente
	private JButton btnAvanzar;
	//Boton para retroceder alpaceinte anterior
	private JButton btnRetroceder;
	//Boton para la extension 1
	private JButton btnOpcion1;
	//Boton para la extension 2
	private JButton btnOpcion2;
	
	public PanelExtensiones(InterfazSistemaPacientes interfazSistemaPacientes) {
		this.interfazSistemaPacientes = interfazSistemaPacientes;
		setLayout(new FlowLayout());
		TitledBorder border = BorderFactory.createTitledBorder(TITULO_PUNTOS_DE_EXTENSION);
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		//Configuracion de los botones
		btnAvanzar = new JButton(">");
		btnAvanzar.setActionCommand(AVANZAR);
		btnAvanzar.addActionListener(this);
		
		btnRetroceder = new JButton("<");
		btnRetroceder.setActionCommand(RETROCEDER);
		btnRetroceder.addActionListener(this);
		
		btnOpcion1 = new JButton("Opción 1");
		btnOpcion1.setActionCommand(OPCION_1);
		btnOpcion1.addActionListener(this);
		
		btnOpcion2 = new JButton("Opción 2");
		btnOpcion2.setActionCommand(OPCION_2);
		btnOpcion2.addActionListener(this);
		
		add(btnRetroceder);
		add(btnOpcion1);
		add(btnOpcion2);
		add(btnAvanzar);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventoRealizado = e.getActionCommand();
		if(RETROCEDER.equals(eventoRealizado)) {
			interfazSistemaPacientes.retroceder();
		}else if(AVANZAR.equals(eventoRealizado)) {
			interfazSistemaPacientes.avanzar();
		}else if(OPCION_1.equals(eventoRealizado)) {
			interfazSistemaPacientes.regFuncOpcion1();
		}else if(OPCION_2.equals(eventoRealizado)) {
			interfazSistemaPacientes.reqFuncOpcion2();
		}
		
	}

}
