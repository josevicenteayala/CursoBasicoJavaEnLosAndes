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
REM Autor: Pablo Barvo - 22/08/2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/
 
REM ---------------------------------------------------------
REM Ejecución del programa
REM ---------------------------------------------------------

cd..
java -classpath ./lib/empleado.jar uniandes.cupi2.empleado.interfaz.InterfazEmpleado
cd bin