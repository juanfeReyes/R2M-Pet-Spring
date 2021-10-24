package com.road.master.PetShelter.application.Donation;

import com.road.master.PetShelter.domain.Donation;
import com.road.master.PetShelter.infrastructure.persistence.mongo.documents.DonationDocument;
import com.road.master.PetShelter.infrastructure.persistence.mongo.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDonation {

  private DonationRepository donationRepository;

  @Autowired
  public CreateDonation(DonationRepository donationRepository){
    this.donationRepository = donationRepository;
  }

  public void execute(Donation donation){
    this.donationRepository.save(DonationDocument.toDocument(donation));
  }
}
