package ch.bdt.spike.spring.cloud.modulithapplication.commande;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Integer quantity;

    private String product;

    private EtatCommande etat;

    public Commande(Integer quantity, String product) {
        this.quantity = quantity;
        this.product = product;
        this.etat = EtatCommande.New;
    }
}
