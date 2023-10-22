package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IUniversiteRepositry;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService{
    IUniversiteRepositry universiteRepositry;
    @Override
    public Universite ajouterUniversite(Universite U) {
        return universiteRepositry.save(U);
    }

    @Override
    public Universite updateUniversite(Universite U) {
        return universiteRepositry.save(U);
    }

    @Override
    public void deleteUniversite(long idUniversite) {
        universiteRepositry.deleteById(idUniversite);
    }

    @Override
    public Universite getUniversite(long idUniversite) {
        return universiteRepositry.findById(idUniversite).get();
    }

    @Override
    public List<Universite> getListUniversite() {
        return (List<Universite>) universiteRepositry.findAll();
    }
}
