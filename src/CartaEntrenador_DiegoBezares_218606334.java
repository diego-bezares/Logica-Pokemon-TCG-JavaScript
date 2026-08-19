public class CartaEntrenador_DiegoBezares_218606334 extends Carta_DiegoBezares_218606334 {
    private String tipoEntrenador;
    private String texto;
    private Efecto_DiegoBezares_218606334 efectoAsociado;

    public CartaEntrenador_DiegoBezares_218606334(String nombre, int numero, String expansion,
                                                  String tipoEntrenador, String texto,
                                                  Efecto_DiegoBezares_218606334 efectoAsociado) {
        super(nombre, numero, expansion);
        this.tipoEntrenador = tipoEntrenador;
        this.texto = texto;
        this.efectoAsociado = efectoAsociado;
    }

    public String getTipoEntrenador() { return tipoEntrenador; }
    public String getTexto() { return texto; }
    public Efecto_DiegoBezares_218606334 getEfectoAsociado() { return efectoAsociado; }
}
