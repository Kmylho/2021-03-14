package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.factory.JugadorFactory;
import co.com.sofka.domain.juego.Juego;
import co.com.sofka.domain.juego.comand.CrearJuego;
import co.com.sofka.domain.juego.values.JuegoId;

public class CrearJuegoUseCase extends UseCase<RequestCommand<CrearJuego>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearJuego> crearJuegoRequestCommand) {
        //llamar al comando
        var command= crearJuegoRequestCommand.getCommand();
        var juegoId = new JuegoId();
        var factory = JugadorFactory.builder();
        command.jugadorNombre()

        var Juego = new Juego(juegoId );

    }
}
