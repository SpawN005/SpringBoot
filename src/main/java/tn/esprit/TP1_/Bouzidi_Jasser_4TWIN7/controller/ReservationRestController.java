package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Foyer;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Reservation;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IReservationService;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("reservations")
@Tag(name = "reservation management")
@RequiredArgsConstructor
public class ReservationRestController {
    private final IReservationService reservationService;
    @GetMapping("allreservations")
    @Operation(description = "retrieve all reservations")
    public List<Reservation> retrieveAllReservation(){return reservationService.getListReservation();}

    @DeleteMapping("reservation/{id}")
    @Operation(description = "delete reservation")
    public Reservation retrieveReservation(@PathVariable long id){

       return reservationService.getReservation(id);}
    @PostMapping("addreservation/{c}/{e}")
    @Operation(description = "add reservation")
    public Reservation addReservation(@PathVariable long c,@PathVariable long e){return reservationService.ajouterReservation(c,e);}
    @PutMapping("updatereservation/{id}")
    @Operation(description = "update reservation")
    public Reservation updateReservation(@RequestBody Reservation b)
    {
        return reservationService.updateReservation(b);
    }
    @PutMapping("annulerreservation/{id}")
    public Reservation annulerReservation(@PathVariable String id, @RequestBody long cin){
        return reservationService.annulerReservation(cin ,id);
    }
}
