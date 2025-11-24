package ch.bdt.spike.spring.cloud.modulithapplication.commande;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommandeService {

    //private final StockService stockService;

    public void complete(Commande aCommande) {
        log.info("Commande completed: " + aCommande);

        aCommande.setEtat(EtatCommande.Done);

        // Mise à jour du stock
        //stockService.updateStockFor(aCommande);
    }
}