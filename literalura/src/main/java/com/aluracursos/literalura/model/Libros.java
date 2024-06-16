package com.aluracursos.literalura.model;
import jakarta.persistence.*;
import jdk.jfr.Relational;
import java.util.ArrayList;
import java.util.List;
import static org.apache.coyote.http11.Constants.a;

@Entity
@Table(name = "libros")
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer libroId;
    @Column(unique = true)
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Languages languages;
    private String topic;
    @OneToMany(mappedBy = "libros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autor;

    public Libros() {}

    public Libros(DatosLibros datosLibros) {
        this.titulo = datosLibros.titulo();
        this.topic = datosLibros.topic();
        this.languages = Languages.fromString(String.valueOf(datosLibros.languages()));
        this.topic = datosLibros.topic();
        for (Autor autor : autor) {
            autor.setLibros(this);
            this.autor.add(autor);
        }
    }


    @Override
    public String toString() {
        return
                "Titulo: " + titulo +
                        "\nAutores: " + autor +
                        "\nLanguages: " + languages +
                        "\nTopic: " + topic +
                        "\nLibro id" + libroId;
    }

    public Integer getLibroId() {return libroId;}

    public void setLibroId(Integer libroId) {this.libroId = libroId;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setAutor(List<Autor> autor) {
        autor.forEach(e -> e.setLibros(this));
        this.autor = autor;
    }

    public Languages getLanguages() {
        return languages;
    }

    public void setLanguages(Languages languages) {
        this.languages = languages;
    }

    public Libros(Languages languages) {
        this.languages = languages;
    }
}

