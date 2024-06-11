import java.util.ArrayList;
import java.util.Scanner;

class Contacto {
    String nombre;
    String telefono;
    String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }
}

public class GestionContactos {
    static ArrayList<Contacto> listaContactos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar un nuevo contacto");
            System.out.println("2. Eliminar un contacto");
            System.out.println("3. Buscar un contacto por nombre");
            System.out.println("4. Mostrar todos los contactos");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    eliminarContacto();
                    break;
                case 3:
                    buscarContactoPorNombre();
                    break;
                case 4:
                    mostrarTodosLosContactos();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 5.");
            }
        } while (opcion != 5);
    }

    static void agregarContacto() {
        System.out.println("\nAgregar nuevo contacto:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String email = scanner.nextLine();

        Contacto nuevoContacto = new Contacto(nombre, telefono, email);
        listaContactos.add(nuevoContacto);
        System.out.println("Contacto agregado correctamente.");
    }

    static void eliminarContacto() {
        System.out.println("\nEliminar contacto:");
        System.out.print("Ingrese el nombre del contacto a eliminar: ");
        String nombre = scanner.nextLine();

        boolean encontrado = false;
        for (Contacto contacto : listaContactos) {
            if (contacto.nombre.equalsIgnoreCase(nombre)) {
                listaContactos.remove(contacto);
                System.out.println("Contacto eliminado correctamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con ese nombre.");
        }
    }

    static void buscarContactoPorNombre() {
        System.out.println("\nBuscar contacto por nombre:");
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();

        boolean encontrado = false;
        for (Contacto contacto : listaContactos) {
            if (contacto.nombre.equalsIgnoreCase(nombre)) {
                System.out.println("Nombre: " + contacto.nombre);
                System.out.println("Teléfono: " + contacto.telefono);
                System.out.println("Correo electrónico: " + contacto.email);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con ese nombre.");
        }
    }

    static void mostrarTodosLosContactos() {
        System.out.println("\nLista de contactos:");
        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos en la lista.");
        } else {
            for (Contacto contacto : listaContactos) {
                System.out.println("Nombre: " + contacto.nombre);
                System.out.println("Teléfono: " + contacto.telefono);
                System.out.println("Correo electrónico: " + contacto.email);
                System.out.println("---------------------------");
            }
        }
    }
}
