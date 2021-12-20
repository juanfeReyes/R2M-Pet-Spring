package com.road.master.PetShelter.domain.medicalAppointment;

import com.road.master.PetShelter.domain.pet.Pet;
import com.road.master.PetShelter.domain.user.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class MedicalAppointment {

  private String id;

  private Date scheduleDate;

  private Date atentionDate;

  private String description;

  private Doctor doctor;

  private Pet pet;
}
