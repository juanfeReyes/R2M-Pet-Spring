package com.road.master.PetShelter.infrastructure.persistence.Entity;

import com.road.master.PetShelter.domain.Pet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class PetEntity {

  @Id
  private String id;

  @Column(length = 50, nullable = false)
  private String name;

  @Column(length = 50, nullable = false)
  private String race;

  public PetEntity() {
  }

  public PetEntity(String id, String name, String race) {
    this.id = id;
    this.name = name;
    this.race = race;
  }

  public static PetEntity toEntity(Pet pet) {
    return new PetEntity(
        pet.getId(),
        pet.getName().getValue(),
        pet.getRace().getValue());
  }

  public static Pet toPet(PetEntity entity) {
    return new Pet(entity.id, entity.name, entity.race);
  }
}
