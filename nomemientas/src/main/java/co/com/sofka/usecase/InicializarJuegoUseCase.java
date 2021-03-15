package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.juego.Juego;
import co.com.sofka.domain.juego.comand.InicializarJuego;

public class InicializarJuegoUseCase extends UseCase<RequestCommand<InicializarJuego>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<InicializarJuego> inicializarJuegoRequestCommand) {
        var command = inicializarJuegoRequestCommand.getCommand();
        var juego = Juego.from(command.getJuegoId(), retrieveEvents());
        juego.iniciarJuego();
        emit().onResponse(new ResponseEvents(juego.getUncommittedChanges()));
    }
}
