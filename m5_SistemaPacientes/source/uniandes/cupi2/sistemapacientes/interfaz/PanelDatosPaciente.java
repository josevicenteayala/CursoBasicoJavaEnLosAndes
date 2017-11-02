package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelDatosPaciente extends JPanel implements ActionListener{

	private static final String CADENA_VACIA = "";

	private static final String TITULO_DATOS_DEL_PACIENTE = "Datos del paciente";
	
	/**
	 * El comando para el boton de calcular la edad del paciente
	 */
	private final static String CALCULAR_EDAD = "CALCULAR EDAD";
	
	/**
	 * Serial del panel
	 */
	private static final long serialVersionUID = -8782638591012119889L;
	private InterfazSistemaPacientes interfazSistemaPacientes;
	
	//Etiqueta y zona de texto para el nombre
	private JLabel labNombre;
	private JTextField txtNombre;
	
	//Etiqueta y zona de texto para el apellido
	private JLabel labApellido;
	private JTextField txtApellido;
	
	//Etiqueta y zona de texto para el sexo
	private JLabel labSexo;
	private JTextField txtSexo;
	
	//Etiqueta donde se muestra la imagen
	private JLabel labImagen;
	
	//Boton para calcular la edad
	private JButton butEdad;
	
	//Zona de texto donde se muestra la edad
	private JTextField txtEdad;
	
	//Etiqueta con la fecha de nacimiento
	private JLabel labFNacimiento;
	private JTextField txtFNacimiento;
	
	
	/**
	 * Constructor del panel
	 */
	public PanelDatosPaciente(InterfazSistemaPacientes interfazSistemaPacientes) {
		this.interfazSistemaPacientes = interfazSistemaPacientes;
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder(TITULO_DATOS_DEL_PACIENTE);
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		//Panel donde se muestra la foto del paciente
		JPanel panelFoto = new JPanel();
		
		//Panel donde se muestra la informacion del paciente
		JPanel panelInformacion = new JPanel();
		
		panelFoto = new JPanel();
		add(panelFoto, BorderLayout.EAST);
		
		panelInformacion = new JPanel();
		add(panelInformacion, BorderLayout.CENTER);
		
		//Creacion de todas las etiqueras 
		labNombre = new JLabel("Nombre: ");
		labApellido = new JLabel("Apellido: ");
		labSexo = new JLabel("Sexo: ");
		labFNacimiento = new JLabel("Fecha de Nacimiento: ");
		
		//Creacion y configuracion de la zona de texto para el nombre
		txtNombre = new JTextField(15);
		txtNombre.setEditable(false);
		txtNombre.setBackground(Color.LIGHT_GRAY);
		txtNombre.setForeground(Color.BLUE);
		
		//Creacion y configuracion de la zona de texto para el apellido
		txtApellido = new JTextField(15);
		txtApellido.setEditable(false);
		txtApellido.setBackground(Color.LIGHT_GRAY);
		txtApellido.setForeground(Color.BLUE);
		
		//Creacion y configuracion de la zona de texto para el sexo
		txtSexo= new JTextField(2);
		txtSexo.setEditable(false);
		txtSexo.setBackground(Color.LIGHT_GRAY);
		txtSexo.setForeground(Color.BLUE);	
		
		//Creacion y configuracion de la fecha de nacimiento
		txtFNacimiento= new JTextField(10);
		txtFNacimiento.setEditable(false);
		txtFNacimiento.setBackground(Color.LIGHT_GRAY);
		txtFNacimiento.setForeground(Color.BLUE);	
		
		//Creacion y configuracion del boton y la zona de texto para la edad
		butEdad = new JButton("Calcular Edad");
		butEdad.setActionCommand(CALCULAR_EDAD);
		butEdad.addActionListener(this);
		
		txtEdad = new JTextField(10);
		txtEdad.setEditable(false);
		
		panelInformacion.setLayout(new GridLayout(6,2));
		panelInformacion.add(labNombre);
		panelInformacion.add(txtNombre);
		panelInformacion.add(labApellido);
		panelInformacion.add(txtApellido);
		panelInformacion.add(labSexo);
		panelInformacion.add(txtSexo);
		panelInformacion.add(labFNacimiento);
		panelInformacion.add(txtFNacimiento);
		panelInformacion.add(butEdad);
		panelInformacion.add(txtEdad);
		
		labImagen = new JLabel("FOTO");
		panelFoto.add(labImagen);
	}
	
	/**
	 * Muestra la edad del paciente
	 * @param edadPaciente
	 */
	public void mostrarEdad(String edadPaciente) {
		txtEdad.setText(edadPaciente);
	}
	/**
	 * @return la edad del paciente
	 */
	public String darEdad() {
		return txtEdad.getText();
	}
	
	public void limpieaCampos() {
		txtEdad.setText(CADENA_VACIA);
	}
	
	/**
	 * Actualiza los campos del panel con la informacion del paciente
	 * @param nombre
	 * @param apellido
	 * @param sexo
	 * @param fechaNacimiento
	 * @param imagen
	 */
	public void actualizarCampos(String nombre, String apellido, String sexo, String fechaNacimiento, String imagen) {
		txtNombre.setText(nombre);
		txtApellido.setText(apellido);
		txtSexo.setText(sexo);
		txtFNacimiento.setText(fechaNacimiento);
		labImagen.setIcon(new ImageIcon(imagen));
		txtEdad.setText(CADENA_VACIA);
	}
	
	/**
	 * @param interfazSistemaPacientes
	 */
	public PanelDatosPaciente(JFrame interfazSistemaPacientes) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventoRealizado = e.getActionCommand();
		if(CALCULAR_EDAD.equals(eventoRealizado)) {
			interfazSistemaPacientes.calcularEdad();
		}
	}
}
