package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.juego.comand.InicializarJuego;
import co.com.sofka.domain.juego.event.JuegoCreado;
import co.com.sofka.domain.juego.event.JuegoInicializado;
import co.com.sofka.domain.juego.values.JuegoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtencion.class)
class InicializarJuegoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void inicializarJuego(){
        var id = JuegoId.of("xxxx");
        var command = new InicializarJuego(id);
        var useCase = new InicializarJuegoUseCase();

        when(repository.getEventsBy(refEq(id.value()))).thenReturn(eventStored(id));

        var events = UseCaseHandler.getInstance().syncExecutor(useCase, new RequestCommand<>(command)).orElseThrow().getDomainEvents();
        var juegoInicializado = (JuegoInicializado)events.get(0);
        Assertions.assertEquals(3, JuegoInicializado.getJugadoresIds().size());
    }

    private List<DomainEvent> eventStored(JuegoId id) {
        return List.of(new JuegoCreado(id));
    }

}