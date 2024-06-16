package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.Autor;
import com.aluracursos.literalura.model.DatosAutor;
import com.aluracursos.literalura.repository.LibrosRepository;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;
import com.aluracursos.literalura.model.DatosLibros;
import com.aluracursos.literalura.model.Libros;

import java.util.*;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com//books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosLibros> datosLibros = new ArrayList<>();
    private List<DatosAutor> datosAutor = new ArrayList<>();
    private LibrosRepository repository;
    private List<Libros> libros;

    public Principal(LibrosRepository repository) {
        this.repository = repository;
    }

    public void muestraElMenu(){
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    ***********************************************
                                    LITERALURA
                                 por Celeste Amador
                    ***********************************************
                    1 - Buscar un libro por título
                    2 - Listar libros registrados
                    3 - Buscar libro por autor
                    4 - listar autores vivos en un determinado año
                    5 - listar libros registrados por idioma
                    0 - salir
                    """;
            System.out.println(menu);
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    mostrarLibrosRegistrados();
                    break;
//                case 3:
//                    buscarLibroPorAutor();
//                    break;
////                case 4:
//                    mostrarAutoresVivos();
//                    break;
//                case 5:
//                    mostrarLibrosRegistradosPorIdioma();
//                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

        }
    }
//Obtener datos de libros por medio de Api
    private DatosLibros getDatosLibros() {
        //Titulo de Libro a buscar
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = scanner.nextLine();
        //Obtener datos de Api
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + nombreLibro.replace(" ", "+"));
        System.out.println(json);
        //Convertir datos
        DatosLibros datosLibros = conversor.obtenerDatos(json, DatosLibros.class);
        return datosLibros;
    }

// Case 1 Buscar Libros y guardar en Datos
    private void buscarLibro(){
        DatosLibros datosLibros = getDatosLibros();
        Libros libros = new Libros(datosLibros);
        repository.save(libros);
        datosLibros.add(datosLibros);
        System.out.println(datosLibros);
    }

//Case 2 Mostrar Libros buscados
    private void mostrarLibrosRegistrados(){
        libros = repository.findAll();

        libros.stream()
                .sorted(Comparator.comparing(Libros::getLanguages))
                .forEach(libro -> System.out.println(libro));

    }

}
