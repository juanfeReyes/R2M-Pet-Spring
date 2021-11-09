package com.road.master.PetShelter.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DonationAudit {

  private Donation donation;

  private String claimer;
}
