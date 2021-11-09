package com.road.master.PetShelter.infrastructure.searchEngine.document;


import com.road.master.PetShelter.domain.Donation;
import com.road.master.PetShelter.domain.DonationAudit;
import lombok.Builder;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Document(indexName = "donation_audits")
@Builder
public class DonationAuditDocument {

  @Id
  private String id;

  private Donation donation;

  private String claimer;

  public static DonationAuditDocument toDocument(DonationAudit donationAudit){
    return DonationAuditDocument.builder()
        .donation(donationAudit.getDonation())
        .claimer(donationAudit.getClaimer())
        .build();
  }
}
