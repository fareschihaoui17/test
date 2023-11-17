package com.example.demo14.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    private String code;

    private String libelle;

    private float prixUnitaire;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Fournisseur> fournisseurs;

    @ManyToOne
    @JoinColumn(name = "rayon_id")
    @ToString.Exclude
    private Rayon rayon;

    @OneToMany(mappedBy = "produit",cascade = CascadeType.ALL)
    private Set<DetailFacture> detailFactures;

    @OneToOne(mappedBy = "produit")
    private DetailProduit detailProduit;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    @ToString.Exclude
    private Stock stock;
}
