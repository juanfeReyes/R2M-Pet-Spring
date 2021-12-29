package com.road.master.PetShelter.domain.medicalAppointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Treatment {

  private String id;

  private double dosis;

  private String unit;

  private String description;

  private MedicalAppointment medicalAppointment;

  private Treatment treatmentGroup;

  private List<Treatment> treatments;

}
