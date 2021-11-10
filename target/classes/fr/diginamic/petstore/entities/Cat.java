package fr.diginamic.petstore.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDate;

import javax.persistence.Column;

@Entity
@Table(name = "CAT")
public class Cat extends Animal{

	@Column(name = "chip_id", length = 50, nullable = false)
	private String chipId;
	
	public Cat(LocalDate birth, String color, Petstore petstore, String chipId) {
		super(birth, color, petstore);
		this.chipId = chipId;
	}
	
	@Override
	public String toString() {
		return this.getColor() + " " + this.getBirth() + " " + this.getChipId();
	}

	/**
	 * @return the chipId
	 */
	public String getChipId() {
		return chipId;
	}

	/**
	 * @param chipId the chipId to set
	 */
	public void setChipId(String chipId) {
		this.chipId = chipId;
	}
	
}
