package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<Autor> autor,
        @JsonAlias("languages") Languages languages,
        @JsonAlias("subjects") String topic,
        @JsonAlias("id") Integer libroId
) {
}
