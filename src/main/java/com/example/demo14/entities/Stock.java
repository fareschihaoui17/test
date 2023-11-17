package com.example.demo14.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idStock;

    Integer qte;

    Integer qteMin;

    String libelleStock;

    @OneToMany(mappedBy = "stock",cascade = CascadeType.ALL)
    Set<Produit> produits;





}
