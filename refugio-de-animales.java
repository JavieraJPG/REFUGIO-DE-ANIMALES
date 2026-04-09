import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RefugioAnimales {

    static Scanner scanner = new Scanner(System.in);

    // Estructuras obligatorias
    static List<String> animales = new ArrayList<>();
    static Map<String, String> estadoAnimal = new HashMap<>();
    static Set<String> especies = new HashSet<>();
    static Map<String, String> animalEspecie = new HashMap<>();
    static String[] estados = {"Disponible", "Adoptado"};

    public static void main(String[] args) {
        int opcion;

        // Especies de ejemplo para poder probar registrar animal
        especies.add("Perro");
        especies.add("Gato");
        especies.add("Conejo");

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarAnimal();
                    break;
                case 2:
                    System.out.println("Opción aún no implementada.");
                    break;
                case 3:
                    System.out.println("Opción aún no implementada.");
                    break;
                case 4:
                    System.out.println("Opción aún no implementada.");
                    break;
                case 5:
                    System.out.println("Opción aún no implementada.");
                    break;
                case 6:
                    System.out.println("Opción aún no implementada.");
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Error: opción inválida.");
            }

        } while (opcion != 7);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n=== REFUGIO DE ANIMALES ===");
        System.out.println("1. Registrar animal");
        System.out.println("2. Registrar especie");
        System.out.println("3. Marcar animal como adoptado");
        System.out.println("4. Mostrar animales disponibles");
        System.out.println("5. Mostrar animales adoptados");
        System.out.println("6. Mostrar reporte general");
        System.out.println("7. Salir");
    }

    public static void registrarAnimal() {
        System.out.println("\n--- REGISTRAR ANIMAL ---");

        if (especies.isEmpty()) {
            System.out.println("Error: no hay especies registradas. Debe registrar una especie primero.");
            return;
        }

        System.out.print("Ingrese el nombre del animal: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("Error: el nombre no puede estar vacío.");
            return;
        }

        if (animales.contains(nombre)) {
            System.out.println("Error: ya existe un animal registrado con ese nombre.");
            return;
        }

        System.out.println("Especies registradas:");
        for (String especie : especies) {
            System.out.println("- " + especie);
        }

        System.out.print("Ingrese la especie del animal: ");
        String especieIngresada = scanner.nextLine().trim();

        if (especieIngresada.isEmpty()) {
            System.out.println("Error: la especie no puede estar vacía.");
            return;
        }

        if (!especies.contains(especieIngresada)) {
            System.out.println("Error: la especie no existe. Debe registrar una especie válida.");
            return;
        }

        animales.add(nombre);
        animalEspecie.put(nombre, especieIngresada);
        estadoAnimal.put(nombre, estados[0]); // "Disponible"

        System.out.println("Animal registrado correctamente.");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especieIngresada);
        System.out.println("Estado: " + estados[0]);
    }

    public static int leerEntero(String mensaje) {
        int numero;

        while (true) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(scanner.nextLine());
                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido.");
            }
        }
    }
}