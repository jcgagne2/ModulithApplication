package ch.bdt.spike.spring.cloud.modulithapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class ModulithApplicationTests {

    @Test
    void testVerifyModules() {
        ApplicationModules vModules = ApplicationModules.of(ModulithApplication.class);
        vModules.forEach(System.out::println);

        vModules.verify();
    }

}
