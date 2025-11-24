package ch.bdt.spike.spring.cloud.modulithapplication.commande;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jmolecules.event.annotation.DomainEvent;

@Getter
@ToString
@DomainEvent
public class CommandeCompletedEvent {
    private final Long commandeId;

    // Le nom du thread qui a appellé new
    private final String producerThreadName;

    // Le nom du thread qui va traiter l'event
    @Setter
    private String consumerThreadName;

    public CommandeCompletedEvent(Long commandeId) {
        this.commandeId = commandeId;
        this.producerThreadName = Thread.currentThread().getName();
    }
}
