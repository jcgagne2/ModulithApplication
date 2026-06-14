package ch.bdt.spike.spring.cloud.modulithapplication.commande.dao;

import ch.bdt.spike.spring.cloud.modulithapplication.commande.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDAO extends JpaRepository<Commande, Long> {
}
