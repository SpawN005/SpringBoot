package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Bloc;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Chambre;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.TypeChambre;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IBlocService;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IChambreService;

import java.util.List;

@RestController
@RequestMapping("chambres")
@Tag(name = "chambre management")
@RequiredArgsConstructor
public class ChambreRestController {
    private final IChambreService chambreService;
    @GetMapping("allchambers")
    @Operation(description = "retrieve all chambres")
    public List<Chambre> getAllChambers(){return chambreService.getListChambre();}
    @PostMapping("addchamber")
    @Operation(description = "add chambre")
    public Chambre AddChamber(@RequestBody Chambre b){return chambreService.ajouterChambre(b);}
    @GetMapping("chamber/{id}")
    @Operation(description = "get specific chambre")
    public Chambre retrieveChambre(@PathVariable long id){

        return chambreService.getChambre(id);}

    @PostMapping("chamberparBlocEtType/{id}")
    @Operation(description = "get specific chambre")
    public List<Chambre> retrieveChambreByBlocAndType(@PathVariable long id, @RequestBody TypeChambre typeC){

        return chambreService.getChambresParBlocEtType(id,typeC);}

    @PutMapping("updatechamber/{id}")
    @Operation(description = "update chambre")
    public Chambre updateChamber(@RequestBody Chambre b)
    {
        return chambreService.updateChambre(b);
    }
}
