package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Bloc;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Chambre;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    Chambre ajouterChambre(Chambre c);
    Chambre updateChambre(Chambre c);
    void deleteChambre(long idChambre);
    Chambre getChambre(long idChambre);
    List<Chambre> getListChambre();
     List<Chambre>getChambresParNomBloc( String nomBloc) ;
     long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) ;
     List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre( String nomFoyer,TypeChambre type) ;
}
