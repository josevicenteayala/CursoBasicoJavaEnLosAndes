@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Todos los derechos reservados 2005
REM
REM Proyecto Cupi2
REM Ejercicio: n7_muestra
REM Autor: Jorge Villalobos - 05-sep-2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

java -classpath ../lib/muestra.jar;../test/lib/muestraTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.muestra.test.MuestraTest