package com.road.master.PetShelter.application.Pet;

import com.road.master.PetShelter.domain.Pet;
import com.road.master.PetShelter.infrastructure.persistence.Entity.PetEntity;
import com.road.master.PetShelter.infrastructure.persistence.repositories.Interfaces.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GetPets {

    private IPetRepository petRepository;

    @Autowired
    public GetPets(IPetRepository petRepository){
        this.petRepository = petRepository;
    }

    public List<Pet> execute(){
        var pets = StreamSupport.stream(petRepository.findAll().spliterator(), false)
                .map(pet -> PetEntity.toPet(pet))
                .collect(Collectors.toList());

        return pets ;
    }
}
