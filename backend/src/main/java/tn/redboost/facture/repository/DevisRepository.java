package tn.redboost.facture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.redboost.facture.model.Devis;

@Repository
public interface DevisRepository extends JpaRepository<Devis, Long> {
}