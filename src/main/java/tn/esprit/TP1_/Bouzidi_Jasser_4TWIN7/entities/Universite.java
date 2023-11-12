package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table( name = "Universite")
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUniversite")
    private Long idUniversite;
    @JsonIgnore
    @OneToOne
    private Foyer foyer;
    @Column(unique = true )
    private String nomUniversite;

    private String adresse;
}
