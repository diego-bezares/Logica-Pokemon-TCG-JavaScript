import java.util.List;

public class CartaPokemon_DiegoBezares_218606334 extends Carta_DiegoBezares_218606334 {
    private int ps;
    private String tipo;
    private String evolucionaDe; // null si es básico
    private String debilidad;
    private String resistencia;
    private int costeRetirada;
    private boolean esEX;
    private Ataque_DiegoBezares_218606334 habilidad; // null si no tiene
    private List<Ataque_DiegoBezares_218606334> ataques;

    public CartaPokemon_DiegoBezares_218606334(String nombre, int numero, String expansion, int ps, String tipo,
                                               String evolucionaDe, String debilidad, String resistencia,
                                               int costeRetirada, boolean esEX, Ataque_DiegoBezares_218606334 habilidad,
                                               List<Ataque_DiegoBezares_218606334> ataques) {
        super(nombre, numero, expansion);
        this.ps = ps;
        this.tipo = tipo;
        this.evolucionaDe = evolucionaDe;
        this.debilidad = debilidad;
        this.resistencia = resistencia;
        this.costeRetirada = costeRetirada;
        this.esEX = esEX;
        this.habilidad = habilidad;
        this.ataques = ataques;
    }

    // Selectores
    public int getPs() { return ps; }
    public String getTipo() { return tipo; }
    public String getEvolucionaDe() { return evolucionaDe; }
    public String getDebilidad() { return debilidad; }
    public String getResistencia() { return resistencia; }
    public int getCosteRetirada() { return costeRetirada; }
    public boolean isEsEX() { return esEX; }
    public Ataque_DiegoBezares_218606334 getHabilidad() { return habilidad; }
    public List<Ataque_DiegoBezares_218606334> getAtaques() { return ataques; }
}
