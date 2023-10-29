package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Bloc;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Chambre;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IBlocService;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IChambreService;

import java.util.List;

@RestController
@RequestMapping("chambres")
@RequiredArgsConstructor
public class ChambreRestController {
    private final IChambreService chambreService;
    @GetMapping("allchambers")
    public List<Chambre> getAllChambers(){return chambreService.getListChambre();}
    @PostMapping("addchamber")
    public Chambre AddChamber(@RequestBody Chambre b){return chambreService.ajouterChambre(b);}
    @GetMapping("chamber/{id}")
    public Chambre retrieveChambre(@PathVariable long id){

        return chambreService.getChambre(id);}

    @PutMapping("updatechamber/{id}")
    public Chambre updateChamber(@RequestBody Chambre b)
    {
        return chambreService.updateChambre(b);
    }
}
