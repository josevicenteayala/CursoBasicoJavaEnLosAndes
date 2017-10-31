package uniandes.nivelatorios.ordenamientoInsercion.interfaz;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.nivelatorios.ordenamientoInsercion.mundo.Carta;

public class PanelCartas extends JPanel{
	
	private static final int alturaCarta = 98;
	private static final int anchoCarta = 74;
	
	private JLabel carta1;
	private JLabel carta2;
	private JLabel carta3;
	private JLabel carta4;
	private JLabel carta5;
	private JLabel carta6;
	
	private BufferedImage imgCartas;
	
	public PanelCartas()
	{
		FlowLayout layout = new FlowLayout();
		layout.setHgap(10);
		setLayout(layout);
		
		carta1 = new JLabel();
		carta2 = new JLabel();
		carta3 = new JLabel();
		carta4 = new JLabel();
		carta5 = new JLabel();
		carta6 = new JLabel();
		
		
		add(carta1);
		add(carta2);
		add(carta3);
		add(carta4);
		add(carta5);
		add(carta6);
		
		try {
			imgCartas = ImageIO.read(new File("data/Cartas.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


	public void mostrarCartas(Carta[] cartas) {
		
		carta1.setIcon(darImagenCarta(cartas[0]));
		carta2.setIcon(darImagenCarta(cartas[1]));
		carta3.setIcon(darImagenCarta(cartas[2]));
		carta4.setIcon(darImagenCarta(cartas[3]));
		carta5.setIcon(darImagenCarta(cartas[4]));
		carta6.setIcon(darImagenCarta(cartas[5]));
		
		/**
		carta1.setText(cartas[0].darValorCarta());
		carta2.setText(cartas[1].darValorCarta());
		carta3.setText(cartas[2].darValorCarta());
		carta4.setText(cartas[3].darValorCarta());
		carta5.setText(cartas[4].darValorCarta());
		carta6.setText(cartas[5].darValorCarta());
		
		*/
	}
	
	public ImageIcon darImagenCarta(Carta carta)
	{
		int xInicial, yInicial;
		
		int xVal = 97;
		
		if(carta.darPinta().equals("tréboles"))
			yInicial = 0;
		else if(carta.darPinta().equals("picas"))
			yInicial = 98;
		else if(carta.darPinta().equals("corazones"))
			yInicial = 98*2;
		else
			yInicial = 98*3;
		
		
		xInicial = 73*(carta.darValorNumero()-1);
		
		return new ImageIcon(imgCartas.getSubimage(xInicial, yInicial, anchoCarta, alturaCarta));
	}

}
