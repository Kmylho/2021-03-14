package co.com.sofka.domain.juego.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.juego.values.Dinero;
import co.com.sofka.domain.juego.values.JugadorId;
import co.com.sofka.domain.juego.values.JugadorNombre;

public class JugadorAdicionado extends DomainEvent {
    private final JugadorId jugadorId;
    private final JugadorNombre jugadorNombre;
    private final Dinero dinero;

    public JugadorAdicionado(JugadorId jugadorId, JugadorNombre jugadorNombre, Dinero dinero) {
        super("nomemientas.juego.jugadoradicionado");
        this.jugadorId = jugadorId;
        this.jugadorNombre = jugadorNombre;
        this.dinero = dinero;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public Dinero getDinero() {
        return dinero;
    }

    public JugadorNombre getJugadorNombre() {
        return jugadorNombre;
    }
}