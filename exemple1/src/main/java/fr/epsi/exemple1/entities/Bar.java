package fr.epsi.exemple1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nom ;

    @ManyToMany
    List<Biere> bieresVendues ;

    @OneToMany(mappedBy = "bar")
    @JsonIgnore
    List<Tireuse> tireuses ;

}
