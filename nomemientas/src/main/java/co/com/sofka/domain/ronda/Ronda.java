package co.com.sofka.domain.ronda;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.ronda.values.RondaId;

public class Ronda extends AggregateEvent<RondaId> {
    public Ronda(RondaId entityId){
        super(entityId);
    }
}
