/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Urna.java 445 2007-06-25 16:30:28Z camil-ji $
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
 * Es la una urna de votaci�n con tres candidatos.
 */
public class Urna
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El candidato numero 1 de la elecciones
     */
    private Candidato candidato1;

    /**
     * El candidato numero 2 de la elecciones
     */
    private Candidato candidato2;

    /**
     * El candidato numero 3 de la elecciones
     */
    private Candidato candidato3;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    /**
     * Inicializa los tres candidatos<br>
     * <b>post: </b> Se inicializaron los tres candidatos con los valores por parametro nombre, apellido, partido politico y edad.
     */
    public Urna( )
    {

        // Inicializa el candidato 1
        candidato1 = new Candidato( "Felipe", "Pitti", "Independiente", 27 );

        // Inicializa el candidato 2
        candidato2 = new Candidato( "Susanita", "Chirusi", "Revolucionario", 26 );

        // Inicializa el candidato 3
        candidato3 = new Candidato( "Manolito", "Goreiro", "Tradicional", 26 );
    }

    /**
     * Devuelve el candidato 1
     * @return Candidato 1
     */
    public Candidato darCandidato1( )
    {
        return candidato1;
    }

    /**
     * Devuelve el candidato 2
     * @return Candidato 2
     */
    public Candidato darCandidato2( )
    {
       	return candidato2;
    }

    /**
     * Devuelve el candidato 3
     * @return Candidato 3
     */
    public Candidato darCandidato3( )
    {
    	 return candidato3;
    }
    
    /**
     * Registra un vota al candidato 1
     */
    public void registrarVotoCandidato1( )
    {
        candidato1.ingresarUnVoto();
    }

    /**
     * Ingresa un voto influenciado por la televisi�n al candidato 1
     */
    public void ingresarVotoTelevisionCandidato1( )
    {
        candidato1.agregarVotoTelevision( );
    }

    /**
     * Ingresa un voto influenciado por radio al candidato 1
     */
    public void ingresarVotoRadioCandidato1( )
    {
        candidato1.agregarVotoRadio( );
    }

    /**
     * Ingresa un voto influenciado por Internet al candidato 1
     */
    public void ingresarVotoInternetCandidato1( )
    {
        candidato1.agregarVotoInternet( );
    }
    
    /**
     * Registra un voto de g�nero femenino al candidato 1.
     */
    public void registrarVotoGeneroFemeninoCandidato1( )
    {
        candidato1.agregarVotoGeneroFemenino();
    }

    /**
     * Registra un voto de g�nero masculino al candidato 1.
     */
    public void registrarVotoGeneroMasculinoCandidato1( )
    {
        candidato1.agregarVotoGeneroMasculino();
    }
    
    /**
     * Registra un voto de edad joven al candidato 1.
     */
    public void registrarVotoEdadJovenCandidato1( )
    {
        candidato1.agregarVotoEdadJoven();
    }
    
    /**
     * Registra un voto de edad media al candidato 1.
     */
    public void registrarVotoEdadMediaCandidato1( )
    {
        candidato1.agregarVotoEdadMedia();
    }
    
    /**
     * Registra un voto de edad mayor al candidato 1.
     */
    public void registrarVotoEdadMayorCandidato1( )
    {
        candidato1.agregarVotoEdadMayor();
    }

    /**
     * Registra un voto al candidato 2
     */
    public void registrarVotoCandidato2( )
    {
        candidato2.ingresarUnVoto();
    }
    
    /**
     * Ingresa un voto influenciado por la televisi�n al candidato 2
     */
    public void ingresarVotoTelevisionCandidato2( )
    {
        candidato2.agregarVotoTelevision( );
    }

    /**
     * Ingresa un voto influenciado por radio al candidato 2
     */
    public void ingresarVotoRadioCandidato2( )
    {
        candidato2.agregarVotoRadio( );
    }

    /**
     * Ingresa un voto influenciado por Internet al candidato 2
     */
    public void ingresarVotoInternetCandidato2( )
    {
        candidato2.agregarVotoInternet( );
    }

    /**
     * Registra un voto de genero femenino al candidato 2.
     */
    public void registrarVotoGeneroFemeninoCandidato2( )
    {
    	candidato2.agregarVotoGeneroFemenino();
    }

    /**
     * Registra un voto de g�nero masculino al candidato 2.
     */
    public void registrarVotoGeneroMasculinoCandidato2( )
    {
    	candidato2.agregarVotoGeneroMasculino();
    }
    
    /**
     * Registra un voto de edad joven al candidato 2.
     */
    public void registrarVotoEdadJovenCandidato2( )
    {
    	candidato2.agregarVotoEdadJoven();
    }
    
    /**
     * Registra un voto de edad media al candidato 2.
     */
    public void registrarVotoEdadMediaCandidato2( )
    {
    	candidato2.agregarVotoEdadMedia();
    }
    
    /**
     * Registra un voto de edad mayor al candidato 2.
     */
    public void registrarVotoEdadMayorCandidato2( )
    {
    	candidato2.agregarVotoEdadMayor();
    }
    
    /**
     * Registra un voto al candidato 3
     */
    public void registrarVotoCandidato3( )
    {
        candidato3.ingresarUnVoto();
    }
    
    /**
     * Ingresa un voto influenciado por la televisi�n al candidato 3
     */
    public void ingresarVotoTelevisionCandidato3( )
    {
        candidato3.agregarVotoTelevision( );
    }

    /**
     * Ingresa un voto influenciado por radio al candidato 3
     */
    public void ingresarVotoRadioCandidato3( )
    {
        candidato3.agregarVotoRadio( );
    }

    /**
     * Ingresa un voto influenciado por Internet al candidato 3
     */
    public void ingresarVotoInternetCandidato3( )
    {
        candidato3.agregarVotoInternet( );
    }
    
    /**
     * Registra un voto de genero femenino al candidato 3.
     */
    public void registrarVotoGeneroFemeninoCandidato3( )
    {
    	candidato3.agregarVotoGeneroFemenino();
    }

    /**
     * Registra un voto de genero masculino al candidato 3.
     */
    public void registrarVotoGeneroMasculinoCandidato3( )
    {
    	candidato3.agregarVotoGeneroMasculino();
    }
    
    /**
     * Registra un voto de edad joven al candidato 3.
     */
    public void registrarVotoEdadJovenCandidato3( )
    {
    	candidato3.agregarVotoEdadJoven();
    }
    
    /**
     * Registra un voto de edad media al candidato 3.
     */
    public void registrarVotoEdadMediaCandidato3( )
    {
    	candidato3.agregarVotoEdadMedia();
    }
    
    /**
     * Registra un voto de edad mayor al candidato 3.
     */
    public void registrarVotoEdadMayorCandidato3( )
    {
    	candidato3.agregarVotoEdadMayor();
    }

    /**
     * Devuelve el total de votos en la urna
     * @return La sumatoria de los votos de los tres candidatos
     */
    public int calcularTotalVotos( )
    {
        return candidato1.darVotos( ) + candidato2.darVotos( ) + candidato3.darVotos( );
    }
    
    /**
     * Devuelve el total de votos influenciados por internet.
     * @return La sumatoria de los votos de los tres candidatos
     */
    public int calcularTotalVotosInternet( )
    {
        return candidato1.darVotosInfluenciaInternet() + candidato2.darVotosInfluenciaInternet() + candidato3.darVotosInfluenciaInternet();
    }
    
    /**
     * Devuelve el total de votos realizados por votantes de g�nero femenino
     * @return La sumatoria de los votos de g�nero femenino de los tres candidatos
     */
    public int calcularTotalVotosGeneroFemenino( )
    {
    	return candidato1.darVotosGeneroFemenino() + candidato2.darVotosGeneroFemenino() + candidato3.darVotosGeneroFemenino();
    }
    
    /**
     * Devuelve el total de votos realizados por votantes de g�nero masculino
     * @return La sumatoria de los votantes de g�nero masculino de los tres candidatos
     */
    public int calcularTotalVotosGeneroMasculino( )
    {
    	return candidato1.darVotosGeneroMasculino() + candidato2.darVotosGeneroMasculino() + candidato3.darVotosGeneroMasculino(); 
    }
    
    /**
     * Devuelve el total de votos realizados por votantes de edad joven
     * @return La sumatoria de los votos de edad joven de los tres candidatos
     */
    public int calcularTotalVotosEdadJoven( )
    {
    	return candidato1.darVotosEdadJoven() + candidato2.darVotosEdadJoven() + candidato3.darVotosEdadJoven();
    }
    
    /**
     * Devuelve el total de votos realizados por votantes de edad media
     * @return La sumatoria de los votos de edad media de los tres candidatos
     */
    public int calcularTotalVotosEdadMedia( )
    {
    	return candidato1.darVotosEdadMedia() + candidato2.darVotosEdadMedia() + candidato3.darVotosEdadMedia();
    }
    
    /**
     * Devuelve el total de votos realizados por votantes de edad mayor
     * @return La sumatoria de los votos de edad mayor de los tres candidatos
     */
    public int calcularTotalVotosEdadMayor( )
    {
    	return candidato1.darVotosEdadMayor() + candidato2.darVotosEdadMayor() + candidato3.darVotosEdadMayor();
    }

    /**
     * Devuelve el costo promedio de campa�a de los candidatos
     * @return La raz�n de la sumatoria de los costos de campa�a de los candidatos y el n�mero total de candidatos.
     */
    public double calcularCostoPromedioCampanha( )
    {

        double total;
        double promedio;

        total = candidato1.darCostoCampanha( ) + candidato2.darCostoCampanha( ) + candidato3.darCostoCampanha( );
        promedio = total / 3;

        return promedio;

    }

    /**
     * Devuelve el porcentaje de votos obtenidos por el candidato 1
     * @return porcentaje de votos obtenidos por el candidato 1
     */
    public double calcularPorcentajeVotosCandidato1( )
    {

        double numVotosCandidato1;
        double votosTotales;

        double porcentaje;

        numVotosCandidato1 = candidato1.darVotos( );
        votosTotales = calcularTotalVotos( );

        porcentaje = numVotosCandidato1 / votosTotales * 100;

        return porcentaje;
    }

    /**
     * Devuelve el porcentaje de votos obtenidos por el candidato 2
     * @return porcentaje de votos obtenidos por el candidato 2
     */
    public double calcularPorcentajeVotosCandidato2( )
    {

        double numVotosCandidato2;
        double votosTotales;

        double porcentaje;

        numVotosCandidato2 = candidato2.darVotos( );
        votosTotales = calcularTotalVotos( );

        porcentaje = numVotosCandidato2 / votosTotales * 100;

        return porcentaje;
    }

    /**
     * Devuelve el porcentaje de votos obtenidos por el candidato 3
     * @return porcentaje de votos obtenidos por el candidato 3
     */
    public double calcularPorcentajeVotosCandidato3( )
    {

        double numVotosCandidato3;
        double votosTotales;

        double porcentaje;

        numVotosCandidato3 = candidato3.darVotos( );
        votosTotales = calcularTotalVotos( );

        porcentaje = numVotosCandidato3 / votosTotales * 100;

        return porcentaje;
    }
    
    /**
     * Devuelve el porcentaje de votos obtenidos por internet por el candidato 1 sobre el total de votos por internet.
     * @return porcentaje de votos obtenidos por internet por el candidato 1.
     */
    public double calcularPorcentajeVotosPorInternetCandidato1( )
    {
    	int darVotosInfluenciaInternet = candidato1.darVotosInfluenciaInternet();
		int calcularTotalVotosInternet = calcularTotalVotosInternet();
		int porcentaje = 100 * darVotosInfluenciaInternet/calcularTotalVotosInternet;
		return porcentaje;
    }

    /**
     * Devuelve el porcentaje de votos obtenidos por internet por el candidato 2 sobre el total de votos por internet.
     * @return porcentaje de votos obtenidos por internet por el candidato 2.
     */
    public double calcularPorcentajeVotosPorInternetCandidato2( )
    {
    	int darVotosInfluenciaInternet = candidato2.darVotosInfluenciaInternet();
		int calcularTotalVotosInternet = calcularTotalVotosInternet();
		int porcentaje = 100 * darVotosInfluenciaInternet/calcularTotalVotosInternet;
		return porcentaje;
    }

    /**
     * Devuelve el porcentaje de votos obtenidos por internet por el candidato 3 sobre el total de votos por internet.
     * @return porcentaje de votos obtenidos por internet por el candidato 3.
     */
    public double calcularPorcentajeVotosPorInternetCandidato3( )
    {
    	int darVotosInfluenciaInternet = candidato3.darVotosInfluenciaInternet();
		int calcularTotalVotosInternet = calcularTotalVotosInternet();
		int porcentaje = 100 * darVotosInfluenciaInternet/calcularTotalVotosInternet;
		return porcentaje;
    }

    /**
     * Restaura la urna al estado inicial, todos los candidatos quedan sin votos y costo de campa�a en 0
     */
    public void vaciarUrna( )
    {

        // Reiniciar candidato 1
        candidato1.reiniciarConteoVotos( );
        candidato1.reiniciarCostoCampanha( );

        // Reiniciar candidato 2
        candidato2.reiniciarConteoVotos( );
        candidato2.reiniciarCostoCampanha( );

        // Reiniciar candidato 3
        candidato3.reiniciarConteoVotos( );
        candidato3.reiniciarCostoCampanha( );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
    * Devuelve el promedio de porcentaje de influencia de votos de television para todos los candidatos.
    * @return promedio del porcentaje de votos influenciados por televisión para todos los candidatos.
    */
    public double darPromedioPorcentajeVotosInfluenciaTelevisionRadioCandidatos() {
    	int totalVotosInfluenciadosPorTelevision = candidato1.darVotosInfluenciaTelevision() + candidato2.darVotosInfluenciaTelevision() + candidato3.darVotosInfluenciaTelevision();    	
    	return totalVotosInfluenciadosPorTelevision / 3;
    }
    
    
    /**
     * M�todo para la extensi�n 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}