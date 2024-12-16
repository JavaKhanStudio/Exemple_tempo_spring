package fr.epsi.exemple1.repository;

import fr.epsi.exemple1.entities.Biere;
import fr.epsi.exemple1.entities.BiereTypeEnum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface BiereRepo extends CrudRepository<Biere, Long> {

    @Query(value = "SELECT * FROM Biere biere WHERE biere.degre > ?1 && biere.type_biere = ?2"
            , nativeQuery = true)
    public ArrayList<Biere> findBiereOfCertainDegreeAndType(float degreeMin, String type) ;

    public List<Biere> findBiereByNom(String nom);

}
