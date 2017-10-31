package uniandes.nivelatorios.ordenamientoInsercion.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import uniandes.nivelatorios.ordenamientoInsercion.mundo.Estudiante;

public class PanelEstudiantes extends JPanel{
	
	private static final int alturaCarta = 98;
	private static final int anchoCarta = 74;
	
	private JLabel estudiante1;
	private JLabel estudiante2;
	private JLabel estudiante3;
	private JLabel estudiante4;
	private JLabel estudiante5;
	private JLabel estudiante6;
	
	private JLabel estudiante1Img;
	private JLabel estudiante2Img;
	private JLabel estudiante3Img;
	private JLabel estudiante4Img;
	private JLabel estudiante5Img;
	private JLabel estudiante6Img;
	
	private JPanel panelImagenes;
	private JPanel panelCarnets;
	
	private ImageIcon hombre;
	private ImageIcon mujer;
	
	public PanelEstudiantes()
	{
		setLayout(new BorderLayout());
		
		panelImagenes = new JPanel();
		panelImagenes.setBackground(Color.WHITE);
		panelCarnets = new JPanel();
		panelCarnets.setBackground(Color.WHITE);
		
		hombre = new ImageIcon("data/hombre.png");
		mujer = new ImageIcon("data/mujer.png");
		
		GridLayout layout = new GridLayout(1,6);
		
		//setLayout(layout);
		
		panelImagenes.setLayout(layout);
		add(panelImagenes, BorderLayout.NORTH);
		add(panelCarnets, BorderLayout.SOUTH);
		
		panelCarnets.setLayout(layout);
		
		
		estudiante1 = new JLabel("",SwingConstants.CENTER);
		estudiante1.setBorder(new LineBorder(Color.BLACK));
		estudiante2 = new JLabel("",SwingConstants.CENTER);
		estudiante2.setBorder(new LineBorder(Color.BLACK));
		estudiante3 = new JLabel("",SwingConstants.CENTER);
		estudiante3.setBorder(new LineBorder(Color.BLACK));
		estudiante4 = new JLabel("",SwingConstants.CENTER);
		estudiante4.setBorder(new LineBorder(Color.BLACK));
		estudiante5 = new JLabel("",SwingConstants.CENTER);
		estudiante5.setBorder(new LineBorder(Color.BLACK));
		estudiante6 = new JLabel("",SwingConstants.CENTER);
		estudiante6.setBorder(new LineBorder(Color.BLACK));
		
		estudiante1Img = new JLabel("",SwingConstants.CENTER);
		estudiante2Img = new JLabel("",SwingConstants.CENTER);
		estudiante3Img = new JLabel("",SwingConstants.CENTER);
		estudiante4Img = new JLabel("",SwingConstants.CENTER);
		estudiante5Img = new JLabel("",SwingConstants.CENTER);
		estudiante6Img = new JLabel("",SwingConstants.CENTER);
		
		
		panelCarnets.add(estudiante1);
		panelCarnets.add(estudiante2);
		panelCarnets.add(estudiante3);
		panelCarnets.add(estudiante4);
		panelCarnets.add(estudiante5);
		panelCarnets.add(estudiante6);
		
		panelImagenes.add(estudiante1Img);
		panelImagenes.add(estudiante2Img);
		panelImagenes.add(estudiante3Img);
		panelImagenes.add(estudiante4Img);
		panelImagenes.add(estudiante5Img);
		panelImagenes.add(estudiante6Img);
		
		
	}

	public void mostrarEstudiantes(Estudiante[] estudiantes)
	{
		estudiante1.setText("<html><u> Nombre</u>: " +estudiantes[0].darCarnet().darNombre()+"<br> <u>Código</u>: "+estudiantes[0].darCarnet().darCodigo()+"</html");
		estudiante2.setText("<html><u> Nombre</u>: " +estudiantes[1].darCarnet().darNombre()+"<br> <u>Código</u>: "+estudiantes[1].darCarnet().darCodigo()+"</html");
		estudiante3.setText("<html><u> Nombre</u>: " +estudiantes[2].darCarnet().darNombre()+"<br> <u>Código</u>: "+estudiantes[2].darCarnet().darCodigo()+"</html");
		estudiante4.setText("<html><u> Nombre</u>: " +estudiantes[3].darCarnet().darNombre()+"<br> <u>Código</u>: "+estudiantes[3].darCarnet().darCodigo()+"</html");
		estudiante5.setText("<html><u> Nombre</u>: " +estudiantes[4].darCarnet().darNombre()+"<br> <u>Código</u>: "+estudiantes[4].darCarnet().darCodigo()+"</html");
		estudiante6.setText("<html><u> Nombre</u>: " +estudiantes[5].darCarnet().darNombre()+"<br> <u>Código</u>: "+estudiantes[5].darCarnet().darCodigo()+"</html");
		
		if(estudiantes[0].darSexo() == 'f')
			estudiante1Img.setIcon(mujer);
		else
			estudiante1Img.setIcon(hombre);
		
		if(estudiantes[1].darSexo() == 'f')
			estudiante2Img.setIcon(mujer);
		else
			estudiante2Img.setIcon(hombre);
		
		if(estudiantes[2].darSexo() == 'f')
			estudiante3Img.setIcon(mujer);
		else
			estudiante3Img.setIcon(hombre);
		
		if(estudiantes[3].darSexo() == 'f')
			estudiante4Img.setIcon(mujer);
		else
			estudiante4Img.setIcon(hombre);
		
		if(estudiantes[4].darSexo() == 'f')
			estudiante5Img.setIcon(mujer);
		else
			estudiante5Img.setIcon(hombre);
		
		if(estudiantes[5].darSexo() == 'f')
			estudiante6Img.setIcon(mujer);
		else
			estudiante6Img.setIcon(hombre);
	}


}
