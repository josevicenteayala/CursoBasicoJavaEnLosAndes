@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM $Id$
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación
REM Licenciado bajo el esquema Academic Free License version 2.1
REM
REM Proyecto Cupi2
REM Ejercicio: n1_empleado
REM Autor: Mario Sánchez - 14-Jun-2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/
 
REM ---------------------------------------------------------
REM Ejecución de las pruebas
REM ---------------------------------------------------------

java -classpath ../lib/empleado.jar;../test/lib/empleadoTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.empleado.test.EmpleadoTest
java -classpath ../lib/empleado.jar;../test/lib/empleadoTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.empleado.test.FechaTest