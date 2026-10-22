import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Escribirjson {
    static String recursos="src/main/resources";
    static File peli=new File(recursos+"/Pelis.json");

    public static void main(String[] args) {
        //Creamos las diferentes peliculas que se van a almacenar en al json
        Pelicula p1=new Pelicula();
        p1.setTitulo("Matrix");
        p1.setDirector("Lana y Lilly Wachowski");
        p1.setAño(1999);

        Pelicula p2=new Pelicula();
        p2.setTitulo("Interstellar");
        p2.setDirector("Christopher Nolan");
        p2.setAño(2014);

        Pelicula p3=new Pelicula();
        p3.setTitulo("Gladiator");
        p3.setDirector("Ridley Scott");
        p3.setAño(2000);

        //Acontinuacion las voy a almacenar en un array de pelicula
        Pelicula []pelis={p1,p2,p3};
        //Aqui creo el objeto Gson el cual se va a encargar de crear el documento json
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        //Acontinuacion voy a meter las diferentes pelicualas que he creado
        try(FileWriter fichero=new FileWriter(peli)){
        //Aqui vamos a llamar al metodo .toJson para que pase todo el array de peliculas y lo escriba en json en el fichero que le hemos pasado
        gson.toJson(pelis,fichero);
            System.out.println("Documento creado con exito");
        }catch (IOException e) {
            System.out.println("Error al escribir el documento JSON.");
        }



    }
}
