package tn.redboost.facture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.redboost.facture.model.Devis;
import tn.redboost.facture.repository.DevisRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class DevisService {
    
    @Autowired
    private DevisRepository devisRepository;
    
    /**
     * Créer un devis avec génération auto des données
     */
    public Devis creerDevis(Devis devis) {
        // Génération auto du num de devis
        if (devis.getNumeroDevis() == null || devis.getNumeroDevis().isEmpty()) {
            devis.setNumeroDevis("DEV-" + System.currentTimeMillis());
        }
        
        // Date de création auto
        if (devis.getDateCreation() == null) {
            devis.setDateCreation(LocalDate.now());
        }
        
        // Date de validité auto (30 jours après création)
        if (devis.getDateValidite() == null) {
            devis.setDateValidite(LocalDate.now().plusDays(30));
        }
        
        // Statut par défaut
        if (devis.getStatut() == null || devis.getStatut().isEmpty()) {
            devis.setStatut("EN_ATTENTE");
        }
        
        return devisRepository.save(devis);
    }
    
    /**
     * Récuperation tous les devis
     */
    public List<Devis> getAllDevis() {
        return devisRepository.findAll();
    }
    
    /**
     * Récuperation un devis par son ID
     */
    public Devis getDevisById(Long id) {
        return devisRepository.findById(id).orElse(null);
    }
    
    /**
     * Màj statut d'un devis
     */
    public Devis updateStatut(Long id, String statut) {
        Devis devis = devisRepository.findById(id).orElse(null);
        if (devis != null) {
            devis.setStatut(statut);
            return devisRepository.save(devis);
        }
        return null;
    }
    
    /**
     * Supprimer un devis
     */
    public void deleteDevis(Long id) {
        devisRepository.deleteById(id);
    }
}