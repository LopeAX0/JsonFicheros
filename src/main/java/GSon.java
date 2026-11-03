import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class GSon {
static String personajes="src/main/java/documentos/personajes.json";
    static String jugador="src/main/java/documentos/jugador.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();

        List<Personaje> listaPersonajes = cargarPersonajes(gson);
        if (listaPersonajes == null || listaPersonajes.isEmpty()) {
            System.out.println("No se pudieron cargar los personajes. Verifique el fichero.");
            return;
        }

        System.out.println("=== ¡BIENVENIDO AL JUEGO DE ADIVINAR EL PERSONAJE! ===");
        System.out.print("Introduce tu nombre de jugador: ");
        String nombreJugador = scanner.nextLine().trim();


        List<Jugador> ranking = cargarRanking(gson);

        int puntuacionTotal = 0;
        boolean jugarNuevamente = true;


        while (jugarNuevamente) {
            Random random = new Random();
            Personaje personajeElegido = listaPersonajes.get(random.nextInt(listaPersonajes.size()));
            List<String> pistas = personajeElegido.getPistas();

            int pistasUsadas = 0;
            boolean acierto = false;

            System.out.println("\n--- ¡Nueva Ronda! ---");

            for (int i = 0; i < pistas.size(); i++) {
                pistasUsadas++;
                System.out.println("\nPista " + pistasUsadas + ": " + pistas.get(i));
                System.out.print("¿Quién soy?: ");
                String respuesta = scanner.nextLine().trim();

                if (respuesta.equalsIgnoreCase(personajeElegido.getNombre())) {
                    System.out.println("¡Enhorabuena! Has acertado.");
                    acierto = true;
                    break;
                } else {
                    System.out.println("Respuesta incorrecta.");
                }
            }


            int puntosRonda = 0;
            if (acierto) {
                if (pistasUsadas == 1) puntosRonda = 10;
                else if (pistasUsadas == 2) puntosRonda = 5;
                else puntosRonda = 2;
                puntuacionTotal += puntosRonda;
                System.out.println("¡Has ganado " + puntosRonda + " puntos en esta ronda!");
            } else {
                System.out.println("Te has quedado sin pistas. El personaje era: " + personajeElegido.getNombre());
            }

            System.out.println("Puntuación acumulada: " + puntuacionTotal + " puntos.");


            System.out.print("\n¿Deseas volver a jugar? (s/n): ");
            String respuestaContinuar = scanner.nextLine().trim();
            if (respuestaContinuar.equalsIgnoreCase("n")) {
                jugarNuevamente = false;
            }
        }


        ranking.add(new Jugador(nombreJugador, puntuacionTotal));
        Collections.sort(ranking);
        guardarRanking(gsonPretty, ranking);
        mostrarRanking(ranking);
        System.out.println("\n¡Gracias por jugar, " + nombreJugador + "!");
        scanner.close();
    }
    private static List<Personaje> cargarPersonajes(Gson gson) {
        try (FileReader reader = new FileReader(personajes)) {
            Type tipoLista = new TypeToken<List<Personaje>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de personajes: " + e.getMessage());
            return null;
        }
    }

    private static List<Jugador> cargarRanking(Gson gson) {
        try (FileReader reader = new FileReader(jugador)) {
            Type tipoLista = new TypeToken<List<Jugador>>() {}.getType();
            List<Jugador> ranking = gson.fromJson(reader, tipoLista);
            return ranking != null ? ranking : new ArrayList<>();
        } catch (IOException e) {

            return new ArrayList<>();
        }
    }
    private static void guardarRanking(Gson gson, List<Jugador> ranking) {
        try (FileWriter writer = new FileWriter(jugador)) {
            gson.toJson(ranking, writer);
            System.out.println("\n[INFO] Ranking actualizado correctamente en " + jugador);
        } catch (IOException e) {
            System.out.println("Error al guardar el ranking: " + e.getMessage());
        }
    }


    private static void mostrarRanking(List<Jugador> ranking) {
        System.out.println("\n==================================");
        System.out.println("       RANKING DE JUGADORES       ");
        System.out.println("==================================");
        int posicion = 1;
        for (Jugador j : ranking) {
            System.out.println(posicion + ". " + j.getNombre() + " - " + j.getPuntos() + " pts");
            posicion++;
            if (posicion > 5) break;
        }
    }
}

