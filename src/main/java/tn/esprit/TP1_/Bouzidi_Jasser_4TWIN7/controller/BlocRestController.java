package tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.entities.Bloc;
import tn.esprit.TP1_.Bouzidi_Jasser_4TWIN7.services.IBlocService;

import java.util.List;

@RestController
@RequestMapping("blocs")
@RequiredArgsConstructor
@Tag(name = "bloc management")
public class BlocRestController {
    private final IBlocService blocService;
    @GetMapping("allblocs")
    @Operation(description = "retrieve all blocs")
    public List<Bloc> retrieveBlocs(){return blocService.getListBloc();}
    @PostMapping("addbloc")
    @Operation(description = "add bloc")
    public Bloc addBloc(@RequestBody Bloc b){return blocService.ajouterBloc(b);}
    @GetMapping("bloc/{id}")
    @Operation(description = "get a specific bloc")
    Bloc retrieveBloc (@PathVariable long idBloc){
        return blocService.getBloc(idBloc);
    };
    @DeleteMapping("deletebloc/{id}")
    @Operation(description = "delete bloc")
    public void removeBloc(@PathVariable long id){

        blocService.deleteBloc(id);}

    @PutMapping("updatebloc/{id}")
    @Operation(description = "update bloc")
    public Bloc updateBloc(@RequestBody Bloc b)
    {
        return blocService.updateBloc(b);
    }
}
