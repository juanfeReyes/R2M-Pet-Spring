package com.road.master.PetShelter.infrastructure.persistence.medicalAppointment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITreatmentRepository extends CrudRepository<TreatmentEntity, String> {
}
