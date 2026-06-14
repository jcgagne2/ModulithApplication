package ch.bdt.spike.spring.cloud.modulithapplication.commande.init;

import ch.bdt.spike.spring.cloud.modulithapplication.commande.Commande;
import ch.bdt.spike.spring.cloud.modulithapplication.commande.dao.CommandeDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.ApplicationModuleInitializer;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
class CommandeModuleInitializer implements ApplicationModuleInitializer {
    private final CommandeDAO commandeDAO;

    @Override
    public void initialize() {
        log.info("initializing module Commande");

        commandeDAO.save(new Commande(10, "Pommes"));
        commandeDAO.save(new Commande(20, "Bananes"));
        commandeDAO.save(new Commande(30, "Poires"));
    }
}