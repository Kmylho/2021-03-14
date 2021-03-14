package co.com.sofka.domain.juego;

import co.com.sofka.domain.factory.JugadorFactory;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.juego.event.JuegoCreado;
import co.com.sofka.domain.juego.event.JugadorAdicionado;
import co.com.sofka.domain.juego.values.Dinero;
import co.com.sofka.domain.juego.values.JuegoId;
import co.com.sofka.domain.juego.values.JugadorId;
import co.com.sofka.domain.juego.values.JugadorNombre;
import co.com.sofka.domain.ronda.values.RondaId;

import java.util.Map;
import java.util.function.BiFunction;

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
    //Añade jugadores
    public void adicionarJugador(JugadorId jugadorId, JugadorNombre jugadorNombre, Dinero dinero) {
        appendChange(new JugadorAdicionado(jugadorId, jugadorNombre, dinero)).apply();
    }

    private BiFunction<Object, Object, Object> appendChange(JugadorAdicionado jugadorAdicionado) {
    }
}