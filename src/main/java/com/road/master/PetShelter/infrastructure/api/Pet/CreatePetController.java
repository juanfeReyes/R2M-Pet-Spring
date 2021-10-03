package com.road.master.PetShelter.infrastructure.api.Pet;

import com.road.master.PetShelter.application.Pet.CreatePet;
import com.road.master.PetShelter.domain.Pet;
import com.road.master.PetShelter.infrastructure.api.Pet.dto.PetDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("pets")
@Tag(name = "Pets")
@SecurityRequirement(name = "basicAuth")
public class CreatePetController {

  private final CreatePet createPet;

  @Autowired
  public CreatePetController(CreatePet createPet) {
    this.createPet = createPet;
  }

  //TODO: Update requestBody to DTO for controller
  @Operation(summary = "Create pet", security = {@SecurityRequirement(name = "OAuthScheme")})
  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public Pet createPet(@Valid @RequestBody PetDTO pet) {
    return createPet.execute(pet.getId(), pet.getName(), pet.getRace());
  }
}
