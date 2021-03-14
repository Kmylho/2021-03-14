package co.com.sofka.domain.juego;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.juego.values.Dinero;
import co.com.sofka.domain.juego.values.JugadorId;
import co.com.sofka.domain.juego.values.JugadorNombre;

public class Jugador extends Entity<JugadorId> {

    private final JugadorNombre jugadorNombre;
    private Dinero dinero;

    public Jugador(JugadorId entityId, JugadorNombre jugadorNombre, Dinero dinero) {
        super(entityId);
        this.jugadorNombre = jugadorNombre;
        this.dinero = dinero;
    }

    public void aumentarDinero(Integer valor) {
        this.dinero = this.dinero.aumentar(valor);
    }

    public Dinero dinero() {
        return dinero;
    }

    public JugadorNombre jugadorNombre() {
        return jugadorNombre;
    }
}
