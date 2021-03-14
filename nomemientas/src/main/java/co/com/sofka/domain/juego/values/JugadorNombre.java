package co.com.sofka.domain.juego.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class JugadorNombre implements ValueObject<String> {
    private final String value;

    public JugadorNombre(String nombrejugador) {
        this.value = Objects.requireNonNull(nombrejugador);
        if (nombrejugador.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede esta vacio");
        }
    }

    public String value() {
        return value;
    }
}