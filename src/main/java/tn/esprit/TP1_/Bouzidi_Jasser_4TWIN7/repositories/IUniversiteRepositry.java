package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;

public interface IUniversiteRepositry extends JpaRepository<Universite,Long> {
    Universite findByNomUniversite(String nomUniv);
}
