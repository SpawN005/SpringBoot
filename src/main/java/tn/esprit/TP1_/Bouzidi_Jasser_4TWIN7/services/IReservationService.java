package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Reservation;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;

import java.util.List;

public interface IReservationService {
    Reservation ajouterReservation(Reservation R);
    Reservation updateReservation(Reservation R);
    void deleteReservation(long idReservation);
    Reservation getReservation(long idReservation);
    List<Reservation> getListReservation();
}
