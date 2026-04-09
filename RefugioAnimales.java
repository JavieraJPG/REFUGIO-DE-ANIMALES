import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RefugioAnimales {

    // Scanner para entrada por consola
    static Scanner scanner = new Scanner(System.in);

    // Lista de animales (solo nombres)
    static List<String> animales = new ArrayList<>();

    // Estado de cada animal (Disponible / Adoptado)
    static Map<String, String> estadoAnimal = new HashMap<>();

    // Conjunto de especies (sin duplicados)
    static Set<String> especies = new HashSet<>();

    // Relación animal → especie
    static Map<String, String> animalEspecie = new HashMap<>();

    // Estados fijos del sistema
    static String[] estados = {"Disponible", "Adoptado"};

    public static void main(String[] args) {
        int opcion = 0;

        // Bucle principal del programa
        do {
            mostrarMenu();

            // Validar que la opción sea un número
            try {
                System.out.print("Seleccione una opción: ");
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Debe ingresar un número válido.");
                continue; // vuelve al menú
            }

            // Control de opciones del menú
            switch (opcion) {
                case 1:
                    registrarAnimal();
                    break;
                case 2:
                    registrarEspecie();
                    break;
                case 3:
                    marcarAnimalComoAdoptado();
                    break;
                case 4:
                    mostrarAnimalesDisponibles();
                    break;
                case 5:
                    mostrarAnimalesAdoptados();
                    break;
                case 6:
                    mostrarReporteGeneral();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7); // termina cuando el usuario elige salir

        scanner.close();
    }

    // Muestra el menú principal
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

    // Registrar un nuevo animal en el sistema
    public static void registrarAnimal() {
        System.out.println("\n--- REGISTRAR ANIMAL ---");

        // Validar que existan especies registradas
        if (especies.isEmpty()) {
            System.out.println("No hay especies registradas.");
            return;
        }

        // Leer nombre
        System.out.print("Ingrese nombre del animal: ");
        String nombre = scanner.nextLine().trim();

        // Validar que no esté vacío
        if (nombre.isEmpty()) {
            System.out.println("No puede estar vacío.");
            return;
        }

        // Verificar que no exista duplicado (ignorando mayúsculas)
        for (String animal : animales) {
            if (animal.equalsIgnoreCase(nombre)) {
                System.out.println("El animal ya existe.");
                return;
            }
        }

        // Mostrar especies disponibles
        System.out.println("Especies:");
        for (String e : especies) {
            System.out.println("- " + e);
        }

        // Leer especie
        System.out.print("Ingrese especie: ");
        String especieIngresada = scanner.nextLine().trim();

        // Validar vacío
        if (especieIngresada.isEmpty()) {
            System.out.println("No puede estar vacío.");
            return;
        }

        // Buscar especie válida (ignorando mayúsculas)
        String especieReal = null;
        for (String e : especies) {
            if (e.equalsIgnoreCase(especieIngresada)) {
                especieReal = e;
            }
        }

        // Si no existe, error
        if (especieReal == null) {
            System.out.println("La especie no existe.");
            return;
        }

        // Guardar datos
        animales.add(nombre);
        animalEspecie.put(nombre, especieReal);
        estadoAnimal.put(nombre, estados[0]); // Disponible

        System.out.println("Animal registrado correctamente.");
    }

    // Registrar nueva especie
    public static void registrarEspecie() {
        System.out.println("\n--- REGISTRAR ESPECIE ---");

        System.out.print("Ingrese especie: ");
        String especie = scanner.nextLine().trim();

        // Validar vacío
        if (especie.isEmpty()) {
            System.out.println("No puede estar vacío.");
            return;
        }

        // Evitar duplicados
        for (String e : especies) {
            if (e.equalsIgnoreCase(especie)) {
                System.out.println("La especie ya existe.");
                return;
            }
        }

        especies.add(especie);
        System.out.println("Especie registrada.");
    }

    // Cambiar estado de un animal a adoptado
    public static void marcarAnimalComoAdoptado() {
        System.out.println("\n--- ADOPTAR ---");

        boolean hay = false;

        // Mostrar animales disponibles
        for (String a : animales) {
            if (estadoAnimal.get(a).equals(estados[0])) {
                System.out.println("- " + a);
                hay = true;
            }
        }

        // Validar que existan disponibles
        if (!hay) {
            System.out.println("No hay disponibles.");
            return;
        }

        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine().trim();

        String animalReal = null;

        // Buscar animal ignorando mayúsculas
        for (String a : animales) {
            if (a.equalsIgnoreCase(nombre)) {
                animalReal = a;
            }
        }

        // Validar existencia
        if (animalReal == null) {
            System.out.println("No existe.");
            return;
        }

        // Validar si ya fue adoptado
        if (estadoAnimal.get(animalReal).equals(estados[1])) {
            System.out.println("Ya adoptado.");
            return;
        }

        // Actualizar estado
        estadoAnimal.put(animalReal, estados[1]);
        System.out.println("Adoptado.");
    }

    // Mostrar solo animales disponibles
    public static void mostrarAnimalesDisponibles() {
        System.out.println("\n--- DISPONIBLES ---");

        for (String a : animales) {
            if (estadoAnimal.get(a).equals(estados[0])) {
                System.out.println(a + " | " + animalEspecie.get(a));
            }
        }
    }

    // Mostrar solo animales adoptados
    public static void mostrarAnimalesAdoptados() {
        System.out.println("\n--- ADOPTADOS ---");

        for (String a : animales) {
            if (estadoAnimal.get(a).equals(estados[1])) {
                System.out.println(a + " | " + animalEspecie.get(a));
            }
        }
    }

    // Mostrar resumen general del sistema
    public static void mostrarReporteGeneral() {
        System.out.println("\n--- REPORTE ---");

        int disponibles = 0;
        int adoptados = 0;

        // Contar estados
        for (String a : animales) {
            if (estadoAnimal.get(a).equals(estados[0])) {
                disponibles++;
            } else {
                adoptados++;
            }
        }

        System.out.println("Total: " + animales.size());
        System.out.println("Disponibles: " + disponibles);
        System.out.println("Adoptados: " + adoptados);

        // Mostrar tabla completa
        System.out.println("\nNombre | Especie | Estado");

        for (String a : animales) {
            System.out.println(a + " | " +
                    animalEspecie.get(a) + " | " +
                    estadoAnimal.get(a));
        }
    }
}