package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Bloc;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IBlocRepositry;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IFoyerRepositry;

import java.util.List;
@RequiredArgsConstructor
@Service
public class BlocServiceImpl implements  IBlocService{
    final IBlocRepositry blocRepositry;
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
}
