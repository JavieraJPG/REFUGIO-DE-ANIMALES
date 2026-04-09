import java.util.*;

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
                    registrarEspecie();
                    break;
                case 3:
                    marcarComoAdoptado();
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
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Error: opción inválida.");
            }

        } while (opcion != 7);

        scanner.close();
    }

    // ====== Funciones =========

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
        String nombre = scanner.nextLine().trim().toUpperCase();

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

    public static void mostrarAnimalesDisponibles(){
        boolean hayDisponible = false;
        for(String animal : animales){
            if(estadoAnimal.get(animal).equals("Disponible")){
                System.out.println("| Nombre: " + animal + "| Especie: " + animalEspecie.get(animal));
                hayDisponible = true;
            }
        }

        if (!hayDisponible){
            System.out.println("No hay animales disponibles");
        }

    }




    // ==== Victor ====
    public static void mostrarAnimalesAdoptados() {
        System.out.println("\n── Animales adoptados ──");

        for(int i = 0; i < animales.size(); i++) {
            String animal = animales.get(i);
            String estado = estadoAnimal.get(animal);

            if (estado.equals("Adoptado")) {
                System.out.printf("  %-20s │ Especie: %-15s │ Estado: %s%n",
                        animal, animalEspecie.get(animal), estado);

            }
        }

    }






    // === Shery ====
    public static void marcarComoAdoptado() {
        System.out.println("\n --- MARCAR ANIMAL COMO ADOPTADO ---");

        if (animales.isEmpty()) {
            System.out.println("Error: No hay animales registrados. ");
            return;
        }

        System.out.println("Animales disponibles: ");
        boolean hayDisponibles = false;
        for (String animal : animales) {
            if (estadoAnimal.get(animal).equals(estados[0])) {
                System.out.println("- " + animal);
                hayDisponibles = true;
            }
        }

        if (!hayDisponibles) {
            System.out.println("Error: No hay animales disponibles para adoptar. ");
            return;
        }

        System.out.println("Ingrese el nombre del animal a adoptar: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío. ");
            return;
        }

        if (estadoAnimal.get(nombre).equals(estados[1])) {
            System.out.println("Error: Este animal ya fue adoptado. ");
            return;
        }

        estadoAnimal.put(nombre, estados[1]);
        System.out.println("El animal " + nombre + "ha sido marcado como adoptado. ");
    }

    // Registrar nueva especie
    public static void registrarEspecie() {
        System.out.println("\n--- REGISTRAR ESPECIE ---");
        System.out.print("Ingrese el nombre de la especie: ");
        String especie = scanner.nextLine().trim();

        if (especie.isEmpty()) {
            System.out.println("Error: el nombre no puede estar vacío.");
            return;
        }

        if (especies.contains(especie)) {
            System.out.println("Aviso: esa especie ya estaba registrada.");
        } else {
            especies.add(especie);
            System.out.println("Especie registrada correctamente.");
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