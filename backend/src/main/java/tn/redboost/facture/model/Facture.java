package tn.redboost.facture.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "factures")
public class Facture {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String numeroFacture;
    
    @Column(nullable = false)
    private String nomClient;
    
    @Column(nullable = false)
    private LocalDate dateEmission;
    
    @Column(nullable = false)
    private Double montantHT;
    
    @Column(nullable = false)
    private Double tauxTVA;
    
    @Column(nullable = false)
    private Double montantTTC;
    
    private String description;
}