package service;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicePeliculasLista implements IServicePeliculas{

    private final List<Pelicula> peliculas;

    //Inicializamos
    public ServicePeliculasLista(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de peliculas...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agregó la pelicula: " + pelicula);

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        //Muestra el indice de la pelicula encontrada
        var indice = peliculas.indexOf(pelicula);
        System.out.println("Pelicula encontrada en el indice: " + indice);

    }
}
