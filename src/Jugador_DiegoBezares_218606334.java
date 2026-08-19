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

    // RF13: Robar carta
    public void robarCarta() {
        if (!mazo.getCartas().isEmpty()) {
            Carta_DiegoBezares_218606334 robada = mazo.getCartas().remove(0);
            mano.add(robada);
            System.out.println("Has robado: " + robada.getNombre());
        } else {
            System.out.println("El mazo está vacío. Has perdido la partida por deck out.");
            // La lógica de victoria se maneja en la clase Juego
        }
    }

    // RF11: Jugar a Banca
    public void jugarABanca(CartaPokemon_DiegoBezares_218606334 pokemonBasico) {
        if (banca.size() < 5) {
            if (pokemonBasico.getEvolucionaDe() == null) { // Valida que sea básico
                CartaEnJuego_DiegoBezares_218606334 nuevoEnJuego = new CartaEnJuego_DiegoBezares_218606334(pokemonBasico);
                banca.add(nuevoEnJuego);
                mano.remove(pokemonBasico);
                System.out.println(pokemonBasico.getNombre() + " ha sido enviado a la banca.");
            } else {
                System.out.println("Solo puedes jugar Pokémon básicos directamente a la banca.");
            }
        } else {
            System.out.println("La banca está llena (máximo 5).");
        }
    }

    // RF12: Cambiar Pokémon Activo
    public void cambiarPokemonActivo(CartaEnJuego_DiegoBezares_218606334 nuevoActivo) {
        if (!banca.contains(nuevoActivo)) {
            System.out.println("El Pokémon debe estar en la banca.");
            return;
        }

        if (pokemonActivo != null) {
            // Lógica de costo de retirada
            int costo = pokemonActivo.getCartaBase().getCosteRetirada();
            if (pokemonActivo.getEnergiasUnidas().size() >= costo) {
                for (int i = 0; i < costo; i++) {
                    CartaEnergia_DiegoBezares_218606334 descartada = pokemonActivo.getEnergiasUnidas().remove(0);
                    pilaDescarte.add(descartada);
                }
                System.out.println("Costo de retirada pagado. " + pokemonActivo.getCartaBase().getNombre() + " va a la banca.");
                banca.add(pokemonActivo);
            } else {
                System.out.println("No tienes suficientes energías para pagar la retirada.");
                return;
            }
        }

        pokemonActivo = nuevoActivo;
        banca.remove(nuevoActivo);
        System.out.println("¡"  + nuevoActivo.getCartaBase().getNombre() + " está en combate!.");
    }


    // RF14: Usar Carta de Energía
    public void usarCartaEnergia (CartaEnJuego_DiegoBezares_218606334 destino, CartaEnergia_DiegoBezares_218606334 energia){
            if (mano.contains(energia)) {
                destino.getEnergiasUnidas().add(energia);
                mano.remove(energia);
                System.out.println("Energía " + energia.getTipo() + " unida a " + destino.getCartaBase().getNombre());
            }
    }

    // RF15: Evolucionar Pokémon
    public void evolucionarPokemon (CartaEnJuego_DiegoBezares_218606334 objetivo, CartaPokemon_DiegoBezares_218606334 evolucion){
            if (objetivo.getTurnosEnJuego() < 1) {
                System.out.println("El Pokémon debe llevar al menos 1 turno en juego para evolucionar.");
                return;
            }
            if (evolucion.getEvolucionaDe() != null && evolucion.getEvolucionaDe().equals(objetivo.getCartaBase().getNombre())) {
                objetivo.getHistorialEvolucion().add(objetivo.getCartaBase());
                objetivo.setCartaBase(evolucion);
                objetivo.setEstado("normal");
                objetivo.resetTurnosEnJuego();
                mano.remove(evolucion);
                System.out.println("¡Evolución completada a " + evolucion.getNombre() + "!");
            } else {
                System.out.println("Evolución no compatible.");
            }
    }

        // Getters y setters lógicos
        public Mazo_DiegoBezares_218606334 getMazo () {
            return mazo;
        }
        public List<Carta_DiegoBezares_218606334> getMano () {
            return mano;
        }
        public List<Carta_DiegoBezares_218606334> getPilaDescarte () {
            return pilaDescarte;
        }
        public List<Carta_DiegoBezares_218606334> getPremios () {
            return premios;
        }
        public CartaEnJuego_DiegoBezares_218606334 getPokemonActivo () {
            return pokemonActivo;
        }
        public void setPokemonActivo (CartaEnJuego_DiegoBezares_218606334 pokemonActivo){
            this.pokemonActivo = pokemonActivo;
        }
        public void addPremio (Carta_DiegoBezares_218606334 premio){
            this.premios.add(premio);
        }
        public List<CartaEnJuego_DiegoBezares_218606334> getBanca () {
            return banca;
        }
}

