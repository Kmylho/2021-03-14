package co.com.sofka.domain.juego.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.juego.values.JuegoId;

public class JuegoCreado extends DomainEvent {
    // llamando a juego id
    private final JuegoId juegoId;
    //constructor del id
    public JuegoCreado(JuegoId juegoId) {
        super("nomemientas.juego.creado");
        this.juegoId = juegoId;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }
}