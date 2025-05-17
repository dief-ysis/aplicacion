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
        Libro libro1 = new Libro();
        try{
            libro = libroRepository.save(libro);
        }
        catch (Exception e){
            System.out.println("Error al guardar el libro: " + e.getMessage());
            return null;
        }
        return libro1;
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
