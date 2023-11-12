package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Foyer;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IBlocRepositry;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IFoyerRepositry;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IUniversiteRepositry;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FoyerServiceImpl implements IFoyerService{
   final IFoyerRepositry foyerRepositry;
    final IUniversiteRepositry universiteRepositry;
    final IBlocRepositry blocRepositry;



    @Override
    public Foyer ajouterFoyer(Foyer f) {
        return foyerRepositry.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepositry.save(f);
    }

    @Override
    public void deleteFoyer(long idFoyer) {
        foyerRepositry.deleteById(idFoyer);
    }

    @Override
    public Foyer getFoyer(long idFoyer) {
        return foyerRepositry.findById(idFoyer).get();
    }

    @Override
    public List<Foyer> getListFoyer() {
        return (List<Foyer>) foyerRepositry.findAll();
    }

    @Override
    @Transactional
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite u =universiteRepositry.findById(idUniversite).orElse(null);
        if (u!=null){
            this.ajouterFoyer(foyer);
           foyer.getBlocs().stream().forEach(e->{
               blocRepositry.save(e);
               e.setFoyer(foyer);
           });


            u.setFoyer(foyer);
            return foyer;
        }


        return null;
    }
}
