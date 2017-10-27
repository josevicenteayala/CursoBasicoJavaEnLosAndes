package uniandes.cupi2.elecciones.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelVotar extends JPanel implements ActionListener
{
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para el bot�n votar
     */
    private static final String VOTAR = "Votar";

    /**
     * Comando para el bot�n cancelar
     */
    private static final String CANCELAR = "Cancelar";
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el di�logo al que pertenece el panel
     */
    private DialogoVotar dialogo;
    
    /**
     * Es la lista de opciones de g�nero.
     */
    private JComboBox listaGenero;

    /**
     * Es la lista de opciones de rango de edad.
     */
    private JComboBox listaRangoEdad;
    
    /**
     * Es la lista de opciones de influencia.
     */
    private JComboBox listaInfluencia;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    public PanelVotar(DialogoVotar dv)
    {
    	dialogo = dv;
    	setLayout(new BorderLayout());
    	
    	JPanel panelAuxArriba = new JPanel();
    	
    	JPanel panelDatos = new JPanel();
    	JPanel panelBotones = new JPanel();
    	
    	panelDatos.setLayout(new GridLayout(8, 1));
    	
    	JLabel lblInfluencia = new JLabel("�Que medio influenci� m�s en usted para votar por este candidato?");
    	JLabel lblGenero = new JLabel("Seleccione su g�nero:");
    	JLabel lblRangoEdad = new JLabel("Seleccione su rango de edad:");
    	
    	String[] opcionesGenero = { "Femenino", "Masculino" };
    	String[] opcionesRangoEdad = { "J�ven: 18 - 34 a�os", "Media: 35 - 54 a�os", "Mayor: 55 o m�s a�os" };
    	String[] opcionesInfuencia = { "Televisi�n", "Radio", "Internet" };
    	
    	listaGenero = new JComboBox(opcionesGenero);
    	listaGenero.setSelectedIndex(0);
    	listaGenero.addActionListener(this);
    	
    	listaRangoEdad = new JComboBox(opcionesRangoEdad);
    	listaRangoEdad.setSelectedIndex(0);
    	listaRangoEdad.addActionListener(this);
    	
    	listaInfluencia = new JComboBox(opcionesInfuencia);
    	listaInfluencia.setSelectedIndex(0);
    	listaInfluencia.addActionListener(this);
    	
    	JButton btnVotar = new JButton(VOTAR);
    	btnVotar.setActionCommand(VOTAR);
    	btnVotar.addActionListener(this);
    	
    	JButton btnCancelar = new JButton(CANCELAR);
    	btnCancelar.setActionCommand(CANCELAR);
    	btnCancelar.addActionListener(this);
    	
    	panelDatos.add(lblGenero);
    	panelDatos.add(listaGenero);
    	panelDatos.add(lblRangoEdad);
    	panelDatos.add(listaRangoEdad);
    	panelDatos.add(lblInfluencia);
    	panelDatos.add(listaInfluencia);
    	
    	panelBotones.add(btnVotar);
    	panelBotones.add(btnCancelar);
    	
    	panelAuxArriba.add(panelDatos);
    	
    	add(panelAuxArriba, BorderLayout.CENTER);
    	add(panelBotones, BorderLayout.SOUTH);
    	
    }
    
    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Es el m�todo que se llama cuando de hace click sobre un bot�n
     * @param evento Es el evento de click sobre un bot�n - evento!=null
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        
        if( VOTAR.equals( comando ) )
        {
            String genero = (String) listaGenero.getSelectedItem();
            String rangoEdad = (String) listaRangoEdad.getSelectedItem();
            String influencia = (String) listaInfluencia.getSelectedItem();
            
            dialogo.votar(influencia, genero, rangoEdad);
            dialogo.dispose( );
            
        }
        else if( CANCELAR.equals( comando ) )
        {
            dialogo.dispose( );
        }
    }
}
