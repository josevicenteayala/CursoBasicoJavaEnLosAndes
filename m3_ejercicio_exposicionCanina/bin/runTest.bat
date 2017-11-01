@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogota - Colombia)
REM Departamento de Ingeniería de Sistemas y Computacion
REM Todos los derechos reservados 2005
REM
REM Proyecto Cupi2
REM Ejercicio: n8_exposicionCanina
REM Autor: Diana Puentes - 29-Ago-2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/

REM ---------------------------------------------------------
REM Ejecucion de la prueba
REM Archivo de ejecucion: exposicionCaninaTest.jar
REM ---------------------------------------------------------

cd..

java -classpath ./lib/exposicionCanina.jar;./test/lib/exposicionCaninaTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.exposicionCanina.test.ExposicionPerrosTest
java -classpath ./lib/exposicionCanina.jar;./test/lib/exposicionCaninaTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.exposicionCanina.test.PerroTest


