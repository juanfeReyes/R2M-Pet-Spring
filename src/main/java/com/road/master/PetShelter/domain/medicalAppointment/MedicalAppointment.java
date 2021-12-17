package com.road.master.PetShelter.domain.medicalAppointment;

import com.road.master.PetShelter.domain.pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//TODO: complete once doctor existis!
@Getter
@Setter
@AllArgsConstructor
public class MedicalAppointment {

  private String id;

  private Pet pet;

  private Date scheduleDate;

  private Date atentionDate;

  private String description;

  //TODO how to add reference to list of
  //TODO: Add reference to doctor
}
