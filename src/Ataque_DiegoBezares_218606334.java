import java.util.List;

public class Ataque_DiegoBezares_218606334 {
    private static int contadorIdAtaque = 0;

    private int id;
    private String nombre;
    private String descripcion;
    private List<RequisitoEnergia_DiegoBezares_218606334> costoEnergias;
    private int danoBase;
    private Efecto_DiegoBezares_218606334 efectoAsociado;

    public Ataque_DiegoBezares_218606334(String nombre, String descripcion, List<RequisitoEnergia_DiegoBezares_218606334> costoEnergias, int danoBase, Efecto_DiegoBezares_218606334 efectoAsociado) {
        this.id = contadorIdAtaque++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoEnergias = costoEnergias;
        this.danoBase = danoBase;
        this.efectoAsociado = efectoAsociado;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public List<RequisitoEnergia_DiegoBezares_218606334> getCostoEnergias() { return costoEnergias; }
    public int getDanoBase() { return danoBase; }
    public Efecto_DiegoBezares_218606334 getEfectoAsociado() { return efectoAsociado; }
}
