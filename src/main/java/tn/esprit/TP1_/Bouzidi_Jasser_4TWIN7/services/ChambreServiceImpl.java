package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Chambre;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IChambreRepositry;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    IChambreRepositry chambreRepositry;
    @Override
    public Chambre ajouterChambre(Chambre c) {
        return chambreRepositry.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepositry.save(c);
    }

    @Override
    public void deleteChambre(long idChambre) {
        chambreRepositry.deleteById(idChambre);
    }

    @Override
    public Chambre getChambre(long idChambre) {
        return chambreRepositry.findById(idChambre).get();
    }

    @Override
    public List<Chambre> getListChambre() {
        return (List<Chambre>) chambreRepositry.findAll();
    }
}
