package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table( name = "Chambre")
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idChambre")
    private Long idChambre;
    private Long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;

    @ManyToOne(fetch = FetchType.EAGER)
    Bloc bloc;
@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Reservation> reservation = new HashSet<>();


}
