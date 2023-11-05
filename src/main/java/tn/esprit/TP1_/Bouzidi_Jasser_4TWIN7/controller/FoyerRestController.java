package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Etudiant;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Foyer;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IEtudiantService;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("foyers")
@Tag(name = "Foyer Management")
@RequiredArgsConstructor
public class FoyerRestController {
    private final IFoyerService foyerService;
    @GetMapping("allfoyers")
    @Operation(description = "Retrieve all foyers")
    public List<Foyer> retrieveAllFoyers(){return foyerService.getListFoyer();}
    @PostMapping("addfoyer")
    @Operation(description = "add foyer")
    public Foyer addFoyer(@RequestBody Foyer b){return foyerService.ajouterFoyer(b);}
    @DeleteMapping("deletefoyer/{id}")
    @Operation(description = "delete foyer")
    public void removeFoyer(@PathVariable long id){

        foyerService.deleteFoyer(id);}
    @GetMapping("foyer/{id}")
    @Operation(description = "Retrieve one foyer")
    public Foyer retrieveFoyer(@PathVariable long id){

       return foyerService.getFoyer(id);}

    @PutMapping("updatefoyer/{id}")
    @Operation(description = "update foyer")
    public Foyer updateFoyer(@RequestBody Foyer b)
    {
        return foyerService.updateFoyer(b);
    }
}
