package com.teamtreehouse.model;

import javafx.collections.transformation.SortedList;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Player implements Comparable<Player>, Serializable {
  private static final long serialVersionUID = 1L;

  private String firstName;
  private String lastName;
  private int heightInInches;
  private boolean previousExperience;

  public Player(String firstName, String lastName, int heightInInches, boolean previousExperience) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.heightInInches = heightInInches;
    this.previousExperience = previousExperience;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getHeightInInches() {
    return heightInInches;
  }

  public boolean isPreviousExperience() {
    return previousExperience;
  }

  @Override
  public int compareTo(Player other) {
    // We always want to sort by last name then first name
    if(equals(other)) {
      return 0;
    }
    int lastNameCompare = lastName.compareTo(other.lastName);
    if(lastNameCompare == 0) {
      return firstName.compareTo(other.firstName);
    }

    return lastNameCompare;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Player)) return false;

    Player player = (Player) o;

    if (heightInInches != player.heightInInches) return false;
    if (previousExperience != player.previousExperience) return false;
    if (!firstName.equals(player.firstName)) return false;
    return lastName.equals(player.lastName);

  }

  @Override
  public int hashCode() {
    int result = firstName.hashCode();
    result = 31 * result + lastName.hashCode();
    result = 31 * result + heightInInches;
    result = 31 * result + (previousExperience ? 1 : 0);
    return result;
  }
  
  @Override
  public String toString() {
    return String.format("%s, %s, %s, %s", lastName, firstName, heightInInches, previousExperience);
  }

  public String playerHeightGroup() {
    String heightKey = "";
    if(getHeightInInches() < 41) {
      heightKey = "35-40 inches";
    } else
      if(getHeightInInches() > 46) {
        heightKey = "47-50 inches";
      } else
        heightKey = "41-46 inches";


    return heightKey;
  }
  
}
