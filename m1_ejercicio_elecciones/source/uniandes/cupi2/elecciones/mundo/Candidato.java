/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Candidato.java 445 2007-06-25 16:30:28Z camil-ji $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_elecciones
 * Autor: Carlos Andr�s Vega - 29-ene-2007
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.elecciones.mundo;

/**
 * Candidato de la elecci�n.
 */

public class Candidato
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del candidato.
     */
    private String nombre;

    /**
     * Apellido del candidato.
     */
    private String apellido;

    /**
     * Partido pol�tico del candidato.
     */
    private String partidoPolitico;

    /**
     * Edad del candidato.
     */
    private int edad;

    /**
     * Costo de campa�a del candidato.
     */
    private double costoCampanha;

    /**
     * N�mero de votos del candidato.
     */
    private int votos;
    
    /**
     * N�mero de votos influenciados por internet.
     */
    private int numeroVotosInfluenciadosPorInternet;
    
    /**
     * N�mero de votos de g�nero femenino.
     */
    private int numeroVotosGeneroFemenino;
    
    /**
     * N�mero de votos de g�nero masculino.
     */
    private int numeroVotosGeneroMasculino;
    
    /**
     * N�mero de votos de edad joven (18 - 34).
     */
    private int numeroVotosEnEdadJoven;
    
    /**
     * N�mero de votos de edad media (35 - 54).
     */
    private int numeroVotosEnEdadMedia;
    /**
     * N�mero de votos de edad mayor (55 � m�s).
     */
    private int numeroVotosEnEdadMayor;
    /**
     * N�mero de votos influenciados por televisi�n
     */
     private int votosInfluenciaTelevision;

     private int votosInfluenciaRadio;
    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa los datos del candidato con los valores que vienen por par�metro. <br>
     * <b>post: </b> El costo de campa�a se inicializ� en cero<br>
     * El n�mero de votos se inicializ� en cero. <br>
     * @param nNombre Nombre del candidato
     * @param nApellido Apellido del Candidato
     * @param nPartidoPolitico Partido pol�tico del candidato
     * @param nEdad Edad del candidato
     */

    public Candidato( String nNombre, String nApellido, String nPartidoPolitico, int nEdad )
    {
        nombre = nNombre;
        apellido = nApellido;
        partidoPolitico = nPartidoPolitico;
        edad = nEdad;
        costoCampanha = 0;
        votos = 0;
        numeroVotosInfluenciadosPorInternet = 0;
        numeroVotosGeneroFemenino = 0;
        numeroVotosGeneroMasculino = 0;
        numeroVotosEnEdadJoven = 0;
        numeroVotosEnEdadMedia = 0;
        numeroVotosEnEdadMayor = 0;
    }

    /**
     * Devuelve el nombre del candidato.
     * @return nombre del candidato.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Devuelve el apellido del candidato.
     * @return apellido del candidato.
     */
    public String darApellido( )
    {
        return apellido;
    }

    /**
     * Devuelve el partido pol�tico del candidato.
     * @return partido pol�tico del candidato.
     */
    public String darPartidoPolitico( )
    {
        return partidoPolitico;
    }

    /**
     * Devuelve la edad del candidato.
     * @return edad del candidato.
     */
    public int darEdad( )
    {
        return edad;
    }

    /**
     * Devuelve el costo de campa�a del candidato.
     * @return costo de campa�a del candidato.
     */
    public double darCostoCampanha( )
    {
        return costoCampanha;
    }

    /**
     * Devuelve el n�mero de votos del candidato.
     * @return n�mero de votos obtenidos.
     */
    public int darVotos( )
    {
        return votos;
    }
    
    /**
     * Devuelve el n�mero de votos influenciados por internet.
     * @return n�mero de votos influenciados por internet.
     */
    public int darVotosInfluenciaInternet()
    {
    	return numeroVotosInfluenciadosPorInternet;
    }
    
    /**
    * Devuelve el n�mero de votos influenciados por television.
    * @return n�mero de votos influenciados por television.
    */    
    public int darVotosInfluenciaTelevision() {
    	return votosInfluenciaTelevision;
    }
    
    /**
    * Inicializa los atributos correspondientes a la influencia de los canales de televisi�n y radio en 0.
    * Tambi�n puede ser usado para el reinicio de los atributos de votos por influencia de la television y de la radio 
    * a su valor inicial.
    */
    public void inicializarInfluenciaTelevision()
    {	 
    	votosInfluenciaTelevision = 0;
        votosInfluenciaRadio = 0;
    } 
    
    /**
    * Agrega un voto influenciado por la televisi�n al atributo correspondiente
    */    
    public void agregarVotoInfluenciaTelevision( ){
    	votosInfluenciaTelevision++;
    }
    
    /**
    * Devuelve el porcentaje de votos de influencia teniendo en cuenta los votos de television 
    * sobre el total de votos recibidos.
    * @return procentaje de votos total que fueron recibidos por television 
    */
          
    public double darPorcentajeVotosInfluenciaTelevisionCanditato() {
    	return 100 * (darVotosInfluenciaTelevision() / darVotos()) ;
    }
    
    /**
     * Devuelve el n�mero de votos de g�nero femenino.
     * @return n�mero de votos de g�nero femenino.
     */
    public int darVotosGeneroFemenino()
    {
    	return numeroVotosGeneroFemenino;
    }
    
    /**
     * Devuelve el n�mero de votos de g�nero masculino.
     * @return n�mero de votos de g�nero masculino.
     */
    public int darVotosGeneroMasculino()
    {
    	return numeroVotosGeneroMasculino;
    }
    
    /**
     * Devuelve el n�mero de votos de edad joven.
     * @return n�mero de votos de edad joven.
     */
    public int darVotosEdadJoven()
    {
    	return numeroVotosEnEdadJoven;
    }
    
    /**
     * Devuelve el n�mero de votos de edad media.
     * @return n�mero de votos de edad media.
     */
    public int darVotosEdadMedia()
    {
    	return numeroVotosEnEdadMedia;
    }
    
    /**
     * Devuelve el n�mero de votos de edad mayor.
     * @return n�mero de votos de edad mayor.
     */
    public int darVotosEdadMayor()
    {
    	return numeroVotosEnEdadMayor;
    }

    /**
     * Ingresa un voto al candidato.<br>
     * <b>post: </b> Se modific� el n�mero de votos aument�ndose el existente en 1.
     */
    public void ingresarUnVoto( )
    {
        votos = votos + 1;
    }

    /**
     * Adiciona un voto influenciado por la televisi�n <br<
     * <b>post: </b> Se adiciona al costo de la campa�a la suma de $1000 y se incrementa el n�mero de votos totales en 1.
     */
    public void agregarVotoTelevision( )
    {
        costoCampanha = costoCampanha + 1000;
    }

    /**
     * Adiciona un voto influenciado por la radio <br>
     * <b>post: </b> Se adiciona al costo de la campa�a la suma de $500 y se incrementa el n�mero de votos totales en 1.
     * 
     */
    public void agregarVotoRadio( )
    {
        costoCampanha = costoCampanha + 500;
    }

    /**
     * Adiciona un voto influenciado por Internet <br>
     * <b>post: </b> Se adiciona al costo de la campa�a la suma de $100, se incrementa el n�mero de votos totales en 1. 
     * Se incrementa en 1 el n�mero de votos influenciados por internet.
     */
    public void agregarVotoInternet( )
    {
    	costoCampanha += 100; 
    	ingresarUnVoto();
    	numeroVotosInfluenciadosPorInternet++;
    }
    
    /**
     * Adiciona un voto dado por un votante de g�nero femenino <br>
     * <b>post: </b> Se incrementa el n�mero de votos de g�nero femenino en 1.
     */
    public void agregarVotoGeneroFemenino( )
    {
    	numeroVotosGeneroFemenino++;
    }
    
    /**
     * Adiciona un voto dado por un votante de g�nero masculino <br>
     * <b>post: </b> Se incrementa el n�mero de votos de g�nero masculino en 1.
     */
    public void agregarVotoGeneroMasculino( )
    {
    	numeroVotosGeneroMasculino++;
    }
    
    /**
     * Adiciona un voto dado por un votante de edad joven <br>
     * <b>post: </b> Se incrementa el n�mero de votos de edad joven en 1.
     */
    public void agregarVotoEdadJoven( )
    {
    	numeroVotosEnEdadJoven++;
    }
    
    /**
     * Adiciona un voto dado por un votante de edad media <br>
     * <b>post: </b> Se incrementa el n�mero de votos de edad media en 1.
     */
    public void agregarVotoEdadMedia( )
    {
    	numeroVotosEnEdadMedia++;
    }
    
    /**
     * Adiciona un voto dado por un votante de edad mayor <br>
     * <b>post: </b> Se incrementa el n�mero de votos de edad mayor en 1.
     */
    public void agregarVotoEdadMayor( )
    {
    	numeroVotosEnEdadMayor++;
    }

    /**
     * Se reinicia el conteo de votos 
     * <b>post: </b> votos = 0. votosGeneroFemenino = 0. votosGeneroMasculino = 0. votosEdadJoven = 0.
     * 	votosEdadMedia = 0. votosEdadMayor = 0. votosInfluenciaInternet=0
     */
    public void reiniciarConteoVotos( )
    {
        votos = 0;
        numeroVotosGeneroFemenino = 0;
        numeroVotosGeneroMasculino = 0;
        numeroVotosEnEdadJoven = 0;
        numeroVotosEnEdadMedia = 0;
        numeroVotosEnEdadMayor = 0;
        numeroVotosInfluenciadosPorInternet = 0;
    }

    /**
     * Se reinicia el costo de campa�a <b>post: </b> costoCampanha = 0.
     */
    public void reiniciarCostoCampanha( )
    {
        costoCampanha = 0;
    }
}
