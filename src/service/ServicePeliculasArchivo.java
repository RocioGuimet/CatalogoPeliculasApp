package service;

import dominio.Pelicula;

import javax.swing.*;
import java.io.*;

public class ServicePeliculasArchivo implements IServicePeliculas{

    private  final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicePeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            // Si ya existe el archivo, NO se vuelve a crear
            if(archivo.exists()){
                System.out.println("El archivo ya existe");
            }
            else {
                // Si no existe, se crea
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        } catch (Exception e){
            System.out.println("Ocurrió un error al abrir el archivo: " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        // Volvemos a abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            System.out.println("Listado de películas:");
            // Abrimos el archivo en modo lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // Leemos linea a linea el archivo
            String linea;
            linea = entrada.readLine();
            // Leemos todas las lineas
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                linea = entrada.readLine();
            } // Fin while
            // Cerramoos el archivo
            entrada.close();
        } catch (Exception e){
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }

    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            // Revisamos si existe el archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            // Agregamos pelicula
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agregó al archivo: " + pelicula);
        } catch (Exception e){
            System.out.println("Ocurrió un error al agregar película: " + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            // Abrimos archivo para leer linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();
            while(lineaTexto != null){
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                lineaTexto = entrada.readLine();
                indice++;
            } // fin while
            // Imprimimos resultados
            if (encontrada) {
                System.out.println("Película: " + lineaTexto + " encontrada - linea " + indice);
            }
            else {
                System.out.println("No se encontró la película: " + pelicula.getNombre());
            }
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrió un error al buscar pelicula: " + e.getMessage());
        }
    }
}
