package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Etudiant;

public interface IEtudiantRepositry extends JpaRepository<Etudiant,Long> {
    Etudiant findByCin(long cin);
}
