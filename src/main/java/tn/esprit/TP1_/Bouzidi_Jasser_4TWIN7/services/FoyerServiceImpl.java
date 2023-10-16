package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Foyer;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IFoyerRepositry;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FoyerServiceImpl implements IFoyerService{
   final IFoyerRepositry foyerRepositry;



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
}
