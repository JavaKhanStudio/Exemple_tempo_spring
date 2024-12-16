package fr.epsi.exemple1.components;

import fr.epsi.exemple1.dto.BiereDTO;
import fr.epsi.exemple1.entities.Biere;
import fr.epsi.exemple1.repository.PersonneRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BiereMapper {


    private final PersonneRepo personneRepo ;

    public Biere dtoToEntity(BiereDTO biereDTO) {
        return Biere
                .builder()
                .nom(biereDTO.nomBiere())
                .degre(biereDTO.degre())
                .quantitee(biereDTO.quantitee())
                .typeBiere(biereDTO.typeEnum())
                .proprietaire(biereDTO.nomPersonne() != null ? personneRepo.findByNom(biereDTO.nomPersonne()) : null)
                .build();
    }

    public BiereDTO entityToDTO(Biere biere) {
        return BiereDTO
                .builder()
                .nomBiere(biere.getNom())
                .typeEnum(biere.getTypeBiere())
                .degre(biere.getDegre())
                .nomPersonne(biere.getProprietaire() != null ?biere.getProprietaire().getNom() : null)
                .build();
    }



}
