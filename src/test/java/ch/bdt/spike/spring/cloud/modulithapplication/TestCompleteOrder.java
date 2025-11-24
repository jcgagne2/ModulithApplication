package ch.bdt.spike.spring.cloud.modulithapplication;

import ch.bdt.spike.spring.cloud.modulithapplication.commande.Commande;
import ch.bdt.spike.spring.cloud.modulithapplication.commande.CommandeServiceWithEvent;
import ch.bdt.spike.spring.cloud.modulithapplication.commande.EtatCommande;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.test.PublishedEvents;

@SpringBootTest
class TestCompleteOrder {
    @Resource
    private CommandeServiceWithEvent commandeServiceWithEvent;

    @Test
    void testCompleteOrder(PublishedEvents events) {
        Commande aCommande = new Commande();
        aCommande.setId(1);
        aCommande.setProduct("Orange");
        aCommande.setQuantity(10);
        aCommande.setEtat(EtatCommande.New);
        commandeServiceWithEvent.complete(aCommande);
    }

}
