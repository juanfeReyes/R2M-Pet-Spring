package com.road.master.PetShelter.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.Map;

@Getter
@Builder
public class Donation {

  private String id;

  private String donor;

  private Date date;

  private String description;

  private Map<String, String> detail;
}
