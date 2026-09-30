import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Agencia de Detectives");

        Caso casoActual = crearCaso(scanner);
        int opcion = 0;

        do {
            mostrarMenu();

            try {
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        casoActual = crearCaso(scanner);
                        System.out.println("Caso creado exitosamente.");
                        break;

                    case 2:
                        registrarUbicacion(scanner, casoActual);
                        break;

                    case 3:
                        consultarUbicaciones(casoActual);
                        break;

                    case 4:
                        consultarUbicacion(scanner, casoActual);
                        break;

                    case 5:
                        modificarUbicacion(scanner, casoActual);
                        break;

                    case 6:
                        descartarUbicacion(scanner, casoActual);
                        break;

                    case 7:
                        registrarPista(scanner, casoActual);
                        break;

                    case 8:
                        consultarPistas(casoActual);
                        break;

                    case 9:
                        buscarPistas(scanner, casoActual);
                        break;

                    case 10:
                        modificarPista(scanner, casoActual);
                        break;

                    case 11:
                        eliminarPista(scanner, casoActual);
                        break;

                    case 12:
                        mostrarReporte(casoActual);
                        break;

                    case 13:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println(
                                "Debe seleccionar una opción entre 1 y 13."
                        );
                }

            } catch (InputMismatchException e) {
                System.out.println(
                        "Error: debe ingresar un número entero."
                );
                scanner.nextLine();

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Operación finalizada.");
            }

        } while (opcion != 13);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("1. Nuevo caso");
        System.out.println("2. Registrar ubicación");
        System.out.println("3. Consultar ubicaciones");
        System.out.println("4. Consultar una ubicación");
        System.out.println("5. Modificar ubicación");
        System.out.println("6. Descartar ubicación");
        System.out.println("7. Registrar pista");
        System.out.println("8. Consultar pistas");
        System.out.println("9. Buscar pistas");
        System.out.println("10. Modificar pista");
        System.out.println("11. Eliminar pista");
        System.out.println("12. Mostrar reporte del caso");
        System.out.println("13. Salir");
    }

    public static Caso crearCaso(Scanner scanner) {
        System.out.println("\nInformación del caso");

        System.out.print("Ingrese el nombre del caso: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el código de identificación del caso: ");
        String codigoIdentificacion = scanner.nextLine();

        System.out.print("Ingrese el nombre del detective responsable: ");
        String detectiveResponsable = scanner.nextLine();

        return new Caso(
                nombre, codigoIdentificacion, detectiveResponsable
        );
    }

    public static void registrarUbicacion(Scanner scanner, Caso caso) {
        System.out.println("\nRegistrar ubicación");

        System.out.print("Ingrese la posición (1-5): ");
        int posicion = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Ingrese el código de la ubicación: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese el nombre de la ubicación: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la dirección de la ubicación: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese el nivel de riesgo (1-10): ");
        int nivelRiesgo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el estado: ");
        String estado = scanner.nextLine();

        Ubicacion ubicacion = new Ubicacion(
                codigo, nombre, direccion, nivelRiesgo, estado
        );

        caso.registrarUbicacion(posicion, ubicacion);

        System.out.println("Ubicación registrada exitosamente.");
    }

    public static void consultarUbicaciones(Caso caso) {
        System.out.println("\nUbicaciones registradas");

        Ubicacion[] ubicaciones = caso.getUbicaciones();
        boolean ubicacionesRegistradas = false;

        for (int i = 0; i < ubicaciones.length; i++) {
            if (ubicaciones[i] != null) {
                System.out.println("\nPosición: " + (i + 1));
                System.out.println(ubicaciones[i]);
                ubicacionesRegistradas = true;
            }
        }

        if (!ubicacionesRegistradas) {
            System.out.println("No existen ubicaciones registradas.");
        }
    }

    public static void consultarUbicacion(Scanner scanner, Caso caso) {
        System.out.println("\nConsultar ubicación");

        System.out.print("Ingrese la posición (1-5): ");
        int posicion = scanner.nextInt() - 1;
        scanner.nextLine();

        Ubicacion ubicacion = caso.consultarUbicacion(posicion);

        System.out.println("Ubicación encontrada:");
        System.out.println(ubicacion);
    }

    public static void modificarUbicacion(Scanner scanner, Caso caso) {
        System.out.println("\nModificar ubicación");

        System.out.print("Ingrese la posición (1-5): ");
        int posicion = scanner.nextInt() - 1;
        scanner.nextLine();

        // Comprueba que la ubicación exista.
        caso.consultarUbicacion(posicion);

        System.out.print("Ingrese el nuevo nivel de riesgo (1-10): ");
        int nivelRiesgo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nuevo estado: ");
        String estado = scanner.nextLine();

        caso.modificarUbicacion(posicion, nivelRiesgo, estado);

        System.out.println("Ubicación modificada exitosamente.");
    }

    public static void descartarUbicacion(Scanner scanner, Caso caso) {
        System.out.println("\nDescartar ubicación");

        System.out.print("Ingrese la posición (1-5): ");
        int posicion = scanner.nextInt() - 1;
        scanner.nextLine();

        caso.descartarUbicacion(posicion);

        System.out.println("Ubicación descartada exitosamente.");
    }

    public static void registrarPista(Scanner scanner, Caso caso) {
        System.out.println("\nRegistrar pista");

        System.out.print("Ingrese el código de la pista: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese la descripción de la pista: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese el tipo de evidencia: ");
        String tipoEvidencia = scanner.nextLine();

        System.out.print("Ingrese el nivel de importancia (1-10): ");
        int nivelImportancia = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nivel de confiabilidad (0-100): ");
        int nivelConfiabilidad = scanner.nextInt();
        scanner.nextLine();

        Pista pista = new Pista(
                codigo,
                descripcion,
                tipoEvidencia,
                nivelImportancia,
                nivelConfiabilidad
        );

        caso.registrarPista(pista);

        System.out.println("Pista registrada exitosamente.");
    }

    public static void consultarPistas(Caso caso) {
        System.out.println("\nPistas registradas");

        ArrayList<Pista> pistas = caso.getPistas();

        if (pistas.isEmpty()) {
            System.out.println("No existen pistas registradas.");
        } else {
            for (int i = 0; i < pistas.size(); i++) {
                System.out.println("\nPista " + (i + 1) + ":");
                System.out.println(pistas.get(i));
            }
        }
    }

    public static void buscarPistas(Scanner scanner, Caso caso) {
        System.out.println("\nBuscar pista");

        System.out.print("Ingrese el código de la pista: ");
        String codigo = scanner.nextLine();

        Pista pista = caso.buscarPista(codigo);

        if (pista == null) {
            System.out.println("No se encontró una pista con ese código.");
        } else {
            System.out.println("Pista encontrada:");
            System.out.println(pista);
        }
    }

    public static void modificarPista(Scanner scanner, Caso caso) {
        System.out.println("\nModificar pista");

        System.out.print("Ingrese el código de la pista: ");
        String codigo = scanner.nextLine();

        Pista pista = caso.buscarPista(codigo);

        if (pista == null) {
            System.out.println("No se encontró una pista con ese código.");
            return;
        }

        System.out.print("Ingrese la nueva descripción: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese el nuevo tipo de evidencia: ");
        String tipoEvidencia = scanner.nextLine();

        System.out.print("Ingrese el nuevo nivel de importancia (1-10): ");
        int nivelImportancia = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nuevo nivel de confiabilidad (0-100): ");
        int nivelConfiabilidad = scanner.nextInt();
        scanner.nextLine();

        // Valida ambos niveles antes de modificar los datos.
        if (nivelImportancia < 1 || nivelImportancia > 10) {
            throw new IllegalArgumentException(
                    "El nivel de importancia debe estar entre 1 y 10."
            );
        }

        if (nivelConfiabilidad < 0 || nivelConfiabilidad > 100) {
            throw new IllegalArgumentException(
                    "El nivel de confiabilidad debe estar entre 0 y 100."
            );
        }

        caso.modificarPista(
                codigo,
                descripcion,
                tipoEvidencia,
                nivelImportancia,
                nivelConfiabilidad
        );

        System.out.println("Pista modificada exitosamente.");
    }

    public static void eliminarPista(Scanner scanner, Caso caso) {
        System.out.println("\nEliminar pista");

        System.out.print("Ingrese el código de la pista: ");
        String codigo = scanner.nextLine();

        caso.eliminarPista(codigo);

        System.out.println("Pista eliminada exitosamente.");
    }

    public static void mostrarReporte(Caso caso) {
        System.out.println("\nReporte del caso");

        System.out.println("Nombre del caso: " + caso.getNombre());
        System.out.println(
                "Código de identificación: "
                        + caso.getCodigoIdentificacion()
        );
        System.out.println(
                "Detective responsable: "
                        + caso.getDetectiveResponsable()
        );

        consultarUbicaciones(caso);

        System.out.println(
                "\nCantidad de ubicaciones registradas: "
                        + caso.contarUbicaciones()
        );
        System.out.println(
                "Espacios disponibles: "
                        + caso.contarEspaciosDisponibles()
        );

        Ubicacion ubicacionMayor = caso.obtenerUbicacionMayorRiesgo();

        if (ubicacionMayor != null) {
            System.out.println("\nUbicación con mayor nivel de riesgo:");
            System.out.println(ubicacionMayor);
        } else {
            System.out.println(
                    "No hay ubicaciones para determinar la de mayor riesgo."
            );
        }

        consultarPistas(caso);

        System.out.println(
                "\nCantidad de pistas registradas: "
                        + caso.getPistas().size()
        );

        if (caso.getPistas().isEmpty()) {
            System.out.println("No existen pistas para realizar cálculos.");
        } else {
            Pista pistaMayorImportancia =
                    caso.obtenerPistaMayorImportancia();

            System.out.println("\nPista con mayor importancia:");
            System.out.println(pistaMayorImportancia);

            Pista pistaMayorConfiabilidad =
                    caso.obtenerPistaMayorConfiabilidad();

            System.out.println("\nPista con mayor confiabilidad:");
            System.out.println(pistaMayorConfiabilidad);

            double promedioImportancia =
                    caso.calcularPromedioImportancia();

            System.out.printf(
                    "\nPromedio de importancia de las pistas: %.2f%n",
                    promedioImportancia
            );
        }
    }
}
