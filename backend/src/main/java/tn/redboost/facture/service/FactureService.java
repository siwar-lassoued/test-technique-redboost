package tn.redboost.facture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.redboost.facture.model.Facture;
import tn.redboost.facture.repository.FactureRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class FactureService {
    
    @Autowired
    private FactureRepository factureRepository;
    
    /**
     * Créer une facture avec calcul automatique du TTC
     */
    public Facture creerFacture(Facture facture) {
        // Calcul automatique du montant TTC
        double montantTTC = facture.getMontantHT() * (1 + facture.getTauxTVA());
        facture.setMontantTTC(montantTTC);
        
        // Génération auto du numéro de facture
        if (facture.getNumeroFacture() == null || facture.getNumeroFacture().isEmpty()) {
            facture.setNumeroFacture("FACT-" + System.currentTimeMillis());
        }
        
        // Date d'émission auto si non fournie
        if (facture.getDateEmission() == null) {
            facture.setDateEmission(LocalDate.now());
        }
        
        return factureRepository.save(facture);
    }
    
    /**
     * Récuperation toutes les factures
     */
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }
    
    /**
     * Récuperation facture par ID
     */
    public Facture getFactureById(Long id) {
        return factureRepository.findById(id).orElse(null);
    }
    
    /**
     * Supprimer une facture
     */
    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }
}