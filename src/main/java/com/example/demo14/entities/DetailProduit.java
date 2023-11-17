package com.example.demo14.entities;

import com.example.demo14.entities.enumerations.CategorieProduit;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DetailProduit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailProduit;

    @Temporal(value=TemporalType.DATE)
    private Date dateCreation;

    @Temporal(value = TemporalType.DATE)
    private Date dateDerniereModification;

    @Enumerated(value = EnumType.STRING)
    private CategorieProduit categorieProduit;

    @OneToOne
    private Produit produit;
}
