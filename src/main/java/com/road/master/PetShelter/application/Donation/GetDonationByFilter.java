package com.road.master.PetShelter.application.Donation;

import com.road.master.PetShelter.domain.Donation;
import com.road.master.PetShelter.infrastructure.persistence.mongo.documents.DonationDocument;
import com.road.master.PetShelter.infrastructure.persistence.mongo.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class GetDonationByFilter {

  private final DonationRepository donationRepository;

  private final RedisTemplate<String, Object> redisTemplate;

  @Autowired
  public GetDonationByFilter(DonationRepository donationRepository,
                             RedisTemplate<String, Object> redisTemplate) {
    this.donationRepository = donationRepository;
    this.redisTemplate = redisTemplate;
  }

  public Donation execute(String id) {
    var donation = (DonationDocument) redisTemplate.opsForValue().get(id);

    if (donation == null) {
      donation = donationRepository.findById(id).get();
      redisTemplate.opsForValue().set(id, donation);
    }

    return DonationDocument.toEntity(donation);
  }
}
