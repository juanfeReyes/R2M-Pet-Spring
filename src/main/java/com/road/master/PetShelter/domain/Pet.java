package com.road.master.PetShelter.domain;

import com.road.master.PetShelter.domain.valueObjects.Name;
import com.road.master.PetShelter.domain.valueObjects.Race;
import lombok.Getter;

@Getter
public class Pet {

    private String id;

    private Name name;

    private Race race;

    public Pet(String id, String name, String race){
        this.id = id;
        this.name = new Name(name);
        this.race = new Race(race);
    }
}
