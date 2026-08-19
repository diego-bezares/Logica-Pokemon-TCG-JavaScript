import java.util.List;

public class Mazo_DiegoBezares_218606334 {
    private static int contadorIdMazo = 0;

    private int idMazo;
    private List<Carta_DiegoBezares_218606334> cartas;

    public Mazo_DiegoBezares_218606334(List<Carta_DiegoBezares_218606334> cartas) {
        this.idMazo = contadorIdMazo++;
        this.cartas = cartas;
    }

    public int getIdMazo() { return idMazo; }
    public List<Carta_DiegoBezares_218606334> getCartas() { return cartas; }
    public void setCartas(List<Carta_DiegoBezares_218606334> cartas) { this.cartas = cartas; }
}
