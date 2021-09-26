package com.road.master.PetShelter.infrastructure.api.Pet;

import com.road.master.PetShelter.application.Pet.GetPets;
import com.road.master.PetShelter.domain.Pet;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pets")
@Tag(name = "Pets")
@SecurityRequirement(name = "basicAuth")
public class GetPetsController {

    private GetPets getPets;

    @Autowired
    public GetPetsController(GetPets getPets){
        this.getPets = getPets;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pet> getPets(){
        return getPets.execute();
    }
}
