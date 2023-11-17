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
public class Rayon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRayon;

    private String code;

    private String libelle;

    @OneToMany(mappedBy = "rayon",cascade = CascadeType.ALL)
    private Set<Produit> produits;
}
