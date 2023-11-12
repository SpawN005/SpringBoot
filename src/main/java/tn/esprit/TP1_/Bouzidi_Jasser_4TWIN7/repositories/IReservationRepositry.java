package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IReservationRepositry extends JpaRepository<Reservation,Long> {
    Reservation findByNumReservation(String numReservation);

}
