package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Bloc;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Chambre;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Foyer;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.TypeChambre;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IBlocRepositry;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IChambreRepositry;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.repositories.IFoyerRepositry;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    IChambreRepositry chambreRepositry;
    IBlocRepositry blocRepositry;
    IFoyerRepositry foyerRepositry;
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

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        return (List<Chambre>) blocRepositry.findByNomBloc(nomBloc).getChambres();
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        return blocRepositry.findById(idBloc).orElse(null).getChambres().stream().filter(e -> e.getTypeChambre().equals(type)).count();

    }

    @Override
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type) {
        Foyer foyer = foyerRepositry.findByNomFoyer(nomFoyer);
        List<Bloc> blocs = blocRepositry.findByFoyer(foyer);
        List<Chambre> chambres = null;
        for (Bloc b : blocs) {

            chambres.addAll(chambreRepositry.findByTypeChambreAndBlocAndReservation(type,b,null));
        }
        return chambres;

    }
}
