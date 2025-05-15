package com.example.demo.services;

import com.example.demo.model.Libro;
import com.example.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros() {
        return libroRepository.findAll();
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro getLibroById(int id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro updateLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public String deleteLibro(int id) {
        libroRepository.deleteById(id);
        return "Producto eliminado con id: " + id;
    }
}
