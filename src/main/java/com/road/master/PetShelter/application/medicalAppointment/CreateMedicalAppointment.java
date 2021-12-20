package com.road.master.PetShelter.application.medicalAppointment;

import com.road.master.PetShelter.domain.exceptions.ConflictException;
import com.road.master.PetShelter.domain.exceptions.NotFoundException;
import com.road.master.PetShelter.domain.medicalAppointment.MedicalAppointment;
import com.road.master.PetShelter.infrastructure.api.medicalAppointment.dto.MedicalAppointmentRequest;
import com.road.master.PetShelter.infrastructure.persistence.medicalAppointment.IMedicalAppointmentRepository;
import com.road.master.PetShelter.infrastructure.persistence.medicalAppointment.MedicalAppointmentEntity;
import com.road.master.PetShelter.infrastructure.persistence.pet.IPetRepository;
import com.road.master.PetShelter.infrastructure.persistence.user.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMedicalAppointment {

  private final IMedicalAppointmentRepository medicalAppointmentRepository;

  private final IPetRepository petRepository;

  private final IDoctorRepository doctorRepository;

  @Autowired
  public CreateMedicalAppointment(IMedicalAppointmentRepository medicalAppointmentRepository,
                                  IDoctorRepository doctorRepository,
                                  IPetRepository petRepository) {
    this.medicalAppointmentRepository = medicalAppointmentRepository;
    this.petRepository = petRepository;
    this.doctorRepository = doctorRepository;
  }

  public MedicalAppointment execute(MedicalAppointmentRequest request) {
    var pet = petRepository.findById(request.getPetId());
    if (pet.isEmpty()) {
      throw new NotFoundException("pet not found with id: " + request.getPetId());
    }

    var doctor = doctorRepository.findById(request.getDoctorId());
    if (doctor.isEmpty()) {
      throw new NotFoundException("doctor not found with id: " + request.getDoctorId());
    }

    var savedAppointment = medicalAppointmentRepository.findById(request.getId());
    if (savedAppointment.isPresent()) {
      throw new ConflictException("Medical appointment already exists");
    }

    var medicalAppointment = medicalAppointmentRepository.save(
        new MedicalAppointmentEntity(request.getId(),
            request.getScheduleDate(),
            request.getAtentionDate(),
            request.getDescription(),
            pet.get(),
            doctor.get()));

    return medicalAppointment.toDomain();
  }
}
