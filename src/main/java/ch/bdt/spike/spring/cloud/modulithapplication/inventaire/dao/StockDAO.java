package ch.bdt.spike.spring.cloud.modulithapplication.inventaire.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class StockDAO {

    public void save() {
        log.info("Saving stock");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException aE) {
            throw new RuntimeException(aE);
        }

    }
}
