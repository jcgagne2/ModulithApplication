package ch.bdt.spike.spring.cloud.modulithapplication.commande;

import ch.bdt.spike.spring.cloud.modulithapplication.commande.dao.CommandeDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommandeServiceWithEvent {
    private final CommandeDAO commandeDAO;

    private final ApplicationEventPublisher events;

    @Transactional
    public void complete(Long aCommandeId) {
        log.info("Completing command {}", aCommandeId);
        Commande aCommande = commandeDAO.findById(aCommandeId).orElseThrow(() -> new RuntimeException("Commande not found"));
        aCommande.setEtat(EtatCommande.Done);

        log.info("Publishing event");
        events.publishEvent(new CommandeCompletedEvent(aCommande.getId()));

        log.info("Command completed: " + aCommande);
    }
}