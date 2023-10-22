package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Reservation;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IReservationRepositry;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService{
    IReservationRepositry reservationRepositry;
    @Override
    public Reservation ajouterReservation(Reservation R) {
        return reservationRepositry.save(R);
    }

    @Override
    public Reservation updateReservation(Reservation R) {
        return reservationRepositry.save(R);
    }

    @Override
    public void deleteReservation(long idReservation) {
        reservationRepositry.deleteById(idReservation);
    }

    @Override
    public Reservation getReservation(long idReservation) {
        return reservationRepositry.findById(idReservation).get();
    }

    @Override
    public List<Reservation> getListReservation() {
        return (List<Reservation>) reservationRepositry.findAll();
    }
}
