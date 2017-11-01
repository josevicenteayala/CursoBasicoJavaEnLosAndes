/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Perro.java,v 1.7 2010/03/29 20:47:53 lr.ruiz114 Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_exposicionCanina 
 * Autor: Mario Sánchez - 26/08/2005 
 * Modificado por: Daniel Romero- 30/06/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.exposicionCanina.mundo;

/**
 * Es la clase que representa a un perro. <br>
 * <b>inv: </b> <br>
 * puntos >= 0 <br>
 * edad > 0 <br>
 * imagen != null <br>
 * nombre != null <br>
 * raza != null
 */
public class Perro
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    public static final int MENOR = 1;

	public static final int MAYOR = -1;

	public static final int IGUALES = 0;

	/**
     * El nombre del perro
     */
    private String nombre;

    /**
     * La raza del perro
     */
    private String raza;

    /**
     * La ruta hasta la imagen del perro
     */
    private String imagen;

    /**
     * Los puntos del perro en la exposición
     */
    private int puntos;

    /**
     * La edad en meses del perro
     */
    private int edad;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo perro con los parámetros indicados. <br>
     * <b>post: </b> Se construyó un perro con los parámetros especificados.
     * @param nombreP es el nombre del perro - nombreP != null
     * @param razaP es la raza del perro - razaP != null
     * @param imagenP es la ruta a la imagen del perro - imagenP != null
     * @param puntosP son los puntos del perro - puntosP >= 0
     * @param edadP es la edad en meses del perro - edadP > 0
     */
    public Perro( String nombreP, String razaP, String imagenP, int puntosP, int edadP )
    {
        nombre = nombreP;
        raza = razaP;
        imagen = imagenP;
        puntos = puntosP;
        edad = edadP;

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del perro.
     * @return Nombre del perro
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la raza del perro.
     * @return La raza del perro
     */
    public String darRaza( )
    {
        return raza;
    }

    /**
     * Retorna la ruta a la imagen del perro.
     * @return La imagen del perro
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Retorna los puntos del perro en la exposición.
     * @return Los puntos del perro en la exposición
     */
    public int darPuntos( )
    {
        return puntos;
    }

    /**
     * Retorna la edad en meses del perro.
     * @return La edad en meses del perro.
     */
    public int darEdad( )
    {
        return edad;
    }

    /**
     * Compara dos perros según el nombre. <br>
     * @param p es el perro contra el que se está comparando - p !=null
     * @return Retorna 0 si los perros tienen el mismo nombre. <br>
     *         Retorna -1 si el perro p tiene una valor "MAYOR" para el nombre. <br>
     *         Retorna 1 si el perro p tiene una valor "MENOR" para el nombre. <br>
     */
    public int compararPorNombre( Perro p )
    {
    	int valorComparacion = nombre.compareToIgnoreCase( p.nombre );
    	if(valorComparacion < IGUALES){
    		valorComparacion = MAYOR;
    	}else if(valorComparacion == IGUALES){
    		valorComparacion = IGUALES;
    	}else{
    		valorComparacion = 1;
    	}
        return valorComparacion;
    }

    /**
     * Compara dos perros según su raza. <br>
     * @param p es el perro contra el que se está comparando - p != null
     * @return Retorna 0 si los perros tienen la misma raza. <br>
     *         Retorna -1 si el perro p tiene una valor "MAYOR" para la raza. <br>
     *         Retorna 1 si el perro p tiene una valor "MENOR" para la raza. <br>
     */
    public int compararPorRaza( Perro p )
    {
        int valorComparacion = raza.compareToIgnoreCase( p.raza );
    	if(valorComparacion < IGUALES){
    		valorComparacion = MAYOR;
    	}else if(valorComparacion == IGUALES){
    		valorComparacion = IGUALES;
    	}else{
    		valorComparacion = MENOR;
    	}
        return valorComparacion;
    }

    /**
     * Compara dos perros según sus puntos. <br>
     * @param p El perro contra el que se está comparando - p!= null
     * @return Retorna 0 si los perros tienen los mismos puntos. <br>
     *         Retorna -1 si el perro p tiene una valor "MAYOR" para puntos . <br>
     *         Retorna 1 si el perro p tiene una valor "MENOR" para los puntos. <br>
     */
    public int compararPorPuntos( Perro p )
    {
        if( puntos == p.puntos )
            return IGUALES;
        else if( puntos > p.puntos )
            return MENOR;
        else
            return MAYOR;
    }

    /**
     * Compara dos perros según su edad. <br>
     * @param p El perro contra el que se está comparando - p!=null
     * @return Retorna 0 si los perros tienen la misma edad. <br>
     *         Retorna -1 si el perro p tiene una valor "MAYOR" para la edad. <br>
     *         Retorna 1 si el perro p tiene una valor "MENOR" para la edad. <br>
     */
    public int compararPorEdad( Perro p )
    {
        if( edad == p.edad )
            return IGUALES;
        else if( edad > p.edad )
            return MENOR;
        else
            return MAYOR;
    }

    /**
     * Retorna una cadena con el nombre del perro
     * @return La representación del perro en String
     */
    public String toString( )
    {
        return nombre + " (" + raza + ")";
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv: </b> altura > 0 y edad > 0 y imagen != null y nombre != null y raza != null
     */
    private void verificarInvariante( )
    {
        assert ( puntos >= IGUALES ) : "Los puntos no pueden ser menores a 0";
        assert ( edad > IGUALES ) : "La edad no puede ser 0";
        assert ( imagen != null ) : "La imagen no puede ser null";
        assert ( nombre != null ) : "El nombre no puede ser null";
        assert ( raza != null ) : "La raza no puede ser null";
    }
}