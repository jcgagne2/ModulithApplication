package ch.bdt.spike.spring.cloud.modulithapplication;

import ch.bdt.spike.spring.cloud.modulithapplication.commande.Commande;
import ch.bdt.spike.spring.cloud.modulithapplication.commande.CommandeServiceWithEvent;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.logback.appender.v1_0.OpenTelemetryAppender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.support.ContextPropagatingTaskDecorator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

// Important sinon @ApplicationModuleListener ne sera pas async
@EnableAsync
@EnableJpaRepositories
@SpringBootApplication
@Slf4j
public class ModulithApplication {

    @Bean
    public ContextPropagatingTaskDecorator contextPropagatingTaskDecorator() {
        return new ContextPropagatingTaskDecorator();
    }

    //@Bean
    CommandLineRunner run(CommandeServiceWithEvent aCommandeService) {
        return args -> {
            Commande vCommande = new Commande(10, "Pomme");
            aCommandeService.complete(vCommande);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ModulithApplication.class, args);
    }

    @Component
    @Slf4j
    public static class InstallOpenTelemetryAppender implements InitializingBean {

        private final OpenTelemetry openTelemetry;

        InstallOpenTelemetryAppender(OpenTelemetry openTelemetry) {
            this.openTelemetry = openTelemetry;
        }

        @Override
        public void afterPropertiesSet() {
            log.info("Installing OpenTelemetry");
            OpenTelemetryAppender.install(this.openTelemetry);
        }

    }
}
