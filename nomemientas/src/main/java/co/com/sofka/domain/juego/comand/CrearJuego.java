package co.com.sofka.domain.juego.comand;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.juego.values.Dinero;
import co.com.sofka.domain.juego.values.JugadorId;
import co.com.sofka.domain.juego.values.JugadorNombre;

import java.util.Map;

public class CrearJuego implements Command {
    private final Map<JugadorId, Dinero> dineros;
    private final Map<JugadorId, JugadorNombre> jugadorNombres;

    public CrearJuego(Map<JugadorId, Dinero> dineros, Map<JugadorId, JugadorNombre> jugadorNombres) {
        this.dineros = dineros;
        this.jugadorNombres = jugadorNombres;
    }

    public Map<JugadorId, Dinero> getCapitales() {
        return capitales;
    }

    public Map<JugadorId, Nombre> getNombres() {
        return nombres;
    }
}
