package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Chambre;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IChambreService;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("universities")
@Tag(name = "universite management")
@RequiredArgsConstructor
public class UniversiteRestController {
    private final IUniversiteService universiteService;
    @GetMapping("alluniversities")
    @Operation(description = "retrieve all universities")
    public List<Universite> retrieveAllUniversities(){return universiteService.getListUniversite();}
    @PostMapping("adduniversity")
    @Operation(description = "add university")
    public Universite addUniversite(@RequestBody Universite b){return universiteService.ajouterUniversite(b);}
    @DeleteMapping("university/{id}")
    @Operation(description = "delete university")
    public Universite retrieveUniversity(@PathVariable long id){

       return universiteService.getUniversite(id);}
    @PutMapping("affecterFoyeraUniver/{f}")
    @Operation(description = "add university")
    public Universite affecterFoyeraUniver(@PathVariable long f,@RequestBody String nomUniv){return universiteService.affecterFoyerAUniversite(f,nomUniv);}

    @PutMapping("desafecter/{f}")
    @Operation(description = "add university")
    public Universite desaffecterFoyer(@PathVariable long f){return universiteService.desaffecterFoyerAUniversite(f);}

    @PutMapping("updateuniversity/{id}")
    @Operation(description = "update university")
    public Universite updateUniversite(@RequestBody Universite b)
    {
        return universiteService.updateUniversite(b);
    }
}
