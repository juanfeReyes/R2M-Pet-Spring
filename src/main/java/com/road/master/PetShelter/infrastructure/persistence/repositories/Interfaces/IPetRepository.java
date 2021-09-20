package com.road.master.PetShelter.infrastructure.persistence.repositories.Interfaces;

import com.road.master.PetShelter.infrastructure.persistence.Entity.PetEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IPetRepository extends CrudRepository<PetEntity, UUID> {
}
