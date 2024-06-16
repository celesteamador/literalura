package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
    @JsonAlias("name") String nombre,
    @JsonAlias("birth_year") Integer birthYear,
    @JsonAlias("death_year") Integer dearhYear,
    @JsonAlias("title")String libros
){
    public void add(DatosAutor datosAutor) {
    }
}
