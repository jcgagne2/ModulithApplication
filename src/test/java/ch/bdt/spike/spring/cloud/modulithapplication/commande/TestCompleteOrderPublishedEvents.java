package ch.bdt.spike.spring.cloud.modulithapplication.commande;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.AssertablePublishedEvents;
import org.springframework.modulith.test.PublishedEvents;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.ALL_DEPENDENCIES)
class TestCompleteOrderPublishedEvents {
    //@Resource
    //private CommandeServiceWithEvent commandeServiceWithEvent;
    //
    //@Test
    //void testCompleteOrder(PublishedEvents events) {
    //    commandeServiceWithEvent.complete(1L);
    //
    //    events.ofType(CommandeCompletedEvent.class).forEach(commandeCompletedEvent -> {
    //        System.out.println(commandeCompletedEvent);
    //    });
    //
    //    var vMatching = events.ofType(CommandeCompletedEvent.class).matching(CommandeCompletedEvent::getCommandeId,
    //                                                                         1L);
    //    assertThat(vMatching).hasSize(1);
    //}

}
