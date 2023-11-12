package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Foyer;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IFoyerRepositry;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IUniversiteRepositry;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService{
   final IUniversiteRepositry universiteRepositry;
    final  IFoyerRepositry foyerRepositry;
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



    @Override
    @Transactional
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer f = foyerRepositry.findById(idFoyer).orElse(null);
        Universite u = universiteRepositry.findByNomUniversite(nomUniversite);
        System.out.println(u);
        if(f!=null && u!=null){
            u.setFoyer(f);
            return u;

        }
        return null;
    }

    @Override
    @Transactional
    public Universite desaffecterFoyerAUniversite(long idUniversite) {

        Universite u = universiteRepositry.findById(idUniversite).orElse(null);
        if(u!=null){
            u.setFoyer(null);
            return u;

        }
        return null;
    }
}
