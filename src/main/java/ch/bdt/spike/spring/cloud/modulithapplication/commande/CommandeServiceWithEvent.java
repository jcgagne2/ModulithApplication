package ch.bdt.spike.spring.cloud.modulithapplication.commande;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommandeServiceWithEvent {

    private final ApplicationEventPublisher events;

    @Transactional
    public void complete(Commande aCommande) {
        log.info("Completing command: " + aCommande);
        aCommande.setEtat(EtatCommande.Done);

        log.info("Publishing event");
        events.publishEvent(new CommandeCompletedEvent(aCommande.getId()));

        log.info("Command completed: " + aCommande);
    }
}