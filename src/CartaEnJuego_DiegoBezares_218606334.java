import java.util.ArrayList;
import java.util.List;

public class CartaEnJuego_DiegoBezares_218606334 {
    private static int contadorIdInstancia = 0;

    private int idInstancia;
    private CartaPokemon_DiegoBezares_218606334 cartaBase;
    private int danoAcumulado;
    private String estado;
    private int turnosEnJuego;
    private List<CartaEnergia_DiegoBezares_218606334> energiasUnidas;
    private List<CartaPokemon_DiegoBezares_218606334> historialEvolucion;

    public CartaEnJuego_DiegoBezares_218606334(CartaPokemon_DiegoBezares_218606334 cartaBase) {
        this.idInstancia = contadorIdInstancia++;
        this.cartaBase = cartaBase;
        this.danoAcumulado = 0;
        this.estado = "normal";
        this.turnosEnJuego = 0;
        this.energiasUnidas = new ArrayList<>();
        this.historialEvolucion = new ArrayList<>();
    }

    // Selectores y modificadores básicos
    public int getIdInstancia() { return idInstancia; }
    public CartaPokemon_DiegoBezares_218606334 getCartaBase() { return cartaBase; }
    public int getDanoAcumulado() { return danoAcumulado; }
    public void setDanoAcumulado(int danoAcumulado) { this.danoAcumulado = danoAcumulado; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public int getTurnosEnJuego() { return turnosEnJuego; }
    public void incrementarTurno() { this.turnosEnJuego++; }
    public List<CartaEnergia_DiegoBezares_218606334> getEnergiasUnidas() { return energiasUnidas; }
    public List<CartaPokemon_DiegoBezares_218606334> getHistorialEvolucion() { return historialEvolucion; }
}