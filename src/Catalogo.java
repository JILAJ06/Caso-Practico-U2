import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalogo {
    private List<Libro> libros = new ArrayList<>();

    // Inserción ordenada por título
    public void insertarLibro(Libro libro) {
        int i = 0;
        while (i < libros.size() && libros.get(i).getTitulo().compareToIgnoreCase(libro.getTitulo()) < 0) {
            i++;
        }
        libros.add(i, libro);
    }

    // Buscar y modificar libro por título
    public boolean buscarYModificar(String titulo, String nuevoAutor, String nuevoCodigo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (nuevoAutor != null && !nuevoAutor.isEmpty()) libro.setAutor(nuevoAutor);
                if (nuevoCodigo != null && !nuevoCodigo.isEmpty()) libro.setCodigo(nuevoCodigo);
                return true;
            }
        }
        return false;
    }

    // Eliminar libro por título
    public boolean eliminarLibro(String titulo) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                libros.remove(i);
                return true;
            }
        }
        return false;
    }

    // Mostrar catálogo
    public void mostrarCatalogo() {
        if (libros.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }
}
