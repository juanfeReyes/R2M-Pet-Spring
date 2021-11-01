package com.road.master.PetShelter.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DonationTest {

  @Test
  public void DonationIsNotNull(){
    var donation = new Donation("id",
        "juan",
        new Date(),
        "description",
        Map.of());

    assertThat(donation).isNull();
  }
}
