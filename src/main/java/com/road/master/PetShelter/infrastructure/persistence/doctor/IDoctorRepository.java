package com.road.master.PetShelter.infrastructure.persistence.doctor;

import org.springframework.data.repository.CrudRepository;

public interface IDoctorRepository extends CrudRepository<DoctorEntity, String> {
}
