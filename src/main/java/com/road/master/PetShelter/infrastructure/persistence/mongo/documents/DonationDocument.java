package com.road.master.PetShelter.infrastructure.persistence.mongo.documents;

import com.road.master.PetShelter.domain.Donation;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Document("Donation")
@Builder
public class DonationDocument {

  private String id;

  private String donor;

  private Date date;

  private String description;

  private Map<String, String> detail;

  public static DonationDocument toDocument(Donation donation){
    return DonationDocument.builder()
        .donor(donation.getDonor())
        .id(donation.getId())
        .date(donation.getDate())
        .description(donation.getDescription())
        .detail(donation.getDetail())
        .build();
  }
}
