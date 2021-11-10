package fr.diginamic.petstore.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.EnumType;

import fr.diginamic.petstore.enums.FishLivEnv;

@Entity
@Table(name = "FISH")
public class Fish extends Animal {

	@Enumerated(EnumType.ORDINAL)
	private FishLivEnv livingEnv;
	
	public Fish(LocalDate birth, String color, Petstore petstore, FishLivEnv livingEnv) {
		super(birth, color, petstore);
		this.livingEnv = livingEnv;
	}
	
	@Override
	public String toString() {
		return this.getColor() + " " + this.getBirth() + " " + this.getLivingEnv();
	}


	/**
	 * @return the livingEnv
	 */
	public FishLivEnv getLivingEnv() {
		return livingEnv;
	}

	/**
	 * @param livingEnv the livingEnv to set
	 */
	public void setLivingEnv(FishLivEnv livingEnv) {
		this.livingEnv = livingEnv;
	}

}
