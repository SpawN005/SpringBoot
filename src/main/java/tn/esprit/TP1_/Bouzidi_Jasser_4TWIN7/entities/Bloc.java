package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table( name = "Bloc")
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBloc")
    @JsonIgnore
    private Long idBloc;
    private String nomBloc;

    private Long capaciteBloc;
    @JsonIgnore
    @ManyToOne
    private Foyer foyer;
    @JsonIgnore
    @OneToMany(mappedBy = "bloc",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Chambre> chambres;
}
