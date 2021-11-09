package com.road.master.PetShelter.application.Donation;

import com.road.master.PetShelter.domain.Donation;
import com.road.master.PetShelter.domain.DonationAudit;
import com.road.master.PetShelter.infrastructure.persistence.mongo.documents.DonationDocument;
import com.road.master.PetShelter.infrastructure.persistence.mongo.repositories.DonationRepository;
import com.road.master.PetShelter.infrastructure.searchEngine.document.DonationAuditDocument;
import com.road.master.PetShelter.infrastructure.searchEngine.document.DonationAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaimDonation {

  private final DonationRepository donationRepository;

  private final DonationAuditRepository donationAuditRepository;

  @Autowired
  public ClaimDonation(DonationRepository donationRepository,
                       DonationAuditRepository donationAuditRepository){
    this.donationRepository = donationRepository;
    this.donationAuditRepository = donationAuditRepository;
  }

  public DonationAudit execute(String donationId, String claimer){

    var donation = donationRepository.findById(donationId).get();

    if(donation == null){
      throw new RuntimeException("Donation not found");
    }

    donationRepository.delete(donation);
    var donationAudit = new DonationAudit(DonationDocument.toEntity(donation), claimer);

    donationAuditRepository.save(DonationAuditDocument.toDocument(donationAudit));
    return donationAudit;
  }
}
