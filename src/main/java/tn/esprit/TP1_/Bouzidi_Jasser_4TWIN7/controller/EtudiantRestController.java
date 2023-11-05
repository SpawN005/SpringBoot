package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Etudiant;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Universite;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("etudiants")
@Tag(name = "etudiant management")
@RequiredArgsConstructor
public class EtudiantRestController {
    private final IEtudiantService etudiantService;
    @GetMapping("alletudiants")
    @Operation(description = "retrieve all etudiants")
    public List<Etudiant> retrieveAllEtudiants(){return etudiantService.getListEtudiant();}
    @PostMapping("addetudiant")
    @Operation(description = "add etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant b){return etudiantService.ajouterEtudiant(b);}
    @DeleteMapping("deleteetudiant/{id}")
    @Operation(description = "delete etudiant")
    public void removeEtudiant(@PathVariable long id){

        etudiantService.deleteEtudiant(id);}
    @GetMapping("etudiant/{id}")
    @Operation(description = "get specific etudiant")
    public Etudiant retriverEtudiant(@PathVariable long id){

        return etudiantService.getEtudiant(id);}

    @PutMapping("updateetudiant/{id}")
    @Operation(description = "update etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant b)
    {
        return etudiantService.updateEtudiant(b);
    }
}
