package com.road.master.PetShelter.infrastructure.persistence.pet;

import com.road.master.PetShelter.infrastructure.persistence.pet.PetEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPetRepository extends CrudRepository<PetEntity, String> {
}
