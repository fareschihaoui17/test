package com.example.demo14.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DetailFacture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailFacture;

    private Integer qte;

    private float prixTotal;

    private Integer pourcentageRemise;

    private float montantRemise;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "facture_id")
    private Facture facture;
}
