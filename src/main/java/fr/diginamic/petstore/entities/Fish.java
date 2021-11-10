package fr.diginamic.petstore.entities;

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
