package ch.bdt.spike.spring.cloud.modulithapplication.inventaire.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.ApplicationModuleInitializer;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class InventaireModuleInitializer implements ApplicationModuleInitializer {

  @Override
  public void initialize() {
    // Initialization code goes here
      log.info("initializing module Inventaire");
  }
}