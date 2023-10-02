package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table( name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idReservation")
    private Long idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;
}
