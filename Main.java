import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<MaterialBibliografico> materiales = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n=== BIBLIOTECA - MENU PRINCIPAL ===");
            System.out.println("1. Agregar material");
            System.out.println("2. Listar materiales");
            System.out.println("3. Simular préstamo (mostrar multa por retraso)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción (1-4): ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un número válido.");
                scanner.nextLine();
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarMaterial(materiales, scanner);
                    break;
                case 2:
                    listarMateriales(materiales);
                    break;
                case 3:
                    simularPrestamo(materiales, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    if (opcion != 0) {
                        System.out.println("Opción no válida.");
                    }
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void agregarMaterial(ArrayList<MaterialBibliografico> materiales, Scanner scanner) {
        System.out.println("\n--- Agregar Nuevo Material ---");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("3. Película");
        System.out.print("Seleccione el tipo de material (1-3): ");
        int tipo = leerEntero(scanner);

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo de material no reconocido.");
            return;
        }

        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine();

        switch (tipo) {
            case 1:
                System.out.print("Ingrese el autor: ");
                String autor = scanner.nextLine();
                System.out.print("Ingrese el número de páginas: ");
                int paginas = leerEntero(scanner);
                materiales.add(new Libro(titulo, autor, paginas));
                System.out.println("Libro agregado exitosamente.");
                break;
            case 2:
                System.out.print("Ingrese la periodicidad (mensual/semanal): ");
                String periodicidad = scanner.nextLine();
                System.out.print("Ingrese el número de edición: ");
                int edicion = leerEntero(scanner);
                materiales.add(new Revista(titulo, periodicidad, edicion));
                System.out.println("Revista agregada exitosamente.");
                break;
            case 3:
                System.out.print("Ingrese el director: ");
                String director = scanner.nextLine();
                System.out.print("Ingrese la duración (minutos): ");
                int duracion = leerEntero(scanner);
                materiales.add(new Pelicula(titulo, director, duracion));
                System.out.println("Película agregada exitosamente.");
                break;
        }
    }

    private static void listarMateriales(ArrayList<MaterialBibliografico> materiales) {
        System.out.println("\n--- Listado de Materiales ---");
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales registrados.");
        } else {
            for (int i = 0; i < materiales.size(); i++) {
                System.out.println("\nID: " + i);
                materiales.get(i).mostrarInformacion(); // POLIMORFISMO
            }
        }
    }

    private static void simularPrestamo(ArrayList<MaterialBibliografico> materiales, Scanner scanner) {
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales para simular préstamo.");
            return;
        }

        listarMateriales(materiales);
        System.out.print("\nSeleccione el ID del material: ");
        int id = leerEntero(scanner);

        if (id >= 0 && id < materiales.size()) {
            MaterialBibliografico material = materiales.get(id);
            System.out.print("Ingrese los días de retraso: ");
            int dias = leerEntero(scanner);

            double multa = material.calcularMulta(dias); // POLIMORFISMO
            System.out.println("\n--- Resultado de la Simulación ---");
            System.out.println("Material: " + material.getTitulo());
            System.out.println("Días de retraso: " + dias);
            System.out.printf("Multa calculada: $%.0f pesos%n", multa);
        } else {
            System.out.println("ID no válido.");
        }
    }

    private static int leerEntero(Scanner scanner) {
        try {
            int val = scanner.nextInt();
            scanner.nextLine();
            return val;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }
}
