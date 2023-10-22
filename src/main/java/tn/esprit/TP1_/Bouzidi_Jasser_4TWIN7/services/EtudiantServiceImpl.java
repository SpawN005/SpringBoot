package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Etudiant;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IEtudiantRepositry;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    IEtudiantRepositry etudiantRepositry;
    @Override
    public Etudiant ajouterEtudiant(Etudiant E) {
        return etudiantRepositry.save(E);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant E) {
        return etudiantRepositry.save(E);
    }

    @Override
    public void deleteEtudiant(long idEtudiant) {
        etudiantRepositry.deleteById(idEtudiant);
    }

    @Override
    public Etudiant getEtudiant(long idEtudiant) {
        return etudiantRepositry.findById(idEtudiant).get();
    }

    @Override
    public List<Etudiant> getListEtudiant() {
        return (List<Etudiant>) etudiantRepositry.findAll();
    }
}
