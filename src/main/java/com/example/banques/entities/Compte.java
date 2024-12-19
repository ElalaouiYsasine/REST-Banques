package com.example.banques.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@XmlRootElement
@Entity
@Data  ///génèrent automatiquement les méthodes getter, setter, constructeurs sans argument et avec tous les argument
@NoArgsConstructor
@AllArgsConstructor
@ToString



public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private double solde ;

    @Temporal(TemporalType.DATE)
    private Date dateDeCreation ;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private TypeCompte type ;



}
