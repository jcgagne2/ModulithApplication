package ch.bdt.spike.spring.cloud.modulithapplication.inventaire;

import ch.bdt.spike.spring.cloud.modulithapplication.commande.CommandeCompletedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventaireServiceWithEvents {

    @EventListener
    public void updateStockFor(CommandeCompletedEvent aEvent) {
        log.info("Updating stock for event {}", aEvent);
        if (aEvent.getCommandeId() == 2L) {
            throw new RuntimeException("boum");
        }

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException aE) {
            throw new RuntimeException(aE);
        }

        log.info("Stock updated for event {}", aEvent);
    }
}
