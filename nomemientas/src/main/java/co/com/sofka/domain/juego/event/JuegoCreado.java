package co.com.sofka.domain.juego.event;

import co.com.sofka.domain.generic.DomainEvent;

public class JuegoCreado extends DomainEvent {

    public JuegoCreado(String type) {
        super("co.com.sofka.domain.juego");
    }
}
