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
    final IChambreRepositry chambreRepositry;
    final IBlocRepositry blocRepositry;
    final IFoyerRepositry foyerRepositry;
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
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        System.out.println(typeC);
        return blocRepositry.findById(idBloc).orElse(null).getChambres().stream().filter(e -> e.getTypeChambre().equals(typeC)).toList();

    }


}
