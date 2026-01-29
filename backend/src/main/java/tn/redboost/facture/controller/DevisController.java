package tn.redboost.facture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.redboost.facture.model.Devis;
import tn.redboost.facture.service.DevisService;

import java.util.List;

@RestController
@RequestMapping("/api/devis")
@CrossOrigin(origins = "http://localhost:4200")
public class DevisController {
    
    @Autowired
    private DevisService devisService;
    
    /**
     * POST /api/devis 
     */
    @PostMapping
    public ResponseEntity<Devis> creerDevis(@RequestBody Devis devis) {
        try {
            Devis nouveauDevis = devisService.creerDevis(devis);
            return ResponseEntity.status(HttpStatus.CREATED).body(nouveauDevis);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/devis 
     */
    @GetMapping
    public ResponseEntity<List<Devis>> getAllDevis() {
        List<Devis> devis = devisService.getAllDevis();
        return ResponseEntity.ok(devis);
    }
    
    /**
     * GET /api/devis/{id} 
     */
    @GetMapping("/{id}")
    public ResponseEntity<Devis> getDevisById(@PathVariable Long id) {
        Devis devis = devisService.getDevisById(id);
        if (devis != null) {
            return ResponseEntity.ok(devis);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    /**
     * PATCH /api/devis/{id}/statut 
     */
    @PatchMapping("/{id}/statut")
    public ResponseEntity<Devis> updateStatut(@PathVariable Long id, @RequestBody String statut) {
        Devis devis = devisService.updateStatut(id, statut);
        if (devis != null) {
            return ResponseEntity.ok(devis);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    /**
     * DELETE /api/devis/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevis(@PathVariable Long id) {
        try {
            devisService.deleteDevis(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}