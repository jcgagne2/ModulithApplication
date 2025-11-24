package ch.bdt.spike.spring.cloud.modulithapplication.commande;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.AssertablePublishedEvents;
import org.springframework.modulith.test.PublishedEvents;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.ALL_DEPENDENCIES)
class TestCompleteOrderPublishedEvents {
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

        events.ofType(CommandeCompletedEvent.class).forEach(commandeCompletedEvent -> {
            System.out.println(commandeCompletedEvent);
        });

        PublishedEvents.TypedPublishedEvents<CommandeCompletedEvent> vMatching = events.ofType(CommandeCompletedEvent.class)
                                                                                       .matching(CommandeCompletedEvent::getCommandeId,
                                                                                                 1L);
        assertThat(vMatching).hasSize(1);
    }

    @Test
    void testCompleteOrderAssertable(AssertablePublishedEvents events) {
        Commande aCommande = new Commande();
        aCommande.setId(1);
        aCommande.setProduct("Orange");
        aCommande.setQuantity(10);
        aCommande.setEtat(EtatCommande.New);
        commandeServiceWithEvent.complete(aCommande);

        assertThat(events).contains(CommandeCompletedEvent.class).matching(CommandeCompletedEvent::getCommandeId, 1L);
    }

}
