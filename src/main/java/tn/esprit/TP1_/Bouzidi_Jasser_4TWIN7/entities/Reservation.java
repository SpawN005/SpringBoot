package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table( name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idReservation")
    private Long idReservation;
    private String numReservation;
    private LocalDate debutAnneeUniv;
    private LocalDate finAnneeUniv;
    private boolean estValide;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Etudiant> etudiants = new HashSet<>();

}
