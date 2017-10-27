@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n
REM Licenciado bajo el esquema Academic Free License version 2.1
REM
REM Proyecto Cupi2
REM Ejercicio: n6_visorImagen
REM Autor: Mario S�nchez - 29-Jun-2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/

REM ---------------------------------------------------------
REM Ejecuci�n de la prueba
REM Archivo de ejecuci�n: visorImagen.jar
REM Clase principal: uniandes.cupi2.visorImagen.test.ImagenTest
REM ---------------------------------------------------------
cd ..

java -classpath ./lib/visorImagen.jar;./test/lib/visorImagenTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.visorImagen.test.ImagenTest

cd bin
