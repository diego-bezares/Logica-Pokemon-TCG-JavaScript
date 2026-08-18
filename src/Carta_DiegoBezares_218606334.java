public abstract class Carta_DiegoBezares_218606334 {
    private static int contadorIdGlobal = 0;

    private int id;
    private String nombre;
    private int numero;
    private String expansion;

    public Carta_DiegoBezares_218606334(String nombre, int numero, String expansion) {
        this.id = contadorIdGlobal++; // Se autoincrementa solo al crear
        this.nombre = nombre;
        this.numero = numero;
        this.expansion = expansion;
    }

    // Selectores básicos
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getNumero() { return numero; }
    public String getExpansion() { return expansion; }
}
