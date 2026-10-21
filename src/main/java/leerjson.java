import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class leerjson {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson=new Gson();

        try(FileReader leer=new FileReader("src/main/resources/Pelis.json")){
            Pelicula[] peliculas=gson.fromJson(leer,Pelicula[].class);

            for (Pelicula pelicula: peliculas){
                System.out.println(pelicula);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el documento json.");
        }
    }
}
