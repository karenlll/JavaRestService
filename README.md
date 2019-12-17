# JavaRestService

El presente proyecto se desarrollo bajo las siguientes condiciones:

IDE - Eclipse
Servidor - Tomcat 7

El proyecto es empaquetado como un war usando maven para administrar sus dependencias.

El proyecto tiene dos partes principales:

1. Los servicios expuestos:

  - Formatear un valor en las monedas US - India - China y France: Dado una valor double se utiliza la clase NumberFormat para devolver
  dicho número en los formatos antes mencionados. Se debe tener en cuenta que el número debe ser mayor o igual a 0 y menor o igual a 10
  elevado a la 9.
  
  - Obtener el nombre del día de la semana de una fecha: Dada una fecha en el formato MM DD YYYY se usa la clase LocalDate para determinar
  el día de la semana correspondiente para la fecha ingresada. Se debe tener en cuenta que el año debe ser mayor a 2000 y menor a 3000.

2. Los test de Junit de los servicios:

  - Se realizó un análisis de clases de equivalencia y valor límite para obtener un set de 7 pruebas para cada caso, incluyendo una prueba
  por formato de la entrada.
  
  Servicio 1 - Entrada: Valor a formatear - Clases Válidas: 0 , 1 , 999.999.999 y 1.000.000.000 - Clases no válidas: -1 , 1.000.000.001
  
  Servicio 2 - Entrada: Fecha - Clases Válidas: "10 11 2001","04 06 2999" - Clases no válidas: "12 20 1999","35 40 2000"," 10 25 3000","45 02 3001"
  
  
 Para ejecutar el proyecto se puede usar el comando mvn clean install - Se genera un war que se puede desplegar un servidor Apache
 
 Desde postman se pueden probar los servicios desplegados localmente usando:
 
 http://localhost:8080/ideamosRestService/services/dayOfWeek [FormParam] date: 08 05 2015
 
 http://localhost:8080/ideamosRestService/services/currencyFormat [FormParam] value: 12334.125
 
 
 
