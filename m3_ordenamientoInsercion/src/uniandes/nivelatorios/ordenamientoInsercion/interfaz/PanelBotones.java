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
	
	InterfazOrdenamientoInsercion interfaz;
	
	public PanelBotones(InterfazOrdenamientoInsercion nInterfaz)
	{
		interfaz = nInterfaz;
		
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		
		btnAleatorio = new JButton("Nuevas Cartas");
		btnAleatorio.addActionListener(this);
		btnAleatorio.setActionCommand(ALEATORIO);
		btnAleatorio.setBackground(new Color(0, 100, 0));
		//btnAleatorio.setBorder(new LineBorder(Color.WHITE, 1));
		btnAleatorio.setForeground(Color.WHITE);
		btnAleatorio.setMargin(new Insets(10,10,10,10));
		add(btnAleatorio);
		
		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.addActionListener(this);
		btnOrdenar.setActionCommand(ORDENAR);
		btnOrdenar.setBackground(new Color(0, 100, 0));
		//btnOrdenar.setBorder(new LineBorder(Color.WHITE, 1));
		btnOrdenar.setForeground(Color.WHITE);
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
			interfaz.nuevasCartas();
			btnOrdenar.setEnabled(true);
		}
		else if(a.getActionCommand().equals(ORDENAR))
			interfaz.ordenarCartas();
		
	}
	
}
