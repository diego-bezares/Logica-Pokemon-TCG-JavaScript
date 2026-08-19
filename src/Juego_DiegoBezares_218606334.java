import java.util.List;

public class Juego_DiegoBezares_218606334 {
    private Jugador_DiegoBezares_218606334 jugador1;
    private Jugador_DiegoBezares_218606334 jugador2;
    private int turnoActual;

    public Juego_DiegoBezares_218606334(Jugador_DiegoBezares_218606334 jugador1, Jugador_DiegoBezares_218606334 jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turnoActual = 1;
    }

    public Jugador_DiegoBezares_218606334 getJugadorEnTurno() {
        return (turnoActual == 1) ? jugador1 : jugador2;
    }

    public Jugador_DiegoBezares_218606334 getOponente() {
        return (turnoActual == 1) ? jugador2 : jugador1;
    }

    // RF18: Usar Ataque
    public void usarAtaquePokemon(Ataque_DiegoBezares_218606334 ataque, List<Object> argumentos) {
        Jugador_DiegoBezares_218606334 atacante = getJugadorEnTurno();
        Jugador_DiegoBezares_218606334 defensor = getOponente();

        CartaEnJuego_DiegoBezares_218606334 pokemonAtacante = atacante.getPokemonActivo();
        CartaEnJuego_DiegoBezares_218606334 pokemonDefensor = defensor.getPokemonActivo();

        if (pokemonAtacante == null) {
            System.out.println("No tienes Pokémon activo para atacar.");
            return;
        }

        // 1. Validar Energías
        int energiasRequeridas = 0;
        for (RequisitoEnergia_DiegoBezares_218606334 req : ataque.getCostoEnergias()) {
            energiasRequeridas += req.getCantidad();
        }
        if (pokemonAtacante.getEnergiasUnidas().size() < energiasRequeridas) {
            System.out.println("No hay energías suficientes para " + ataque.getNombre());
            return;
        }

        // 2. Ejecutar Efecto Polimórfico
        if (ataque.getEfectoAsociado() != null) {
            ataque.getEfectoAsociado().ejecutar(this, argumentos);
        }

        // 3. Aplicar Daño y Modificadores si hay defensor
        if (pokemonDefensor != null) {
            int danoFinal = ataque.getDanoBase();
            String tipoAtaque = pokemonAtacante.getCartaBase().getTipo();
            String debilidadRival = pokemonDefensor.getCartaBase().getDebilidad();
            String resistenciaRival = pokemonDefensor.getCartaBase().getResistencia();

            if (tipoAtaque.equals(debilidadRival)) {
                danoFinal *= 2;
                System.out.println("¡Es súper eficaz! Daño x2.");
            } else if (tipoAtaque.equals(resistenciaRival)) {
                danoFinal -= 30;
                System.out.println("El rival resiste el ataque. Daño -30.");
            }

            danoFinal = Math.max(0, danoFinal);
            pokemonDefensor.setDanoAcumulado(pokemonDefensor.getDanoAcumulado() + danoFinal);
            System.out.println(ataque.getNombre() + " causó " + danoFinal + " puntos de daño.");

            // 4. Revisar Knock Out
            if (pokemonDefensor.getCartaBase().getPs() <= pokemonDefensor.getDanoAcumulado()) {
                procesarKnockOut(atacante, defensor, pokemonDefensor);
            }
        }

        // 5. Fin de turno
        pasarTurno();
    }

    private void procesarKnockOut(Jugador_DiegoBezares_218606334 atacante, Jugador_DiegoBezares_218606334 defensor, CartaEnJuego_DiegoBezares_218606334 derrotado) {
        System.out.println("¡" + derrotado.getCartaBase().getNombre() + " ha sido derrotado!");

        // Mover a la pila de descarte
        defensor.getPilaDescarte().add(derrotado.getCartaBase());
        defensor.setPokemonActivo(null);

        // Tomar premios
        int premiosATomar = derrotado.getCartaBase().isEsEX() ? 2 : 1;
        for (int i = 0; i < premiosATomar; i++) {
            if (!defensor.getPremios().isEmpty()) {
                Carta_DiegoBezares_218606334 premio = defensor.getPremios().remove(0);
                atacante.getMano().add(premio);
                System.out.println("Has tomado una carta de premio.");
            }
        }

        // Condición de Victoria
        if (defensor.getPremios().isEmpty()) {
            System.out.println("¡Has tomado todos tus premios! VICTORIA ABSOLUTA.");
        } else if (defensor.getBanca().isEmpty() && defensor.getPokemonActivo() == null) {
            System.out.println("El rival no tiene más Pokémon en juego. VICTORIA ABSOLUTA.");
        }
    }

    public void pasarTurno() {
        System.out.println("Fin del turno " + turnoActual);

        Jugador_DiegoBezares_218606334 jugadorQueTermina = (turnoActual == 1) ? jugador1 : jugador2;

        if (jugadorQueTermina.getPokemonActivo() != null) {
            jugadorQueTermina.getPokemonActivo().incrementarTurno();
        }

        for (CartaEnJuego_DiegoBezares_218606334 pBanca : jugadorQueTermina.getBanca()) {
            pBanca.incrementarTurno();
        }

        turnoActual = (turnoActual == 1) ? 2 : 1;
    }

    public int getTurnoActual() { return turnoActual; }
}