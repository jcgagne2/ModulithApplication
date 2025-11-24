package ch.bdt.spike.spring.cloud.modulithapplication.commande.web;

import ch.bdt.spike.spring.cloud.modulithapplication.commande.Commande;
import ch.bdt.spike.spring.cloud.modulithapplication.commande.CommandeServiceWithEvent;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandeController {

    @Resource
    private CommandeServiceWithEvent commandeServiceWithEvent;

    @GetMapping("/completeCommande/{quantite}/{produit}")
    public String completeCommande(@PathVariable int quantite, @PathVariable String produit) {
        Commande vCommande = new Commande(quantite, produit);
        commandeServiceWithEvent.complete(vCommande);
        return "Commande completed: " + vCommande;
    }
}
