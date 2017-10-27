#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogotá - Colombia)
# Departamento de Ingeniería de Sistemas y Computación
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n1_elecciones
# Autor: Equipo Cupi2 2014
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecución de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/elecciones.jar:./test/lib/eleccionesTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.elecciones.test.UrnaTest
java -ea -classpath ./lib/elecciones.jar:./test/lib/eleccionesTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.elecciones.test.CandidatoTest
cd bin/mac

stty echo
