package uniandes.cupi2.lineasTelefonicas.mundo;

public class LineaSatelital extends LineaCelular {
	private double saldoDisponibleLargaDistancia;
	
	public LineaSatelital() {
		super();
		saldoDisponibleLargaDistancia = 100000;
	}
	
	/**
	* Reinicia los valores de los atributos heredados a traves de la 
	* superclase, y el valor del saldo disponible a larga distancia que queda en 100000
	*/
	@Override
	public void reiniciar() {
		super.reiniciar();
		saldoDisponibleLargaDistancia = 100000;
	}
	
	/**
	* Sobreescribe el metodo heredado ya que la linea satelital si puede 
	* realizar llamadas a larga distancia. El minuto a larga distancia tiene 
	* un valor de 450 pesos desde la linea satelital
	* @param minutos Numero de minutos de la llamada. minutos >0.
	*/
	@Override
	public void agregarLlamadaLargaDistancia(int minutos) {
		super.agregarLlamadaLargaDistancia(minutos);
		++numeroLlamadas;
		numeroMinutos += minutos;
		costoLlamadas += minutos * 450;
		saldoDisponibleLargaDistancia -= minutos * 450;
	}
}
