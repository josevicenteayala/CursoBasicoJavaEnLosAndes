package uniandes.cupi2.elecciones.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import uniandes.cupi2.elecciones.mundo.Candidato;

public class PanelEstadisticasCandidato extends JPanel implements ActionListener
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el diálogo al que pertenece el panel
     */
    private DialogoEstadisticasCandidato dialogo;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    public PanelEstadisticasCandidato(DialogoEstadisticasCandidato dv, Candidato candidato,  String pctje,  String pctjeInternet)
    {
    	dialogo = dv;
    	setLayout(new BorderLayout());
    	
    	JPanel panelArriba = new JPanel();
    	JPanel panelAbajo = new JPanel();
    	
    	panelArriba.setLayout(new GridLayout(2, 2));
    	JLabel lblPctjeVotos = new JLabel("Porcentaje de votos");
    	JTextField txtPctjeVotos = new JTextField(pctje + " %");
    	txtPctjeVotos.setEditable(false);
    	
    	JLabel lblPctjeVotosInternet = new JLabel("Porcentaje de votos influenciados por internet");
    	JTextField txtPctjeVotosInternet = new JTextField(pctjeInternet + " %");
    	txtPctjeVotosInternet.setEditable(false);
    	
    	panelArriba.add(lblPctjeVotos);
    	panelArriba.add(txtPctjeVotos);
    	panelArriba.add(lblPctjeVotosInternet);
    	panelArriba.add(txtPctjeVotosInternet);
    	
    	DefaultPieDataset datosRangoEdad = new DefaultPieDataset();
    	
    	datosRangoEdad.setValue("18 - 34 ", candidato.darVotosEdadJoven());
		datosRangoEdad.setValue("35 - 54 ", candidato.darVotosEdadMedia());
		datosRangoEdad.setValue("55 ó más ", candidato.darVotosEdadMayor());
    	
    	JFreeChart chart = ChartFactory.createPieChart("Votos por rango de edad", datosRangoEdad, true, true ,false);

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
		plot.setNoDataMessage("No hay datos disponibles");
		plot.setCircular(true);
		PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}: {1}", new DecimalFormat("0"), new DecimalFormat("0%"));
		plot.setLabelGenerator(gen);
		plot.setSimpleLabels(true);
		plot.setBackgroundPaint(Color.WHITE);
		plot.setOutlineVisible(false);
		
		ChartPanel auxRangoEdad = new ChartPanel(chart);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		panelAbajo.add(btnAceptar);
		
		add(panelArriba, BorderLayout.NORTH);
		add(auxRangoEdad, BorderLayout.CENTER);
		add(panelAbajo, BorderLayout.SOUTH);
    }
    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Es el método que se llama cuando de hace click sobre un botón
     * @param evento Es el evento de click sobre un botón - evento!=null
     */
    public void actionPerformed( ActionEvent evento )
    {
    	dialogo.dispose();
    }
}
