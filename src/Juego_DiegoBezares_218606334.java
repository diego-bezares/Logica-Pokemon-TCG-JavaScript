public class Juego_DiegoBezares_218606334 {
    private Jugador_DiegoBezares_218606334 jugador1;
    private Jugador_DiegoBezares_218606334 jugador2;
    private int turnoActual; // 1 para jugador1, 2 para jugador2

    public Juego_DiegoBezares_218606334(Jugador_DiegoBezares_218606334 jugador1, Jugador_DiegoBezares_218606334 jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turnoActual = 1;
    }

    public Jugador_DiegoBezares_218606334 getJugador1() { return jugador1; }
    public Jugador_DiegoBezares_218606334 getJugador2() { return jugador2; }
    public int getTurnoActual() { return turnoActual; }
    public void setTurnoActual(int turnoActual) { this.turnoActual = turnoActual; }
}