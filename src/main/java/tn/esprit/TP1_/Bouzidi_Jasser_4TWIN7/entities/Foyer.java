package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table( name = "Foyer")
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idFoyer")

    private Long idFoyer;
    private String nomFoyer;
    @JsonIgnore
    @OneToOne(mappedBy = "foyer")
    private Universite universite;
    private Long capaciteFoyer;

    @OneToMany(mappedBy = "foyer",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private Set<Bloc> blocs;
}
