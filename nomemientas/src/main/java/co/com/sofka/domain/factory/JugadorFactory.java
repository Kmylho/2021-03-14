package co.com.sofka.domain.factory;

import co.com.sofka.domain.juego.Jugador;
import co.com.sofka.domain.juego.values.Dinero;
import co.com.sofka.domain.juego.values.JugadorId;
import co.com.sofka.domain.juego.values.JugadorNombre;

import java.util.HashSet;
import java.util.Set;

public class JugadorFactory {
    private final Set<Jugador> jugadores;

    private JugadorFactory() {
        jugadores = new HashSet<>();
    }

    public static JugadorFactory builder() {
        return new JugadorFactory();
    }

    public JugadorFactory nuevoJugador(JugadorId jugadorId, JugadorNombre nombrejugador, Dinero dinero) {
        jugadores.add(new Jugador(jugadorId, nombrejugador, dinero));
        return this;
    }

    public Set<Jugador> jugadores() {
        return jugadores;
    }

}