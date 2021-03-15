package co.com.sofka.domain.juego;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.juego.event.JuegoCreado;
import co.com.sofka.domain.juego.event.JuegoInicializado;
import co.com.sofka.domain.juego.event.JugadorAdicionado;

import java.util.HashMap;

public class JuegoChange extends EventChange {
    public JuegoChange(Juego juego) {
        //para crear el juego
        apply((JuegoCreado event) -> {
            //el juego esta creado pero no inicializado
            juego.jugando = Boolean.FALSE;
            juego.jugadores = new HashMap<>();
        });
        //para inicializar el juego
        apply((JuegoInicializado event) -> {
            //el juego ya esta inicializado
            juego.jugando = Boolean.TRUE;
        });
        // adiciona los jugadores despues de iniciar el juego
        apply((JugadorAdicionado event) -> {
            // verifica que el juego no haya comenzado
            if (juego.jugando.equals(Boolean.TRUE)) {
                throw new IllegalArgumentException("Juego ya inicializado");
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