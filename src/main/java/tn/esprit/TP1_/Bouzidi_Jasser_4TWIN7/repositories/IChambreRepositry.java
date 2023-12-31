package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Bloc;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Chambre;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Reservation;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.TypeChambre;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

public interface IChambreRepositry extends JpaRepository<Chambre,Long> {
    Set<Chambre> findAllByNumeroChambreIn(List<Long> numChambre);
    Chambre findByNumeroChambre(Long numChambre);
    Chambre findByReservation(Reservation r);
    List<Chambre> findByTypeChambreAndBlocAndReservation(TypeChambre t, Bloc b , Reservation r);
}
