package com.road.master.PetShelter.infrastructure.persistence.mongo.repositories;

import com.road.master.PetShelter.infrastructure.persistence.mongo.documents.DonationDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DonationRepository extends MongoRepository<DonationDocument, String> {
}
