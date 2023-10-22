package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Bloc;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre ajouterChambre(Chambre c);
    Chambre updateChambre(Chambre c);
    void deleteChambre(long idChambre);
    Chambre getChambre(long idChambre);
    List<Chambre> getListChambre();
}
