package uniandes.nivelatorios.ordenamientoInsercion.interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelBotones extends JPanel implements ActionListener{

	private static final String ALEATORIO = "ALEATORIO";
	private static final String ORDENAR = "ORDENAR";
	
	private JButton btnAleatorio;
	
	private JButton btnOrdenar;
	
	InterfazOrdenamientoBurbuja interfaz;
	
	public PanelBotones(InterfazOrdenamientoBurbuja nInterfaz)
	{
		interfaz = nInterfaz;
		
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		
		btnAleatorio = new JButton("Nuevos Estudiantes");
		btnAleatorio.addActionListener(this);
		btnAleatorio.setActionCommand(ALEATORIO);
		btnAleatorio.setBackground(Color.WHITE);
		//btnAleatorio.setBorder(new LineBorder(Color.WHITE, 1));
		btnAleatorio.setForeground(Color.BLACK);
		btnAleatorio.setMargin(new Insets(10,10,10,10));
		add(btnAleatorio);
		
		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.addActionListener(this);
		btnOrdenar.setActionCommand(ORDENAR);
		btnOrdenar.setBackground(Color.WHITE);
		//btnOrdenar.setBorder(new LineBorder(Color.WHITE, 1));
		btnOrdenar.setForeground(Color.BLACK);
		btnOrdenar.setMargin(new Insets(10,10,10,10));
		add(btnOrdenar);
	}

	public void desahibilitarOrdenamiento()
	{
		btnOrdenar.setEnabled(false);
	}
	


	@Override
	public void actionPerformed(ActionEvent a) {
		
		if(a.getActionCommand().equals(ALEATORIO))
		{
			interfaz.nuevosEstudiantes();
			btnOrdenar.setEnabled(true);
		}
		else if(a.getActionCommand().equals(ORDENAR))
			interfaz.ordenarEstudiantes();
		
	}
	
}
