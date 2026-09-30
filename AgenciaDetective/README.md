# Agencia de Detectives

Laboratorio 2 - Arreglos y excepciones  
Curso: Introducción a la Programación Orientada a Objetos  
Universidad del Valle de Guatemala  
María Cajas - 26183

## Descripción

Programa de consola desarrollado en Java que permite administrar un caso de investigación, registrar ubicaciones y organizar las pistas encontradas.

Utiliza un arreglo básico para almacenar hasta cinco ubicaciones y un ArrayList para guardar una cantidad dinámica de pistas.

## Funcionalidades

- Crear un nuevo caso con nombre, código y detective responsable.
- Registrar, consultar, modificar y descartar ubicaciones.
- Registrar, consultar, buscar, modificar y eliminar pistas.
- Evitar el registro de pistas con códigos repetidos.
- Mostrar un reporte con cantidades, espacios disponibles, ubicación de mayor riesgo, pistas de mayor importancia y confiabilidad, y promedio de importancia.
- Manejar entradas incorrectas mediante try-catch y finally.

## Clases

| Clase | Función |
|---|---|
| Caso | Administra las ubicaciones, pistas y cálculos de la investigación. |
| Ubicacion | Almacena los datos de un lugar de investigación. |
| Pista | Almacena los datos de una evidencia encontrada. |
| App | Ejecuta el programa, muestra el menú y maneja la interacción con el usuario. |

## Validaciones

- Posiciones de ubicaciones entre 1 y 5.
- Registro de ubicaciones únicamente en posiciones disponibles.
- Nivel de riesgo e importancia entre 1 y 10.
- Nivel de confiabilidad entre 0 y 100.
- Códigos de pistas no repetidos.
- Comprobación de registros existentes antes de modificarlos o eliminarlos.
- Control de entradas numéricas incorrectas y colecciones vacías.

## Tecnologías

- Java.
- Visual Studio Code.
- Scanner, arreglos básicos y ArrayList.

## Ejecución

Se necesita un JDK instalado.

Desde Git Bash, dentro de la carpeta principal del proyecto, compilar:

    javac -encoding UTF-8 -d bin src/*.java

Ejecutar:

    java -cp bin App

El programa solicitará los datos del caso y mostrará un menú de trece opciones. Para finalizar, seleccionar la opción 13.
