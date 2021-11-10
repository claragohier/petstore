package fr.diginamic.petstore.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ANIMAL")
public abstract class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "birth", length = 50, nullable = false)
	private LocalDate birth;

	@Column(name = "color", length = 50, nullable = false)
	private String color;

	@ManyToOne
	@JoinColumn(name = "petstore_id", referencedColumnName = "id")
	private Petstore petstore;

	public Animal(LocalDate birth, String color, Petstore petstore) {
		this.birth = birth;
		this.color = color;
		this.petstore = petstore;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the birth
	 */
	public LocalDate getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

}
