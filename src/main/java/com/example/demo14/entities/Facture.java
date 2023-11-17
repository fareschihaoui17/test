package com.example.demo14.entities;

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
public class Facture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;

    private float montantRemise;

    private float montantFacture;

    @Temporal(value = TemporalType.DATE)
    private Date dateFacture;

    private boolean active;

    @OneToMany(mappedBy = "facture",cascade = CascadeType.ALL)
    private Set<DetailFacture> detailFactures;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @ToString.Exclude
    private Client client;

}
