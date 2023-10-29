package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Etudiant;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("etudiants")
@RequiredArgsConstructor
public class EtudiantRestController {
    private final IEtudiantService etudiantService;
    @GetMapping("alletudiants")
    public List<Etudiant> retrieveAllEtudiants(){return etudiantService.getListEtudiant();}
    @PostMapping("addetudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant b){return etudiantService.ajouterEtudiant(b);}
    @DeleteMapping("deleteetudiant/{id}")
    public void removeEtudiant(@PathVariable long id){

        etudiantService.deleteEtudiant(id);}
    @GetMapping("etudiant/{id}")
    public Etudiant retriverEtudiant(@PathVariable long id){

        return etudiantService.getEtudiant(id);}

    @PutMapping("updateetudiant/{id}")
    public Etudiant updateEtudiant(@RequestBody Etudiant b)
    {
        return etudiantService.updateEtudiant(b);
    }
}
