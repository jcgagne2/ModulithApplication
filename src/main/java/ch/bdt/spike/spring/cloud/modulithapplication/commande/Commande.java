package ch.bdt.spike.spring.cloud.modulithapplication.commande;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Commande {
    private long id;

    private Integer quantity;

    private String product;

    private EtatCommande etat;

    public Commande() {
        this.etat = EtatCommande.New;
    }

    public Commande(Integer quantity, String product) {
        this.quantity = quantity;
        this.product = product;
        this.etat = EtatCommande.New;
    }
}
