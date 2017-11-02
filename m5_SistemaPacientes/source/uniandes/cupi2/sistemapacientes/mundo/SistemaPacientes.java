package uniandes.cupi2.sistemapacientes.mundo;

import java.util.ArrayList;



/**
 * Sistema de pacientes.
 */
public class SistemaPacientes 
{
	
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

	/**
     * Lista de pacientes
     */
    private ArrayList pacientes;
    
    /**
     * Índice del paciente actual.
     */
    private int pacienteActual;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * 
     * Constructor que inicializa el RUNT. <br>
     * <b> post: </b> Se inicializó la lista de persona vacía. El paciente actual es el primero de la lista.<br>
     * Se inicializó la lista de vehículos vacía.
     */
    public SistemaPacientes( )
    {
    
    	pacientes = new ArrayList( );
    	
    	Fecha fechaNacimiento1 = new Fecha( );    	
        fechaNacimiento1.inicializar( 16, 6, 1989 );       
        Fecha fechaMuestra1 = new Fecha( );
        fechaMuestra1.inicializar( 5, 4, 2012 );
    	pacientes.add(new Paciente("Daniela", "Olivera Mesa", 1, fechaNacimiento1, fechaMuestra1,  50, 30, 23, 22,true, "data/Person_Undefined_Female_Light.png"));
    	
    	Fecha fechaNacimiento2 = new Fecha( );    	
        fechaNacimiento2.inicializar( 12, 12, 1944 );       
        Fecha fechaMuestra2 = new Fecha( );
        fechaMuestra2.inicializar( 30, 3, 2013 );    	
    	pacientes.add(new Paciente("Roberto", "Espinoza", 2, fechaNacimiento2, fechaMuestra2,  60, 30, 25, 21,false, "data/ArmyNurse_Female_Dark.png"));
    	
    	Fecha fechaNacimiento3 = new Fecha( );    	
        fechaNacimiento3.inicializar( 25, 7, 1978 );       
        Fecha fechaMuestra3 = new Fecha( );
        fechaMuestra3.inicializar( 21, 4, 2015 ); 
    	pacientes.add(new Paciente("Pepito", "Perez", 2, fechaNacimiento3, fechaMuestra3, 70, 40, 33, 12,true, "data/Cowboy.png"));     
    	pacienteActual=0;
    }
    
    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    
    /**
     * 
     * @return Lista de pacientes.
     */
    public ArrayList darPacientes()
    {
    	return pacientes;
    }
    
    /**
     * Retorna el paciente actual.
     * @return Paciente actual.
     */
    public Paciente darPacienteActual( )
    {
        Paciente respuesta = (Paciente) pacientes.get( pacienteActual );
        return respuesta;
    }
    
    /**
     * Retorna el paciente siguiente de la lista de pacientes.
     * <b>pre: </b> La lista de pacientes está inicializada.
     * <b>post: </b> Avanza una posición en la lista de pacientes. 
     *               Si el paciente actual era el último de la lista, el siguiente es el primer paciente de la lista.
     *               La posición del paciente actual corresponde a la del paciente siguiente en la lista.
     * @return Paciente siguiente de la lista de pacientes.
     */
    public Paciente darPacienteSiguiente( )
    {
        pacienteActual++;
        if(pacienteActual==pacientes.size( ))
        {
            pacienteActual=0;
        }
        Paciente respuesta = (Paciente) pacientes.get( pacienteActual );
        return respuesta;
    }
    
    /**
     * Retorna el paciente anterior de la lista de pacientes.
     * <b>pre: </b> La lista de pacientes está inicializada.
     * <b>post: </b> Retrocede una posición en la lista de pacientes. 
     *               Si el paciente actual era el primero de la lista, el anterior es el último paciente de la lista.
     *               La posición del paciente actual corresponde a la del paciente anterior en la lista.
     * @return Paciente anterior de la lista de pacientes.
     */
    public Paciente darPacienteAnterior()
    {
        if(pacienteActual==0)
        {
            pacienteActual=pacientes.size( );
        }
        pacienteActual--;
        Paciente respuesta = (Paciente) pacientes.get( pacienteActual );
        return respuesta;
    }
	
	 //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método de extensión 1
     * @return Resultado de la operación
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método de extensión 2
     * @return Resultado de la operación
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}
