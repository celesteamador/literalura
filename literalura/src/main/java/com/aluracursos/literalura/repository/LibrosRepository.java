package com.aluracursos.literalura.repository;
import com.aluracursos.literalura.model.Autor;
import com.aluracursos.literalura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibrosRepository extends JpaRepository<Libros, Long> {
    //Buscar en PostgreSQL
    @Query(value = "SELECT * FROM libros", nativeQuery = true)
    List<Libros> findAll();

}


