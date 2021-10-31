package com.road.master.PetShelter.infrastructure.persistence.mongo.documents;

import com.road.master.PetShelter.domain.Donation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Document("Donation")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DonationDocument implements Serializable {

  private String id;

  private String donor;

  private Date date;

  private String description;

  private Map<String, String> detail;

  public static DonationDocument toDocument(Donation donation) {
    return DonationDocument.builder()
        .donor(donation.getDonor())
        .id(donation.getId())
        .date(donation.getDate())
        .description(donation.getDescription())
        .detail(donation.getDetail())
        .build();
  }

  public static Donation toEntity(DonationDocument document) {
    return Donation.builder()
        .donor(document.getDonor())
        .id(document.getId())
        .date(document.getDate())
        .description(document.getDescription())
        .detail(document.getDetail())
        .build();
  }
}
