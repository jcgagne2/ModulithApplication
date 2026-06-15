package ch.bdt.spike.spring.cloud.modulithapplication.inventaire;

import ch.bdt.spike.spring.cloud.modulithapplication.commande.Commande;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventaireService {
    public void updateStockFor(Commande aCommande) {
        log.info("Updating stock for {}", aCommande);

        if (aCommande.getId() == 2L) {
            throw new RuntimeException("boum");
        }

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException aE) {
            throw new RuntimeException(aE);
        }

    }
}
