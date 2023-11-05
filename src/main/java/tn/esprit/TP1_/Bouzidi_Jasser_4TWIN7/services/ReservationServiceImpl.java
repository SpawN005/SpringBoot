package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Chambre;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Etudiant;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Reservation;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IChambreRepositry;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IEtudiantRepositry;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IReservationRepositry;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService{
    IReservationRepositry reservationRepositry;
    IEtudiantRepositry etudiantRepositry;
    IChambreRepositry chambreRepositry;
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

    @Override
    @Transactional
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation res, Long numChambre, long cin) {
        Etudiant e = etudiantRepositry.findByCin(cin);
        Chambre c = chambreRepositry.findByNumeroChambre(numChambre);
        if (e!=null && c!=null){

            if (c.getBloc().getCapaciteBloc() ==0){

               e.getReservations().add(res);
               c.getReservation().add(res);
               res.getEtudiants().add(e);
               this.ajouterReservation(res);
               c.getBloc().setCapaciteBloc(c.getBloc().getCapaciteBloc()-1);
               return res;

            }

        }

        return null;
    }

    @Override
    public long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee) {
        return reservationRepositry.findByAnneeUniversitaireBetween(debutAnnee,finAnnee).size();

    }
}
