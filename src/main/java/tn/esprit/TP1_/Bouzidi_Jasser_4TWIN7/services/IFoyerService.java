package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Foyer;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IFoyerRepositry;

import java.util.List;

public interface IFoyerService  {
    Foyer ajouterFoyer(Foyer f);
    Foyer updateFoyer(Foyer f);
    void deleteFoyer(long idFoyer);
    Foyer getFoyer(long idFoyer);
    List<Foyer> getListFoyer();
    Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
