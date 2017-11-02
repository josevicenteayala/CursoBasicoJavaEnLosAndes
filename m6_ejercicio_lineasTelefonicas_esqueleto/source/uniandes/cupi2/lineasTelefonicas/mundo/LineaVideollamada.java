package uniandes.cupi2.lineasTelefonicas.mundo;

public class LineaVideollamada extends LineaVozIP {

	private int numeroMinutosVideollamada;
	
	public LineaVideollamada() {
		super();
		numeroMinutosVideollamada = 0;
	}

	/**
	* Agrega una videollamada a la linea
	* <b> post: </b> Se aumento el numero de llamadas en 1, el numero de minutos consumidos y numero minutos de videollamada aumentaron en el 
	* numero de minutos  dados como parametro, el costo de llamadas aumento en el costo de la llamada  realizada y el saldo disminuyo en ese mismo valor. <br>
	* @param minutos - Numero de minutos de duracion de la videollamada
	*/	
	public void agregarVideollamada(int minutos) {
        //
        //Una llamada mas
        ++numeroLlamadas;
        //
        //Suma los minutos consumidos
        numeroMinutos += minutos;
        numeroMinutosVideollamada += minutos;
        //
        //Suma el costo (costo por minuto: 550 pesos)
        double valorLlamada = minutos * 550;
		double costoLlamada = darCostoLlamadas() + valorLlamada ;
        modificarCostoLlamada(costoLlamada);
        
        saldoDisponible -= valorLlamada;		
	}
	/**
	* Reinicia los atributos heredados de la clase padre y el numero de minutos de videollamada
	*/	
	@Override
	public void reiniciar() {
		super.reiniciar();
		numeroMinutosVideollamada = 0;
	}
}
