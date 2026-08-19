public class CartaEnergia_DiegoBezares_218606334 extends Carta_DiegoBezares_218606334 {
    private String tipo;

    public CartaEnergia_DiegoBezares_218606334(String nombre, int numero, String expansion, String tipo) {
        super(nombre, numero, expansion); // Llama al constructor de la clase abstracta
        this.tipo = tipo;
    }

    public String getTipo() { return tipo; }
}
