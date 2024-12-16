package fr.epsi.exemple1.repository;

import fr.epsi.exemple1.entities.Personne;
import fr.epsi.exemple1.entities.Tireuse;
import org.springframework.data.repository.CrudRepository;

public interface PersonneRepo extends CrudRepository<Personne, Long> {

    public Personne findByNom(String nom);


}
