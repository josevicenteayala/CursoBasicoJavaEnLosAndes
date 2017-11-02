/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$ 
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1  
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co) 
 * Ejercicio: n6_lineasTelefonicas
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.lineasTelefonicas.mundo;


/**
 * Clase que representa una linea telef�nica celular.  Hereda la clase LineaTelefonica.
 */
public class LineaCelular extends LineaTelefonica{
	
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	

    
    /**
     * N�mero de minutos locales consumidos.
     */
    private int numeroMinutosLocal;

    /**
     * N�mero de minutos celulares consumidos.
     */
    private int numeroMinutosCelular;
    
    /**
     * Saldo o dinero disponible para realizar llamadas locales.
     */
    private double saldoDisponibleLocal;    
    
    
    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------
    
    /**
     * Constructor que inicializa la l�nea telef�nica celular <br>
     * <b>post: </b> La l�nea celular inicializ� sus valores en cero. 
     *               Se inicializaron los valores de la l�nea telefonica heredada en cero a trav�s del llamado a su respectivo constructor.
     */    
	public LineaCelular() {
		//Llamado al constructor de la clase heredada.
		super();
		
		saldoDisponibleLocal = 50000;
		numeroMinutosLocal = 0;
		numeroMinutosCelular = 0;
	}
	
    /**
     * Devuelve el n�mero de minutos locales consumidos
     * @return N�mero de minutos locales consumidos
     */
    public int darNumeroMinutosLocal() {
		return numeroMinutosLocal;
	}

    /**
     * Devuelve el n�mero de minutos celulares consumidos
     * @return N�mero de minutos celulares consumidos
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
     * Agrega una llamada local a la l�nea celular <br>
     * <b>pre: </b>  Hay saldo local disponible para realizar la llamada 
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, se incremento numeroMinutosLocal en minutos, 
     *               costoLlamadas aumento en ( minutos * 20 ) y saldoDisponibleLocal disminuye en ( minutos * 20 )
     * @param minutos N�mero de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaLocal( int minutos )
    {
        //
        //Una llamada mas. Se modifica el atributo protegido heredado.
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos. Se modifica el atributo protegido heredado.
        numeroMinutos = numeroMinutos + minutos;
        
        //Suma el costo (costo por minuto: 20 pesos). 
        //Se obtiene y modifica el atributo privado heredados a trav�s de los m�todos publicos heredados.
        costoLlamadas = costoLlamadas + ( minutos * 20 );

        //Suma los minutos locales consumidos. Se modifica el atributo propio de esta clase.
        numeroMinutosLocal = numeroMinutosLocal + minutos;        
        
        //Disminuye el saldo disponible para realizar llamadas locales (costo por minuto: 20 pesos)
        saldoDisponibleLocal = saldoDisponibleLocal - ( minutos * 20 );
    }	
    
    
    /**
     * Agrega una llamada a celular a la l�nea celular <br>
     * <b>post: </b> Se incremento en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aumento en ( minutos * 999 )
     * 				 y se incremento numeroMinutosCelular en minutos.
     * @param minutos N�mero de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaCelular( int minutos )
    {
    	//Se invoca el metodo agregarLlamadaCelular de la clase hereda a trav�s de la palabra reservada "super".
    	//Esta invocacion incrementa en 1 numeroDeLlamadas, incrementa numeroDeMinutos en minutos y aumenta costoLlamadas en ( minutos * 999 )
    	super.agregarLlamadaCelular(minutos);
    	
    	//Modifica el costo total de las llamadas con el valor dado por par�metro.
    	costoLlamadas = costoLlamadas - ( minutos * 989 );
    	
        //Suma los minutos a celular consumidos. Se modifica el atributo propio de esta clase.
        numeroMinutosCelular = numeroMinutosCelular + minutos;
    }  
    
    
    /**
     * Sobreescribre el m�todo heredado y lo deja sin implementaci�n para evitar realizar alguna llamada a larga distancia desde una l�nea celular <br>
     * @param minutos N�mero de minutos de la llamada. minutos >0.
     */
    public void agregarLlamadaLargaDistancia( int minutos )
    {   
    	//Sin implementaci�n.
    }    
	
    /**
    * Reinicia los atributos de la linea celular, ademas de los atributos heredados de la
    * clase padre. Este metodo sobreescribe al de mismo nombre de la clase LineaTelefonica
    */
    @Override
    public void reiniciar() {
    		super.reiniciar();
    		numeroMinutosLocal = 0;
    		numeroMinutosCelular = 0;
    		saldoDisponibleLocal = 50000;
    }

}
