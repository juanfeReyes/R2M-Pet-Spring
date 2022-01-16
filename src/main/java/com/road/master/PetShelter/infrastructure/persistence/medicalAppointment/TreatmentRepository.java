package com.road.master.PetShelter.infrastructure.persistence.medicalAppointment;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends CrudRepository<TreatmentEntity, String>,
    QuerydslPredicateExecutor<TreatmentEntity> {

}
