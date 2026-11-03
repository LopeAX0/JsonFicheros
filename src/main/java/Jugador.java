public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private int puntos;

    public Jugador() {
    }

    public Jugador(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public int compareTo(Jugador otro) {
        return Integer.compare(otro.puntos, this.puntos);
    }


}
