package uniandes.cupi2.lineasTelefonicas.mundo;

public interface ILineaTelefonica {
	public double darCostoLlamadas( );
	public int darNumeroLlamadas( );
	public int darNumeroMinutos( );
	public void modificarCostoLlamada(double pCostoLlamadas);
	public void agregarLlamadaLocal( int minutos );
	public void reiniciar( );
}
