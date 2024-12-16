package fr.epsi.exemple1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Biere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	float degre ;

	@Enumerated(EnumType.STRING)
	BiereTypeEnum typeBiere ;

	protected String nom ;
	protected int quantitee ;

	@OneToOne
	protected Personne proprietaire ;

	@ManyToMany(mappedBy = "bieresVendues")
	List<Bar> ouBieresVendues ;

	public void boire(Personne personne, int quantiteeBu) {
		System.out.println("Je bois un brevage");

		if(quantiteeBu == 0) {

			System.out.println("Attention tente de boire 0");
			return ;
		}

		if(quantiteeBu > this.quantitee) {
			quantiteeBu = this.quantitee ;
			this.quantitee = 0 ;
			return ;
		} else {
			this.quantitee -= quantiteeBu ;
		}

		personne.setLiquideEstomac(personne.getLiquideEstomac() + quantiteeBu);
		Personne.biereBue ++;

	}


	@Override
	public String toString() {
		return "Biere [nom=" + this.getNom() + ", quantitee=" + this.quantitee + ", degre=" + degre + ", typeBiere=" + typeBiere + "]";
	}


}
