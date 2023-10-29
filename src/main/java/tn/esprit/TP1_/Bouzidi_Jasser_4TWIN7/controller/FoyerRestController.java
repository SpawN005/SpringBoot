package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Etudiant;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Foyer;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IEtudiantService;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("foyers")
@RequiredArgsConstructor
public class FoyerRestController {
    private final IFoyerService foyerService;
    @GetMapping("allfoyers")
    public List<Foyer> retrieveAllFoyers(){return foyerService.getListFoyer();}
    @PostMapping("addfoyer")
    public Foyer addFoyer(@RequestBody Foyer b){return foyerService.ajouterFoyer(b);}
    @DeleteMapping("deletefoyer/{id}")
    public void removeFoyer(@PathVariable long id){

        foyerService.deleteFoyer(id);}
    @GetMapping("foyer/{id}")
    public Foyer retrieveFoyer(@PathVariable long id){

       return foyerService.getFoyer(id);}

    @PutMapping("updatefoyer/{id}")
    public Foyer updateFoyer(@RequestBody Foyer b)
    {
        return foyerService.updateFoyer(b);
    }
}
