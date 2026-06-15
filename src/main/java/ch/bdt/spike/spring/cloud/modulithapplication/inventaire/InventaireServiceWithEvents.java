package ch.bdt.spike.spring.cloud.modulithapplication.inventaire;

import ch.bdt.spike.spring.cloud.modulithapplication.commande.CommandeCompletedEvent;
import ch.bdt.spike.spring.cloud.modulithapplication.inventaire.dao.StockDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventaireServiceWithEvents {
    private final StockDAO stockDAO;

    //@ApplicationModuleListener
    @EventListener
    public void updateStockFor(CommandeCompletedEvent aEvent) {
        log.info("Updating stock for event {}", aEvent);
        if (aEvent.getCommandeId() == 2L) {
            throw new RuntimeException("boum");
        }
        stockDAO.save();
        log.info("Stock updated for event {}", aEvent);
    }
}
