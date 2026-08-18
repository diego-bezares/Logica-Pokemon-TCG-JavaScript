import java.util.ArrayList;
import java.util.List;

public class Jugador_DiegoBezares_218606334 {
    private Mazo_DiegoBezares_218606334 mazo;
    private List<Carta_DiegoBezares_218606334> mano;
    private List<Carta_DiegoBezares_218606334> pilaDescarte;
    private List<Carta_DiegoBezares_218606334> premios;
    private CartaEnJuego_DiegoBezares_218606334 pokemonActivo;
    private List<CartaEnJuego_DiegoBezares_218606334> banca;

    public Jugador_DiegoBezares_218606334(Mazo_DiegoBezares_218606334 mazo) {
        this.mazo = mazo;
        this.mano = new ArrayList<>();
        this.pilaDescarte = new ArrayList<>();
        this.premios = new ArrayList<>();
        this.pokemonActivo = null;
        this.banca = new ArrayList<>();
    }

    // Getters y setters lógicos
    public Mazo_DiegoBezares_218606334 getMazo() { return mazo; }
    public List<Carta_DiegoBezares_218606334> getMano() { return mano; }
    public List<Carta_DiegoBezares_218606334> getPilaDescarte() { return pilaDescarte; }
    public List<Carta_DiegoBezares_218606334> getPremios() { return premios; }
    public CartaEnJuego_DiegoBezares_218606334 getPokemonActivo() { return pokemonActivo; }
    public void setPokemonActivo(CartaEnJuego_DiegoBezares_218606334 pokemonActivo) { this.pokemonActivo = pokemonActivo; }
    public List<CartaEnJuego_DiegoBezares_218606334> getBanca() { return banca; }
}
