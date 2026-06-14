package ch.bdt.spike.spring.cloud.modulithapplication.commande;

import ch.bdt.spike.spring.cloud.modulithapplication.commande.dao.CommandeDAO;
import ch.bdt.spike.spring.cloud.modulithapplication.inventaire.InventaireService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommandeService {
    private final CommandeDAO commandeDAO;

    private final InventaireService stockService;

    @Transactional
    public void complete(Long aCommandeId) {
        log.info("Commande completed: " + aCommandeId);
        Commande aCommande = commandeDAO.findById(aCommandeId).orElseThrow(() -> new RuntimeException("Commande not found"));

        aCommande.setEtat(EtatCommande.Done);

        // Mise à jour du stock
        stockService.updateStockFor(aCommande);
    }
}