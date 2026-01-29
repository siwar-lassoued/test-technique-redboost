package tn.redboost.facture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.redboost.facture.model.Facture;
import tn.redboost.facture.service.FactureService;

import java.util.List;

@RestController
@RequestMapping("/api/factures")
@CrossOrigin(origins = "http://localhost:4200")
public class FactureController {
    
    @Autowired
    private FactureService factureService;
    
    /**
     * POST /api/factures 
     */
    @PostMapping
    public ResponseEntity<Facture> creerFacture(@RequestBody Facture facture) {
        try {
            Facture nouvelleFacture = factureService.creerFacture(facture);
            return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleFacture);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * GET /api/factures 
     */
    @GetMapping
    public ResponseEntity<List<Facture>> getAllFactures() {
        List<Facture> factures = factureService.getAllFactures();
        return ResponseEntity.ok(factures);
    }
    
    /**
     * GET /api/factures/{id} 
     */
    @GetMapping("/{id}")
    public ResponseEntity<Facture> getFactureById(@PathVariable Long id) {
        Facture facture = factureService.getFactureById(id);
        if (facture != null) {
            return ResponseEntity.ok(facture);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    /**
     * DELETE /api/factures/{id} 
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacture(@PathVariable Long id) {
        try {
            factureService.deleteFacture(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}