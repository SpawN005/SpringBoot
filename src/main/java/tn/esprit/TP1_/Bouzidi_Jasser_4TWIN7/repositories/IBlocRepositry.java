package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Bloc;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Foyer;

import java.util.List;

public interface IBlocRepositry extends JpaRepository<Bloc,Long> {
    Bloc findByNomBloc(String Bloc);
    List<Bloc> findByFoyer(Foyer f);
}
