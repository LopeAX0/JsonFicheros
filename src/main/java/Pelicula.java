public class Pelicula {
    //Ponemos las etiquetas de lo que ahi en el documento json
    private String  titulo;
    private String director;
    private int año;
    //Creamos un construcctor vacio
    public Pelicula(){

    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setAño(int año) {
        this.año = año;
    }

    //Creamos los geters de todos los atributos de la clase con los cuales se metera los datos del json
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
        //Este mensaje se mostrara a la hora de hacer el print
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", año=" + año +
                '}';
    }
}
