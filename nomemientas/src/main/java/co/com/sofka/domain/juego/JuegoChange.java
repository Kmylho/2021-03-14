package co.com.sofka.domain.juego;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.juego.event.JuegoCreado;
import co.com.sofka.domain.juego.event.JuegoInicializado;
import co.com.sofka.domain.juego.event.JugadorAdicionado;

import java.util.HashMap;

public class JuegoChange extends EventChange {
    public JuegoChange(Juego juego) {

        apply((JuegoCreado event) -> {
            juego.jugando = Boolean.FALSE;
            juego.jugadores = new HashMap<>();
        });

        apply((JuegoInicializado event) -> {
            juego.jugando = Boolean.TRUE;
        });

        apply((JugadorAdicionado event) -> {
            if (juego.jugando.equals(Boolean.TRUE)) {
                throw new IllegalArgumentException("No se puede crear un nuevo jugador si el juego esta en marcha");
            }
            juego.jugadores.put(event.getJugadorId(),
                    new Jugador(
                            event.getJugadorId(),
                            event.getJugadorNombre(),
                            event.getDinero()
                    )
            );
        });
    }
}