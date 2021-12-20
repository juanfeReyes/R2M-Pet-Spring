package com.road.master.PetShelter.infrastructure.api.medicalAppointment.dto;

import com.road.master.PetShelter.domain.pet.Pet;
import com.road.master.PetShelter.domain.user.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalAppointmentRequest {

  private String id;

  private Date scheduleDate;

  private Date atentionDate;

  private String description;

  private String doctorId;

  private String petId;
}
