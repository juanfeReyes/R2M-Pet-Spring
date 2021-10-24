package com.road.master.PetShelter.infrastructure.api.Donation;

import com.road.master.PetShelter.application.Donation.CreateDonation;
import com.road.master.PetShelter.domain.Donation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("donation")
@Tag(name = "Donation")
public class CreateDonationController {

  private CreateDonation createDonation;

  @Autowired
  public CreateDonationController(CreateDonation createDonation){
    this.createDonation = createDonation;
  }

  //TODO: Update requestBody to DTO for controller
  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public void createPet(@Valid @RequestBody Donation donation){
    createDonation.execute(donation);
  }
}
