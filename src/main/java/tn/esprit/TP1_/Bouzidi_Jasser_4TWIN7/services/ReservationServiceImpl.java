package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.*;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IChambreRepositry;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IEtudiantRepositry;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IReservationRepositry;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService{
    final IReservationRepositry reservationRepositry;
    final IEtudiantRepositry etudiantRepositry;
    final IChambreRepositry chambreRepositry;
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
    @Transactional
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Chambre c = chambreRepositry.findById(idChambre).orElse(null);
        Etudiant e = etudiantRepositry.findByCin(cinEtudiant);

        if (c!=null && e!=null){
            DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MM-yyyy");
            Reservation r = new Reservation();
            r.setNumReservation(c.getNumeroChambre().toString()+c.getBloc().getNomBloc()+e.getCin().toString());
            r.setDebutAnneeUniv(LocalDate.parse("01-09-"+String.valueOf(LocalDate.now().getYear()),df));
            r.setFinAnneeUniv(LocalDate.parse("01-06-"+String.valueOf(LocalDate.now().getYear()+1),df));
            r.setEstValide(true);




if(((c.getTypeChambre().equals(TypeChambre.SIMPLE)) && (c.getReservation().size()==0) )||(c.getTypeChambre().equals(TypeChambre.DOUBLE)&& c.getReservation().size()<2)||(c.getTypeChambre().equals(TypeChambre.TRIPLE)&& c.getReservation().size()<3)){
    System.out.println("aze");
    c.getReservation().add(r);
    r.getEtudiants().add(e);
    e.getReservations().add(r);
    this.ajouterReservation(r);

}


return r;


        }


        return null;
    }

    @Override
    @Transactional
    public Reservation annulerReservation(long cinEtudiant, String numReservation) {
       Reservation r = reservationRepositry.findByNumReservation(numReservation);
       Etudiant e = etudiantRepositry.findByCin(cinEtudiant);
        Chambre c = chambreRepositry.findByReservation(r);
        if ( r!=null && e!=null){

            r.setEstValide(false);

            r.getEtudiants().remove(e);
            e.getReservations().remove(r);
            if (c!=null )
                c.getReservation().remove(r);


            return r;


        }
        return null;
    }
}
