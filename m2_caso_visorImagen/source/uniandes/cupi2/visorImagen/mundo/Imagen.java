/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_visorImagen 
 * Autor: Katalina Marcos
 * Modificaci�n: Mario S�nchez - 28/06/2005
 * Modificaci�n: Pablo Barvo - 1-Sep-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.visorImagen.mundo;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

/**
 * Imagen de mapa de colores
 */
public class Imagen {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Ancho m�ximo de la imagen
	 */
	public static final int ANCHO_MAXIMO = 400;

	/**
	 * Alto m�ximo de la imagen
	 */
	public static final int ALTO_MAXIMO = 300;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Matriz de colores de la imagen
	 */
	private Color bitmap[][];

	/**
	 * Ancho de la imagen
	 */
	private int ancho;

	/**
	 * Alto de la imagen
	 */
	private int alto;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea una imagen a partir de la ruta del archivo donde esta la imagen original
	 * en BMP. La imagen numera los p�xeles desde la esquina superior izquierda de
	 * la imagen con (0,0). La coordenada X ve de 0 hasta el ancho-1 y la coordenada
	 * Y va de 0 a el alto-1 Si la imagen es de ancho mayor al ANCHO_MAXIMO o con
	 * altura mayor a ALTO_MAXIMO, la imagen se recorta hasta los l�mites.
	 * 
	 * @param archivo
	 *            Nombre y ruta del archivo. archivo != null.
	 * @throws IOException
	 *             Error al leer el archivo
	 */
	public Imagen(String archivo) throws IOException {
		bitmap = new Color[ALTO_MAXIMO][ANCHO_MAXIMO];
		cargarImagen(archivo);
	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Retorna el color de un p�xel seg�n su ubicaci�n en la imagen
	 * 
	 * @param x
	 *            Coordenada horizontal
	 * @param y
	 *            Coordenada vertical
	 * @return el color del p�xel de coordenadas (x,y) o null en caso de que las
	 *         coordenadas no est�n sobrepasen los l�mites de la imagen.
	 */
	public Color darColorPixel(int x, int y) {
		if (x >= ancho || y >= alto)
			return null;
		else
			return bitmap[y][x];
	}

	/**
	 * Retorna el alto en p�xeles de la imagen
	 * 
	 * @return alto
	 */
	public int darAlto() {
		return alto;
	}

	/**
	 * Retorna el ancho en p�xeles de la imagen
	 * 
	 * @return ancho
	 */
	public int darAncho() {
		return ancho;
	}

	/**
	 * Carga la imagen que se encuentra en el archivo
	 * 
	 * @param nombreArchivo
	 *            - nombre y ruta del archivo
	 * @throws IOException
	 *             Error al cargar la imagen
	 */
	private void cargarImagen(String nombreArchivo) throws IOException {
		File archivo = new File(nombreArchivo);
		BufferedImage bmp;

		try {
			bmp = ImageIO.read(archivo);
		} catch (IOException e) {
			throw new IOException("No se encuentra la imagen");
		}

		if (bmp.getWidth() < ANCHO_MAXIMO)
			ancho = bmp.getWidth();
		else
			ancho = ANCHO_MAXIMO;

		if (bmp.getHeight() < ALTO_MAXIMO)
			alto = bmp.getHeight();
		else
			alto = ALTO_MAXIMO;

		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++) {
				bitmap[i][j] = new Color(bmp.getRGB(j, i));
			}
	}

	/**
	 * Retorna el mapa de bits como una BufferdImage
	 * 
	 * @return imagen como objeto BufferedImage
	 */
	public BufferedImage darImagenBuffer() {
		BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++) {
				imagen.setRGB(j, i, bitmap[i][j].getRGB());
			}
		return imagen;
	}

	/**
	 * Negativo de la imagen: El negativo se calcula cambiando cada componente RGB,
	 * tomando el valor absoluto de restarle al componente 255.
	 */
	public void convertirNegativo() {
		// Recorre la matriz y calcula los componentes del nuevo color
		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++) {
				Color colorViejo = bitmap[i][j];
				int nuevoR = Math.abs(colorViejo.getRed() - 255);
				int nuevoG = Math.abs(colorViejo.getGreen() - 255);
				int nuevoB = Math.abs(colorViejo.getBlue() - 255);
				bitmap[i][j] = new Color(nuevoR, nuevoG, nuevoB);
			}
	}

	/**
	 * Reflejar imagen: Consiste en intercambiar las columnas enteras de la imagen,
	 * de las finales a la iniciales
	 */
	public void reflejarImagen() {
		// Recorre la matriz hasta la mitad para intercambiar los colores de la columna
		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho / 2; j++) {
				Color temporal = bitmap[i][j];
				bitmap[i][j] = bitmap[i][ancho - 1 - j];
				bitmap[i][ancho - 1 - j] = temporal;
			}
	}

	/**
	 * Reflejar imagen vertical: Consiste en intercambiar las filas enteras de la
	 * imagen, de las finales a la iniciales
	 */
	public void reflejarImagenVertical() {
		// Recorre la matriz hasta la mitad para intercambiar los colores de la columna
		for (int i = 0; i < alto / 2; i++)
			for (int j = 0; j < ancho; j++) {
				Color temporal = bitmap[i][j];
				bitmap[i][j] = bitmap[i][alto - 1 - i];
				bitmap[i][alto - 1 - i] = temporal;
			}
	}

	/**
	 * Binarizaci�n: Consiste en llevar cada p�xel de una imagen a negro o
	 * blanco. Para ello se requiere un umbral: si el color del p�xel est� por
	 * encima o igual se lleva a blanco y si est� por debajo se lleva a negro.
	 * 
	 * @param umbral
	 *            Umbral para la binarizaci�n.
	 */
	public void binarizarImagen(double umbral) {
		// Recorre la matriz de la imagen. Aquellos puntos con color menor o
		// igual al umbral los lleva a blanco y los mayores al negro.
		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++) {
				Color pixel = bitmap[i][j];
				int promedio = (pixel.getBlue() + pixel.getGreen() + pixel.getRed()) / 3;
				if (promedio < umbral)
					bitmap[i][j] = Color.BLACK;
				else
					bitmap[i][j] = Color.WHITE;
			}
	}

	/**
	 * Pixelamiento: Consiste en dividir la imagen en peque�as regiones de
	 * p�xeles y para cada una de esas regiones cambiar el color de los p�xeles
	 * al color promedio de dicha regi�n. En este ejemplo, la regi�n se
	 * dimensiona con los divisores m�s peque�os del ancho y el alto de la
	 * imagen
	 */
	public void pixelarImagen() {
		// Los p�xeles son divisores de las dimensiones de la imagen
		int anchoPixel = menorDivisorMayorAUno(ancho);
		int altoPixel = menorDivisorMayorAUno(alto);

		// Recorre la matriz por regiones para modificarla
		for (int x = 0; x < ancho; x += anchoPixel) {
			for (int y = 0; y < alto; y += altoPixel) {
				// Obtiene el color medio de la regi�n
				Color colorPromedio = colorPromedio(x, y, x + anchoPixel - 1, y + altoPixel - 1);
				// Cambia el color de la regi�n al promedio
				cambiarColorRegion(colorPromedio, x, y, x + anchoPixel - 1, y + altoPixel - 1);
			}
		}
	}

	/**
	 * Escala de grises: Para ello promedia los componentes de cada p�xel y crea
	 * un nuevo color donde cada componente (RGB) tiene el valor de dicho promedio
	 */
	public void convertirAGrises() {
		// Recorre la matriz de la imagen. para pasarla a gris.
		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++) {
				int rgbGris = (bitmap[i][j].getBlue() + bitmap[i][j].getGreen() + bitmap[i][j].getRed()) / 3;
				bitmap[i][j] = new Color(rgbGris, rgbGris, rgbGris);
			}
	}

	/**
	 * Convoluci�n: Opera la imagen con la matriz de convoluci�n dada por el
	 * usuario
	 * 
	 * @param convolucion
	 *            Matriz cuadrada de dimensi�n impar. convolucion != null.
	 * @param dimension
	 *            Dimensi�n de la matriz de convoluci�n. dimension es v�lido
	 *            para el contenido de la matriz.
	 */
	public void aplicarOperadorConvolucion(double[][] convolucion, int dimension) {
		// Obtiene una copia de la imagen original, pero con un marco
		// de p�xeles negros para operar f�cilmente las esquinas de la imagen
		// con la matriz de convoluci�n
		Color copiaBorde[][] = copiarConBorde(dimension / 2);

		// Calcula la suma de los factores de convoluci�n
		double sumaConvolucion = 0;
		for (int i = 0; i < dimension; i++)
			for (int j = 0; j < dimension; j++)
				sumaConvolucion += convolucion[i][j];

		// Recorre la matriz de p�xeles para cambiar la imagen
		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++) {
				// Para cada p�xel realiza el c�lculo recorriendo la matriz de convoluci�n
				double sumaRed = 0;
				double sumaGreen = 0;
				double sumaBlue = 0;

				// La divisi�n se hace en la mayor�a de los casos (excepto en los bordes)
				// Restando sobre la suma de los factores de convoluci�n
				double divisor = sumaConvolucion;

				// La suma se hace con los p�xeles de la imagen original
				for (int k = -dimension / 2; k <= dimension / 2; k++)
					for (int l = -dimension / 2; l <= dimension / 2; l++) {
						sumaRed += convolucion[k + dimension / 2][l + dimension / 2]
								* copiaBorde[i + k + dimension / 2][j + l + dimension / 2].getRed();
						sumaGreen += convolucion[k + dimension / 2][l + dimension / 2]
								* copiaBorde[i + k + dimension / 2][j + l + dimension / 2].getGreen();
						sumaBlue += convolucion[k + dimension / 2][l + dimension / 2]
								* copiaBorde[i + k + dimension / 2][j + l + dimension / 2].getBlue();

						// Si es un p�xel del borde no cuenta para el divisor
						if (i + l < 0 || i + l > alto || j + k < 0 || j + k > ancho)
							divisor -= convolucion[k + dimension / 2][l + dimension / 2];
					}

				if (divisor > 0) {
					sumaRed /= divisor;
					sumaGreen /= divisor;
					sumaBlue /= divisor;

					if (sumaRed > 255)
						sumaRed = 255;
					else if (sumaRed < 0)
						sumaRed = 0;

					if (sumaGreen > 255)
						sumaGreen = 255;
					else if (sumaGreen < 0)
						sumaGreen = 0;

					if (sumaBlue > 255)
						sumaBlue = 255;
					else if (sumaBlue < 0)
						sumaBlue = 0;

					// Cambia el p�xel en la imagen
					bitmap[i][j] = new Color((int) sumaRed, (int) sumaGreen, (int) sumaBlue);
				} else {
					if (sumaRed > 255)
						sumaRed = 255;
					else if (sumaRed < 0)
						sumaRed = 0;

					if (sumaGreen > 255)
						sumaGreen = 255;
					else if (sumaGreen < 0)
						sumaGreen = 0;

					if (sumaBlue > 255)
						sumaBlue = 255;
					else if (sumaBlue < 0)
						sumaBlue = 0;

					// Cambia el p�xel en la imagen
					bitmap[i][j] = new Color((int) sumaRed, (int) sumaGreen, (int) sumaBlue);
				}
			}
	}

	/**
	 * Retorna el color promedio de la imagen
	 * 
	 * @return color promedio de toda la imagen
	 */
	public Color colorPromedio() {
		return colorPromedio(0, 0, ancho - 1, alto - 1);
	}

	/**
	 * Busca el color promedio de la regi�n de la imagen El color promedio es
	 * formado por los promedios de rojos, verdes y azules de cada p�xel
	 * 
	 * @param xInicial
	 *            Coordenada x del p�xel de inicio.
	 * @param yInicial
	 *            Coordenada y del p�xel de inicio.
	 * @param xFinal
	 *            Coordenada x del p�xel final.
	 * @param yFinal
	 *            Coordenada y del p�xel final.
	 * @return Color promedio de la regi�n.
	 */
	private Color colorPromedio(int xInicial, int yInicial, int xFinal, int yFinal) {
		int valorMedioRojo = 0, valorMedioVerde = 0, valorMedioAzul = 0;
		int totalPixeles = (xFinal - xInicial + 1) * (yFinal - yInicial + 1);

		// Recorre la regi�n para promediar los componentes de los colores
		for (int i = yInicial; i <= yFinal; i++)
			for (int j = xInicial; j <= xFinal; j++) {
				valorMedioRojo += bitmap[i][j].getRed();
				valorMedioVerde += bitmap[i][j].getGreen();
				valorMedioAzul += bitmap[i][j].getBlue();
			}

		valorMedioRojo /= totalPixeles;
		valorMedioVerde /= totalPixeles;
		valorMedioAzul /= totalPixeles;
		return new Color(valorMedioRojo, valorMedioVerde, valorMedioAzul);
	}

	/**
	 * Calcula el menor divisor del n�mero dado que sea mayor a 1.
	 * 
	 * @param numero
	 *            al que se le buscar� el divisor.
	 * @return menor divisor mayor a uno del n�mero
	 */
	private int menorDivisorMayorAUno(int numero) {
		boolean encontrado = false;
		int divisor = 2;

		// Si el n�mero es par el divisor menor es 2
		if (numero % divisor == 0)
			return divisor;

		else {
			// Si el n�mero es impar le busca un divisor impar
			divisor = 3;
			while (divisor < numero && !encontrado) {
				if (numero % divisor == 0)
					encontrado = true;
				else
					divisor += 2;
			}
			return divisor;
		}
	}

	/**
	 * Cambia el color de los p�xeles de la regi�n al dado como par�metro
	 * 
	 * @param color
	 *            Color de la nueva regi�n
	 * @param xInicial
	 *            Coordenada x del p�xel de inicio
	 * @param yInicial
	 *            Coordenada y del p�xel de inicio
	 * @param xFinal
	 *            Coordenada x del p�xel final
	 * @param yFinal
	 *            Coordenada y del p�xel final
	 */
	private void cambiarColorRegion(Color color, int xInicial, int yInicial, int xFinal, int yFinal) {
		for (int i = yInicial; i <= yFinal && i < alto; i++)
			for (int j = xInicial; j <= xFinal && j < ancho; j++) {
				bitmap[i][j] = color;
			}
	}

	/**
	 * Crea una copia de la imagen pero le adiciona un borde de p�xeles de color
	 * negro, esto con el fin de poder operar con m�s facilidad la matriz de
	 * convoluci�n con las esquinas de la imagen, y sin alterar el resultado de
	 * los bordes
	 * 
	 * @param borde
	 *            ancho en p�xeles del borde (sobre un lado)
	 * @return copia de la imagen (mapa de colores)
	 */
	private Color[][] copiarConBorde(int borde) {
		// Crea una copia de la imagen original que incluye un marco de p�xeles negros
		Color[][] copia = new Color[alto + 2 * borde][ancho + 2 * borde];

		// Recorre la imagen pero incluye el borde
		for (int i = 0; i < alto + borde * 2; i++)
			for (int j = 0; j < ancho + borde * 2; j++) {
				// Si el p�xel es del borde, es de color negro
				if (i < borde || i >= alto + borde || j < borde || j >= ancho + borde)
					copia[i][j] = Color.BLACK;
				else
					// Si no lo toma de la imagen
					copia[i][j] = new Color(bitmap[i - borde][j - borde].getRGB());
			}
		return copia;
	}

	/**
	 * Retorna el número de pixeles que tienen el color dado como parámetro
	 * 
	 * @param colorBuscado
	 *            - Color de los pixeles a contar
	 * @return - Número de pixeles en la imagen con el color dado
	 */
	public int cuantosPixelColor(Color colorBuscado) {
		int numeroPixelesDeColorDeterminado = 0;
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				Color color = bitmap[i][j];
				if (color.equals(colorBuscado)) {
					numeroPixelesDeColorDeterminado++;
				}
			}
		}
		return numeroPixelesDeColorDeterminado;
	}

	/**
	 * Retorna la tendencia de color de la imagen. Un pixel tiene un color de
	 * tendencia roja si su índice es mayor que los otros dos; lo mismo sucede para
	 * los otros componentes. La tendencia de color de la imagen está definida
	 * entonces como el componente que tenga más pixeles con tendencia a ese color.
	 * 
	 * @return - Tendencia de color de la imagen. Los posibles valores son: 0 si la
	 *         imagen no presenta ninguna tendencia 1 si la tendencia es roja 2 si
	 *         la tendencia es verde 3 si la tendencia es azul
	 */
	public int calcularTendencia() {
		int tendencia = 0;
		final int TENDENCIA_ROJA = 1;
		final int TENDENCIA_VERDE = 2;
		final int TENDENCIA_AZUL = 3;

		int cantidadRojo = 0;
		int cantidadVerde = 0;
		int cantidadAzul = 0;
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				Color color = bitmap[i][j];
				cantidadRojo += color.getRed();
				cantidadVerde += color.getGreen();
				cantidadAzul += color.getBlue();
			}
		}
		if (cantidadRojo > cantidadAzul) {
			tendencia = TENDENCIA_ROJA;
			if (cantidadRojo < cantidadVerde) {
				tendencia = TENDENCIA_VERDE;
			}
		} else if (cantidadAzul > cantidadVerde) {
			tendencia = TENDENCIA_AZUL;
		}

		return tendencia;
	}

	/**
	 * Método que verifica si la imagen es oscura. Una imagen es oscura si más del
	 * 60% de sus pixeles tienen componentes RGB menores a 10.
	 */
	public boolean esOscuraLaImagen() {

		final int PORCENTAJE_OSCURO_MINIMO = 60;
		int cantidadPixelesOscuros = 0;
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				Color color = bitmap[i][j];
				if (color.getRed() + color.getGreen() + color.getBlue() < 10) {
					cantidadPixelesOscuros++;
				}
			}
		}
		int totalPixeles = alto * ancho;
		double porcenjajeOscuro = cantidadPixelesOscuros / totalPixeles * 100;
		return porcenjajeOscuro > PORCENTAJE_OSCURO_MINIMO;
	}

	/**
	 * Rota la imagen 90 grados hacia la izquierda
	 */
	public void rotar90ALaIzquierda() {
		Color bitmapImagenRotada[][] = new Color[ancho][alto];
		int filaNuevoArreglo = 0;
		for (int columna = ancho - 1; columna > -1; columna--) {
			for (int fila = 0; fila < alto; fila++) {
				Color color = bitmap[fila][columna];
				bitmapImagenRotada[filaNuevoArreglo][fila] = color;
			}
			filaNuevoArreglo++;
		}
		bitmap = bitmapImagenRotada;
		int anchoTemporal = ancho;
		ancho = alto;
		alto = anchoTemporal;

	}

	/**
	 * Rota la imagen 90 grados hacia la derecha
	 */
	public void rotar90ALaDerecha() {
		Color bitmapImagenRotada[][] = new Color[ancho][alto];
		int filaNuevoArreglo = 0;
		int nuevaColumna = alto - 1;
		for (int columna = 0; columna < ancho; columna++) {
			for (int fila = 0; fila < alto; fila++) {
				Color color = bitmap[fila][columna];
				bitmapImagenRotada[filaNuevoArreglo][nuevaColumna--] = color;
			}
			filaNuevoArreglo++;
			nuevaColumna = alto - 1;

		}
		bitmap = bitmapImagenRotada;
		int anchoTemporal = ancho;
		ancho = alto;
		alto = anchoTemporal;

	}

	// -----------------------------------------------------------------
	// Puntos de Extensi�n
	// -----------------------------------------------------------------

	/**
	 * M�todo de extensi�n 1
	 * 
	 * @return Respuesta 1
	 */
	public String metodo1() {
		return "Respuesta1 ";
	}

	/**
	 * M�todo de extensi�n 2
	 * 
	 * @return Respuesta 2
	 */
	public String metodo2() {
		return "Respuesta 2";
	}
}