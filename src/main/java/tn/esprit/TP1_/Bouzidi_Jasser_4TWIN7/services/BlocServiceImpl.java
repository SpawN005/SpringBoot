package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Bloc;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Chambre;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Foyer;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IBlocRepositry;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IChambreRepositry;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IFoyerRepositry;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class BlocServiceImpl implements  IBlocService{
    final IBlocRepositry blocRepositry;

    final IChambreRepositry chambreRepositry;
    final IFoyerRepositry foyerRepositry;
    @Override
    public Bloc ajouterBloc(Bloc b) {
        return blocRepositry.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepositry.save(b);
    }

    @Override
    public void deleteBloc(long idBloc) {
blocRepositry.deleteById(idBloc);
    }

    @Override
    public Bloc getBloc(long idBloc) {
        return blocRepositry.findById(idBloc).get();
    }

    @Override
    public List<Bloc> getListBloc() {
        return (List<Bloc>) blocRepositry.findAll();
    }

    @Override
    @Transactional
    public Bloc affecterChambresABloc(List<Long> numChambre, Long idBloc) {
        Set<Chambre> sc = chambreRepositry.findAllByNumeroChambreIn(numChambre);
        Bloc b = blocRepositry.findById(idBloc).orElse(null);
        if(sc!=null && b!=null){
          sc.stream().forEach(e-> e.setBloc(b));
        }
        return null;
    }

    @Override
    @Transactional
    public Bloc affecterBlocAFoyer(long idBloc, long idFoyer) {
        Bloc b = blocRepositry.findById(idBloc).orElse(null);
        Foyer f= foyerRepositry.findById(idFoyer).orElse(null);
        if(f!=null && b!=null){
            b.setFoyer(f);
            return b;
        }
        return null;
    }


}
