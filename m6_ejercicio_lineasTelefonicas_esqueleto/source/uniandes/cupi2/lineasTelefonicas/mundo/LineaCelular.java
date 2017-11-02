/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1  
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co) 
 * Ejercicio: n6_lineasTelefonicas
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.lineasTelefonicas.mundo;


/**
 * Clase que representa una línea telefónica celular.  Hereda la clase LineaTelefonica.
 */
public class LineaCelular extends LineaTelefonica{
	
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	

    
    /**
     * Número de minutos locales consumidos.
     */
    private int numeroMinutosLocal;

    /**
     * Número de minutos celulares consumidos.
     */
    private int numeroMinutosCelular;
    
    /**
     * Saldo o dinero disponible para realizar llamadas locales.
     */
    private double saldoDisponibleLocal;    
    
    
    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
    
    /**
     * Constructor que inicializa la línea telefónica celular <br>
     * <b>post: </b> La línea celular inicializó sus valores en cero. 
     *               Se inicializaron los valores de la línea telefonica heredada en cero a través del llamado a su respectivo constructor.
     */    
	public LineaCelular() {
		//Llamado al constructor de la clase heredada.
		super();
		
		saldoDisponibleLocal = 50000;
		numeroMinutosLocal = 0;
		numeroMinutosCelular = 0;
	}
	
    /**
     * Devuelve el número de minutos locales consumidos
     * @return Número de minutos locales consumidos
     */
    public int darNumeroMinutosLocal() {
		return numeroMinutosLocal;
	}

    /**
     * Devuelve el número de minutos celulares consumidos
     * @return Número de minutos celulares consumidos
     */    
	public int darNumeroMinutosCelular() {
		return numeroMinutosCelular;
	}

	/**
     * Devuelve el saldo disponible para realizar llamadas locales.
     * @return Saldo disponible para realizar llamadas locales.
     */	
	public double darSaldoDisponibleLocal() {
		return saldoDisponibleLocal;
	}

	/**
     * Devuelve el costo total de las llamadas locales realizadas. Un minuto local 20 pesos.
     * @return Costo total de las llamadas locales realizadas.
     */
	public double calcularCostoLlamadasLocal() {
		return numeroMinutosLocal * 20;
	}
	
	
    
    /**
     * Agrega una llamada local a la línea celular <br>
     * <b>pre: </b>  Hay saldo local disponible para realizar la llamada 
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, se incremento numeroMinutosLocal en minutos, 
     *               costoLlamadas aumento en ( minutos * 20 ) y saldoDisponibleLocal disminuye en ( minutos * 20 )
     * @param minutos Número de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaLocal( int minutos )
    {
        //
        //Una llamada más. Se modifica el atributo protegido heredado.
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos. Se modifica el atributo protegido heredado.
        numeroMinutos = numeroMinutos + minutos;
        
        //Suma el costo (costo por minuto: 20 pesos). 
        //Se obtiene y modifica el atributo privado heredados a través de los métodos publicos heredados.
        double nuevoTotalLlamadas = darCostoLlamadas() + ( minutos * 20 );
        modificarCostoLlamada(nuevoTotalLlamadas);

        //Suma los minutos locales consumidos. Se modifica el atributo propio de esta clase.
        numeroMinutosLocal = numeroMinutosLocal + minutos;        
        
        //Disminuye el saldo disponible para realizar llamadas locales (costo por minuto: 20 pesos)
        saldoDisponibleLocal = saldoDisponibleLocal - ( minutos * 20 );
    }	
    
    
    /**
     * Agrega una llamada a celular a la línea celular <br>
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 999 )
     * 				 y se incremento numeroMinutosCelular en minutos.
     * @param minutos Número de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaCelular( int minutos )
    {
    	//Se invoca el método agregarLlamadaCelular de la clase hereda a través de la palabra reservada "super".
    	//Esta invocación incrementa en 1 numeroDeLlamadas, incrementa numeroDeMinutos en minutos y aumenta costoLlamadas en ( minutos * 999 )
    	super.agregarLlamadaCelular(minutos);
    	
    	//Modifica el costo total de las llamadas con el valor dado por parámetro.
    	modificarCostoLlamada( darCostoLlamadas() - minutos*989);
    	
        //Suma los minutos a celular consumidos. Se modifica el atributo propio de esta clase.
        numeroMinutosCelular = numeroMinutosCelular + minutos;
    }  
    
    
    /**
     * Sobreescribre el método heredado y lo deja sin implementación para evitar realizar alguna llamada a larga distancia desde una línea celular <br>
     * @param minutos Número de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaLargaDistancia( int minutos )
    {   
    	//Sin implementación.
    } 
    
    /**
     * Reinicia la línea celular, dejando todos sus valores en cero.
     */
    public void reiniciar( )
    {
    	super.reiniciar();
        numeroMinutosLocal =0;
        numeroMinutosCelular =0;
        saldoDisponibleLocal = 50000;
    }
	

}
