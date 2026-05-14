import java.io.*;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Verificar fichero/directorio");
            System.out.println("2. Mostrar restaurantes con CP que empieza por 6");
            System.out.println("3. Añadir datos al CSV");
            System.out.println("4. Crear Restaurants2.csv sin CP que empiece por 6");
            System.out.println("5. Borrar fichero");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    ejercicio1();
                    break;
                case 2:
                    ejercicio2();
                    break;
                case 3:
                    ejercicio3();
                    break;
                case 4:
                    ejercicio4();
                    break;
                case 5:
                    ejercicio5();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    // ====== EJERCICIO 1 ======
    public static void ejercicio1() {
        System.out.print("Ingrese la ruta: ");
        String ruta = sc.nextLine();

        File fichero = new File(ruta);

        if (fichero.exists()) {
            System.out.println("Existe.");

            if (fichero.isDirectory()) {
                System.out.println("Es un directorio.");
            } else if (fichero.isFile()) {
                System.out.println("Es un fichero.");
                System.out.println("Nombre: " + fichero.getName());
                System.out.println("Tamaño: " + fichero.length() + " bytes");
                System.out.println("Lectura: " + fichero.canRead());
                System.out.println("Escritura: " + fichero.canWrite());
            }
        } else {
            System.out.println("No existe.");
        }
    }

    // ====== EJERCICIO 2 ======
    public static void ejercicio2() {
        String archivo = "Restaurants.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length > 0) {
                    String cp = datos[datos.length - 1].trim();

                    if (cp.startsWith("6")) {
                        System.out.println(linea);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ====== EJERCICIO 3 ======
    public static void ejercicio3() {
        String archivo = "Restaurants.csv";

        try (FileWriter fw = new FileWriter(archivo, true)) {
            System.out.println("Ingrese nueva línea (formato CSV):");
            String linea = sc.nextLine();

            fw.write(System.lineSeparator() + linea);

            System.out.println("Datos agregados.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ====== EJERCICIO 4 ======
    public static void ejercicio4() {
        String entrada = "Restaurants.csv";
        String salida = "Restaurants2.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(entrada));
             FileWriter fw = new FileWriter(salida)) {

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length > 0) {
                    String cp = datos[datos.length - 1].trim();

                    if (!cp.startsWith("6")) {
                        fw.write(linea + System.lineSeparator());
                    }
                }
            }

            System.out.println("Archivo creado: " + salida);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ====== EJERCICIO 5 ======
    public static void ejercicio5() {
        System.out.print("Ruta del fichero a borrar: ");
        String ruta = sc.nextLine();

        File fichero = new File(ruta);

        if (fichero.exists()) {
            if (fichero.delete()) {
                System.out.println("Borrado correctamente.");
            } else {
                System.out.println("No se pudo borrar.");
            }
        } else {
            System.out.println("No existe.");
        }
    }
}