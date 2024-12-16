package fr.epsi.exemple1.dto;

import fr.epsi.exemple1.entities.BiereTypeEnum;
import fr.epsi.exemple1.entities.Personne;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Builder;

@Builder
public record BiereDTO(String nomBiere, BiereTypeEnum typeEnum, float degre, int quantitee, String nomPersonne) {


}
