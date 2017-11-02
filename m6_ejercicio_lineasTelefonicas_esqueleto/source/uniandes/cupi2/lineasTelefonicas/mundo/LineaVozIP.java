package uniandes.cupi2.lineasTelefonicas.mundo;

public class LineaVozIP extends LineaTelefonica {
	public static final int VALOR_MINUTO_LLAMADA_LOCAL = 35;
	public static final int VALOR_MINUTO_LLAMADA_LARGA_DISTANCIA = 80;
	public static final int VALOR_MINUTO_LLAMADA_CELULAR = 7;
	
	public LineaVozIP() {
		super();
		saldoDisponible = 100000;
		numeroMinutosLargaDistancia = 0;
		numeroMinutosCelular = 0;
	}
	
	/**
	 * Indica los numeros de minutos a larga distancia
	 */
	private int numeroMinutosLargaDistancia;
	/**
	 * indica los numeros de minutos a celular
	 */
	private int numeroMinutosCelular;
	/**
	 * indica el saldo disponible para hacer llamadas
	 */
	private double saldoDisponible;
	
	/**
	 * @return the numeroMinutosLargaDistancia
	 */
	public int darNumeroMinutosLargaDistancia() {
		return numeroMinutosLargaDistancia;
	}
	/**
	 * @return the numeroMinutosCelular
	 */
	public int darNumeroMinutosCelular() {
		return numeroMinutosCelular;
	}
	/**
	 * @return the saldoDisponible
	 */
	public double darSaldoDisponible() {
		return saldoDisponible;
	}
	
	/* (non-Javadoc)
	 * @see uniandes.cupi2.lineasTelefonicas.mundo.LineaTelefonica#agregarLlamadaCelular(int)
	 */
	@Override
	public void agregarLlamadaCelular(int minutos) {
        //
        //Una llamada mas
        ++numeroLlamadas;
        //
        //Suma los minutos consumidos
        numeroMinutos += minutos;
        //
        numeroMinutosCelular += minutos;
        double valorLlamada = minutos * VALOR_MINUTO_LLAMADA_CELULAR;
        //Suma el costo (costo por minuto: 7 pesos)
        double costoLlamada = darCostoLlamadas() + valorLlamada ;
        modificarCostoLlamada(costoLlamada);
        saldoDisponible -= valorLlamada;
	}
	
	@Override
	public void agregarLlamadaLargaDistancia(int minutos) {
        //
        //Una llamada mas
        ++numeroLlamadas;
        //
        //Suma los minutos consumidos
        numeroMinutos += minutos;
        numeroMinutosLargaDistancia += minutos;
        //
        //Suma el costo (costo por minuto: 80 pesos)
        double valorLlamada = minutos * VALOR_MINUTO_LLAMADA_LARGA_DISTANCIA;
		double costoLlamada = darCostoLlamadas() + valorLlamada ;
        modificarCostoLlamada(costoLlamada);
        
        saldoDisponible -= valorLlamada;
	}
	
	/* (non-Javadoc)
	 * @see uniandes.cupi2.lineasTelefonicas.mundo.LineaTelefonica#reiniciar()
	 */
	@Override
	public void reiniciar() {
		super.reiniciar();
		saldoDisponible = 100000;
		numeroMinutosLargaDistancia = 0;
		numeroMinutosCelular = 0;		
	}
}
