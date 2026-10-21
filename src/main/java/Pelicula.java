public class Pelicula {

    private String  titulo;
    private String director;
    private int año;

    public Pelicula(){

    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getAño() {
        return año;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", año=" + año +
                '}';
    }
}
