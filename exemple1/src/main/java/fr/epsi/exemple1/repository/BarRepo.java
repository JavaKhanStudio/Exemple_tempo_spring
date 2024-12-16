package fr.epsi.exemple1.repository;

import fr.epsi.exemple1.entities.Bar;
import fr.epsi.exemple1.entities.Tireuse;
import org.springframework.data.repository.CrudRepository;

public interface BarRepo extends CrudRepository<Bar, Long> {
}
