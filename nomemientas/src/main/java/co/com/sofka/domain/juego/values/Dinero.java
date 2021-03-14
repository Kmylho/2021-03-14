package co.com.sofka.domain.juego.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Dinero implements ValueObject<Integer> {
    private final Integer value;

    public Dinero(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (value < 0) {
            throw new IllegalArgumentException("El valor del capital no puede ser negativo");
        }
    }

    public Dinero aumentar(Integer value) {
        return new Dinero(this.value + value);
    }

    @Override
    public Integer value() {
        return value;
    }
}
