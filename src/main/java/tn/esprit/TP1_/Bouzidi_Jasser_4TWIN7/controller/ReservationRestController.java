package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Reservation;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IReservationService;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("reservations")
@RequiredArgsConstructor
public class ReservationRestController {
    private final IReservationService reservationService;
    @GetMapping("allreservations")
    public List<Reservation> retrieveAllReservation(){return reservationService.getListReservation();}

    @DeleteMapping("reservation/{id}")
    public Reservation retrieveReservation(@PathVariable long id){

       return reservationService.getReservation(id);}

    @PutMapping("updatereservation/{id}")
    public Reservation updateReservation(@RequestBody Reservation b)
    {
        return reservationService.updateReservation(b);
    }
}
