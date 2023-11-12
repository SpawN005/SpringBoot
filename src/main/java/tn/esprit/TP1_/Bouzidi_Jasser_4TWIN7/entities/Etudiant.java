package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table( name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private Long cin;
    private String ecole;
    private LocalDate dateNaissance;
@JsonIgnore
    @ManyToMany(mappedBy = "etudiants")
    private Set<Reservation> reservations;






}
