package com.road.master.PetShelter.infrastructure.searchEngine.document;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DonationAuditRepository extends ElasticsearchRepository<DonationAuditDocument, String> {
}
