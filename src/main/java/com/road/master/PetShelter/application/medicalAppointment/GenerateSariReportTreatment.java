package com.road.master.PetShelter.application.medicalAppointment;

import com.road.master.PetShelter.domain.pet.Pet;
import com.road.master.PetShelter.infrastructure.persistence.pet.IPetRepository;
import com.road.master.PetShelter.infrastructure.persistence.pet.PetEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenerateSariReportTreatment {

  private final IPetRepository petRepository;

  @Autowired
  public GenerateSariReportTreatment(IPetRepository petRepository) {
    this.petRepository = petRepository;
  }

  public List<Pet> execute(String petRace, String doctorExpertise, String adopterAddress, String adopterName) {

    var entities = petRepository.sariReport(petRace, doctorExpertise, adopterAddress, adopterName);
    return entities.stream()
        .map(PetEntity::toPet)
        .collect(Collectors.toList());
  }
}
