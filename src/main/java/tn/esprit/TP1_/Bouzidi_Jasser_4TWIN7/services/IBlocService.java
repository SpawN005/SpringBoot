package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Bloc;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Foyer;

import java.util.List;

public interface IBlocService {
    Bloc ajouterBloc(Bloc b);
    Bloc updateBloc(Bloc b);
    void deleteBloc(long idBloc);
    Bloc getBloc(long idBloc);
    List<Bloc> getListBloc();
    Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);
    Bloc affecterBlocAFoyer( String nomBloc, String nomFoyer) ;
}
