package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Getter
@Setter
@Table( name = "Bloc")
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBloc")
    private Long idBloc;
    private String nomBloc;

    private Long capaciteBloc;
}
