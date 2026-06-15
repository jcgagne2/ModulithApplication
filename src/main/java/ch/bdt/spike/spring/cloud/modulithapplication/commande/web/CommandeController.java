package ch.bdt.spike.spring.cloud.modulithapplication.commande.web;

import ch.bdt.spike.spring.cloud.modulithapplication.commande.CommandeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CommandeController {

    @Resource
    private CommandeService commandeService;

    @GetMapping("/completeCommande/{id}")
    public String completeCommande(@PathVariable long id) {
        log.info("Completing command {}", id);
        commandeService.complete(id);
        return "Commande completed: " + id;
    }
}
