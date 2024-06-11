import java.util.ArrayList;
import java.util.Scanner;

class Libro {
    String titulo;
    String autor;
    String ISBN;
    int añoPublicacion;
    boolean prestado;

    public Libro(String titulo, String autor, String ISBN, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.añoPublicacion = añoPublicacion;
        this.prestado = false;
    }
}

public class SistemaGestionBiblioteca {
    static ArrayList<Libro> biblioteca = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);    

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n--- Sistema de Gestión de Biblioteca ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Mostrar todos los libros disponibles");
            System.out.println("5. Prestar libro");
            System.out.println("6. Devolver libro");
            System.out.println("7. Salir");
            System.out.print("Ingrese su opción: ");
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();  
                switch (opcion) {
                    case 1:
                        agregarLibro();
                        break;
                    case 2:
                        buscarLibroPorTitulo();
                        break;
                    case 3:
                        buscarLibroPorAutor();
                        break;
                    case 4:
                        mostrarLibrosDisponibles();
                        break;
                    case 5:
                        prestarLibro();
                        break;
                    case 6:
                        devolverLibro();  
                        break;
                    case 7:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error al procesar la opción. Intente nuevamente.");
                scanner.nextLine();  
            }
        } while (opcion != 7);
    }

      //Metodo 1
    public static void agregarLibro() {
        System.out.println("\n--- Agregar Libro ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Año de Publicación: ");
        int añoPublicacion = scanner.nextInt();
        scanner.nextLine(); 
        Libro libro = new Libro(titulo, autor, ISBN, añoPublicacion);
        biblioteca.add(libro);
        System.out.println("Libro agregado exitosamente.");
    }
      //Metodo 2
    public static void buscarLibroPorTitulo() {
        System.out.println("\n--- Buscar Libro por Título ---");
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        boolean encontrado = false;
        for (Libro libro : biblioteca) {
            if (libro.titulo.equalsIgnoreCase(titulo)) {
                System.out.println(libro.titulo + " - " + libro.autor + " - " + libro.ISBN + " - " + libro.añoPublicacion);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Libro no encontrado.");
        }
    }
       //Metodo 3
    public static void buscarLibroPorAutor() {
        System.out.println("\n--- Buscar Libro por Autor ---");
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        boolean encontrado = false;
        for (Libro libro : biblioteca) {
            if (libro.autor.equalsIgnoreCase(autor)) {
                System.out.println(libro.titulo + " - " + libro.autor + " - " + libro.ISBN + " - " + libro.añoPublicacion);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Libro no encontrado.");
        }
    }
      //Metodo 4
    public static void mostrarLibrosDisponibles() {
        System.out.println("\n--- Libros Disponibles ---");
        for (Libro libro : biblioteca) {
            if (!libro.prestado) {
                System.out.println(libro.titulo + " - " + libro.autor + " - " + libro.ISBN + " - " + libro.añoPublicacion);
            }
        }
    }
      //Metodo 5
    public static void prestarLibro() {
        System.out.println("\n--- Prestar Libro ---");
        System.out.print("Ingrese el título del libro que desea prestar: ");
        String titulo = scanner.nextLine();
        boolean encontrado = false;
        for (Libro libro : biblioteca) {
            if (libro.titulo.equalsIgnoreCase(titulo) && !libro.prestado) {
                libro.prestado = true;
                System.out.println("Libro prestado exitosamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Libro no encontrado o ya prestado.");
        }
    }
      //Metodo 6
    public static void devolverLibro() {
        System.out.println("\n--- Devolver Libro ---");
        System.out.print("Ingrese el título del libro que desea devolver: ");
        String titulo = scanner.nextLine();
        boolean encontrado = false;
        for (Libro libro : biblioteca) {
            if (libro.titulo.equalsIgnoreCase(titulo) && libro.prestado) {
                libro.prestado = false;
                System.out.println("Libro devuelto exitosamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Libro no encontrado o no prestado.");
        }
    }
}
