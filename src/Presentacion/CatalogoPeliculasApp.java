package Presentacion;

import dominio.Pelicula;
import service.IServicePeliculas;
import service.ServicePeliculasArchivo;
import service.ServicePeliculasLista;

import java.util.Scanner;

public class CatalogoPeliculasApp {
    static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        // Agregamos la implementacion del service
        // IServicePeliculas servicePeliculas = new ServicePeliculasLista(); ANTIGUA DE PRUEBA
        IServicePeliculas servicePeliculas = new ServicePeliculasArchivo();
        while(!salir){
            try{
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicePeliculas);
            } catch (Exception e){
                System.out.println("Ocurrió un eror: " + e.getMessage());
            }
            System.out.println();
        } //fin while
    }

    //Implementamos metodos
    private static void mostrarMenu(){
        System.out.print("""
                * Catálogo de películas *
                1. Agregar película
                2. Listar películas
                3. Buscar película
                4. Salir
                Elige una opción: 
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, IServicePeliculas servicePeliculas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce el nombre de la película: ");
                var nombrePelicula = consola.nextLine();
                servicePeliculas.agregarPelicula(new Pelicula(nombrePelicula));
            }
            case 2 -> servicePeliculas.listarPeliculas();

            case 3 -> {
                System.out.println("Introduce la película a buscar: ");
                var buscar = consola.nextLine();
                servicePeliculas.buscarPelicula(new Pelicula (buscar));
            }
            case 4 -> {
                System.out.println("¡Hasta pronto!");
                salir = true;
            }
            default -> System.out.println("Opción incorrecta: " + opcion);
        } // fin switch
        return salir;
    }
}