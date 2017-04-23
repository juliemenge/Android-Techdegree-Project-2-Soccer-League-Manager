package com.teamtreehouse.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Collection;

public class League {
  private Map<String, Team> mTeams;
  
  public League() {
    mTeams = new TreeMap<>();
  }
  
  //return all the team names
  public Set<String> getTeams() {
    return mTeams.keySet();
  }
  
  //returns team if it exists
  public Team getTeam(String teamName) {
     return mTeams.get(teamName);
  }
  
  public void addTeam(Team team) {
    mTeams.put(team.getTeamName(), team);
  }
  
  //return experience levels for all teams in league...
  public void printTeamExperience() {
    Collection<Team> teams = mTeams.values();
    for(Team team: teams) {
      System.out.printf(team.getTeamName());
      System.out.printf("%nExperienced players: %s%n", team.getCountOfExperiencedPlayers());
      System.out.printf("Inexperienced players: %s%n%n", team.getCountOfInexperiencedPlayers());
    }
  }
}