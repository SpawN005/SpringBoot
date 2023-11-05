package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite ajouterUniversite(Universite U);
    Universite updateUniversite(Universite U);
    void deleteUniversite(long idUniversite);
    Universite getUniversite(long idUniversite);

    List<Universite> getListUniversite();
    Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    Universite desaffecterFoyerAUniversite (long idFoyer, long idUniversite) ;
}
