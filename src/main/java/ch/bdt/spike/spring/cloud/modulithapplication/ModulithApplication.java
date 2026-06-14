package ch.bdt.spike.spring.cloud.modulithapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

// Important sinon @ApplicationModuleListener ne sera pas async
@EnableAsync
@EnableJpaRepositories
@SpringBootApplication
@Slf4j
public class ModulithApplication {

    //@Bean
    //public ContextPropagatingTaskDecorator contextPropagatingTaskDecorator() {
    //    return new ContextPropagatingTaskDecorator();
    //}

    public static void main(String[] args) {
        SpringApplication.run(ModulithApplication.class, args);
    }

}
