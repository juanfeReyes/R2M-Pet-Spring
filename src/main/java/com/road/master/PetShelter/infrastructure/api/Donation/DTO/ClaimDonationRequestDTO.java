package com.road.master.PetShelter.infrastructure.api.Donation.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClaimDonationRequestDTO {

  private String donationId;

  private String claimer;
}
