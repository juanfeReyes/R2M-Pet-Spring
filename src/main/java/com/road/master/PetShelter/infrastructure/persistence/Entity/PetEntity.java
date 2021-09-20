package com.road.master.PetShelter.infrastructure.persistence.Entity;

import com.road.master.PetShelter.domain.Pet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Setter
@Getter
public class PetEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String race;

    public PetEntity(){}

    public PetEntity(UUID id, String name, String race){
        this.id = id;
        this.name = name;
        this.race = race;
    }

    public static PetEntity toEntity(Pet pet){
        return new PetEntity(
                UUID.fromString(pet.getId()),
                pet.getName().getValue(),
                pet.getName().getValue());
    }

    public static Pet toPet(PetEntity entity){
        return new Pet(entity.id.toString(), entity.name, entity.race);
    }
}
