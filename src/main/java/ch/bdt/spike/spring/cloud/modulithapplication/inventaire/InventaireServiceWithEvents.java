package ch.bdt.spike.spring.cloud.modulithapplication.inventaire;

import ch.bdt.spike.spring.cloud.modulithapplication.commande.CommandeCompletedEvent;
import ch.bdt.spike.spring.cloud.modulithapplication.inventaire.dao.StockDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventaireServiceWithEvents {
    private final StockDAO stockDAO;

    private int count = 0;

    @ApplicationModuleListener
    //@EventListener
    public void updateStockFor(CommandeCompletedEvent aEvent) {
        log.info("Updating stock for event {}", aEvent);
        count++;
        if (count == 1) {
            // Premier passage. On plante.
            throw new IllegalStateException("jamais le premier soir");
        }
        aEvent.setConsumerThreadName(Thread.currentThread().getName());
        stockDAO.save();
        log.info("Stock updated for event {}", aEvent);
    }
}
