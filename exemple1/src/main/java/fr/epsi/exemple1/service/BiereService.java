package fr.epsi.exemple1.service;

import fr.epsi.exemple1.components.BiereMapper;
import fr.epsi.exemple1.dto.BiereDTO;
import fr.epsi.exemple1.entities.Bar;
import fr.epsi.exemple1.entities.Biere;
import fr.epsi.exemple1.entities.BiereTypeEnum;
import fr.epsi.exemple1.entities.Tireuse;
import fr.epsi.exemple1.repository.BarRepo;
import fr.epsi.exemple1.repository.BiereRepo;
import fr.epsi.exemple1.repository.PersonneRepo;
import fr.epsi.exemple1.repository.TireuseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BiereService {

    final BiereRepo biereRepo;

    final BarRepo barRepo;

    final TireuseRepo tireuseRepo;

    final PersonneRepo personneRepo ;

    final BiereMapper biereMapper ;


    public void initStuff() {

        personneRepo.


        Biere biere = Biere
                .builder()
                .nom("1664")
                .typeBiere(BiereTypeEnum.BLONDE)
                .degre(4)
                .build()
                ;

        Biere biere2 = Biere
                .builder()
                .nom("IPA")
                .typeBiere(BiereTypeEnum.IPA)
                .degre(4)
                .build()
                ;

        biereRepo.save(biere) ;
        biereRepo.save(biere2) ;
        Bar bar = new Bar();
        bar.setNom("Blarney Stones");
        Tireuse tireuse = new Tireuse();

        tireuse.setBar(bar);

        Tireuse tireuse2 = new Tireuse();

        tireuse2.setBar(bar);
        barRepo.save(bar);
        tireuseRepo.save(tireuse);
        tireuseRepo.save(tireuse2);
    }

    public List<BiereDTO> getBiere(float degree, String type) {
        List<Biere> bieres = biereRepo.findBiereOfCertainDegreeAndType(degree, type) ;
        List<BiereDTO> mesBiere = new ArrayList<>() ;

        for(Biere biere : bieres) {
            mesBiere.add((biereMapper.entityToDTO(biere))) ;
        }

        return mesBiere ;
    }
}
