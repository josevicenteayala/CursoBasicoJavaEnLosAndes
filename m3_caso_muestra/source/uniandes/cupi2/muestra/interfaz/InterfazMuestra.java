/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazMuestra.java,v 1.13 2006/08/06 20:26:47 da-romer Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_muestra
 * Autor: Jorge Villalobos - 05-Sep-2005
 * Autor: Pablo Barvo - 26-Sep-2005
 * Autor: Mario Sánchez - 29-Jun-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.muestra.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.muestra.mundo.Muestra;
import uniandes.cupi2.muestra.mundo.MuestraOrdenada;

/**
 * Esta es la ventana principal de la aplicación.
 */
public class InterfazMuestra extends JFrame
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la muestra sobre la que se realizarán las pruebas
     */
    private Muestra muestra;

    /**
     * Es una muestra ordenada con los mismos valores que 'muestra'
     */
    private MuestraOrdenada muestraOrdenada;

    /**
     * Indica si las acciones que realizan los botones deben estar habilitadas;
     */
    private boolean botonesHabilitados;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con los datos de la Muestra
     */
    private PanelMuestra panelMuestra;

    /**
     * Panel de búsqueda
     */
    private PanelBusqueda panelBusqueda;

    /**
     * Panel de ordenamiento
     */
    private PanelOrdenamiento panelOrdenamiento;

    /**
     * Panel para mostrar los cálculos
     */
    private PanelCalculos panelCalculos;

    /**
     * Panel con el titulo
     */
    private PanelImagen panelImagen;

    /**
     * Panel con las opciones
     */
    private PanelExtension panelExtension;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la ventana principal.     
     */
    public InterfazMuestra( )
    {
        construirForma( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Este método sirve para construir la forma inicializando cada uno de los componentes. <br>
     * <b>pre: </b> La ventana está vacía. <br>
     * <b>post: </b> Se inicializaron los componentes gráficos de la aplicación.
     */
    private void construirForma( )
    {
        getContentPane( ).setLayout( new BorderLayout( ) );
        setSize( 530, 530 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "Manejo de muestras" );

        // Panel Imagen
        panelImagen = new PanelImagen( );
        getContentPane( ).add( panelImagen, BorderLayout.NORTH );

        JPanel panelMitad = new JPanel( new BorderLayout( ) );

        // Panel muestra
        panelMuestra = new PanelMuestra( this );
        panelMitad.add( panelMuestra, BorderLayout.NORTH );

        // Panel búsqueda
        panelBusqueda = new PanelBusqueda( this );
        panelMitad.add( panelBusqueda, BorderLayout.WEST );

        // Panel ordenamiento
        panelOrdenamiento = new PanelOrdenamiento( this );
        panelMitad.add( panelOrdenamiento, BorderLayout.EAST );

        // Panel calculos
        panelCalculos = new PanelCalculos( this );
        panelMitad.add( panelCalculos, BorderLayout.SOUTH );

        getContentPane( ).add( panelMitad, BorderLayout.CENTER );

        // Panel Opciones
        panelExtension = new PanelExtension( this );
        getContentPane( ).add( panelExtension, BorderLayout.SOUTH );

        pack( );

        botonesHabilitados = true;
    }

    /**
     * Calcula el tiempo de una búsqueda secuencial en la muestra
     */
    public void busquedaSecuencial( )
    {
        if( botonesHabilitados )
        {
            if( muestra == null )
            {
                JOptionPane.showMessageDialog( this, "Debe crear una muestra primero", "Error", JOptionPane.INFORMATION_MESSAGE );
            }
            else
            {
                TareaBusquedaSecuencial tarea = new TareaBusquedaSecuencial( muestra, this );
                VentanaProgreso progreso = new VentanaProgreso( this, "Progreso de la Búsqueda Secuencial", "Buscando...", tarea );

                ThreadIniciarTarea t = new ThreadIniciarTarea( progreso );
                t.start( );
            }
        }
    }

    /**
     * Calcula el tiempo de una búsqueda binaria en la muestra
     */
    public void busquedaBinaria( )
    {
        if( botonesHabilitados )
        {
            TareaBusquedaBinaria tarea = new TareaBusquedaBinaria( muestraOrdenada, this );
            VentanaProgreso progreso = new VentanaProgreso( this, "Progreso de la Búsqueda Binaria", "Buscando...", tarea );

            ThreadIniciarTarea t = new ThreadIniciarTarea( progreso );
            t.start( );
        }
    }

    /**
     * Ordena la muestra utilizando el algoritmo de inserción
     */
    public void ordenarInsercion( )
    {
        if( botonesHabilitados )
        {
            TareaOrdenarInsercion tarea = new TareaOrdenarInsercion( muestra, this );
            VentanaProgreso progreso = new VentanaProgreso( this, "Progreso del Ordenamiento", "Ordenando...", tarea );

            ThreadIniciarTarea t = new ThreadIniciarTarea( progreso );
            t.start( );
        }
    }

    /**
     * Ordena la muestra utilizando el algoritmo de Selección
     */
    public void ordenarSeleccion( )
    {
        if( botonesHabilitados )
        {
            TareaOrdenarSeleccion tarea = new TareaOrdenarSeleccion( muestra, this );
            VentanaProgreso progreso = new VentanaProgreso( this, "Progreso del Ordenamiento", "Ordenando...", tarea );

            ThreadIniciarTarea t = new ThreadIniciarTarea( progreso );
            t.start( );
        }
    }

    /**
     * Ordena la muestra utilizando el algoritmo de burbuja
     */
    public void ordenarBurbuja( )
    {
        if( botonesHabilitados )
        {
            TareaOrdenarBurbuja tarea = new TareaOrdenarBurbuja( muestra, this );
            VentanaProgreso progreso = new VentanaProgreso( this, "Progreso del Ordenamiento", "Ordenando...", tarea );

            ThreadIniciarTarea t = new ThreadIniciarTarea( progreso );
            t.start( );
        }
    }

    /**
     * Crea una nueva muestra para realizar operaciones
     */
    public void nuevaMuestra( )
    {
        if( botonesHabilitados )
        {
            String strTamano = JOptionPane.showInputDialog( this, "Ingrese el número de elementos en la muestra", "Número de Elementos", JOptionPane.QUESTION_MESSAGE );
            if( strTamano != null )
            {
                try
                {
                    int tamano = Integer.parseInt( strTamano );
                    if( tamano <= 0 )
                    {
                        JOptionPane.showMessageDialog( this, "El tamaño de la muestra debe ser de al menos un elemento", "Error", JOptionPane.INFORMATION_MESSAGE );
                    }
                    else
                    {

                        String strLimite = JOptionPane.showInputDialog( this, "Ingrese el límite superior para los valores de la muestra", "Límite Superior", JOptionPane.QUESTION_MESSAGE );
                        if( strLimite != null )
                        {
                            int limite = Integer.parseInt( strLimite );
                            if( limite <= 0 )
                            {
                                JOptionPane.showMessageDialog( this, "El límite superior para los valores la muestra debe ser un entero positivo ", "Error", JOptionPane.INFORMATION_MESSAGE );
                            }

                            else
                            {
                                muestra = new Muestra( tamano, limite );
                                muestra.generarValores( );
                                muestraOrdenada = null;

                                panelMuestra.refrescarDatos( muestra );
                                panelBusqueda.limpiarTiempos( );
                                panelBusqueda.desactivarBusquedaBinaria( );
                                panelBusqueda.activarBusquedaSecuencial( );
                                panelOrdenamiento.limpiarTiempos( );
                                panelOrdenamiento.activarBotones( );
                                panelCalculos.limpiarValores( );
                                panelCalculos.desactivarBotones( );
                            }
                        }
                    }
                }

                catch( NumberFormatException e )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar un valor numérico", "Error", JOptionPane.INFORMATION_MESSAGE );
                }
            }
        }
    }
    /**
     * Calcula y muestra el número de elementos que hay en un rango
     */
    public void contarElementosEnRango( )
    {
        if( botonesHabilitados )
        {
            String strLimiteInferior = JOptionPane.showInputDialog( this, "Ingrese el límite inferior para el rango de búsqueda", "Límite Inferior", JOptionPane.QUESTION_MESSAGE );

            if( strLimiteInferior != null )
            {
                String strLimiteSuperior = JOptionPane.showInputDialog( this, "Ingrese el límite superior para el rango de búsqueda", "Límite Superior", JOptionPane.QUESTION_MESSAGE );

                if( strLimiteSuperior != null )
                {
                    try
                    {
                        int limiteInferior = Integer.parseInt( strLimiteInferior );
                        int limiteSuperior = Integer.parseInt( strLimiteSuperior );

                        long tiempoTotal = 0;
                        long t1 = System.currentTimeMillis( );

                        int elementosEnRango = muestraOrdenada.contarElementosEnRango( limiteInferior, limiteSuperior );

                        long t2 = System.currentTimeMillis( );
                        tiempoTotal += ( t2 - t1 );

                        panelCalculos.cambiarNumeroElementosRango( elementosEnRango, tiempoTotal );
                    }
                    catch( NumberFormatException e )
                    {
                        JOptionPane.showMessageDialog( this, "Debe ingresar un valor numérico", "Error", JOptionPane.INFORMATION_MESSAGE );
                    }
                }

            }

        }
    }

    /**
     * Calcula y muestra el número de ocurrencias de un valor en la muestra
     */
    public void contarOcurrencias( )
    {
        if( botonesHabilitados )
        {

            String strNumeroBuscado = JOptionPane.showInputDialog( this, "Ingrese el número para el que se van a contar las ocurrencias", "Número Buscado", JOptionPane.QUESTION_MESSAGE );

            if( strNumeroBuscado != null )
            {
                try
                {
                    int numeroBuscado = Integer.parseInt( strNumeroBuscado );

                    long tiempoTotal = 0;
                    long t1 = System.currentTimeMillis( );

                    int ocurrencias = muestraOrdenada.contarOcurrencias( numeroBuscado );

                    long t2 = System.currentTimeMillis( );
                    tiempoTotal += ( t2 - t1 );

                    panelCalculos.cambiarNumeroOcurrencias( ocurrencias, tiempoTotal );
                }
                catch( NumberFormatException e )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar un valor numérico", "Error", JOptionPane.INFORMATION_MESSAGE );
                }
            }
        }
    }

    /**
     * Calcula y muestra el número de valores distintos en la muestra
     */
    public void contarValoresDistintos( )
    {
        if( botonesHabilitados )
        {
            long tiempoTotal = 0;
            long t1 = System.currentTimeMillis( );

            int valoresDistintos = muestraOrdenada.contarValoresDistintos( );

            long t2 = System.currentTimeMillis( );
            tiempoTotal += ( t2 - t1 );

            panelCalculos.cambiarNumeroValoresDistintos( valoresDistintos, tiempoTotal );
        }
    }

    /**
     * Calcula y muestra el valor más frecuente en la muestra
     */
    public void calcularValorMasFrecuente( )
    {
        if( botonesHabilitados )
        {
            long tiempoTotal = 0;
            long t1 = System.currentTimeMillis( );

            int valorMasFrecuente = muestraOrdenada.darValorMasFrecuente( );

            long t2 = System.currentTimeMillis( );
            tiempoTotal += ( t2 - t1 );

            panelCalculos.cambiarValorMasFrecuente( valorMasFrecuente, tiempoTotal );
        }
    }

    /**
     * Este método establece cual será la muestra ordenada. <br>
     * Cuando se establece la muestra ordenada se activan las opciones que requieren de una muestra ordenada para funcionar.
     * @param muestra La muestra que ahora será la muestra ordenada usada.
     */
    public void cambiarMuestraOrdenada( MuestraOrdenada muestra )
    {
        muestraOrdenada = muestra;

        if( muestraOrdenada == null )
        {
            panelBusqueda.desactivarBusquedaBinaria( );
            panelCalculos.desactivarBotones( );
        }
        else
        {
            panelBusqueda.activarBusquedaBinaria( );
            panelCalculos.activarBotones( );
        }
    }

    /**
     * Habilita los botones de la ventana
     */
    public void habilitarBotones( )
    {
        botonesHabilitados = true;
    }

    /**
     * Deshabilita los botones de la ventana
     */
    public void deshabilitarBotones( )
    {
        botonesHabilitados = false;
    }

    /**
     * Registra el tiempo que tomó el algoritmo de inserción
     * @param tiempo es el tiempo que será mostrado
     */
    public void registrarTiempoOrdenamientoInsercion( long tiempo )
    {
        panelOrdenamiento.cambiarTiempoInsercion( tiempo );
    }

    /**
     * Registra el tiempo que tomó el algoritmo de burbuja
     * @param tiempo es el tiempo que será mostrado
     */
    public void registrarTiempoOrdenamientoBurbuja( long tiempo )
    {
        panelOrdenamiento.cambiarTiempoBurbuja( tiempo );
    }

    /**
     * Registra el tiempo que tomó el algoritmo de selección
     * @param tiempo es el tiempo que será mostrado
     */
    public void registrarTiempoOrdenamientoSeleccion( long tiempo )
    {
        panelOrdenamiento.cambiarTiempoSeleccion( tiempo );
    }

    /**
     * Registra el tiempo promedio que tomó una búsqueda secuencial
     * @param tiempo es el tiempo que será mostrado
     */
    public void registrarTiempoBusquedaSecuencial( double tiempo )
    {
        panelBusqueda.cambiarTiempoSecuencial( tiempo );
    }

    /**
     * Registra el tiempo promedio que tomó una búsqueda binaria
     * @param tiempo es el tiempo que será mostrado
     */
    public void registrarTiempoBusquedaBinaria( double tiempo )
    {
        panelBusqueda.cambiarTiempoBinaria( tiempo );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        if( muestra != null )
        {
            String resultado = muestra.metodo1( );
            JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        if( muestra != null )
        {
            String resultado = muestra.metodo2( );
            JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Método para la extensión 3
     */
    public void reqFuncOpcion3( )
    {
        if( muestra != null )
        {
            String resultado = muestra.metodo3( );
            JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    /**
     * Método para la extensión 4
     */
    public void reqFuncOpcion4( )
    {
        if( muestra != null )
        {
            String resultado = muestra.metodo4( );
            JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args son los argumentos de la aplicación. No se requiere ninguno.
     */
    public static void main( String[] args )
    {

        InterfazMuestra interfaz = new InterfazMuestra( );
        interfaz.setVisible( true );
    }
}