package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Foyer;

public interface IFoyerRepositry extends JpaRepository<Foyer,Long> {
Foyer findByNomFoyer(String nomF);
}
