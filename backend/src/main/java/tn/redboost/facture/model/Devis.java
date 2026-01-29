package tn.redboost.facture.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "devis")
public class Devis {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String numeroDevis;
    
    @Column(nullable = false)
    private String nomClient;
    
    @Column(nullable = false)
    private LocalDate dateCreation;
    
    @Column(nullable = false)
    private LocalDate dateValidite;
    
    @Column(nullable = false)
    private Double montant;
    
    @Column(nullable = false)
    private String statut;
    
    private String description;
}