package com.example.demo.repository;

import com.example.demo.model.Libro;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class LibroRepository {
    
    private List<Libro> libros = new ArrayList<>();

    public List<Libro> obteneLibros() {
        return libros;
    }

    public Libro buscarPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public Libro guardar (Libro libro) {
        libros.add(libro);
        return libro;
    }

    public Libro actializar (Libro lib) {
        int id = 0;
        int idPosicion = 0;
        
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == lib.getId()) {
                id = lib.getId();
                idPosicion = i;
            }
        }
        
        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setIsbn(lib.getIsbn());
        libro1.setTitulo(lib.getTitulo());
        libro1.setEditorial(lib.getEditorial());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setAutor(lib.getAutor());
        
        libros.set(idPosicion, libro1);
        return libro1;
    }

    public void eliminar (int id) {
        Libro libro = buscarPorId(id);
        if (libro != null) {
            libros.remove(libro);
        }
    }
}