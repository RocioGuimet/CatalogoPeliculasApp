package service;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicePeliculasLista implements IServicePeliculas{

    private final List<Pelicula> peliculas;

    // Inicializamos
    public ServicePeliculasLista(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de películas...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agregó la película: " + pelicula);

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        // Muestra el indice de la pelicula encontrada
        var indice = peliculas.indexOf(pelicula);
        if (indice == -1)
            System.out.println("No se encontró la película " + pelicula);
        else
            System.out.println("Película encontrada en el índice: " + indice);
    }

    static void main(String[] args) {
        // Creamos objetos de prueba
        var pelicula1 = new Pelicula ("Batman");
        var pelicula2 = new Pelicula ("Superman");
        // Creamos patron de disenio service
        IServicePeliculas servicePeliculas = new ServicePeliculasLista();
        // Agregamos peliculas a la lista
        servicePeliculas.agregarPelicula(pelicula1);
        servicePeliculas.agregarPelicula(pelicula2);
        // Listamos las peliculas
        servicePeliculas.listarPeliculas();
        // Buscamos una pelicula (equals y hashCode)
        servicePeliculas.buscarPelicula(new Pelicula("Robin"));
    }

}
