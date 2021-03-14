package co.com.sofka.domain.juego;

import co.com.sofka.domain.factory.JugadorFactory;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.juego.event.JuegoCreado;
import co.com.sofka.domain.juego.event.JuegoInicializado;
import co.com.sofka.domain.juego.event.JugadorAdicionado;
import co.com.sofka.domain.juego.values.Dinero;
import co.com.sofka.domain.juego.values.JuegoId;
import co.com.sofka.domain.juego.values.JugadorId;
import co.com.sofka.domain.juego.values.JugadorNombre;
import co.com.sofka.domain.ronda.values.RondaId;

import java.util.List;
import java.util.Map;

public class Juego extends AggregateEvent<JuegoId> {
    protected Map<JugadorId, Jugador> jugadores;
    protected Boolean jugando;
    protected RondaId rondaId;

    public Juego(JuegoId entityId, JugadorFactory jugadorFactory) {
        super(entityId);
        appendChange(new JuegoCreado(entityId)).apply();
        jugadorFactory.jugadores()
                .forEach(jugador -> adicionarJugador(jugador.identity(), jugador.jugadorNombre(), jugador.dinero()));
    }

    private Juego(JuegoId entityId) {
        super(entityId);
        subscribe(new JuegoChange(this));
    }

    public static Juego from(JuegoId entityId, List<DomainEvent> events) {
        var juego = new Juego(entityId);
        events.forEach(juego::applyEvent);
        return juego;
    }

    public void adicionarJugador(JugadorId jugadorId, JugadorNombre jugadorNombre, Dinero dinero) {
        appendChange(new JugadorAdicionado(jugadorId, jugadorNombre, dinero)).apply();
    }
    // Iniciar el juego
    public void iniciarJuego() {
        var jugadoresIds = jugadores.keySet();
        appendChange(new JuegoInicializado(jugadoresIds)).apply();
    }

    public RondaId rondaId() {
        return rondaId;
    }

    public Boolean isJuegoInicializado() {
        return jugando;
    }
}