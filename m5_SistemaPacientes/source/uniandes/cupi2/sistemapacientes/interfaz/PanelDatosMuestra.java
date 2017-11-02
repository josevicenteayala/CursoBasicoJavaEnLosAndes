package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelDatosMuestra extends JPanel implements ActionListener{

	private static final String CADENA_VACIA = "";
	private static final String TITULO_INFORMACION_MUESTRA = "Información muestra";
	
	/**
	 * Comando para el boton calcular hematocrito
	 */
	private static final String CALCULAR_HEMATOCRITO = "CALCULAR HEMATOCRITO";
	/**
	 * Comando para el boton calcular leucocitos
	 */
	private static final String CALCULAR_LEUCOCITOS = "CALCULAR LEUCOCITOS";
	
	private static final String AYUNAS = "En ayunas";
	
	/**
	 * serial aplicacion
	 */
	private static final long serialVersionUID = -4491513643878361622L;
	
	private InterfazSistemaPacientes interfazSistemaPacientes;
	
	//Etiqueta para la fecha de toma
	private JLabel labFTomaMuestra;
	//Zona de texto donde se ingresa la fecha de toma
	private JTextField txtFTomaMuestra;
	//Etiqueta para el volumen
	private JLabel labVolumenMuestra;
	//Zona de texto donde se ingresa el volumen
	private JTextField txtVolumenMuestra;
	//Etiqueta para el volumen de eritrocitos
	private JLabel labVolumenEritrocitos;
	//Zona para ingresar el volumen de eritrocitos
	private JTextField txtVolumenEritrocitos;
	//Etiqueta para el conteo de leucocitos
	private JLabel labConteoLeucocitos;
	//Zona para ingresar el conteo de leucocitos
	private JTextField txtConteoLeucocitos;
	//Etiqueta para el conteo de las plaquetas
	private JLabel labConteoPlaquetas;
	//Zona para ingresar el conteo de plaquetas
	private JTextField txtConteoPlaquetas;
	//caja de chequeo que indica si la muestra se tomo en ayunas
	private JCheckBox cbAyunas;
	//boton para ejecutar el calculo del hematocrito
	private JButton butHematocrito;
	//Zona para mostrar el calculo del hematocrito
	private JTextField txtHematocrito;
	//boton para ejecutar el calculo de leucocitos
	private JButton butLeucocitos;
	//Zona para mostrar el resultado del calculo de leucocitos
	private JTextField txtLeucocitos;
	
	
	
	public PanelDatosMuestra(InterfazSistemaPacientes interfazSistemaPacientes) {
		this.interfazSistemaPacientes = interfazSistemaPacientes;
		GridLayout gridLayout = new GridLayout(6,4);
		setLayout(gridLayout);
		TitledBorder border = BorderFactory.createTitledBorder(TITULO_INFORMACION_MUESTRA);
		border.setTitleColor(Color.BLUE);
		setBorder(border);	
		
		//Creacion de las etiquetas
		labFTomaMuestra = new JLabel("Fecha Toma Muestra: ");
		labVolumenMuestra = new JLabel("Volumen Muestra: ");
		labVolumenEritrocitos = new JLabel("Volumen Eritrocitos: ");
		labConteoLeucocitos = new JLabel("Conteo Leucocitos: ");
		labConteoPlaquetas = new JLabel("Conteo Plaquetas: ");
		
		
		//Creacion de los campos de texto
		txtFTomaMuestra = new JTextField();
		txtFTomaMuestra.setEnabled(false);
		txtFTomaMuestra.setBackground(Color.LIGHT_GRAY);
		txtFTomaMuestra.setForeground(Color.BLUE);
		
		txtConteoLeucocitos = new JTextField();
		txtConteoPlaquetas = new JTextField();
		txtHematocrito = new JTextField();
		txtLeucocitos = new JTextField();
		txtVolumenEritrocitos = new JTextField();
		txtVolumenMuestra = new JTextField();
		
		//creacion botones
		butHematocrito = new JButton("Calcular Hematocrito");
		butHematocrito.setActionCommand(CALCULAR_HEMATOCRITO);
		butHematocrito.addActionListener(this);
		
		butLeucocitos = new JButton("Calcular Leucocitos");
		butLeucocitos.setActionCommand(CALCULAR_LEUCOCITOS);
		butLeucocitos.addActionListener(this);
		
		//configuracion caja de chequeo
		cbAyunas = new JCheckBox("Ayunas");
		cbAyunas.setActionCommand(AYUNAS);
		cbAyunas.addActionListener(this);
		
		add(labFTomaMuestra);
		add(txtFTomaMuestra);
		add(new JLabel(CADENA_VACIA));
		add(cbAyunas);
		
		add(labVolumenMuestra);
		add(txtVolumenMuestra);
		add(new JLabel(CADENA_VACIA));
		add(new JLabel(CADENA_VACIA));
		
		add(labVolumenEritrocitos);
		add(txtVolumenEritrocitos);
		add(butHematocrito);
		add(txtHematocrito);
		
		add(labConteoLeucocitos);
		add(txtConteoLeucocitos);
		add(butLeucocitos);
		add(txtLeucocitos);
		
		add(labConteoPlaquetas);
		add(txtConteoPlaquetas);
		add(new JLabel(CADENA_VACIA));
		add(new JLabel(CADENA_VACIA));
		
		add(new JLabel(CADENA_VACIA));
		add(new JLabel(CADENA_VACIA));
		add(new JLabel(CADENA_VACIA));
		add(new JLabel(CADENA_VACIA));		
	}


	/**
	 * Envia a la pantalla el valor del hematocrito
	 * @param pHematocrito
	 */
	public void mostrarHematocrito(String pHematocrito) {
		txtHematocrito.setText(pHematocrito);
	}
	
	/**
	 * Muestra en pantalla si la ocion del examen es en ayunas
	 * @param pEnAyunas
	 */
	public void mostrarAyunas(String pEnAyunas) {
		cbAyunas.setText(pEnAyunas);
	}
	/**
	 * @return El volumen de la muestra
	 */
	public String darVolumenMuestra() {
		return txtLeucocitos.getText();
	}
	
	/**
	 * @return el conteo de leucocitos
	 */
	public String darConteoLeucocitos() {
		return txtConteoLeucocitos.getText();
	}
	
	/**
	 * @return el volumen de eritrocitos
	 */
	public String darVolumenEritrocitos() {
		return txtVolumenEritrocitos.getText();
	}
	
	/**
	 * @return el conteo de plaquetas
	 */
	public String darConteoPlaquetas() {
		return txtConteoPlaquetas.getText();
	}
	
	public boolean estaEnAyunas() {
		return cbAyunas.isSelected();
	}
	
	/**
	 * Muestra los leucocitos en la pantalla
	 * @param pLeucocito
	 */
	public void mostrarLeucocito(String pLeucocito) {
		txtLeucocitos.setText(pLeucocito);
	}
	
	/**
	 * Limpia los campos de texto del panel
	 */
	public void limpiarCampos() {
		txtHematocrito.setText(CADENA_VACIA);
		txtLeucocitos.setText(CADENA_VACIA);
	}
	
	/**
	 * Actualiza los campos del panel con la informacion que ingresa como parametro
	 * @param fechaMuestra
	 * @param enAyunas
	 * @param volumenMuestra
	 * @param volumenEritrocitos
	 * @param conteoLeucocitos
	 * @param conteoPlaquetas
	 */
	public void actualizarCampos(String fechaMuestra, boolean enAyunas, double volumenMuestra, double volumenEritrocitos, int conteoLeucocitos, int conteoPlaquetas) {
		txtFTomaMuestra.setText(fechaMuestra);
		txtVolumenMuestra.setText(String.valueOf(volumenMuestra));
		txtVolumenEritrocitos.setText(String.valueOf(volumenEritrocitos));
		txtConteoLeucocitos.setText(String.valueOf(conteoLeucocitos));
		txtConteoPlaquetas.setText(String.valueOf(conteoPlaquetas));
		cbAyunas.setSelected(enAyunas);
	}
	

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventoRealizado = e.getActionCommand();
		if(CALCULAR_HEMATOCRITO.equals(eventoRealizado)) {
			interfazSistemaPacientes.calcularHematocrito();
		}else if(CALCULAR_LEUCOCITOS.equals(eventoRealizado)) {
			interfazSistemaPacientes.calcularLeucocito();
		}else if(AYUNAS.equals(eventoRealizado)) {
			interfazSistemaPacientes.cambiarEnAyunas();
		}
		
	}

}
