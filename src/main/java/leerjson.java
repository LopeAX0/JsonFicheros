import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class leerjson {
    public static void main(String[] args) throws FileNotFoundException {
       //Creamos el objeto Gson
        Gson gson=new Gson();
        //Hacemos esto para poder leer el archivo
        try(FileReader leer=new FileReader("src/main/resources/Pelis.json")){
            //Me temos el contenido del json en un array de Peliculas
            Pelicula[] peliculas=gson.fromJson(leer,Pelicula[].class);
            //Recorremos el array y lo mostramos por pantalla
            for (Pelicula pelicula: peliculas){
                System.out.println(pelicula);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el documento json.");
        }
    }
}
