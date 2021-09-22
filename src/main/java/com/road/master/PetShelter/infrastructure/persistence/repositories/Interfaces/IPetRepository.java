package com.road.master.PetShelter.infrastructure.persistence.repositories.Interfaces;

import com.road.master.PetShelter.infrastructure.persistence.Entity.PetEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPetRepository extends CrudRepository<PetEntity, String> {
}
