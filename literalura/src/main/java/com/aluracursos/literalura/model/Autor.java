package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    @JsonProperty("birth_year")
    private Integer birthYear;
    @JsonProperty("death_year")
    private Integer deathYear;
    @ManyToOne
    private Libros libros;

    public Autor() {}

    public Autor(String nombre, Integer birthYear, Integer deathYear, Libros libros) {
        this.nombre = nombre;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.libros = libros;
    }

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.birthYear = datosAutor.birthYear();
        this.deathYear = datosAutor.dearhYear();
        this.libros = getLibros();
    }

    @Override
    public String toString() {
        return
                "nombre=" + nombre +
                        "\nbirthYear=" + birthYear +
                        "\ndeathYear=" + deathYear +
                        "\nlibros=" + libros;

}

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getNombre() {
return nombre;
}

public void setNombre(String nombre) {
this.nombre = nombre;
}

public Integer getBirthYear() {
return birthYear;
}

public void setBirthYear(Integer birthYear) {
this.birthYear = birthYear;
}

public Integer getDeathYear() {
return deathYear;
}

public void setDeathYear(Integer deathYear) {
this.deathYear = deathYear;
}

public Libros getLibros() {
return libros;
}

public void setLibros(Libros libros) {
this.libros = libros;
}
}

