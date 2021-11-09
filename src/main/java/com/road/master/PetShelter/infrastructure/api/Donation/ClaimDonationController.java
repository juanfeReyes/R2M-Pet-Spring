package com.road.master.PetShelter.infrastructure.api.Donation;

import com.road.master.PetShelter.application.Donation.ClaimDonation;
import com.road.master.PetShelter.infrastructure.api.Donation.DTO.ClaimDonationRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("donation")
@Tag(name = "Donation")
public class ClaimDonationController {

  private final ClaimDonation claimDonation;

  @Autowired
  public ClaimDonationController(ClaimDonation claimDonation){
    this.claimDonation = claimDonation;
  }

  @Operation(summary = "Claim donation", security = {@SecurityRequirement(name = "OAuthScheme")})
  @PostMapping(value = "/claim", produces = MediaType.APPLICATION_JSON_VALUE)
  @PreAuthorize("hasRole('WRITE')")
  public void claimDonation(@Valid @RequestBody ClaimDonationRequestDTO claimDonationRequest) {
    claimDonation.execute(claimDonationRequest.getDonationId(), claimDonationRequest.getClaimer());
  }
}
