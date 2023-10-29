package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Chambre;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IChambreService;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("universities")
@RequiredArgsConstructor
public class UniversiteRestController {
    private final IUniversiteService universiteService;
    @GetMapping("alluniversities")
    public List<Universite> retrieveAllUniversities(){return universiteService.getListUniversite();}
    @PostMapping("adduniversity")
    public Universite addUniversite(@RequestBody Universite b){return universiteService.ajouterUniversite(b);}
    @DeleteMapping("university/{id}")
    public Universite retrieveUniversity(@PathVariable long id){

       return universiteService.getUniversite(id);}

    @PutMapping("updateuniversity/{id}")
    public Universite updateUniversite(@RequestBody Universite b)
    {
        return universiteService.updateUniversite(b);
    }
}
