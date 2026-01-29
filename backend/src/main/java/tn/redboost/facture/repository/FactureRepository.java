package tn.redboost.facture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.redboost.facture.model.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
}