import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_DiegoBezares_218606334 {

    private static Juego_DiegoBezares_218606334 juegoActual;
    private static List<Carta_DiegoBezares_218606334> catalogoCartasGenerales = new ArrayList<>();
    private static List<Mazo_DiegoBezares_218606334> catalogoMazos = new ArrayList<>();
    private static List<Ataque_DiegoBezares_218606334> catalogoAtaques = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        precargarDatosV1_1();

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            System.out.print("> ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                // --- SETUP ---
                case "1": crearCartaEnergiaLogica(); break;
                case "2": crearAtaqueLogica(); break;
                case "3": crearCartaPokemonLogica(); break;
                case "4": crearCartaEntrenadorLogica(); break;
                case "5": crearMazoLogica(); break;
                case "6": iniciarJuegoLogica(); break;
                case "7":
                    if (juegoActual != null) mostrarEstadoJuegoLogica();
                    else System.out.println("[Error] Debes iniciar el juego primero.");
                    break;

                // --- MENÚ EN JUEGO ---
                case "8": robarCartaLogica(); break;
                case "9": jugarPokemonBancaLogica(); break;
                case "10": cambiarActivoLogica(); break;
                case "11": unirEnergiaLogica(); break;
                case "12": evolucionarLogica(); break;
                case "13": usarEntrenadorLogica(); break;
                case "14": usarHabilidadLogica(); break;
                case "15": usarAtaqueLogica(); break;

                case "0":
                    salir = true;
                    System.out.println("[Sistema] Saliendo del programa.");
                    break;
                default:
                    System.out.println("[Error] Opción inválida.");
                    break;
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n######## POKEMON TCG - Paradigmas OOP ########");
        System.out.println("--- Setup ---");
        System.out.println("1. Crear carta de energia           (RF03)");
        System.out.println("2. Crear ataque                     (RF04)");
        System.out.println("3. Crear carta Pokemon              (RF05)");
        System.out.println("4. Crear carta de entrenador        (RF06)");
        System.out.println("5. Crear mazo (a partir de cartas)  (RF07)");
        System.out.println("6. Iniciar juego (2 mazos)          (RF08/09)");
        System.out.println("7. Mostrar estado del juego         (RF10)");
        System.out.println("--- En Juego ---");
        System.out.println("8. Robar carta                      (RF13)");
        System.out.println("9. Jugar Pokemon a la banca         (RF11)");
        System.out.println("10. Cambiar Pokemon activo          (RF12)");
        System.out.println("11. Unir energia a un Pokemon       (RF14)");
        System.out.println("12. Evolucionar un Pokemon          (RF15)");
        System.out.println("13. Usar carta de entrenador        (RF16)");
        System.out.println("14. Usar habilidad de Pokemon       (RF17)");
        System.out.println("15. Usar ataque / Pasar turno       (RF18)");
        System.out.println("0. Salir");
    }

    // --- MÉTODOS DE IMPLEMENTACIÓN FUNCIONAL ---

    private static void crearCartaEnergiaLogica() {
        System.out.println("\n[Sistema] --- Crear Carta de Energía (RF03) ---");
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Número de colección: "); int numero = scanner.nextInt(); scanner.nextLine();
        System.out.print("Expansión: "); String expansion = scanner.nextLine();
        System.out.print("Tipo (Fuego, Agua, etc.): "); String tipo = scanner.nextLine();

        catalogoCartasGenerales.add(new CartaEnergia_DiegoBezares_218606334(nombre, numero, expansion, tipo));
        System.out.println("[Éxito] Carta de energía añadida al catálogo global.");
    }

    private static void crearAtaqueLogica() {
        System.out.println("\n[Sistema] --- Crear Ataque (RF04) ---");
        System.out.print("Nombre del ataque: "); String nombre = scanner.nextLine();
        System.out.print("Descripción: "); String desc = scanner.nextLine();
        System.out.print("Daño base: "); int dano = scanner.nextInt(); scanner.nextLine();

        List<RequisitoEnergia_DiegoBezares_218606334> costo = new ArrayList<>();
        boolean agregando = true;
        while (agregando) {
            System.out.print("Cantidad de energía requerida: "); int cant = scanner.nextInt(); scanner.nextLine();
            System.out.print("Tipo de energía: "); String tipoReq = scanner.nextLine();
            costo.add(new RequisitoEnergia_DiegoBezares_218606334(cant, tipoReq));

            System.out.print("¿Agregar otro requisito? (s/n): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("n")) agregando = false;
        }

        Efecto_DiegoBezares_218606334 efectoNulo = new Efecto_DiegoBezares_218606334() {
            @Override
            public Juego_DiegoBezares_218606334 ejecutar(Juego_DiegoBezares_218606334 juegoIn, List<Object> args) { return juegoIn; }
        };

        catalogoAtaques.add(new Ataque_DiegoBezares_218606334(nombre, desc, costo, dano, efectoNulo));
        System.out.println("[Éxito] Ataque guardado en el catálogo.");
    }

    private static void crearCartaPokemonLogica() {
        System.out.println("\n[Sistema] --- Crear Carta Pokémon (RF05) ---");
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Número: "); int numero = scanner.nextInt(); scanner.nextLine();
        System.out.print("Expansión: "); String exp = scanner.nextLine();
        System.out.print("PS: "); int ps = scanner.nextInt(); scanner.nextLine();
        System.out.print("Tipo: "); String tipo = scanner.nextLine();

        System.out.print("¿Evoluciona de? (Enter si es Básico): "); String evo = scanner.nextLine();
        if (evo.trim().isEmpty()) evo = null;

        System.out.print("Debilidad (Enter si no tiene): "); String debilidad = scanner.nextLine();
        if (debilidad.trim().isEmpty()) debilidad = null;

        System.out.print("Resistencia (Enter si no tiene): "); String resistencia = scanner.nextLine();
        if (resistencia.trim().isEmpty()) resistencia = null;

        System.out.print("Coste retirada (cantidad incolora): "); int coste = scanner.nextInt(); scanner.nextLine();
        System.out.print("¿Es EX? (true/false): "); boolean esEx = scanner.nextBoolean(); scanner.nextLine();

        List<Ataque_DiegoBezares_218606334> ataquesSeleccionados = new ArrayList<>();
        if (!catalogoAtaques.isEmpty()) {
            System.out.println("\n--- Ataques Disponibles ---");
            for (int i = 0; i < catalogoAtaques.size(); i++) {
                System.out.println(i + ". " + catalogoAtaques.get(i).getNombre() + " (Daño: " + catalogoAtaques.get(i).getDanoBase() + ")");
            }
            boolean agregando = true;
            while (agregando && ataquesSeleccionados.size() < 3) {
                System.out.print("Ingrese número de ataque (-1 para terminar): ");
                int index = scanner.nextInt(); scanner.nextLine();
                if (index == -1) agregando = false;
                else if (index >= 0 && index < catalogoAtaques.size()) {
                    ataquesSeleccionados.add(catalogoAtaques.get(index));
                    System.out.println("Ataque agregado.");
                } else System.out.println("Índice inválido.");
            }
        }

        catalogoCartasGenerales.add(new CartaPokemon_DiegoBezares_218606334(nombre, numero, exp, ps, tipo, evo, debilidad, resistencia, coste, esEx, null, ataquesSeleccionados));
        System.out.println("[Éxito] Pokémon registrado en el catálogo global.");
    }

    private static void crearCartaEntrenadorLogica() {
        System.out.println("\n[Sistema] --- Crear Carta Entrenador (RF06) ---");
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Número: "); int numero = scanner.nextInt(); scanner.nextLine();
        System.out.print("Expansión: "); String exp = scanner.nextLine();
        System.out.print("Tipo (partidario/objeto): "); String tipo = scanner.nextLine();
        System.out.print("Texto: "); String texto = scanner.nextLine();

        Efecto_DiegoBezares_218606334 efectoNulo = new Efecto_DiegoBezares_218606334() {
            @Override
            public Juego_DiegoBezares_218606334 ejecutar(Juego_DiegoBezares_218606334 juegoIn, List<Object> args) { return juegoIn; }
        };

        catalogoCartasGenerales.add(new CartaEntrenador_DiegoBezares_218606334(nombre, numero, exp, tipo, texto, efectoNulo));
        System.out.println("[Éxito] Entrenador creado.");
    }

    private static void crearMazoLogica() {
        System.out.println("\n[Sistema] --- Crear Mazo (RF07) ---");
        if (catalogoCartasGenerales.isEmpty()) {
            System.out.println("[Error] No hay cartas en el catálogo para armar un mazo.");
            return;
        }

        List<Carta_DiegoBezares_218606334> cartasMazo = new ArrayList<>();
        System.out.println("Agregando cartas automáticamente para simular un mazo válido...");
        while(cartasMazo.size() < 60) {
            cartasMazo.add(catalogoCartasGenerales.get(0)); // Añade copias de la primera carta (idealmente valida la regla de 4 copias)
        }
        catalogoMazos.add(new Mazo_DiegoBezares_218606334(cartasMazo));
        System.out.println("[Éxito] Mazo creado con 60 cartas y añadido al catálogo de mazos.");
    }

    private static void iniciarJuegoLogica() {
        System.out.println("\n[Sistema] --- Iniciar Juego (RF09) ---");
        if (catalogoMazos.size() < 1) {
            System.out.println("[Error] Debes tener al menos 1 mazo creado.");
            return;
        }
        Jugador_DiegoBezares_218606334 j1 = new Jugador_DiegoBezares_218606334(catalogoMazos.get(0));
        Jugador_DiegoBezares_218606334 j2 = new Jugador_DiegoBezares_218606334(catalogoMazos.get(catalogoMazos.size() - 1));

        // RF08: Barajar Mazos
        Collections.shuffle(j1.getMazo().getCartas());
        Collections.shuffle(j2.getMazo().getCartas());
        System.out.println("[Sistema] Mazos barajados.");

        juegoActual = new Juego_DiegoBezares_218606334(j1, j2);

        // Simulación básica de robar 7 cartas y separar 6 premios (RF09)
        for(int i=0; i<7; i++) { j1.robarCarta(); j2.robarCarta(); }
        for(int i=0; i<6; i++) {
            if(!j1.getMazo().getCartas().isEmpty()) j1.addPremio(j1.getMazo().getCartas().remove(0));
            if(!j2.getMazo().getCartas().isEmpty()) j2.addPremio(j2.getMazo().getCartas().remove(0));
        }
        System.out.println("[Éxito] Juego inicializado, cartas robadas y premios asignados.");
    }

    private static void mostrarEstadoJuegoLogica() {
        System.out.println("\n=== ESTADO DEL JUEGO (RF10) ===");
        System.out.println("Turno actual: Jugador " + juegoActual.getTurnoActual());

        Jugador_DiegoBezares_218606334 jTurno = juegoActual.getJugadorEnTurno();
        Jugador_DiegoBezares_218606334 jOponente = juegoActual.getOponente();

        System.out.println("\n[Jugador en Turno]");
        System.out.println("Premios restantes: " + jTurno.getPremios().size());
        System.out.println("Cartas en mazo: " + jTurno.getMazo().getCartas().size());
        System.out.println("Cartas en mano: " + jTurno.getMano().size());
        System.out.println("Pokémon Activo: " + (jTurno.getPokemonActivo() != null ? jTurno.getPokemonActivo().getCartaBase().getNombre() : "Ninguno"));
        System.out.println("Pokémon en Banca: " + jTurno.getBanca().size());

        System.out.println("\n[Oponente]");
        System.out.println("Premios restantes: " + jOponente.getPremios().size());
        System.out.println("Cartas en mazo: " + jOponente.getMazo().getCartas().size());
        System.out.println("Cartas en mano: " + jOponente.getMano().size());
        System.out.println("Pokémon Activo: " + (jOponente.getPokemonActivo() != null ? jOponente.getPokemonActivo().getCartaBase().getNombre() : "Ninguno"));
        System.out.println("===============================");
    }

    // --- MÉTODOS EN JUEGO (Llaman a la lógica de los TDAs) ---

    private static void robarCartaLogica() {
        if(juegoActual == null) return;
        juegoActual.getJugadorEnTurno().robarCarta();
    }

    private static void jugarPokemonBancaLogica() {
        if(juegoActual == null) return;
        Jugador_DiegoBezares_218606334 j = juegoActual.getJugadorEnTurno();
        if(j.getMano().isEmpty()) return;

        for(Carta_DiegoBezares_218606334 c : j.getMano()) {
            if(c instanceof CartaPokemon_DiegoBezares_218606334) {
                CartaPokemon_DiegoBezares_218606334 p = (CartaPokemon_DiegoBezares_218606334) c;
                if(p.getEvolucionaDe() == null) {
                    j.jugarABanca(p);
                    return;
                }
            }
        }
        System.out.println("[Sistema] No tienes Pokémon básicos en la mano.");
    }

    private static void cambiarActivoLogica() {
        if(juegoActual == null) return;
        Jugador_DiegoBezares_218606334 j = juegoActual.getJugadorEnTurno();
        if(j.getBanca().isEmpty()) {
            System.out.println("[Sistema] No hay Pokémon en la banca para cambiar.");
            return;
        }
        j.cambiarPokemonActivo(j.getBanca().get(0));
    }

    private static void unirEnergiaLogica() {
        if(juegoActual == null) return;
        Jugador_DiegoBezares_218606334 j = juegoActual.getJugadorEnTurno();
        if(j.getPokemonActivo() == null) return;

        for(Carta_DiegoBezares_218606334 c : j.getMano()) {
            if(c instanceof CartaEnergia_DiegoBezares_218606334) {
                j.usarCartaEnergia(j.getPokemonActivo(), (CartaEnergia_DiegoBezares_218606334) c);
                return;
            }
        }
        System.out.println("[Sistema] No tienes energías en la mano.");
    }

    private static void evolucionarLogica() {
        if (juegoActual == null) return;
        Jugador_DiegoBezares_218606334 j = juegoActual.getJugadorEnTurno();

        // 1. Buscar una carta de evolución en la mano
        CartaPokemon_DiegoBezares_218606334 cartaEvolucion = null;
        for (Carta_DiegoBezares_218606334 c : j.getMano()) {
            if (c instanceof CartaPokemon_DiegoBezares_218606334) {
                CartaPokemon_DiegoBezares_218606334 p = (CartaPokemon_DiegoBezares_218606334) c;
                if (p.getEvolucionaDe() != null) { // Si tiene evolucionaDe, es una evolución
                    cartaEvolucion = p;
                    break;
                }
            }
        }

        if (cartaEvolucion == null) {
            System.out.println("[Sistema] No tienes cartas de evolución en tu mano.");
            return;
        }

        // 2. Buscar un objetivo válido en juego que coincida con el nombre
        CartaEnJuego_DiegoBezares_218606334 objetivo = null;

        // Revisamos primero el activo
        if (j.getPokemonActivo() != null && cartaEvolucion.getEvolucionaDe().equals(j.getPokemonActivo().getCartaBase().getNombre())) {
            objetivo = j.getPokemonActivo();
        } else {
            // Revisamos la banca
            for (CartaEnJuego_DiegoBezares_218606334 pBanca : j.getBanca()) {
                if (cartaEvolucion.getEvolucionaDe().equals(pBanca.getCartaBase().getNombre())) {
                    objetivo = pBanca;
                    break;
                }
            }
        }

        if (objetivo == null) {
            System.out.println("[Sistema] Tienes a " + cartaEvolucion.getNombre() + " en mano, pero no tienes a un " + cartaEvolucion.getEvolucionaDe() + " válido en juego.");
            return;
        }

        // 3. Llamar al TDA Jugador para ejecutar la lógica de evolución (RF15)
        j.evolucionarPokemon(objetivo, cartaEvolucion);
    }

    private static void usarEntrenadorLogica() {
        if (juegoActual == null) return;
        Jugador_DiegoBezares_218606334 j = juegoActual.getJugadorEnTurno();

        // 1. Buscar una carta de Entrenador en la mano
        CartaEntrenador_DiegoBezares_218606334 entrenador = null;
        for (Carta_DiegoBezares_218606334 c : j.getMano()) {
            if (c instanceof CartaEntrenador_DiegoBezares_218606334) {
                entrenador = (CartaEntrenador_DiegoBezares_218606334) c;
                break;
            }
        }

        if (entrenador == null) {
            System.out.println("[Sistema] No tienes cartas de entrenador en la mano.");
            return;
        }

        System.out.println("[Sistema] Usando carta de entrenador: " + entrenador.getNombre());

        // 2. Ejecutar el efecto asociado de forma polimórfica (RF16)
        if (entrenador.getEfectoAsociado() != null) {
            // Se le pasa una lista vacía de argumentos por defecto para la simulación
            juegoActual = entrenador.getEfectoAsociado().ejecutar(juegoActual, new ArrayList<>());
        }

        // 3. Descartar la carta
        j.getMano().remove(entrenador);
        j.getPilaDescarte().add(entrenador);
        System.out.println("[Sistema] Efecto aplicado y carta enviada a la pila de descarte.");
    }

    private static void usarHabilidadLogica() {
        if (juegoActual == null) return;
        Jugador_DiegoBezares_218606334 j = juegoActual.getJugadorEnTurno();

        CartaEnJuego_DiegoBezares_218606334 pkmConHabilidad = null;

        // 1. Buscar en el Pokémon activo
        if (j.getPokemonActivo() != null && j.getPokemonActivo().getCartaBase().getHabilidad() != null) {
            pkmConHabilidad = j.getPokemonActivo();
        } else {
            // 2. Buscar en la banca
            for (CartaEnJuego_DiegoBezares_218606334 pBanca : j.getBanca()) {
                if (pBanca.getCartaBase().getHabilidad() != null) {
                    pkmConHabilidad = pBanca;
                    break;
                }
            }
        }

        if (pkmConHabilidad == null) {
            System.out.println("[Sistema] Ninguno de tus Pokémon en juego posee una habilidad.");
            return;
        }

        Ataque_DiegoBezares_218606334 habilidad = pkmConHabilidad.getCartaBase().getHabilidad();
        System.out.println("[Sistema] Activando la habilidad: " + habilidad.getNombre() + " de " + pkmConHabilidad.getCartaBase().getNombre());

        // 3. Ejecutar el efecto polimórfico de la habilidad (RF17)
        if (habilidad.getEfectoAsociado() != null) {
            juegoActual = habilidad.getEfectoAsociado().ejecutar(juegoActual, new ArrayList<>());
        }
    }

    private static void usarAtaqueLogica() {
        if(juegoActual == null) return;
        System.out.println("[Sistema] ¿Desea (1) Atacar o (2) Pasar Turno?: ");
        String accion = scanner.nextLine();
        switch(accion) {
            case "2":
                juegoActual.pasarTurno();
                break;
            case "1":
                Jugador_DiegoBezares_218606334 j = juegoActual.getJugadorEnTurno();
                if (j.getPokemonActivo() == null) {
                    System.out.println("[Sistema] No hay activo.");
                    return;
                }

                List<Ataque_DiegoBezares_218606334> ataques = j.getPokemonActivo().getCartaBase().getAtaques();
                if (ataques.isEmpty()) {
                    System.out.println("[Sistema] El Pokémon no tiene ataques.");
                    return;
                }

                // Simula usar el primer ataque
                juegoActual.usarAtaquePokemon(ataques.get(0), new ArrayList<>());
                break;
            default:
                System.out.println("[Error] Opción inválida.");
                System.out.println("[Sistema] Pasando turno...");
                break;
        }
    }

    // --- PRECARGA DE DATOS V1.1 ---
    private static void precargarDatosV1_1() {
        System.out.println("[Sistema] Precargando datos para revisión (V1.1)...");

        // A. Instanciar Efectos (Patrón Estrategia)
        Efecto_DiegoBezares_218606334 efectoNulo = new Efecto_DiegoBezares_218606334() {
            @Override
            public Juego_DiegoBezares_218606334 ejecutar(Juego_DiegoBezares_218606334 juegoIn, List<Object> args) {
                return juegoIn;
            }
        };

        // B. Crear cartas de Energía
        CartaEnergia_DiegoBezares_218606334 energiaFuego = new CartaEnergia_DiegoBezares_218606334("Fuego", 1, "Base Set", "Fuego");

        // C. Crear Requisitos de Ataque y Ataques
        List<RequisitoEnergia_DiegoBezares_218606334> costoLlamarada = new ArrayList<>();
        costoLlamarada.add(new RequisitoEnergia_DiegoBezares_218606334(2, "Fuego"));
        Ataque_DiegoBezares_218606334 ataqueLlamarada = new Ataque_DiegoBezares_218606334("Llamarada", "Quema al rival", costoLlamarada, 50, efectoNulo);

        // D. Crear Cartas Pokémon (Básico y Evolución)
        List<Ataque_DiegoBezares_218606334> ataquesPkm = new ArrayList<>();
        ataquesPkm.add(ataqueLlamarada);

        CartaPokemon_DiegoBezares_218606334 charmander = new CartaPokemon_DiegoBezares_218606334(
                "Charmander", 4, "Base Set", 60, "Fuego", null, "Agua", null, 1, false, null, ataquesPkm
        );

        CartaPokemon_DiegoBezares_218606334 charmeleon = new CartaPokemon_DiegoBezares_218606334(
                "Charmeleon", 5, "Base Set", 80, "Fuego", "Charmander", "Agua", null, 1, false, null, ataquesPkm
        );

        // E. Crear Carta de Entrenador con Efecto Real
        Efecto_DiegoBezares_218606334 efectoProfesorOak = new Efecto_DiegoBezares_218606334() {
            @Override
            public Juego_DiegoBezares_218606334 ejecutar(Juego_DiegoBezares_218606334 juegoIn, List<Object> args) {
                System.out.println("[Efecto Aplicado] Profesor Oak te hace robar 2 cartas del mazo.");
                juegoIn.getJugadorEnTurno().robarCarta();
                juegoIn.getJugadorEnTurno().robarCarta();
                return juegoIn;
            }
        };
        CartaEntrenador_DiegoBezares_218606334 profesorOak = new CartaEntrenador_DiegoBezares_218606334(
                "Profesor Oak", 10, "Base Set", "Partidario", "Roba 2 cartas.", efectoProfesorOak
        );

        // F. Crear el Mazo
        List<Carta_DiegoBezares_218606334> cartasMazo1 = new ArrayList<>();
        // Metemos 4 de cada uno para asegurar que salgan en el robo inicial
        for(int i = 0; i < 4; i++) { cartasMazo1.add(charmander); }
        for(int i = 0; i < 4; i++) { cartasMazo1.add(charmeleon); }
        for(int i = 0; i < 4; i++) { cartasMazo1.add(profesorOak); }
        // Rellenamos el resto (48 cartas) con energías
        for(int i = 0; i < 48; i++) { cartasMazo1.add(energiaFuego); }

        Mazo_DiegoBezares_218606334 mazo1 = new Mazo_DiegoBezares_218606334(cartasMazo1);
        catalogoMazos.add(mazo1);
        catalogoMazos.add(mazo1);

        System.out.println("[Sistema] Jugadores, mazos (60 cartas con evolución y entrenador) cargados correctamente.");
    }
}