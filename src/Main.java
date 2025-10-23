import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nCatálogo de Libros");
            System.out.println("1. Insertar libro");
            System.out.println("2. Buscar y modificar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Ver catálogo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Opción no válida.");
                System.out.print("Elige una opción: ");
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer
            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    Libro libro = new Libro(titulo, autor, codigo);
                    catalogo.insertarLibro(libro);
                    System.out.println("Libro insertado correctamente.");
                    break;
                case 2:
                    System.out.print("Título a buscar: ");
                    String buscarTitulo = sc.nextLine();
                    System.out.print("Nuevo autor (dejar vacío para no cambiar): ");
                    String nuevoAutor = sc.nextLine();
                    System.out.print("Nuevo código (dejar vacío para no cambiar): ");
                    String nuevoCodigo = sc.nextLine();
                    if (catalogo.buscarYModificar(buscarTitulo, nuevoAutor, nuevoCodigo)) {
                        System.out.println("Libro modificado.");
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Título a eliminar: ");
                    String eliminarTitulo = sc.nextLine();
                    if (catalogo.eliminarLibro(eliminarTitulo)) {
                        System.out.println("Libro eliminado.");
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 4:
                    catalogo.mostrarCatalogo();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}

