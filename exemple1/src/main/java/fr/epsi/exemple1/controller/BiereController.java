package fr.epsi.exemple1.controller;

import fr.epsi.exemple1.dto.BiereDTO;
import fr.epsi.exemple1.entities.Bar;
import fr.epsi.exemple1.entities.Biere;
import fr.epsi.exemple1.entities.BiereTypeEnum;
import fr.epsi.exemple1.entities.Tireuse;
import fr.epsi.exemple1.repository.BarRepo;
import fr.epsi.exemple1.repository.BiereRepo;
import fr.epsi.exemple1.repository.TireuseRepo;
import fr.epsi.exemple1.service.BiereService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/biere")
@RequiredArgsConstructor
public class BiereController {

    final BiereService biereService;


    @GetMapping(path = "/init")
    public void initStuff() {
        biereService.initStuff() ;
    }

    @GetMapping(path = "/precis")
    public List<BiereDTO> getBiere(float degree, String type) {
        return biereRepo.findBiereOfCertainDegreeAndType(degree, type) ;
    }

    @GetMapping(path = "/parNom")
    public List<Biere> getBiere(String nom) {
        return biereRepo.findBiereByNom(nom) ;
    }

    @GetMapping(path = "/bar")
    public Bar returnBar() {
        return barRepo.findById(2L).orElse(null) ;
    }


    @GetMapping(path = "")
    public Iterable<Biere> biere() {
        return biereRepo.findAll() ;}

    @GetMapping(path = "/{id}")
    public Biere biere(@PathVariable() long id) {
        Optional<Biere> biereOptional = biereRepo.findById(id) ;
        if (biereOptional.isPresent()) {
            return biereOptional.get() ;
        } else {
            System.out.println("C'est dommage");
            return null ;
        }
    }

    @PostMapping
    public String addBiere(@RequestBody BiereDTO biereDto) {

        Biere biere = Biere
                .builder()
                .nom(biereDto.nom())
                .degre(biereDto.pourcent())
                .build() ;

        biereRepo.save(biere) ;
        return "OK" ;
    }



}
