package com.example.demo14.entities;

import com.example.demo14.entities.enumerations.CategorieClient;
import com.example.demo14.entities.enumerations.Profession;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nom;

    private String prenom;

    private String email;

    private String password;

    @Temporal(value = TemporalType.DATE)
    private Date dateNaissance;

    @Enumerated(value = EnumType.STRING)
    private CategorieClient categorieClient;

    @Enumerated(value = EnumType.STRING)
    private Profession profession;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private Set<Facture> factures;

}
