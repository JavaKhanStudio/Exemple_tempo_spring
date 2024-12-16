package fr.epsi.exemple1.repository;

import fr.epsi.exemple1.entities.Biere;
import fr.epsi.exemple1.entities.Tireuse;
import org.springframework.data.repository.CrudRepository;

public interface TireuseRepo extends CrudRepository<Tireuse, Long> {
}
