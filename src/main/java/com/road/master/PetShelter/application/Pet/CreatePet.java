package com.road.master.PetShelter.application.Pet;

import com.road.master.PetShelter.domain.Pet;
import com.road.master.PetShelter.domain.exceptions.ConflictException;
import com.road.master.PetShelter.infrastructure.persistence.Entity.PetEntity;
import com.road.master.PetShelter.infrastructure.persistence.repositories.Interfaces.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePet {

  private final IPetRepository petRepository;

  @Autowired
  public CreatePet(IPetRepository petRepository) {
    this.petRepository = petRepository;
  }

  public Pet execute(String id, String name, String race) {
    // Verify if exits else throe already exist exception
    var existingPet = petRepository.findById(id);
    if (existingPet.isPresent()) {
      //Throw exception
      throw new ConflictException("Pet with id " + id + " is already created");
    }

    var newPet = new Pet(id, name, race);
    var createdPet = PetEntity.toPet(petRepository.save(PetEntity.toEntity(newPet)));
    //save pet in BD and return it
    return createdPet;
  }
}
