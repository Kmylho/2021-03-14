package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.juego.comand.CrearJuego;
import co.com.sofka.domain.juego.event.JuegoCreado;
import co.com.sofka.domain.juego.event.JugadorAdicionado;
import co.com.sofka.domain.juego.values.Dinero;
import co.com.sofka.domain.juego.values.JugadorId;
import co.com.sofka.domain.juego.values.JugadorNombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;

class CrearJuegoUseCaseTest {
    @Test
    void crearJuego(){

        var jugadorNombre = Map.of(
                JugadorId.of("1"), new JugadorNombre("Kmylho"),
                JugadorId.of("2"), new JugadorNombre("Andres"),
                JugadorId.of("3"), new JugadorNombre("Andrea")
        );
        var dinero = Map.of(
                JugadorId.of("1"), new Dinero(1000),
                JugadorId.of("2"), new Dinero(1000),
                JugadorId.of("3"), new Dinero(1000)
        );
        var command = new CrearJuego(dinero, jugadorNombre);

        var useCase = new CrearJuegoUseCase();

        var events =UseCaseHandler.getInstance().syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        var juegoCreado = (JuegoCreado)events.get(0);
        var jugadorAdicionado = (JugadorAdicionado)events.get(1);

        Assertions.assertTrue(Objects.nonNull(juegoCreado.getJuegoId().value()));
        Assertions.assertEquals("1", jugadorAdicionado.getJugadorId().value());
        Assertions.assertEquals("Kmylho", jugadorAdicionado.getJugadorNombre().value());
        Assertions.assertEquals(1000, jugadorAdicionado.getDinero().value());

    }
}